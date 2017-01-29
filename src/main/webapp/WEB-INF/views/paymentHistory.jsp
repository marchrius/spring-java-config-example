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
											      <th>#No</th>
											      <th>Paid Date</th>
											      <th>Paid Amount</th>
											      <th>Actual Fee</th>
											     
											    </tr>
											  </thead>
											  <tbody>
											  <c:forEach var="payments" items="${payments }" varStatus="count">
											  		<tr>
											  		   <td>${count.count }</td>
											  		  <td><fmt:formatDate value="${payments.paidDate}" pattern="dd-MMM-yyyy"/></td>
											  		  <td>${payments.paidAmount}</td>
											  		  <td>${payments.candidate.candidateFee }</td>
											  		  
											  		 
											  </tr>
											  </c:forEach>	
											  
											  </tbody>
											 </table> 
                   					</div>
                   				
                   					