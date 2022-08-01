<#import "contentTitle.ftl" as contentTitle/>

<!DOCTYPE html>
<html>
<head>
    <title>IT is FUN</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}

        .fa {
            padding: 20px;
            font-size: 30px;
            width: 30px;
            text-align: center;
            text-decoration: none;
            border-radius: 50%;
        }
    </style>
</head>
<body class="w3-light-grey">

<!-- w3-content defines a container for fixed size centered content,
and is wrapped around the whole page content, except for the footer in this example -->
<div class="w3-content" style="max-width:1400px">

    <!-- Header -->
    <header class="w3-container w3-center w3-padding-32">
        <h1><b>It is Fun </b></h1>
        <p>Learn everything about <span class="w3-tag">programming</span></p>
    </header>

    <!-- Grid -->
    <div class="w3-row">

        <#list posts as post>
            <@contentTitle.contentTitleBlock title=post.title title2=post.title2 description=post.description image=post.image redirectLocation=post.redirectLocation/>
        </#list>

        <!-- Introduction menu -->
        <div class="w3-col l4">
            <!-- About Card -->
            <div class="w3-card w3-margin w3-margin-top">
                <img src="/tutorial-images/profile.jpg" style="width:100%">
                <div class="w3-container w3-white">
                    <h4><b>Patrik Csikós</b></h4>
                    <p>
                        Hi! I am a software engineer student in Budapest. Please feel free to contact me if you have any questions. My email is pacsinta@gmail.com.
                    </p>
                </div>
            </div><hr>

            <!-- Posts -->
            <#--<div class="w3-card w3-margin">
                <div class="w3-container w3-padding">
                    <h4>Popular Posts</h4>
                </div>
                <ul class="w3-ul w3-hoverable w3-white">
                    <li class="w3-padding-16">
                        <img src="/w3images/workshop.jpg" alt="Image" class="w3-left w3-margin-right" style="width:50px">
                        <span class="w3-large">Lorem</span><br>
                        <span>Sed mattis nunc</span>
                    </li>
                </ul>
            </div>
            <hr>-->

            <!-- Labels / tags -->
            <#--<div class="w3-card w3-margin">
                <div class="w3-container w3-padding">
                    <h4>Tags</h4>
                </div>
                <div class="w3-container w3-white">
                    <p><span class="w3-tag w3-black w3-margin-bottom">Travel</span> <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">New York</span> <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">London</span>
                        <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">IKEA</span> <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">NORWAY</span> <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">DIY</span>
                        <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Ideas</span> <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Baby</span> <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Family</span>
                        <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">News</span> <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Clothing</span> <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Shopping</span>
                        <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Sports</span> <span class="w3-tag w3-light-grey w3-small w3-margin-bottom">Games</span>
                    </p>
                </div>
            </div>
            -->
            <!-- END Introduction Menu -->
        </div>

        <!-- END GRID -->
    </div><br>

    <!-- END w3-content -->
</div>

<!-- Footer -->
<footer class="w3-container w3-dark-grey w3-padding-32 w3-margin-top w3-center">
    <a href="https://www.facebook.com/patrik.csikos.92/" class="fa fa-facebook"></a>
    <a href="https://www.youtube.com/channel/UC3i9tEauejbNpqI2OORNk2g" class="fa fa-youtube"></a>
    <a href="https://www.instagram.com/the_patrik_company/" class="fa fa-instagram"></a>
    <a href="https://github.com/pacsinta/" class="fa fa-github"></a>
</footer>

</body>
</html>
