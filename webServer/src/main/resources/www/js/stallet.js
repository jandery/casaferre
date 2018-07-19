/**
 * Created by Jorgen Andersson on 2018-07-19.
 */


class Person {
    constructor(id, name, email, mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }
}

class Horse {
    constructor(id, name, owner, fellows) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.fellows = fellows;
    }
}


class AnimalContent {
    constructor() {
        this.horses = [];
    }

    addHorse(horse) {
        console.log("Adding " + horse.id);
        this.horses.push(horse);
    }

    removeHorse(horse) {
        console.log("Removing " + horse.id);
    }
}

class Box extends AnimalContent {
    constructor(id) {
        super();
        this.id = id;
    }


}

class Paddock extends AnimalContent {
    constructor(id, name) {
        super();
        this.id = id;
        this.name = name;
    }
}


class Stable {
    constructor(owner, boxes, paddocks, horses) {
        this.owner = owner;
        this.boxes = boxes;
        this.paddocks = paddocks;
        this.horses = horses;
    }
}

let PEOPLE = {
    CISSI: new Person("1", "Cissi", "?", "+46"),
    CURT: new Person("2", "Curt", "?", "+46"),
    LENA: new Person("3", "Lena", "", "+46"),
    MONA: new Person("4", "Mona", "?", ""),
    JORGEN: new Person("5", "Jörgen", "", "+46"),
    AMI: new Person("6", "Ami", "?", "+46"),
    ASE: new Person("7", "Åse", "?", "+46"),
    KAJSA: new Person("8", "Kajsa", "?", "+46")
};

let stable = new Stable(
    [PEOPLE.CISSI, PEOPLE.CURT],
    [new Box("B1"), new Box("B2"), new Box("B3"), new Box("B4"), new Box("B5")],
    [
        new Paddock("P1", "Sommarhage 1"),
        new Paddock("P2", "Sommarhage 2"),
        new Paddock("P3", "Vinterhage 1"),
        new Paddock("P4", "Vinterhage 2")],
    [
        new Horse("H1", "Bersi", PEOPLE.LENA, [PEOPLE.ASE, PEOPLE.KAJSA]),
        new Horse("H2", "Sleipnir", PEOPLE.MONA, [PEOPLE.AMI]),
        new Horse("H3", "Tyson", PEOPLE.CISSI, []),
        new Horse("H4", "Donatello", PEOPLE.CISSI, [])]
);

