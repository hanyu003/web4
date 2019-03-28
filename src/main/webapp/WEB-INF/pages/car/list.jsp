<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/13 0013
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        #tb{
            border-collapse: collapse;
        }
        #tb th,#tb td{
            border: 1px solid #999;
            padding: 5px 10px;
        }
    </style>
</head>
<body>
<table id="tb">
    <thead>
    <tr>
        <th>商品名称</th>
        <th>商品类型</th>
        <th>商品品牌</th>
        <th>商品价格</th>
        <th>数量</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="car">
        <tr>
            <td>${car.name}</td>
            <td>${car.type}</td>
            <td>${car.brand}</td>
            <td>${car.price}</td>
            <td>${car.count}</td>
            <td>
                <a href="javascript:void(0)" onclick="del(${car.id})">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script>
    function del(id) {
        var message = "确定要删除吗？"
        if(confirm(message)){
            window.location.href="del?id="+id;
        }
    }
</script>
</body>
</html>
