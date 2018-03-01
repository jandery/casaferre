<template>
    <div>
        <div class="red">Data: {{mydata}}</div>
        <div class="blue">Prop: {{myprop}}</div>
    </div>
</template>

<script>
    export default {
        name: "vue-example",

        data() {
            return {
                mydata: "This is data",
                mydataval: 0
            }
        },

        prop() {
            myprop: String
        },

        created() {
            this.mydataval = 1;
        }
    }
</script>

<style scoped>

    .red { color: Red; }
    .blue { color: Blue; }

</style>