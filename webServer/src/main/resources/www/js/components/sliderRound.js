/**
 * Created by Jorgen Andersson on 2018-07-05.
 */
Vue.component('casaferre-slider-round', {
    template: `<img 
:src="imagePath" 
@touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd" 
:style="{width: sizePx + 'px', height: sizePx + 'px', transform:'rotate(' + rotate + 'deg)'}" style="border-radius: 50%;" alt="Image">
</img>`,
    props: {
        sizePx: { type: Number, default: 100 },
        imagePath: { type: String, required: true },
        move: { type: Function, default: (value) => {}},
        done: { type: Function, default: (value) => {}}
    },
    data() {
        return {
            centerX: this.sizePx / 2,
            centerY: this.sizePx / 2,
            startDegree: null,
            endDegree: null,
            previousDegree: null,
            laps: 0,
            rotate: 0
        }
    },
    created() {
    },
    mounted() {
        var elementTop = this.$el.getBoundingClientRect().top;
        var elementLeft = this.$el.getBoundingClientRect().left;
        this.centerX = elementLeft + (this.sizePx / 2);
        this.centerY = elementTop + (this.sizePx / 2);
    },
    methods: {
        touchStart(event) {
            this.laps = 0;
            this.endDegree = null;
            this.startDegree = this.getDegree(event.touches[0].clientX, event.touches[0].clientY);
        },
        touchMove(event) {
            let currentDegree = this.getDegree(event.changedTouches[0].clientX, event.changedTouches[0].clientY);
            let totalMoveDegree = this.currentValue(currentDegree, this.previousDegree);
            this.rotate = totalMoveDegree;
            this.move(totalMoveDegree);
            this.previousDegree = currentDegree;
        },
        touchEnd(event) {
            this.endDegree = this.getDegree(event.changedTouches[0].clientX, event.changedTouches[0].clientY);
            let totalMoveDegree = this.currentValue(this.endDegree);
            this.done(totalMoveDegree);
        },
        getDegree(pointX, pointY) {
            let degree = Math.atan2(pointY - this.centerY, pointX - this.centerX) * 180 / Math.PI;
            return degree >= 0 ? degree : 360 + degree;
        },
        currentValue(degree, previous) {
            if (previous) {
                if (previous > 350 && degree < 10) {
                    this.laps++;
                } else if(previous < 10 && degree > 350) {
                    this.laps--;
                }
            }

            return (this.laps * 360) + (degree - this.startDegree);
        }
    }
});