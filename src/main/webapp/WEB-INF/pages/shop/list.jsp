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
     <a href="add">添加</a>
     <table id="tb">
         <thead>
              <tr>
                  <th>商品名称</th>
                  <th>商品类型</th>
                  <th>商品品牌</th>
                  <th>商品价格</th>
                  <th>是否有效</th>
                  <th>操作</th>
              </tr>
         </thead>
         <tbody>
              <c:forEach items="${list}" var="shop">
                         <tr>
                             <td>${shop.name}</td>
                             <td>${shop.type}</td>
                             <td>${shop.brand}</td>
                             <td>${shop.price}</td>
                             <td>
                                 <c:if test="${shop.is_del==1}">有效</c:if>
                                 <c:if test="${shop.is_del==0}">无效</c:if>
                             </td>
                             <td>
                                 <a href="update?id=${shop.id}">修改</a>
                                 <c:if test="${shop.is_del==1}" >
                                       <a href="javascript:void(0)" onclick="del(${shop.id},1)">删除</a>
                                 </c:if>
                                 <c:if test="${shop.is_del==0}">
                                     <a href="javascript:void(0)" onclick="del(${shop.id},0)">恢复</a>
                                 </c:if>
                                 <a href="../car/add?id=${shop.id}">添加购物车</a>
                             </td>
                         </tr>
              </c:forEach>
         </tbody>
     </table>
     <script>
         function del(id,flag) {
             var message = flag==1?"确定要删除吗？":"确定要恢复吗？"
             if(confirm(message)){
                 window.location.href="del?id="+id+"&flag="+flag;
             }
         }
     </script>
</body>
</html>
