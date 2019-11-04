$('#imageboardWriteBtn').on("click" , function(){
	$('#imageIdDiv').empty();
	$('#imageNameDiv').empty();
	$('#imagePriceDiv').empty();
	$('#imageQtyDiv').empty();
	$('#imageContentDiv').empty();
	$('#img1Div').empty();
	
	if($('#imageId').val()==''){
		$('#imageIdDiv').html("<span style='color:red; font-size:7px;'>상품코드를 입력하시오</span>");
		
	}else if($('#imageName').val()==''){
		$('#imageNameDiv').html("<span style='color:red; font-size:7px;'>상품명을 입력하시오</span>");
		
	}else if($('#imagePrice').val()==''){
		$('#imagePriceDiv').html("<span style='color:red; font-size:7px;'>단가를 입력하시오</span>");
		
	}else if($('#imageQty').val()==''){
		$('#imageQtyDiv').html("<span style='color:red; font-size:7px;'>갯수 입력하시오</span>");
		
	}else if($('#imageContent').val()==''){
		$('#imageContentDiv').html("<span style='color:red; font-size:7px;'>내용을 입력하시오</span>");
		
	}else{
		var formData = new FormData($('#imageboardWriteForm')[0]); //forms[0] 의미가 같다
		$.ajax({
			type : 'post' , 
			enctype : 'multipart/form-data',
			processData : false , //데이터를 컨텐트 타입에 맞게 변환 여부
			contentType : false , //요청 컨텐트 타입, contentType: "application/json"
			url : '/springProject/imageboard/imageboardWrite',
			data : formData,
			success : function(){
				alert('등록성공');
				$(location).attr("href", "http://localhost:8080/springProject/imageboard/imageboardList");
			},
			error : function(err){
				console.log(err);
				alert('실패');
			}
		});
	}
});
