/**
 * Created by Jorgen Andersson on 2018-07-25.
 */

var reducedSystems = {
    system1 : [
        [ 1, 1, 0, 1, 0, 0],
        [ 0, 1, 1, 0, 1, 0],
        [ 0, 0, 1, 1, 0, 1],
        [ 0, 1, 0, 0, 1, 1],
        [ 1, 0, 0, 1, 1, 0],
        [ 1, 0, 1, 0, 0, 1]],
    system2 : [
        [ 1, 1, 1, 1, 0, 0],
        [ 0, 0, 1, 1, 1, 1],
        [ 1, 1, 0, 0, 1, 1]],
    system3 : [
        [ 1, 1, 0, 1, 0],
        [ 0, 1, 1, 0, 1],
        [ 1, 0, 1, 0, 1],
        [ 0, 1, 0, 1, 1],
        [ 1, 0, 1, 1, 0]]
};


class ReducedHorseSystem {
    constructor(system, list) {

        this.system = system;
        this.list = list;

        // Which race do we only have one horse, filter out race indexes
        let singles = list
            .map((value, index) => {
                return {index: index, value: value}
            })
            .filter(race => race.value.length === 1)
            .map(item => item.index);

        // Insert single horse races (Spik)
        this.system.forEach((row, index) => {
            singles.forEach(item => {
                row.splice(item, 0, 0);
            });
        });

        this.table = [];

        // Build system
        this.table = this.system.map(row => {
            return row
                .map((value, index) => {
                    return value ? this.list[index] : this.list[index].slice(0, 1);
                });
        });
    }

    rowCount() {
        return this.table.length;
    }

    row(index) {
        return this.table[index];
    }

    totalCost() {
        return this.table
            .map(value => {
                return value.reduce((acc, itemValue) => acc * itemValue.length, 1);
            })
            .reduce((acc, value) => acc + value, 0);
    }
    rowCost(index) {
        return this.table[index].reduce((acc, value) => acc * value.length, 1);
    }
}

var prioList = [
    [ 4, 1, 2, 3, 5, 6, 7, 8, 9,10,11,14],
    [ 9, 1, 6, 7,10,12,15],
    [ 3, 4,10,11],
    [ 8, 1, 3, 5, 6, 7,14],
    [ 4, 1],
    [ 1],
    [ 9, 1]
];


console.warn("SECOND");
var second = new ReducedHorseSystem(reducedSystems.system2, prioList);
for (var i = 0; i < second.rowCount(); i++) {
    let row = second.row(i);
    console.log(row);
    console.log("Cost for " + i + ": " + second.rowCost(i));
}
console.log("TOTAL: " + second.totalCost());


