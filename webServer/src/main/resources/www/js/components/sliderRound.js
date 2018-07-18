// global Vue 
/**
 * Component for a round slider
 * Created by Jorgen Andersson on 2018-07-05.
 */
var sliderMixin = {
    props: {
        // Image size in Px
        sizePx: { type: Number, default: 100 },
        // Function to call on touchMove, i.e. when user swipes finger
        move: { type: Function, default: (value) => {}},
        // Function to call on touchEnd, i.e. when use lifts finger
        done: { type: Function, default: (value) => {}}
    },
    data() {
        return {
            // Center point for image
            centerX: this.sizePx / 2,
            centerY: this.sizePx / 2,
            // finger touch point on start/press finger, number of degrees compared to center point
            startDegree: null,
            // finger touch point on end/lift finger, number of degrees compared to center point
            endDegree: null,
            // holder for showing current number of degrees on touchMove
            previousDegree: null,
            // number of rotations the finger has completed
            laps: 0,
            // rotation variable for image, degree
            rotate: 0
        }
    },
    /**
     * When component i mounted, find the x/y position (on document) for center of image
     * This must be in mounted coz this.$el is undefined in created()
     */
    mounted() {
        var elementTop = this.$el.getBoundingClientRect().top;
        var elementLeft = this.$el.getBoundingClientRect().left;
        this.centerX = elementLeft + (this.sizePx / 2);
        this.centerY = elementTop + (this.sizePx / 2);
    },
    methods: {
        /**
         * Event for touch start, finger down
         * @param event
         */
        touchStart(event) {
            this.laps = 0;
            this.endDegree = null;
            this.startDegree = this.getDegree(event.changedTouches[0]);
        },
        /**
         * Event for touch move, finger move
         * @param event
         */
        touchMove(event) {
            let currentDegree = this.getDegree(event.changedTouches[0]);
            let totalMoveDegree = this.currentValue(currentDegree, this.previousDegree);
            this.rotate = totalMoveDegree;
            this.move(totalMoveDegree);
            this.previousDegree = currentDegree;
        },
        /**
         * Event for touch end, finger lift
         * @param event
         */
        touchEnd(event) {
            this.endDegree = this.getDegree(event.changedTouches[0]);
            let totalMoveDegree = this.currentValue(this.endDegree);
            this.done(totalMoveDegree);
        },
        /**
         * Function for calculating current position of finger
         * @param point object, should contain keys clientX and clientY
         * @return {number} converted X and Y position to degree integer (>= 0 and <= 360)
         */
        getDegree(point) {
            let degree = Math.atan2(point.clientY - this.centerY, point.clientX - this.centerX) * 180 / Math.PI;
            return degree >= 0 ? degree : 360 + degree;
        },
        /**
         * Function for calculate how long a move has been
         * @param degree
         * @param previous
         * @return {number}
         */
        currentValue(degree, previous) {
            // If we have a previous, ie this is touch move or touch end
            if (previous) {
                if (previous > 350 && degree < 10) {
                    // Have completed a full clockwise lap
                    this.laps++;
                } else if (previous < 10 && degree > 350) {
                    // Have completed a full anti-clockwise lap
                    this.laps--;
                }
            }
            // Calculate how many degrees in total from touch start
            return (this.laps * 360) + (degree - this.startDegree);
        }
    }
};

/**
 * Image version of round slider. Loads an img tag which will rotate with the touch move
 * Example usage:
 * <casaferre-img-slider-round :size-px="100" image-path="../imgs/me.png"></casaferre-img-slider-round>
 * <casaferre-img-slider-round :size-px="150" image-path="../imgs/me.png" :move="onRotateImgMove" :done="onRotateImgDone"></casaferre-img-slider-round>
 */
Vue.component('casaferre-img-slider-round', {
    template: `<img 
:src="imagePath" 
@touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd" 
:style="{width: sizePx + 'px', height: sizePx + 'px', transform:'rotate(' + rotate + 'deg)'}" style="border-radius: 50%;" alt="Image">
</img>`,
    mixins: [sliderMixin],
    props: {
        // Path to image
        imagePath: { type: String, required: true }
    }
});

/**
 * Svg version of round slider. Loads a round svg image which will rotate with the touch move
 * Example usage:
 * <casaferre-svg-slider-round :size-px="100"></casaferre-svg-slider-round>
 * <casaferre-svg-slider-round :size-px="150" color="#cc0000" line-color="#eeeeee" inner-size="75" :move="onRotateSvgMove" :done="onRotateSvgDone"></casaferre-svg-slider-round>
 */
Vue.component('casaferre-svg-slider-round', {
    template: `<svg xmlns="http://www.w3.org/2000/svg" :width="sizePx" :height="sizePx" viewBox="0 0 200 200" :style="{transform:'rotate(' + rotate + 'deg)'}">
                <g @touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd">
                    <circle cx="100" cy="100" r="100" :style="{fill:color}"/>
                    <line x1="0" y1="100" x2="200" y2="100" :style="{stroke:lineColor}"/>
                    <line x1="100" y1="0" x2="100" y2="200" :style="{stroke:lineColor}"/>
                    <circle cx="100" cy="100" :r="innerSize" style="fill:#ffffff"/>
                </g>`,
    mixins: [sliderMixin],
    props: {
        // Color of the circle
        color: { type: String, default: '#00cc00'},
        // Two lines for user to see the rotation
        lineColor: { type: String, default: '#006600'},
        // Size in percent of the white inner space
        innerSize: { type: Number, default: 50}
    }
});