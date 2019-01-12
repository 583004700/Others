var Scripts = {
    id: 0,
    filed: "",
    dataSourceKey: "",
    /**
     * 弹出脚本编辑框
     **/
    alertShowScript: function () {
        $('#dlg').dialog('open').dialog('center').dialog('setTitle', '编辑脚本');
        $('#fm').form('clear');
    },
    /**
     * 新增脚本
     */
    addScripts: function () {
        $('#fm').form('submit', {
            url: "/scripts/addScripts",
            onSubmit: function () {
                return $(this).form('validate');
            },
            success: function (result) {
                $('#dlg').dialog('close');		// close the dialog
                $('#dg').datagrid('reload');	// reload the user data
            }
        });
    },
    /**
     **展示sql
     */
    showSql: function (sqlStr) {
        $('#dlgShowSql').dialog('open').dialog('center').dialog('setTitle', '编辑字段内容');
        $("#sqlContext").textbox('setValue', sqlStr);
    },
    updateScripts: function () {
        var val = $("#sqlContext").textbox("getValue");
        var paramData = {id: Scripts.id};
        var kv = {"TITLE":"title","CONTEXT":"context","NOTE":"note"};

        var key = kv[Scripts.filed];

        paramData[key] = val;
        $.ajax({
            url: "/scripts/update",
            data: paramData,
            success: function () {
                $('#dlgShowSql').dialog('close');		// close the dialog
                $('#dg').datagrid('reload');	// reload the user data
            }
        });
    },
    search: function () {
        $('#dg').datagrid('load', $("#searchform").serializeObject());
    },
    showResult: function(){
        var sqlText = $("#sqlContext").textbox('getValue');
        var dataSourceKey = Scripts.dataSourceKey;
        if(!sqlText || !dataSourceKey || sqlText == 'null' || dataSourceKey == 'null'){
            alert("执行失败，参数有误");
            return false;
        }
        $("#show_result").dialog('open').dialog('center').dialog('setTitle', '脚本执行结果');
        var showResultIframeW = $("#show_result_iframe")[0].contentWindow;
        showResultIframeW.excuteSql(sqlText,dataSourceKey);
    }
};

$(function () {
    $('#dg').datagrid({
        onDblClickRow: function (rowIndex, rowData) {

        },
        onDblClickCell: function(index,field,value){
            var rows = $('#dg').datagrid('getRows');
            var rowData = rows[index];
            if ((rowData.USER_ID == user.id) && (field == 'CONTEXT' || field == 'TITLE' || field == 'NOTE')) {
                $("#saveSqlButton").show();
            } else {
                $("#saveSqlButton").hide();
            }
            if(field == 'CONTEXT'){
                $("#excuteSqlButton").show();
            }else{
                $("#excuteSqlButton").hide();
            }
            Scripts.id = rowData.ID;
            Scripts.filed = field;
            if(field == 'CONTEXT'){
                Scripts.sqlText = value;
                Scripts.dataSourceKey = rowData.DATASOURCE_KEY;
            }

            Scripts.showSql(value);
        }
    });
});