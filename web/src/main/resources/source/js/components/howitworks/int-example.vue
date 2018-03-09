<template>

    <div class="container">
        <table>
            <tbody>
            <tr>
                <td colspan="12">{{ value }}</td>
            </tr>
            <tr>
                <td colspan="2">&nbsp;</td>
                <td v-for="item in items" :key="item">{{ value & Math.pow(base, item) ? 1 : 0 }}</td>
                <td colspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2">&nbsp;</td>
                <td v-for="item in items" :key="item">{{ base }}<sup>{{ item }}</sup></td>
                <td colspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2">&nbsp;</td>
                <td v-for="item in items" :key="item">{{ Math.pow(base, item) }}</td>
                <td colspan="2">&nbsp;</td>
            </tr>
            <tr>
                <td colspan="2">&nbsp;</td>
                <td v-for="item in items" :key="item">{{ value & Math.pow(base, item) }}</td>
                <td colspan="2">&nbsp;</td>
            </tr>
            </tbody>
        </table>
    </div>

</template>

<script>
    export default {
        name: "int-example",
        props: {
            value: Number
        },
        data: function () {
            return {
                items: [7, 6, 5, 4, 3, 2, 1, 0],
                base: 2
            };
        }
    }
</script>

<style scoped>

</style>