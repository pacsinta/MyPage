<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Szeretlek ha kell 100szor is</title>
    <style>
        * {box-sizing: border-box;}
        body {font-family: Verdana, sans-serif;}
        .mySlides {display: none;}
        img {vertical-align: middle;}

        /* Slideshow container */
        .slideshow-container {
            max-width: 1000px;
            position: relative;
            margin: auto;
        }

        /* Caption text */
        .text {
            color: #f2f2f2;
            font-size: 15px;
            padding: 8px 12px;
            position: absolute;
            bottom: 8px;
            width: 100%;
            text-align: center;
        }

        /* Number text (1/3 etc) */
        .numbertext {
            color: #f2f2f2;
            font-size: 12px;
            padding: 8px 12px;
            position: absolute;
            top: 0;
        }

        /* The dots/bullets/indicators */
        .dot {
            height: 15px;
            width: 15px;
            margin: 0 2px;
            background-color: #bbb;
            border-radius: 50%;
            display: inline-block;
            transition: background-color 0.6s ease;
        }

        .active {
            background-color: #717171;
        }

        /* Fading animation */
        .fade {
            animation-name: fade;
            animation-duration: 1.5s;
        }

        h1{
            text-align: center;
        }

        img{
            width: 80%;
            height: auto;
        }
        @keyframes fade {
            from {opacity: .4}
            to {opacity: 1}
        }

        /* On smaller screens, decrease text size */
        @media only screen and (max-width: 300px) {
            .text {font-size: 11px}
        }
    </style>
</head>
<body>

<h1>Ha kételkednél nézd meg h nincs miért!</h1>
<p>
    Ha hiányzol, ennyi és ehhez hasonló képek jönnek a segítségemre, hogy rájöjjek mennyire csodálatos vagy.
</p>
<p>Tudom te másképp vagy vele de én az összes képen szeretlek! <3 <3 <3 </p>

<audio controls autoplay>
    <source src="song.mp3" type="audio/mpeg">
</audio>

<div class="slideshow-container">
    <button onclick="showSlides()">Start</button>

    <#list posts as post>
        <div class="mySlides fade">
            <img src=${post}>
        </div>
    </#list>
</div>
<br>

<script>
    let slideIndex = 0;

    function showSlides() {
        let i;
        let slides = document.getElementsByClassName("mySlides");
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        slideIndex++;
        if (slideIndex > slides.length) {slideIndex = 1}
        slides[slideIndex-1].style.display = "block";
        setTimeout(showSlides, 3000); // Change image every 2 seconds
    }
</script>

</body>
</html>
