/**
 * Purpose of this file is ...
 *
 * Created by Jorgen Andersson on 2018-07-09.
 */


function JsAssert(a) {
    this.isEqualTo = function(b) {
        return a === b;
    };
    this.isLessThan = function(b) {
        return a < b;
    };
    this.isGreaterThan = function(b) {
        return a > b;
    };
    this.isBetween = function(b, c) {
        return b < a && c > a;
    };
}

function assertThat(a) {
    return new JsAssert(a);
}

function test(name, f) {
    f();
}
function describe(name, f) {
    f();
}


// Source File

var HelloWorld = function() {
    this.greeting = function() {
        return "Hello, World";
    };
    this.getValue = function() {
        return 7;
    };
};


// Test File

describe('HelloWorld',() => {

    test('should say hello',() => {
        var helloWorld = new HelloWorld();
        assertThat(helloWorld.greeting()).isEqualTo("Hello, World");
    });

    test('should be 7',() => {
        var helloWorld = new HelloWorld();
        assertThat(helloWorld.getValue()).isEqualTo(7);
    });

    test('should be between 6 and 8',() => {
        var helloWorld = new HelloWorld();
        assertThat(helloWorld.getValue()).isBetween(6, 8);
    });

    test('should not be "7"',() => {
        var helloWorld = new HelloWorld();
        assertThat(helloWorld.getValue()).isEqualTo("7");
    });
});