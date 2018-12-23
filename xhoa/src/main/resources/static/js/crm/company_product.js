var productGridObject = {
    url: '/cust/productInfo?id='+getQueryString("companyId"),
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
    rowNum: 30,
    rowList: [10, 20, 30],
    colNames: ['所属品类','适用人群', '适用场景', "包装风格", "市场定价", "功能", "操作"],
    jsonReader: {
        root: "list", page: "pageNum", total: "pages",
        records: "total", repeatitems: false, id: false
    },
    colModel: [
        {
            name: 'category',
            index: 'category',
            editable: true,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string"
        },
        {
            name: 'suitUsers',
            index: 'suitUsers',
            editable: true,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string"
        },
        {
            name: 'suitScene',
            index: 'suitScene',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'packStyle',
            index: 'packStyle',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'price',
            index: 'price',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'func',
            index: 'func',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: '',
            editable: true,
            width: 100,
            align: "center",
            sortable: false,
            formatter:function (a,b,rowdata) {
                var html = "";
                html += "<a href='javascript:Product.look("+rowdata.id+")' style='margin-right:3px;'>查看</a>"
                html += "<a href='javascript:Product.edit("+rowdata.id+")' style='margin-right:3px;'>编辑</a>"
                return html;
            }
        }
    ],
    pager: "#productPager",
    viewrecords: true,
    caption: "产品列表",
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false
};

var Product = {
    look:function(id){
        alertEdit('/crm/product_edit?op=ck&id='+id,'查看产品');
    },
    edit:function(id){
        alertEdit('/crm/product_edit?op=edit&id='+id,'编辑产品');
    }
};