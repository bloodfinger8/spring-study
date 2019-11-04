<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form name="imageboardListForm" id="imageboardListForm" method="get" action="/springProject/imageboard/imageboardDelete">
	<table id="imageboardTable" border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="10">
			<tr>
				<td><input type="checkbox" id="all">번호</td>
				<td>이미지</td>
				<td>상품명</td>
				<td>단가</td>
				<td>갯수</td>
				<td>합</td>
			</tr>
	</table>
	
	<input type="button" value="선택삭제" id="choiceDeleteBtn">
	<div id="imageboardPaging" style="width:660px; text-align: center;"></div>
</form>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	$.ajax({
		type : 'post' ,
		url : '/springProject/imageboard/getImageboardList',
		data : 'pg=${pg}',
		dataType : 'json',
		success : function(data){
			//alert(JSON.stringify(data));
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>',{
					align: 'center',
					text: items.seq
					}).prepend($('<input/>',{
						type : 'checkbox',
						value : items.seq , 
						name : 'check',
						class : 'check'
				}))).append($('<td/>',{
					align: 'center',
					
					}).append($('<img/>',{
						src : '../storage/'+items.image1,
						style : 'cursor : pointer; width:40px; height:40px',
						class : items.seq+''
				}))).append($('<td/>',{
					align: 'center',
					text: items.imageName
				})).append($('<td/>',{
					align: 'center',
					text: items.imagePrice.toLocaleString()
				})).append($('<td/>',{
					align: 'center',
					text: items.imageQty
				})).append($('<td/>',{
					align: 'center',
					text: (items.imagePrice*items.imageQty).toLocaleString()
				})).appendTo($('#imageboardTable'));
				
				$('.' + items.seq).on('click' , function(){
					location.href="/springProject/imageboard/imageboardView?seq="+items.seq+"&pg=${pg}";
				});
			});
			
			$('#imageboardPaging').html(data.imageboardPaging.pagingHTML);
		},
		error : function(err){
			console.log(err);
		}
		
	});
	
	//체크버튼 누를시 모두 작동
	$('#all').on('click',function(){
		if($('#all').prop('checked')){
			$('.check').prop('checked' , true);
		}else{
			$('.check').prop('checked' , false);
		}
	});
	
	//선택삭제
	$('#choiceDeleteBtn').on('click' , function(){
		var count = $('.check:checked').length;
		if(count == 0){
			alert('삭제할 항목을 선택하세요');
		}else{
			var jbResult = confirm( '정말로 삭제하시겠습니까?' );
			if(jbResult){
				$('#imageboardListForm').submit();
			}
		}
	});
	
});



/* function isLogin(memId,seq,pg){
	if(memId==""){
		alert("로그인 먼저 해주세요");
	}else{
		location.href="/miniproject/imageboard/imageboardView.do?seq="+seq+"&pg="+pg;
	}
}
function checkAll(){
	var check = document.getElementsByName("check");
	
	if(document.getElementById("all").checked){
		for(i=0; i<check.length; i++) {
			check[i].checked = true;
		}
	}else{
		for(i=0; i<check.length; i++) {
			check[i].checked = false;
		}
	}
}

 function selectedDelete(){
	var ck = 0;
	var check = document.getElementsByName("check");
	for(var i=0; i < check.length; i++) {
		if(check[i].checked){
			ck = ck +1;
		}
	}
	if(ck==0){
		alert('항목을 선택하세요')
	}else{
		var jbResult = confirm( '정말로 삭제하시겠습니까?' );
		if(jbResult){
			for(var i=0; i < check.length; i++) {
				if(check[i].checked){
					document.imageboardListForm.submit();
				}
			}
		}
	} 
} */


</script>