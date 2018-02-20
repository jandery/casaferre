/**
 * Created by Jorgen Andersson on 2018-02-16.
 */
Vue.component('int-example', {
    template: '<table class="border">' +
    '<tbody>' +
    '<tr><td v-for="item in items">{{ base }}<sup>{{ item }}</sup></td></tr>' +
    '<tr><td v-for="item in items">{{ Math.pow(base, item) }}</td></tr>' +
    '</tbody>' +
    '</table>',
    props: {
        value: {
            type: Number,
            default: 0
        }
    },
    data: function () {
        return {
            items: [ 7, 6, 5, 4, 3, 2, 1, 0],
            base: 2
        };
    },
    computed: {},
    methods: {}
});