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
        <title>Patient Registration</title>
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
      function Autocheck(){
           onClickDate();
      }
  </script>

    </head>
    <body onload="Autocheck()" class="formSec">
        <div class="">
            <header class="adminH">
                <image src="<c:url value='/static/images/title1.png' />">
                <button type="button" class="btn btn-secondary loginBtn logoutA">Logout</button>
            </header>
        </div>
        <div class="container-fluid">
            <form:form modelAttribute="patient" action="newpatient" class="form-horizontal" method="POST">
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
                                <a href="<c:url value='/logout' />"><li class="logoutBox"><span><img src="<c:url value='/static/images/logout.png' />" class="iconSbar"></span><span class="txtSide">logout</span></li></a>
                                <a href="#"><li class="LogoImgSet"><img src="<c:url value='/static/images/lbp_1.png' />" alt="Responsive image" class="img-fluid"></li></a>
                            </ul>
                        </div>		
                    </div>
                    <div class="col-md-10 col_right"> 
                        <div class="secHeading">
                            <div class="userTag">
                                <div class="userlogo"> <img src="<c:url value='/static/images/user.png' />"></div>
                                <span>Patient Registration</span>
                                <div class="profileSec">
                                    <div class="userTag">
                                        <div class="prflImg">
                                            <div class="inrR">
                                                <img src="<c:url value='/static/images/myPhoto.png'/>" class="prfPic">
                                            </div>
                                        </div>
                                        <span class="greeting">Hi, <strong>${loggedinuser}</strong></span>
                                    </div>
                                </div>
                            </div>						
                        </div>
                        <div class="clearfix"></div>
                        <div class="innerMasterBox ">
                            <h6> Personal data</h6>
                            <div class="row innerRow">	
                                <div class="col-md-4">
                                    <div>
                                        <div class="setBox">
                                            <form class="form-inline disIn">
                                                <div class="form-group">
<!--                                                    <label>Patient ID :</label>
                                                    <label class="interLevel"><strong></strong></label>-->
                                                </div>
                                            </form>											
                                        </div>
                                    </div>		
                                </div>
                            </div>	
                            <div class="row innerRow">
                                <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="mSet" for="inputPassword6">First Name</label>
                                            <span>*</span>
                                            <div>
                                                <form:input type="text" path="first_name" id="first_name" class="form-control"/>
                                                <div class="has-error">
                                                    <form:errors path="first_name" class="help-inline"/>
                                                </div>
                                            </div>
                                        </div>
                                </div>
                                <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="mSet"   for="inputPassword6">Middle Name</label>
                                            <div>
                                                <form:input type="text" path="middle_name" id="middle_name" class="form-control"/>
                                                <div class="has-error">
                                                    <form:errors path="middle_name" class="help-inline"/>
                                                </div>
                                            </div>
                                        </div>
                                </div>
                                <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="mSet"  for="inputPassword6">Last Name</label>
                                            <div>
                                                <form:input type="text" path="last_name" id="last_name" class="form-control"/>
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
                                        <label class="mSet"  class="labelM" >Gender</label>
                                        <span>*</span>
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
                                                <label class="mSet">Date of Birth</label>
                                                <span>*</span>
                                                <div>
                                                    <form:input onclick="onClickDate('#idDateField');" path="birthdate" id="idDateField" class="form-control" />
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
                                            <form:input path="mobile_no" class="form-control"/>

                                        </div>
                                </div>
                                <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="mSet" for="inputPassword6">Landline No.</label>
                                            <form:input path="landline_no" class="form-control"/>
                                        </div>
                                </div>
                                <div class="col-md-4">
                                        <div class="form-group">
                                            <label class="mSet" for="inputPassword6">Email</label>
                                            <form:input path="email" class="form-control"/>
                                        </div>
                                </div>							
                            </div>						

                            <h6>Relationship</h6>

                            <div class="row innerRow">
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="exampleFormControlSelect1">Type</label>
                                            <form:select path="rel_type" class="form-control" id="exampleFormControlSelect1">
                                                <option>Supervisor</option>
                                                <option>Father</option>
                                                <option>Mother</option>
                                                <option>Brother</option>
                                                <option>Sister</option>
                                                <option>Son</option>
                                                <option>Daughter</option>
                                                <option>Husband</option>
                                                <option>Wife</option>
                                                <option>Paternal Grandfather</option>
                                                <option>Paternal Grandmother</option>
                                                <option>Maternal Grandfather</option>
                                                <option>Maternal Grandmother</option>
                                            </form:select>
                                        </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="inputPassword6">Name</label>
                                            <form:input path="rel_name" class="form-control"/>
                                        </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <div class="setBox">
                                                <label class="labelM MFSet mSet" >Is alive</label>
                                                <div>
                                                    <div class="custom-control inrCheckBx">
                                                        <form:radiobutton path="isAlive" name="customRadio" value="1"/>
                                                        <label class="MFSet mSet" for="isAlive">Yes</label> 
                                                    </div>
                                                    <div class="custom-control inrCheckBx">
                                                        <form:radiobutton path="isAlive" name="customRadio" value="0"/>
                                                        <label class="MFSet mSet" for="isAlive">No</label> 
                                                    </div>	
                                                </div>									
                                            </div>									
                                        </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="inputPassword6">Died On</label>
                                            <form:input onclick="onClickDate('#idDateField1');" path="died_on" id="idDateField1" class="form-control "/>
                                        </div>
                                </div>							
                            </div>	
                            <h6>Other</h6>
                            <div class="row innerRow">
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="exampleFormControlSelect1">Educational Data</label>
                                            <form:select class="form-control" path="educational_data">
                                                <option>Uneducated</option>
                                                <option>5th Pass or below</option>
                                                <option>6th to 9th </option>
                                                <option>10th pass</option>
                                                <option>12th pass</option>
                                                <option>Graduate and above</option>
                                            </form:select>
                                        </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="exampleFormControlSelect1">Occupation</label>
                                            <form:select class="form-control" path="occupation">
                                                <option>Unemployed</option>
                                                <option>Student</option>
                                                <option>Government</option>
                                                <option>Business</option>
                                                <option>Housewife</option>
                                                <option>Labour</option>
                                            </form:select>
                                        </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="exampleFormControlSelect1">Mother's Name</label>
                                            <form:input path="mother_name" class="form-control "/>								
                                        </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="exampleFormControlSelect1">Religion</label>
                                            <form:input path="religion" class="form-control"/>								
                                        </div>
                                </div>	
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="exampleFormControlSelect1">Caste</label>
                                            <form:input path="caste" class="form-control"/>								
                                        </div>
                                </div>	
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="exampleFormControlSelect1">Tags</label>
                                            <form:select class="form-control" path="tags">
                                                <option>education</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </form:select>							
                                        </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="exampleFormControlSelect1">Refered By</label>
                                            <form:select class="form-control" path="refered_by">
                                                <option>education</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </form:select>																
                                        </div>
                                </div>	
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <label class="mSet" for="exampleFormControlSelect1">Aadhar No.</label>
                                            <form:input path="Aadhar_no" class="form-control "/>								
                                        </div>
                                </div>
                                <div class="col-md-3">
                                        <div class="form-group">
                                            <div class="custom-file">
                                                <input type="file" class="custom-file-input" path="validatedCustomFile">
                                                <label class="custom-file-label" for="validatedCustomFile">upload Photo...</label>
                                                <div class="invalid-feedback">Example invalid custom file feedback</div>
                                            </div>
                                        </div>
                                </div>
                            </div>
                            <div class="text-center sBtn">
                                <button type="submit" class="btn btn-primary">Submit</button>
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
        var opt = {
                url: "${pageContext.request.contextPath}/District",
                getValue: "District",
                list: {
                        match: {
                                enabled: true
                        }
                }
        };
        $("#District").easyAutocomplete(opt);
        var option = {
                url: "${pageContext.request.contextPath}/State",
                getValue: "State",
                list: {
                        match: {
                                enabled: true
                        }
                }
        };
        $("#State").easyAutocomplete(option);
        </script>
    </body>	
</html>