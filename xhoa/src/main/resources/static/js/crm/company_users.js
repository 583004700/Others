var usersGridObject = {
    url: '/cust/custUsers?id='+getQueryString("companyId"),
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
    colNames: ['年龄','性别', '所属地域', "文化水平", "流行话题", "职业", "爱好", "操作"],
    jsonReader: {
        root: "list", page: "pageNum", total: "pages",
        records: "total", repeatitems: false, id: false
    },
    colModel: [
        {
            name: 'age',
            index: 'age',
            editable: true,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string"
        },
        {
            name: 'sex',
            index: 'sex',
            editable: true,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string"
        },
        {
            name: 'area',
            index: 'area',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'culturalLevel',
            index: 'culturalLevel',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'topic',
            index: 'topic',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'ujob',
            index: 'ujob',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'hobby',
            index: 'hobby',
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
                //如果负责人是自己
                html += "<a href='javascript:Users.look("+rowdata.id+")' style='margin-right:3px;'>查看</a>"
                html += "<a href='javascript:Users.edit("+rowdata.id+")' style='margin-right:3px;'>编辑</a>"
                return html;
            }
        }
    ],
    pager: "#usersPager",
    viewrecords: true,
    caption: "用户列表",
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false
};

var Users = {
    look:function(id){
        alertEdit('/crm/users_edit?op=ck&id='+id,'查看用户');
    },
    edit:function(id){
        alertEdit('/crm/users_edit?op=edit&id='+id,'编辑用户');
    }
};