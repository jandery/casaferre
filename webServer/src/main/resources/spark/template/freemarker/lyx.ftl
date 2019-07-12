<#--noinspection HtmlRequiredTitleElement-->
<#-- @ftlvariable name="title" type="java.lang.String" -->
<#import "includes/basePage.ftl" as basePage />
<!DOCTYPE html>
<html lang="en">
<@basePage.lyxHeader />
<body>

<div class="w3-row">
    <div class="w3-quarter w3-container"></div>
    <div class="w3-half w3-container">

        <div class="w3-row">
            <h2 class="w3-center">Personer</h2>
            <ul class="w3-ul">
                <li class="w3-bar">
                    <div class="w3-bar-item">Jörgen</div>
                    <div class="w3-bar-item w3-right">1965</div>
                </li>
                <li class="w3-bar">
                    <div class="w3-bar-item">Lena</div>
                    <div class="w3-bar-item w3-right">1966</div>
                </li>
                <li class="w3-bar">
                    <div class="w3-bar-item">Maya</div>
                    <div class="w3-bar-item w3-right">2004</div>
                </li>
            </ul>
        </div>

    </div>
    <div class="w3-quarter w3-container"></div>
</div>

<div class="w3-row">
    <div class="w3-quarter w3-container"></div>
    <div class="w3-half w3-container">

        <div class="w3-row">
            <h2 class="w3-center">Fordon</h2>
            <ul class="w3-ul">
                <li class="w3-bar">
                    <div class="w3-bar-item">Saab</div>
                    <div class="w3-bar-item w3-right">UFM321</div>
                </li>
                <li class="w3-bar">
                    <div class="w3-bar-item">Renault</div>
                    <div class="w3-bar-item w3-right">DZD218</div>
                </li>
            </ul>
        </div>

    </div>
    <div class="w3-quarter w3-container"></div>
</div>

<div class="w3-row">
    <div class="w3-quarter w3-container"></div>
    <div class="w3-half w3-container">

        <div class="w3-row">
            <h2 class="w3-center">Boende</h2>
            <ul class="w3-ul">
                <li class="w3-bar">
                    <div class="w3-bar-item">Björnstorp</div>
                    <div class="w3-bar-item w3-right">Villa</div>
                </li>
            </ul>
        </div>

    </div>
    <div class="w3-quarter w3-container"></div>
</div>

<div class="w3-row">
    <div class="w3-quarter w3-container"></div>
    <div class="w3-half w3-container">

        <div class="w3-row">
            <h2 class="w3-center">Lån</h2>
            <ul class="w3-ul">
                <li class="w3-bar">
                    <div class="w3-bar-item">Bolån</div>
                    <div class="w3-bar-item w3-right">2 750 000</div>
                </li>
                <li class="w3-bar">
                    <div class="w3-bar-item">Billån</div>
                    <div class="w3-bar-item w3-right">70 000</div>
                </li>
                <li class="w3-bar">
                    <div class="w3-bar-item">CSN</div>
                    <div class="w3-bar-item w3-right">12 000</div>
                </li>
                <li class="w3-bar">
                    <div class="w3-bar-item">Blanko</div>
                    <div class="w3-bar-item w3-right">122 000</div>
                </li>
            </ul>
        </div>

    </div>
    <div class="w3-quarter w3-container"></div>
</div>

<div class="w3-row">
    <div class="w3-quarter w3-container"></div>
    <div class="w3-half w3-container">

        <div class="w3-container w3-green">
            <h2>Header</h2>
        </div>

        <form class="w3-container">


            <label>
                Belopp
                <input class="w3-input" type="tel" />
            </label>

        </form>

    </div>
    <div class="w3-quarter w3-container"></div>
</div>

<script>

    let data = [
        {"id": "p001", "type": "person", "name": "Jörgen", "birthYear": 1965},
        {"id": "p002", "type": "person", "name": "Lena", "birthYear": 1966},
        {"id": "p003", "type": "person", "name": "Maya", "birthYear": 2004},
        {"id": "b001", "type": "car", "name": "DZD218", "model": "Renault"},
        {"id": "b002", "type": "car", "name": "UFM321", "model": "Saab"},
        {"id": "l001", "type": "living", "name": "Huvudboende", "model": "villa"},
        {"id": "x001", "type": "loan", "name": "mortgage", "ref": "l001", "amount": 2810000},
        {"id": "x002", "type": "loan", "name": "car", "ref": "b001", "amount": 70000}
    ];
</script>
</body>
</html>
