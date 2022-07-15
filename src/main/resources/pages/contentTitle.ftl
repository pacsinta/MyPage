<#macro contentTitleBlock title title2 description image redirectLocation>

<!-- Blog entries -->
<div class="w3-col l8 s12">
    <!-- Blog entry -->
    <div class="w3-card-4 w3-margin w3-white">
        <#if image.name != "">
            <img src="${image.url}" alt=${image.name} style="width:100%">
        </#if>
        <div class="w3-container">
            <h3><b>${title}</b></h3>
            <h5>${title2}</h5>
        </div>

        <div class="w3-container">
            <p>${description}</p>
            <div class="w3-row">
                <div class="w3-col m8 s12">
                    <p><button onclick="window.location='tutorials/${redirectLocation}';" class="w3-button w3-padding-large w3-white w3-border"><b>READ MORE »</b></button></p>
                </div>
            </div>
        </div>
    </div>
    <!-- END BLOG ENTRIES -->
</div>

</#macro>