<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>出国申请终审</title>
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

</head>

<div class="navbar navbar-fixed-top bs-docs-nav" role="banner">
  <div class="conjtainer">
    <!-- Menu button for smallar screens -->

    <!-- Navigation starts -->
    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
        <ul class="nav navbar-nav navbar-left">
          <div class="logo" style="vertical-align:middle;margin-top:12px;margin-left:25px">
          <!--居中-->
            <h3>军事医学研究院出国(境)人员终审系统<span class="bold"></span></h3>
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
          <li><a href="#"><i class="icon-list-alt"></i> 指南发布 </a></li>
          <li><a href="#"><i class="icon-list-alt"></i> 指南查看 </a></li>
        </ul>
      </li>
      <li><a href="glyy.jsp" class="open"><i class="icon-home"></i> 出国(境)终审 </a></li>
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
                <div class="pull-left">出国(境)终审</div>
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
                      <label class="control-label col-sm-1" for="gly_search_hbid2">h&nbspb&nbsp&nbspi&nbspd&nbsp2</label>
                      <div class="col-sm-3">
                        <input type="text" class="form-control" id="gly_search_hbid2" value="输入合并后的id2进行查询" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_hbid1">h&nbspb&nbsp&nbspi&nbspd&nbsp1</label>
                      <div class="col-sm-3">
                        <input type="text" class="form-control" id="gly_search_hbid1" value="输入合并后的id1进行查询" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_tkid">t&nbsp&nbsp&nbspk&nbsp&nbsp&nbspi&nbsp&nbspd</label>
                      <div class="col-sm-3">
                        <input type="text" class="form-control" id="gly_search_tkid" value="输入任务id进行查询" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="gly_search_taskname">任&nbsp&nbsp务&nbsp&nbsp名</label>
                      <div class="col-sm-3">
                        <select id="gly_search_taskname" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入任务名'></select>
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_name">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名</label>
                      <div class="col-sm-3">
                        <select id="gly_search_name" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入专家姓名'>
                        </select>
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_gender">性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别</label>
                      <div class="col-sm-3">
                        <select id="gly_search_gender" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择性别'>
                          <option  selected="selected"></option>
                          <option >男</option>
                          <option >女</option>
                        </select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="gly_search_department">单&nbsp&nbsp位&nbsp&nbsp名</label>
                      <div class="col-sm-3">
                        <select id="gly_search_department" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入任务名'></select>
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_agebeg">年&nbsp&nbsp龄&nbsp&nbsp起</label>
                      <div class="col-sm-3">
                        <input type="text" class="form-control" id="gly_search_agebeg" value="输入起始年龄如:35" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_ageend">年&nbsp&nbsp龄&nbsp&nbsp终</label>
                      <div class="col-sm-3">
                        <input type="text" class="form-control" id="gly_search_ageend" value="输入截止年龄如:45" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#000'}">
                      </div>
                    </div>

                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="txt_search_zhuangtai">审核状态</label>
                      <div class="col-sm-3">
                        <select id="txt_search_zhuangtai" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择审核状态'>
                          // <option  selected="selected"></option>
                          // <option >未审核</option>
                          // <option >审核通过</option>
                          // <option >审核未通过</option>
                        </select>
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_tarcountry">目&nbsp&nbsp的&nbsp&nbsp国</label>
                      <div class="col-sm-3">
                        <select id="gly_search_tarcountry" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的国'></select>
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_tarcity">目的城市</label>
                      <div class="col-sm-3">
                        <select id="gly_search_tarcity" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的城市'></select>
                      </div>
                    </div>

                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="gly_search_zhicheng">职称</label>
                      <div class="col-sm-3">
                        <select id="gly_search_zhicheng" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择职称'>
                          <option  selected="selected"></option>
                          <option >研究实习员</option>
                          <option >助理研究员</option>
                          <option >副研究员</option>
                          <option >研究员</option>
                        </select>
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_jishudengji">技术等级</label>
                      <div class="col-sm-3">
                        <select id="gly_search_jishudengji" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择技术等级'>
                          <option  selected="selected"></option>
                          <option >技术一级</option>
                          <option >技术二级</option>
                          <option >技术三级</option>
                          <option >技术四级</option>
                          <option >技术五级</option>
                          <option >技术六级</option>
                          <option >技术七级</option>
                          <option >技术八级</option>
                          <option >技术九级</option>
                          <option >技术十级</option>
                          <option >技术十一级</option>
                          <option >技术十二级</option>
                          <option >技术十三级</option>
                          <option >技术十四级</option>
                        </select>
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_zhiwudengji">职务等级</label>
                      <div class="col-sm-3">
                        <select id="gly_search_zhiwudengji" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请输入目的城市'>
                          <option  selected="selected"></option>
                          <option >排</option>
                          <option >副连</option>
                          <option >正连</option>
                          <option >副营</option>
                          <option >正营</option>
                          <option >副团</option>
                          <option >正团</option>
                          <option >副师</option>
                          <option >正师</option>
                          <option >副军</option>
                        </select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <label class="control-label col-sm-1" for="gly_search_cjcfbeg">开始时间</label>
                      <div id="gly_search_cjcfbeg" class="input-append col-sm-3">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="task_cjcfbeg_query001">
                        <span class="add-on">
                                      <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                        </span>
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_cjggend">结束时间</label>
                      <div id="gly_search_cjggend" class="input-append col-sm-3">
                        <input data-format="yyyy-MM-dd" type="text" class="form-control dtpicker" id="task_cjggend_query001">
                        <span class="add-on">
                                      <i data-time-icon="icon-time" data-date-icon="icon-calendar" class="btn btn-info btn-lg"></i>
                        </span>
                      </div>
                      <label class="control-label col-sm-1" for="gly_search_dayout">出国期限</label>
                      <div class="col-sm-3">
                        <select id="gly_search_dayout" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='出国时间大于该数的记录'>
                        </select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <div class="btn-group">
                        <button type="button" style="margin-left:50px" id="glybtn_search_query" class="btn btn-primary">查&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp询</button>
                        <button type="button" id="glybtn_search_singleview" class="btn btn-success">单人预览</button>
                        <button type="button" id="glybtn_search_multileview" class="btn btn-default">多人预览</button>
                        <button type="button" id="glybtn_search_edit" class="btn btn-danger"  data-toggle="modal" data-target="#fanhuixiugaiModal2">返回修改</button>
                        <button type="button" id="glybtn_search_delete" class="btn btn-warning">删&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp除</button>
                      </div>
                    </div>
                  </form>


                  <table class="table table-striped table-bordered table-hover" id="table006"></table>
                  <div class="form-group" style="margin-top:15px">
                    <div class="btn-group">
                      <button type="button" style="margin-left:35px" id="glybtn_hb_task" class="btn btn-primary" data-toggle="modal" data-target="#hbrwModal2">合并任务</button>
                      <button type="button" id="glybtn_qxhb_task " class="btn btn-info">取消合并</button>
                      <button type="button" id="glybtn_hb_chengpi " class="btn btn-success">生成呈批件</button>
                      <button type="button" id="glybtn_hb_updownload" class="btn btn-danger"  data-toggle="modal" data-target="#updownloadModal2">附件上传/下载</button>
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
<div id="fanhuixiugaiModal2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                  <label class="control-label col-sm-1" for="glyy_beizhu">备注</label>
                  <div class="col-sm-11">
                    <textarea class="form-control" rows="10" placeholder="请填写专家需要修改的地方" id="glyy_beizhu"></textarea>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="btn-group" style="margin-left:25px">
                    <!--button-->
                    <div id="toolbar002" class="btn-group">
                      <button type="button" id="glyy_btn_queding002" class="btn btn-warning">确定</button>
                      <button type="button" id="glyy_btn_quxiao002" class="btn btn-success" data-dismiss="modal" aria-hidden="true">取消</button>
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
<div id="hbrwModal2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
                  <label class="control-label col-sm-1" for="glyy_rwhb2_renwuming">任&nbsp&nbsp务&nbsp&nbsp名</label>
                  <div class="col-sm-3">
                    <select id="glyy_rwhb2_renwuming" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择任务名'></select>
                  </div>
                  <label class="control-label col-sm-1" for="glyy_rwhb2_tarcountry">目&nbsp&nbsp的&nbsp&nbsp国</label>
                  <div class="col-sm-3">
                    <select id="glyy_rwhb2_tarcountry" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择目的国'></select>
                  </div>
                  <label class="control-label col-sm-1" for="glyy_rwhb2_tarcity">目的城市</label>
                  <div class="col-sm-3">
                    <select id="glyy_rwhb2_tarcity" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择目的城市'></select>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="glyy_rwhb2_tasktype">任务类型</label>
                  <div class="col-sm-3">
                    <select id="glyy_rwhb2_tasktype" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择任务类型'>
                      <option  selected="selected"></option>
                      <option >与会</option>
                      <option >交流</option>
                      <option >培训</option>
                      <option >执行任务</option>
                    </select>
                  </div>
                  <label class="control-label col-sm-1" for="glyy_rwhb2_cjcfbeg">开始时间</label>
                  <div class="col-sm-3">
                    <select id="glyy_rwhb2_cjcfbeg" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择邀请函上任务开始时间'></select>
                  </div>
                  <label class="control-label col-sm-1" for="glyy_rwhb2_cjcfend">结束时间</label>
                  <div class="col-sm-3">
                    <select id="glyy_rwhb2_cjcfend" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择邀请函上任务结束时间'></select>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="glyy_rwhb2_lijingbeg">出境时间</label>
                  <div class="col-sm-3">
                    <select id="glyy_rwhb2_lijingbeg" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择离境时间'></select>
                  </div>
                  <label class="control-label col-sm-1" for="glyy_rwhb2_rujingend">入境时间</label>
                  <div class="col-sm-3">
                    <select id="glyy_rwhb2_rujingend" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择入境时间'></select>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <label class="control-label col-sm-1" for="glyy_rwhb2_significance">参会影响力及意义</label>
                  <div class="col-sm-11">
                    <select id="glyy_rwhb2_significance" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick"  title='请选择参会的意义及影响力'></select>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="btn-group" style="margin-left:25px">
                    <!--button-->
                    <div id="toolbar003" class="btn-group">
                      <button type="button" id="glyy_btn_queding003" class="btn btn-warning">确定</button>
                      <button type="button" id="glyy_btn_quxiao003" class="btn btn-success" data-dismiss="modal" aria-hidden="true">取消</button>
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
<div id="updownloadModal2" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h4 class="modal-title"><strong>附件下载及上传</strong></h4>
      </div>
      <div class="modal-body">
        <form class="form-horizontal">
          <!-- Matter -->
          <div class="matter">
            <div class="container">
              <div class="row">
                <!-- post sidebar -->
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>呈批件(三合一)</strong></h4></div>
                  <div id="taskhb2_cpj">
                    <div id="toolbarcpj" class="btn-group">
                      <button id="glyy_btn_cpj001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>呈批件1(word版)</strong></h4></div>
                  <div id="taskhb2_cpj1">
                    <div id="toolbarcpj1" class="btn-group">
                      <button id="glyy_btn_cpj011" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj012" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj013" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj014" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj015" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>呈批件2(word版)</strong></h4></div>
                  <div id="taskhb2_cpj2">
                    <div id="toolbarcpj2" class="btn-group">
                      <button id="glyy_btn_cpj021" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj022" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj023" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj024" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj025" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>呈批件3(word版)</strong></h4></div>
                  <div id="taskhb2_cpj3">
                    <div id="toolbarcpj3" class="btn-group">
                      <button id="glyy_btn_cpj031" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj032" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj033" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj034" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cpj035" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>所机关对院请示件(word版)</strong></h4></div>
                  <div id="taskhb2_qsj">
                    <div id="toolbarqsj" class="btn-group">
                      <button id="glyy_btn_qsj001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_qsj002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_qsj003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_qsj004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_qsj005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>出国人员情况表(word版)</strong></h4></div>
                  <div id="taskhb2_cgryqkb">
                    <div id="toolbarcgryqkb" class="btn-group">
                      <button id="glyy_btn_cgryqkb001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cgryqkb002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cgryqkb003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cgryqkb004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_cgryqkb005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>保密责任书(word版)</strong></h4></div>
                  <div id="taskhb2_bmzrs">
                    <div id="toolbarbmzrs" class="btn-group">
                      <button id="glyy_btn_bmzrs001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_bmzrs002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_bmzrs003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_bmzrs004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_bmzrs005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>邀请函(中英文)</strong></h4></div>
                  <div id="taskhb2_yaoqinghan">
                    <div id="toolbaryaoqinghan" class="btn-group">
                      <button id="glyy_btn_yaoqinghan001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_yaoqinghan002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_yaoqinghan003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_yaoqinghan004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_yaoqinghan005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
                    </div>
                  </div>
                </div>
                <div class="form-group" style="margin-top:15px">
                  <div class="col-sm-3" align="right"><h4><strong>行程安排(中英文)</strong></h4></div>
                  <div id="taskhb2_xcap">
                    <div id="toolbarxcap" class="btn-group">
                      <button id="glyy_btn_xcap001" type="button" class="btn btn-primary"  style="margin-left:50px">&nbsp&nbsp&nbsp&nbsp预览&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_xcap002" type="button" class="btn btn-success">&nbsp&nbsp&nbsp&nbsp下载&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_xcap003" type="button" class="btn btn-danger">&nbsp&nbsp&nbsp&nbsp上传&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_xcap004" type="button" class="btn btn-info">&nbsp&nbsp&nbsp&nbsp脱密&nbsp&nbsp&nbsp&nbsp</button>
                      <button id="glyy_btn_xcap005" type="button" class="btn btn-default">&nbsp&nbsp&nbsp&nbsp删除&nbsp&nbsp&nbsp&nbsp</button>
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