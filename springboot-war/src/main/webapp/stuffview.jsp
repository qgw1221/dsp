<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'stuffview.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <script src="//cdn.bootcss.com/jquery/1.7.2/jquery.min.js"></script>
  <script type="text/javascript">
  function deletestuff(stuffID){
  	$.ajax({
  		 //url:'<%=basePath%>stuff/deleteStuff.action',
  		 data:{'stuffID':stuffID},
  		 datatype:'json',
  		 type:'post',
  		 contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
  		 success: function(data){
  		 	window.alert('删除成功，即将刷新页面');
  		  	location.reload()
  		  }
  		  });
  }
  function reupdatestuff(t,y,u,i,o){
  	//alert(t+","+y+","+u+","+i+","+o);
  	$("#stuffID1").val(t);
  	$("#stuffName").val(y);
  	$("#stuffPassword").val(u);
  	$("#stuffPosition").val(i);
  	$("#stuffArea").val(o);
  }
  function updatestuff(stuffID){
  	var stuffID = $("#stuffID").val();
    var stuffname = $("#stuffName").val();
    var stuffPassword = $("#stuffPassword").val();
    var stuffPosition = $("#stuffPosition").val();
    var stuffArea = $("#stuffArea").val();
  	$.ajax({
  		 //url:'<%=basePath%>stuff/updateStuff.action',
  		 data:{'stuffID':stuffID,'stuffName':stuffname,'stuffPassword':stuffPassword,
  		 'stuffPosition':stuffPosition,'stuffArea':stuffArea},
  		 datatype:'json',
  		 type:'post',
  		 contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
  		 success: function(data){
  		 	window.alert('修改信息成功，即将刷新页面');
  		  	location.reload()
  		  }
  		  });
  }
  function resetstuff(stuffID){
  	$.ajax({
  		//url:'<%=basePath%>stuff/resetStuff.action',
  		 data:{'stuffID':stuffID,'stuffPassword':'123456'},
  		 datatype:'json',
  		 type:'post',
  		 contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
  		 success: function(data){
  		 	window.alert('修改成功，即将刷新页面');
  		  	location.reload()
  		  }
  		  });
  }
  </script>
  <body>
    <table width="80%" align="center" name="stufftable" border="1" cellspacing="0" style="text-align:center;page: auto;">
    <tr>
    	<td>账号</td>
    	<td>用户名</td>
    	<td>密码</td>
    	<td>角色</td>
    	<td>地区</td>
    	<td>删除</td>
    	<td>重置密码</td>
    </tr>
    <c:forEach var="i" begin="1" end="5">
    <tr>
    	<td>${i+0}</td>
    	<td>${i+1}</td>
    	<td>${i+2}</td>
    	<td>${i+3}</td>
    	<td>${i+4}</td>
    	<td>
    	<button onclick="deletestuff(${i})">删除</button>
    	<button onclick="reupdatestuff(${i},${i+1},${i+2},${i+3},${i+4})">修改</button>
    	</td>
    	<td>
    	<button onclick="resetstuff(${i})">重置密码</button>
    	</td>
    </tr>
    </c:forEach>
    </table>
    <table width="80%" align="center" name="stufftable2" border="1" cellspacing="0" style="text-align:center;page: auto;">
    <tr>
    	<td>账号</td>
    	<td>用户名</td>
    	<td>密码</td>
    	<td>角色</td>
    	<td>地区</td>
    	<td>操作</td>
    </tr>
    <tr>
    	<td><input id="stuffID1"/></td>
    	<td><input id='stuffName' /></td>
    	<td><input id='stuffPassword'/></td>
    	<td><input id='stuffPosition'/></td>
    	<td><input id='stuffArea'/></td>
    	<td>
    	<button onclick="updatestuff(${bean.stuffID})">修改</button>
    	</td>
    </tr>
    <br>
     <a href="<%=basePath%>jsp/addStuff.jsp">Add</a>
     <br>
    <a href="<%=basePath%>jsp/manager.jsp">Return.</a>
    </body>
</html>
