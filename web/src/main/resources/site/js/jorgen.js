var Cell = /** @class */ (function () {
    function Cell(index) {
        this.index = index;
        this.base = 2;
        this._value = Math.pow(this.base, this.index);
    }
    Object.defineProperty(Cell.prototype, "exponentCell", {
        get: function () {
            var element = document.createElement('td');
            element.innerHTML = this.base + "<sup>" + this.index + "</sup>";
            return element;
        },
        enumerable: true,
        configurable: true
    });
    Object.defineProperty(Cell.prototype, "valueCell", {
        get: function () {
            var element = document.createElement('td');
            element.innerHTML = "" + this._value;
            return element;
        },
        enumerable: true,
        configurable: true
    });
    return Cell;
}());
var Cells = /** @class */ (function () {
    //
    function Cells() {
        this.cells = [];
        this.tableElement = document.getElementById("example");
        this.tableBody = this.tableElement.getElementsByTagName("tbody")[0];
        this.tableRows = this.tableBody.getElementsByTagName("tr");
        var list = [];
        for (var i = 0; i < 15; i++) {
            list.push(new Cell(i));
        }
        this.cells = list.reverse();
    }
    Cells.prototype.initTable = function () {
        var _this = this;
        this.cells.forEach(function (cell, index) {
            _this.tableRows.item(0).appendChild(cell.exponentCell);
            _this.tableRows.item(1).appendChild(cell.valueCell);
        });
    };
    return Cells;
}());
