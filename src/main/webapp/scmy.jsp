<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>出国申请初审</title>
  <link href="img/icons/title.png" rel="SHORTCUT ICON" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="">
  <link href="img/icons/title.png" rel="SHORTCUT ICON" />

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
  <script src="js/table001.js"></script>
  <script src="js/table002.js"></script>
  <script src="js/table003.js"></script>
  <script src="js/table004.js"></script>
  <script src="js/table005.js"></script>
  <script src="js/table006.js"></script>
  <!--
  <script src="js/table002.js"></script>
  <script src="js/table003.js"></script>
  <script src="js/table004.js"></script>
  <script src="js/table005.js"></script>
  <script src="js/table006.js"></script>
  -->
</head>

<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">
  <div class="conjtainer">
    <!-- Menu button for smallar screens -->

    <!-- Navigation starts -->
    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
        <ul class="nav navbar-nav navbar-left">
          <div class="logo" style="vertical-align:middle;margin-top:12px;margin-left:25px">
          <!--居中-->
            <h3>军事医学研究院出国(境)人员初审系统<span class="bold"></span></h3>
          </div>
        </ul>

        <!-- Search form -->
        <!-- Links -->
        <ul class="nav navbar-nav pull-right">
          <li class="dropdown pull-right">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#" id="dropdown_user_name">
              <i class="icon-user"></i><span></span><b class="caret"></b>
            </a>

            <!-- Dropdown menu -->
            <ul class="dropdown-menu">
              <%--<li><a href="#"><i class="icon-user"></i> 资料</a></li>--%>
              <%--<li><a href="#"><i class="icon-cogs"></i> 设置</a></li>--%>
              <li><a href="login.jsp"><i class="icon-off"></i> 退出</a></li>
            </ul>
          </li>

        </ul>
    </nav>

  </div>
</div>

<body>


<!-- Header starts -->


<!-- Header ends -->

<!-- Main content starts -->

<div class="content">

  <!-- Sidebar -->
  <div class="sidebar" style="margin-top:12px";>
    <div class="sidebar-dropdown"><a href="#">导航</a></div>

    <!--- Sidebar navigation -->
    <!-- If the main navigation has sub navigation, then add the class "has_sub" to "li" of main navigation. -->
    <ul id="nav">
      <!-- Main menu with font awesome icon -->
      <li><a href="#" class="has_sub"><i class="icon-list-alt"></i> 指&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp南 </a>
        <ul>
          <li><a href="JSP_DB/news/pub_do.jsp"><i class="icon-list-alt"></i> 指南查看 </a></li>
        </ul>
      </li>
      <li><a href="scmy.jsp" class="open"><i class="icon-home"></i> 出国(境)初审 </a></li>
    </ul>
  </div>

  <!-- Sidebar ends -->

  <!-- Main bar -->
  <div class="mainbar">


    <!-- Page heading ends -->



    <!-- Matter -->

    <div class="matter">
      <div class="container">

        <!-- Today status. jQuery Sparkline plugin used. -->




        <!-- Today status ends -->

        <!-- Dashboard Graph starts -->

        <!-- Dashboard graph ends -->

        <!-- Chats, File upload and Recent Comments -->
        <div class="row">
          <div class="col-md-12">
            <div class="widget">
              <div class="widget-head">
                <div class="pull-left">出国(境)初审</div>
                <div class="widget-icons pull-right">
                  <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                  <a href="#" class="wclose"><i class="icon-remove"></i></a>
                </div>
                <div class="clearfix"></div>
              </div>
              <div class="widget-content">
                <div class="panel-body" style="padding-bottom:0px;">
                  <form id="formSearch001" class="form-horizontal">
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="txt_search_hbid">h&nbsp&nbspb&nbsp&nbsp&nbspi&nbsp&nbspd</label>
                      <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_hbid" value="输入合并后的id进行查询" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_tkid">t&nbsp&nbsp&nbspk&nbsp&nbsp&nbspi&nbsp&nbspd</label>
                      <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_tkid" value="输入任务id进行查询" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_name">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名</label>
                      <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_name" value="输入姓名进行查询" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="txt_search_taskname">任&nbsp&nbsp务&nbsp&nbsp名</label>
                      <div class="col-sm-3">
                        <select id="txt_search_taskname" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入任务名'></select>
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_tarcountry">目&nbsp&nbsp的&nbsp&nbsp国</label>
                      <div class="col-sm-3">
                        <select id="txt_search_tarcountry" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的国'></select>
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_tarcity">目的城市</label>
                      <div class="col-sm-3">
                        <select id="txt_search_tarcity" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的城市'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="txt_search_zhuangtai">审核状态</label>
                      <div class="col-sm-2">
                        <select id="txt_search_zhuangtai" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择审核状态'>
                          // <option  selected="selected"></option>
                          // <option >未审核</option>
                          // <option >审核通过</option>
                          // <option >审核未通过</option>
                        </select>
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_cjcfbeg">开始时间</label>
                      <div id="txt_search_cjcfbeg" class="input-append col-sm-2">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="task_cjcfbeg_query001">
                        <span class="add-on">
                                      <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                        </span>
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_cjggend">结束时间</label>
                      <div id="txt_search_cjggend" class="input-append col-sm-2">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="task_cjggend_query001">
                        <span class="add-on">
                                      <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                        </span>
                      </div>
                      <label class="control-label col-sm-1" for="txt_search_dayout">出国期限</label>
                      <div class="col-sm-2">
                        <select id="txt_search_dayout" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='出国时间大于该数的记录'>
                        </select>
                      </div>
                    </div>

                    <div class="form-group" style="margin-top:15px">
                      <div class="btn-group">
                        <button type="button" style="margin-left:50px" id="btn_search_query" class="btn btn-primary">查&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp询</button>
                        <button type="button" id="btn_search_view" class="btn btn-success">预&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp览</button>
                        <button type="button" id="btn_search_edit" class="btn btn-danger"  data-toggle="modal" data-target="#fanhuixiugaiModal1">返回修改</button>
                        <button type="button" id="btn_search_delete" class="btn btn-warning">删&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp除</button>
                      </div>
                    </div>
                  </form>


                  <table class="table table-striped table-bordered table-hover" id="table004"></table>
                  <div class="form-group" style="margin-top:15px">
                    <div class="btn-group">
                      <button type="button" style="margin-left:35px" id="btn_hb_task" class="btn btn-primary" data-toggle="modal" data-target="#hbrwModal1">合并任务</button>
                      <button type="button" id="btn_hb_qingshi" class="btn btn-success">生成请示</button>
                      <button type="button" id="btn_hb_updownload" class="btn btn-danger"  data-toggle="modal" data-target="#updownloadModal1">附件上传/下载</button>
                      <button type="button" id="btn_hb_zhongshen" class="btn btn-warning">提交终审</button>
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

<!-- poppage start -->

<!-- poppage 返回修改 -->
<div id="fanhuixiugaiModal1" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" style="width:1200px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title"><strong>需返回专家修改的地方</strong></h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
          <!-- Matter -->
          <div class="matter">
            <div class="container">
              <div class="row">
                <!-- post sidebar -->
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="rwhb1_beizhu">备注</label>
                  <div class="col-sm-11">
                    <textarea class="form-control" rows="10" placeholder="请填写专家需要修改的地方" id="rwhb1_beizhu"></textarea>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="btn-group" style="margin-left:25px">
                    <!--button-->
                    <div id="toolbar002" class="btn-group">
                      <button type="button" id="btn_queding002" class="btn btn-warning">确定</button>
                      <button type="button" id="btn_quxiao002" class="btn btn-success" data-dismiss="modal" aria-hidden="true">取消</button>
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

<!-- poppage 合并任务开始 -->
<div id="hbrwModal1" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" style="width:1200px;">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title"><strong>任务合并</strong>></h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
          <!-- Matter -->
          <div class="matter">
            <div class="container">
              <div class="row">
                <!-- post sidebar -->
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="rwhb1_renwuming">任&nbsp&nbsp务&nbsp&nbsp名</label>
                  <div class="col-sm-3">
                    <select id="rwhb1_renwuming" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择任务名'></select>
                  </div>
                  <label class="control-label col-sm-1" for="rwhb1_tarcountry">目&nbsp&nbsp的&nbsp&nbsp国</label>
                  <div class="col-sm-3">
                    <select id="rwhb1_tarcountry" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择目的国'></select>
                  </div>
                  <label class="control-label col-sm-1" for="rwhb1_tarcity">目的城市</label>
                  <div class="col-sm-3">
                    <select id="rwhb1_tarcity" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择目的城市'></select>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="rwhb1_tasktype">任务类型</label>
                  <div class="col-sm-3">
                    <select id="rwhb1_tasktype" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择任务类型'>
                      <option  selected="selected"></option>
                      <option >与会</option>
                      <option >交流</option>
                      <option >培训</option>
                      <option >执行任务</option>
                    </select>
                  </div>
                  <label class="control-label col-sm-1" for="rwhb1_cjcfbeg">开始时间</label>
                  <div class="col-sm-3">
                    <select id="rwhb1_cjcfbeg" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择邀请函上任务开始时间'></select>
                  </div>
                  <label class="control-label col-sm-1" for="rwhb1_cjcfend">结束时间</label>
                  <div class="col-sm-3">
                    <select id="rwhb1_cjcfend" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择邀请函上任务结束时间'></select>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="rwhb1_lijingbeg">出境时间</label>
                  <div class="col-sm-3">
                    <select id="rwhb1_lijingbeg" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择离境时间'></select>
                  </div>
                  <label class="control-label col-sm-1" for="rwhb1_rujingend">入境时间</label>
                  <div class="col-sm-3">
                    <select id="rwhb1_rujingend" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择入境时间'></select>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="rwhb1_significance">参会影响力及意义</label>
                  <div class="col-sm-11">
                    <select id="rwhb1_significance" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick"  title='请选择参会的意义及影响力'></select>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="btn-group" style="margin-left:25px">
                    <!--button-->
                    <div id="toolbar003" class="btn-group">
                      <button type="button" id="btn_queding003" class="btn btn-warning">确定</button>
                      <button type="button" id="btn_quxiao003" class="btn btn-success" data-dismiss="modal" aria-hidden="true">取消</button>
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
<!-- poppage 合并任务结束 -->

<!-- poppage 附件上传下载开始 -->
<div id="updownloadModal1" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title"><strong>附件下载及上传</strong>></h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
          <!-- Matter -->
          <div class="matter">
            <div class="container">
              <div class="row">
                <!-- post sidebar -->
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>本单位对院出具请示件</strong></h4></div>
                  <div id="taskhb1_qsj">
                    <div id="toolbarqsj" class="btn-group">
                      <button id="btn_qsj001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_qsj002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_qsj003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_qsj004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_qsj005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>出国人员情况表</strong></h4></div>
                  <div id="taskhb1_cgryqkb">
                    <div id="toolbarcgryqkb" class="btn-group">
                      <button id="btn_cgryqkb001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_cgryqkb002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_cgryqkb003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_cgryqkb004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_cgryqkb005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>保密责任书</strong></h4></div>
                  <div id="taskhb1_bmzrs">
                    <div id="toolbarbmzrs" class="btn-group">
                      <button id="btn_bmzrs001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_bmzrs002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_bmzrs003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_bmzrs004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_bmzrs005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>邀请函(中英文)</strong></h4></div>
                  <div id="taskhb1_yaoqinghan">
                    <div id="toolbaryaoqinghan" class="btn-group">
                      <button id="btn_yaoqinghan001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_yaoqinghan002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_yaoqinghan003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_yaoqinghan004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_yaoqinghan005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>行程安排(中英文)</strong></h4></div>
                  <div id="taskhb1_xcap">
                    <div id="toolbarxcap" class="btn-group">
                      <button id="btn_xcap001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_xcap002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_xcap003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_xcap004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="btn_xcap005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="btn-group" style="margin-left:25px">
                    <!--button-->
                    <div id="toolbar004" class="btn-group">
                      <button type="button" id="btn_fanhui004" class="btn btn-success" data-dismiss="modal" aria-hidden="true">返回</button>
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
<!-- poppage 附件上传下载结束 -->

<!-- poppage  ends -->

<!-- Scroll to top -->
<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span>

</body>
</html>