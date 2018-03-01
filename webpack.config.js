
const path = require('path');

module.exports = {
    watch: true,
    entry: {
        index: './web/src/main/resources/source/js/index.js',
        home: './web/src/main/resources/source/js/home.ts',
        mid: './web/src/main/resources/source/js/mid.ts'
    },
    output: {
        path: path.resolve(__dirname, 'web/src/main/resources/site/js'),
        filename: '[name].js'
    },
    module: {
        rules: [
            /**
             * Looking for lang="ts" in vue files and
             * compiling them to JavaScript with ts-loader (an npm package)
             */
            {
                test: /\.ts$/,
                exclude: /node_modules|vue\/src/,
                loader: "ts-loader",
                options: {
                    appendTsSuffixTo: [/\.vue$/]
                }
            },
            /**
             * Looking for .vue endings and
             * compiling them to JavaScript with vue-loader (an npm package)
             */
            {
                test: /\.vue$/,
                loader: "vue-loader",
                options: {
                }
            }
        ]
    },
    /**
     * Which extensions that webpack should be looking for and which kind of vue to compile
     */
    resolve: {
        extensions: [".ts", ".js", ".vue", ".json"],
        alias: {
            "vue$": "vue/dist/vue.esm.js"
        }
    }
};