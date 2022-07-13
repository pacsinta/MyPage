<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inconsolata">
    <style>
        body, html {
            height: 100%;
            font-family: "Inconsolata", sans-serif;
        }

        <#if image.name != "">
        .bgimg {
            background-position: center;
            background-size: cover;
            background-image: url("/w3images/coffeehouse.jpg");
            min-height: 75%;
        }
        </#if>

        .menu {
            display: none;
        }
    </style>
</head>
<body>

<#-- Links (sit on top) -->
<div class="w3-top">
    <div class="w3-row w3-padding w3-black">
        <div class="w3-col s3">
            <a href="/" class="w3-button w3-block w3-black">HOME</a>
        </div>
        <div class="w3-col s3">
            <a href="#about" class="w3-button w3-block w3-black">NEXT TUTORIAL</a>
        </div>
        <div class="w3-col s3">
            <a href="#menu" class="w3-button w3-block w3-black">PREVIOUS TUTORIAL</a>
        </div>
    </div>
</div>

<#-- Header with image -->
<header class="bgimg w3-display-container w3-grayscale-min" id="home">
    <div class="w3-display-bottomleft w3-center w3-padding-large w3-hide-small">
        <span class="w3-tag">Open from 6am to 5pm</span>
    </div>
    <div class="w3-display-middle w3-center">
        <span class="w3-text-white" style="font-size:90px">the<br>Cafe</span>
    </div>
    <div class="w3-display-bottomright w3-center w3-padding-large">
        <span class="w3-text-white">15 Adr street, 5015</span>
    </div>
</header>

<#-- Add a background color and large text to the whole page -->
<div class="w3-sand w3-grayscale w3-large">

    ${content}

    <#-- TODO FeedBack -->
    <div class="w3-container" id="where" style="padding-bottom:32px;">
        <div class="w3-content" style="max-width:700px">
            <h5 class="w3-center w3-padding-48"><span class="w3-tag w3-wide">SEND ME A FEEDBACK</span></h5>
            <p>If you find a misspelling or a bug please leave me a note.</p>
            <form action="${url}" target="_self" method="get">
                <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Name" required name="Name"></p>
                <p><input class="w3-input w3-padding-16 w3-border" type="text" placeholder="Message \ Special requirements" required name="Message"></p>
                <p><button class="w3-button w3-black" type="submit">SEND MESSAGE</button></p>
            </form>
        </div>
    </div>

    <#-- End page content -->
</div>

<#-- Footer -->
<footer class="w3-center w3-light-grey w3-padding-48 w3-large">
    <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a></p>
</footer>

</body>
</html>
