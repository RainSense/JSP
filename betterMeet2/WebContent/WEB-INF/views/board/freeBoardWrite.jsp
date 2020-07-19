
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Better Meet 자유게시판 글쓰기</title>


	
	<!-- Bootstrap core JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<script src="https://cdn.ckeditor.com/ckeditor5/20.0.0/classic/ckeditor.js"></script>


<style>

  @font-face { font-family: 'TmoneyRoundWindExtraBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/TmoneyRoundWindExtraBold.woff') format('woff'); font-weight: normal; font-style: normal; }


        .cute_font{


            font-family: 'TmoneyRoundWindExtraBold';

            font-size: 100%;

        }




	#editor{
	
		
		width : 700px;
		
		height : 1200px;
	
	}
	
	textarea{
	
	width : 700px;
		
		height : 1200px;
	
	}



</style>



</head>




<body>


	<h1> 자유게시판 글 작성</h1>

	<form action="<%=request.getContextPath()%>/board/fBoardWriteSubmit.do">
   <textarea name="content" id="editor"></textarea>
<button type="button" class="btn btn-outline cute_font">글쓰기</button>
</form>
 <script>
    // 3. CKEditor5를 생성할 textarea 지정
    ClassicEditor
        .create( document.querySelector( '#editor' ) )
        .catch( error => {
            console.error( error );
        } );
    
    
    
    </script>




</body>
</html>