<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<jsp:include page="common/css.jsp"></jsp:include>

</head>
<body class="skin-blue sidebar-mini">
  <div class="wraper">
	<jsp:include page="common/header.jsp"></jsp:include>
	
	<div class="content-wrapper" style="margin-left: 0px;">
       
        <!-- Main content -->
        <section class="content">
			<div class=row style="margin-left: 10%;margin-right: auto;width: 120%;">
				<div class="col-md-8">
					<div class="box box-success">
                <!-- form start -->
                  <div class="box-body" >
                  	
                  	  <div class="col-md-12" style="box-shadow:3px 0px 15px 2px rgba(0, 0, 0, 0.125) ! important; padding-top:5px;">
                  			<div class="nav-tabs-custom">
                  				<ul class="nav nav-tabs">
                  					<li class="active"><a data-toggle="tab" href="#payments" aria-expanded="true">Today Payments</a></li>
                  					<li class=""><a data-toggle="tab" href="#pendings" aria-expanded="false">Pending Payments</a></li>
                				</ul>
                  			<div class="tab-content">
                  				<div id="payments" class="tab-pane active">
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
											      <th>Paid Date</th>
											      <th>Action</th>   
											    </tr>
											  </thead>
											  <tbody>
											        <c:forEach var="candidate" items="${todayPayments }" varStatus="count">
											  		<tr>
											  		  <td>${count.count }</td>
											  		  <td>${candidate.name }</td>
											  		  <td>${candidate.mobileNo }</td>
											  		  <td>${candidate.emergencyContactNo }</td>
											  		  <td>${candidate.room.roomName }</td>
											  		  <td>${candidate.room.roomType.roomCategory }</td>
											  		  <td>${candidate.candidateFee }</td>
											  		  <td>${candidate.dueDate }</td>
											  		  <td><button name="payNow" class="btn btn-xs btn-success" value="$(candidate.candidateId)">Pay</button></td>
											  		  </tr>
											  		  </c:forEach>
											  </tbody>
											</table>
                  				</div>
                  				<div id="pendings" class="tab-pane ">
                  						<table class="table table-bordered table-striped dataTable" id="pendingPays">
											  <thead>
											    <tr>
											      <th>#NO</th>
											      <th>Candidate Name</th>
											      <th>Mobile No</th>
											      <th>Emergency Phone</th>
											      <th>Room No</th>
											      <th>Room Type</th>
											      <th>Fee Amount</th>
											      <th>Paid Date</th>
											      <th>Action</th>   
											    </tr>
											  </thead>
											  <tbody>
											      <c:forEach var="candidate" items="${pendingPays }" varStatus="count">
											  		<tr>
											  		  <td>${count.count }</td>
											  		  <td>${candidate.name }</td>
											  		  <td>${candidate.mobileNo }</td>
											  		  <td>${candidate.emergencyContactNo }</td>
											  		  <td>${candidate.room.roomName }</td>
											  		  <td>${candidate.room.roomType.roomCategory }</td>
											  		  <td>${candidate.candidateFee }</td>
											  		  <td>${candidate.dueDate }</td>
											  		  <td ><button name="payNow" class="btn btn-xs btn-success" value="$(candidate.candidateId)">Pay</button></td>
											  		  </tr>
											  		  </c:forEach>
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
             
         </section>
         
         </div>
          <jsp:include page="common/footer.jsp"></jsp:include>
         
        </div>
        
        <jsp:include page="common/scripts.jsp"></jsp:include>
      <script type="text/javascript">
		  $(function(){
			  $("#payment-tab").addClass("tabActive");
			  $('#example1').DataTable();
			  $('#pendingPays').DataTable();
			  });
      </script>
       <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/jquery.dataTables.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/dataTables.bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/appjs/payments.js"></script>
       </body>
       
       </html>