
function parseMe() {
    $.ajax({
        url: '/js/components/vue-example.js'
    }).done(function(response) {
        // Insert response string into DivElement
        var element = document.createElement("div");
        element.innerHTML = response;
        // Extract DOM elements
        var templateElements = element.getElementsByTagName("template");
        var scriptElements = element.getElementsByTagName("script");
        var styleElements = element.getElementsByTagName("style");

        // Create Vue component stuff
        var component = {};
        // The template
        component["template"] = templateElements[0];
        // JavaScript, remove the export default part and use the stuff between { and }

    });
}