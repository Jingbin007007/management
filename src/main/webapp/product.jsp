<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>病理申请信息页</title>
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

  <script src="js/custom.js"></script>
  <script src="js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
  <script src="js/jquery-ui-1.9.2.custom.min.js"></script> <!-- jQuery UI -->

  <script src="js/tableExport.js"></script>
  <script src="js/product.js"></script>


  <script>
      var tempObj = new Array();
      var tempObj001 = new Array();
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
          <li><a href="#"><i class="icon-list-alt"></i> 申请单 </a></li>
          <li><a href="medicalRecord.html"><i class="icon-list-alt"></i> 病历详情 </a></li>
        </ul>
      </li>
      <li class="has_sub"><a href="#"><i class="icon-file-alt"></i> 列表信息 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="eqpatientinfo.jsp"><i class="icon-list-alt"></i> 患者列表 </a></li>
          <li><a href="patientappli.jsp"><i class="icon-list-alt"></i> 申请列表 </a></li>
          <li><a href="acceptsample.jsp"><i class="icon-list-alt"></i> 样本列表 </a></li>
          <li><a href="product.jsp"><i class="icon-list-alt"></i> 切片列表 </a></li>
          <li><a href="#"><i class="icon-list-alt"></i> 图文报告 </a></li>
          <li><a href="#"><i class="icon-list-alt"></i> 会诊列表 </a></li>
        </ul>
      </li>
      <li class="has_sub"><a href="#"><i class="icon-file-alt"></i> 取材制片<span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="patientsample.jsp"><i class="icon-list-alt"></i> 取材及组织处理 </a></li>
          <li><a href="slicingDesign.jsp"><i class="icon-list-alt"></i> 切片设计 </a></li>
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
          <li><a href="#"><i class="icon-list-alt"></i> 阅片诊断 </a></li>
          <li><a href="diagnosticDetails.html"><i class="icon-list-alt"></i> 诊断详情 </a></li>
        </ul>
      </li>
      <li class="has_sub"><a href="#"><i class="icon-tasks"></i> 报告管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="#"><i class="icon-list-alt"></i> 报告管理 </a></li>
          <li><a href="#"><i class="icon-list-alt"></i> 报告预览 </a></li>
        </ul>
      </li>
      <li class="has_sub"><a href="#"><i class="icon-magic"></i> 质控管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="#"><i class="icon-list-alt"></i> 质控管理 </a></li>
        </ul>
      </li>
      <li class="has_sub"><a href="#"><i class="icon-calendar"></i> 参数配置 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
        <ul>
          <li><a href="#"><i class="icon-list-alt"></i> 字典维护 </a></li>
          <li><a href="#"><i class="icon-list-alt"></i> 检查项目 </a></li>
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
                    <div class="pull-left">切片信息列表</div>
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
                              <label class="control-label col-sm-1" for="txt_search_productno">切片编号</label>
                              <div class="col-sm-2">
                                <input type="text" class="form-control" id="txt_search_productno">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_specialrequire">特殊要求</label>
                              <div class="col-sm-2">
                                <input type="text" class="form-control" id="txt_search_specialrequire">
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_productstatus">制片状态</label>
                              <div class="col-sm-2">
                                <select id="txt_search_productstatus" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择制片状态'></select>
                              </div>
                              <label class="control-label col-sm-1" for="txt_search_patientname">患者姓名</label>
                              <div class="col-sm-2">
                                <select id="txt_search_patientname" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择患者姓名'></select>
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="txt_search_applino">病&nbsp&nbsp理&nbsp&nbsp号</label>
                              <div class="col-sm-2">
                                <input type="text" class="form-control" id="txt_search_applino">
                              </div>
                              <label class="control-label col-sm-1" for="datetimepicker1">制片日期</label>
                              <div id="datetimepicker1" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="txt_search_productdate001">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                              <div id="datetimepicker2" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="txt_search_productdate002">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                            </div>


                            <div class="form-group" style="margin-top:15px">
                              <div class="btn-group">
                                <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">&nbsp&nbsp查&nbsp&nbsp&nbsp&nbsp询&nbsp&nbsp</button>
                                <button type="button" id="btn_output" class="btn btn-success">&nbsp&nbsp导&nbsp&nbsp&nbsp&nbsp出&nbsp&nbsp</button>
                                <button type="button" id="btn_finish" class="btn btn-danger">制片完成</button>
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
            <p class="copy">Copyright &copy; 2018 | <a href="#">蓝创公司</a> </p>
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
        <form class="form-horizontal">
          <!-- Matter -->
          <div class="matter">
            <div class="container">
              <div class="row">
                <!-- post sidebar -->
                <!--
                <ul id="myTab" class="nav nav-tabs">
                  <li class="active"><a href="#home" data-toggle="tab">整体观察记录</a></li>
                </ul>
                -->
                <div id="myTabContent" class="tab-content">
                  <!--------------------------home-------------------------------->
                  <div class="tab-pane fade in active" id="home">
                    <div class="col-sm-11">
                      <input type="hidden" id="idsample">
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--制片要求-->
                      <label class="control-label col-sm-1" for="txt_search_zhipianyaoqiu">制片要求</label>
                      <div class="col-sm-9">
                        <select id="txt_search_zhipianyaoqiu" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择制片要求'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--制片时间-->
                      <label class="control-label col-sm-1" for="txt_search_zhipianshijian">制片时间</label>
                      <div class="col-sm-9">
                        <input type="text" class="form-control" id="txt_search_zhipianshijian">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--存放位置-->
                      <label class="control-label col-sm-1" for="txt_search_cunfangweizhi">存放位置</label>
                      <div class="col-sm-9">
                        <input type="text" class="form-control" id="txt_search_cunfangweizhi">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--制片质量-->
                      <label class="control-label col-sm-1" for="txt_search_zhipianzhiliang">制片质量</label>
                      <div class="col-sm-3">
                        <select id="txt_search_zhipianzhiliang" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择制片质量'></select>
                      </div>
                      <!--不合格理由-->
                      <label class="control-label col-sm-1" for="txt_search_buhegeliyou">不合格理由</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_buhegeliyou">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--意见建议-->
                      <label class="control-label col-sm-1" for="txt_search_yijianjianyi">意见建议</label>
                      <div class="col-sm-9">
                        <select id="txt_search_yijianjianyi" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择意见建议'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!-----------------------照片上传-------------------------------->
                      <label class="control-label col-sm-1" for="pic-upload-b1">照片上传</label>
                      <div class="col-sm-10">
                        <div id="toolbar0022" class="btn-group">
                          <button id="btn_add001" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                          </button>
                          <button id="btn_sub001" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
                          </button>
                        </div>
                      </div>
                    </div>
                    <!---------------------------照片上传-------------------------------->
                    <div id="pics">
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
                    </div>
                    <!-- Matter ends -->
                  </div>
                </div>
              </div>
            </div>
          </div>
      </form>
      </div>
    </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id="allsave123">Save</button>
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
                productno:$("#txt_search_productno").val(),
                applino:$("#txt_search_applino").val(),
                patientname:$("#txt_search_patientname").val(),
                specialrequire:$("#txt_search_specialrequire").val(),
                productstatus:$("#txt_search_productstatus").val(),
                productdate001:$("#txt_search_productdate001").val(),
                productdate002:$("#txt_search_productdate002").val(),
                sortName:"productno",
                sortOrder:"asc"
            }

        };
        $('#tb_tasks').bootstrapTable('refresh',opt);
    });
</script>
</body>
</html>