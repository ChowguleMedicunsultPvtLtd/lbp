<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>LBP</title>
        <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />">
        <link rel="stylesheet" href="<c:url value='/static/css/lbp.css' />">

    </head>
    <body class="loginBody">
        <div class="loginBox">
            <img  class="loginImg" src="<c:url value='/static/images/login.png' />">
            <div class="clearfix"></div>
            <div class="idBox" id="idBox">		
                <div class="innerIdBox">
                    <div class="loginTag">LOGIN</div>
                </div>
                <div class="formBox">
                    <c:url var="loginUrl" value="/login" />
                    <form action="${loginUrl}" method="post" class="form-horizontal">
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                <p>Invalid username and password.</p>
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                <p>You have been logged out successfully.</p>
                            </div>
                        </c:if>
                        <div class="form-group">
                            <label for="exampleInputEmail1" class="txt">Email</label>
                            <input type="text" class="form-control" id="username" name="ssoId" aria-describedby="emailHelp" placeholder="">
                        </div>	
                        <div class="form-group">
                            <label for="exampleInputEmail1" class="txt">Password</label>	
                            <input type="password" class="form-control" id="password" name="password" aria-describedby="emailHelp" placeholder="">
                        </div>									
                        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                        <div class="submitBox">
                            <div class="submitBtn"><input type="submit" class="btn smtBtn" value="Log in"></div>
                        </div>
                        </form>
                        <span><a href="<c:url value='/newuser' />" class="nReg">New User Registration</a></span>								
                        <div class="clearfix"></div>
                </div>	
            </div>		
        </div>

        <div class="footer">
            <img class="labLogo" src="<c:url value='/static/images/lbp_1.png' />">
            <!-- <span>Copyright @ Lok Biradari Prakalp 2018.</span> -->
            <span class="cmplsec">
                <span><sup>powered by</sup></span>
                <span><img class="cmplLogo" src="<c:url value='/static/images/cmpl_logo.jpg' />"></span>
                           </span>

                           </div>

                    <script src="<c:url value='/static/js/3.1.1_min.js' />"></script>       
                    <!--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>-->
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
                    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>		
                    <script src="<c:url value='/static/js/lbp.js' />"></script>
                            <script>
            if(${param.error != null}){
                document.getElementById("idBox").style.display="block";
            }
        </script>
                    </body>	
                    </html>
