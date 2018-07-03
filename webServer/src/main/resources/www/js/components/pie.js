/**
 * Single value pie-chart
 */
Vue.component('casaferre-simple-pie', {
    template: '<svg viewBox="0 0 32 32" v-bind:style="{width: sizePx + \'px\', height: sizePx + \'px\'}" style="transform: rotate(-90deg); border-radius: 50%;">' +
    '<circle r="16" cx="16" cy="16" v-bind:fill="backgroundColor" v-bind:stroke="strokeColor" style="stroke-width: 32;" v-bind:stroke-dasharray="strokeDashArray" />' +
    '</svg>',
    props: {
        /**
         * Width and Hight of image in px
         */
        sizePx: { type: Number, default: 100 },
        /**
         * Integer value in percent
         */
        value: { type: Number, required: true },
        /*
         * Background color, for pie
         */
        backgroundColor: { type: String, default: '#ddd' },
        /*
         * Color for the value part of pie
         */
        strokeColor: { type: String, default: '#888' }
    },
    computed: {
        strokeDashArray: function() { return this.value + " 100"; }
    }
});


/**
 * Multiple value pie-chart
 */
Vue.component('casaferre-pie', {
    template: '<svg v-bind:style="{width: sizePx + \'px\', height: sizePx + \'px\'}" viewBox="-1 -1 2 2" style="transform: rotate(-0.25turn)">' +
    '<path v-for="(item, index) in values" v-bind:d="d[index]" v-bind:fill="colors[index]"/>' +
    '</svg>',
    props: {
        sizePx: { type: Number, default: 100 },
        /**
         * Array of Number
         * Ex: [10, 20, 30, 40]
         */
        values: { type: Array, required: true },
        /**
         * If total is not the sum of all values
         * but pie should only cover fx. 90 %
         */
        totalSum: Number,
        /**
         * Array of String representing HTML colors
         * Ex: ['#aaa', '#888', #555', '#222']
         */
        colors: { type: Array, required: true }
    },
    computed: {
        /**
         * Calculate the sum of all values.
         * Return the higher value of inparam total and the sum
         */
        sum: function() {
            if (this.totalSum) {
                return this.totalSum;
            }
            return this.values.reduce(function(a,b){ return a+b; }, 0);
        },
        /**
         * Calculate list of Pie pieces
         */
        d: function() {
            let accumulatedPercent = 0;
            let total = this.sum;

            // Function to calculate a coordinate point on graph to draw an arc to
            const getCoordinates = function(percent) {
                let x = Math.cos(2 * Math.PI * percent);
                let y = Math.sin(2 * Math.PI * percent);
                return x + " " + y;
            };

            return $.map(this.values, function(value) {
                let start = getCoordinates(accumulatedPercent);
                accumulatedPercent += value / total;
                let end = getCoordinates(accumulatedPercent);
                let largeArcFlag = value / total > .5 ? 1 : 0;
                return "M " + start + " A 1 1 0 " + largeArcFlag + " 1 " + end + " L 0 0";
            });
        }
    }
});
