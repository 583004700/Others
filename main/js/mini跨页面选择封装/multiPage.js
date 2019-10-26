/**
 * miniui跨页面选择，在miui后面引入
 * @param uuid
 */
mini.DataGrid.prototype.getMultiPpageSelectedStart = function(uuid){
    this.uuid = uuid;
    var _this = this;
    this.cacheMap = {};
    this._events.select = this._events.select || [];
    this._events.select.unshift([function(e){
        var selected = e.record;
        var autorowno = selected[_this.uuid];
        _this.cacheMap[autorowno] = selected;
    }]);
    this._events.deselect = this._events.deselect || [];
    this._events.deselect.unshift([function(e){
        var selected = e.record;
        var autorowno = selected[_this.uuid];
        delete _this.cacheMap[autorowno];
    }]);
    var oldUpdateRow = this.updateRow;
    this.updateRow = function(t, e, i){
        oldUpdateRow.call(_this,t,e,i);
        if (t = _this._getRow(t), t && e){
            if(_this.cacheMap[t[_this.uuid]]){
                _this.cacheMap[t[_this.uuid]] = t;
            }
        }
    };

    this._events.load = this._events.load || [];
    this._events.load.unshift([function(e){
        var data = e.data;
        for(var i=0;i<data.length;i++){
            var row = data[i];
            var autorowno = row[_this.uuid];
            if(_this.cacheMap[autorowno]){
                _this.select(row, false);
                _this.cacheMap[autorowno] = row;
            }
        }
    }]);
};

mini.DataGrid.prototype.getMultiPpageSelected = function(){
    var d = [];
    for(var o in this.cacheMap){
        d.push(this.cacheMap[o]);
    }
    return d;
};


// var grid = mini.get("datagrid");        //表格ID
// grid.getMultiPpageSelectedStart("JHBH");    //设置表格的主键列
// grid.getMultiPpageSelected();       //获取选中的数据