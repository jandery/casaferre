<#assign cssPath="css/" />
<#assign jsLibPath="jslib/" />

<#macro htmlHeader title baseHref>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>${title}</title>
        <base href="${baseHref}"/>
        <#nested />
    </head>
</#macro>

<#macro casaFerreHeader title baseHref>
    <@htmlHeader title=title baseHref=baseHref>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=KoHo">
        <link rel="stylesheet" href="${cssPath}bootstrap.css">
        <script type="text/javascript" src="${jsLibPath}jquery-3.3.1.js"></script>
        <script type="text/javascript" src="${jsLibPath}bootstrap.js"></script>
    </@htmlHeader>
</#macro>

<#macro lyxHeader>
    <@htmlHeader title="Jörgen Test Lyxfällan" baseHref="/">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=KoHo">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script type="text/javascript" src="${jsLibPath}jquery-3.3.1.js"></script>
        <style>
            html {
                font-family: "Koho", "Arial", sans-serif;
                font-weight: 500;
            }

            body {
                width: 100%;
                margin: auto;
            }

        </style>
    </@htmlHeader>
</#macro>
