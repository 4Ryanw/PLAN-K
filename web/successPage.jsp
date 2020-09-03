<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="bean.Info" %>
<%@ page import="bean.Result" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/3/003
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>上传成功</title>
    <style type="text/css">
            /* gridtable */
           table.gridtable {
                  font-family: verdana,arial,sans-serif;
                   font-size:11px;
                    color:#333333;
                    border-width: 1px;
                    border-color: #666666;
                   border-collapse: collapse;
               margin-top: 2rem;
               }
           table.gridtable th {
                        border-width: 1px;
                          padding: 8px;
                          border-style: solid;
                          border-color: #666666;
                           background-color: #dedede;
                       }
          table.gridtable td {
                        border-width: 1px;
                           padding: 8px;
                          border-style: solid;
                           border-color: #666666;
                         background-color: #ffffff;
                     }
        </style>
</head>
<body>



<h1>上传成功</h1>
<div>
    <button style="margin-right: 4rem" onclick="window.location.href='/'">《返回</button>
    <button onclick="window.location.href='/Stastic'">统计</button>
</div>
<table id="table1" class="gridtable">
    <tr>
        <th>大区</th>
        <th>运营中心</th>
        <th>门店数量</th>
        <th>无水鸡汤演示数量</th>
        <th>演示率(%)</th>
    </tr>
    <c:forEach items="${list}" var="result">
    <tr>
        <td>${result.region}</td>
        <td>${result.name}</td>
        <td>${result.total}</td>
        <td>${result.count}</td>
<%--        //<td>${result.count/result.total}</td>--%>
        <td><fmt:formatNumber type="number" value="${((result.count*100)/result.total)}" maxFractionDigits="2"/> </td>
    </tr>
    </c:forEach>
</table>
</body>
<script>
</script>
</html>
