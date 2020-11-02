<%--
  Created by IntelliJ IDEA.
  User: Kangjh
  Date: 2020/7/24
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据表格</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css">
<%--  引入layui.js需要使用  layui.use()语法--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
</head>
<body>
<%--定义layui数据表格--%>
<table class="layui-hide" id="userTable" lay-filter="userTable"></table>
<script type="text/javascript">
    //使用多个模块用['模块名1','模块名2']
    layui.use(['table'], function () {
        var table = layui.table;
        //渲染数据表格
        table.render({
            elem: '#userTable'
            , url: '${pageContext.request.contextPath}/user'
            ,parseData:function (res) {
                return{
                    "code": res.status, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count": res.users.total, //解析数据长度
                    "data": res.users.list //解析数据列表
                }
            }
            , title: '用户数据表'
            , page: true
            ,limit:6
            , cols: [[
               // {type: 'checkbox', fixed: 'left'}
                {field: 'id', title: 'ID'}
                , {field: 'userName', title: '用户名'}
                , {field: 'gender', title: '性别', sort: true,templet:function (d) {
                        return d.gender == '2' ? '男' : '女';
                    }}
            ]]

        });
    });
</script>
</body>
</html>
