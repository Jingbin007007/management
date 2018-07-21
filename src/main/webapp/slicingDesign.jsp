<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>切片设计</title>
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
  <!-- layui -->
  <link href="style/layui.css" rel="stylesheet">   
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
	      <h2 class="pull-left"><i class="icon-home"></i> 切片设计 </h2>
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
          <br/>
          <div class="row">
            <div class="col-lg-1">
              <p> </p>
            </div>
            <div class="col-lg-1">
              <p>病理号：</p>
            </div>
            <div class="col-lg-1">
              <p>xxxxxxxxx</p>
            </div>
            <div class="col-lg-1">
              <p>姓名：</p>
            </div>
            <div class="col-lg-1">
              <p>xx</p>
            </div>
            <div class="col-lg-1">
              <p>年龄：</p>
            </div>
            <div class="col-lg-1">
              <p>23</p>
            </div>
            <div class="col-lg-1">
              <p>标本部位：</p>
            </div>
            <div class="col-lg-1">
              <p>xxxxxxxxx</p>
            </div>
            <div class="col-lg-1">
              <p>蜡块编号：</p>
            </div>
            <div class="col-lg-1">
              <p>xxxxxxxxx</p>
            </div>
          </div>
          <br/>
          <br/>
          <div class="slicing-design">
            <div class="row">
              <div class="col-lg-1">
              </div>
              <div class="col-lg-1">
                <p>检查方法：</p>
              </div>
              <div class="col-lg-10">
                <span class="label label-success">活检</span>
                <span class="label label-success">免疫组化</span>
              </div>
            </div>
            <br/>
            <br/>
            <div class="row">
              <div class="col-lg-1">
              </div>
              <form class="form-horizontal" role="form">
                  <label class="col-lg-1"> 病理申请<br/>特殊要求： </label>
                  <div class="col-lg-9">
                    <textarea class="form-control" rows="3" placeholder="内容文字"></textarea>
                  </div>
              </form>
            </div>
            <br/>
            <br/>
            <div class="row">
              <div class="col-lg-1">
              </div>
              <div class="col-lg-1">
                <p>染色类型：</p>
              </div>
              <div class="col-lg-10">
                <button type="button" class="btn btn-success btn-he"> +HE染色</button>
                <button type="button" class="btn btn-success btn-ts"> +特殊染色</button>
                <button type="button" class="btn btn-success btn-my"> +免疫组化</button>
              </div>
            </div>
            <br/>
            <br/>
            <!-- HE染色 -->
            <div class="row he-ranse">
              <div class="col-lg-1">
              </div>
              <div class="layui-card col-lg-10">
                <div class="layui-card-header">HE染色<i class="layui-icon layui-icon-delete delete-he"></i></div>
                <div class="layui-card-body">
                  <input type="text" class="form-control" placeholder="Input Box">
                </div>
              </div>
            </div>
            <br/>
            <!-- 特殊染色 -->
            <div class="row teshu-ranse">
              <div class="col-lg-1">
              </div>
              <div class="layui-card col-lg-10">
                <div class="layui-card-header">特殊染色<i class="layui-icon layui-icon-delete delete-ts"></i></div>
                <div class="layui-card-body">
                  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">选择特染方法</button>
                  <p>已选特染方法: <b>4</b></p>
                  <p><span class="label label-info">AB-PAS染色</span><span class="label label-info">AB-PAS染色</span></p>
                </div>
              </div>
            </div>
            <br/>
            <!-- 免疫组化 -->
            <div class="row mianyi-zuhua">
              <div class="col-lg-1">
              </div>
              <div class="layui-card col-lg-10">
                <div class="layui-card-header">免疫组化<i class="layui-icon layui-icon-delete delete-my"></i></div>
                <div class="layui-card-body">
                  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal1">选择标记物</button>
                  <p>已选标记物: <b>4</b></p>
                  <p><span class="label label-info">AFP</span><span class="label label-info">AR</span></p>
                </div>
              </div>
            </div>
            <br/>
            <br/>
            <div class="row button">
              <p><button type="button" class="btn btn-primary">保存</button></p>
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

<!-- 特殊染色方法 模态框 -->
<div class="modal fade report slicing-modal" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg vertical-align-center" role="document" style="left:10%">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">特殊染色方法</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-lg-6">
            <ul id="myTab" class="nav nav-tabs">
              <li class="active"><a href="#home" data-toggle="tab">特染方法</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
              <div class="tab-pane fade in active" id="home">
                <p class="clearfix">
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">Masson三色染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">AB-PAS染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">网状纤维染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">抗酸染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">PAS染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">铜染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">铁染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">AB染色</span>
                </p>
              </div>
            </div>
          </div>
          <div class="col-lg-6">
            <ul id="myTab" class="nav nav-tabs">
              <li class="active"><a href="#home" data-toggle="tab">已选特染方法</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
              <div class="tab-pane fade in active" id="home">
                <p class="clearfix">
                  <span class="label label-info">Masson三色染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">AB-PAS染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">网状纤维染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">抗酸染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">PAS染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">铜染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">铁染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">AB染色<i class="layui-icon layui-icon-close"></i></span>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">确认</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">关闭</button>
      </div>
    </div>
  </div>
</div>
<!-- 免疫组化 模态框 -->
<div class="modal fade report slicing-modal" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg vertical-align-center" role="document" style="left:10%">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">免疫组化标记物</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-lg-6">
            <ul id="myTab" class="nav nav-tabs">
              <li class="active"><a href="#home1" data-toggle="tab">单项</a></li>
              <li><a href="#profile1" data-toggle="tab">套餐</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
              <div class="tab-pane fade in active" id="home1">
                <div class="row">
                  <div class="col-lg-10">
                    <input type="text" class="form-control" placeholder="查询">
                  </div>
                  <div class="col-lg-2">
                    <button type="button" class="btn btn-primary">查询</button>
                  </div>
                </div>
                <br/>
                <p class="clearfix">
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">Masson三色染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">AB-PAS染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">网状纤维染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">抗酸染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">PAS染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">铜染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">铁染色</span>
                  <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">AB染色</span>
                </p>
              </div>
              <div class="tab-pane fade" id="profile1">
                <div class="layui-card">
                  <div class="layui-card-header">胃肠道间质瘤（GIST）</div>
                  <div class="layui-card-body">
                    <p class="clearfix">
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">Masson三色染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">AB-PAS染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">网状纤维染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">抗酸染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">PAS染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">铜染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">铁染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">AB染色</span>
                    </p>
                  </div>
                </div>
                <div class="layui-card">
                  <div class="layui-card-header">鼻咽癌</div>
                  <div class="layui-card-body">
                    <p class="clearfix">
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">Masson三色染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">AB-PAS染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">网状纤维染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">抗酸染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">PAS染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">铜染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">铁染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">AB染色</span>
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-lg-6">
            <ul id="myTab" class="nav nav-tabs">
              <li class="active"><a href="" data-toggle="tab">已选标记物</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
              <div class="tab-pane fade in active" id="">
                <p class="clearfix">
                  <span class="label label-info">Masson三色染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">AB-PAS染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">网状纤维染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">抗酸染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">PAS染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">铜染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">铁染色<i class="layui-icon layui-icon-close"></i></span>
                  <span class="label label-info">AB染色<i class="layui-icon layui-icon-close"></i></span>
                </p>
                <div class="layui-card">
                  <div class="layui-card-header">鼻咽癌<i class="layui-icon layui-icon-delete"></i></div>
                  <div class="layui-card-body">
                    <p class="clearfix">
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">Masson三色染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">AB-PAS染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">网状纤维染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">抗酸染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">PAS染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">铜染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">铁染色</span>
                      <span class="label label-info" title="介绍介绍介绍介绍介绍介绍介绍介绍">AB染色</span>
                    </p>
                  </div>
                </div>
              </div>
              
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary">确认</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">关闭</button>
      </div>
    </div>
  </div>
</div>
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

<script src="js/layui.all.js"></script> <!-- layui -->

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
<script>
  /*染色类型控制显示隐藏*/
  $(".btn-he").click(function (e) {
      $('.he-ranse').css("display","block");
  });
  $(".btn-ts").click(function (e) {
      e.preventDefault();
      $('.teshu-ranse').css("display","block");
  });
  $(".btn-my").click(function (e) {
      e.preventDefault();
      $('.mianyi-zuhua').css("display","block");
  });

  $(".delete-he").click(function (e) {
      $('.he-ranse').css("display","none");
  });
  $(".delete-ts").click(function (e) {
      e.preventDefault();
      $('.teshu-ranse').css("display","none");
  });
  $(".delete-my").click(function (e) {
      e.preventDefault();
      $('.mianyi-zuhua').css("display","none");
  });
</script>
</body>
</html>