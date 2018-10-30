/**
 * Created by Administrator on 2017/6/9.
 *
 */

Date.prototype.Format = function (fmt) {
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};


function html2Escape(sHtml) {
    return sHtml.replace(/[<>&".]/g,function(c){return {'<':'&lt;','>':'&gt;','&':'&amp;','"':'&quot;','.':'&middot;'}[c];});
}



$("[data-toggle='tooltip']").tooltip();

$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

    /*
    * 1.任务创建
    *
    * */
    var btn_query = $('#btn_query');  //创建

    //var staff_name = "<% Staff login_user = (Staff)request.getSession().getAttribute("staff");out.print(login_user.getName());%>";

    //元素
    var task_name = $('#task_name').val();
    var task_tarcountry = $('#task_tarcountry').val();
    var task_tarcity = $('#task_tarcity').val();
    var task_jiaoliutimu = $('#task_jiaoliutimu').val();
    var task_type = $('#task_type').val();
    var task_cjcfbeg001 = $('#task_cjcfbeg001').val();
    var task_cjggend001 = $('#task_cjggend001').val();
    var task_lijingshijian001 = $('#task_lijingshijian001').val();
    var task_rujingshijian001 = $('#task_rujingshijian001').val();
    var task_significance = $('#task_significance').val();
    var task_temp = $('#task_temp').val();

    //新建数据记录
    btn_query.click(function(){
        $.ajax({
            type: "get",
            url: "/insertTask",
            async: false,
            data: {'rowLists': JSON.stringify(rowLists),'lengthRecords':rowLists.length},
            dataType:"json",
            success: function (data1) {

            },
            error: function () {
                alert("Error");
            }
        });
    });


    /*
    * 2.更新staffextend
    *
    * */
    var extend_nation = $('#extend_nation').val();
    var extend_educationle = $('#extend_educationle').val();
    var extend_zzmianmao = $('#extend_zzmianmao').val();
    var extend_wgysp = $('#extend_wgysp').val();
    var passport_ywhuzhao = $('#passport_ywhuzhao').val();
    var passport_huzhaozhonglei = $('#passport_huzhaozhonglei').val();
    var passport_huzhaohao = $('#passport_huzhaohao').val();
    var extend_bysjbyyx = $('#extend_bysjbyyx').val();
    var task_swscmxm = $('#task_swscmxm').val();
    var task_swscmdh = $('#task_swscmdh').val();
    var passport_beizhu = $('#passport_beizhu').val();
    var staffdetail_yjfxcjgx = $('#staffdetail_yjfxcjgx').val();

    var btn_gengxin = $('#btn_gengxin');
    btn_gengxin.click(function(){
        $.ajax({
            type: "get",
            url: "/updateStaffextend",
            async: false,
            data: {'rowLists': JSON.stringify(rowLists),'lengthRecords':rowLists.length},
            dataType:"json",
            success: function (data1) {

            },
            error: function () {
                alert("Error");
            }
        });
    });
});


function getJsonLength(jsonData){
    var jsonLength = 0;
    for(var item in jsonData){
        jsonLength++;
    }
    return jsonLength;
}

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_tasks').bootstrapTable({
            url: '/selectAllTask', //请求后台的URL（*）
            //contextMenu: '#example1-context-menu',
            method: 'get', //请求方式（*）
            dataType: "json",
            toolbar: '#toolbar', //工具按钮用哪个容器
            striped: true, //是否显示行间隔色
            cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true, //是否显示分页（*）
            sortable: true, //是否启用排序
            sortOrder: "asc", //排序方式
            queryParams: null,//传递参数（*）
            queryParamsType: "undefined",//undefined
            singleSelect: false,//复选框只能选择一条记录
            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1, //初始化加载第一页，默认第一页
            pageSize: 10, //每页的记录行数（*）
            pageList: [10, 25, 50, 100,500], //可供选择的每页的行数（*）
            search: false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端
            strictSearch: true,
            showColumns: true, //是否显示所有的列
            showRefresh: true, //是否显示刷新按钮
            minimumCountColumns: 2, //最少允许的列数
            clickToSelect: true, //是否启用点击选中行
            height: 'auto', //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id", //每一行的唯一标识，一般为主键列
            showToggle:true, //是否显示详细视图和列表视图的切换按钮
            cardView: false, //是否显示详细视图
            detailView: false, //是否显示父子表
            showExport: true,
            exportDataType: "selected",              //'basic', 'all', 'selected'.
            columns: [
                {checkbox: true},
                {field:'id',title:'ID',width:60,align:'center',sortable:true},
                {field:'zhuangtai',title:'审核状态',width:100,align:'left',sortable:true},
                {field:'name',title:'任务名',width:70,align:'left',sortable:true},
                {field:'tarcountry',title:'目的国',width:80,align:'left',sortable:true},
                {field:'tarcity',title:'目的城市',width:100,align:'left',sortable:true}
            ],
            onEditableSave: function (field, row, oldValue, $el) {
                $.ajax({
                    error: function () {
                        //alert("Error");
                    },
                    complete: function () {

                    }

                });
            }
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.pageSize, //页面大小
            pageNumber: params.pageNumber, //页码

            //筛选参数
            sortName:this.sortName,
            sortOrder:this.sortOrder
        };
        return temp;
    };
    return oTableInit;
};



var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
    };

    return oInit;
};

