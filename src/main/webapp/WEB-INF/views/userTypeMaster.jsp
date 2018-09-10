<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>User Type Master</title>
        <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css'/>"/>
        <link rel="stylesheet" href="<c:url value='/static/css/lbp.css' />"/> 
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
        <script>
            function test(){
                var typeField =document.getElementById("type").value;
                if(typeField === ("")){
                    alert("User Type Can Not Be Blank");
                    return false;
                }
            }
        </script>
    </head>
    <body class="formSec">
        <div class="">
            <header class="adminH">
                <image src="<c:url value='/static/images/title1.png' />">
                <button type="button" class="btn btn-secondary loginBtn logoutA">Logout</button>
            </header>
        </div>
        <div class="container-fluid">
            <form:form commandName="usertype" action="userTypeMaster" class="form-horizontal" method="POST">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
                <form:input type="hidden" path="id" id="id"/>
                <div class="row ">
                    <div class="col-md-2 col_left">
                        <div class="sidebarL">
                            <ul>
                                <a href="<c:url value='/entry' />"><li><span><img src="<c:url value='/static/images/home.png' />" class="iconSbar"></span> <span class="txtSide">Home</span></li></a>
                                <a href="<c:url value='/master' />"><li><span><img src="<c:url value='/static/images/master.png' />" class="iconSbar"></span> <span class="txtSide">Master</span></li></a>
                                <a href="<c:url value='/PatientRegistration' />"><li><span><img src="<c:url value='/static/images/pReg.png' />" class="iconSbar"></span><span class="txtSide">Patient Registration</span></li></a>
                                <a href="#"><li><span><img src="<c:url value='/static/images/pList.png' />" class="iconSbar"></span><span class="txtSide">Patient List</span></li></a>
                                <a href="<c:url value='/logout' />"><li class="logoutBox"><span><img src="<c:url value='/static/images/logout.png' />" class="iconSbar"></span><span class="txtSide">logout</span></li></a>
                                <a href="#">
                                    <li class="LogoImgSet"><img src="<c:url value='/static/images/lbp_1.png' />" alt="Responsive image" class="img-fluid"></li>
                                </a>
                            </ul>
                        </div>		
                    </div>
                    <div class="col-md-10 col_right"> 
                        <div class="secHeading">
                            <div class="userTag">
                                <div class="userlogo"> <img src="<c:url value='/static/images/user.png' />"></div>
                                <span>User Type Master</span>
                                <div class="profileSec">
                                    <div class="userTag">
                                        <div class="prflImg">
                                            <div class="inrR">
                                                <img src="<c:url value='/static/images/title1.png' />images/myPhoto.png" class="prfPic">
                                            </div>
                                        </div>
                                        <span class="greeting">Hi, <strong>${loggedinuser}</strong></span>
                                    </div>
                                </div>
                            </div>						
                        </div>
                        <div class="clearfix"></div>
                        <div class="innerMasterBox ">

                            <div class="row setRow">
                                <div class="col-md-4">
                                    <div class="formFill">
                                        <div class="setBox ">
                                            <div class="form-group myF_Control">
                                                <label for="exampleInputEmail1">User type : </label><span>*</span>
                                                <form:input path="type" class="form-control" id="type"/>
                                                <div class="has-error">
                                                    <form:errors path="type" class="help-inline"/>
                                                </div>
                                            </div>						  
                                        </div>
                                    </div>		
                                </div>

                                <div class="col-md-4">
                                    <div class="formFill">
                                        <div class="setBox ">
                                            <div class="form-group myF_Control">
                                                <label for="exampleInputEmail1">User sub-type :</label>
                                                <form:input path="sub_type" class="form-control"/>
                                                <div class="has-error">
                                                    <form:errors path="sub_type" class="help-inline"/>
                                                </div>
                                            </div>						  
                                        </div>
                                    </div>		
                                </div>
                                <div class="col-md-4">
                                    <c:choose>
						<c:when test="${edit}">
                                                    <input type="submit" onclick="return test()" style=" margin: 31px auto auto;" value="Update"  class="btn btn-primary"/> <span class="cancelBtn">or <a href="<c:url value='/userTypeMaster' />">Cancel</a></span>
                                                </c:when> 
						<c:otherwise>
                                                    <input type="submit" onclick="return test()" style=" margin: 31px auto auto;" value="Submit" class="btn btn-primary"/> <span class="cancelBtn">or <a href="<c:url value='/userTypeMaster' />">Cancel</a></span>
                                                </c:otherwise>
                                    </c:choose>    
                                </div>
                                                 
                            </div>        
                            <div class="row setRow">                    
                                <div class="col-md-12">
                                    <div style="padding:0px 10px;">       
                                        <div class="table-responsive">
                                            <table class="table table-bordered table-hover">
                                                <tr>
                                                    <th>User Type</th>
                                                    <th>User Sub Type</th>
                                                <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                                                    <th width="100"></th>
                                                </sec:authorize>
                                                <sec:authorize access="hasRole('ADMIN')">
                                                    <th width="100"></th>
                                                </sec:authorize>
                                                </tr>
                                                <tr>
                                                    <c:forEach items="${userType}" var="user_profile">
                                                        <td>${user_profile.type}</td>
                                                        <td>${user_profile.sub_type}</td>
                                                    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                                                        <td class="text-center"><a href="<c:url value='/edit-user_profile-${user_profile.id}' />" class="btn "><img src="<c:url value='/static/images/edit.png'/>"/></a></td>
                                                    </sec:authorize>
                                                    <sec:authorize access="hasRole('ADMIN')">
                                                        <td class="text-center"><a href="<c:url value='/delete-user_profile-${user_profile.id}' />" class="btn"><img src="<c:url value='/static/images/delete.png'/>"/></a></td>
                                                    </sec:authorize>
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
               
            </form:form>                                                        
        </div>
        <script src="<c:url value='/static/js/3.1.1_min.js' />"></script>
        <script src="<c:url value='/static/js/lbp.js' />"></script>
        <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
    </body>	
</html>

