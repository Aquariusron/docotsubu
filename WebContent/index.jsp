<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶへようこそ</h1>
<form action="/docoTsubu/Login" method ="post" >
ユ－ザ－名：<input type = "text"  name ="name" >
<br><% // nameという名前でテキストタイプのデ－タを送る %>
パスワ－ド：<input type = "password" name = "pass">
<br><% // passという名前でパスタイプの以下略。javaのロジックとやり取りをする。%>
<input type = "submit" value = "ログイン">
</form>
</body>
</html>