<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>兽药质量标准检索页面</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="">

  <link href="style/bootstrap.css" rel="stylesheet">
  <!--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">-->
  <link href="style/fileinput.css" rel="stylesheet" type="text/css"/>
  <link href="style/font-awesome.css" media="all" rel="stylesheet" type="text/css"/>

  <link rel="stylesheet" href="style/bootstrap-select.css">
  <!-- Stylesheets -->
  <!--<link href="style/bootstrap.css" rel="stylesheet">-->
  <!-- Font awesome icon -->
  <link rel="stylesheet" href="style/font-awesome.css">

  <!-- Main stylesheet -->
  <link href="style/style.css" rel="stylesheet">
  <!-- Widgets stylesheet -->
  <link href="style/widgets.css" rel="stylesheet">

  <!--将表格列宽设置为可定制-->
  <style type="text/css">
    table {
      table-layout: fixed;
    }
    .vertical-align-center {
      /* To center vertically */
      display: table-cell;
      vertical-align: middle;
      pointer-events:none;
    }
    .modal-content {
      /* Bootstrap sets the size of the modal in the modal-dialog class, we need to inherit it */
      width:inherit;
      max-width:inherit; /* For Bootstrap 4 - to avoid the modal window stretching full width */
      height:inherit;
      /* To center horizontally */
      margin: 0 auto;
      pointer-events: all;
    }
  </style>

  <!-- HTML5 Support for IE -->
  <!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->

  <!-- Favicon -->
  <link rel="shortcut icon" href="img/favicon/favicon.png">
  <link rel="stylesheet" href="style/bootstrap.css">
  <link rel="stylesheet" href="style/bootstrap-table.css">
  <link rel="stylesheet" href="style/bootstrap-editable.css">
  <link href="style/style.css" rel="stylesheet">
  <link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">


  <script src="js/jquery.js"></script> <!-- jQuery -->
  <script src="js/sortable.js" type="text/javascript"></script>
  <script src="js/fileinput.js" type="text/javascript"></script>
  <script src="js/popper.js" type="text/javascript"></script>

  <script src="js/bootstrap-select.js"></script>
  <script src="js/bootstrap.js"></script> <!-- Bootstrap -->

  <script src="js/bootstrap-table.js"></script>
  <script src="js/bootstrap-table-zh-CN.js"></script>
  <script src="js/bootstrap-editable.js"></script>
  <script src="js/bootstrap-table-editable.js"></script>
  <script src="js/bootstrap-table-export.js"></script>
  <script src="js/bootstrap-datetimepicker.min.js"></script>
  <script src="js/custom.js"></script> <!-- Custom codes -->
  <script src="js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
  <script src="js/jquery-ui-1.9.2.custom.min.js"></script> <!-- jQuery UI -->

  <script src="js/tableExport.js"></script>
  <script src="js/userFace001.js"></script>


  <script>
      var tempObj = new Array();
      var tempObj001 = new Array();
  </script>
</head>


<body>

  <header>
    <div class="conjtainer">
      <div class="row">

        <!-- Logo section -->
        <div class="col-md-10">
          <!-- Logo. -->
           <div class="logo">
             <h1 style="text-align:center"><font size="55" face="arial" color="black">兽药质量标准检索系统<span class="bold"></span></font></h1>
             <p class="meta" style="text-align:center;font-size:21px">Veterinary Drug Quality Standard Retrieval System</p>
          </div>
          <!-- Logo ends -->
        </div>


        <!-- Data section -->

        <div class="col-md-2">
          <div class="header-data">

            <!-- Traffic data -->
            <div class="hdata">
              <div class="mcol-left">
                <!-- Icon with red background -->
                <i class="icon-signal bred"></i> 
              </div>
              <div class="mcol-right">
                <!-- Number of visitors -->
                <p><a href="#">7000</a> <em>visits</em></p>
              </div>
              <div class="clearfix"></div>
            </div>


            <!-- revenue data -->
            <div class="hdata">
              <div class="mcol-left">
                <!-- Icon with green background -->
                <i class="icon-money bgreen"></i> 
              </div>
              <div class="mcol-right">
                <!-- Number of visitors -->
                <p><a href="#">5000</a><em>orders</em></p>
              </div>
              <div class="clearfix"></div>
            </div>                        

          </div>
        </div>

      </div>
    </div>
  </header>

<!-- Header ends -->

<!-- Main content starts -->

<div class="content">

  	<!-- Sidebar -->
    <div class="sidebar">
        <div class="sidebar-dropdown"><a href="#">Navigation</a></div>

        <!--- Sidebar navigation -->
        <!-- If the main navigation has sub navigation, then add the class "has_sub" to "li" of main navigation. -->
        <ul id="nav">
          <!-- Main menu with font awesome icon -->
          <li><a href="userFace00all.jsp"><i class="icon-calendar"></i> 全局检索</a></li>
          <li><a href="userFace002import.jsp"><i class="icon-bar-chart"></i> 数据导入</a></li>
          <li><a href="userFace002.jsp" class="open"><i class="icon-table"></i> 化药筛选</a></li>
          <li><a href="userFace002zhongyao.jsp"><i class="icon-tasks"></i> 中药筛选</a></li>
          <li><a href="userFace002shengyao.jsp"><i class="icon-magic"></i> 生药筛选</a></li>
        </ul>
    </div>

    <!-- Sidebar ends -->

  	<!-- Main bar -->
  	<div class="mainbar">

      <!-- Page heading -->
      <div class="page-head">
        <h2 class="pull-left"><i class="icon-table"></i> 检索信息</h2>

        <!-- Breadcrumb -->
        <div class="bread-crumb pull-right">
          <a href="userFace002.jsp"><i class="icon-home"></i> 主页</a>
          <!-- Divider -->
          <span class="divider">/</span> 
          <a href="#" class="bread-current">工作面板</a>
        </div>

        <div class="clearfix"></div>

      </div>
      <!-- Page heading ends -->

	    <!-- Matter -->

	    <div class="matter">
        <div class="container">
          <!-- Table -->

<!--宽度更换为col-12-->
<!--界面中任务列表显示-->
          <!--维修事件列表-->
            <div class="row">
              <div class="col-md-12">
                <div class="widget">
                  <div class="widget-head">
                    <div class="pull-left">检索事件列表</div>
                    <div class="widget-icons pull-right">
                      <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                      <a href="#" class="wclose"><i class="icon-remove"></i></a>
                    </div>
                    <div class="clearfix"></div>
                  </div>



                  <div class="widget-content">
                    <div class="panel-body" style="padding-bottom:0px;">
                      <div class="widget">
                        <div class="widget-head">
                          <div class="pull-left">检索条件</div>
                          <div class="widget-icons pull-right">
                            <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                            <a href="#" class="wclose"><i class="icon-remove"></i></a>
                          </div>
                          <div class="clearfix"></div>
                        </div>
                        <div class="widget-content">
                          <form id="formSearch001" class="form-horizontal">
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_tongyongmingcheng">通用名称</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_tongyongmingcheng">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_yingwenming">英文名称</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_yingwenming">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_laiyuan">来&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp源</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_laiyuan">
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_yuanliao">原&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp料</label>
                              <div class="col-sm-3">
                                <select id="txt_search_yuanliao" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入原料'></select>
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_zhuangtai">状&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp态</label>
                              <div class="col-sm-3">
                                <select id="txt_search_zhuangtai" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入状态'></select>
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_leibie001">一类类别</label>
                              <div class="col-sm-3">
                                <select id="txt_search_leibie001" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入一类类别'></select>
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_leibie002">二类类别</label>
                              <div class="col-sm-3">
                                <select id="txt_search_leibie002" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入二类类别'></select>
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_leibie003">三类类别</label>
                              <div class="col-sm-3">
                                <select id="txt_search_leibie003" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入三类类别'></select>
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_guanlileibie">管理类别</label>
                              <div class="col-sm-3">
                                <select id="txt_search_guanlileibie" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入管理类别'></select>
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_chufangyao">处&nbsp&nbsp方&nbsp&nbsp药</label>
                              <div class="col-sm-3">
                                <select id="txt_search_chufangyao" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入处方药'></select>
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_chengfen">成&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp分</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_chengfen">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_biaozhunguidingguige">标准规格</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_biaozhunguidingguige">
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_biaozhunwaiguige">标外规格</label>
                              <div class="col-sm-3">
                                <select id="txt_search_biaozhunwaiguige" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入标外规格'></select>
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_shiyongduixiang">适用对象</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_shiyongduixiang">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_yongtu">用&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp途</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_yongtu">
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_xianlianghuoxiuyao">限量休药</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_xianlianghuoxiuyao">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_shenbaodanwei">申报单位</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_shenbaodanwei">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_biaozhunyange">标准沿革</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_biaozhunyange">
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_xiuyaoqi">休&nbsp&nbsp药&nbsp&nbsp期</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_xiuyaoqi">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_baocuntiaojian">保存条件</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_baocuntiaojian">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_zhijileibie">制剂类别</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_zhijileibie">
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_fufangyufou">复方与否</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_fufangyufou">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_yuliu001">预&nbsp&nbsp留&nbsp&nbsp一</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_yuliu001">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_yuliu002">预&nbsp&nbsp留&nbsp&nbsp二</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_yuliu002">
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_jinkouyuguochan">进口国产</label>
                              <div class="col-sm-3">
                                <select id="txt_search_jinkouyuguochan" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择进口或国产'></select>
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_beizhu">备&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp注</label>
                              <div class="col-sm-6">
                                <input type="text" class="form-control" id="txt_search_beizhu">
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_pizhunshijian">批准时间</label>
                              <div class="col-sm-3">
                                <select id="txt_search_pizhunshijian" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入批准时间'></select>
                              </div>

                              <label class="control-label col-sm-1" for="datetimepicker1">批准时间</label>
                              <div id="datetimepicker1" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd'" type="text" class="form-control dtpicker" id="txt_search_pizhunriqi1">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                              <div id="datetimepicker2" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd'" type="text" class="form-control dtpicker" id="txt_search_pizhunriqi2">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                              <div class="btn-group">
                                <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                                <button type="button" id="btn_output" class="btn btn-success">导出</button>
                              </div>
                            </div>

                          </form>
                        </div>
                      </div>
                      <div id="toolbar" class="btn-group">
                        <button id="btn_add" type="button" class="btn btn-default">
                          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                        </button>
                        <button id="btn_save" type="button" class="btn btn-default">
                          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>保存
                        </button>
                        <button id="btn_delete" type="button" class="btn btn-default">
                          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
                        </button>
                      </div>
                      <table id="tb_tasks"></table>
                    </div>
                  </div>
                </div>
              </div>
            </div>
        </div>
		  </div>

		<!-- Matter ends -->

    </div>

   <!-- Mainbar ends -->	    	
   <div class="clearfix"></div>

</div>
<!-- Content ends -->


<!-- Footer starts -->
<footer>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
            <!-- Copyright info -->
            <p class="copy">Copyright &copy; 2017 | <a href="#">兽药质量标准检索网</a> </p>
      </div>
    </div>
  </div>
</footer> 	

<!-- Footer ends -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

  <div class="modal-dialog modal-lg vertical-align-center" role="document" style="left:10%">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">预览</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="file-loading">
          <input type="hidden" id="idvalue"></div>
          <!--<input type="hidden" id="pathvalue"></div>-->
          <input id="input-b9" name="input-b9" type="file" class="fileloading">
        </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" title="Your custom upload logic">Save</button>
      </div>
    </div>
  </div>
</div>


<!-- Scroll to top -->
<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span> 


<script>
    //初始化fileinput

    $("#input-b9").fileinput({
        language : 'zh',
        uploadUrl : "/admin/upload/files",
        autoReplace : true,
        maxFileCount : 1,
        allowedFileExtensions : [ "jpg", "png", "gif", "pdf" ],
        browseClass : "btn btn-primary", //按钮样式
        previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
        uploadExtraData : function(previewId, index) {
            var obj = {};
            obj.fileid = $("#idvalue").val();
            //alert(obj.fileid);
            return obj;
        }
    }).on("fileuploaded", function(e, data) {
        var res = data.response;
        debugger;
        var opt = {
            url: '/selectMeds',
            query:{
                pageSize: 10, //页面大小
                pageNumber: 1, //页码

                //筛选参数
                tongyongmingcheng: $("#txt_search_tongyongmingcheng").val(),
                yingwenming: $("#txt_search_yingwenming").val(),
                laiyuan: $("#txt_search_laiyuan").val(),
                yuanliao: $("#txt_search_yuanliao").val(),
                zhuangtai: $("#txt_search_zhuangtai").val(),
                leibie001: $("#txt_search_leibie001").val(),
                leibie002: $("#txt_search_leibie002").val(),
                leibie003: $("#txt_search_leibie003").val(),
                guanlileibie: $("#txt_search_guanlileibie").val(),
                chufangyao: $("#txt_search_chufangyao").val(),
                chengfen: $("#txt_search_chengfen").val(),
                biaozhunguidingguige: $("#txt_search_biaozhunguidingguige").val(),
                biaozhunwaiguige: $("#txt_search_biaozhunwaiguige").val(),
                shiyongduixiang: $("#txt_search_shiyongduixiang").val(),
                yongtu: $("#txt_search_yongtu").val(),
                xianlianghuoxiuyao: $("#txt_search_xianlianghuoxiuyao").val(),
                pizhunshijian: $("#txt_search_pizhunshijian").val(),
                biaozhunyange: $("#txt_search_biaozhunyange").val(),
                beizhu: $("#txt_search_beizhu").val(),

                shenbaodanwei:$("#txt_search_shenbaodanwei").val(),
                baocuntiaojian:$("#txt_search_baocuntiaojiani").val(),
                zhijileibie:$("#txt_search_zhijileibie").val(),
                fufangyufou:$("#txt_search_fufangyufou").val(),
                yuliu001:$("#txt_search_yuliu001").val(),
                yuliu002:$("#txt_search_yuliu002").val(),
                jinkouyuguochan:$("#txt_search_jinkouyuguochan").val(),
                xiuyaoqi:$("#txt_search_xiuyaoqi").val(),
                pizhunriqi1:$("#txt_search_pizhunriqi1").val(),
                pizhunriqi2:$("#txt_search_pizhunriqi2").val(),
                sortName:"id",
                sortOrder:"asc"
            }

        };
        $('#tb_tasks').bootstrapTable('refresh',opt);
    });
</script>
</body>
</html>