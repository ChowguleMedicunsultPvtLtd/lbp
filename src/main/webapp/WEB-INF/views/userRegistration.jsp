<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>LBP</title>
        <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />">
        <link rel="stylesheet" href="<c:url value='/static/css/lbp.css' />"> 
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
        <link rel="stylesheet" href="<c:url value='/static/css/jquery-ui.css' />"> 
        <link rel="stylesheet" href="<c:url value='/static/css/easy-autocomplete.min.css' />"> 
        <script type="text/javascript">
            function onClickDate() {
                $("#idDateField").datepicker(
                        {
                            dateFormat: "dd/mm/yy",
                            changeMonth: true,
                            changeYear: true,
                            maxDate: "+0D"
                        });
                $("#idDateField1").datepicker(
                        {
                            dateFormat: "dd/mm/yy",
                            changeMonth: true,
                            changeYear: true,
                            maxDate: "+0D"
                        });

            };
            
            function test(){
//                var password =document.getElementById("password").value;
//                var passwordConf=document.getElementById("passwordConf").value;
//                if(password == "" || password == undefined ){
//                    document.getElementById("password_Label").innerHTML="Password should not be empty";
////                    alert("Password should not be empty");
//                    return false;
//                }else if(passwordConf == "" || passwordConf == undefined ){
//                    document.getElementById("passwordConf_Label").innerHTML="Password Confirm should not be empty";
////                    alert("Password Confirm should not be empty");
//                    return false;
//                }
//                else if(password != passwordConf){
//                    document.getElementById("password_Label").innerHTML="Password  doesn't match";
////                    alert("Password  doesn't match");
//                    return false;
//                }
//                return true;
                var typeField =document.getElementById("type").value;
                if(typeField === ("")){
                    alert("User Type Can Not Be Blank");
                    return false;
                }
            }
            
            function Autocheck() {
                onClickDate();
                document.getElementById("passwordConf").value=document.getElementById("password").value;
            }
        </script> 

</head>
	<body onload="Autocheck()" class="formSec">
		<div class="">
			<div class="">
						<div class="secHeading">
                                                    <div class="userlogo"> <img src="<c:url value='/static/images/user.png' />"></div>
						<span class="tagHeading">
							<span class= "tagColorSet">U</span>ser 
							<span class= "tagColorSet">M</span>aster
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
									
			</div>
		</div>		
 		<div class="container-fluid">
		  <form:form modelAttribute="user" class="form-horizontal" method="POST">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
                <form:input type="hidden" path="id" id="id"/>
                <div class="row">
                    <div class="col-md-2 col_left">
                        <div class="sidebarL">
                            <ul>
                                <a href="<c:url value='/entry' />"><li><span><img src="<c:url value='/static/images/home.png' />" class="iconSbar"></span> <span class="txtSide">Home</span></li></a>
                                <a href="<c:url value='/master' />"><li><span><img src="<c:url value='/static/images/master.png' />" class="iconSbar"></span> <span class="txtSide">Master</span></li></a>
                                <a href="<c:url value='/PatientRegistration' />"><li><span><img src="<c:url value='/static/images/pReg.png' />" class="iconSbar"></span><span class="txtSide">Patient Registration</span></li></a>
                                <a href="#"><li><span><img src="<c:url value='/static/images/pList.png' />" class="iconSbar"></span><span class="txtSide">Patient List</span></li></a>
                                <!--<a href="<c:url value='/logout' />"><li class="logoutBox"><span><img src="<c:url value='/static/images/logout.png' />" class="iconSbar"></span><span class="txtSide">logout</span></li></a>-->
                                <a href="#">
                                    <li class="logoSetB"><img class="img-fluid" src="<c:url value='/static/images/lbp_3.png' />" /></li>
                                </a>
                            </ul>
                        </div>		
                    </div>
                    <div class="col-md-10 col_right"> 
                        <div class="innerMasterBox ">
                            <h6 style="float:left; margin-top:10px;"> Personal data</h6>
                    <span class="listIcon">
                        <a href="<c:url value='/list'/>"><img src="<c:url value='/static/images/listOfUser_2.png'/>"></a>
                    </span>                            
                    <div class="clearfix"></div>
                            <div class="row innerRow">	
                                <div class="col-md-4">
                                    <div>
                                        <div class="setBox">
                                           
                                                <div class="form-group">
<!--                                                    <label>Patient ID :</label>
                                                    <label class="interLevel">user</label>-->
                                                </div>

                                        </div>
                                    </div>		
                                </div>
                            </div>	
                            <div class="row innerRow">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label class="mSet" for="inputname">First Name</label><span>*</span>
                                        <div>
                                            <form:input type="text" path="first_name" class="form-control "/>
                                            <div class="has-error">
                                                <form:errors path="first_name" class="help-inline"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet"   for="inputname">Middle Name</label>
                                        <div>
                                            <form:input type="text" path="middle_name" class="form-control"/>
                                            <div class="has-error">
                                                <form:errors path="middle_name" class="help-inline"/>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet"  for="inputname">Last Name</label>
                                        <div>
                                            <form:input type="text" path="last_name" class="form-control"/>
                                            <div class="has-error">
                                                <form:errors path="last_name" class="help-inline"/>
                                            </div>
                                        </div>
                                    </div>

                                </div>							
                            </div>
                            <div class="row innerRow">
                                <div class="col-md-4">	
                                    <div class="setBox">
                                        <label class="mSet"  class="labelM" >Gender</label><span>*</span>
                                        <div>
                                            <div class="custom-control inrCheckBx">
                                                <form:radiobutton path="gender" value="M"/>
                                                <label class="mSet" for="customRadio1">Male</label>
                                            </div>
                                            <div class="custom-control inrCheckBx">
                                                <form:radiobutton  path="gender" value="F"/>
                                                <label class="mSet"  for="customRadio2">Female</label>
                                            </div>	
                                            <div class="has-error">
                                                <form:errors path="gender" class="help-inline"/>
                                            </div>
                                        </div>									
                                    </div>						
                                </div>
                                <div class="col-md-4">
                                    <div class="setBox">
                                        <div class="form-group">
                                                <label class="mSet">Date of Birth</label><span>*</span>
                                                <div>
                                                    <form:input autocomplete="off" onclick="onClickDate('#idDateField');" path="birthdate" id="idDateField" class="form-control" />
                                                    <div class="has-error">
                                                        <form:errors path="birthdate" class="help-inline"/>
                                                    </div>
                                                    
                                                </div>
                                            </div>
                                    </div>									
                                </div>      
                                <div class="col-md-4">	
                                    <div class="setBox">
                                        <label class="labelM mSet">Estimated</label>	
                                            <div class="form-group">
                                                <form:checkbox id="birthdate_estimated" path="birthdate_estimated"/>
                                            </div>
                                    </div>						
                                </div>						
                            </div>

                            <h6>Address</h6>

                            <div class="row innerRow">
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">House No.</label>
                                        <form:input path="HouseNo" class="form-control "/>

                                    </div>

                                </div>
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Area</label>
                                        <form:input path="Area" class="form-control"/>

                                    </div>

                                </div>
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Gram Panchayat</label>
                                        <form:input path="GramPanchayat" class="form-control"/>

                                    </div>

                                </div>							
                            </div>
                            <div class="row innerRow">
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Village</label>
                                        <form:input path="Village" class="form-control"/>

                                    </div>

                                </div>
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Tehsil</label>
                                        <form:input path="Tehsil" id="Tehsil" class="form-control"/>
                                    </div>

                                </div>
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">District</label>
                                        <form:input path="District" id="District" class="form-control"/>
                                    </div>

                                </div>							
                            </div>						
                            <div class="row innerRow">
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label  class="mSet" for="inputPassword6">State</label>
                                        <form:input path="State" id="State" class="form-control"/>
                                    </div>

                                </div>
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Pincode</label>
                                        <form:input path="Pincode" class="form-control"/>

                                    </div>

                                </div>
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6"></label>
                                    </div>

                                </div>							
                            </div>						

                            <h6>Contact</h6>
                            <div class="row innerRow">
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Mobile No.</label>
                                        <form:input type="text" path="mobile_no" class="form-control "/>

                                    </div>

                                </div>
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Alternate Mobile No.</label>
                                        <form:input type="text" path="alternate_mobile" class="form-control "/>
                                    </div>

                                </div>
                                <div class="col-md-4"></div>
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Email</label>
                                        <form:input type="text" path="email" class="form-control"/>
                                    </div>

                                </div>							
                                <div class="col-md-4">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Alternate Email</label>
                                        <form:input type="text" path="alternate_email" class="form-control"/>
                                    </div>

                                </div>
                                <div class="col-md-4"></div>		




                            </div>						

                            <h6>Other Qualification</h6>

                            <div class="row innerRow">
                                <div class="col-md-3">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Qualification</label>
                                        <form:input type="text" path="qualification" class="form-control "/>
                                    </div>


                                </div>
                                <div class="col-md-3">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">UserName</label><span>*</span>
                                        <form:input type="text" path="username" class="form-control "/>
                                        
                                    </div>

                                </div>
                                <div class="col-md-3">

                                    <div class="form-group">
                                        <label class="mSet" for="inputPassword6">Password</label><span>*</span>
                                        <form:input type="Password" id="password" path="password" class="form-control "/>
                                        <div class="has-error">
							<form:errors path="password" class="help-inline"/>
                                                        <label id="password_Label"></label>  
						</div>
                                    </div>							


                                </div>

                                <div class="col-md-3">

                                    <div class="form-group">
                                        <label class="mSet"  for="inputPassword6" >Re-enter Password</label><span>*</span>
                                        <form:input type="Password" id="passwordConf" path="passwordConf" class="form-control "/>
                                        <div class="has-error">
                                                        <label id="passwordConf_Label"></label>  
							<form:errors path="passwordConf" class="help-inline"/>
						</div>
                                    </div>

                                </div>
                                <div class="col-md-3">

                                    <div class="form-group">
                                        <div class="form-group">
                                            <label class="mSet" for="exampleFormControlSelect1"> User Type</label>
                                            <span>*</span>
                                            <form:select path="userProfiles"  multiple="true" class="form-control">
						 <form:option value="0" label="--- Select type---" />
                                                 <form:options itemValue="id"  itemLabel="type" items="${roles}" />
                                            </form:select>
                                           
                                            <div class="has-error">
						<form:errors path="userProfiles" class="help-inline"/>
                                            </div>
                                        </div>								
                                    </div>
                                </div>
                                <div class="col-md-3">

                                    <div class="form-group">
                                        <label class="mSet" for="exampleFormControlSelect1">Department</label>
                                        <span>*</span>
                                        <form:select class="form-control" path="department">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </form:select>
                                    </div>	

                                </div>
                                <div class="col-md-3">
                                </div>						
                            </div>	
                            <div class="row innerRow ">
                                <div class="col-md-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered ">
                                            <thead class="thead-light">
                                                <tr>
                                                    <th scope="col">Available</th>
                                                    <th scope="col">Day of Week </th>
                                                    <th scope="col">From Time </th>
                                                    <th scope="col">To Time </th>
                                                    <th scope="col">From Time</th>
                                                    <th scope="col">To Time </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td><form:checkbox path="UserTimeTable[0].dayCheck" /></td>
                                                    <td>Mon</td>
                                                    <td><form:input type="text" path="UserTimeTable[0].from1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[0].to1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[0].from2"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[0].to2"/></td>				  
                                                </tr>
                                                <tr>
                                                    <td><form:checkbox path="UserTimeTable[1].dayCheck" /></td>
                                                    <td>Tue</td>
                                                    <td><form:input type="text" path="UserTimeTable[1].from1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[1].to1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[1].from2"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[1].to2"/></td>				  
                                                </tr>
                                                <tr>
                                                    <td><form:checkbox path="UserTimeTable[2].dayCheck" /></td>
                                                    <td>Wed</td>
                                                    <td><form:input type="text" path="UserTimeTable[2].from1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[2].to1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[2].from2"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[2].to2"/></td>				  
                                                </tr>
                                                <tr>
                                                    <td><form:checkbox path="UserTimeTable[3].dayCheck" /></td>
                                                    <td>Thu</td>
                                                    <td><form:input type="text" path="UserTimeTable[3].from1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[3].to1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[3].from2"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[3].to2"/></td>				  
                                                </tr>
                                                <tr>
                                                    <td><form:checkbox path="UserTimeTable[4].dayCheck" /></td>
                                                    <td>Fri</td>
                                                    <td><form:input type="text" path="UserTimeTable[4].from1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[4].to1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[4].from2"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[4].to2"/></td>				  
                                                </tr>
                                                <tr>
                                                    <td><form:checkbox path="UserTimeTable[5].dayCheck" /></td>
                                                    <td>Sat</td>
                                                    <td><form:input type="text" path="UserTimeTable[5].from1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[5].to1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[5].from2"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[5].to2"/></td>				  
                                                </tr>
                                                <tr>
                                                    <td><form:checkbox path="UserTimeTable[6].dayCheck" /></td>
                                                    <td>sun</td>
                                                    <td><form:input type="text" path="UserTimeTable[6].from1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[6].to1"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[6].from2"/></td>
                                                    <td><form:input type="text" path="UserTimeTable[6].to2"/></td>				  
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>						
                            </div>	
			    <div class="text-center sBtn">
                                <c:choose>
						<c:when test="${edit}">
                                                    <input type="submit" onclick="return test()" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
						</c:when> 
						<c:otherwise>
                                                    <input type="submit" onclick="return test()" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/list' />">Cancel</a>
						</c:otherwise>
				</c:choose>
                            </div>
                        </div> 			
                    </div>
                </div>
            </form:form>
		</div>
		

        <script src="<c:url value='/static/js/3.1.1_min.js' />"></script>
        <script src="<c:url value='/static/js/lbp.js' />"></script>
        <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
        <script src="<c:url value='/static/js/jquery-ui.min.js' />"></script>
        <script src="<c:url value='/static/js/jquery.easy-autocomplete.min.js' />"></script>
        <script>
        var options = {
                url: "${pageContext.request.contextPath}/Tehsil",
                getValue: "Taluka",
                list: {
                        match: {
                                enabled: true
                        }
                }
        };
        $("#Tehsil").easyAutocomplete(options);
        options = {
                url: "${pageContext.request.contextPath}/District",
                getValue: "District",
                list: {
                        match: {
                                enabled: true
                        }
                }
        };
        $("#District").easyAutocomplete(options);
        options = {
                url: "${pageContext.request.contextPath}/State",
                getValue: "State",
                list: {
                        match: {
                                enabled: true
                        }
                }
        };
        $("#State").easyAutocomplete(options);
        </script>
	</body>	
</html>





