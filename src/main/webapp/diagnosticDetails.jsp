<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <!-- Title and other stuffs -->
  <title>诊断详情</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="author" content="">
  <!-- Stylesheets -->
  <link href="style/bootstrap.css" rel="stylesheet">
  <link rel="stylesheet" href="style/bootstrap-table.css">
  <link rel="stylesheet" href="style/bootstrap-editable.css">
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

  <script src="js/bootstrap-table.js"></script>
  <script src="js/bootstrap-table-zh-CN.js"></script>
  <script src="js/bootstrap-editable.js"></script>
  <script src="js/bootstrap-table-editable.js"></script>
  <script src="js/bootstrap-table-export.js"></script>
  
  <script type="text/javascript">
  
  	var index = 1;
  	var object;
  	var maxsel = 0;
        /**
         * 获取参数的键值对对象。
         * @returns {Object}
         */

			var getParam = function() {
				try {
					var url = window.location.href;
					var result = url.split("?")[1];
					var keyValue = result.split("&");
					var obj = {};
					for (var i = 0; i < keyValue.length; i++) {
						var item = keyValue[i].split("=");
						obj[item[0]] = item[1];
					}
					return obj;
				} catch (e) {
					console.warn("There has no param value!");
				}
			};
			
			function showProductPro(showNo){
				var pathologydrawVOs = object.sampleVOs[index-1].pathologydrawVOs;
				for (var i=0; i<pathologydrawVOs.length; i++){
					var productVOs = pathologydrawVO.productVOs;
					for (var i=0; i<productVOs.length; i++){
						productVO = productVOs[i];
						if(showNo == productVO.showNo){
							$("#showno").html("切片编号："+productVO.showNo);
							$("#sampledesc").html("所属标本："+productVO.sampleDesc);
							$("#showsampleno").html("标本编号："+productVO.showSampleNo);
							$("#drawposition").html("取材部位："+productVO.drawPos);
							$("#showdrawno").html("蜡块编号："+productVO.showDrawNo);
							$("#resultkind").html("染色方法："+productVO.resultKind);
							
							$("#sampledesc2").html("当前标本："+productVO.sampleDesc);
							$("#showsampleno2").html("标本编号："+productVO.showSampleNo);
							$("#drawposition2").html("取材部位："+productVO.drawPos);
							$("#showdrawno2").html("蜡块编号："+productVO.showDrawNo);
							$("#resultkind2").html("染色方法："+productVO.resultKind);
						}
					}
				}
			}

			function lakuaihtml(pathologydrawVOs) {
				var str = "";
				str += "<h2>所有切片：</h2>";
				for (var i=0; i<pathologydrawVOs.length; i++){
					pathologydrawVO = pathologydrawVOs[i];
					str += "<div class='layui-card lakuai'>";
					str += "<div class='layui-card-header'>蜡块编号：" + pathologydrawVO.showDrawNo + "</div>";
					str += "<div class='layui-card-body'>";
					str += "<ul class='clearfix'>";
					
					var productVOs = pathologydrawVO.productVOs;
					for (var i=0; i<productVOs.length; i++){
						productVO = productVOs[i];
						str += "<button type='button' class='btn btn-primary' onclick='showProductPro(\"" + productVO.showNo + "\");'>" + productVO.productno + "</li>";
					}
					
					str += "</ul>";
					str += "</div>";
					str += "</div>";
				}
				$("#lakuai").html(str);
				$("#showno").html("切片编号：");
				$("#sampledesc").html("所属标本：");
				$("#showsampleno").html("标本编号：");
				$("#drawposition").html("取材部位：");
				$("#showdrawno").html("蜡块编号：");
				$("#resultkind").html("染色方法：");
				
				$("#sampledesc2").html("当前标本：");
				$("#showsampleno2").html("标本编号：");
				$("#drawposition2").html("取材部位：");
				$("#showdrawno2").html("蜡块编号：");
				$("#resultkind2").html("染色方法：");
				
			};
			
			function changeselected(id){
				var str = "<i class=\"layui-icon layui-icon-ok\"></i>";
				if($("#"+id).attr("class") == "select"){
					$("#"+id).attr("class", "");
					maxsel += -1;
					var innerhtml = $("#"+id).html();
					innerhtml = innerhtml.replace(str, "");
					$("#"+id).html(innerhtml);
					changeselectedvo(id, "N");
				}else{
					$("#"+id).attr("class", "select");
					var innerhtml = $("#"+id).html();
					innerhtml += str;
					$("#"+id).html(innerhtml);
					changeselectedvo(id, "Y");
					maxsel += 1;
				}
				if(maxsel > 4){
					changeselected(id);
				}
			}
			
			function changeselectedvo(id, bool){
				var docsproductid = id.split("_")[1];
				console.log(docsproductid);
				var docsProductVOs = object.docsProductVOs;
				for (var i=0; i<docsProductVOs.length; i++){
					var docsProductVO = docsProductVOs[i];
					if(docsproductid == parseInt(docsProductVO.docsproductid)){
						docsProductVO.selected = bool;
					}
				}
				console.log(docsProductVOs);
			}
			
			function pichtml(docsProductVOs){
				var str = "";
				var str2 = "";
				for (var i=0; i<docsProductVOs.length; i++){
					var docsProductVO = docsProductVOs[i];
					if(docsProductVO.selected == 'Y'){
						str += "<li><a href='" + docsProductVO.docsfilename + "' class='prettyPhoto[pp_gal]'><img src='" + docsProductVO.docsfilename + "' alt=''></a></li>";
						str2 += "<li id=\"picselect_" + docsProductVO.docsproductid +"\" class=\"select\" onclick=\"changeselected('" + "picselect_" + docsProductVO.docsproductid + "')\"><img src=\"" + docsProductVO.docsfilename + "\"><i class=\"layui-icon layui-icon-ok\"></i></li>";
						maxsel += 1;
					}else{
						str2 += "<li id=\"picselect_" + docsProductVO.docsproductid +"\" onclick=\"changeselected('" + "picselect_" + docsProductVO.docsproductid + "')\"><img src='" + docsProductVO.docsfilename + "' ></li>";
					}
				}
				str += "<li class='on' data-toggle='modal' data-target='#exampleModal2'><i class='layui-icon layui-icon-add-1'></i></li>";
				$("#show_pic").html(str);
				$("#pic_selected").html(str2);
			}
			
			function changeDiag(lastindex){
				
				samplevo1 = object.sampleVOs[lastindex-1];
				samplevo1.visualobservation = $("#rouyansuojian").val();
				samplevo1.diagnosismicroscope = $("#jingxiasuojian").val();
				samplevo1.diagnosisspecial = $("#teshujiancha").val();
				samplevo1.diagnosispathology = $("#binglizhenduan").val();
				samplevo1.diagnosisnote = $("#zdbeizhu").val();
				
				console.log(samplevo1);
				
				samplevo2 = object.sampleVOs[index-1];
				$("#rouyansuojian").val(samplevo2.visualobservation);
				$("#jingxiasuojian").val(samplevo2.diagnosismicroscope);
				$("#teshujiancha").val(samplevo2.diagnosisspecial);
				$("#binglizhenduan").val(samplevo2.diagnosispathology);
				$("#zdbeizhu").val(samplevo2.diagnosisnote);
				
				console.log(object.sampleVOs);
			}
			
			function openupdate(id){
				
				$.ajax({
					type : "get",
					url : "/dignosis/deleteAdvice?adviceno=" + id,
					async : false,
					dataType : "json",
					success : function(data) {
						console.log(data);
					    var opt = {
					            url: '/dignosis/selectAdvice',
					            query:{
						            pageSize: 10, //页面大小
						            pageNumber: 1, //页码
						            //筛选参数
						            diagnosisno: object.sampleVOs[index-1].diagnosisno,
					                sortName:"adviceno",
					                sortOrder:"asc"
					            }

					        };
					        $('#tb_tasks').bootstrapTable('refresh',opt);
						
					},
					error : function() {
						alert("Error");
					}
				});
				
			}
			
			function freshTab(){
				var opt = {
			            url: '/dignosis/selectAdvice',
			            query:{
				            pageSize: 10, //页面大小
				            pageNumber: 1, //页码
				            //筛选参数
				            diagnosisno: object.sampleVOs[index-1].diagnosisno,
			                sortName:"adviceno",
			                sortOrder:"asc"
			            }

			        };
			        $('#tb_tasks').bootstrapTable('refresh',opt);
			}

			/**
			 * 页面加载完毕打印键值对对象
			 */
			window.onload = function() {

				var applino = getParam().applino;
				console.log(applino);

				$.ajax({
					type : "get",
					url : "/dignosis/selectDiagnosisdetail?applino=" + applino,
					async : false,
					dataType : "json",
					success : function(data) {
						console.log(data);
						object = data;
						console.log(object);
						$("#pat_name").html(data.name);
						$("#pat_sex").html(data.sex);
						$("#pat_age").html(data.age);
						$("#ipd_no").html(data.hospitalizetionid);
						$("#path_no").html(data.applino);

						console.log(data.sampleVOs.length);

						$("#crt_sample").html(
								index + "/" + data.sampleVOs.length);
						
						var pathologydrawVOs = data.sampleVOs[index-1].pathologydrawVOs;
						$("#lakuai").html("<h2>所有切片：</h2>");
						lakuaihtml(pathologydrawVOs);
						samplevo2 = object.sampleVOs[index-1];
		 				$("#rouyansuojian").val(samplevo2.visualobservation);
		 				$("#jingxiasuojian").val(samplevo2.diagnosismicroscope);
		 				$("#teshujiancha").val(samplevo2.diagnosisspecial);
		 				$("#binglizhenduan").val(samplevo2.diagnosispathology);
		 				$("#zdbeizhu").val(samplevo2.diagnosisnote);
		 				
		 				pichtml(object.docsProductVOs);
						
					},
					error : function() {
						alert("Error");
					}
				});

				$("#next").click(
						function() {
							lastindex = index;
							index = index + 1;
							if (index > object.sampleVOs.length) {
								index = object.sampleVOs.length;
							}
							$("#crt_sample").html(
									index + "/" + object.sampleVOs.length);
							
							var pathologydrawVOs = object.sampleVOs[index-1].pathologydrawVOs;
							$("#lakuai").html("<h2>所有切片：</h2>");
							lakuaihtml(pathologydrawVOs);
							changeDiag(lastindex);
						});

				$("#prev").click(
						function() {
							lastindex = index;
							index = index - 1;
							if (index < 1) {
								index = 1;
							}
							$("#crt_sample").html(
									index + "/" + object.sampleVOs.length);
							
							var pathologydrawVOs = object.sampleVOs[index-1].pathologydrawVOs;
							$("#lakuai").html("<h2>所有切片：</h2>");
							lakuaihtml(pathologydrawVOs);
							changeDiag(lastindex);
						});
				

				$("#save_sel_pic").click(
						function() {
							$.ajax({
								type : "post",
								url : "/dignosis/savePicSel",
								async : false,
								dataType : "json",
								contentType: "application/json;charset=UTF-8",
								data: JSON.stringify(object.docsProductVOs),
								success : function(data) {
									console.log(data);
									pichtml(object.docsProductVOs);
								},
								error : function() {
									alert("Error");
								}
							});
						});
				
				
				$("#savediag").click(
						function() {
							
							samplevo = object.sampleVOs[index-1];
							samplevo.visualobservation = $("#rouyansuojian").val();
							samplevo.diagnosismicroscope = $("#jingxiasuojian").val();
							samplevo.diagnosisspecial = $("#teshujiancha").val();
							samplevo.diagnosispathology = $("#binglizhenduan").val();
							samplevo.diagnosisnote = $("#zdbeizhu").val();
							
							console.log(object);
							
							$.ajax({
								type : "post",
								url : "/dignosis/saveDiagnosis",
								async : false,
								dataType : "json",
								contentType: "application/json;charset=UTF-8",
								data: JSON.stringify(object.sampleVOs),
								success : function(data) {
									console.log(data);
									var applino = getParam().applino;
									$.ajax({
										type : "get",
										url : "/dignosis/selectDiagnosisdetail?applino=" + applino,
										async : false,
										dataType : "json",
										success : function(data) {
											console.log(data);
											object = data;
											console.log(object);
											$("#pat_name").html(data.name);
											$("#pat_sex").html(data.sex);
											$("#pat_age").html(data.age);
											$("#ipd_no").html(data.hospitalizetionid);
											$("#path_no").html(data.applino);

											console.log(data.sampleVOs.length);

											$("#crt_sample").html(
													index + "/" + data.sampleVOs.length);
											
											var pathologydrawVOs = data.sampleVOs[index-1].pathologydrawVOs;
											$("#lakuai").html("<h2>所有切片：</h2>");
											lakuaihtml(pathologydrawVOs);
											samplevo2 = object.sampleVOs[index-1];
							 				$("#rouyansuojian").val(samplevo2.visualobservation);
							 				$("#jingxiasuojian").val(samplevo2.diagnosismicroscope);
							 				$("#teshujiancha").val(samplevo2.diagnosisspecial);
							 				$("#binglizhenduan").val(samplevo2.diagnosispathology);
							 				$("#zdbeizhu").val(samplevo2.diagnosisnote);
											
										},
										error : function() {
											alert("Error");
										}
									});
								},
								error : function() {
									alert("Error");
								}
							});
							
						});
				
				$("#yizhusave").click(
						function() {
							
							$.ajax({
								type : "POST",
								url : "/dignosis/saveDoctorAdvice",
								async : false,
								dataType : "json",
								data: JSON.stringify({
									"jishuyizhu" : $("#jishuyizhu").val(),
									"shuliang" : $("#shuliang").val(),
									"beizhu" : $("#beizhu").val(),
									"tejianyizhu" : $("#tejianyizhu").val(),
									"jutixiangmu" : $("#jutixiangmu").val(),
									"tejianbeizhu" : $("#tejianbeizhu").val(),
									"diagnosisno": object.sampleVOs[index-1].diagnosisno
								}),
								contentType: "application/json;charset=UTF-8",
								success : function(data) {
									console.log(data);
								},
								error : function() {
									alert("Error");
								}
							});
							
							
							
						});
				
			    var oTable = new TableInit();
			    oTable.Init();
			    
			    
			}
			
			
			
			var TableInit = function () {
			    var oTableInit = new Object();
			    //初始化Table
			    oTableInit.Init = function () {
			        $('#tb_tasks').bootstrapTable({
			            url: '/dignosis/selectAdvice', //请求后台的URL（*）
			            //contextMenu: '#example1-context-menu',
			            method: 'get', //请求方式（*）
			            dataType: "json",
			            toolbar: '#toolbar', //工具按钮用哪个容器
			            striped: true, //是否显示行间隔色
			            cache: false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			            pagination: true, //是否显示分页（*）
			            sortable: true, //是否启用排序
			            sortOrder: "asc", //排序方式
			            queryParams: oTableInit.queryParams,//传递参数（*）
			            queryParamsType: "undefined",//undefined
			            singleSelect: false,//复选框只能选择一条记录
			            sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
			            pageNumber:1, //初始化加载第一页，默认第一页
			            pageSize: 10, //每页的记录行数（*）
			            pageList: [10, 25, 50, 100,500], //可供选择的每页的行数（*）
			            search: false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端
			            strictSearch: true,
			            showColumns: true, //是否显示所有的列
			            showRefresh: true, //是否显示刷新按钮
			            minimumCountColumns: 2, //最少允许的列数
			            clickToSelect: true, //是否启用点击选中行
			            height: 'auto', //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			            uniqueId: "adviceno", //每一行的唯一标识，一般为主键列
			            showToggle:true, //是否显示详细视图和列表视图的切换按钮
			            cardView: false, //是否显示详细视图
			            detailView: false, //是否显示父子表
			            showExport: true,
			            exportDataType: "selected",              //'basic', 'all', 'selected'.
			            columns: [
							{checkbox: true},
			                {field:'adviceno',title:'序号',width:45,align:'center',sortable:true},
			                {field:'pdfpath',title:'操作',width:150,align:'left',editable:false,sortable:true,formatter:function(value,row,index){
			                    var temp_html001,temp_html002;
			                    console.log(row);
			                    temp_html001 = '<button type="button" class="btn btn-xs btn-danger" data-toggle="modal" onclick="openupdate(' + row.adviceno + ')">删除</button>';
// 			                    temp_html002 = '<button type="button" class="btn btn-xs btn-success" data-toggle="modal" data-target="#exampleModal" onclick="openupdate(' + row.adviceno + ')" >修改</button>';
								temp_html002 = '';
			                    temp_html002 += '&nbsp&nbsp';
			                    temp_html002 += temp_html001;
			                    return temp_html002;
			                }},
			                {field:'sampledesc',title:'标本',width:50,align:'left',editable:false,sortable:true},
			                {field:'sampleno',title:'标本编号',width:100,align:'left',editable:false,sortable:true},
			                {field:'drawno',title:'蜡块编号',width:50,align:'left',editable:false,sortable:true},
			                {field:'advicekind',title:'医嘱类别',width:50,align:'left',editable:false,sortable:true},
			                {field:'adviceprogram',title:'医嘱项目',width:100,align:'left',editable:false,sortable:true},
			                {field:'advicecontent',title:'医嘱内容',width:100,align:'left',editable:false,sortable:true},
			                {field:'advicenum',title:'数量',width:180,align:'left',editable:false,sortable:true}
			            ],

			            onEditableSave: function (field, row, oldValue, $el) {
			                $.ajax({
			                    error: function () {
			                        //alert("Error");
			                    },
			                    complete: function () {

			                    }

			                });
			            }
			        });
			    };

			    //得到查询的参数
			    oTableInit.queryParams = function (params) {
			        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			            pageSize: params.pageSize, //页面大小
			            pageNumber: params.pageNumber, //页码

			            //筛选参数
			            diagnosisno: 1,
			            sortName:this.sortName,
			            sortOrder:this.sortOrder
			        };
			        return temp;
			    };
			    return oTableInit;
			};
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
          <li><a href="index.jsp"><i class="icon-home"></i> 首页 </a></li>
          <li class="has_sub"><a href="#"><i class="icon-list-alt"></i> 申请登记 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
            <ul>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 申请登记 </a></li>
              <li><a href="widgets2.html"><i class="icon-list-alt"></i> 冰冻预约 </a></li>
            </ul>
          </li>
          <li class="has_sub"><a href="#"><i class="icon-file-alt"></i> 列表信息 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
            <ul>
              <li><a href="eqpatientinfo.jsp"><i class="icon-list-alt"></i> 患者列表 </a></li>
              <li><a href="patientappli.jsp"><i class="icon-list-alt"></i> 申请列表 </a></li>
              <li><a href="acceptsample.jsp"><i class="icon-list-alt"></i> 样本列表 </a></li>
              <li><a href="product.jsp"><i class="icon-list-alt"></i> 切片列表 </a></li>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 图文报告 </a></li>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 会诊列表 </a></li>
            </ul>
          </li>
          <li class="has_sub"><a href="#"><i class="icon-file-alt"></i> 取材制片 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
            <ul>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 大体取材 </a></li>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 制片管理 </a></li>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 特殊检验 </a></li>
            </ul>
          </li>
          <li class="has_sub"><a href="charts.html"><i class="icon-bar-chart"></i> 扫描管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
            <ul>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 扫描管理 </a></li>
            </ul>
          </li>
          <li class="has_sub"><a href="charts.html" class="open"><i class="icon-table"></i> 诊断管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
            <ul>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 阅片诊断 </a></li>
            </ul>
          </li>
          <li class="has_sub"><a href="charts.html"><i class="icon-tasks"></i> 报告管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
            <ul>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 报告签收 </a></li>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 报告归档 </a></li>
            </ul>
          </li>
          <li class="has_sub"><a href="charts.html"><i class="icon-magic"></i> 质控管理 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
            <ul>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 质控管理 </a></li>
            </ul>
          </li>
          <li class="has_sub"><a href="charts.html"><i class="icon-calendar"></i> 系统配置 <span class="pull-right"><i class="icon-chevron-right"></i></span></a>
            <ul>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 数据字典 </a></li>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> 常用语 </a></li>
              <li><a href="postTask.html"><i class="icon-list-alt"></i> ICH项目 </a></li>
            </ul>
          </li>
        </ul>
    </div>
    <!-- Sidebar ends -->
  	  	<!-- Main bar -->
  	<div class="mainbar">
	    <!-- Page heading -->
	    <div class="page-head">
	      <h2 class="pull-left"><i class="icon-home"></i> 诊断详情 </h2>
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
              <p>姓名</p>
            </div>
            <div class="col-lg-1">
              <p id="pat_name">123</p>
            </div>
            <div class="col-lg-1">
              <p>性别</p>
            </div>
            <div class="col-lg-1">
              <p id="pat_sex">123</p>
            </div>
            <div class="col-lg-1">
              <p>年龄</p>
            </div>
            <div class="col-lg-1">
              <p id="pat_age">123</p>
            </div>
            <div class="col-lg-1">
              <p>住院号</p>
            </div>
            <div class="col-lg-1">
              <p id="ipd_no">123</p>
            </div>
            <div class="col-lg-1">
              <p>病理号</p>
            </div>
            <div class="col-lg-1">
              <p id="path_no">123</p>
            </div>
          </div>
          <br/>
          <br/>
          <ul class="pager">
            <li class="previous"><a href="#" id="prev">&larr; Prev</a></li>
            <li class="number" id="crt_sample">1/3</li>
            <li class="next"><a href="#" id="next">Next &rarr;</a></li>
          </ul>
          <div class="row">
            <div class="diagnosis">
              <h1>病理诊断：</h1>
              <form class="form-horizontal col-lg-3" role="form">
                  <label> 肉眼所见 </label>
                  <div>
                    <textarea class="form-control" rows="3" placeholder="（这里显示为大体取材时的记录）" id="rouyansuojian"></textarea>
                  </div>
                  <label> 镜下所见 </label>
                  <div>
                    <textarea class="form-control" rows="3" placeholder="" id="jingxiasuojian"></textarea>
                  </div>
                  <label> 特殊检查 </label>
                  <div>
                    <textarea class="form-control" rows="3" placeholder="" id="teshujiancha"></textarea>
                  </div>
                
                  <label> 病理诊断 </label>
                  <div>
                    <textarea class="form-control" rows="3" placeholder="" id="binglizhenduan"></textarea>
                  </div>
                
                  <label> 备注 </label>
                  <div>
                    <textarea class="form-control" rows="3" placeholder="" id="zdbeizhu"></textarea>
                  </div>
                  
                  <div class="layui-card-body">
                  	<button type="button" class="btn btn-primary" data-toggle="modal" style="display:block;margin:0 auto" id="savediag">保存诊断</button>
                  </div>
              </form>
              <div class="col-lg-2">
                <div class="layui-collapse">
                  <div class="layui-colla-item">
                    <p class="layui-colla-title">部位常用词</p>
                    <div class="layui-colla-content layui-show">肝</div>
                    <div class="layui-colla-content layui-show">肾</div>
                    <div class="layui-colla-content layui-show">皮肤</div>
                    <div class="layui-colla-content layui-show">口腔</div>

                  </div>
                </div>
              </div>
              <div class="col-lg-2">
                <div class="layui-card">
                  <div class="layui-card-header">肝常用词</div>
                  <div class="layui-card-body">
                    肝脏区域
                  </div>
                </div>
              </div>
              <div class="section col-lg-2" id="lakuai">
                <h2>所有切片：</h2>
                <div class="layui-card lakuai">
                  <div class="layui-card-header">蜡块编号：xxxxxx-01-01</div>
                  <div class="layui-card-body">
                    <ul class="clearfix">
                      <li class="blue">1</li>
                      <li class="blue">2</li>
                      <li class="blue">3</li>
                      <li class="violet">4</li>
                      <li class="violet">5</li>
                      <li class="violet">6</li>
                      <li class="yellow">7</li>
                      <li class="yellow">8</li>
                    </ul>
                  </div>
                </div>
                <div class="layui-card lakuai">
                  <div class="layui-card-header">蜡块编号：xxxxxx-01-01</div>
                  <div class="layui-card-body">
                    <ul class="clearfix">
                      <li class="blue">1</li>
                      <li class="blue">2</li>
                      <li class="blue">3</li>
                      <li class="violet">4</li>
                      <li class="violet">5</li>
                      <li class="violet">6</li>
                      <li class="yellow">7</li>
                      <li class="yellow">8</li>
                    </ul>
                  </div>
                </div>
              </div>  
              <div class="section col-lg-3">
                <h2>当前切片信息：</h2>
                <div class="layui-card lakuai">
                  <div class="layui-card-body">
                    <p id="showno">切片编号：xxxxxx-01-01-01</p>
                    <p id="sampledesc">所属标本：肝脏</p>
                    <p id="showsampleno">标本编号：xxxxxx-01</p>
                    <p id="drawposition">取材部位：肿物中心</p>
                    <p id="showdrawno">蜡块编号：xxxxxx-01-01</p>
                    <p id="resultkind">染色方法：HE染色</p>
                    <div class="button">
                      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">+补充医嘱</button>
                      <p><span data-toggle="modal" data-target="#exampleModal1" onclick="freshTab()">查看明细（1）</span></p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="diagnosis report-image">
              <h1>报告图像：</h1>
              <ul class='clearfix' id="show_pic">
<!--                 <li><a href="img/photos/s1.jpg" class="prettyPhoto[pp_gal]"><img src="img/photos/t1.jpg" alt=""></a></li> -->
<!--                 <li><a href="img/photos/s2.jpg" class="prettyPhoto[pp_gal]"><img src="img/photos/t2.jpg" alt=""></a></li> -->
<!--                 <li><a href="img/photos/s3.jpg" class="prettyPhoto[pp_gal]"><img src="img/photos/t3.jpg" alt=""></a></li> -->
                <li class="on" data-toggle="modal" data-target="#exampleModal2"><i class="layui-icon layui-icon-add-1"></i></li>
              </ul>
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



<!-- 补充医嘱 模态框 -->
<div class="modal fade report yizhu" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg vertical-align-center" role="document" style="left:10%">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">补充医嘱</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p id="sampledesc2">当前标本：肝脏</p>
 		<p id="showsampleno2">标本编号：xxxxxx-01</p>
 		<p id="drawposition2">取材部位：肿物中心</p>
 		<p id="showdrawno2">蜡块编号：xxxxxx-01-01</p>
		<p id="resultkind2">染色方法：HE染色</p>
        <!-- Form starts.  -->
        <form class="form-horizontal" role="form">
          <div class="form-group">
            <div class="row">
              <label class="col-lg-1 control-label"> 技术医嘱 </label>
              <div class="col-lg-4">
                <input type="text" class="form-control" placeholder="Input Box" id="jishuyizhu">
              </div>
              <label class="col-lg-1 control-label"> 数量 </label>
              <div class="col-lg-4">
                <input type="text" class="form-control" placeholder="Input Box" id="shuliang">
              </div>
            </div>
            <br/>
            <div class="row">
              <label class="col-lg-1 control-label"> 备注 </label>
              <div class="col-lg-8">
                <input type="text" class="form-control" placeholder="Input Box" id="beizhu">
              </div>
            </div>
            <br/>
            <div class="row">
              <label class="col-lg-1 control-label"> 特检医嘱 </label>
              <div class="col-lg-4">
                <input type="text" class="form-control" placeholder="Input Box" id="tejianyizhu">
              </div>
              <label class="col-lg-1 control-label"> 具体项目 </label>
              <div class="col-lg-4">
                <input type="text" class="form-control" placeholder="Input Box" id="jutixiangmu">
              </div>
            </div>
            <br/>
            <div class="row">
              <label class="col-lg-1 control-label"> 备注 </label>
              <div class="col-lg-8">
                <input type="text" class="form-control" placeholder="Input Box" id="tejianbeizhu">
              </div>
            </div>
          </div>
        </form> 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="yizhusave">确认</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">关闭</button>
      </div>
    </div>
  </div>
</div>

<!-- 查看明细 模态框 -->
<div class="modal fade report" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg vertical-align-center" role="document" style="left:10%">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">补充医嘱信息列表</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <br/>
		<table id="tb_tasks"></table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">关闭</button>
      </div>
    </div>
  </div>
</div>

<!-- 报告图像 模态框 -->
<div class="modal fade report report-image" id="exampleModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg vertical-align-center" role="document" style="left:10%">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">选取报告图片</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="choice">
          <p>最多选择4张</p>
          <ul class="clearfix" id="pic_selected">
<!--             <li class="select"><img src="" ><i class="layui-icon layui-icon-ok"></i></li> -->
<!--             <li><img src="" ></li> -->
<!--             <li><img src="" ></li> -->
<!--             <li><img src="" ></li> -->
<!--             <li><img src="" ></li> -->
<!--             <li><img src="" ></li> -->
<!--             <li><img src="" ></li> -->
<!--             <li><img src="" ></li> -->
<!--             <li><img src="" ></li> -->
<!--             <li><img src="" ></li> -->
          </ul>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" id="save_sel_pic">确认</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" aria-label="Close">关闭</button>
      </div>
    </div>
  </div>
</div>


<!-- Scroll to top -->
<span class="totop"><a href="#"><i class="icon-chevron-up"></i></a></span> 

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
  layui.use(['element', 'layer'], function(){
    var element = layui.element;
    var layer = layui.layer;
    
    //监听折叠
    element.on('collapse(test)', function(data){
      layer.msg('展开状态：'+ data.show);
    });
  });
</script>
</body>
</html>