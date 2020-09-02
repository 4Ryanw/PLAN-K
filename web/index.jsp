<%--
  Created by IntelliJ IDEA.
  User: 4Ryanw
  Date: 2020/8/31
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>凯计划</title>
    <script src="static/js/jQuery v1.10.2.js"></script>
    <style>
    </style>
  </head>
  <body>
 <h1>凯计划实施中 ing...</h1>
 <div style="margin: auto;width:50%;">
   <h3 style="margin-left: 10rem;">你选择的文件<span style="margin-left: 3rem">↓👇↓</span></h3>


     <form action="/Upload" enctype="multipart/form-data" method="post">
         <input style="margin-left: 15rem;" type="file" name="pic">
         <input type="submit" value="提交文件"> <span>${requestScope.success}<br></span>
     </form>


 </div>


  </body>
</html>
