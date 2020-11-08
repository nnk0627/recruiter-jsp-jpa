<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<jsp:include page="resources/common.jsp"></jsp:include>
</head>
<body>
	
<div class="container">

    <div class="row">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header text-center bg-primary">
                    <h4>Admin Profile</h4>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-md-8">
                            <table class="table no-border">
                                <c:forEach items="${profile }" var="p">                            
                                <tr>
                                    <td>Name</td>
                                    <td>:</td>
                                    <td>${p.name }</td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td>:</td>
                                    <td>${p.email }</td>
                                </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                </div>
            </div>




        </div>
    </div>
</div>
	
</body>
</html>