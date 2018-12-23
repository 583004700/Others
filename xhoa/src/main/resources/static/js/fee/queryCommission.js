function view(id,userId,year,month) {
    $("#articleModal").modal('toggle');
    $.ajax({
        type: "post",
        url: "/commission/view",
        data: {id: id},
        dataType: "json",
        success: function (data) {
            for (var attr in data.data.entity) {
                $("[name=" + attr + "]").val(data.data.entity[attr]);
                // $("[name="+attr+"]").attr("readonly","readonly");
            }
        }

    });
    $("#userId").val(userId)
    $("#year").val(year)
    $("#month").val(month)
    $("#article_table_logs").jqGrid('setGridParam', {
        postData: $("#articleForm").serializeJson(), //发送数据
    }).trigger("reloadGrid"); //重新载入
    $("#article_table_logs").jqGrid({
        url: '/article/queryArticleForComm',
        datatype: "json",
        mtype: 'POST',
        postData: $("#articleForm").serializeJson(), //发送数据
        altRows: true,
        altclass: 'bgColor',
        height: "auto",
        page: 1,//第一页
        rownumbers: false,
        //setLabel: "序号",
        autowidth: true,//自动匹配宽度
        gridview: true, //加速显示
        cellsubmit: "clientArray",
        viewrecords: true,  //显示总记录数
        multiselect: false,
        multiselectWidth: 25, //设置多选列宽度
        sortable: "true",
        sortname: "id",
        sortorder: "desc", //排序方式：倒序，本例中设置默认按id倒序排序
        shrinkToFit: true,
        prmNames: {rows: "size"},
        rowNum: 10,//每页显示记录数
        rowList: [10, 25, 50],//分页选项，可以下拉选择每页显示记录数
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: "id"
        },

        // colNames: ['角色类型', '角色名称', '角色描述', '操作'],
        colModel: [
            {name: 'id', label: 'id', editable: true,hidden:true, width: 120},
            {name: 'mediaName', label: '媒体名称', editable: true, width: 120},
            {name: 'supplierName', label: '供应商名称', editable: true, width: 60},
            {name: 'title', label: '标题', editable: true, width: 60,},
            {name: 'link', label: '链接', editable: true, width: 80},
            {name: 'saleAmount', label: '销售额', editable: true, width: 80},
            {name: 'incomeAmount', label: '进账金额', editable: true, width: 80},
            {name: 'taxes', label: '税额', editable: true, width: 80},
            {name: 'outgoAmount', label: '成本', editable: true, width: 80},
            {name: 'otherPay', label: '其他支出', editable: true, width: 80},
            {name: 'refundAmount', label: '退款', editable: true, width: 80},
            {name: 'commission', label: '提成', editable: true, width: 80}
        ],
        pager: jQuery("#article_pager_logs"),
        viewrecords: true,
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        loadComplete: function (data) {
            if (getResCode(data))
                return;
        }
    });

    $("#articleSearch").click(function () {
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#article_table_logs").emptyGridParam() ;
        $("#article_table_logs").jqGrid('setGridParam', {
            postData: $("#articleForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });
};
function confirm(id) {
    layer.confirm('把提成数据发送给业务员确认？', {
        btn: ['发送', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index);
        $.ajax({
            type: "post",
            url: "/commission/confirm",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                layer.close(index);
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    $("#query_table_logs").jqGrid('setGridParam', {
                        postData: $("#queryForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {
        return;
    });
};

//审批记录查看
function history(id) {
    //process详见IProcess
    $("#historyModal").modal('toggle');
    $.ajax({
        type: "post",
        url: "/process/history",
        data: {dataId: id,process: 5},
        dataType: "json",
        success: function (data) {
            if(data.code==200){
                $("#history").empty() ;
                if(data.data.data!=null){
                    html="<div class='form-control'>" +
                        "<div class='col-sm-3 text-center'>节点</div>" +
                        "<div class='col-sm-3 text-center'>审批人</div>" +
                        "<div class='col-sm-3 text-center'>审批意见</div>" +
                        "<div class='col-sm-3 text-center'>审批时间</div>" ;
                    $("#history").append(html) ;
                    for(var i=0;i<data.data.data.length;i++){
                        html = "<div class='form-control'>" +
                            "<div class='col-sm-3 text-center'>"+data.data.data[i].name+"</div>" +
                            "<div class='col-sm-3 text-center'>"+data.data.data[i].user+"</div>" +
                            "<div class='col-sm-3 text-center'>"+data.data.data[i].desc+"</div>" +
                            "<div class='col-sm-3 text-center'>"+data.data.data[i].time+"</div>" +
                            "</div>" ;
                        $("#history").append(html) ;
                    }
                    html="</div>"
                    $("#history").append(html) ;
                }
            }else{
                layer.msg(data.msg) ;
            }
        }
    });
};
function pass(id) {
    layer.confirm('您已确定提成数据没有问题？', {
        btn: ['确定', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index);
        $.ajax({
            type: "post",
            url: "/commission/pass",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                layer.close(index);
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    $("#query_table_logs").jqGrid('setGridParam', {
                        postData: $("#queryForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {
        return;
    });
};
function reject(id) {
    layer.confirm('提成数据有问题？退回财务复核！', {
        btn: ['确定', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index);
        $.ajax({
            type: "post",
            url: "/commission/reject",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                layer.close(index);
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    $("#query_table_logs").jqGrid('setGridParam', {
                        postData: $("#queryForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {
        return;
    });
};
function release(id) {
    layer.confirm('发放提成？', {
        btn: ['确定', '取消'], //按钮
        shade: false //不显示遮罩
    }, function (index) {
        layer.close(index);
        $.ajax({
            type: "post",
            url: "/commission/release",    //向后端请求数据的url
            data: {id: id},
            dataType: "json",
            success: function (data) {
                layer.close(index);
                if (data.code == 200) {
                    layer.msg(data.data.message, {time: 1000, icon: 6});
                    $("#query_table_logs").jqGrid('setGridParam', {
                        postData: $("#queryForm").serializeJson(), //发送数据
                    }).trigger("reloadGrid"); //重新载入
                } else {
                    layer.msg(data.msg);
                }
            }
        });
    }, function () {
        return;
    });
};
$(document).ready(function () {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $(window).bind('resize', function () {
        var width = $('.jqGrid_wrapper').width();
        $('#query_table_logs').setGridWidth(width);
        $('#article_table_logs').setGridWidth(width);
    });

    //flag=1审批，否则查看
    if(getQueryString("id")==null||getQueryString("id")==""||getQueryString("id")==undefined){

    }else{
        view(getQueryString("id"),getQueryString("flag")) ;
    }

    $("#query_table_logs").jqGrid({
        url: '/commission/listPg',
        datatype: "json",
        mtype: 'POST',
        postData: $("#queyrForm").serializeJson(), //发送数据
        altRows: true,
        altclass: 'bgColor',
        height: "auto",
        page: 1,//第一页
        rownumbers: false,
        //setLabel: "序号",
        autowidth: true,//自动匹配宽度
        gridview: true, //加速显示
        cellsubmit: "clientArray",
        viewrecords: true,  //显示总记录数
        multiselect: false,
        multiselectWidth: 25, //设置多选列宽度
        sortable: "true",
        sortname: "id",
        sortorder: "desc", //排序方式：倒序，本例中设置默认按id倒序排序
        shrinkToFit: true,
        prmNames: {rows: "size"},
        rowNum: 10,//每页显示记录数
        rowList: [10, 25, 50],//分页选项，可以下拉选择每页显示记录数
        jsonReader: {
            root: "list", page: "pageNum", total: "pages",
            records: "total", repeatitems: false, id: "id"
        },

        // colNames: ['角色类型', '角色名称', '角色描述', '操作'],
        colModel: [
            {name: 'year', label: '年', editable: true, width: 60},
            {name: 'month', label: '月', editable: true, width: 60,},
            {name: 'id', label: 'id', editable: true,hidden:true, width: 60},
            {name: 'user_id', label: 'userId', editable: false,hidden:true, width: 60},
            {name: 'name', label: '业务员姓名', editable: true, width: 60},
            {name: 'dept_name', label: '所属部门', editable: true, width: 120},
            {name: 'income', label: '进账金额', editable: true, width: 80},
            {name: 'outgo', label: '成本', editable: true, width: 80},
            {name: 'taxExpense', label: '税额', editable: true, width: 80},
            {name: 'refund', label: '退款', editable: true, width: 80},
            {name: 'otherExpense', label: '其他支出', editable: true, width: 80},
            {name: 'profit', label: '利润', editable: true, width: 80,},
            {name: 'profitPercent', label: '利润占比', editable: true, width: 80},
            {name: 'comm', label: '提成', editable: true, width: 80},
            // {name: 'commPercent', label: '提成比例', editable: true, width: 80},
            {name: 'state', label: '状态', editable: true, width: 80,
                formatter:function (value) {
                    switch (value) {
                        case -1 :
                            return "<span style='color:red'>审核驳回</span>";
                        case 0 :
                            return "<span style=''>已保存</span>";
                        case 1 :
                            return "<span style=''>已完成</span>";
                        case 2 :
                            return "<span style='color:red'>审核通过</span>";
                        case 3 :
                            return "<span style='color:red'>组长审核</span>";
                        case 4 :
                            return "<span style='color:red'>部长审核</span>";
                        case 5 :
                            return "<span style='color:red'>总监审核</span>";
                        case 6 :
                            return "<span style='color:red'>财务总监审核</span>";
                        case 7 :
                            return "<span style='color:red'>副总经理审核</span>";
                        case 8 :
                            return "<span style='color:red'>总经理审核</span>";
                        case 9 :
                            return "<span style='color:red'>会计审核</span>";
                        case 10 :
                            return "<span style='color:red'>业务员确认</span>";
                    }
                }
            },
            {
                name: 'operate', label: "操作", index: '',
                formatter: function (value, grid, rows) {
                    var html = "" ;
                    html += "<a href='javascript:void(0)' style='height:22px;width:40px;'  onclick='view("+rows.id+","+rows.user_id+","+rows.year+","+rows.month+")'>提成详情&nbsp;&nbsp;</a>";
                    if(rows.state==0||rows.state==-1){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;;'  onclick='confirm(" + rows.id + ")'>发起确认&nbsp;&nbsp;</a>";
                    }
                    if(rows.state==10){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;;color: red'  onclick='pass(" + rows.id + ")'>确认通过&nbsp;&nbsp;</a>";
                    }
                    if(rows.state==10){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;;color: red'  onclick='reject(" + rows.id + ")'>驳回&nbsp;&nbsp;</a>";
                    }
                    if(rows.state==2){
                        html += "<a href='javascript:void(0)' style='height:22px;width:40px;;color: blue'  onclick='release(" + rows.id + ")'>发放提成</a>";
                    }
                    return html;
                },
            },
        ],
        pager: jQuery("#query_pager_logs"),
        viewrecords: true,
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
        // ondblClickRow: function (rowid, iRow, iCol, e) {
        //     //双击行时触发。rowid：当前行id；iRow：当前行索引位置；iCol：当前单元格位置索引；e:event对象
        //     //page('/role/view?id=' + rowid, '角色详情');
        //     edit(rowid);
        //     // page('/fee/editCommission?id=' + rowid, '角色编辑');
        // },
        loadComplete: function (data) {
            if (getResCode(data))
                return;
            // console.log(JSON.stringify(data))
        }
    });

    $("#querySearch").click(function () {
        // alert(JSON.stringify($("#role").serializeJson()));
        $("#query_table_logs").emptyGridParam() ;
        $("#query_table_logs").jqGrid('setGridParam', {
            postData: $("#queryForm").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });



});
