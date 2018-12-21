var gridObject = {
    url: '/rt/jdk',
    postData: {},
    datatype: "json",
    mtype: 'get',
    // data: mydata,
    height: "auto",
    page: 1,//第一页
    autowidth: true,
    rownumbers: true,
    gridview: true,
    viewrecords: true,
    multiselect: true,
    shrinkToFit: true,
    prmNames: {rows: "size"},
    rowNum: 10,
    rowList: [10, 20, 30],
    colNames: ["用户名","真实姓名"],
    jsonReader: {
        root: "list", page: "pageNum", total: "pages",
        records: "total", repeatitems: false, id: false
    },
    colModel: [
        {
            name: 'userName',
            index: 'userName',
            editable: false,
            width: 30,
            align: "center",
            sortable: false,
            sorttype: "int",
            search: true,
            hidden:false
        },
        {
            name: 'name',
            index: 'name',
            editable: false,
            width: 90,
            align: "center",
            sortable: false,
            sorttype: "string"
        }
    ],
    pager: "#custPager",
    viewrecords: true,
    caption: "客户列表",
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false
};
