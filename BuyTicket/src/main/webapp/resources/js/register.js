$(document).ready(function(){
   // 회원 가입 처리
   $('#submit').on("click", function() {
       //e.preventDefault();
   
       if($("#userName").val() ==''){
           alert('이름을 입력하세요');
           $("#userName").focus();
           return false;
       } 
      if($("#userId").val() ==''){
           alert('아이디를 입력하세요');
           $("#userId").focus();
           return false;
       }
       if($("#userPw").val() ==''){
           alert('비밀번호를 입력하세요');
           $("#userPw").focus();
           return false;
       }
       if($("#userPwCheck").val() ==''){
           alert('비밀번호를 다시 한번 더 입력하세요');
           $("#userPwCheck").focus();
           return false;
       }
       if($("#userPw").val()!== $("#userPwCheck").val()){
           alert('비밀번호를 둘다 동일하게 입력하세요');
           return false;
       }
      var email = $('#userEmail').val();
       if(email == ''){
           alert('이메일을 입력하세요');
           $("#userEmail").focus();
           return false;
       }
       var emailRegex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
       if (!emailRegex.test(email)) {
           alert('이메일 주소가 유효하지 않습니다. ex)abc@gmail.com');
           $("#userEmail").focus();
           return false;
       }
       if($("#userPhone").val() == ''){
           alert('휴대폰 번호를 입력해주세요');
           $("#userPhone").focus();
           return false;
       }
       if($("#userBirth").val() ==''){
           alert('생일을 입력하세요');
           $("#userBirth").focus();
           return false;
       }
       if($("#sample6_postcode").val() ==''){
           alert('주소를 입력해주세요');
           $("#sample6_postcode").focus();
           return false;
       }
       if($("#userGender").val() =='선택'){
           alert('성별을 입력해주세요');
           $("#userGender").focus();
           return false;
       }
       if($("#agree").is(":checked") == false){
           alert('약관에 동의하셔야 합니다');
           return false;      
       }
       alert('회원가입이 완료되었습니다.');
       $("#registerForm").submit();
       //document.getElementById($("#registerForm")).submit();
       return true;
   });
})

function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}

function fn_idCheck() {
	//alert("중복확인");
	$.ajax({
		url : "/member/idCheck",
		type : "post",
		dataType : "json",
		data : {"userId" : $("#userId").val()},
		success : function(data){
			if(data == 1) {
				alert("중복된 아이디입니다.");
			} else if(data == 0) {
				$("#idCheck").attr("value", "Y");
				alert("사용가능한 아이디입니다.");
			}
		}
	})
}