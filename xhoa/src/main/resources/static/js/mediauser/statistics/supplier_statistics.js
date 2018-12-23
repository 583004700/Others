var Supplier = {
    //设置统计数据
    setArticleResult: function(){
        $.ajax({
            url: "/mediaUsereManagerStatistics/supplierListSort",
            data: $("#searchForm").serializeJson(),
            type: "post",
            success: function(resData){
                resData = resData.list;
                if(resData && resData.length > 0){
                    for(var o in resData[0]){
                        $("#"+o).text(resData[0][o]);
                    }
                }else{
                    $("#tj").find(".text-danger").html(0);
                }
            }
        });
    }
};

//查询区域
var searchForm = {
    //显示或隐藏发布日期
    showIssuedDate: function (val) {
        if (val == 5) {
            $("#issuedDateFormGroup").show();
        } else {
            $("#issuedDateFormGroup").hide();
        }
    },
    //查询
    search: function () {
       grid.search();
       Supplier.setArticleResult();
    }
};

var gridObject = {
    url: '/mediaUsereManagerStatistics/supplierListSort',
    postData: $("#searchForm").serializeJson(),
    datatype: "json",
    mtype: 'get',
    // data: mydata,
    height: "auto",
    page: 1,//第一页
    autowidth: true,
    rownumbers: true,
    gridview: true,
    viewrecords: true,
    multiselect: false,
    shrinkToFit: true,
    prmNames: {rows: "size"},
    rowNum: 10,
    rowList: [10, 20, 30],
    colNames: ['稿件类别', '供应商', '联系人', '稿件总数','应付金额', '已付金额','请款金额',"操作"],
    jsonReader: {
        root: "list", page: "pageNum", total: "pages",
        records: "total", repeatitems: false, id: false
    },
    colModel: [
        {
            name: 'artType',
            index: 'artType',
            editable: false,
            //width: 80,
            align: "center",
            sortable: false,
            hidden: false
        },
        {
            name: 'supName',
            index: 'supName',
            editable: false,
            //width: 80,
            align: "center",
            sortable: false
        },
        {
            name: 'contactor',
            index: 'contactor',
            editable: false,
            //width: 80,
            align: "center",
            sortable: false,
            sorttype: "string"
        },
        {
            name: 'artCount',
            index: 'artCount',
            editable: false,
            //width: 70,
            align: "center",
            sortable: false,
            sorttype: "string"
        },
        {
            name: 'payAmount',
            index: 'payAmount',
            editable: false,
            //width: 80,
            align: "center",
            sortable: false,
            sorttype: "string",
            hidden: false,
            classes:'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"￥"}
        },
        {
            name: 'incomeAmount',
            index: 'incomeAmount',
            editable: false,
            //width: 70,
            align: "center",
            sortable: false,
            classes:'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"￥"}
        },
        {
            name: 'applyAmount',
            index: 'applyAmount',
            editable: false,
            //width: 70,
            align: "center",
            sortable: false,
            classes:'text-danger',
            formatter: "currency",
            formatoptions: {thousandsSeparator:",",decimalSeparator:".", prefix:"￥"}
        },
        {
            name: 'option',
            editable: false,
            //width: 100,
            align: "center",
            sortable: false,
            formatter:function (a,b,rowdata) {
                return "";
            }
        }
    ],
    /**
     * 翻页时保存当前页面的选中数据
     * @param pageBtn
     */
    onPaging:function(pageBtn){

    },
    gridComplete: function () {

    },
    pager: "#pager",
    viewrecords: true,
    caption: "供应商排名",
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false,
    shrinkToFit:false,
    autoScroll: true
};
