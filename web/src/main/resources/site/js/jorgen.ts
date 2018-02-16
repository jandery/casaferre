
class Cell {
    private base : number = 2;
    private _value : number;

    constructor(private index : number) {
        this._value = Math.pow(this.base, this.index);
    }

    get exponentCell() : Node {
        let element = document.createElement('td');
        element.innerHTML = `${this.base}<sup>${this.index}</sup>`;
        return element;
    }

    get valueCell() : Node {
        let element = document.createElement('td');
        element.innerHTML = `${this._value}`;
        return element;
    }
}

class Cells {
    private cells = [];
    private tableElement = document.getElementById("example");
    private tableBody = this.tableElement.getElementsByTagName("tbody")[0];
    private tableRows = this.tableBody.getElementsByTagName("tr");
    //

    constructor() {
        var list = [];
        for (var i = 0; i < 15; i++) {
            list.push(new Cell(i));
        }
        this.cells = list.reverse();
    }


    initTable() {
        this.cells.forEach((cell, index) => {
            this.tableRows.item(0).appendChild(cell.exponentCell);
            this.tableRows.item(1).appendChild(cell.valueCell);
        });
    }
}

