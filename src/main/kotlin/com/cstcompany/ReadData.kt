package com.cstcompany

import com.cstcompany.data.BlogPost
import com.cstcompany.data.Image
import io.github.classgraph.ClassGraph
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

// It reads the blog posts data from the resources folder
fun readData(path: String): List<BlogPost> {
    val posts = mutableListOf<BlogPost>()

    var resourceNames: List<URL?>
    ClassGraph()
        .acceptPaths("$path/tutorials")
        .scan().use { scanResult -> resourceNames = scanResult.allResources.urLs }

    resourceNames.forEach { resourceName ->
        if (resourceName != null) {
            if (resourceName.path.contains("description.txt")) {
                val stream = resourceName.openStream()
                val lines = BufferedReader(InputStreamReader(stream)).readLines()

                val parentFolder = resourceName.path.removeSuffix("/description.txt").replaceBefore("/pages/", "")

                if (lines[0] != "not ready") {
                    posts.add(
                        BlogPost(
                            title = lines[0],
                            title2 = lines[1],
                            contentLocation = "$parentFolder/index.html",
                            description = lines[2],
                            image = if (lines.size > 4) Image(
                                name = lines[4],
                                url = "$parentFolder/image1"
                            ) else Image(
                                "",
                                ""
                            ),
                            redirectLocation = lines[3]
                        )
                    )
                } else if (LOCALHOST_ONLY) {
                    posts.add(
                        BlogPost(
                            title = lines[1],
                            title2 = lines[2],
                            contentLocation = "$parentFolder/index.html",
                            description = lines[3],
                            image = if (lines.size > 5) Image(
                                name = lines[5],
                                url = "$parentFolder/image1"
                            ) else Image(
                                "",
                                ""
                            ),
                            redirectLocation = lines[4]
                        )
                    )
                }
            }
        }
    }

    return posts.reversed()
}