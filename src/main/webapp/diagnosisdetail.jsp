<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>阅片诊断</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="">
  <!-- Stylesheets -->
  <link href="style/bootstrap.css" rel="stylesheet">
  <!-- Font awesome icon -->
  <link rel="stylesheet" href="style/font-awesome.css"> 
  <!-- jQuery UI -->
  <link rel="stylesheet" href="style/jquery-ui.css"> 
  <!-- Calendar -->
  <link rel="stylesheet" href="style/fullcalendar.css">
  <!-- prettyPhoto -->
  <link rel="stylesheet" href="style/prettyPhoto.css">  
  <!-- Star rating -->
  <link rel="stylesheet" href="style/rateit.css">
  <!-- Date picker -->
  <link rel="stylesheet" href="style/bootstrap-datetimepicker.min.css">
  <!-- CLEditor -->
  <link rel="stylesheet" href="style/jquery.cleditor.css"> 
  <!-- Uniform -->
  <link rel="stylesheet" href="style/uniform.default.css"> 
  <!-- Bootstrap toggle -->
  <link rel="stylesheet" href="style/bootstrap-switch.css">
  <!-- Main stylesheet -->
  <link href="style/style.css" rel="stylesheet">
  <!-- Widgets stylesheet -->
  <link href="style/widgets.css" rel="stylesheet">   
  <!-- 表格颜色 -->
  <link href="style/z-table-color.css" rel="stylesheet">  
  <!-- HTML5 Support for IE -->
  <!--[if lt IE 9]>
  <script src="js/html5shim.js"></script>
  <![endif]-->
  <!-- Favicon -->
  <link rel="shortcut icon" href="img/favicon/favicon.png">
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
	      <h2 class="pull-left"><i class="icon-home"></i> 阅片诊断</h2>
        <!-- Breadcrumb -->
        <div class="bread-crumb pull-right">
          <a href="index.jsp"><i class="icon-home"></i> 首页</a>
          <!-- Divider -->
          <span class="divider">/</span> 
          <a href="#" class="bread-current">控制台</a>
        </div>
        <div class="clearfix"></div>
      </div>
	    <!-- Page heading ends -->
	    <!-- Matter -->
	    <div class="matter">
        <div class="container">
          <!-- Today status. jQuery Sparkline plugin used. -->
          <div class="row">
            <div class="col-md-12">
              <ul class="today-datas">
                <li class="dropdown dropdown-big">
                  <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                    <h3><i class="icon-file"></i> 今日病例 <span class="label label-danger">12</span></h3>
                  </a>
                </li>
                <li class="dropdown dropdown-big">
                  <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                    <h3><i class="icon-instagram"></i> 已诊断 <span class="label label-success">5</span></h3>
                  </a>
                </li>
                <li class="dropdown dropdown-big">
                  <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                    <h3><i class="icon-dropbox"></i> 提交审核 <span class="label label-warning">5</span></h3>
                  </a>
                </li>
                <li class="dropdown dropdown-big">
                  <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                    <h3><i class="icon-keyboard"></i> 已诊断 <span class="label label-info">80</span></h3>
                  </a>
                </li>
                <li class="dropdown dropdown-big">
                  <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                    <h3><i class="icon-eye-open"></i> 提交会诊 <span class="label label-danger">12</span></h3>
                  </a>
                </li>
                <li class="dropdown dropdown-big">
                  <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                    <h3><i class="icon-file-text"></i> 完成会诊 <span class="label label-primary">9</span></h3>
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <br/>
          <!-- Form starts.  -->
          <form class="form-horizontal" role="form">
            <div class="form-group">
              <label class="col-lg-1 control-label"> 姓名 </label>
              <div class="col-lg-2">
                <input type="text" class="form-control" placeholder="Input Box">
              </div>
              <label class="col-lg-1 control-label"> 病理号 </label>
              <div class="col-lg-2">
                <input type="text" class="form-control" placeholder="Input Box">
              </div>
              <label class="col-lg-1 control-label"> 是否会诊 </label>
              <div class="col-lg-2">
                <select class="form-control">
                  <option>1</option>
                  <option>2</option>
                </select>
              </div>
              <label class="col-lg-1 control-label"> 状态 </label>
              <div class="col-lg-2">
                <select class="form-control">
                  <option>1</option>
                  <option>2</option>
                </select>
              </div>
              <div class="col-lg-1">
                <button type="button" class="btn btn-primary">查询</button>
              </div>
            </div>
          </form> 
          <br/>
          <div class="col-lg-3">
             <table class="table table-striped table-bordered table-hover blue">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>病例信息</th>
                  <th>病理号</th>
                  <th>总切片</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>张某</td>
                  <td>xxxxxxx</td>
                  <td>20</td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="col-lg-9">
            <table class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th>临床信息</th>
                  <th>取材部位</th>
                  <th>检查方法</th>
                  <th>片数</th>
                  <th>病理诊断/或病理诊断时间</th>
                  <th>诊断医师</th>
                  <th>上级审核/或审核时间</th>
                  <th>审核医师</th>
                  <th>是否会诊</th>
                  <th>会诊时间</th>
                  <th>状态</th>
                  <th>操作</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td>已审核</td>
                  <td><button type="button" class="btn btn-primary">查看</button></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td>待审核</td>
                  <td><button type="button" class="btn btn-primary">审核</button></td>
                </tr>
                <tr>
                  <td>3</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td>已保存</td>
                  <td><button type="button" class="btn btn-primary">提交审核</button></td>
                </tr>
                <tr>
                  <td>4</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td>待处理</td>
                  <td><button type="button" class="btn btn-primary">待处理</button></td>
                </tr>
                <tr>
                  <td>5</td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td>医嘱执行</td>
                  <td><button type="button" class="btn btn-primary">查看</button></td>
                </tr>
              </tbody>
            </table>
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

<!-- Scroll to top -->
<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span> 

<!-- JS -->
<script src="js/jquery.js"></script> <!-- jQuery -->
<script src="js/bootstrap.js"></script> <!-- Bootstrap -->
<script src="js/jquery-ui-1.9.2.custom.min.js"></script> <!-- jQuery UI -->
<script src="js/fullcalendar.min.js"></script> <!-- Full Google Calendar - Calendar -->
<script src="js/jquery.rateit.min.js"></script> <!-- RateIt - Star rating -->
<script src="js/jquery.prettyPhoto.js"></script> <!-- prettyPhoto -->

<!-- jQuery Flot -->
<script src="js/excanvas.min.js"></script>
<script src="js/jquery.flot.js"></script>
<script src="js/jquery.flot.resize.js"></script>
<script src="js/jquery.flot.pie.js"></script>
<script src="js/jquery.flot.stack.js"></script>

<!-- jQuery Notification - Noty -->
<script src="js/jquery.noty.js"></script> <!-- jQuery Notify -->
<script src="js/themes/default.js"></script> <!-- jQuery Notify -->
<script src="js/layouts/bottom.js"></script> <!-- jQuery Notify -->
<script src="js/layouts/topRight.js"></script> <!-- jQuery Notify -->
<script src="js/layouts/top.js"></script> <!-- jQuery Notify -->
<!-- jQuery Notification ends -->

<script src="js/sparklines.js"></script> <!-- Sparklines -->
<script src="js/jquery.cleditor.min.js"></script> <!-- CLEditor -->
<script src="js/bootstrap-datetimepicker.min.js"></script> <!-- Date picker -->
<script src="js/jquery.uniform.min.js"></script> <!-- jQuery Uniform -->
<script src="js/bootstrap-switch.min.js"></script> <!-- Bootstrap Toggle -->
<script src="js/filter.js"></script> <!-- Filter for support page -->
<script src="js/custom.js"></script> <!-- Custom codes -->
<script src="js/charts.js"></script> <!-- Charts & Graphs -->

<script src="js/userFaceindex.js"></script>
<!-- Script for this page -->
<script type="text/javascript">
$(function () {

    /* Bar Chart starts */

    var d1 = [];
    for (var i = 0; i <= 20; i += 1)
        d1.push([i, parseInt(Math.random() * 30)]);

    var d2 = [];
    for (var i = 0; i <= 20; i += 1)
        d2.push([i, parseInt(Math.random() * 30)]);


    var stack = 0, bars = true, lines = false, steps = false;
    
    function plotWithOptions() {
        $.plot($("#bar-chart"), [ d1, d2 ], {
            series: {
                stack: stack,
                lines: { show: lines, fill: true, steps: steps },
                bars: { show: bars, barWidth: 0.8 }
            },
            grid: {
                borderWidth: 0, hoverable: true, color: "#777"
            },
            colors: ["#ff6c24", "#ff2424"],
            bars: {
                  show: true,
                  lineWidth: 0,
                  fill: true,
                  fillColor: { colors: [ { opacity: 0.9 }, { opacity: 0.8 } ] }
            }
        });
    }

    plotWithOptions();
    
    $(".stackControls input").click(function (e) {
        e.preventDefault();
        stack = $(this).val() == "With stacking" ? true : null;
        plotWithOptions();
    });
    $(".graphControls input").click(function (e) {
        e.preventDefault();
        bars = $(this).val().indexOf("Bars") != -1;
        lines = $(this).val().indexOf("Lines") != -1;
        steps = $(this).val().indexOf("steps") != -1;
        plotWithOptions();
    });

    /* Bar chart ends */

});
</script>

</body>
</html>