<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>取材及组织处理</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="">

  <link href="style/bootstrap.css" rel="stylesheet">
  <!--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">-->
  <link href="style/fileinput.css" rel="stylesheet" type="text/css">
  <link href="style/font-awesome.css" media="all" rel="stylesheet" type="text/css">

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

  <script src="js/custom.js"></script>
  <script src="js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
  <script src="js/jquery-ui-1.9.2.custom.min.js"></script> <!-- jQuery UI -->

  <script src="js/tableExport.js"></script>
  <script src="js/patientsample001.js"></script>
  <script src="js/patientsample002.js"></script>
  <script src="js/patientsample003.js"></script>

  <script>
      var tempObj = new Array();
      var tempObj001 = new Array();
      var main = 1;
      var pic_group0 = 0;
      var pic_group1 = 0;
      var pic_group2 = 0;
      var pic_group3 = 0;
      var pic_group4 = 0;
      var pic_group5 = 0;
      var pic_group6 = 0;
      var pic_group7 = 0;
      var pic_group8 = 0;
      var pic_group9 = 0;
      var pic_groups = new Array();

      //modal传参
      var parameterDesc = null;
      var parameterNo = null;
  </script>
</head>


<body>
<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">
<div class="conjtainer">
  <!-- Menu button for smallar screens -->
  <div class="navbar-header">
    <button class="navbar-toggle btn-navbar" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
      <span>菜单</span>
    </button>
    <!-- Site name for smallar screens -->
    <a href="index.jsp" class="navbar-brand hidden-lg">APIS</a>
  </div>



  <!-- Navigation starts -->
  <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">

    <ul class="nav navbar-nav navbar-left">

      <!-- Upload to server link. Class "dropdown-big" creates big dropdown -->
      <li class="dropdown dropdown-big">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="label label-success"><i class="icon-cloud-upload"></i></span> 上传到云服务器</a>
        <!-- Dropdown -->
        <ul class="dropdown-menu">
          <li>
            <!-- Progress bar -->
            <p>电子档案上传进度</p>
            <!-- Bootstrap progress bar -->
            <div class="progress progress-striped active">
              <div class="progress-bar progress-bar-info"  role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                <span class="sr-only">完成40%</span>
              </div>
            </div>

            <hr />

            <!-- Progress bar -->
            <p>数字切片上传进度</p>
            <!-- Bootstrap progress bar -->
            <div class="progress progress-striped active">
              <div class="progress-bar progress-bar-success"  role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                <span class="sr-only">完成80%</span>
              </div>
            </div>

            <hr />

            <!-- Dropdown menu footer -->
            <div class="drop-foot">
              <a href="#">查看所有</a>
            </div>

          </li>
        </ul>
      </li>

      <!-- Sync to server link -->
      <li class="dropdown dropdown-big">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="label label-danger"><i class="icon-refresh"></i></span> 同步到服务器</a>
        <!-- Dropdown -->
        <ul class="dropdown-menu">
          <li>
            <!-- Using "icon-spin" class to rotate icon. -->
            <p><span class="label label-info"><i class="icon-cloud"></i></span>同步数字切片到服务器</p>
            <hr />
            <p><span class="label label-warning"><i class="icon-cloud"></i></span>同步数字切片到云端</p>

            <hr />

            <!-- Dropdown menu footer -->
            <div class="drop-foot">
              <a href="#">查看所有</a>
            </div>

          </li>
        </ul>
      </li>

    </ul>

    <!-- Search form -->
    <form class="navbar-form navbar-left" role="search">
      <div class="form-group">
        <input type="text" class="form-control" placeholder="Search">
      </div>
    </form>
    <!-- Links -->
    <ul class="nav navbar-nav pull-right">
      <li class="dropdown pull-right">
        <a data-toggle="dropdown" class="dropdown-toggle" href="#" id="dropdown_user_name">
          <i class="icon-user"></i><span></span><b class="caret"></b>
        </a>

        <!-- Dropdown menu -->
        <ul class="dropdown-menu">
          <li><a href="#"><i class="icon-user"></i> 资料</a></li>
          <li><a href="#"><i class="icon-cogs"></i> 设置</a></li>
          <li><a href="login.jsp"><i class="icon-off"></i> 退出</a></li>
        </ul>
      </li>

    </ul>
  </nav>

</div>
</div>


<!-- Header starts -->
<header>
  <div class="container">
    <div class="row">

      <!-- Logo section -->
      <div class="col-md-4">
        <!-- Logo. -->
        <div class="logo">
          <h1><a href="#">APIS<span class="bold"></span></a></h1>
          <p class="meta">业务流管理系统</p>
        </div>
        <!-- Logo ends -->
      </div>

      <!-- Button section -->
      <div class="col-md-4">

        <!-- Buttons -->
        <ul class="nav nav-pills">

          <!-- Comment button with number of latest comments count -->
          <li class="dropdown dropdown-big">
            <a class="dropdown-toggle" href="#" data-toggle="dropdown">
              <i class="icon-comments"></i> 留言 <span class="label label-info">6</span>
            </a>

            <ul class="dropdown-menu">
              <li>
                <!-- Heading - h5 -->
                <h5><i class="icon-comments"></i> 留言</h5>
                <!-- Use hr tag to add border -->
                <hr />
              </li>
              <li>
                <!-- List item heading h6 -->
                <h6><a href="#">你好 :)</a> <span class="label label-warning pull-right">10:42</span></h6>
                <div class="clearfix"></div>
                <hr />
              </li>
              <li>
                <h6><a href="#">你怎么样?</a> <span class="label label-warning pull-right">20:42</span></h6>
                <div class="clearfix"></div>
                <hr />
              </li>
              <li>
                <h6><a href="#">你在干撒呢?</a> <span class="label label-warning pull-right">14:42</span></h6>
                <div class="clearfix"></div>
                <hr />
              </li>
              <li>
                <div class="drop-foot">
                  <a href="#">查看所有</a>
                </div>
              </li>
            </ul>
          </li>

          <!-- Message button with number of latest messages count-->
          <li class="dropdown dropdown-big">
            <a class="dropdown-toggle" href="#" data-toggle="dropdown">
              <i class="icon-envelope-alt"></i> 收件箱 <span class="label label-primary">6</span>
            </a>

            <ul class="dropdown-menu">
              <li>
                <!-- Heading - h5 -->
                <h5><i class="icon-envelope-alt"></i> 消息</h5>
                <!-- Use hr tag to add border -->
                <hr />
              </li>
              <li>
                <!-- List item heading h6 -->
                <h6><a href="#">你好啊?</a></h6>
                <!-- List item para -->
                <p>最近咋样啊...</p>
                <hr />
              </li>
              <li>
                <h6><a href="#">今天很好啊?</a></h6>
                <p>相当好...</p>
                <hr />
              </li>
              <li>
                <div class="drop-foot">
                  <a href="#">查看所有</a>
                </div>
              </li>
            </ul>
          </li>

          <!-- Members button with number of latest members count -->
          <li class="dropdown dropdown-big">
            <a class="dropdown-toggle" href="#" data-toggle="dropdown">
              <i class="icon-user"></i> 用户 <span class="label label-success">6</span>
            </a>

            <ul class="dropdown-menu">
              <li>
                <!-- Heading - h5 -->
                <h5><i class="icon-user"></i> 用户</h5>
                <!-- Use hr tag to add border -->
                <hr />
              </li>
              <li>
                <!-- List item heading h6-->
                <h6><a href="#">Ravi Kumar</a> <span class="label label-warning pull-right">免费</span></h6>
                <div class="clearfix"></div>
                <hr />
              </li>
              <li>
                <h6><a href="#">Balaji</a> <span class="label label-important pull-right">高级</span></h6>
                <div class="clearfix"></div>
                <hr />
              </li>
              <li>
                <h6><a href="#">Kumarasamy</a> <span class="label label-warning pull-right">免费</span></h6>
                <div class="clearfix"></div>
                <hr />
              </li>
              <li>
                <div class="drop-foot">
                  <a href="#">查看所有</a>
                </div>
              </li>
            </ul>
          </li>

        </ul>

      </div>

      <!-- Data section -->

      <div class="col-md-4">
        <div class="header-data">

          <!-- Traffic data -->
          <div class="hdata">
            <div class="mcol-left">
              <!-- Icon with red background -->
              <i class="icon-signal bred"></i>
            </div>
            <div class="mcol-right">
              <!-- Number of visitors -->
              <p><a href="#">7000</a> <em>诊断</em></p>
            </div>
            <div class="clearfix"></div>
          </div>

          <!-- Members data -->
          <div class="hdata">
            <div class="mcol-left">
              <!-- Icon with blue background -->
              <i class="icon-user bblue"></i>
            </div>
            <div class="mcol-right">
              <!-- Number of visitors -->
              <p><a href="#">3000</a> <em>图片</em></p>
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
              <p><a href="#">5000</a><em>样本</em></p>
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
    <div class="sidebar-dropdown"><a href="#">导航</a></div>

    <!--- Sidebar navigation -->
    <!-- If the main navigation has sub navigation, then add the class "has_sub" to "li" of main navigation. -->
    <ul id="nav">
      <!-- Main menu with font awesome icon -->
      <li><a href="index.jsp" class="open"><i class="icon-home"></i> 首页 </a></li>
      <li class="has_sub"><a href="#"><i class="icon-list-alt"></i> 登记管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="patientappli.jsp"><i class="icon-list-alt"></i> 申请签收登记 </a></li>
          <li><a href="widgets2.html"><i class="icon-list-alt"></i> 病历详情 </a></li>
        </ul>
      </li>
      <li class="has_sub"><a href="#"><i class="icon-file-alt"></i> 列表信息 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="eqpatientinfo.jsp"><i class="icon-list-alt"></i> 患者列表 </a></li>
          <li><a href="patientappli.jsp"><i class="icon-list-alt"></i> 申请列表 </a></li>
          <li><a href="acceptsample.jsp"><i class="icon-list-alt"></i> 样本列表 </a></li>
          <li><a href="product.jsp"><i class="icon-list-alt"></i> 切片列表 </a></li>
        </ul>
      </li>
      <li class="has_sub"><a href="#"><i class="icon-file-alt"></i> 取材制片<span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="patientsample.jsp"><i class="icon-list-alt"></i> 取材及组织处理 </a></li>
          <li><a href="product.jsp"><i class="icon-list-alt"></i> 切片管理 </a></li>
        </ul>
      </li>
      <li class="has_sub"><a href="#"><i class="icon-bar-chart"></i> 扫描管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="scan.jsp"><i class="icon-list-alt"></i> 扫描管理 </a></li>
        </ul>
      </li>
      <li class="has_sub"><a href="#"><i class="icon-table"></i> 诊断管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="diagnosis.jsp"><i class="icon-list-alt"></i> 阅片诊断 </a></li>
          <li><a href="#"><i class="icon-list-alt"></i> 诊断详情 </a></li>
        </ul>
      </li>
      <li class="has_sub"><a href="#"><i class="icon-tasks"></i> 报告管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="report.jsp"><i class="icon-list-alt"></i> 报告管理 </a></li>
        </ul>
      </li>
    </ul>
  </div>

  <!-- Sidebar ends -->

  <!-- Main bar -->
  <div class="mainbar">

    <!-- Page heading -->
    <div class="page-head">
      <h2 class="pull-left"><i class="icon-home"></i> 首页</h2>

      <!-- Breadcrumb -->
      <div class="bread-crumb pull-right">
        <a href="index.jsp"><i class="icon-home"></i> 首页</a>
        <!-- Divider -->
        <span class="divider">/</span>
        <a href="#" class="bread-current">患者列表</a>
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
                    <div class="pull-left">取材及组织处理</div>
                    <div class="widget-icons pull-right">
                      <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                      <a href="#" class="wclose"><i class="icon-remove"></i></a>
                    </div>
                    <div class="clearfix"></div>
                  </div>



                  <div class="widget-content">
                    <div class="panel-body" style="padding-bottom:0px;">
                      <div class="widget">
                        <!--<div class="widget-head">
                          <div class="pull-left">检索条件</div>
                          <div class="widget-icons pull-right">
                            <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                            <a href="#" class="wclose"><i class="icon-remove"></i></a>
                          </div>
                          <div class="clearfix"></div>
                        </div>-->
                        <div class="widget-content">
                          <div id="formSearch001" class="form-horizontal">
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_patientname">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_patientname">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_applino">病&nbsp&nbsp理&nbsp&nbsp号</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="txt_search_applino">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_inspmethod">检查方法</label>
                              <div class="col-sm-3">
                                <select id="txt_search_inspmethod" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择检查方法'></select>
                              </div>
                            </div>
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_advicestatus">状&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp态</label>
                              <div class="col-sm-3">
                                <select id="txt_search_advicestatus" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择状态'></select>
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_specialrequire">特殊要求</label>
                              <div class="col-sm-3">
                                <select id="txt_search_specialrequire" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='是否存在特殊要求'></select>
                              </div>
                              <div class="btn-group">
                                <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">查询</button>
                                <button type="button" id="btn_output" class="btn btn-success">导出</button>
                                <button type="button" id="btn_print" class="btn btn-danger">打印</button>
                                <button type="button" id="btn_new" class="btn btn-info">新建</button>
                                <button type="button" id="btn_change" class="btn btn-warning">编辑</button>
                              </div>
                            </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

         <!--第一步 选人--->
                <div class="row">
              <div class="col-md-6">
                <div class="widget">
                  <!--<div class="widget-head">
                    <div class="pull-left">I 选取患者</div>
                    <div class="widget-icons pull-right">
                      <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                      <a href="#" class="wclose"><i class="icon-remove"></i></a>
                    </div>
                    <div class="clearfix"></div>
                  </div>-->
                  <div class="widget-content">
                    <div class="panel-body" style="padding-bottom:0px;">
                      <div id="toolbar" class="btn-group">
                        <button id="btn_trans001" type="button" class="btn btn-default">
                          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>选取
                        </button>
                      </div>
                      <table id="tb_tasks"></table>
                    </div>
                  </div>
                </div>
              </div>
                <!--第二步 选标本--->
                <div class="col-md-6">
                  <div class="widget">
                    <!--<div class="widget-head">
                      <div class="pull-left">II 选取标本</div>
                      <div class="widget-icons pull-right">
                        <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                        <a href="#" class="wclose"><i class="icon-remove"></i></a>
                      </div>
                      <div class="clearfix"></div>
                    </div>-->
                    <div class="widget-content">
                      <div class="panel-body" style="padding-bottom:0px;">
                        <div id="toolbar2" class="btn-group">
                          <button id="btn_trans002" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>选取
                          </button>
                        </div>
                        <table id="tb_tasks002"></table>
                      </div>
                    </div>
                  </div>
                </div>
                </div>
                <!--第三步 取材操作--->
                <div class="row">
                <div class="col-md-12">
                  <div class="widget">
                    <!--<div class="widget-head">
                      <div class="pull-left">III 取材操作</div>
                      <div class="widget-icons pull-right">
                        <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                        <a href="#" class="wclose"><i class="icon-remove"></i></a>
                      </div>
                      <div class="clearfix"></div>
                    </div>-->
                    <div class="widget-content">
                      <div class="panel-body" style="padding-bottom:0px;">
                        <table id="tb_tasks003"></table>
                      </div>
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
            <p class="copy">Copyright &copy; 2018 | <a href="#">蓝创公司</a> </p>
      </div>
    </div>
  </div>
</footer> 	

<!-- 模态图片窗体 -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">

  <div class="modal-dialog modal-lg vertical-align-center" role="document" style="left:10%">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">备注</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <textarea class="form-control" rows="3" placeholder="Textarea" id="txt_beizhu"></textarea>
        <input type="hidden" id="idvalue"></div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" title="保存" id="savemodal">保存</button>
      </div>
    </div>
  </div>
</div>


<!-----------------------------取材记录表---------------------------------->
<!--弹出对话框-->
<div id="myModal1" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title">记录</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
          <!-- Matter -->
          <div class="matter">
            <div class="container">
              <div class="row">
                <!-- post sidebar -->
                <ul id="myTab" class="nav nav-tabs">
                  <li class="active"><a href="#home" data-toggle="tab">整体观察记录</a></li>
                  <li><a href="#nav1" data-toggle="tab">取材记录</a></li>
                </ul>

                <div id="myTabContent" class="tab-content">
                  <!--------------------------home-------------------------------->
                  <div class="tab-pane fade in active" id="home">
                      <div class="col-sm-11">
                          <input type="hidden" id="idsample">
                      </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--避标本部位-->
                      <label class="control-label col-sm-1" for="txt_search_biaobenbuwei">标本部位</label>
                      <div class="col-sm-11">
                        <input type="text" class="form-control" id="txt_search_biaobenbuwei" readonly>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="txt_search_rouyanguancha">肉眼观察</label>
                      <div class="col-sm-11">
                    <textarea class="form-control" rows="3" placeholder="Textarea"
                              id="txt_search_rouyanguancha"></textarea>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="txt_search_biaobenchuli">标本处理</label>
                      <div class="col-sm-11">
                      <select id="txt_search_biaobenchuli" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择标本处理'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!-----------------------照片上传-------------------------------->
                      <label class="control-label col-sm-1" for="pic-upload-b1">照片上传</label>
                      <div class="col-sm-10">
                      <div id="toolbar0022" class="btn-group">
                        <button id="btn_add" type="button" class="btn btn-default">
                          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                        </button>
                        <button id="btn_sub" type="button" class="btn btn-default">
                          <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                        </button>
                      </div>
                      </div>
                    </div>
                    <!---------------------------照片上传-------------------------------->
                    <div class="form-group" style="margin-top:15px"  id="span-1">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu1"></textarea>
                      </div>
                      <div class="col-sm-6">
                          <input id="pic-upload-b1" name="pic-upload-b1" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px"  id="span-2">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu2"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b2" name="pic-upload-b2" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px"  id="span-3">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu3"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b3" name="pic-upload-b3" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px"  id="span-4">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu4"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b4" name="pic-upload-b4" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px"  id="span-5">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu5"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b5" name="pic-upload-b5" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px"  id="span-6">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu6"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b6" name="pic-upload-b6" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px"  id="span-7">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu7"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b7" name="pic-upload-b7" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px"  id="span-8">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu8"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b8" name="pic-upload-b8" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-9">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu9"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b9" name="pic-upload-b9" type="file" class="file">
                      </div>
                    </div>
                    <!-- Matter ends -->
                  </div>



                  <!--------------------------nav1---------------------------->
                  <div class="tab-pane fade" id="nav1">
                    <div class="form-group" style="margin-top:15px">
                      <div class="col-sm-10">
                        <div id="toolbar000" class="btn-group">
                          <button id="btn_add0" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub0" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <hr>

                    <div class="form-group" style="margin-top:15px" id="span-10">
                      <div class="col-sm-10">
                        <div id="toolbar001" class="btn-group">
                          <button id="btn_add1" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub1" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-11">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu11"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b11" name="pic-upload-b11" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-12">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu12"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b12" name="pic-upload-b12" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-13">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu13"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b13" name="pic-upload-b13" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-14">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu14"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b14" name="pic-upload-b14" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-15">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu15"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b15" name="pic-upload-b15" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-16">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu16"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b16" name="pic-upload-b16" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-17">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu17"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b17" name="pic-upload-b17" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-18">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu18"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b18" name="pic-upload-b18" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-19">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu19"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b19" name="pic-upload-b19" type="file" class="file">
                      </div>
                    </div>

                    <!--------------------------2-------------------->
                    <div class="form-group" style="margin-top:15px" id="span-20">
                      <div class="col-sm-10">
                        <div id="toolbar002" class="btn-group">
                          <button id="btn_add2" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub2" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-21">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu21"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b21" name="pic-upload-b21" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-22">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu22"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b22" name="pic-upload-b22" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-23">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu23"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b23" name="pic-upload-b23" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-24">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu24"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b24" name="pic-upload-b24" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-25">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu25"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b25" name="pic-upload-b25" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-26">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu26"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b26" name="pic-upload-b26" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-27">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu27"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b27" name="pic-upload-b27" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-28">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu28"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b28" name="pic-upload-b28" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-29">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu29"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b29" name="pic-upload-b29" type="file" class="file">
                      </div>
                    </div>

                    <!-----------------------3----------------------->
                    <div class="form-group" style="margin-top:15px" id="span-30">
                      <div class="col-sm-10">
                        <div id="toolbar003" class="btn-group">
                          <button id="btn_add3" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub3" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-31">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu31"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b31" name="pic-upload-b31" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-32">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu32"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b32" name="pic-upload-b32" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-33">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu33"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b33" name="pic-upload-b33" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-34">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu34"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b34" name="pic-upload-b34" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-35">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu35"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b35" name="pic-upload-b35" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-36">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu36"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b36" name="pic-upload-b36" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-37">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu37"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b37" name="pic-upload-b37" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-38">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu38"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b38" name="pic-upload-b38" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-39">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu39"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b39" name="pic-upload-b39" type="file" class="file">
                      </div>
                    </div>
                    <!-----------------------4----------------------->
                    <div class="form-group" style="margin-top:15px" id="span-40">
                      <div class="col-sm-10">
                        <div id="toolbar004" class="btn-group">
                          <button id="btn_add4" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub4" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-41">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu41"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b41" name="pic-upload-b41" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-42">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu42"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b42" name="pic-upload-b42" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-43">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu43"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b43" name="pic-upload-b43" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-44">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu44"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b44" name="pic-upload-b44" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-45">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu45"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b45" name="pic-upload-b45" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-46">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu46"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b46" name="pic-upload-b46" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-47">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu47"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b47" name="pic-upload-b47" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-48">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu48"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b48" name="pic-upload-b48" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-49">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu49"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b49" name="pic-upload-b49" type="file" class="file">
                      </div>
                    </div>
                    <!-----------------------5----------------------->
                    <div class="form-group" style="margin-top:15px" id="span-50">
                      <div class="col-sm-10">
                        <div id="toolbar005" class="btn-group">
                          <button id="btn_add5" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub5" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-51">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu51"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b51" name="pic-upload-b51" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-52">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu52"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b52" name="pic-upload-b52" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-53">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu53"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b53" name="pic-upload-b53" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-54">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu54"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b54" name="pic-upload-b54" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-55">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu55"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b55" name="pic-upload-b55" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-56">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu56"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b56" name="pic-upload-b56" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-57">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu57"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b57" name="pic-upload-b57" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-58">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu58"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b58" name="pic-upload-b58" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-59">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu59"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b59" name="pic-upload-b59" type="file" class="file">
                      </div>
                    </div>
                    <!-----------------------6----------------------->
                    <div class="form-group" style="margin-top:15px" id="span-60">
                      <div class="col-sm-10">
                        <div id="toolbar006" class="btn-group">
                          <button id="btn_add6" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub6" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-61">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu61"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b61" name="pic-upload-b61" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-62">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu62"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b62" name="pic-upload-b62" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-63">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu63"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b63" name="pic-upload-b63" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-64">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu64"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b64" name="pic-upload-b64" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-65">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu65"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b65" name="pic-upload-b65" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-66">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu66"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b66" name="pic-upload-b66" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-67">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu67"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b67" name="pic-upload-b67" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-68">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu68"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b68" name="pic-upload-b68" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-69">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu69"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b69" name="pic-upload-b69" type="file" class="file">
                      </div>
                    </div>
                    <!-----------------------7----------------------->
                    <div class="form-group" style="margin-top:15px" id="span-70">
                      <div class="col-sm-10">
                        <div id="toolbar007" class="btn-group">
                          <button id="btn_add7" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub7" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-71">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu71"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b71" name="pic-upload-b71" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-72">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu72"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b72" name="pic-upload-b72" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-73">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu73"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b73" name="pic-upload-b73" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-74">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu74"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b74" name="pic-upload-b74" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-75">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu75"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b75" name="pic-upload-b75" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-76">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu76"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b76" name="pic-upload-b76" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-77">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu77"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b77" name="pic-upload-b77" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-78">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu78"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b78" name="pic-upload-b78" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-79">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu79"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b79" name="pic-upload-b79" type="file" class="file">
                      </div>
                    </div>
                    <!-----------------------8----------------------->
                    <div class="form-group" style="margin-top:15px" id="span-80">
                      <div class="col-sm-10">
                        <div id="toolbar008" class="btn-group">
                          <button id="btn_add8" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub8" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-81">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu81"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b81" name="pic-upload-b81" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-82">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu82"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b82" name="pic-upload-b82" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-83">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu83"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b83" name="pic-upload-b83" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-84">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu84"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b84" name="pic-upload-b84" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-85">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu85"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b85" name="pic-upload-b85" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-86">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu86"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b86" name="pic-upload-b86" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-87">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu87"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b87" name="pic-upload-b87" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-88">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu88"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b88" name="pic-upload-b88" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-89">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu89"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b89" name="pic-upload-b89" type="file" class="file">
                      </div>
                    </div>
                    <!-----------------------9----------------------->
                    <div class="form-group" style="margin-top:15px" id="span-90">
                      <div class="col-sm-10">
                        <div id="toolbar009" class="btn-group">
                          <button id="btn_add9" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub9" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-91">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu91"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b91" name="pic-upload-b91" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-92">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu92"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b92" name="pic-upload-b92" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-93">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu93"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b93" name="pic-upload-b93" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-94">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu94"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b94" name="pic-upload-b94" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-95">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu95"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b95" name="pic-upload-b95" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-96">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu96"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b96" name="pic-upload-b96" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-97">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu97"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b97" name="pic-upload-b97" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-98">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu98"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b98" name="pic-upload-b98" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px" id="span-99">
                      <div class="col-sm-5">
                    <textarea class="form-control" rows="2" placeholder="Textarea"
                              id="txt_search_zhaopianmiaoshu99"></textarea>
                      </div>
                      <div class="col-sm-6">
                        <input id="pic-upload-b99" name="pic-upload-b99" type="file" class="file">
                      </div>
                    </div>
                    <br>
                  </div>
                  <br>
                  <hr>
                  <div class="form-group" style="margin-top:15px" id="span-101">
                    <button type="button" style="margin-left:50px" id="btn_submit" class="btn btn-primary">上传</button>
                    <button type="button" id="btn_cancel" class="btn btn-success" data-dismiss="modal">取消</button>
                  </div>
                </div>
              </div>
              </div>
            </div>
        </form>
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
            url: '/selectPatientinfo',
            query:{
                pageSize: 10, //页面大小
                pageNumber: 1, //页码

                //筛选参数
                hospitalizetionid: $("#txt_search_hospitalizetionid").val(),
                applino: $("#txt_search_applino").val(),
                inspmethod: $("#txt_search_inspmethod").val(),
                patientdiagkind: $("#txt_search_patientdiagkind").val(),
                inspdepartid: $("#txt_search_inspdepartid").val(),
                specialrequire: $("#txt_search_specialrequire").val(),
                inspdate001: $("#txt_search_inspdate001").val(),
                inspdate002: $("#txt_search_inspdate002").val(),
                acceptdate001: $("#txt_search_acceptdate001").val(),
                acceptdate002: $("#txt_search_acceptdate002").val(),
                sortName:"applino",
                sortOrder:"asc"
            }

        };
        $('#tb_tasks').bootstrapTable('refresh',opt);
    });
</script>
</body>
</html>