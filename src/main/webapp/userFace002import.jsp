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
  <script src="js/userFace001import.js"></script>

</head>


<body>




<!-- Header starts -->
  <header>
    <div class="container">
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

        <!-- Button section -->
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
          <li><a href="userFace002import.jsp" class="open"><i class="icon-bar-chart"></i> 数据导入</a></li>
          <li><a href="userFace002.jsp"><i class="icon-table"></i> 化药筛选</a></li>
          <li><a href="userFace002zhongyao.jsp"><i class="icon-tasks"></i> 中药筛选</a></li>
          <li><a href="userFace002shengyao.jsp"><i class="icon-magic"></i> 生药筛选</a></li>
        </ul>
    </div>

    <!-- Sidebar ends -->

  	<!-- Main bar -->
  <div class="mainbar">

    <!-- Page heading -->
    <div class="page-head">
      <h2 class="pull-left"><i class="icon-home"></i> 数据导入</h2>

      <!-- Breadcrumb -->
      <div class="bread-crumb pull-right">
        <a href="userFace002.jsp"><i class="icon-home"></i> Home</a>
        <!-- Divider -->
        <span class="divider">/</span>
        <a href="#" class="bread-current">Import</a>
      </div>

      <div class="clearfix"></div>

    </div>
    <!-- Page heading ends -->


    <!-- Matter -->

    <div class="matter">
      <div class="container">
        <div class="row">
          <!-- post sidebar -->
          <div class="col-md-12">

            <div class="widget">
              <div class="widget-head">
                <div class="pull-left">上传文件</div>
                <div class="widget-icons pull-right">
                  <a href="#" class="wminimize"><i class="icon-chevron-up"></i></a>
                  <a href="#" class="wclose"><i class="icon-remove"></i></a>
                </div>
                <div class="clearfix"></div>
              </div>
              <div class="widget-content">
                <div class="padd">
                  <form>
                    <div class="form-group" style="margin-top:15px">
                      <div class="col-sm-12">
                        <select id="txt_search_tablename" data-first-option="false" data-live-search="true" class="selectpicker form-control show-tick" title='请选择导入的数据表'></select>
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <div class="col-sm-12">
                        <input id="input-b9" name="input-b9" type="file" class="file">
                      </div>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                      <div class="col-sm-12">
                        <div class="btn-group">
                          <button type="button" id="btn_output" class="btn btn-success">导入</button>
                        </div>
                      </div>
                    </div>
                  </form>
                </div>
                <div class="widget-foot">
                  <!-- Footer goes here -->
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

<!-- Scroll to top -->
<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span> 


<script>

    $("#input-b9").fileinput({
        language : 'zh',
        uploadUrl : "/adminappendfiles",
        autoReplace : true,
        maxFileCount : 1,
        allowedFileExtensions : [ "xls", "xlsx" ],
        browseClass : "btn btn-primary", //按钮样式
        previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
        uploadExtraData : function(previewId, index) {
            var obj = {};
            obj.tablename = $("#txt_search_tablename").val();
            return obj;
        }
    }).on("fileuploaded", function(e, data) {
        var res = data.response;
    });
</script>
</body>
</html>