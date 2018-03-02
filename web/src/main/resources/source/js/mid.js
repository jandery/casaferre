"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Person = (function () {
    function Person(firstName, lastName) {
        this.fName = firstName;
        this.lName = lastName;
    }
    Object.defineProperty(Person.prototype, "fullName", {
        get: function () {
            return "${this.fName} ${this.lName}";
        },
        enumerable: true,
        configurable: true
    });
    return Person;
}());
exports.Person = Person;
//# sourceMappingURL=mid.js.map