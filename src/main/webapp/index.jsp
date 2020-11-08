<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="./resources/css/style.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="./resources/js/jquery.min.js"></script>

<script type="text/javascript" src="./resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">   
 <div class="row">
  <div class="col-md-12">      
   <div class="wrap">
        <p class="form-title"> Log In For Recruiter</p>   
        <div class="p-5">
             <c:if test="${not empty message }">
				<div class="alert alert-danger offset-4 col-4" role="alert" ><strong>${message} </strong></div>
			 </c:if>
			 <c:url var="login" value="/login"></c:url>
             <form  action="${login }" method="post" class="login">
                    <div class="form-group">
                      <input type="email" class="" name="email" 
                      required autocomplete="email"  placeholder="Enter Email Address">
                    </div>
                    <div class="form-group">
                      <input  type="password" class=" " name="password" required 
                      autocomplete="current-password" placeholder="Enter Password">
                    </div>
                  <button type="submit" class="btn btn-block btn-success">Log In</button>                  
                    <div class="remember-forgot">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" />
                                    Remember Me
                                </label>
                            </div>
                        </div>
                        <div class="col-md-6%20forgot-pass-content">
                            <a href="#">Forgot Password</a>
                        </div>
                    </div>
                  </div>
              </form>             
         </div>
     </div>
   </div> 
 </div>
</div>        
</body>
</html>
