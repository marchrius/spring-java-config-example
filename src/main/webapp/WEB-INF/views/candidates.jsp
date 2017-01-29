<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<jsp:include page="common/css.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/bootstrap/css/dataTables.bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap-datetimepicker.min.css"></link>	
</head>
<body class="skin-blue sidebar-mini"> 
  <div class="wraper">
	<jsp:include page="common/header.jsp"></jsp:include>
	
	<div class="content-wrapper" style="margin-left: 0px;">
       
        <!-- Main content -->
        <section class="content">
        
        <div class="modal fade" id="vacateModal">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                    <h4 class="modal-title">Vacate Information</h4>
                  </div>
                  <div class="modal-body">
                  <div class="form-group row" id="duedate">
                      <label for="section" class="col-xs-3" >Vacate Date</label>
                      <div class="col-xs-6">
                        <input type="text" placeholder="Vacate" id="due" name="nextDue" class="form-control"  REQUIRED>
                        <input type="hidden" name="candidateId" id="candidateId">
                      </div>
                    </div>
                    <!-- <p>One fine body...</p> -->
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="vacateCandidate()">Vacate</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div>
            
            <div class="modal fade" id="vacateEditModal">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                    <h4 class="modal-title">Vacate Information</h4>
                  </div>
                  <div class="modal-body">
                  <div class="form-group row" id="duedate">
                      <label for="section" class="col-xs-3" >Vacate Date</label>
                      <div class="col-xs-6">
                        <input type="text" placeholder="Vacate" id="editVacate" name="editVacate" class="form-control"  REQUIRED>
                        
                      </div>
                    </div>
                    <!-- <p>One fine body...</p> -->
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary red" onclick="cancelVacate()" >Cancel Vacate</button>
                    <button type="button" class="btn btn-primary" onclick="updateVacate()">Postpone</button>
                     <button type="button" class="btn btn-primary" onclick="vacate()">Kick Off</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div>
            
            <div class="modal fade" id="paymentHistory">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                    <h4 class="modal-title">Payment History </h4>
                  </div>
                  <div class="modal-body paymentHistory-body">
                    
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div>
            <div class="modal fade" id="moreInfoModal">
              <div class="modal-dialog" style="width: 70%;">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                    <h4 class="modal-title">Candidate More Info : </h4>
                  </div>
                  <div class="modal-body moreInfoModal" >
                    
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div>
			<div class=row style="margin-left: 10%;margin-right: auto;width: 120%;">
				<div class="col-md-8">
				<!--  User body starts from here -->
				<div class="box box-success">
					<div class="box-body">
						<div class="col-md-12" style="box-shadow:3px 0px 15px 2px rgba(0, 0, 0, 0.125) ! important; padding-top:5px;">
							<div class="row">
							
							<div class="col-md-3">
							    <div class="row">
								<label class="col-md-3">Building</label>
								<div class="col-md-9">
								<select class="form-control" id="buildingSelect">
								<option>- select -</option>
								<c:forEach var="building" items="${buildings}" varStatus="count">
								<c:choose>
								    <c:when test="${count.count eq 1}">
								       <option value="${building.buildingId}" selected="selected">${building.buildingName}</option>
								    </c:when>
								    <c:otherwise>
								        <option value="${building.buildingId}">${building.buildingName}</option>
								    </c:otherwise>
								</c:choose>
								
								</c:forEach>
								</select>
								</div>
								</div>
							</div>
						   
						    	<div class="col-md-2">
									 <div class="checkbox" >
				                        <label >
				                          <input type="checkbox" id="onlyVacates">
				                               <span style="color:#ff0303; ">Only Vacates</span>
				                         </label>
				                      </div>
									  
								</div>
								<div class="col-md-3">
									<button class="btn btn-primary" id="Go">Go</button>
								</div>
								
						   
							</div>
							 <div class="row" style="height: 2px; background: #f5f5f5;margin-top:5px; "></div>
							<div class="row" style="padding:0px 5px 0px 5px;">
								<div class="col-md-12" id="candidateTable" style=" display: none;">
								<div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap" style="padding-top:10px;">
									
									<div class="row">
										<div class="col-sm-12 no-padding">
											<table class="table table-bordered table-striped dataTable" id="example1">
											  <thead>
											    <tr>
											      <th>#NO</th>
											      <th>Candidate Name</th>
											      <th>Mobile No</th>
											      <th>Emergency Phone</th>
											      <th>Room No</th>
											      <th>Room Type</th>
											      <th>Fee Amount</th>
											      <th>Join Date</th>
											      <th>Action</th>   
											    </tr>
											  </thead>
											  <tbody>
											  	
											  </tbody>
											  </table>
										</div>
									</div>
								</div>
							</div>
							</div>
						
						</div>
						
					
							
					</div>	
					
				</div>
				</div>
			</div>
		</section>
		
	</div>
	
	 <jsp:include page="common/footer.jsp"></jsp:include>
	</div>
	 <jsp:include page="common/scripts.jsp"></jsp:include>
       <script src="<%=request.getContextPath() %>/resources/bootstrap/js/datepicker.js" type="text/javascript"></script>
       <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/jquery.dataTables.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/dataTables.bootstrap.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/moment.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
       <script type="text/javascript">
			$(function(){
				
				$("#candidatesDetails-tab").addClass("tabActive");
				var nowDate = new Date();
				var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
				  $('#due').datetimepicker({format: 'DD-MM-YYYY',minDate: today });	
				  $('#editVacate').datetimepicker({format: 'DD-MM-YYYY'});	
				  var table=$('#example1').DataTable();
				  $("#Go").on("click",function(){
					  getCandidates(table);
				  });
				  getCandidates(table);  
			});
			
			function showVacateForm (candidateId) {
				$("#candidateId").val(candidateId);
				  
				$("#vacateModal").modal("show");
			}
			
            function showEditVacateForm (candidateId, vacationDate) {
            	$("#candidateId").val(candidateId);
            	$("#vacateEditModal").modal("show");
            	$("#editVacate").val(moment(vacationDate).format("DD-MMM-YYYY"));
            	
            }
			
			function vacateCandidate () {
               var candidateId = $("#candidateId").val();
               var date = $("#due").val();
               var table=$('#example1').DataTable();
				  table.clear();
               $.ajax({
   	 			type: "GET",
   	 			url: context + "/auth/updateVacateData/"+candidateId+"/"+date,
   	 			cache: false,
   				contentType: 'text/html',
   	 			success: function(res){
   	 			

		   				 alert("Updated Successfully"); 
   		   	 			$("#vacateModal").modal("hide");
   		   	 		    getCandidates(table);
   	 				
   	 			}
   	 		});
			}

			function updateVacate(){
				var candidateId = $("#candidateId").val();
	               var date = $("#editVacate").val();
	               var table=$('#example1').DataTable();
					  table.clear();
	               $.ajax({
	   	 			type: "GET",
	   	 			url: context + "/auth/updateVacateData/"+candidateId+"/"+date,
	   	 			cache: false,
	   				contentType: 'text/html',
	   	 			success: function(res){
	   	 			$("#vacateEditModal").modal("hide");
					alert("Updated successfully");
					
	   		   				  
	   		   	 			$("#vacateModal").modal("hide");
	   		   	 		    getCandidates(table);
	   		   	 		    
	   	 			}
	   	 		});
			}

			function cancelVacate(){
				var candidateId = $("#candidateId").val();
	               var table=$('#example1').DataTable();
					  table.clear();
	               $.ajax({
	   	 			type: "GET",
	   	 			url: context + "/auth/cancelVacate/"+candidateId,
	   	 			cache: false,
	   				contentType: 'text/html',
	   	 			success: function(res){
	   	 			$("#vacateEditModal").modal("hide");
					alert("Updated successfully");
	   		   	 			$("#vacateModal").modal("hide");
	   		   	 		    getCandidates(table);
	   		   	 			}
	   	 		});
			}

			function vacate(cid){
				var candidateId = $("#candidateId").val();
				$.ajax({
	   	 			type: "GET",
	   	 			url: context + "/auth/vacate/"+candidateId,
	   	 			cache: false,
	   				contentType: 'text/html',
	   	 			success: function(res){
	   	 			$("#vacateEditModal").modal("hide");
					alert("Updated successfully");
	   		   				  
	   		   	 		    getCandidates(table);
	   				 				
	   	 			}
	   	 		});
				}
			function getCandidates (table) {
				var buildingId = $("#buildingSelect").val();
	               console.log("buildingId: " + buildingId);
	               var isOnlyVacates=$("#onlyVacates").prop("checked");
				$.ajax({
		   	 			type: "GET",
		   	 			url: context + "/auth/candidatesList/"+buildingId+"/"+isOnlyVacates,
		   	 			cache: false,
		   				contentType: 'text/html',
		   	 			success: function(candidatesRes){
		   				  $("#candidateTable").show();
		   		table.clear();
		   	 			$.each(candidatesRes,function(index,candidate){
		   	 				var toggleDropdown = null;
		   	 				
		   	 				if (candidate.vacationFlag == 0) {
			   	 				console.log(candidate.vacationDate);
		   	 					toggleDropdown = '<div class="btn-group" style="width:100px;">'
 				                       +'<button class="btn btn-warning btn-xs" type="button">Options</button>'
   	 				                   +'<button data-toggle="dropdown" class="btn btn-warning dropdown-toggle btn-xs" type="button" style="height: 22px;" >'
   	 				               +'   <span class="caret"></span>'
   	 				           +'       <span class="sr-only">Toggle Dropdown</span> '
   	 				       +'         </button> '
   	 				   +'									  		  	<ul role="menu" class="dropdown-menu" >'
   	 				+'									                        <li><a href="#"  onclick="showEditVacateForm('+candidate.candidateId+', &apos;'+candidate.vacationDate+'&apos;)">Edit/Cancel Vacate</a></li>'
   	 			+'																<li><a href="#" onclick="editCandidate('+candidate.candidateId+')">Edit Details</a></li>'														
   	 			+'<li><a href="#" onclick="showPaymentHistory('+candidate.candidateId+')"> Payment History</a></li>'
   	 			 +'<li><a href="#" onclick="showMoreInfo('+candidate.candidateId+')" >View More info...</a></li>'
   	 		+'                  										   </ul> </div>';
		   	 				} else {
		   	 				toggleDropdown = '<div class="btn-group" style="width:100px;">'
				                       +'<button class="btn btn-warning btn-xs" type="button">Options</button>'
				                   +'<button data-toggle="dropdown" class="btn btn-warning dropdown-toggle btn-xs" type="button" style="height: 22px;" >'
				               +'   <span class="caret"></span>'
				           +'       <span class="sr-only">Toggle Dropdown</span> '
				       +'         </button> '
				   +'									  		  	<ul role="menu" class="dropdown-menu" >'
				+'									                        <li><a href="#"  onclick="showVacateForm('+candidate.candidateId+')">Vacate</a></li>'
			+'<li><a href="#" onclick="editCandidate('+candidate.candidateId+')">Edit Details</a></li>'
			+'<li><a href="#" onclick="showPaymentHistory('+candidate.candidateId+')">Payment History</a></li>'									                        
			+'<li><a href="#" onclick="showMoreInfo('+candidate.candidateId+')" >View More info...</a></li>'
		+'                  										   </ul> </div>';
		   	 				}
		   	 				//var joinDate=moment(candidate.joinDate, "yyyy-mm-dd").format("D-MMM-yyyy");
		   	 				//console.log(moment(candidate.joinDate).format("DD-MMM-YYYY"));
		   	 				var rowNode=table.row.add([index+1,candidate.fullName,candidate.mobileNo,candidate.emergencyContactNo,
		   	 				                           candidate.roomName, candidate.roomCategory, candidate.candidateFee,moment(candidate.joinDate).format("DD-MMM-YYYY"), toggleDropdown
		   	 				                           ]).draw().node();
		   	 			if(candidate.vacationFlag == 0) {
		   	 				console.log("Zero :");
		   	 				$(rowNode).css('background-color', 'rgb(255, 224, 241)');
		   	 			}
		   	 				
		   	 			});
		   	 			  	 			
		   	 			
		   	 			}
		   	 		});
			}

	function showPaymentHistory(candiateId){
		 $.ajax({
   	 			type: "GET",
   	 			url: context + "/auth/paymentHistory/"+candiateId,
   	 			cache: false,
   				contentType: 'text/html',
   	 			success: function(response){
   				  
   	 			$("#paymentHistory").modal("show");
   	 		$(".paymentHistory-body").html(response);
   	 		    
   	 		    
   	 			}
   	 		}); 
		}

	function showMoreInfo(candidateId){
		$.ajax({
	 			type: "GET",
	 			url: context + "/auth/candidateDetails/"+candidateId,
	 			cache: false,
				contentType: 'text/html',
	 			success: function(response){
				  
	 			$("#moreInfoModal").modal("show");
	 		$(".moreInfoModal").html(response);
	 		    
	 		    
	 			}
	 		}); 
		}

	function editCandidate(cid){
		window.location.href=context+"/auth/editCandidateInfo/"+cid;
		}				
       </script>
</body>				