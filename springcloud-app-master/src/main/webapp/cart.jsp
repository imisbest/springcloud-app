<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>info</title>
    <link rel="stylesheet" href="${path}/statics/bootstrap/css/bootstrap.min.css">
    <!--引入jqgrid的bootstrap css-->
    <link rel="stylesheet" href="${path}/statics/jqgrid/css/ui.jqgrid-bootstrap.css">
    <!--引入jquery核心js-->
    <script src="${path}/statics/js/jquery-3.4.1.min.js"></script>
    <!--引入jqgrid核心js-->
    <script src="${path}/statics/jqgrid/js/jquery.jqGrid.min.js"></script>
    <!--引入jqgrid国际化js-->
    <script src="${path}/statics/jqgrid/i18n/grid.locale-cn.js"></script>
    <!--引入bootstrap组件js-->
    <script src="${path}/statics/bootstrap/js/bootstrap.min.js"></script>
    <title>购物车</title>
    <script>
        $(function () {
            $.post('${path}/master/queryAll', function (data) {
                console.log("data]" + data);
                $('#thead').empty();
                $('#tbody').empty();
                $('#thead').append("<tr><th>ID</th><th>名字</th><th>图片</th><th>描述</th><th>数量</th><th>单价</th></tr>");
                for (let i = 0; i < data.length; i++) {
                    console.log(data[i]);
                    $('#tbody').append('<tr><td>' + data[i].productId + '</td><td>' + data[i].productName + '</td><td>' + data[i].productIcon + '</td><td>' + data[i].productDescription + '</td><td>' + data[i].productQuantity + '</td><td>' + data[i].productPrice + '</td> </tr>\n');
                }
                $('#tbody').append('<br/><a href="http://localhost:8772/master/createOrder" >创建订单</a>');
            }, 'json')
        })
    </script>
</head>
<body>
<ul>
    <table class="table table-condensed">`````````````
        <caption>商品信息</caption>
        <thead id="thead">

        </thead>
        <tbody id="tbody">

        </tbody>
    </table>

</ul>
</body>
</html>