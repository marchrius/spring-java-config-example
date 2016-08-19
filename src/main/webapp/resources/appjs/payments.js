$(function(){
	 
	$('button[name="payNow"]').on('click',showPayment);
	
});

var showPayment=function(){
	var candidateId=$(this).val();
	console.log(candidateId);
	var name =$(this).parent().prev().prev().prev().prev().prev().prev().prev().text();
	var roomNo=$(this).parent().prev().prev().prev().prev().text();
	var feeAmount=$(this).parent().prev().prev().text();
	console.log(name+","+roomNo+", "+feeAmount);
	$("#paymentForm").modal('show');
	var header="You are viewing <b>"+name+"</b>, <b>Room -"+roomNo+"</b>, <b>feeAmount-"+feeAmount+"</b>";
	$(".modal-title").html(header);
};

