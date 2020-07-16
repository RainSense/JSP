<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <style>
      .bg-image-full {
        background: no-repeat center center scroll;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        background-size: cover;
        -o-background-size: cover;
      }

      div.bg-image-full{
        height: 300px;
        text-align: center;
      }

      @font-face { font-family: 'GmarketSansBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.1/GmarketSansBold.woff') format('woff'); font-weight: normal; font-style: normal; }
      div.bg-image-full>h1{
        color : white;
        position: relative;
        top : 75px;
        font-size: 3em;
        font-family: 'GmarketSansBold';
        text-shadow: -2px 0 black, 0 2px black, 2px 0 black, 0 -2px black;
      }
  </style>
</head>
<body>
	<%@ include file="WEB-INF/views/common/header.jsp" %>

	<!-- 메인 화면 이미지 -->
	<div class="py-5 bg-image-full" style="background-image: url('https://iei.or.kr/resources/images/intro/intro_bg.jpg');">
	    <h1>더 나은 만남, 더 나은 인연</h1>
	</div>
	
	<!-- 내용 작성 부분 -->
	<div class="py-5">
	  <div class="container">
	 
	    <h1>Better Meet</h1>
	     <br>
	    <p class="lead">만남과 시간을 소중히 여기는 당신에게.</p>
	    <p>흔하지 않은 만남은 어렵습니다. 왜냐하면 서로 가진 삶의 방향성이 다르기 때문입니다. 하지만, 서로가 누군지 알고 서로가 무엇을 좋아하는지 알고, 서로가 잘 맞을 거라는 걸 아는 만남이 자주 이뤄진다면, 우리의 삶에도 더 나은 인연이 생긴다면, 힘든 삶이 더 행복하지 않을까요? better meet, 당신에게 드립니다.</p>
	  </div>
	</div>
	
	<div class="py-5">
	  <div class="container">
	 
	    <h1>Better Meet</h1>
	     <br>
	    <p class="lead">만남과 시간을 소중히 여기는 당신에게.</p>
	    <p>흔하지 않은 만남은 어렵습니다. 왜냐하면 서로 가진 삶의 방향성이 다르기 때문입니다. 하지만, 서로가 누군지 알고 서로가 무엇을 좋아하는지 알고, 서로가 잘 맞을 거라는 걸 아는 만남이 자주 이뤄진다면, 우리의 삶에도 더 나은 인연이 생긴다면, 힘든 삶이 더 행복하지 않을까요? better meet, 당신에게 드립니다.</p>
	  </div>
	</div>
	
	<%@ include file="WEB-INF/views/common/footer.jsp" %>
	
</body>
</html>