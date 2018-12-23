var dockingGridObject = {
    url: '/cust/dockingInfo?id='+getQueryString("companyId"),
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
    colNames: ['姓名','部门', '职位', "负责项目", "性格", "年龄", "家庭", "专业程度","文化","爱好","之前所在的公司","长相", "操作"],
    jsonReader: {
        root: "list", page: "pageNum", total: "pages",
        records: "total", repeatitems: false, id: false
    },
    colModel: [
        {
            name: 'custName',
            index: 'custName',
            editable: true,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string"
        },
        {
            name: 'department',
            index: 'department',
            editable: true,
            width: 80,
            align: "center",
            sortable: false,
            sorttype: "string"
        },
        {
            name: 'job',
            index: 'job',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'fproject',
            index: 'fproject',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'kidney',
            index: 'kidney',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'age',
            index: 'age',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'home',
            index: 'home',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'professionLevel',
            index: 'professionLevel',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'cultural',
            index: 'cultural',
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
            name: 'oldCompany',
            index: 'oldCompany',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: 'looks',
            index: 'looks',
            editable: true,
            width: 100,
            align: "center",
            sortable: false
        },
        {
            name: '',
            editable: true,
            width: 120,
            align: "center",
            sortable: false,
            formatter:function (a,b,rowdata) {
                var html = "";
                //如果负责人是自己
                if(user.id == rowdata.worker){
                    html += "<a href='javascript:DockingPeople.look("+rowdata.id+")' style='margin-right:3px;'>查看</a>";
                    html += "<a href='javascript:DockingPeople.edit("+rowdata.id+")' style='margin-right:3px;'>编辑</a>";
                    html += "<a href='javascript:DockingPeople.accountManager("+rowdata.id+")' style='margin-right:3px;'>账户管理</a>";
                }
                return html;
            }
        }
    ],
    pager: "#dockingPager",
    viewrecords: true,
    caption: "对接人列表",
    add: false,
    edit: false,
    addtext: 'Add',
    edittext: 'Edit',
    hidegrid: false
};

var DockingPeople = {
    look:function(id){
        alertEdit('/crm/docking_edit?op=ck&id='+id,'查看对接人');
    },
    edit:function(id){
        alertEdit('/crm/docking_edit?op=edit&id='+id,'编辑对接人');
    },
    accountManager:function(id){
        alertEdit('/fee/queryAccount?op=docking&dockingId='+id+"&companyId="+CustOption.companyId+"&companyName="+CustOption.companyName,"账户管理");
    }
};