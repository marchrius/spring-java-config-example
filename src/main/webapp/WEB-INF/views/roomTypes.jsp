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
                
                   			
                   				<div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap" style="padding-top:18px;">
                   				<div class="col-md-12">
                   					<button class="btn btn-success" id="addRoom">Add Room Type</button>
                   					
                   				</div>
                   					<div class="row">
                   						<div class="col-sm-12 ">
											<table class="table table-bordered table-striped dataTable" id="example1" style="cursor: pointer;">
											  <thead>
											    <tr>
											      <th>#NO</th>
											      <th>Room Type</th>
											      <th>Building</th>
											      
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
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <jsp:include page="common/footer.jsp"></jsp:include>
     <div class="modal fade" id="roomType">
              <div class="modal-dialog" style="width: 40%;">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                    <h4 class="modal-title">Room Types </h4>
                  </div>
                  <div class="modal-body" id="candidates-modal-body" >
                  <div class="form-group">
                      <label >Building</label>
                     <select class="form-control" id="buildingSelect">
								<option value="">- All -</option>
								<c:forEach var="building" items="${buildings}" varStatus="count">
								
      								<c:choose>
    <c:when test="${buildingId eq building.buildingId}">
       <option value="${building.buildingId}" selected="selected">${building.buildingName}</option>
    </c:when>
    <c:otherwise>
        <option value="${building.buildingId}">${building.buildingName}</option>
    </c:otherwise>
</c:choose>
								</c:forEach>
								</select>
                    </div>
                  
                  <div class="form-group">
                      <label >Room Name</label>
                      <input type="text" placeholder="Room Type" id="fullName" class="form-control required" value="${candidate.name}" name="roomType">
                    </div>
                  
                    <!-- <p>One fine body...</p> -->
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
                      <button class="btn btn-success">Save</button>
                  </div>
                </div><!-- /.modal-content -->
              </div><!-- /.modal-dialog -->
            </div>
   </div>
    
      
      
      <jsp:include page="common/scripts.jsp"></jsp:include>
     
       <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/jquery.dataTables.min.js"></script>
      <script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/dataTables.bootstrap.min.js"></script>
      
       <script type="text/javascript">
		  $(function(){
			  $("#admin-tab").addClass("tabActive");
			  $("#addRoom").on("click",function(){
				  $("#roomType").modal('show');
				  });
			  $.ajax({
				  url:context+"/auth/saveRoomType",
				  
				  });
			  });
      </script>
</body>
</html>