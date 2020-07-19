<%@page import="com.btm.better.board.model.vo.FreeBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Better Meet 자유게시판</title>


    
   <style>
   
   @font-face { font-family: 'TmoneyRoundWindExtraBold'; src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_20-07@1.0/TmoneyRoundWindExtraBold.woff') format('woff'); font-weight: normal; font-style: normal; }


        .cute_font{


            font-family: 'TmoneyRoundWindExtraBold';

            font-size: 100%;

        }



        .intro_board{

            font-size: 200%;
            
            margin-left: 40%;

        }

        #board_wrap{

            margin-left: 10%;

            width: 85%;
            height: 80%;


        }

        .select_search_type{

            margin-right: 5%;

            display:inline-block;

            color: #555;

            
        }

        .select_search_type:hover{
            
            color: black;

            text-decoration: underline;
        }

        form{
            display: inline-block;
        }

		

        .free_board_notice{
            
            border: 1px solid #e4e4e4;
            width: 84%;
            box-shadow: 0 3px 3px #777;

            height: 80px;

            position: relative;

            margin-top: 1%;

            
        }

        .tag_board{


            color: #3f729b;

            margin-left: 3%;

            

            

        }
        *{
            font-size: 105%;
        }
        
        .search_wrap{
            margin-left: 20%;
        }


        .free_board_no{

            display: inline-block;

            margin-left: 2%;

            
            line-height: bold;
        }

        .post_infomation{
            color: #ec5336;
            margin-left: 3%;

            float: right;
            

        }

        .post_infomation:blank{
         
            clear: both;
        }



        .board_click_no{
            color: black;
        }

        .board_content{
            margin-left: 3%;
            
            line-height: 2;

            color: #000;

            padding-bottom: 5px;



        }
        
        .my-5{
        	
        margin-left : 35%;
        display: inline-block;
        
        }
		
	

        .logo_image{
            margin-left: 26%;
        }



    .searchbar{
    margin-bottom: auto;
    margin-top: auto;
    height: 60px;
    background-color: #7FDBDA;
    border-radius: 30px;
    padding: 10px;
    }

    .search_input{
    color: white;
    border: 0;
    outline: 0;
    background: none;
    width: 0;
    caret-color:transparent;
    line-height: 40px;
    transition: width 0.4s linear;
    }

    .searchbar:hover > .search_input{
    padding: 0 10px;
    width: 250px;
    caret-color:red;
    transition: width 0.4s linear;
    }

    .searchbar:hover > .search_icon{
    background: white;
    color: #e74c3c;
    }

    .search_icon{
    height: 40px;
    width: 40px;
    float: right;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50%;
    color:white;
    text-decoration:none;
    }
    
    .btn {


  color: #FA8072;


  border-color: #FA8072;
  
  box-shadow: 0 3px 3px #777;

	
  
  margin-left: 79%;
  
  margin-top : 1%;

  }
  
  
   
   </style>
    
    

    </head>





    <body>

<%@  include file="../common/header.jsp" %>
       

    <div id="board_wrap">
			
			
			<img src="../resources/img/betterMeet.jpg" class="logo_image">
		
	
        <div class="intro_board cute_font">자유 게시판</div>
        <br>
        <br>

    <div class="select_search_type cute_font"> 최신순</div>
        
    <div class="select_search_type cute_font"> 추천순</div>
    <div class="select_search_type cute_font"> 댓글순</div>
    <div class="select_search_type cute_font"> 스크랩순</div>
    <div class="select_search_type cute_font"> 조회순</div>

    
    <form class="search_wrap">
    <%@ 


include file="../common/search_bar.jsp" %>

</form>

<br>

<br>
<%@  include file="../common/board.jsp" %>






                            
    

</div>


  
		






    </body>
</html>