/**
 * 
 */

function imageCheck(){
	if (document.imageboardWriteForm.imageId.value == "") {
		alert("상품코드 입력하시오");
	}else if (document.imageboardWriteForm.imageName.value == "") {
		alert("상품명 입력하시오");
	}else if (document.imageboardWriteForm.imagePrice.value == "") {
		alert("단가를 입력하시오");
	}else if (document.imageboardWriteForm.imageQty.value == "") {
		alert("갯수를 입력하시오");
	}else if(document.imageboardWriteForm.imageContent.value == ""){
		alert("내용을 입력하세요");
	}else if(document.imageboardWriteForm.image1.value == ""){
		alert("파일을 선택하세요");
	}else{
		document.imageboardWriteForm.submit();
	}
}