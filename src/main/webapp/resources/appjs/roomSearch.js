$(function(){
	
	$("#search").on("click",searchRooms);
	$("#building").on("change",getSharingTypes);
	
});

var searchRooms=function(){
	 var table=$('#example1').DataTable();
	 
	var buildingId=$("#building :selected").val();
	console.log(buildingId);
	
	var searchReqObj={};
	
	if(buildingId.length==0){
		alert("Building must select ");
		return false;
	}
	searchReqObj.buildingId=Number(buildingId);
	
	var shareTypeId=$("#sharing :selected").val();
	
	if(shareTypeId.length!=0){
		searchReqObj.shareTypeId=Number(shareTypeId);
	}
	
	if($("#fully").prop("checked")){
		searchReqObj.fully=true;
	}else{
		searchReqObj.fully=false;
	}
	
	if($("#partially").prop("checked")){
		searchReqObj.partially=true;
	}else{
		searchReqObj.partially=false;
	}
	
	if($("#empty").prop("checked")){
		searchReqObj.empty=true;
	}else{
		searchReqObj.empty=false;
	}
	
	if($("#vacates").prop("checked")){
		searchReqObj.vacates=true;
	}else{
		searchReqObj.vacates=false;
	}
	
	console.log(searchReqObj);
	
	$.ajax({
		type: "POST",
		contentType:"application/json",
		data:JSON.stringify(searchReqObj),
		url:context+"/auth/findRooms",
		success:function(resp){
			//console.log(resp);
			diplayTable(resp,searchReqObj,table);
		},
		error:function(ex){
			console.log(ex);
		}
	});
};

var diplayTable=function(response,searchReqObj,table){
	console.log(response);
	console.log(searchReqObj);
	table.clear();
	$.each(response,function(index,roomObject){
		console.log(roomObject);
	// setting color codes based on search criteria 
	
	if(searchReqObj.fully){
	   		if(roomObject.capacity==roomObject.occupaid){
	   			//#ff5d5d
	   			var rowNode=table.row.add([
	   			       			 (index+1),
	   			       			roomObject.roomCategory,
	   			       			roomObject.floorName,
	   			       			roomObject.roomName,
	   			       			roomObject.capacity,
	   			       			roomObject.occupaid,
	   			       			roomObject.cost
	   			       		]).draw().node();
	   			$(rowNode).css('background-color', '#ff5d5d');
	   		}
	}
	
	if(searchReqObj.partially && roomObject.occupaid!=0){
		if(roomObject.capacity>roomObject.occupaid){
			var rowNode=table.row.add([
 			       			 (index+1),
 			       			roomObject.roomCategory,
 			       			roomObject.floorName,
 			       			roomObject.roomName,
 			       			roomObject.capacity,
 			       			roomObject.occupaid,
 			       			roomObject.cost
 			       		]).draw().node();
			$(rowNode).css('background-color', '#fdff5d');
		}
	}
	
	if(searchReqObj.empty){
		if(roomObject.occupaid==0){
			var rowNode=table.row.add([
			       			 (index+1),
			       			roomObject.roomCategory,
			       			roomObject.floorName,
			       			roomObject.roomName,
			       			roomObject.capacity,
			       			roomObject.occupaid,
			       			roomObject.cost
			       		]).draw().node();
			$(rowNode).css('background-color', '#94ff5d');
		}
	}
	
	if(searchReqObj.vacates){
		
	}
	
	});
	
	
	
};

var getSharingTypes=function(){
	var buildingId=$(this).val();
	$('#sharing').html("");
	$('#sharing').append('<option value="">--select--</option>');
	
	if(buildingId.length!=0){
		$.ajax({
			type:"GET",
			url: context+"/auth/getShareTypes/"+buildingId,
			success:function(resp){
				console.log(resp);
				$.each(resp, function(index, value){
					$('#sharing').append('<option value="'+value.roomTypeId+'">'+value.roomCategroy+'</option>');
				});
			},
			error:function(ex){
				alert("Check your network/ Contact your provider");
			}
		});
	}
};