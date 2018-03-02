
import Vue from "vue";
import ExampleComponent from "./components/ExampleComponent.vue";

new Vue({
    el: "#vueApp",
    render: h => h(ExampleComponent)
});