<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Users List</title>
        <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
        <link rel="stylesheet" href="<c:url value='/static/css/lbp.css' />"> 
        <link rel="stylesheet" href="<c:url value='/static/css/jquery-ui.css' />"> 

</head>
	<body class="formSec">
		<div class="">
			
						<div class="secHeading">
                                                    <div class="userlogo deptLstLogo"> <img src="<c:url value='/static/images/listOfUser_2.png'/>"></div>
						<span class="tagHeading">
							<span class= "tagColorSet">U</span>sers 
							<span class= "tagColorSet">L</span>ist
						</span>
							<div class="userTag">
								<div class="profileSec">
									<div class="userTag">
										<div class="prflImg">
											<div class="inrR">
												<img src="images/myPhoto.png" class="prfPic">
											</div>
										</div>
										<span class="greeting"> ${loggedinuser}</span>
										<div class="userlogo userLogoR"> <img src="<c:url value='/static/images/user.png'/>"></div>
									</div>
								</div>
							</div>
							<div class="clearfix"></div>
							
							<div class="logoutSec">
								<div class="logInner">
									<div class="inrLog_1" >
										<img class="logoutProfile img-fluid" src="<c:url value='/static/images/logout_profile.png'/>"/>
									</div>
									<div class="inrLog_2">
										<ul>
											<li><b>Siddhesh Shiposkar</b></li>
											<li>siddhesh.shiposkar@gmail.com</li>
										</ul>
									</div>
								</div>
								<div class="signoutSec">
									<button type="button" class="btn btn-primary ">Sign out</button>
								</div>
							</div>
								<div></div>
							
							</div>	
							
						</div>
									
			
 		<div class="container-fluid">
		              <div class="row">
                <div class="col-md-2 col_left">
                    <div class="sidebarL">
                        <ul>
                            <a href="<c:url value='/entry' />"><li><span><img src="<c:url value='/static/images/home.png'/>" class="iconSbar"></span> <span class="txtSide">Home</span></li></a>
                            <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                                <a href="<c:url value='/master' />"><li><span><img src="<c:url value='/static/images/master.png'/>" class="iconSbar"></span> <span class="txtSide">Master</span></li></a>
                            </sec:authorize>
                            <a href="<c:url value='/PatientRegistration'/>"><li><span><img src="<c:url value='/static/images/pReg.png'/>" class="iconSbar"></span><span class="txtSide">Patient Registration</span></li></a>
                            <a href="#"><li><span><img src="<c:url value='/static/images/pList.png'/>" class="iconSbar"></span><span class="txtSide">Patient List</span></li></a>
                            <a href="#">
                                <li class="logoSetB"><img class="img-fluid" src="<c:url value='/static/images/lbp_3.png' />" /></li>
                            </a>
                        </ul>
                    </div>		
                </div>
                <div class="col-md-10 col_right"> 
                    <span class="listIcon">
                       <a href="<c:url value='/newuser'/>"><img src="<c:url value='/static/images/new-user.png'/>"></a>
                    </span>
                    
                    <div style="padding:0px 10px;">
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <tr>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Email</th>	
                                    <th>UserName</th>	

                                <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                                    <th width="100"></th>
                                </sec:authorize>
                                <sec:authorize access="hasRole('ADMIN')">
                                    <th width="100"></th>
                                </sec:authorize>
                                </tr>
                                <tr>
                                    <c:forEach items="${users}" var="user">
                                        <td>${user.first_name}</td>
                                        <td>${user.last_name}</td>
                                        <td>${user.email}</td>
                                        <td>${user.username}</td>
                                    <sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
                                        <td class="text-center"><a href="<c:url value='/edit-user-${user.username}' />" class="btn "><img src="<c:url value='/static/images/edit.png'/>"/></a></td>
                                    </sec:authorize>
                                    <sec:authorize access="hasRole('ADMIN')">
                                        <td class="text-center"><a href="<c:url value='/delete-user-${user.username}' />" class="btn"><img src="<c:url value='/static/images/delete.png'/>"/></a></td>
                                    </sec:authorize>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>	
                </div>
                              </div>                
		</div>
	<script src="<c:url value='/static/js/3.1.1_min.js' />"></script>
        <script src="<c:url value='/static/js/lbp.js' />"></script>
        <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
        <script src="<c:url value='/static/js/jquery-ui.min.js' />"></script>
	</body>	
</html>





