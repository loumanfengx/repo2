<%--
  Created by IntelliJ IDEA.
  User: Kangjh
  Date: 2020/7/23
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
</head>
<body>
<%--<table class="layui-table">
    <colgroup>
        <col width="150">
        <col width="200">
        <col>
    </colgroup>
    <thead>
    <tr>
        <th>用户编码</th>
        <th>用户名</th>
        <th>电话</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userCode}</td>
            <td>${user.userName}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>--%>

<table id="demo" lay-filter="test"></table>
<table class="layui-table" lay-data="{height:315, url:'${pageContext.request.contextPath}/user', page:true, id:'test'}"
       lay-filter="test">
    <thead>
    <tr>
        <th lay-data="{field:'id', width:80, sort: true}">ID</th>
        <th lay-data="{field:'username', width:80}">用户名</th>
        <th lay-data="{field:'sex', width:80, sort: true}">性别</th>
        <%--<th lay-data="{field:'city'}">城市</th>
        <th lay-data="{field:'sign'}">签名</th>
        <th lay-data="{field:'experience', sort: true}">积分</th>
        <th lay-data="{field:'score', sort: true}">评分</th>
        <th lay-data="{field:'classify'}">职业</th>
        <th lay-data="{field:'wealth', sort: true}">财富</th>--%>
    </tr>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.userCode}</td>
            <td>${user.userName}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
    </tbody>
    </thead>
</table>


<script>
    layui.use('table', function () {
        var table = layui.table;
        table.render({
            elem: '#demo'
            , url: ''
            , request: {
                pageName: 'curr' //页码的参数名称，默认：page
                , limitName: 'nums' //每页数据量的参数名，默认：limit
            }
//,…… //其他参数
        });
    });

</script>


</body>
</html>
