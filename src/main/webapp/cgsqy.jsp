<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>出国(境)申请详情页</title>
  <link href="img/icons/title.png" rel="SHORTCUT ICON" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="">

  <link href="style/bootstrap.css" rel="stylesheet">
  <!--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">-->
  <link href="style/fileinput.css" rel="stylesheet" type="text/css"/>
  <link href="style/font-awesome.css" media="all" rel="stylesheet" type="text/css"/>
  <link href="img/icons/title.png" rel="SHORTCUT ICON" />

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
  <script src="js/patientappli.js"></script>
  <script src="js/address.js"></script>

  <script>
      var tempObj = new Array();
      var tempObj001 = new Array();
      var temp_change = true;
      var tempJianchafangfa = "";
  </script>
</head>


<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">
  <div class="conjtainer">
    <!-- Menu button for smallar screens -->
    <div class="navbar-header">
      <button class="navbar-toggle btn-navbar" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
        <span>菜单</span>
      </button>
      <!-- Site name for smallar screens -->
      <a href="index.jsp" class="navbar-brand hidden-lg">军事医学研究院出国人员审批系统</a>
    </div>



    <!-- Navigation starts -->
    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">

      <ul class="nav navbar-nav navbar-left">

      </ul>


      <!-- Links -->
      <ul class="nav navbar-nav pull-right">
        <li class="dropdown pull-right">
          <a data-toggle="dropdown" class="dropdown-toggle" href="#" id="dropdown_user_name">
            <i class="icon-user"></i><span></span><b class="caret"></b>
          </a>

          <!-- Dropdown menu -->
          <ul class="dropdown-menu">
            <li><a href="#"><i class="icon-user"></i> 资料</a></li>
            <%--<li><a href="#"><i class="icon-cogs"></i> 设置</a></li>--%>
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
          <h3>军事医学研究院出国(境)人员申请系统<span class="bold"></span></h3>
          <%--<p class="meta">业务流管理系统</p>--%>
        </div>
        <!-- Logo ends -->
      </div>

      <!-- Button section -->
      <div class="col-md-4">
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
      <li><a href="#" class="has_sub"><i class="icon-list-alt"></i> 公告 </a></li>
      <%--<li><a href="index.jsp" class="open"><i class="icon-home"></i> 首页 </a></li>--%>

      <li class="has_sub"><a href="#"><i class="icon-list-alt"></i> 出国(境)申请 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
      <ul>
        <li><a href="patientappli.jsp"><i class="icon-list-alt"></i> 出国(境)申请登记表 </a></li>
      <%--<li><a href="widgets2.html"><i class="icon-list-alt"></i> 病历详情 </a></li>--%>
      </ul>
      </li>
    </ul>
  </div>

  <!-- Sidebar ends -->

  <!-- Main bar -->
  <div class="mainbar">


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
                    <div class="pull-left">任务创建</div>
                    <div class="widget-icons pull-right">
                      <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                      <a href="#" class="wclose"><i class="icon-remove"></i></a>
                    </div>
                    <div class="clearfix"></div>
                  </div>

                  <div class="widget-content">
                    <div class="panel-body" style="padding-bottom:0px;">
                      <div class="widget">
                        <div class="widget-content">
                          <!--1-->
                          <form id="formSearch001" class="form-horizontal">
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="task_name">任&nbsp&nbsp务&nbsp&nbsp名</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="task_name" value="请输入任务名" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                              </div>
                              <label class="control-label col-sm-1" for="task_tarcountry">目&nbsp&nbsp的&nbsp&nbsp国</label>
                              <div class="col-sm-3">
                                <select id="task_tarcountry" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的国'></select>
                              </div>
                              <label class="control-label col-sm-1" for="task_tarcity">目的城市</label>
                              <div class="col-sm-3">
                                <select id="task_tarcity" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的城市'></select>
                              </div>
                            </div>
                            <!--2-->
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="task_jiaoliutimu">交流题目</label>
                              <div class="col-sm-3">
                                <input type="text" class="form-control" id="task_jiaoliutimu">
                              </div>
                              <label class="control-label col-sm-1" for="task_type">任务类别</label>
                              <div class="col-sm-3">
                                <select id="task_type" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入出国期限'></select>
                              </div>
                            </div>
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="task_cjcfbeg">起始时间</label>
                              <div id="task_cjcfbeg" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="task_cjcfbeg001">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                              <label class="control-label col-sm-1" for="task_cjggend">结束时间</label>
                              <div id="task_cjggend" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="task_cjggend001">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                              <label class="control-label col-sm-1" for="task_lijingshijian">离境时间</label>
                              <div id="task_lijingshijian" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="task_lijingshijian001">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                              <label class="control-label col-sm-1" for="task_rujingshijian">入境时间</label>
                              <div id="task_rujingshijian" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="task_rujingshijian001">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="task_significance">参会意义</label>
                              <div class="col-sm-11">
                                  <textarea class="form-control" rows="3" placeholder="Textarea" id="task_significance">
			                      </textarea>
                              </div>
                            </div>
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="task_temp">个人简介</label>
                              <div class="col-sm-11">
                                  <textarea class="form-control" rows="3" placeholder="Textarea" id="task_temp">
			                      </textarea>
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <div class="btn-group">
                                <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary">创建</button>
                                <button type="button" id="btn_output" class="btn btn-success">修改</button>
                                <button type="button" id="btn_print" class="btn btn-danger">删除</button>
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

              <!---->
              <div class="col-md-12">
                <div class="widget">
                  <div class="widget-head">
                    <div class="pull-left">基本信息填写</div>
                    <div class="widget-icons pull-right">
                      <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                      <a href="#" class="wclose"><i class="icon-remove"></i></a>
                    </div>
                    <div class="clearfix"></div>
                  </div>

                  <div class="widget-content">
                    <div class="panel-body" style="padding-bottom:0px;">
                      <div class="widget">
                        <div class="widget-content">
                          <!--1-->
                          <form id="formSearch002" class="form-horizontal">
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="extend_nation">民&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp族</label>
                              <div class="col-sm-2">
                                <input type="text" class="form-control" id="extend_nation" value="请输入民族" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                              </div>
                              <label class="control-label col-sm-1" for="extend_educationle">文化程度</label>
                              <div class="col-sm-2">
                                <select id="extend_educationle" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的国'></select>
                              </div>
                              <label class="control-label col-sm-1" for="extend_zzmianmao">政治面貌</label>
                              <div class="col-sm-2">
                                <select id="extend_zzmianmao" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的城市'></select>
                              </div>
                              <label class="control-label col-sm-1" for="extend_wgysp">外语水平</label>
                              <div class="col-sm-2">
                                <select id="extend_wgysp" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的城市'></select>
                              </div>
                            </div>
                            <!--2-->
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="passport_ywhuzhao">有无护照</label>
                              <div class="col-sm-2">
                                <input type="text" class="form-control" id="passport_ywhuzhao">
                              </div>
                              <label class="control-label col-sm-1" for="passport_huzhaozhonglei">护照种类</label>
                              <div class="col-sm-2">
                                <select id="passport_huzhaozhonglei" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入出国期限'></select>
                              </div>
                              <label class="control-label col-sm-1" for="passport_huzhaohao">护&nbsp&nbsp照&nbsp&nbsp号</label>
                              <div class="col-sm-2">
                                <select id="passport_huzhaohao" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入出国期限'></select>
                              </div>

                            </div>
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="passport_fazhaoriqi">发照时间</label>
                              <div id="passport_fazhaoriqi" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="passport_fazhaoriqi001">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                              <label class="control-label col-sm-1" for="passport_huzhaoyouxiaoqi">护照效期</label>
                              <div id="passport_huzhaoyouxiaoqi" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="passport_huzhaoyouxiaoqi001">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                              <label class="control-label col-sm-1" for="passport_yanqi">护照延期</label>
                              <div id="passport_yanqi" class="input-append col-sm-2">
                                <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="passport_yanqi001">
                                <span class="add-on">
                                  <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                </span>
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="extend_bysjbyyx">毕业情况</label>
                              <div class="col-sm-2">
                                <input type="text" class="form-control" id="extend_bysjbyyx" value="请输入毕业时间及院校" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                              </div>
                              <label class="control-label col-sm-1" for="task_swscmxm">参谋姓名</label>
                              <div class="col-sm-2">
                                <input type="text" class="form-control" id="task_swscmxm" value="请输入单位外事参谋姓名" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                              </div>
                              <label class="control-label col-sm-1" for="task_swscmdh">参谋电话</label>
                              <div class="col-sm-2">
                                <input type="text" class="form-control" id="task_swscmdh" value="请输入外事参谋电话" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="passport_beizhu">护照备注</label>
                              <div class="col-sm-11">
                                  <textarea class="form-control" rows="3" placeholder="填写护照备注信息" id="passport_beizhu">
			                      </textarea>
                              </div>
                            </div>
                            <div class="form-group" style="margin-top:15px">
                              <label class="control-label col-sm-1" for="staffdetail_yjfxcjgx">个人简介</label>
                              <div class="col-sm-11">
                                  <textarea class="form-control" rows="3" placeholder="填写个人研究方向、重点研究领域、突出成就业绩" id="staffdetail_yjfxcjgx">
			                      </textarea>
                              </div>
                            </div>

                            <div class="form-group" style="margin-top:15px">
                              <div class="btn-group">
                                <button type="button" style="margin-left:50px" id="btn_zancun" class="btn btn-primary">暂存</button>
                                <button type="button" id="btn_gengxin" class="btn btn-success">更新</button>
                              </div>
                            </div>

                          </form>
                        </div>
                      </div>
                    </div>
                  </div>

                  <div class="col-md-12">
                    <div class="widget">
                      <div class="widget-head">
                        <div class="pull-left">出国申请记录</div>
                        <div class="widget-icons pull-right">
                          <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                          <a href="#" class="wclose"><i class="icon-remove"></i></a>
                        </div>
                        <div class="clearfix"></div>
                      </div>

                      <div class="col-md-12">
                        <div class="widget">
                          <div class="widget-head">
                            <div class="pull-left">附件填写及上传</div>
                            <div class="widget-icons pull-right">
                              <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                              <a href="#" class="wclose"><i class="icon-remove"></i></a>
                            </div>
                            <div class="clearfix"></div>
                          </div>

                          <div class="widget-content">
                            <div class="panel-body" style="padding-bottom:0px;">
                              <div class="widget">
                                <div class="widget-content">
                                  <!--1-->
                                  <form id="formSearch004" class="form-horizontal">
                                    <div class="form-group" style="margin-top:15px">
                                      <label class="control-label col-sm-1" for="task_name_query">情&nbsp&nbsp况&nbsp&nbsp表</label>
                                      <div class="btn-group">
                                        <button type="button" style="margin-left:50px" id="btn_tianxie001" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp填写&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_xiugai0001" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp修改&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_yulan0001" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_xiazai0001" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_shanchu0001" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                                      </div>
                                    </div>
                                    <div class="form-group" style="margin-top:15px">
                                      <label class="control-label col-sm-1" for="task_name_query">责&nbsp&nbsp任&nbsp&nbsp书</label>
                                      <div class="btn-group">
                                        <button type="button" style="margin-left:50px" id="btn_tianxie002" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp填写&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_xiugai0002" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp修改&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_yulan0002" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_xiazai0002" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_shanchu0002" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                                      </div>
                                    </div>
                                    <div class="form-group" style="margin-top:15px">
                                      <label class="control-label col-sm-1" for="task_name_query">邀&nbsp&nbsp请&nbsp&nbsp函</label>
                                      <div class="btn-group">
                                        <button type="button" style="margin-left:50px" id="btn_tianxie003" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp填写&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_xiugai0003" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp修改&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_yulan0003" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_xiazai0003" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_shanchu0003" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                                      </div>
                                    </div>
                                    <div class="form-group" style="margin-top:15px">
                                      <label class="control-label col-sm-1" for="task_name_query">行程安排</label>
                                      <div class="btn-group">
                                        <button type="button" style="margin-left:50px" id="btn_tianxie004" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp填写&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_xiugai0004" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp修改&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_yulan0004" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_xiazai0004" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                                        <button type="button" id="btn_shanchu0004" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                                      </div>
                                    </div>
                                  </form>
                                </div>
                              </div>

                              <div id="toolbar003" class="btn-group">
                                <button id="btn_query002" type="button" class="btn btn-primary"  style="margin-left:50px">合并附件</button>
                                <button id="btn_yulan002" type="button" class="btn btn-success">提交审核</button>
                                <button id="btn_output002" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                                <button id="btn_input002" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                              </div>

                              <br/>
                            </div>
                          </div>
                        </div>
                      </div>

                      <div class="widget-content">
                        <div class="panel-body" style="padding-bottom:0px;">
                          <div class="widget">
                            <div class="widget-content">
                              <!--1-->
                              <form id="formSearch003" class="form-horizontal">
                                <div class="form-group" style="margin-top:15px">
                                  <label class="control-label col-sm-1" for="task_name_query">任&nbsp&nbsp务&nbsp&nbsp名</label>
                                  <div class="col-sm-2">
                                    <input type="text" class="form-control" id="task_name_query" value="请输入任务名" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                                  </div>
                                  <label class="control-label col-sm-1" for="task_tarcountry_query">目&nbsp&nbsp的&nbsp&nbsp国</label>
                                  <div class="col-sm-2">
                                    <select id="task_tarcountry_query" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的国'></select>
                                  </div>
                                  <label class="control-label col-sm-1" for="task_tarcity_query">目的城市</label>
                                  <div class="col-sm-2">
                                    <select id="task_tarcity_query" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的城市'></select>
                                  </div>

                                </div>
                                <!--2-->
                                <div class="form-group" style="margin-top:15px">
                                  <label class="control-label col-sm-1" for="task_cjcfbeg_query">开始时间</label>
                                  <div id="task_cjcfbeg_query" class="input-append col-sm-2">
                                    <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="task_cjcfbeg_query001">
                                    <span class="add-on">
                                      <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                    </span>
                                  </div>
                                  <label class="control-label col-sm-1" for="task_cjggend_query">结束时间</label>
                                  <div id="task_cjggend_query" class="input-append col-sm-2">
                                    <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="task_cjggend_query001">
                                    <span class="add-on">
                                      <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                                    </span>
                                  </div>

                                </div>

                              </form>
                            </div>
                          </div>

                          <div id="toolbar001" class="btn-group">
                            <button id="btn_query001" type="button" class="btn btn-default">
                              <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>查询
                            </button>
                            <button id="btn_yulan001" type="button" class="btn btn-default">
                              <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>预览
                            </button>
                            <button id="btn_output001" type="button" class="btn btn-default">
                              <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>导出
                            </button>
                          </div>
                          <table id="tb_tasks001"></table>

                        </div>
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
            <p class="copy">Copyright &copy; 2018 | <a href="#">院办信息中心</a> </p>
      </div>
    </div>
  </div>
</footer> 	

<!-- Footer ends -->

<!--弹出对话框-->
<div id="myModal1" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title">申请单</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
          <!-- Matter -->
          <div class="matter">
            <div class="container">
              <div class="row">
                <!-- post sidebar -->
                <ul id="myTab" class="nav nav-tabs">
                  <li class="active"><a href="#home" data-toggle="tab">患者信息</a></li>
                  <li><a href="#nav1" data-toggle="tab">临床信息</a></li>
                  <li><a href="#nav2" data-toggle="tab">送检标本信息</a></li>
                  <li><a href="#nav3" data-toggle="tab">肿瘤患者填写</a></li>
                  <li><a href="#nav4" data-toggle="tab">妇科患者填写</a></li>
                  <li><a href="#nav5" data-toggle="tab">甲状腺标本填写</a></li>
                  <li><a href="#nav6" data-toggle="tab">手术标本送检</a></li>
                  <li><a href="#nav7" data-toggle="tab">采集标本解剖</a></li>
                </ul>

                <div id="myTabContent" class="tab-content">
                  <!--------------------------home-------------------------------->
                  <div class="tab-pane fade in active" id="home">
                    <div class="form-group" style="margin-top:15px">
                      <!--避孕youfoubiyun-->
                      <label class="control-label col-sm-1" for="txt_search_shenqingleixing">申请类型</label>
                      <div class="col-sm-4">
                        <select id="txt_search_shenqingleixing" data-first-option="false"
                                data-live-search="true"
                                class="selectpicker form-control show-tick" title='申请类型'></select>
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_binglihao1">病&nbsp&nbsp理&nbsp&nbsp号</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_binglihao1" readonly>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--姓名name-->
                      <label class="control-label col-sm-1" for="txt_search_xingming">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_xingming">
                      </div>
                      <!--性别gender-->
                      <label class="control-label col-sm-1" for="txt_search_gender">性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别</label>
                      <div class="col-sm-4">
                        <select id="txt_search_gender" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='请选择性别'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--年龄age-->
                      <label class="control-label col-sm-1"
                             for="txt_search_age">年&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp龄</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_age">
                      </div>
                      <!--年龄单位unit-->
                      <label class="control-label col-sm-1" for="txt_search_department"></label>
                      <div class="col-sm-4">
                        <select id="txt_search_department" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='请选择单位'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--婚否marrage-->
                      <label class="control-label col-sm-1" for="txt_search_marrage">婚&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp否</label>
                      <div class="col-sm-4">
                        <select id="txt_search_marrage" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='请选择婚否'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--民族minzu-->
                      <label class="control-label col-sm-1"
                             for="txt_search_minzu">民&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp族</label>
                      <div class="col-sm-4">
                        <select id="txt_search_minzu" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='请选择民族'></select>
                      </div>
                      <!--职业zhiye-->
                      <label class="control-label col-sm-1"
                             for="txt_search_zhiye">职&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp业</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_zhiye">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--电话tel-->
                      <label class="control-label col-sm-1"
                             for="txt_search_tel">电&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp话</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_tel">
                      </div>
                      <!--身份证号shenfenzheng-->
                      <label class="control-label col-sm-1" for="txt_search_shenfenzheng">身份证号</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_shenfenzheng">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--住址address-->
                      <label class="control-label col-sm-1" for="txt_search_address">住&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp址</label>
                      <div class="col-sm-4">
                        <select id="txt_search_address" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='请输入省'></select>
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_address"></label>
                      <div class="col-sm-4">
                        <select id="txt_search_addresscity" data-first-option="false"
                                data-live-search="true" class="selectpicker form-control show-tick"
                                title='请输入市'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="txt_search_address"></label>
                      <div class="col-sm-4">
                        <select id="txt_search_addressdistinct" data-first-option="false"
                                data-live-search="true" class="selectpicker form-control show-tick"
                                title='请输入区'></select>
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_address"></label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_addressother">
                      </div>
                    </div>

                    <div class="form-group" style="margin-top:15px">
                      <!--就医来源source-->
                      <label class="control-label col-sm-1" for="txt_search_source">就医来源</label>
                      <div class="col-sm-4">
                        <select id="txt_search_source" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='请选择就医来源'></select>
                      </div>
                      <!--病区bingqu-->
                      <label class="control-label col-sm-1" for="txt_search_bingqu">病&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp区</label>
                      <div class="col-sm-4">
                        <select id="txt_search_bingqu" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='请选择病区'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--床号bedcode-->
                      <label class="control-label col-sm-1" for="txt_search_bedcode">床&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp号</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_bedcode">
                      </div>
                    </div>
                    <!-- Matter ends -->
                  </div>
                  <!--------------------------nav1---------------------------->
                  <div class="tab-pane fade" id="nav1">
                    <div class="form-group" style="margin-top:15px">
                      <!--症状zhengzhuang-->
                      <label class="control-label col-sm-1" for="txt_search_zhengzhuang">症&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp状</label>
                    </div>
                    <div class="form-group" style="margin-top:15px;margin-left:3px">
                      <div class="col-sm-11">
                    <textarea class="form-control" rows="3" placeholder="Textarea"
                              id="txt_search_zhengzhuang"></textarea>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px;margin-left:3px">
                      <!--体征tizheng-->
                      <label class="control-label col-sm-1"
                             for="txt_search_tizheng">体&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp征</label>
                    </div>
                    <div class="form-group" style="margin-top:15px;margin-left:3px">
                      <div class="col-sm-11">
                        <textarea class="form-control" rows="3" placeholder="Textarea"
                                  id="txt_search_tizheng"></textarea>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px;margin-left:3px">
                      <!--临床诊断linchuangzhenduan-->
                      <label class="control-label col-sm-1" for="txt_search_linchuangzhenduan">临床诊断</label>
                    </div>
                    <div class="form-group" style="margin-top:15px;margin-left:3px">
                      <div class="col-sm-11">
                    <textarea class="form-control" rows="3" placeholder="Textarea"
                              id="txt_search_linchuangzhenduan"></textarea>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px;margin-left:3px">
                      <!--其它诊断qitazhenduan-->
                      <label class="control-label col-sm-1" for="txt_search_qitazhenduan"> 其它诊断</label>
                    </div>
                    <div class="form-group" style="margin-top:15px;margin-left:3px">
                      <div class="col-sm-11">
                    <textarea class="form-control" rows="3" placeholder="Textarea"
                              id="txt_search_qitazhenduan"></textarea>
                      </div>
                    </div>
                  </div>
                  <!------------------------------nav2-------------------------------->
                  <div class="tab-pane fade" id="nav2">
                    <div class="form-group" style="margin-top:15px">
                      <label class="col-sm-4">注意事项</label>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--是否曾在本院做过病理检查sfczby-->
                      <label class="col-sm-4" for="txt_search_sfczby">是否曾在本院做过病理检查</label>
                      <div class="col-sm-5">
                        <select id="txt_search_sfczby" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='是否曾在本院做过病理检查'></select>
                      </div>
                    </div>
                  </div>
                  <!------------------------------nav3--------------------------------->
                  <div class="tab-pane fade" id="nav3">
                    <div class="form-group" style="margin-top:15px">
                      <!--肿瘤发现时间zlfxsj-->
                      <label class="control-label col-sm-1" for="txt_search_zlfxsj">发现时间</label>
                      <div id="txt_search_zlfxsj1" class="input-append col-sm-3">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="txt_search_zlfxsj">
                        <span class="add-on">
                            <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                        </span>
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_year">年</label>
                      <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_year">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--肿瘤部位zlbw-->
                      <label class="control-label col-sm-1" for="txt_search_zlbw">肿瘤部位</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_zlbw">
                      </div>
                      <!--肿瘤大小zldx-->
                      <label class="control-label col-sm-1" for="txt_search_zldx">肿瘤大小</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_zldx">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--转移zhuanyi-->
                      <label class="control-label col-sm-1" for="txt_search_zhuanyi">有无转移</label>
                      <div class="col-sm-4">
                        <select id="txt_search_zhuanyi" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='有无转移'></select>
                      </div>
                      <!--转移位置zhuanyiweizhi-->
                      <label class="control-label col-sm-1" for="txt_search_zhuanyiweizhi">转移位置</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_zhuanyiweizhi">
                      </div>
                    </div>

                    <div class="form-group" style="margin-top:15px">
                      <!--放化疗fanghualiao-->
                      <label class="control-label col-sm-1" for="txt_search_fanghualiao">放化疗？</label>
                      <div class="col-sm-4">
                        <select id="txt_search_fanghualiao" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='有无放化疗'></select>
                      </div>
                      <!--肿瘤大小zhongliudaxiao-->
                      <label class="control-label col-sm-1" for="txt_search_zhongliudaxiao">肿瘤大小</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_zhongliudaxiao">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--肿瘤大小对应时间-->
                      <div id="datetimepicker12" class="input-append col-sm-5">
                        <input data-format="yyyy-MM-dd'" type="text" class="form-control dtpicker"
                               id="txt_search_zldxdysj">
                        <span class="add-on">
                              <i data-time-icon="icon-time" data-date-icon="icon-calendar"
                                 class="btn btn-info btn-lg"></i>
                            </span>
                      </div>
                    </div>
                  </div>

                  <div class="tab-pane fade" id="nav4">
                    <div class="form-group" style="margin-top:15px">
                      <!--月经周期yjzq-->
                      <label class="control-label col-sm-1" for="txt_search_yjzq">月经周期</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_yjzq">
                      </div>
                      <!--月经持续时间yjcxsj-->
                      <label class="control-label col-sm-1" for="txt_search_yjcxsj">持续时间</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_yjcxsj">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--上次月经scyj-->
                      <label class="control-label col-sm-1" for="txt_search_scyj">上次月经</label>
                      <div id="datetimepicker42" class="input-append col-sm-4">
                        <input data-format="yyyy-MM-dd'" type="text" class="form-control dtpicker"
                               id="txt_search_scyj">
                        <span class="add-on">
                              <i data-time-icon="icon-time" data-date-icon="icon-calendar"
                                 class="btn btn-info btn-lg"></i>
                            </span>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--周期治疗？zqzl-->
                      <label class="control-label col-sm-1" for="txt_search_zqzl">周期治疗</label>
                      <div class="col-sm-4">
                        <select id="txt_search_zqzl" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick" title='是否施行周期治疗'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--周期治疗时间zqzlsj-->
                      <label class="control-label col-sm-1" for="txt_search_zqzlsj">时&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp间</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_zqzlsj">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--剂量zqzljl-->
                      <label class="control-label col-sm-1" for="txt_search_zqzljl">剂&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp量</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_zqzljl">
                      </div>
                    </div>


                    <div class="form-group" style="margin-top:15px">
                      <!--生产史shengchanshi-->
                      <label class="control-label col-sm-1" for="txt_search_shengchanshi">生&nbsp&nbsp产&nbsp&nbsp史</label>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_shengchanshi">
                      </div>
                      <!--剂量zqzljl-->
                      <label class="control-label col-sm-1" for="txt_search_shengchanshi">胎</label>
                      <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_shengchanshichan">
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_shengchanshi">产</label>
                    </div>

                    <div class="form-group" style="margin-top:15px">
                      <!--避孕youfoubiyun-->
                      <label class="control-label col-sm-1" for="txt_search_youfoubiyun">有否避孕</label>
                      <div class="col-sm-4">
                        <select id="txt_search_youfoubiyun" data-first-option="false"
                                data-live-search="true"
                                class="selectpicker form-control show-tick" title='有否避孕'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--避孕方式biyunfangshi-->
                      <label class="control-label col-sm-1" for="txt_search_biyunfangshi">避孕方式</label>
                      <div class="col-sm-4">
                        <select id="txt_search_biyunfangshi" data-first-option="false"
                                data-live-search="true"
                                class="selectpicker form-control show-tick" title='避孕方式'></select>
                      </div>
                    </div>
                  </div>
                  <!---->
                  <div class="tab-pane fade" id="nav5">
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-2"
                             for="txt_search_dianjizhiliao">如为甲状腺标本请填写</label>
                    </div>

                    <div class="form-group" style="margin-top:15px">
                      <!--碘剂治疗dianjizhiliao-->
                      <div class="col-sm-11">
                        <select id="txt_search_dianjizhiliao" data-first-option="false"
                                data-live-search="true"
                                class="selectpicker form-control show-tick" title='是否接受过碘剂治疗'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--硫尿嘧啶类治疗lnmdzl-->
                      <div class="col-sm-11">
                        <select id="txt_search_lnmdzl" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick"
                                title='是否接受过硫尿嘧啶类治疗'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="txt_search_shoushusuojian">手术标本</label>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <!--手术所见shoushusuojian-->
                      <label class="control-label col-sm-1" for="txt_search_shoushusuojian">手术所见</label>
                      <div class="col-sm-10">
                  <textarea class="form-control" rows="3" placeholder="Textarea"
                            id="txt_search_shoushusuojian"></textarea>
                      </div>
                    </div>
                  </div>
                  <!---->
                  <!-----------------------------nav6------------------------------------->
                  <div class="tab-pane fade" id="nav6">
                    <div class="form-group" style="margin-top:15px">
                      <!--碘剂治疗dianjizhiliao-->
                      <label class="control-label col-sm-3"
                             for="txt_search_dianjizhiliao">标本位置</label>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_cjbbzlbw">
                      </div>
                      <div class="col-sm-4">
                        <input type="text" class="form-control" id="txt_search_zlfj1">
                      </div>
                      <div class="col-sm-2">
                        <button id="btn_addjpbw" type="button" class="btn btn-default">+</button>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <div class="col-sm-4">
                        <label class="control-label col-sm-3"
                               for="txt_search_huayanjieguo">化验结果</label>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <div class="col-sm-10">
                  <textarea class="form-control" rows="3" placeholder="Textarea"
                            id="txt_search_huayanjieguo"></textarea>
                      </div>
                    </div>
                  </div>
                  <!---->
                  <div class="tab-pane fade" id="nav7">
                    <div class="form-group" style="margin-top:15px">
                      <!--碘剂治疗dianjizhiliao-->
                      <label class="control-label col-sm-4"
                             for="txt_search_dianjizhiliao">检查方法</label>
                    </div>
                    <div class="form-group" style="margin-top:5px;margin-left:10px">
                      <button type="button" id="btn-1" class="btn btn-warning" style="width:130px">活检</button>
                      <button type="button" id="btn-2" class="btn btn-warning" style="width:130px">快速冰冻</button>
                      <button type="button" id="btn-3" class="btn btn-warning" style="width:130px">细胞学</button>
                      <button type="button" id="btn-4" class="btn btn-warning" style="width:130px">TCT</button>
                    </div>
                    <div class="form-group" style="margin-top:5px;margin-left:10px">
                      <button type="button" id="btn-5" class="btn btn-warning" style="width:130px">免疫组化</button>
                      <button type="button" id="btn-6" class="btn btn-warning" style="width:130px">细胞DNA倍体</button>
                      <button type="button" id="btn-7" class="btn btn-warning" style="width:130px">FISH</button>
                      <button type="button" id="btn-8" class="btn btn-warning" style="width:130px">基因检测</button>
                    </div>
                    <div class="form-group" style="margin-top:5px;margin-left:10px">
                      <label class="control-label col-sm-3"
                             for="txt_search_qitafangfa">其它方法</label>
                    </div>
                    <div class="form-group" style="margin-top:5px;margin-left:10px">
                      <div class="col-sm-10">
                        <input type="text" class="form-control" id="txt_search_qitafangfa">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:5px;margin-left:10px">
                      <label class="control-label col-sm-1"
                             for="txt_search_teshuyaoqiu">特殊要求</label>
                    </div>
                    <div class="form-group" style="margin-top:5px;margin-left:10px">
                      <div class="col-sm-10">
                  <textarea class="form-control" rows="3" placeholder="Textarea"
                            id="txt_search_teshuyaoqiu"></textarea>
                      </div>
                    </div>
                    <hr/>
                    <div class="form-group" style="margin-top:5px;margin-left:10px">
                      <label class="control-label col-sm-1"
                             for="txt_search_dianjizhiliao">申请医师</label>
                      <div class="col-sm-4">
                        <select id="txt_search_shenqingyishi" data-first-option="false" data-live-search="true"
                                class="selectpicker form-control show-tick"
                                title='请选择申请医师'>
                        </select>
                      </div>
                      <label class="control-label col-sm-1"
                             for="txt_search_sheniqngriqi">申请日期</label>
                        <div id="datetimepickerer42" class="input-append col-sm-4">
                        <input data-format="yyyy-MM-dd'" type="text" class="form-control dtpicker"
                               id="txt_search_sheniqngriqi">
                        <span class="add-on">
                              <i data-time-icon="icon-time" data-date-icon="icon-calendar"
                                 class="btn btn-info btn-lg"></i>
                        </span>
                      </div>
                    </div>

                      <div class="form-group" style="margin-top:5px;margin-left:10px">
                        <label class="control-label col-sm-1"
                               for="txt_search_songjianyishi">送检医师</label>
                        <div class="col-sm-4">
                          <select id="txt_search_songjianyishi" data-first-option="false" data-live-search="true"
                                  class="selectpicker form-control show-tick"
                                  title='选择送检医师'>
                          </select>
                        </div>
                        <label class="control-label col-sm-1"
                               for="txt_search_songjianriqi">送检日期</label>
                        <div id="datetimepickerera42" class="input-append col-sm-4">
                          <input data-format="yyyy-MM-dd'" type="text" class="form-control dtpicker"
                                 id="txt_search_songjianriqi">
                          <span class="add-on">
                              <i data-time-icon="icon-time" data-date-icon="icon-calendar"
                                 class="btn btn-info btn-lg"></i>
                        </span>
                        </div>
                      </div>
                      <div class="form-group" style="margin-top:5px;margin-left:10px">
                        <label class="control-label col-sm-1"
                               for="txt_search_dianjizhiliao">送检科室</label>
                        <div class="col-sm-4">
                          <select id="txt_search_lnmfghdzl" data-first-option="false" data-live-search="true"
                                  class="selectpicker form-control show-tick"
                                  title='选择送检科室'>
                          </select>
                        </div>
                      </div>
                      <div class="form-group" style="margin-top:5px;margin-left:10px">
                        <label class="control-label col-sm-1" for="txt_search_dianjizhiliao"></label>
                        <div class="col-sm-3">
                          <button type="button" id="btn-save" class="btn btn-primary" style="width:130px">保存</button>
                        </div>
                        <div class="col-sm-3">
                          <button type="button" id="btn-submit" class="btn btn-info" style="width:130px">提交</button>
                        </div>
                      </div>
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