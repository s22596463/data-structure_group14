<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
</head>
<body>

<%
String[][] orderList = (String[][])  request.getAttribute("query");
 for(int i =0 ; i < orderList.length;i++){%> 
	<a href='<%= orderList[i][1] %>'><%= orderList[i][0] %></a><br><h style="font-size:10px;"><%= orderList[i][1] %></h><br><br> 
 <% 
 }
 %> 

<img src="/FinalDemo_G14/Img/outcomeright.jpg" style=width:770px;height:670px;position:absolute;right:0px;bottom:0px;z-index:-1>
<img src="/FinalDemo_G14/Img/333.gif" style=width:200px;height:200px;position:absolute;bottom:0px;left:650px;z-index:-1 >

</body>
</html>