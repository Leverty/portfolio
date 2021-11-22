<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
   <title>Create an account</title>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
   <!-- 스타일시트 참조  -->
   <link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.min.css">
   <!-- 합쳐지고 최소화된 최신 CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
   
      <!-- 부가적인 테마 -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
   
      <!-- Google CDN -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
   
      <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
      
      <!-- CSS -->
	  <link href="../../resources/css/default.css" rel="stylesheet" type="text/css">
      <style>
         #registerh2 {
            text-align:center;
            font-size: 40px;
            margin: 5px, 10px, 10px, 0;
         }
      </style>
</head>
<body>
<!-- top menu start -->
<%@ include file="../include/topmenu.jsp" %>
<!-- top menu end -->

<!-- 회원가입 From -->
<div class="container">
   <form class="form-horizontal" role="form" name="registerForm" id="registerForm" action="/member/register" method="post">
      <h2 id="registerh2">회원가입</h2>
      <div class="form-group">
         <label for="firstName" class="col-sm-4 control-label">이름</label>
         <div class="col-sm-5">
            <input type="text" id="userName" name="userName" placeholder="Name" class="form-control" autofocus>
         </div>
      </div>
      <div class="form-group">
         <label for="firstName" class="col-sm-4 control-label">아이디</label>
         <div class="form-inline">
            <button class="idCheck btn btn-warning form-control" type="button" id="idCheck" onclick="fn_idCheck();" value="N">아이디 중복확인</button>
            <div class="col-sm-3">
            <input type="text" id="userId" name="userId" placeholder="Id" class="form-control" autofocus>               
                </div>    
         </div>
      </div>
      <div class="form-group">
         <label for="password" class="col-sm-4 control-label">비밀번호</label>
         <div class="col-sm-5">
            <input type="password" id="userPw" name="userPw" placeholder="Password" class="form-control">
         </div>
      </div>
      <div class="form-group">
         <label for="password" class="col-sm-4 control-label">비밀번호 확인</label>
         <div class="col-sm-5">
            <input type="password" id="userPwCheck" name="userPwCheck" placeholder="Password Check" class="form-control">
         </div>
      </div>
      <div class="form-group">
         <label for="email" class="col-sm-4 control-label">이메일</label>
         <div class="col-sm-5">
            <input type="email" id="userEmail" name="userEmail" placeholder="Email" class="form-control">
         </div>
      </div>
      <div class="form-group">
         <label for="email" class="col-sm-4 control-label">핸드폰 번호</label>
         <div class="col-sm-5">
            <input type="text" id="userPhone" name="userPhone" placeholder="010-1234-5678" class="form-control">
         </div>
      </div>
      <div class="form-group">
         <label for="birthDate" class="col-sm-4 control-label">생일</label>
         <div class="col-sm-5">
            <input type="date" id="userBirth" name="userBirth" class="form-control">
         </div>
      </div>
      <div class="form-group">
         <label for="country" class="col-sm-4 control-label">주소</label>
         <div class="form-inline">
            <input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기" class="form-control">
            <div class="col-sm-3">
               <input type="text" id="sample6_postcode" name="sample6_postcode" placeholder="우편번호" class="form-control">
                </div>    
         </div>
      </div>
      <div class="form-group">
         <label class="col-sm-4 control-label"></label>
         <div class="col-sm-5">
            <input type="text" id="sample6_address" name="sample6_address" placeholder="주소" class="form-control">
         </div>
      </div>
      <div class="form-group">
         <label class="col-sm-4 control-label"></label>
         <div class="col-sm-3">
            <input class="form-control" type="text" id="sample6_detailAddress" name="sample6_detailAddress" placeholder="상세주소">
            <input class="form-control col-sm-4" type="text" id="sample6_extraAddress" placeholder="참고항목">
         </div>
      </div>
      <div class="form-group">
         <label class="control-label col-sm-4">성별</label>
         <div class="col-sm-6">
            <div class="row">
               <div class="col-sm-4">
                  <select id="userGender" name="userGender" class="form-control">
                     <option>선택</option>
                     <option>남자</option>
                     <option>여자</option>                        
                  </select>
               </div>
            </div>
         </div>
      </div> <!-- /.form-group -->
      <div class="form-group">
         <div class="col-sm-9 col-sm-offset-4">
            <div class="checkbox">
               <label>
                  <input type="checkbox" id="agree" name="agree"><a href="#">이용약관</a>에 동의합니다.
               </label>
            </div>
         </div>
      </div> <!-- /.form-group -->
      <div class="form-group">
         <div class="col-sm-5 col-sm-offset-4">
            <button type="submit" id="submit" name="submit" class="btn btn-primary btn-block">회원가입</button>
         </div>
      </div>
   </form> <!-- /form -->
</div> <!-- ./container -->

<!-- footer start -->
<%@ include file="../include/footer.jsp" %>
<!-- footer end -->

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="../../../resources/js/register.js"></script>

</body>
</html>