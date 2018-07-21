<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <!-- Title and other stuffs -->
    <title>用户注册页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="">
    <!-- Stylesheets -->
    <link href="style/bootstrap.css" rel="stylesheet">
    <link rel="stylesheet" href="style/font-awesome.css">
    <link href="style/style.css" rel="stylesheet">
    <link href="style/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 Support for IE -->
    <!--[if lt IE 9]>
    <script src="js/html5shim.js"></script>
    <![endif]-->

    <!-- Favicon -->
    <link rel="shortcut icon" href="img/favicon/favicon.png">

    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/messages_zh.js"></script>

    <script>
        $().ready(function() {

            $.validator.setDefaults({
            /**
                 submitHandler: function(form) {
                    form.submit();
                }
            */
            });

            $("#form-reg").validate({
                //设置为调试模式
                //debug:true,
                rules:{
                    email:{
                        email:true
                    },
                    grade:{
                        required:true
                    },
                    password:{
                        required:true,
                        minlength:6
                    },
                    age:{
                        maxlength:2,
                        min:16
                    },
                    xieyi:{
                        required:true
                    },
                    username:{
                        required:true,
                        minlength:3,

                        remote:{
                            type:"POST",
                            url:"/testUserName",
                            data:{
                                username:function(){
                                    return $("#username").val();
                                }
                            },
                            dataType:"html",
                            dataFilter:function(data,type){
                                if(data == "true")
                                    return true;
                                else
                                    return false;
                            }
                        }

                    }
                },
                messages:{
                    username:{
                        required:'必填',
                        minlength:'用户名最少3字符',
                        remote:'用户名已经被注册！'
                    },
                    age:{
                        maxlength:'不符合年龄格式'
                    },
                    password:{
                        required:'必填',
                        minlength:'密码最少6字符'
                    },
                    email:{
                        email:'不符合邮箱格式'
                    },
                    grade:{
                        required:'必填'
                    },
                    xieyi:{
                        required:'必填'
                    }
                }

            });

        });
    </script>
    <style>
        .error{
            color:red;
        }
    </style>

</head>

<body>

<div class="admin-form">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <!-- Widget starts -->
                <div class="widget wred">
                    <div class="widget-head">
                        <i class="icon-lock"></i> Register
                    </div>
                    <div class="widget-content">
                        <div class="padd">

                            <form class="form-horizontal" action="/registerStaff" method="post" id="form-reg">
                                <!-- Registration form starts -->
                                <!-- Name -->
                                <div class="form-group">
                                    <label class="control-label col-lg-3" for="name">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名</label>
                                    <div class="col-lg-9">
                                        <input type="text" class="form-control" id="name" name="name">
                                    </div>
                                </div>
                                <!-- Phone -->
                                <div class="form-group">
                                    <label class="control-label col-lg-3" for="phone">电话号码</label>
                                    <div class="col-lg-9">
                                        <input type="text" class="form-control" id="phone" name="phone">
                                    </div>
                                </div>
                                <!-- Age -->
                                <div class="form-group">
                                    <label class="control-label col-lg-3" for="age">年&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp龄</label>
                                    <div class="col-lg-9">
                                        <input type="text" class="form-control" id="age" name="age">
                                    </div>
                                </div>
                                <!-- Email -->
                                <div class="form-group">
                                    <label class="control-label col-lg-3" for="email">电子邮箱</label>
                                    <div class="col-lg-9">
                                        <input type="email" class="form-control" id="email" name="email">
                                    </div>
                                </div>
                                <!-- Select box grade-->
                                <div class="form-group">
                                    <label class="control-label col-lg-3" for="grade">用户等级</label>
                                    <div class="col-lg-9">
                                        <select class="form-control" id="grade" name="grade">
                                            <option></option>
                                            <option value="1">普通用户</option>
                                            <option value="2">超级用户</option>
                                            <option value="3">管理员</option>
                                        </select>
                                    </div>
                                </div>
                                <!-- Select box sex-->
                                <div class="form-group">
                                    <label class="control-label col-lg-3" for="sex">性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别</label>
                                    <div class="col-lg-9">
                                        <select class="form-control" id="sex" name="sex">
                                            <option></option>
                                            <option>男</option>
                                            <option>女</option>
                                        </select>
                                    </div>
                                </div>
                                <!-- Username -->
                                <div class="form-group">
                                    <label class="control-label col-lg-3" for="username">用&nbsp&nbsp户&nbsp&nbsp名</label>
                                    <div class="col-lg-9">
                                        <input type="text" class="form-control" id="username" name="username">
                                    </div>
                                </div>
                                <!-- Password -->
                                <div class="form-group">
                                    <label class="control-label col-lg-3" for="password">密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码</label>
                                    <div class="col-lg-9">
                                        <input type="password" class="form-control" id="password" name="password">
                                    </div>
                                </div>
                                <!-- Accept box and button s-->
                                <div class="form-group">
                                    <div class="col-lg-9 col-lg-offset-3">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox" id="xieyi" name="xieyi"> 接受协议
                                            </label>
                                        </div>
                                        <br />
                                        <button type="submit" class="btn btn-danger">注册</button>
                                        <button type="reset" class="btn btn-success">重置</button>
                                    </div>
                                </div>
                                <br />
                            </form>

                        </div>
                    </div>
                    <div class="widget-foot">
                        已经注册? <a href="login.jsp">登录</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<!-- JS -->

</body>
</html>