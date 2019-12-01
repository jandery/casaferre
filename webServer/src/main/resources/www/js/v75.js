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
    [10, 7, 6,11, 3],
    [ 6, 9,12, 1, 7, 8,11],
    [ 2],
    [ 1,12,11, 2, 3],
    [ 9, 7],
    [ 8, 6],
    [ 4]
];

/*
console.warn("SECOND");
var second = new ReducedHorseSystem(reducedSystems.system2, prioList);
for (var i = 0; i < second.rowCount(); i++) {
    let row = second.row(i);
    console.log(row);
    console.log("Cost for " + i + ": " + second.rowCost(i));
}
console.log("TOTAL: " + second.totalCost());
*/

const myfn = (list) => {
    let resp = list
        .map((item, index) => {
            return {
                index: index,
                a: item[0],
                b: item.slice(1)
            }
        })
        .sort((first, second) => {
            return second.b.length - first.b.length;
        });

    console.log(resp);
};

myfn(prioList);