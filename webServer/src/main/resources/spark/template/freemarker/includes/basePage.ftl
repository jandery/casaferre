<#macro htmlHeader title baseHref>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${title}</title>
        <base href="${baseHref}"/>
        <#nested />
    </head>
</#macro>


<#macro casaFerreHeader title baseHref>
    <@htmlHeader title=title baseHref=baseHref>
        <link href="https://fonts.googleapis.com/css?family=KoHo" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="jslib/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="jslib/bootstrap.js"></script>
    </@htmlHeader>
</#macro>