<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="style/bootstrap.css" rel="stylesheet">
    <!--<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">-->
    <link href="style/fileinput.css" rel="stylesheet" type="text/css"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css"/>

    <script src="js/jquery.js"></script> <!-- jQuery -->
    <script src="js/sortable.js" type="text/javascript"></script>
    <script src="js/fileinput.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" type="text/javascript"></script>

    <script src="js/bootstrap-select.js"></script>
    <script src="js/bootstrap.js"></script>
</head>
<body>

<input id="input-b9" name="input-b9" type="file" class="fileloading">

<script>
    $("#input-b9").fileinput({
        language : 'zh',
        uploadUrl : "/adminappendfiles",
        autoReplace : true,
        maxFileCount : 1,
        allowedFileExtensions : [ "xls", "xlsx" ],
        browseClass : "btn btn-primary", //按钮样式
        previewFileIcon : "<i class='glyphicon glyphicon-king'></i>"
    }).on("fileuploaded", function(e, data) {
        var res = data.response;
        alert(res.success);
        //$("#logo").attr("value", res.success);
    })
</script>
</body>
</html>