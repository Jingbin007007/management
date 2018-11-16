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

//重置Date原型
Date.prototype.toLocaleString = function() {
    return this.getFullYear() + "-" + (this.getMonth() + 1) + "-" + this.getDate();
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


    //起始时间
    $('#testdatetimepicker001').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //结束时间
    $('#testdatetimepicker002').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //离境时间
    $('#testdatetimepicker003').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //入境时间
    $('#testdatetimepicker004').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //发照时间
    $('#testdatetimepicker005').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //护照效期
    $('#testdatetimepicker006').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //护照延期
    $('#testdatetimepicker007').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //开始时间
    $('#testdatetimepicker008').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //结束时间
    $('#testdatetimepicker009').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //出生日期
    $('#testdatetimepicker0010').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //有效期至
    $('#testdatetimepicker0011').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //起止年月1
    $('#testdatetimepicker0012').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //起止年月2
    $('#testdatetimepicker0013').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //起止年月3
    $('#testdatetimepicker0014').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //起止年月4
    $('#testdatetimepicker0015').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //起止年月5
    $('#testdatetimepicker0016').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //时间1
    $('#testdatetimepicker0017').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //时间2
    $('#testdatetimepicker0018').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //时间3
    $('#testdatetimepicker0019').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //离境时间
    $('#testdatetimepicker0020').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });
    //入境时间
    $('#testdatetimepicker0021').datetimepicker({
        weekStart: 0, //一周从哪一天开始
        todayBtn:  1, //
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1,
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd'
    });

    //全局变量初始化
    staff_id = $('#span_temp001').text();
    $.ajax({
        type: "get",
        url: "/staffextend/selectStaffextendByStaffLimit",
        async: false,
        data: {
            'staff_id':staff_id
        },
        dataType:"json",
        success: function (data1) {
            staffextend_id = data1[0].extendid;
            task_id = data1[0].taskid.id;
        },
        error: function () {
            alert("Error!");
        }
    });

    //Task table设置Opt参数
    var opt = {
        url: '/task/selectAllTask',
        query:{
            sortName:"id",
            sortOrder:"asc"
        }
    };

    //新建Task记录
    btn_query.click(function(){
        $.ajax({
            type: "get",
            url: "/task/insertTask",
            async: false,
            data: {'task_name': $('#task_name').val(),
                'task_tarcountry':$('#task_tarcountry').val(),
                'task_tarcity':$('#task_tarcity').val(),
                'task_jiaoliutimu':$('#task_jiaoliutimu').val(),
                'task_type':$('#task_type').val(),
                'task_cjcfbeg001':$('#testdatetimepicker001').find("input").val(),
                'task_cjggend001':$('#testdatetimepicker002').find("input").val(),
                'task_lijingshijian001':$('#testdatetimepicker003').find("input").val(),
                'task_rujingshijian001':$('#testdatetimepicker004').find("input").val(),
                'task_significance':$('#task_significance').val(),
                'task_temp':$('#task_temp').val(),
                'staff_id':staff_id
            },
            dataType:"json",
            success: function (data1) {
                $('#extend_nation').val(data1.nation);
                $('#extend_educationle').val(data1.educationle);
                //extend_zzmianmao
                $('#extend_zzmianmao').val(data1.zzmianmao);
                //extend_wgysp
                $('#extend_wgysp').val(data1.wgysp);
                //passport_ywhuzhao
                $('#passport_ywhuzhao').val(data1.ywhuzhao);
                //passport_huzhaozhonglei
                $('#passport_huzhaozhonglei').val(data1.huzhaozhonglei);
                //passport_huzhaohao
                $('#passport_huzhaohao').val(data1.huzhaohao);
                //extend_bysjbyyx
                $('#extend_bysjbyyx').val(data1.bysjbyyx);
                //task_swscmxm
                $('#task_swscmxm').val(data1.swscmxm);
                //task_swscmdh
                $('#task_swscmdh').val(data1.swscmdh);
                //passport_beizhu
                $('#passport_beizhu').val(data1.beizhu);
                //staffdetail_yjfxcjgx
                $('#staffdetail_yjfxcjgx').val(data1.yjfxcjgx);
                /*
                * 需要转换显示
                * */
                //passport_fazhaoriqi
                var unixTimestamp005 = new Date( data1.fazhaoriqi );
                $('#testdatetimepicker005').find("input").val(unixTimestamp005.toLocaleString());
                //passport_huzhaoyouxiaoqi
                var unixTimestamp006 = new Date( data1.huzhaoyouxiaoqi );
                $('#testdatetimepicker006').find("input").val(unixTimestamp006.toLocaleString());
                //passport_yanqi
                var unixTimestamp007 = new Date( data1.yanqi );
                $('#testdatetimepicker007').find("input").val(unixTimestamp007.toLocaleString());

                //刷新全局变量
                staffextend_id = data1.extendid;
                task_id = data1.taskid.id;

                //刷新table

                $('#tb_tasks').bootstrapTable('refresh',opt);
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
    var btn_gengxin = $('#btn_gengxin');


    btn_gengxin.click(function(){
        $.ajax({
            type: "get",
            url: "/staffextend/updateStaffextend",
            async: false,
            data: {'extend_nation': $('#extend_nation').val(),
                'extend_educationle':$('#extend_educationle').val(),
                'extend_zzmianmao':$('#extend_zzmianmao').val(),
                'extend_wgysp':$('#extend_wgysp').val(),
                'passport_ywhuzhao':$('#passport_ywhuzhao').val(),
                'passport_huzhaozhonglei':$('#passport_huzhaozhonglei').val(),
                'passport_huzhaohao':$('#passport_huzhaohao').val(),
                'extend_bysjbyyx':$('#extend_bysjbyyx').val(),
                'task_swscmxm':$('#task_swscmxm').val(),
                'task_swscmdh':$('#task_swscmdh').val(),
                'passport_beizhu':$('#passport_beizhu').val(),
                'staffdetail_yjfxcjgx':$('#staffdetail_yjfxcjgx').val(),
                'passport_fazhaoriqi':$('#testdatetimepicker005').find("input").val(),
                'passport_huzhaoyouxiaoqi':$('#testdatetimepicker006').find("input").val(),
                'passport_yanqi':$('#testdatetimepicker007').find("input").val(),
                'staff_id':staff_id
            },
            dataType:"json",
            success: function (data1) {
                alert("更新用户信息完成!");
            },
            error: function () {
                alert("更新用户信息失败!");
            }
        });
    });

    /*
    * 3.测试按钮功能
    *
    * */
    var btn_output = $('#btn_output');
    btn_output.click(function(){
        alert($('#span_temp001').text());
    });

    /*
    * 4.附件填写及上传
    * */

    //情况表
    var btn_tianxie001 = $('#btn_tianxie001');
    var btn_xiugai0001 = $('#btn_xiugai0001');
    var btn_yulan0001 = $('#btn_yulan0001');
    var btn_xiazai0001 = $('#btn_xiazai0001');
    var btn_shanchu0001 = $('#btn_shanchu0001');

    //责任书
    var btn_tianxie002 = $('#btn_tianxie002');
    var btn_xiugai0002 = $('#btn_xiugai0002');
    var btn_yulan0002 = $('#btn_yulan0002');
    var btn_xiazai0002 = $('#btn_xiazai0002');
    var btn_shanchu0002 = $('#btn_shanchu0002');

    //邀请函
    var btn_tianxie003 = $('#btn_tianxie003');
    var btn_xiugai0003 = $('#btn_xiugai0003');
    var btn_yulan0003 = $('#btn_yulan0003');
    var btn_xiazai0003 = $('#btn_xiazai0003');
    var btn_shanchu0003 = $('#btn_shanchu0003');

    //行程安排
    var btn_tianxie004 = $('#btn_tianxie004');
    var btn_xiugai0004 = $('#btn_xiugai0004');
    var btn_yulan0004 = $('#btn_yulan0004');
    var btn_xiazai0004 = $('#btn_xiazai0004');
    var btn_shanchu0004 = $('#btn_shanchu0004');

/*
* 按钮事件
* */

/*
* 责任书.预览
* */
    btn_yulan0002.click(function(){
        //准备测试


    });

/*
* 情况表.填写
* */
    btn_tianxie001.click(function(){
        $.ajax({
            type: "get",
            url: "/staffextend/selectStaffextendByStaffLimit",
            async: false,
            data: {
                'staff_id':staff_id
            },
            dataType:"json",
            success: function (data1) {
                //传递参数，显示变化
                /*
               * data1[0].staffid.name
               *
               * data1[0].staffid.gender
               * data1[0].staffid.birthday
               * data1[0].staffid.birthplace
               *
               * data1[0].nation
               * data1[0].educationle
               * data1[0].qkbzwhzc    职务
               * data1[0].qkbjxhjb    军衔
               * data1[0].zzmianmao   政治面貌
               * data1[0].wgysp       外语水平
               * data1[0].bysjbyyx    毕业情况
               *
               * data1[0].staffid.phone  联系电话
               *
               * 证件号
               *
               * data1[0].ywhuzhao    有无护照
               * data1[0].huzhaohao   护照号
               * data1[0].huzhaoyouxiaoqi  护照效期
               * */

                /*
                * 控件设置只读
                * */
                $('#qkb_name').attr("readonly",true);
                $('#qkb_gender').attr("readonly",true);
                //$('#testdatetimepicker0010').find("span").attr("readonly",true);
                $('#qkb_birthyplace').attr("readonly",true);
                $('#qkb_lxdh').attr("readonly",true);
                $('#qkb_jgzid').attr("readonly",true);

                $('#qkb_name').val(data1[0].staffid.name);
                $('#qkb_gender').val(data1[0].staffid.gender);
               //出生日期
                var testdatetimepicker0010 = new Date(data1[0].staffid.birthyday);
                $('#testdatetimepicker0010').find("input").val(testdatetimepicker0010.toLocaleString());
                $('#qkb_birthyplace').val(data1[0].staffid.birthplace);
                $('#qkb_nation').val(data1[0].nation);
                $('#qkb_educationle').val(data1[0].educationle);
                $('#qkb_zwhzc').val(data1[0].qkbzwhzc);
                $('#qkb_jxhjb').val(data1[0].qkbjxhjb);
                $('#qkb_zzmianmao').val(data1[0].zzmianmao);
                $('#qkb_wgysp').val(data1[0].wgysp);
                $('#qkb_bysjbyyx').val(data1[0].bysjbyyx);
                $('#qkb_lxdh').val(data1[0].staffid.phone);

                $('#qkb_ywhuzhaoc').val(data1[0].ywhuzhao);
                $('#qkb_huzhaohao').val(data1[0].huzhaohao);
                var testdatetimepicker0011 = new Date(data1[0].huzhaoyouxiaoqi);
                $('#testdatetimepicker0011').find("input").val(testdatetimepicker0011.toLocaleString());
               /*
                var unixTimestamp007 = new Date( data1.yanqi );
                $('#testdatetimepicker007').find("input").val(unixTimestamp007.toLocaleString());
               */
                $('#qkb_gzdwzw1').val(data1[0].gzjlcsgzjzw001);
                var testdatetimepicker0012 = new Date(data1[0].gzjlsj001);
                $('#testdatetimepicker0012').find("input").val(testdatetimepicker0012.toLocaleString());
                $('#qkb_gzdwzw2').val(data1[0].gzjlcsgzjzw002);
                var testdatetimepicker0013 = new Date(data1[0].gzjlsj002);
                $('#testdatetimepicker0013').find("input").val(testdatetimepicker0013.toLocaleString());
                $('#qkb_gzdwzw3').val(data1[0].gzjlcsgzjzw003);
                var testdatetimepicker0014 = new Date(data1[0].gzjlsj003);
                $('#testdatetimepicker0014').find("input").val(testdatetimepicker0014.toLocaleString());
                $('#qkb_gzdwzw4').val(data1[0].gzjlcsgzjzw004);
                var testdatetimepicker0015 = new Date(data1[0].gzjlsj004);
                $('#testdatetimepicker0015').find("input").val(testdatetimepicker0015.toLocaleString());
                $('#qkb_gzdwzw5').val(data1[0].gzjlcsgzjzw005);
                var testdatetimepicker0016 = new Date(data1[0].gzjlsj005);
                $('#testdatetimepicker0016').find("input").val(testdatetimepicker0016.toLocaleString());

                $('#qkb_gjjrw001').val(data1[0].cgqkgjjrw001);
                $('#qkb_dwsf001').val(data1[0].cgqkdwsf001);
                var testdatetimepicker0017 = new Date(data1[0].cgqksj001);
                $('#testdatetimepicker0017').find("input").val(testdatetimepicker0017.toLocaleString());
                $('#qkb_gjjrw002').val(data1[0].cgqkgjjrw002);
                $('#qkb_dwsf002').val(data1[0].cgqkdwsf002);
                var testdatetimepicker0018 = new Date(data1[0].cgqksj002);
                $('#testdatetimepicker0018').find("input").val(testdatetimepicker0018.toLocaleString());
                $('#qkb_gjjrw003').val(data1[0].cgqkgjjrw003);
                $('#qkb_dwsf003').val(data1[0].cgqkdwsf003);
                var testdatetimepicker0019 = new Date(data1[0].cgqksj003);
                $('#testdatetimepicker0019').find("input").val(testdatetimepicker0019.toLocaleString());

                $('#qkb_cyxm001').val(data1[0].jtqkxm001);
                $('#qkb_gx001').val(data1[0].jtqkgx001);
                $('#qkb_dwzw001').val(data1[0].jtqkgzjzw001);
                $('#qkb_gw1').val(data1[0].jtqkgwf001);
                $('#qkb_cyxm002').val(data1[0].jtqkxm002);
                $('#qkb_gx002').val(data1[0].jtqkgx002);
                $('#qkb_dwzw002').val(data1[0].jtqkgzjzw002);
                $('#qkb_gw2').val(data1[0].jtqkgwf002);
                $('#qkb_cyxm003').val(data1[0].jtqkxm003);
                $('#qkb_gx003').val(data1[0].jtqkgx003);
                $('#qkb_dwzw003').val(data1[0].jtqkgzjzw003);
                $('#qkb_gw3').val(data1[0].jtqkgwf003);

                $('#qkb_scmxm').val(data1[0].swscmxm);
                $('#qkb_scmdh').val(data1[0].swscmdh);

            },
            error: function () {
                alert("Error");
            }
        });
    });


    /*
* 责任书.填写
* */
    btn_tianxie002.click(function(){
        $.ajax({
            type: "get",
            url: "/baomi/selectBaomiByStaffLimit",
            async: false,
            data: {
                'task_id':task_id
            },
            dataType:"json",
            success: function (data1) {
               //传递参数，显示变化
               /*
               * data1[0].staffid.name    姓名
               * data1[0].huzhaohao   职级
               * data1[0].huzhaoyouxiaoqi  部职别
               * 职务职称
               * 到访国家
               *
               * */

                /*
                * 控件设置只读
                * */
                debugger;
                /*
                $('#qkb_name').attr("readonly",true);
                $('#qkb_gender').attr("readonly",true);
                //$('#testdatetimepicker0010').find("span").attr("readonly",true);
                $('#qkb_birthyplace').attr("readonly",true);
                $('#qkb_lxdh').attr("readonly",true);
                $('#qkb_jgzid').attr("readonly",true);

                var testdatetimepicker0017 = new Date(data1[0].cgqksj001);
                $('#testdatetimepicker0017').find("input").val(testdatetimepicker0017.toLocaleString());
                $('#qkb_gjjrw002').val(data1[0].cgqkgjjrw002);
                $('#qkb_dwsf002').val(data1[0].cgqkdwsf002);
                var testdatetimepicker0018 = new Date(data1[0].cgqksj002);
                $('#testdatetimepicker0018').find("input").val(testdatetimepicker0018.toLocaleString());
                $('#qkb_gjjrw003').val(data1[0].cgqkgjjrw003);
                $('#qkb_dwsf003').val(data1[0].cgqkdwsf003);
                var testdatetimepicker0019 = new Date(data1[0].cgqksj003);
                $('#testdatetimepicker0019').find("input").val(testdatetimepicker0019.toLocaleString());

                $('#qkb_cyxm001').val(data1[0].jtqkxm001);
                $('#qkb_gx001').val(data1[0].jtqkgx001);
                $('#qkb_dwzw001').val(data1[0].jtqkgzjzw001);
                $('#qkb_gw1').val(data1[0].jtqkgwf001);
                $('#qkb_cyxm002').val(data1[0].jtqkxm002);
                $('#qkb_gx002').val(data1[0].jtqkgx002);
                $('#qkb_dwzw002').val(data1[0].jtqkgzjzw002);
                $('#qkb_gw2').val(data1[0].jtqkgwf002);
                $('#qkb_cyxm003').val(data1[0].jtqkxm003);
                $('#qkb_gx003').val(data1[0].jtqkgx003);
                $('#qkb_dwzw003').val(data1[0].jtqkgzjzw003);
                $('#qkb_gw3').val(data1[0].jtqkgwf003);

                $('#qkb_scmxm').val(data1[0].swscmxm);
                $('#qkb_scmdh').val(data1[0].swscmdh);
                */
            },
            error: function () {
                alert("Error");
            }
        });
    });


    /*
    * 出国、赴港澳人员情况表.完成
    *
    * */
    var btn_wancheng005 = $('#btn_wancheng005');
    btn_wancheng005.click(function(){
        $.ajax({
            type: "get",
            url: "/staffextend/updateStaffextend",
            async: false,
            data: {
                'extend_nation':$('#qkb_nation').val(),
                'extend_educationle':$('#qkb_educationle').val(),
                'extend_qkbzwhzc':$('#qkb_zwhzc').val(),
                'extend_qkbjxhjb':$('#qkb_jxhjb').val(),
                'extend_zzmianmao':$('#qkb_zzmianmao').val(),
                'extend_wgysp':$('#qkb_wgysp').val(),
                'extend_bysjbyyx':$('#qkb_bysjbyyx').val(),
                'extend_ywhuzhao':$('#qkb_ywhuzhaoc').val(),
                'passport_huzhaohao':$('#qkb_huzhaohao').val(),
                'passport_huzhaoyouxiaoq':$('#testdatetimepicker0011').find("input").val(),
                'extend_gzjlcsgzjzw001':$('#qkb_gzdwzw1').val(),
                'extend_gzjlsj001':$('#testdatetimepicker0012').find("input").val(),
                'extend_gzjlcsgzjzw002':$('#qkb_gzdwzw2').val(),
                'extend_gzjlsj002':$('#testdatetimepicker0013').find("input").val(),
                'extend_gzjlcsgzjzw003':$('#qkb_gzdwzw3').val(),
                'extend_gzjlsj003':$('#testdatetimepicker0014').find("input").val(),
                'extend_gzjlcsgzjzw004':$('#qkb_gzdwzw4').val(),
                'extend_gzjlsj004':$('#testdatetimepicker0015').find("input").val(),
                'extend_gzjlcsgzjzw005':$('#qkb_gzdwzw5').val(),
                'extend_gzjlsj005':$('#testdatetimepicker0016').find("input").val(),
                'extend_cgqkgjjrw001':$('#qkb_gjjrw001').val(),
                'extend_cgqkdwsf001':$('#qkb_dwsf001').val(),
                'extend_cgqksj001':$('#testdatetimepicker0017').find("input").val(),
                'extend_cgqkgjjrw002':$('#qkb_gjjrw002').val(),
                'extend_cgqkdwsf002':$('#qkb_dwsf002').val(),
                'extend_cgqksj002':$('#testdatetimepicker0018').find("input").val(),
                'extend_cgqkgjjrw003':$('#qkb_gjjrw003').val(),
                'extend_cgqkdwsf003':$('#qkb_dwsf003').val(),
                'extend_cgqksj003':$('#testdatetimepicker0019').find("input").val(),
                'extend_jtqkxm001':$('#qkb_cyxm001').val(),
                'extend_jtqkgx001':$('#qkb_gx001').val(),
                'extend_jtqkgzjzw001':$('#qkb_dwzw001').val(),
                'extend_jtqkgwf001':$('#qkb_gw1').val(),
                'extend_jtqkxm002':$('#qkb_cyxm002').val(),
                'extend_jtqkgx002':$('#qkb_gx002').val(),
                'extend_jtqkgzjzw002':$('#qkb_dwzw002').val(),
                'extend_jtqkgwf002':$('#qkb_gw2').val(),
                'extend_jtqkxm003':$('#qkb_cyxm003').val(),
                'extend_jtqkgx003':$('#qkb_gx003').val(),
                'extend_jtqkgzjzw003':$('#qkb_dwzw003').val(),
                'extend_jtqkgwf003':$('#qkb_gw3').val(),
                'task_swscmxm':$('#qkb_scmxm').val(),
                'task_swscmdh':$('#qkb_scmdh').val(),
                'staff_id':staff_id
            },
            dataType:"json",
            success: function (data1) {
                //传递参数，显示变化
                debugger;
            },
            error: function () {
                alert("Error");
            }
        });
    });

    /*
    * btn_yulan0001
    * 出国、赴港澳人员情况表.预览
    * */
    btn_yulan0001.click(function(){
        $.ajax({
            type: "get",
            url: "/staffextend/outputQkb",
            async: false,
            data: {
                'staff_id':staff_id
            },
            dataType:"json",
            success: function (data1) {
                //传递参数，显示变化
                //alert("/outputfiles/word/" + data1);
            },
            error: function () {
                alert("Error");
            }
        });
    });

/*
* btn_xiazai0001
* 出国、赴港澳人员情况表.下载
*
* */

    btn_xiazai0001.click(function(){
        window.open("/outputfiles/word/sqrycgqkb-21-20181116161236.doc");
    });

    /*
    * btn_shanchu0001
    * 出国、赴港澳人员情况表.删除
    * */
    btn_shanchu0001.click(function(){
        $.ajax({
            type: "get",
            url: "/staffextend/updateStaffextend",
            async: false,
            data: {
                /*
                'extend_nation':'',
                'extend_educationle':'',
                'extend_qkbzwhzc':'',
                'extend_qkbjxhjb':'',
                'extend_zzmianmao':'',
                'extend_wgysp':'',
                'extend_bysjbyyx':'',
                'extend_ywhuzhao':'',
                'passport_huzhaohao':'',
                'passport_huzhaoyouxiaoq':'',
                'extend_gzjlcsgzjzw001':'',
                'extend_gzjlsj001':'',
                'extend_gzjlcsgzjzw002':'',
                'extend_gzjlsj002':'',
                'extend_gzjlcsgzjzw003':'',
                'extend_gzjlsj003':'',
                'extend_gzjlcsgzjzw004':'',
                'extend_gzjlsj004':'',
                'extend_gzjlcsgzjzw005':'',
                'extend_gzjlsj005':'',
                'extend_cgqkgjjrw001':'',
                'extend_cgqkdwsf001':'',
                'extend_cgqksj001':'',
                'extend_cgqkgjjrw002':'',
                'extend_cgqkdwsf002':'',
                'extend_cgqksj002':'',
                'extend_cgqkgjjrw003':'',
                'extend_cgqkdwsf003':'',
                'extend_cgqksj003':'',
                'extend_jtqkxm001':'',
                'extend_jtqkgx001':'',
                'extend_jtqkgzjzw001':'',
                'extend_jtqkgwf001':'',
                'extend_jtqkxm002':'',
                'extend_jtqkgx002':'',
                'extend_jtqkgzjzw002':'',
                'extend_jtqkgwf002':'',
                'extend_jtqkxm003':'',
                'extend_jtqkgx003':'',
                'extend_jtqkgzjzw003':'',
                'extend_jtqkgwf003':'',
                'task_swscmxm':'',
                'task_swscmdh':'',
                */
                'staff_id':staff_id
            },
            dataType:"json",
            success: function (data1) {
                //传递参数，显示变化
                debugger;
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
            url: '/task/selectAllTask', //请求后台的URL（*）
            //contextMenu: '#example1-context-menu',
            method: 'get', //请求方式（*）
            dataType: "json",
            toolbar: '#toolbar', //工具按钮用哪个容器
            striped: true, //是否显示行间隔色
            cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true, //是否显示分页（*）
            sortable: true, //是否启用排序
            sortOrder: "asc", //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
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

