function excuteSql(sqlText,dataSourceKey) {
    loadData(1,6);
    /**
     * 加载表格数据
     * @param page 当前页码
     * @param rows  每页显示的条数
     */
    function loadData(page,rows){
        if(!page){
            page = 1;
        }
        if(!rows){
            rows = 6;
        }
        $.ajax({
            url: "/dynamicQuery/queryList",
            type: "post",
            data: {sqlText:sqlText,dataSourceKey:dataSourceKey,page:page,rows:rows},
            success: function(data){
                var cols = [];
                if(data.rows && data.rows.length > 0){
                    var o = data.rows[0];
                    for(var f in o){
                        var col = {field:"",title:"",width:80};
                        col.field = f;
                        col.title = f;
                        cols.push(col);
                    }
                }

                $('#dg').datagrid({
                    columns:[cols]
                });
                $('#dg').datagrid('loadData',data);
                $('#pp').pagination({
                    total:data.total,
                    pageSize:6,
                    onSelectPage: function(pageNumber, pageSize){
                        loadData(pageNumber,pageSize);
                    },
                    pageList: [6,12,50,100]
                });
            },
            error:function(){
                $('#dg').datagrid('loadData',{total:0,rows:[]});
                $.messager.alert("错误","执行失败，请查看sql或数据源是否正确");
            }
        });
    }
}


