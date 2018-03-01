
const path = require('path');

module.exports = {
    watch: true,
    entry: {
        index: './web/src/main/resources/source/js/index.js',
        home: './web/src/main/resources/source/js/home.js'
    },
    output: {
        path: path.resolve(__dirname, 'web/src/main/resources/site/js'),
        filename: '[name].js'
    }
};