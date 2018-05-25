/**
 * Purpose of this file is ...
 *
 * Created by Jorgen Andersson on 2018-05-24.
 */


Vue.component('pie-chart', {
    template: '<svg xmlns="http://www.w3.org/2000/svg" viewBox="-1 -1 2 2" style="transform: rotate(-0.25turn)">' +
    '<path v-for="(item, index) in values" v-bind:d="d[index]" v-bind:fill="colors[index] />' +
    '</svg>',
    props: {
        values: Array
    },
    data: function () {
        return {
            colors["#ff0000", "#00ff00", "#0000ff", "#ffff00", "#ff00ff", "#00ffff", "#f00000", "#00f0000", "#0000f0", "#f0f000", "#f000f0", "#00f0f0"]
        };
    },
    computed: {
        /**
         * Calculate sum of values
         * @return {*}
         */
        sum: function() {
            return this.values.reduce(function(total, currentValue) {return total + currentValue;});
        },
        d: function() {
            var vueData = this.$data;
            var accumulatedPercent = 0;
            var arrayOfPaths = [];
            var total = this.sum;
            // Center of graph
            var centerPoint = "L 0 0";

            // Function to calculate a coordinate point on graph to draw an arc to
            var getCoordinates = function(percent) {
                var x = Math.cos(2 * Math.PI * percent);
                var y = Math.sin(2 * Math.PI * percent);
                return x + " " + y;
            }

            $.each(this.values, function(index, value) {
                var start = getCoordinates(accumulatedPercent);
                accumulatedPercent += value / total;
                var end = getCoordinates(accumulatedPercent);
                var largeArcFlag = value / total > .5 ? 1 : 0;
                arrayOfPaths.push("M " + start + " A 1 1 0 " + largeArcFlag + " 1 " + end + " " + centerPoint);
            });

            return arrayOfPaths;
        }
    },
    methods: {}
});
