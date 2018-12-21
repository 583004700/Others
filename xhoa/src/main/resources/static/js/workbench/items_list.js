var itemsObject = {
    url: '/items/list',
    postData: {transactionState: getQueryString("transactionState")},
    datatype: "json",
    mtype: 'get',
    // data: mydata,
    height: "auto",
    page: 1,//第一页
    autowidth: true,
    rownumbers: false,
    gridview: true,
    viewrecords: true,
    multiselect: true,
    shrinkToFit: true,
    prmNames: {rows: "size"},
    rowNum: 10,
    rowList: [10, 20, 30],
    colNames: ['id','工作名称', '工作类型' ,'发起人', '开始时间', '接收时间', '处理期限'],
    jsonReader: {
        root: "list", page: "pageNum", total: "pages",
        records: "total", repeatitems: false, id: false
    },
    colModel: [
        {
            name: 'id',
            index: 'id',
            editable: false,
            width: 30,
            align: "center",
            sortable: false,
            sorttype: "int",
            search: false,
            hidden: true
        },
        {
            name: 'itemName',
            index: 'itemName',
            editable: false,
            width: 90,
            align: "center",
            sortable: false,
            sorttype: "string"
        },
        {
            name: 'workType',
            index: 'workType',
            editable: false,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'initiatorWorkerName',
            index: 'initiatorWorkerName',
            editable: false,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'startTime',
            index: 'startTime',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            formatter:function (d) {
                if(d){
                    return new Date(d).format("yyyy-MM-dd hh:mm:ss");
                }
                return "";
            }
        },
        {
            name: 'createTime',
            index: 'createTime',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            formatter:function (d) {
                if(d){
                    return new Date(d).format("yyyy-MM-dd hh:mm:ss");
                }
                return "";
            }
        },
        {
            name: 'endTime',
            index: 'endTime',
            editable: false,
            width: 100,
            align: "center",
            sortable: false,
            formatter:function (d) {
                if(d){
                    return new Date(d).format("yyyy-MM-dd hh:mm:ss");
                }
                return "";
            }
        }
    ],
    /**
     * 翻页时保存当前页面的选中数据
     * @param pageBtn
     */
    onPaging:function(pageBtn){
        //跨页面选择
        itemsGrid.setPageSelected("id");
    },
    gridComplete: function () {
        //跨页面选择
        itemsGrid.getPageSelectedSet("id");
    },
    pager: "#itemsPager",
    viewrecords: true,
    caption: null,
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false
};