"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var vue_1 = require("vue");
var ExampleComponent_vue_1 = require("./components/ExampleComponent.vue");
new vue_1.default({
    el: "#vueApp",
    template: "\n    <div>\n        <div>Hello {{name}}!</div>\n        Name: <input v-model=\"name\" type=\"text\"><br/>\n        <example-component></example-component>\n    </div>",
    data: {
        name: "World"
    },
    components: {
        ExampleComponent: ExampleComponent_vue_1.default
    }
});
//# sourceMappingURL=home.js.map