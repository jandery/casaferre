<!DOCTYPE html>
<#import "includes/basePage.ftl" as basePage />
<html lang="sv" xml:lang="sv" xmlns="http://www.w3.org/1999/xhtml">
<@basePage.casaFerreHeader "CasaFerre", "/" />
<body>
<header class="page-header text-center">
    <h2>CasaFerre Informatik<br/>
        <small>Konsulttjänster inom</small>
    </h2>
</header>
<#include "casaferre/tada.ftl" />

<script>
    $('.carousel').carousel({
        interval: 2000
    });
</script>
</body>
</html>