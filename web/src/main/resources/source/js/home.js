"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var vue_1 = require("vue");
new vue_1.default({
    el: "#mainExampleComponents",
    template: "\n    <div>\n        <div>Hello {{name}}!</div>\n        Name: <input v-model=\"name\" type=\"text\">\n    </div>",
    data: {
        name: "World"
    },
    components: {}
});
//# sourceMappingURL=home.js.map