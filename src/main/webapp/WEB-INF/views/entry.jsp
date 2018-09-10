<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>EMR</title>
        <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css' />">
        <link rel="stylesheet" href="<c:url value='/static/css/lbp.css' />"> 
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
        <link rel="stylesheet" href="<c:url value='/static/css/jquery-ui.css' />"> 
        
</head>
	<body class="formSec">
		<div class="">
			<header class="adminH">
                            <image src="<c:url value='/static/images/title1.png' />">
				<button type="button" class="btn btn-secondary loginBtn logoutA">Logout</button>
			</header>
		</div>
 		<div class="container-fluid">
			<div class="row">
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
									<!-- <span>User Registration</span> -->
								
								<div class="profileSec">
									<div class="userTag">
										<div class="prflImg">
											<div class="inrR">
												<img src="<c:url value='/static/images/myPhoto.png' />" class="prfPic">
											</div>
										</div>
										<span class="greeting">Hi,${loggedinuser}</span>
									</div>
								</div>
							</div>						
						</div>
						<div class="clearfix"></div>
	<div class="text-center">
            	
		<p class="tagH">${success}</p>
	</div>
 <div class="inputG">
	<div class="row innerRow text-center">
		<div class="img-sec tab">
			<!-- --><div class="text-center"></div> 
                        <div class="text-center tablinks" onclick="openContent(event, 'OPD')"><!-- <a href="javascript(0)" class="linkEntry"> --><div class ="sectionEntry opdEntry"><img class="img-fluid" src="<c:url value='/static/images/opd.jpg' />"><p>OPD</p></div><div class="bgEntry"><!-- <p>OPD</p> --></div><!-- /a> --></div>
                        <div class="text-center tablinks" onclick="openContent(event, 'IPD')"><!-- <a href="javascript(0)" class="linkEntry"> --><div class ="sectionEntry ipdEntry"><img class="img-fluid" src="<c:url value='/static/images/ipd.jpg' />"><p>IPD</p></div><div class="bgEntry"><!-- <p>IPD</p> --><!-- </a> --></div></div>
                        <div class="text-center tablinks" onclick="openContent(event, 'pathology')"><!-- <a href="javascript(0)" class="linkEntry"> --><div class ="sectionEntry pathology"><img class="img-fluid" src="<c:url value='/static/images/pathology.jpg' />"><p>Pathology</p></div><div class="bgEntry"><!-- <p>Pathology</p> </a>--></div></div>
                        <div class="text-center tablinks" onclick="openContent(event, 'radiology')"><!-- <a href="javascript(0)" class="linkEntry"> --><div class ="sectionEntry radiology"><img class="img-fluid" src="<c:url value='/static/images/radio.png' />"><p>Radiology</p></div><div class="bgEntry"><!-- <p>Radiology</p> </a>--></div></div>
			<!-- --><div class=" text-center "></div>
		</div>
	</div>
<!--  -->	<div class="row innerRow">
			<div class="col-md-1"></div>
			<div class="col-md-10 tabPReg ">
				<div id="OPD" class="tabcontent">
					<div class="row innerRow"  ><!-- opd -->
							<div class="col-md-6">
								<form class="">
								  <div class="form-group">
										<label class="mSet" for="exampleFormControlSelect1">Department</label>
										<span>*</span>
										<select class="form-control" id="exampleFormControlSelect1">
										  <option>1</option>
										  <option>2</option>
										  <option>3</option>
										  <option>4</option>
										  <option>5</option>
										</select>
								  </div>
								</form>
							</div>
							<div class="col-md-6">
								<form class="">
								  <div class="form-group">
										<label class="mSet" for="exampleFormControlSelect1">Doctor</label>
										<span>*</span>
										<select class="form-control" id="exampleFormControlSelect1">
										  <option>1</option>
										  <option>2</option>
										  <option>3</option>
										  <option>4</option>
										  <option>5</option>
										</select>
								  </div>
								</form>
							</div>	
							<div class="sbmtBtn"><button type="button" class="btn btn-secondary">Submit</button></div>	
					</div>
				</div>
				
				
				<div id="IPD" class="tabcontent">
					<div class="row innerRow " id="IPD" ><!-- ipd -->
							
							<div class="col-md-6">
								<form class="">
								  <div class="form-group">
										<label class="mSet" for="exampleFormControlSelect1">Ward</label>
										<span>*</span>
										<select class="form-control" id="exampleFormControlSelect1">
										  <option>1</option>
										  <option>2</option>
										  <option>3</option>
										  <option>4</option>
										  <option>5</option>
										</select>
								  </div>
								</form>
							</div>
							<div class="col-md-6">
								<form class="">
								  <div class="form-group">
										<label class="mSet" for="exampleFormControlSelect1">Doctor</label>
										<span>*</span>
										<select class="form-control" id="exampleFormControlSelect1">
										  <option>1</option>
										  <option>2</option>
										  <option>3</option>
										  <option>4</option>
										  <option>5</option>
										</select>
								  </div>
								</form>
							</div>
							<div class="sbmtBtn"><button type="submit" class="btn btn-secondary">Submit</button></div>			
					</div>
				</div>
				<div id="pathology" class="tabcontent">
					<div class="row innerRow " id="pathology"><!-- pathology -->
							
							<div class="col-md-6">
								<form class="">
								  <div class="form-group">
										<label class="mSet" for="exampleFormControlSelect1">label 1</label>
										<span>*</span>
										<select class="form-control" id="exampleFormControlSelect1">
										  <option>1</option>
										  <option>2</option>
										  <option>3</option>
										  <option>4</option>
										  <option>5</option>
										</select>
								  </div>
								</form>
							</div>
							<div class="col-md-6">
								<form class="">
								  <div class="form-group">
										<label class="mSet" for="exampleFormControlSelect1">label 2</label>
										<span>*</span>
										<select class="form-control" id="exampleFormControlSelect1">
										  <option>1</option>
										  <option>2</option>
										  <option>3</option>
										  <option>4</option>
										  <option>5</option>
										</select>
								  </div>
								</form>
							</div>
							<div class="sbmtBtn"><button type="button" class="btn btn-secondary">Submit</button></div>								
					</div>
				</div>
				<div id="radiology" class="tabcontent">
					<div class="row innerRow " id="radiology"  ><!-- radiology -->
							<div class="col-md-6">
								<form class="">
								  <div class="form-group">
										<label class="mSet" for="exampleFormControlSelect1">label1</label>
										<span>*</span>
										<select class="form-control" id="exampleFormControlSelect1">
										  <option>1</option>
										  <option>2</option>
										  <option>3</option>
										  <option>4</option>
										  <option>5</option>
										</select>
								  </div>
								</form>
							</div>
							<div class="col-md-6">
								<form class="">
								  <div class="form-group">
										<label class="mSet" for="exampleFormControlSelect1">label 2</label>
										<span>*</span>
										<select class="form-control" id="exampleFormControlSelect1">
										  <option>1</option>
										  <option>2</option>
										  <option>3</option>
										  <option>4</option>
										  <option>5</option>
										</select>
								  </div>
								</form>
							</div>
							<div class="sbmtBtn"><button type="button" class="btn btn-secondary">Submit</button></div>			
					</div>
				</div>				
			
		</div>
		<div class="col-md-1"></div>
		<div class = ""></div>
	</div>


<script>
function openContent(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
</script>



	
</div>
		</div>
                        </div>
                </div>
                <script src="<c:url value='/static/js/3.1.1_min.js' />"> </script>
		<script src="<c:url value='/static/js/lbp.js' />"></script>
                <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
		</body>	
</html>





