<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
                   				<div  class="dataTables_wrapper form-inline dt-bootstrap">
                   					
											
												
											<table class="table table-bordered table-striped dataTable"  style="cursor: pointer;">
											  <thead>
											    <tr>
											      <th>Candidate Name</th>
											      <th>Mobile No</th>
											      <th>Emergency Phone</th>
											      <th>Occupation</th>
											      <th>Work Place</th>
											      <th>Id Type</th>
											      <th>Id No</th>
											     
											    </tr>
											  </thead>
											  <tbody>
											  		<tr>
											  		  <td>${candidate.name }</td>
											  		  <td>${candidate.mobileNo }</td>
											  		  <td>${candidate.emergencyContactNo }</td>
											  		  <td>${candidate.occupation }</td>
											  		  <td>${candidate.workPlace }</td>
											  		  <td>${candidate.idType }</td>
											  		 <td>${candidate.idNo }</td>
									  		
											  		 
											  </tr>
											  
											  </tbody>
											 </table> 
												
										<!-- ROW 2 -->
										
										
										
											
                   					</div>
                   				
                   					