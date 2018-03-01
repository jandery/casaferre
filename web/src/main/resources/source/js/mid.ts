
export class Person {
    fName: string;
    lName: string;
    constructor(firstName: string, lastName: string) {
        this.fName = firstName;
        this.lName = lastName;
    }

    get fullName() {
        return "${this.fName} ${this.lName}";
    }
}