<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/19
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1></h1>
<form action="upload" enctype="multipart/form-data" method="post">
    选择第一个文件
    <input type="file" name="uploadFile" /><br>
    选择第二个文件
    <input type="file" name="uploadFile2" /><br>
    <input type="text" name="test">
    <input type="submit" value="上传" />
</form>
</body>
</html>
