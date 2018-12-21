
function view() {
    $("#myModal").modal('toggle');

}
function loadAccountInfo2() {
    $.jgrid.defaults.styleUI = 'Bootstrap';
    $("#account_table_logs2").jqGrid({
        url: '/user/deptUser',
        datatype: "json",
        mtype: 'POST',
        postData: $("#innerAccount").serializeJson(), //发送数据
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
        multiselect: true,
        multiboxonly: true,
        beforeSelectRow: beforeSelectRow,
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
            {name: 'deptName', label: '部门名称', editable: true, width: 240},
            {name: 'name', label: '用户名', editable: true, width: 240},
            // {name: 'balance', label: '账号开户行', editable: true, width: 240},
            {name: 'id', label: 'id', editable: true,hidden: true, width: 0},
        ],
        pager: "#account_pager_logs2",
        viewrecords: true,
        caption: "",
        add: false,
        edit: true,
        addtext: 'Add',
        edittext: 'Edit',
        hidegrid: false,
    });

    //实现单选
    function beforeSelectRow() {
        $("#account_table_logs2").jqGrid('resetSelection');
        return (true);
    }


}


function xz1() {
    var rowid = $("#account_table_logs2").jqGrid("getGridParam", "selrow");     //获取选中行id
    var rowData = jQuery("#account_table_logs2").jqGrid("getRowData", rowid);   //获取选中行信息
    $("#mgrId").val(rowData.id);
    $("#mgrName").val(rowData.name);
    $("#accountModal2").modal('hide');
} 
 
function fgld() {
    var rowid = $("#account_table_logs2").jqGrid("getGridParam", "selrow");     //获取选中行id
    var rowData = jQuery("#account_table_logs2").jqGrid("getRowData", rowid);   //获取选中行信息
    $("#mgrLeaderId").val(rowData.id);
    $("#mgrLeaderName").val(rowData.name);
    $("#accountModal2").modal('hide');
}
function xz11() {
    var rowid = $("#account_table_logs2").jqGrid("getGridParam", "selrow");     //获取选中行id
    var rowData = jQuery("#account_table_logs2").jqGrid("getRowData", rowid);   //获取选中行信息
    $("#mgrId1").val(rowData.id);
    $("#mgrName1").val(rowData.name);
    $("#accountModal2").modal('hide');
}
function fgld1() {
    var rowid = $("#account_table_logs2").jqGrid("getGridParam", "selrow");     //获取选中行id
    var rowData = jQuery("#account_table_logs2").jqGrid("getRowData", rowid);   //获取选中行信息
    $("#mgrLeaderId1").val(rowData.id);
    $("#mgrLeaderName1").val(rowData.name);
    $("#accountModal2").modal('hide');
}
function submitHander(t,url) {
    if ($("#editForm").valid()) {
        // alert($("#form").serialize());
        var param = $("#editForm").serializeJson();
        startModal("#"+t.id);//锁定按钮，防止重复提交
        // startModal("#update");//锁定按钮，防止重复提交
        // alert(JSON.stringify(param));
        $.ajax({
            type: "post",
            url: url,
            data: param,
            dataType: "json",
            success: function (data) {
                Ladda.stopAll();   //解锁按钮锁定
                $("#account_table_logs2").jqGrid('setGridParam', {
                   // postData: $("#queryForm").serializeJson(), //发送数据
                }).trigger("reloadGrid"); //重新载入
                $("#myModal").modal('hide');
            }
        });
    }
}




$(document).ready(function () {
    $("#selMgr").click(function () {
        document.getElementById("selectAccount").onclick = xz1;
        $("#accountModal2").modal('toggle');
        loadAccountInfo2();
    });
    $("#selMgr1").click(function () {
        document.getElementById("selectAccount").onclick = xz11;
        $("#accountModal2").modal('toggle');
        loadAccountInfo2();
    });
    $("#selMgrLeader1").click(function () {
        document.getElementById("selectAccount").onclick = fgld1;
        $("#accountModal2").modal('toggle');
        loadAccountInfo2();
    });
    $("#selMgrLeader").click(function(){
 document.getElementById("selectAccount").onclick=fgld;
        $("#accountModal2").modal('toggle');
        loadAccountInfo2();
    });

    $("#accountSearch2").click(function () {
        $("#account_table_logs2").emptyGridParam() ;
        $("#account_table_logs2").jqGrid('setGridParam', {
            postData: $("#innerAccount").serializeJson(), //发送数据
        }).trigger("reloadGrid"); //重新载入
    });

    $.ajax({
        url: "/dept/list",
        type: "post",
        dataType: "json",
        success: function (data) {
            require.config({
                paths: {
                    echarts: 'http://echarts.baidu.com/build/dist'
                }
            });
            require(
                [
                    'echarts',
                    'echarts/chart/tree' // 使用树状图就加载tree模块，按需加载
                ],
                function (ec) {
                    // 基于准备好的dom，初始化echarts图表
                    var myChart = ec.init(document.getElementById('main_orgStructure'));
                    myChart.on("click", clickFun);
                    myChart.hideLoading();
                    // 为echarts对象加载数据
                    myChart.setOption(
                        option = {
                            series: [
                                {
                                    name: '组织架构图',
                                    color: '#000',
                                    type: 'tree',
                                    roam: true,//是否开启鼠标缩放和平移漫游。默认不开启。如果只想要开启缩放或者平移，可以设置成 'scale' 或者 'move'。设置成 true 为都开启
                                    rootLocation: {x: 'center', y: '15%'}, // 根节点位置  {x: 'center',y: 10}
                                    nodePadding: 20,
                                    layerPadding: 40,
                                    borderColor: 'black',
                                    // initialTreeDepth:3,
                                    // expandAndCollapse: true,
                                    // orient: 'vertical',
                                    // symbol: 'image://http://localhost/img/deptBg.png', //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow', 'none'
                                    symbol: 'side', //'circle', 'rect', 'roundRect', 'triangle', 'diamond', 'pin', 'arrow', 'none'
                                    itemStyle: {
                                        normal: {
                                            color: '#EC5565',
                                            // color: '#E86C79',
                                            // rotate: -90,
                                            label: {
                                                color: '#000',
                                                show: true,
                                                position: 'right',
                                                position: 'inside',
                                                textStyle: {
                                                    color: '#FFFFFF',//标签颜色
                                                    fontSize: 15,
                                                }
                                            },
                                            lineStyle: {
                                                color: '#ccc',
                                                width: 1,
                                                type: 'broken' // 'curve'|'broken'|'solid'|'dotted'|'dashed'
                                            }
                                        }
                                    },
                                    label: {
                                        color: '#000',
                                        // backgroundColor:'#000',
                                        // shadowColor:'#000',
                                        normal: {
                                            show: false,
                                            // rotate: -90,
                                            verticalAlign: 'middle',
                                            align: 'right',
                                            fontSize: 9
                                        }
                                    },

                                    data: data.data.list,
                                    top: '5%',
                                    left: '2%',
                                    bottom: '5%',
                                    right: '5%',
                                    symbolSize: [100, 30],
                                    showAllSymbol: true,

                                }
                            ]
                        });
                    // myChart.on('click', function (param) {
                    //     console.log(param)
                    //     alert(param);
                    // });
                    if (option && typeof option === "object") {
                        myChart.setOption(option, true);
                    }

                    //关键点！
                    function clickFun(param) {
                        // console.log(param) ;
                        if (typeof param.seriesIndex == 'undefined') {
                            return;
                        }
                        if (param.type == 'click') {
                            console.log(param)
                            $("#myModal").modal('toggle');
                            // $(".modal-body").find("option").removeAttr("selected") ;
                            $("#name").val(param.name);
                            $("#code").val(param.data.code);
                            $("#type").val(param.data.type);
                            $("#id").val(param.data.value);
                            $("#level").val(param.data.level);
                            $("#parentId").val(param.data.pid);
                            $("#mgrName").val(param.data.mgrName);
                            $("#mgrId").val(param.data.mgrId);
                            $("#mgrLeaderId").val(param.data.mgrLeaderId);
                            $("#mgrLeaderName").val(param.data.mgrLeaderName);
                            //子部门信息
                            $("#parentId1").val(param.data.value);
                            $("#level1").val(param.data.level);
                            $("#code1").val(param.data.code);
                            $("#type1").val(param.data.type);
                            //level=1时，要显示是新媒体还是网络媒介
                            if(param.data.level==1 && param.data.name=='媒介部'){
                                $("#code1").val("MJ") ;
                                $("#MJType1").show() ;
                                $("#types1").removeAttr('disabled');
                            }else{
                                $("#MJType1").hide() ;
                            }
                            if(param.data.code=='MJ' && param.data.level>1){
                                // console.log("*******"+param.data.type)
                                $("#MJType1").show() ;
                                $("#MJType").show() ;
                                $("#types").prop("disabled",'disabled')
                                $("#types1").prop("disabled",'disabled')
                                $("#MJType").find("option[value='"+param.data.type+"']").prop('selected','selected');
                                $("#MJType1").find("option[value='"+param.data.type+"']").prop('selected','selected');
                            }else{
                                $("#MJType").hide() ;
                            }
                        }
                    }

                });
        }
    })
    //=================================================节点维护开始===================================================
    // $.validator.setDefaults({
    //     highlight: function (e) {
    //         $(e).closest(".form-group").removeClass("has-success").addClass("has-error")
    //     }, success: function (e) {
    //         e.closest(".form-group").removeClass("has-error").addClass("has-success")
    //     }, errorElement: "span", errorPlacement: function (e, r) {
    //         e.appendTo(r.is(":radio") || r.is(":checkbox") ? r.parent().parent().parent() : r.parent())
    //     }, errorClass: "help-block m-b-none", validClass: "help-block m-b-none"
    // }),
    var e = "<i class='fa fa-times-circle'></i> ";
    $("#deptForm").validate({
        rules: {
            name: {
                required: !0, minlength: 2, maxlength: 16,
                remote: {
                    url: "/dept/checkName", // 后台处理程序
                    type: "post", // 数据发送方式
                    dataType: "json", // 接受数据格式
                    data: { // 要传递的数据
                        "id": function () {
                            return $("#id").val();
                        },
                        "name": function () {
                            return $("#name").val();
                        },
                        "childName": function () {
                            return "";
                        }
                    },
                    dataFilter: function (data) {
                        //返回值是string，需要转换成json
                        var obj = JSON.parse(data)
                        if (obj.data.flag) {
                            return true;
                        } else {
                            return false;
                        }

                    }
                }
            },
            childName: {
                required: !0, minlength: 2, maxlength: 16,
                remote: {
                    url: "/dept/checkName", // 后台处理程序
                    type: "post", // 数据发送方式
                    dataType: "json", // 接受数据格式
                    data: { // 要传递的数据
                        "id": function () {
                            return $("#id").val();
                        },
                        "name": function () {
                            return "";
                        },
                        "childName": function () {
                            return $("#childName").val();
                        }
                    },
                    dataFilter: function (data) {
                        //返回值是string，需要转换成json
                        var obj = JSON.parse(data)
                        if (obj.data.flag) {
                            return true;
                        } else {
                            return false;
                        }

                    }
                }
            },
        },
        // messages: {
        //     name: {
        //         required: e + "请输入部门名称",
        //
        //         remote: e + "部门名称重复"
        //     },
        //     childName: {
        //         required: e + "请输入部门名称",
        //
        //         remote: e + "部门名称重复"
        //     },
        // }
    });
    $("#edit").click(function () {

        if ($("#editForm").valid()) {
            // console.log(JSON.stringify($("#deptForm").serializeJson()))
            $.ajax({
                type: "post",
                url: "/dept/edit",
                data: $("#editForm").serializeJson(),
                dataType: "json",
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg(data.data.message, {time: 1000, icon: 6});
                        // $("#myModal").modal('toggle');
                        setTimeout(function () {
                            window.location.reload();
                        }, 1000);
                    } else {
                        layer.msg(data.msg);
                    }
                }
            });
        }
    });
    $("#del").click(function () {

        layer.confirm('确认删除？删除该部门会把相应的下属部门一起删除，请确认后操作！', {
            btn: ['删除', '取消'], //按钮
            shade: false //不显示遮罩
        }, function () {
            $.ajax({
                type: "post",
                url: "/dept/del",
                data: {id:$("#id").val()},
                dataType: "json",
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg(data.data.message, {time: 1000, icon: 6});
                        // $("#myModal").modal('toggle');
                        setTimeout(function () {
                            window.location.reload();
                        }, 1000);

                    } else {
                        layer.msg(data.msg);
                    }
                }
            });
        }, function () {
            return;
        });
    });
    $("#add").click(function () {

        if ($("#addForm").valid()) {
            // console.log(JSON.stringify($("#deptForm").serializeJson()))
            $.ajax({
                type: "post",
                url: "/dept/addChild",
                data: $("#addForm").serializeJson(),
                dataType: "json",
                success: function (data) {
                    if (data.code == 200) {
                        layer.msg(data.data.message, {time: 1000, icon: 6});
                        // $("#myModal").modal('toggle');
                        setTimeout(function () {
                            window.location.reload();
                        }, 1000);

                    } else {
                        layer.msg(data.msg);
                    }
                }
            });
        }

    });
    //=================================================节点维护结束===================================================

})