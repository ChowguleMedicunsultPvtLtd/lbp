<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>LBP</title>
        <link rel="stylesheet" href="<c:url value='/static/css/bootstrap.min.css'/>"/>
        <link rel="stylesheet" href="<c:url value='/static/css/lbp.css' />"/> 
        <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
        <SCRIPT language="javascript">
            function addRow(tableID) {
                document.getElementById("tableDiv").style.display = "block";
                var table = document.getElementById(tableID);
                var rowCount = table.rows.length;
                var length = table.rows.length;
                var row = table.insertRow(rowCount);

                var cell1 = row.insertCell(0);
                cell1.innerHTML = document.getElementById("Each").value+"<input type='hidden' name='DrugComposition[\"" + length + "\"].CompositionDosage' id='DrugComposition[\"" + length + "\"].CompositionDosage' value=\"" + document.getElementById("Each").value + "\"/>";
                
                var cell2 = row.insertCell(1);
                cell2.innerHTML = document.getElementById("GenericName").value+"<input type='hidden' id='DrugComposition[\""+ length + "\"].GenericName' name='DrugComposition[\""+ length + "\"].GenericName' value=\"" + document.getElementById("GenericName").value + "\"/>";
                var cell3 = row.insertCell(2);
                cell3.innerHTML = document.getElementById("Strength").value+"<input type='hidden' name='DrugComposition[\"" + length + "\"].Strength' id='DrugComposition[\"" + length + "\"].Strength' value=\"" + document.getElementById("Strength").value + "\"/>";
                
                var cell4 = row.insertCell(3); 
                var e = document.getElementById("FormControlUnit");
                var strUser = e.options[e.selectedIndex].value;
                cell4.innerHTML = strUser+"<input type='hidden' name='DrugComposition[\"" + length + "\"].Unit' id='DrugComposition[\"" + length + "\"].Unit' value=\"" +strUser+ "\"/>";
                
                var cell5 = row.insertCell(4);
                cell5.innerHTML = "<img src='/EMR/static/images/edit.png'/><type='hidden' id=\"row" + length + "\"/>";

                var cell6 = row.insertCell(5);
                cell6.innerHTML = "<img src='/EMR/static/images/delete.png' class='btnDelete' onclick='afterRemove()'/>";

            }

            function myFunction()
            {

                var str = document.getElementById('brand').value;
                var div = document.getElementById('brandSelected').innerHTML;
                if ($.trim(div) === '') {
                    document.getElementById('brandSelected').innerHTML = $.trim(str);
                    document.getElementById('BrandName').value = $.trim(str);
                } else {
                    document.getElementById('brandSelected').innerHTML = div + ", " + $.trim(str);
                    document.getElementById('BrandName').value = div + ", " + $.trim(str);
                }
                document.getElementById('brand').value = "";

            }
            function editBrand()
            {
                document.getElementById('brand').value = document.getElementById('brandSelected').innerHTML;
                document.getElementById('brandSelected').innerHTML = document.getElementById('BrandName').value = "";
            }
            function test() {
                var typeField = document.getElementById("DiagnosisName").value;

                if (typeField === ("")) {
                    alert("DiagnosisName Can Not Be Blank");
                    return false;
                }
            }



        </SCRIPT>    

    </head>
    <body class="formSec">

        <div class="">
            <div class="">
                <div class="secHeading">
                    <div class="userlogo"> <img src="<c:url value='/static/images/drugs.png'/>" style="width: 30px;padding: 2px;margin-top: 3px;margin-left: -2px;"></div>
                    <span class="tagHeading">
                        <span class= "tagColorSet">D</span>rug 
                        <span class= "tagColorSet">M</span>aster
                    </span>
                    <div class="userTag">
                        <div class="profileSec">
                            <div class="userTag">
                                <div class="prflImg">
                                    
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
        <form:form modelAttribute="drug" action="drug" class="form-horizontal" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
            <form:input type="hidden" path="drugID" id="drugID"/>
            <div class="row">
                <div class="col-md-2 col_left">
                    <div class="sidebarL">
                        <ul>
                            <a href="<c:url value='/entry' />"><li><span><img src="<c:url value='/static/images/home.png' />" class="iconSbar"></span> <span class="txtSide">Home</span></li></a>
                            <a href="<c:url value='/master' />"><li><span><img src="<c:url value='/static/images/master.png' />" class="iconSbar"></span> <span class="txtSide">Master</span></li></a>
                            <a href="<c:url value='/PatientRegistration' />"><li><span><img src="<c:url value='/static/images/pReg.png' />" class="iconSbar"></span><span class="txtSide">Patient Registration</span></li></a>
                            <a href="#"><li><span><img src="<c:url value='/static/images/pList.png' />" class="iconSbar"></span><span class="txtSide">Patient List</span></li></a>
                            <!--<a href="#"><li class="LogoImgSet"><img src="<//c:url value='/static/images/lbp_1.png' />" alt="Responsive image" class="img-fluid"></li></a>-->
                            <li class="logoSetB"><img class="img-fluid" src="<c:url value='/static/images/lbp_3.png' />" /></li>
                        </ul>
                    </div>		
                </div>
                <div class="col-md-10 col_right"> 
                    <div class=" innerMasterBox">
                        <div class="row innerRow">
                            <div class="col-md-4">
                                <div class="">

                                    <div class="form-group myF_Control">
                                        <label class="mSet" for="exampleFormControlSelect1">Diagnosis Name <span>*</span></label>
                                        <form:select path="DiagnosisName" class="form-control" id="DiagnosisName">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </form:select>
                                    </div>	
                                </div>		
                            </div>
                            <div class="col-md-4">
                                <div class="">
                                    <div class="form-group myF_Control">
                                        <label class="mSet" for="exampleFormControlSelect1">Dosage Form </label>
                                        <form:select class="form-control" path="DosageForm" id="DosageForm">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </form:select>
                                    </div>	
                                </div>		
                            </div>	
                            <div class="col-md-4">
                                <div class="">
                                    <div class="form-group myF_Control">
                                        <div class="userlogo userLogoR"> <a href="<c:url value='/druglist' />"> <img src="<c:url value='/static/images/user.png'/>"> </a> </div>
                                        
                                    </div>	
                                </div>	
                            </div>    
                        </div>

                        <h6>Composition</h6>
                        <div class="row innerRow">
                            <div class=" col-md-10" style="padding:0px;">
                                <div class="row innerRow">
                                    <div class="col-md-3">
                                        <div class="setBox ">

                                            <div class="form-group myF_Control">
                                                <label for="exampleInputEmail1">Each</label>
                                                <input type="text" class="form-control " id="Each" aria-describedby="emailHelp" placeholder="">
                                            </div>						  

                                        </div>									
                                    </div>
                                    <div class="col-md-3">
                                        <div class="setBox ">

                                            <div class="form-group myF_Control">
                                                <label for="exampleInputEmail1">Generic Name</label>
                                                <input type="text" class="form-control" id="GenericName" aria-describedby="emailHelp" placeholder="">
                                            </div>						  

                                        </div>									
                                    </div>
                                    <div class="col-md-3">
                                        <div class="setBox ">

                                            <div class="form-group myF_Control">
                                                <label for="exampleInputEmail1">Strength</label>
                                                <input type="text" class="form-control " id="Strength" aria-describedby="emailHelp" placeholder="">
                                            </div>						  

                                        </div>									
                                    </div>
                                    <div class="col-md-3">
                                        <div class="setBox ">

                                            <div class="form-group myF_Control">
                                                <label for="exampleInputEmail1">Unit</label>
                                                <select class="form-control" id="FormControlUnit">
                                                    <option value="0">Select</option>
                                                    <option value="mg">mg</option>
                                                    <option value="g">g</option>
                                                    <option value="mcg">mcg</option>
                                                    <option value="IU">IU</option>
                                                </select>
                                            </div>						  

                                        </div>									
                                    </div>									
                                </div>
                            </div>
                            <div class=" col-md-2 ">
                                <div class="setBox text-center">
                                    <input type="button" class="btn btn-secondary addBtnDrug"  onclick="addRow('dataTable')" value="Add"/>
                                </div>								
                            </div>	
                        </div>

                        <div class="row innerRow">
                            <div class="table-responsive" id="tableDiv" style="display: none;">
                                <table class="table table-bordered table-striped" id="dataTable">
                                    <tr>
                                        <th>Each</th>
                                        <th>Generic Name</th>
                                        <th>Strength</th>	
                                        <th>Unit</th>	
                                        <th></th>	
                                        <th></th>
                                    </tr>
                                    
                                </table>
                            </div>
                        </div>

                        <div class="form-group  row innerRow">
                            <div class="col-md-2">
                                <div class="setBox ">
                                    <div class="form-group myF_Control">
                                        <label for="inputBrand">Brand Name</label>
                                    </div>
                                </div></div>    
                            <div class="col-sm-10 col-md-4">
                                <input type="text" class="form-control" id="brand"  placeholder="Enter Brand Name" > 
                                <!--onkeyup = "if (event.keyCode === 13) {return myFunction();}">-->

                                <div class="brandSelected" id="brandSelected" ></div>
                                <form:input type="hidden" path="BrandName" id="BrandName"/>
                            </div><div><img src='/EMR/static/images/edit.png' onclick="editBrand();"/></div>
                        </div>

                        <div class="row innerRow">
                            <div class="col-md-4">
                                <div class="setBox ">

                                    <div class="form-group myF_Control">
                                        <label for="exampleInputEmail1">Company Name</label>
                                        <form:input path="Company" class="form-control " id="password" aria-describedby="emailHelp" placeholder=""/>
                                    </div>						  
                                </div>									
                            </div>
                            <div class="col-md-4">
                                <div class="setBox ">

                                    <div class="form-group myF_Control">
                                        <label for="exampleInputEmail1">Division</label>
                                        <form:input path="Division" class="form-control " id="Division" aria-describedby="emailHelp" placeholder=""/>
                                    </div>						  
                                </div>									
                            </div>
                            <div class="col-md-4">
                                <div class="">
                                    <div class="form-group myF_Control">
                                        <label class="mSet" for="exampleFormControlSelect1">Dose</label>
                                        <form:select path="Dose" class="form-control" id="Dose">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </form:select>
                                    </div>	
                                </div>		
                            </div>
                            <div class="col-md-4">
                                <div class="">
                                    <div class="form-group myF_Control">
                                        <label class="mSet" for="exampleFormControlSelect1">Frequency</label>
                                        <form:select path="Frequency" class="form-control" id="Frequency">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </form:select>
                                    </div>	
                                </div>		
                            </div>	
                            <div class="col-md-4">
                                <div class="">
                                    <div class="form-group myF_Control">
                                        <label class="mSet" for="exampleFormControlSelect1">Duration</label>

                                        <form:select path="Duration" class="form-control" id="Duration">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </form:select>
                                    </div>	

                                </div>		
                            </div>	
                            <div class="col-md-4">
                                <div class="">

                                    <div class="form-group myF_Control">
                                        <label class="mSet" for="exampleFormControlSelect1">Route</label>

                                        <form:select path="Route" class="form-control" id="Route">
                                            <option>1</option>
                                            <option>2</option>
                                            <option>3</option>
                                            <option>4</option>
                                            <option>5</option>
                                        </form:select>
                                    </div>	

                                </div>		
                            </div>								
                        </div>
                        <div class="row innerRow">
                            <div class="col-md-4">
                                <div class="setBox ">
                                    <div class="form-group myF_Control">
                                        <label for="exampleInputEmail1">Remark</label>
                                        <form:input path="Remark" class="form-control " id="Remark" aria-describedby="emailHelp" placeholder=""/>
                                    </div>						  
                                </div>									
                            </div>
                            <div class="col-md-4">
                                <div class="text-center">
                                    <c:choose>
                                        <c:when test="${edit}">
                                            <input type="submit" onclick="return test()" style=" margin: 31px 10px auto;" value="Update"  class="btn btn-primary"/><span class="cancelBtn">or <a href="<c:url value='/drug' />">Cancel</a></span>
                                        </c:when> 
                                        <c:otherwise>
                                            <input type="submit" onclick="return test()" style=" margin: 31px 10px auto;" value="Submit" class="btn btn-primary"/><span class="cancelBtn">or <a href="<c:url value='/drug' />">Cancel</a></span>
                                        </c:otherwise>
                                    </c:choose>    
                                </div>
                            </div>        
                        </div>
                    </div>
                    <div class="">
<!--                        <div class="logSec">
                            <button type="button" class="btn btn-secondary loginBtn">Logout</button>                            
                        </div>-->
                    </div>
                </div>			
            </div>
        </form:form>
    </div>
    <script src="<c:url value='/static/js/3.1.1_min.js' />"></script>
    <script src="<c:url value='/static/js/lbp.js' />"></script>
    <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
    <script>
                                                $(document).ready(function () {
                                                    $("#dataTable").on('click', '.btnDelete', function () {
                                                        $(this).closest('tr').remove();
                                                    });

                                                    $('#brand').keydown(function (e) {

                                                        if (e.keyCode === 13) {
                                                            var str = document.getElementById('brand').value;
                                                            var div = document.getElementById('brandSelected').innerHTML;
                                                            if ($.trim(div) === '') {
                                                                document.getElementById('brandSelected').innerHTML = $.trim(str);
                                                                document.getElementById('BrandName').value = $.trim(str);
                                                            } else {
                                                                document.getElementById('brandSelected').innerHTML = div + ", " + $.trim(str);
                                                                document.getElementById('BrandName').value = div + ", " + $.trim(str);
                                                            }
                                                            document.getElementById('brand').value = "";

                                                            e.preventDefault();

                                                            return false;
                                                        }

                                                    });
                                                });
                                                function afterRemove() {
                                                    var table = document.getElementById("dataTable");
                                                    var rowCount = table.rows.length;
                                                    if (rowCount > 2) {
                                                        $("#tableDiv").show()();
                                                    } else {
                                                        $("#tableDiv").hide();
                                                    }
                                                }
    </script>
</body>	
</html>





