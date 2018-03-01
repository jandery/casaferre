
import Vue from "vue";

new Vue({
    el: "#mainExampleComponents",
    template: `
    <div>
        <div>Hello {{name}}!</div>
        Name: <input v-model="name" type="text">
    </div>`,
    data: {
        name: "World"
    },
    components: {
    }
});