<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/13 0013
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <form action="update" method="post">
                 <input type="hidden" name="id" value="${shop.id}" />
                商品名称:<input name="name" value="${shop.name}" /><br/>
                商品类型:<input name="type" value="${shop.type}" /><br/>
                商品品牌:<input name="brand" value="${shop.brand}" /><br/>
                商品价格:<input name="price"value="${shop.price}" /><br/>
                <button>保存</button>
        </form>
</body>
</html>
