/**
 * Created by Jorgen Andersson on 2018-02-16.
 */

Vue.component('int-example', {
    template: '<b-container>' +
    '<b-row class="text-center"><b-col cols="2">&nbsp;</b-col><b-col v-for="item in items">{{ base }}<sup>{{ item }}</sup></b-col><b-col cols="2">&nbsp;</b-col></b-row>' +
    '<b-row class="text-center"><b-col cols="2">&nbsp;</b-col><b-col v-for="item in items">{{ Math.pow(base, item) }}</b-col><b-col cols="2">&nbsp;</b-col></b-row>' +
    '</b-container>',
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