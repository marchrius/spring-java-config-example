<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                  	  	<div class="row">	
                  	  		<div class="col-md-4">
                  	  		    <div class="row">
                  	  		      		 <label class="col-md-3">Building</label>
                  	  		      		 <div class="col-md-9">
                  	  		      		 		<select class="form-control">
                  	  								<option>--select--</option>
                  	  						</select>
                  	  		      		 </div>
                  	  				</div>
                  	  		</div>
                  	  		
                  	  		<div class="col-md-4">
                  	  		 <label class="col-md-4">Share Type</label>
                  	  		  <div class="col-md-8">
                  	  			  <select class="form-control col-md-9"></select>
                  	  		  </div>
                  	  		</div>
                  	  		
                  	  		<div class="col-md-4">
                  	  		     <div class="checkbox" style="top:5px;">
                        <label >
                          <input type="checkbox" >
                               <span class="btn btn-xs btn-warning vacation">Include Vacates</span>
                         </label>
                      </div>
                  	  		</div>
                  	  		
                  	  </div>
                  	  
                  	  <div class="row">
                  	  		
                  	  </div>
                  	  		
                  	  </div>
                  
                  </div><!-- /.box-body -->

              
              </div>
				</div>
				
			</div>
			
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      <jsp:include page="common/footer.jsp"></jsp:include>
     
   </div>
    
      
      
      <jsp:include page="common/scripts.jsp"></jsp:include>
      <script type="text/javascript">
		  $(function(){
			  $("#room-tab").addClass("tabActive");
			  });
      </script>
</body>
</html>