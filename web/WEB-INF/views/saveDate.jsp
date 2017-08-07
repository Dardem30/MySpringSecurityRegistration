<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%--<html lang="en">--%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap datetimepicker</title>
    <script type="text/javascript" src="${contextPath}/resources1/js/jquery-1.11.1.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources1/js/moment-with-locales.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources1/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${contextPath}/resources1/js/bootstrap-datetimepicker.min.js"></script>
    <link rel="stylesheet" href="${contextPath}/resources1/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${contextPath}/resources1/css/bootstrap-datetimepicker.min.css" />
</head>
<body style="margin:40px;">

<h1 class="page-header">Bootstrap datetimepicker</h1>
<h2>datetimepicker1</h2>
<div class="form-group">
    <div class="input-group date" id="datetimepicker1">
        <input type="text" class="form-control" />
        <span class="input-group-addon">
        <%--<span class="glyphicon-calendar glyphicon"></span>--%>
      </span>
    </div>
</div>

<h2>datetimepicker2</h2>
<input type="text" class="form-control" id="datetimepicker2">


<spring:form modelAttribute="employeeDate" method="post" action="/saveEmployeeDate">
    <spring:input path="date" name="time" type="datetime-local"/>
    <spring:button>ok</spring:button>
</spring:form>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker({
            defaultDate: "09.01.2015",
            pickTime: false,
            date: 'glyphicon glyphicon-calendar'
        });
        $('#datetimepicker2').datetimepicker({
            pickDate: false,
            ampm: false,
            useSeconds: true,
            time: 'glyphicon glyphicon-time'
        });
    })
</script>
</body>
</html>