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
  <!--<script src="js/address.js"></script>-->

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

<!--弹出对话框1-->
<!--出国、赴港澳人员情况表-->
<div id="myModal1" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title">出国、赴港澳人员情况表</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
          <!-- Matter -->
          <div class="matter">
            <div class="container">
              <div class="row">
                <!-- post sidebar -->
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_name">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_name">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gender">性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别</label>
                      <div class="col-sm-3">
                          <select id="qkb_gender" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='是否存在特殊要求'></select>
                      </div>
                      <label class="control-label col-sm-1" for="qkb_birthyday">出生日期</label>
                      <div id="qkb_birthyday" class="input-append col-sm-2">
                          <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="qkb_birthyday002">
                          <span class="add-on">
                            <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                          </span>
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_birthyplace">出生地点</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_birthyplace">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_nation">民&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp族</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_nation">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_educationle">文化程度</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_educationle">
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_zwhzc">职务职称</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_zwhzc">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_jxhjb">军衔级别</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_jxhjb">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_zzmianmao">政治面貌</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_zzmianmao">
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_wgysp">外语水平</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_wgysp">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_bysjbyyx">毕业状况</label>
                      <div class="col-sm-11">
                        <textarea class="form-control" rows="3" placeholder="Textarea" id="qkb_bysjbyyx">
                        </textarea>
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_lxdh">联系电话</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_lxdh">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_jgzid">证件号码</label>
                      <div class="col-sm-11">
                        <textarea class="form-control" rows="3" placeholder="Textarea" id="qkb_jgzid">
                        </textarea>
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_ywhuzhaoc">有无护照</label>
                      <div class="col-sm-3">
                          <select id="qkb_ywhuzhaoc" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='是否存在特殊要求'></select>
                      </div>
                      <label class="control-label col-sm-1" for="qkb_huzhaohao">护照号码</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_huzhaohao">
                      </div>
                      <label class="control-label col-sm-1" for="qkb__huzhaoyouxiaoqi">有效期至</label>
                      <div id="qkb__huzhaoyouxiaoqi" class="input-append col-sm-2">
                          <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="qkb__huzhaoyouxiaoqi002">
                          <span class="add-on">
                            <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                          </span>
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="task_name">工作简历</label>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="task_name">起止年月</label>
                      <label class="control-label col-sm-3" for="task_name"></label>
                      <label class="control-label col-sm-3" for="task_name">工作职务</label>
                      <label class="control-label col-sm-3" for="task_name"></label>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_qzsj001">起止年月1</label>
                      <div id="qkb_qzsj001" class="input-append col-sm-2">
                          <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="qkb_qzsj001001">
                          <span class="add-on">
                            <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                          </span>
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gzdwzw1">工作职务1</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_gzdwzw1">
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_qzsj002">起止年月2</label>
                      <div id="qkb_qzsj002" class="input-append col-sm-2">
                          <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="qkb_qzsj002001">
                          <span class="add-on">
                            <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                          </span>
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gzdwzw2">工作职务2</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_gzdwzw2">
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_qzsj003">起止年月3</label>
                      <div id="qkb_qzsj003" class="input-append col-sm-2">
                          <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="qkb_qzsj003001">
                          <span class="add-on">
                              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                          </span>
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gzdwzw3">工作职务3</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_gzdwzw3">
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_qzsj004">起止年月4</label>
                      <div id="qkb_qzsj004" class="input-append col-sm-2">
                          <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="qkb_qzsj004001">
                          <span class="add-on">
                            <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                          </span>
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gzdwzw4">工作职务4</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_gzdwzw4">
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_qzsj005">起止年月5</label>
                      <div id="qkb_qzsj005" class="input-append col-sm-2">
                          <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="qkb_qzsj005001">
                          <span class="add-on">
                              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                          </span>
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gzdwzw5">工作职务5</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_gzdwzw5">
                      </div>
                  </div>

                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="task_name">出国情况</label>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="task_name">时间</label>
                      <label class="control-label col-sm-2" for="task_name"></label>
                      <label class="control-label col-sm-1" for="task_name">执行任务</label>
                      <label class="control-label col-sm-2" for="task_name"></label>
                      <label class="control-label col-sm-1" for="task_name">对外身份</label>
                      <label class="control-label col-sm-2" for="task_name"></label>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_cgqksj001">时间1</label>
                      <div id="qkb_cgqksj001" class="input-append col-sm-2">
                          <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="qkb_cgqksj001001">
                          <span class="add-on">
                            <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                          </span>
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gjjrw001">国家任务1</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_gjjrw001">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_dwsf001">身份1</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_dwsf001">
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_cgqksj002">时间2</label>
                      <div id="qkb_cgqksj002" class="input-append col-sm-2">
                          <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="qkb_cgqksj002001">
                          <span class="add-on">
                            <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                          </span>
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gjjrw002">国家任务2</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_gjjrw002">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_dwsf002">身份2</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_dwsf002">
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_cgqksj003">时间3</label>
                      <div id="qkb_cgqksj003" class="input-append col-sm-2">
                          <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="qkb_cgqksj003001">
                          <span class="add-on">
                              <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                          </span>
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gjjrw003">国家任务3</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_gjjrw003">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_dwsf003">身份3</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_dwsf003">
                      </div>
                  </div>

                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="task_name">家庭成员</label>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="task_name">姓名</label>
                      <label class="control-label col-sm-2" for="task_name"></label>
                      <label class="control-label col-sm-1" for="task_name">关系</label>
                      <label class="control-label col-sm-2" for="task_name"></label>
                      <label class="control-label col-sm-1" for="task_name">工作单位</label>
                      <label class="control-label col-sm-2" for="task_name"></label>
                      <label class="control-label col-sm-1" for="task_name">是否国外</label>
                      <label class="control-label col-sm-2" for="task_name"></label>
                  </div>

                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_cyxm001">姓名1</label>
                      <div class="col-sm-1">
                          <input type="text" class="form-control" id="qkb_cyxm001">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gx001">关系1</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_gx001">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_dwzw001">单位职务1</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_dwzw001">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gw1">国外否1</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_gw1">
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_cyxm002">姓名2</label>
                      <div class="col-sm-1">
                          <input type="text" class="form-control" id="qkb_cyxm002">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gx002">关系2</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_gx002">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_dwzw002">单位职务2</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_dwzw002">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gw2">国外否2</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_gw2">
                      </div>
                  </div>
                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_cyxm003">姓名3</label>
                      <div class="col-sm-1">
                          <input type="text" class="form-control" id="qkb_cyxm003">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gx003">关系3</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_gx003">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_dwzw003">单位职务3</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_dwzw003">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_gw3">国外否3</label>
                      <div class="col-sm-2">
                          <input type="text" class="form-control" id="qkb_gw3">
                      </div>
                  </div>

                  <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="qkb_department">承办单位</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_department">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_scmxm">联&nbsp&nbsp系&nbsp&nbsp人</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_scmxm">
                      </div>
                      <label class="control-label col-sm-1" for="qkb_scmdh">电&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp话</label>
                      <div class="col-sm-3">
                          <input type="text" class="form-control" id="qkb_scmdh">
                      </div>
                  </div>

                  <div class="form-group" style="margin-top:15px">
                      <div class="btn-group">
                          <!--button-->
                          <div id="toolbar005" class="btn-group">
                              <button type="button" id="btn_baocun005" class="btn btn-warning">保存</button>
                              <button type="button" id="btn_wancheng005" class="btn btn-success">完成</button>
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

<div id="myModal2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title">军事医学研究院因公出国人员保密责任书</h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
          <!-- Matter -->
          <div class="matter">
            <div class="container">
              <div class="row">
                <!-- post sidebar -->
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="bmzrs_name">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="bmzrs_name">
                  </div>
                  <label class="control-label col-sm-1" for="baomi_zhiji">职&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp级</label>
                  <div class="col-sm-3">
                    <select id="baomi_zhiji" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='是否存在特殊要求'></select>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="baomi_buzhibie">部&nbsp&nbsp职&nbsp&nbsp别</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_buzhibie">
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="qkb_zwzc">职务职称</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="qkb_zwzc">
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="qkb_dfgj">到访国家</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="qkb_dfgj">
                  </div>
                  <label class="control-label col-sm-1" for="baomi_jwtlbeg">离境时间</label>
                  <div id="baomi_jwtlbeg" class="input-append col-sm-2">
                    <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="baomi_jwtlbeg001">
                    <span class="add-on">
							<i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
						  </span>
                  </div>
                  <label class="control-label col-sm-1" for="baomi_jwtlend">入境时间</label>
                  <div id="baomi_jwtlend" class="input-append col-sm-2">
                    <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="baomi_jwtlend001">
                    <span class="add-on">
							<i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
						  </span>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="baomi_jwtlend">携带设备</label>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="task_name">设备类型</label>
                  <label class="control-label col-sm-3" for="task_name"></label>
                  <label class="control-label col-sm-3" for="task_name">品牌型号</label>
                  <label class="control-label col-sm-3" for="task_name"></label>
                  <label class="control-label col-sm-3" for="task_name">涉密等级</label>
                  <label class="control-label col-sm-3" for="task_name"></label>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="baomi_xddzsblx1">类型1</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xddzsblx1">
                  </div>
                  <label class="control-label col-sm-1" for="baomi_xddzsbxh1">型号1</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xddzsbxh1">
                  </div>
                  <label class="control-label col-sm-1" for="baomi_xddzsbsmdj1">涉密等级1</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xddzsbsmdj1">
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="baomi_xddzsblx2">类型2</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xddzsblx2">
                  </div>
                  <label class="control-label col-sm-1" for="baomi_xddzsbxh2">型号2</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xddzsbxh2">
                  </div>
                  <label class="control-label col-sm-1" for="baomi_xddzsbsmdj2">涉密等级2</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xddzsbsmdj2">
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="baomi_xddzsbyf">携带电脑</label>
                  <div class="col-sm-3">
                    <select id="baomi_xddzsbyf" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='是否存在特殊要求'></select>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="baomi_xddzsbyf">涉密材料</label>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="baomi_xddzsbyf">资料名称</label>
                  <label class="control-label col-sm-3" for="baomi_xddzsbyf"></label>
                  <label class="control-label col-sm-3" for="baomi_xddzsbyf">份数</label>
                  <label class="control-label col-sm-3" for="baomi_xddzsbyf"></label>
                  <label class="control-label col-sm-3" for="baomi_xddzsbyf">涉密等级</label>
                  <label class="control-label col-sm-3" for="baomi_xddzsbyf"></label>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="baomi_xdsmzlmc1">资料1</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xdsmzlmc1">
                  </div>
                  <label class="control-label col-sm-1" for="baomi_xdsmzlfs1">份数1</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xdsmzlfs1">
                  </div>
                  <label class="control-label col-sm-1" for="baomi_xdsmzlsmdj1">涉密等级1</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xdsmzlsmdj1">
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="baomi_xdsmzlmc2">资料2</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xdsmzlmc2">
                  </div>
                  <label class="control-label col-sm-1" for="baomi_xdsmzlfs2">份数2</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xdsmzlfs2">
                  </div>
                  <label class="control-label col-sm-1" for="baomi_xdsmzlsmdj2">涉密等级2</label>
                  <div class="col-sm-3">
                    <input type="text" class="form-control" id="baomi_xdsmzlsmdj2">
                  </div>
                </div>

                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="baomi_xdsmzlyf">涉密材料</label>
                  <div class="col-sm-3">
                    <select id="baomi_xdsmzlyf" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='是否存在特殊要求'></select>
                  </div>
                </div>

                <div class="form-group" style="margin-top:15px">
                  <div class="btn-group">
                    <!--button-->
                    <div id="toolbar006" class="btn-group">
                      <button type="button" id="btn_baocun006" class="btn btn-warning">保存</button>
                      <button type="button" id="btn_wancheng006" class="btn btn-success">完成</button>
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