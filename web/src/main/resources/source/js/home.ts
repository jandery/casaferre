
import Vue from "vue";
import ExampleComponent from "./components/ExampleComponent.vue";

new Vue({
    el: "#vueApp",
    template: `
    <div>
        <div>Hello {{name}}!</div>
        Name: <input v-model="name" type="text"><br/>
        <example-component></example-component>
    </div>`,
    data: {
        name: "World"
    },
    components: {
        ExampleComponent
    }
});