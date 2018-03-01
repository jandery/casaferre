<template>
    <div>
        <input v-model="msg">
        <h1>{{ computedMsg }}</h1>
    </div>
</template>

<script lang="ts">
    import Vue from "vue";
    import Component from "vue-class-component";

    @Component
    export default class ExampleComponent extends Vue {
        /**
         * Property of this vue-component
         * @type {string}
         */
        msg: string = "A message";

        /**
         * Function that will run when component is mounted
         */
        mounted(){
            console.warn("This component is moounted!");
        }

        /**
         * A computed message that returns a string
         * @returns {string}
         */
        get computedMsg(): string {
            return this.msg + " : This is the second vue-component, written in TypeScript!";
        }
    }
</script>

<style scoped>
    h1 {
        color: #ff4dab;
        padding: 30px;
        border: 3px solid #c33fff;
        width: max-content;
        background-color: #24242e;
        margin: auto;
    }
</style>