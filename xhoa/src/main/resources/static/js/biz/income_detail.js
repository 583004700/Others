var incomeGridObject = {
    url: '/income/listPaByArticleId?id='+getQueryString("artId"),
    postData: {},
    datatype: "json",
    mtype: 'get',
    // data: mydata,
    height: "auto",
    page: 1,//第一页
    autowidth: true,
    rownumbers: true,
    gridview: true,
    shrinkToFit: true,
    prmNames: {rows: "size"},
    rowNum: 300,
    rowList: [10, 20, 30],
    colNames: ['收入日期','收入金额','打款人姓名', '入账卡号ID'],
    jsonReader: {
        root: "list", page: "pageNum", total: "pages",
        records: "total", repeatitems: false, id: false
    },
    colModel: [
        {
            name: 'date',
            index: 'date',
            editable: true,
            width: 80,
            align: "center",
            sortable: false,
            formatter:function (d) {
                if(!d){
                    return "";
                }
                return new Date(d).format("yyyy-MM-dd hh:mm:ss");
            }
        },
        {
            name: 'amount',
            index: 'amount',
            editable: true,
            width: 80,
            align: "center",
            sortable: false
        },
        {
            name: 'trade_man',
            index: 'trade_man',
            editable: true,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string"
        },
        {
            name: 'bank_no',
            index: 'bank_no',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        }
    ],
    pager: "",
    viewrecords: true,
    caption: "入账详情",
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false
};