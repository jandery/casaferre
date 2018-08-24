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
    [ 3, 6],
    [ 2],
    [10, 2],
    [12, 1, 9,10,11],
    [ 5],
    [ 7, 3, 4, 5, 6],
    [ 7,14,15]

];

var tada = new ReducedHorseSystem(reducedSystems.system1, prioList);
for (var i = 0; i < tada.rowCount(); i++) {
    let row = tada.row(i);
    console.log("Cost for " + i + ": " + tada.rowCost(i));
    console.log(row);
}
console.log("TOTAL");
console.log(tada.totalCost());