<%@page import="com.btm.better.board.model.vo.FreeBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Better Meet 자유게시판</title>
    </head>


    <link rel= "stylesheet" type="text/css" href="../resources/css/freeBoard.css">



    <body>

<%@ 


include file="../common/header.jsp" %>
       

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
<% List<FreeBoard> fBoardList = (List<FreeBoard>)request.getAttribute("fBoardList"); %>



<% for(int i = 0; i<fBoardList.size(); i++) {%>



<div class="free_board_notice">    


<div class="free_board_no cute_font"> #<%=fBoardList.get(i).getFreeBoardNo() %> </div>    
<span class="tag_board cute_font"   >#<%=fBoardList.get(i).getFreeBoardTag() %></span>   
<span class="tag_board cute_font" >#<%=fBoardList.get(i).getFreeBoardTag() %></span>   
<span  class="tag_board cute_font" >#<%=fBoardList.get(i).getFreeBoardTag() %></span>      





<div class="board_Info">
<span class="post_infomation cute_font"> 조회수 
<span class="board_click_no"><%=fBoardList.get(i).getFreeBoardNo() %> </span>  </span>
<span class="post_infomation cute_font"> 댓글
    <span class="board_click_no "><%=fBoardList.get(i).getFreeBoardReplyCount() %> </span>  
    </span>
    <span class="post_infomation cute_font"> 좋아요        <span class="board_click_no"><%=fBoardList.get(i).getFreeBoardLike() %> </span>  
        </span>
    </div>

<span  class="board_content cute_font" >
    <%=fBoardList.get(i).getFreeBoardTitle() %>
</span>


</div> 

<%} %>



                            
                            
                            
                            </div> 
                            
                            
                            
                            <div class="my-5" style="clear: both;">
           <ul class="pagination">
               <li>
                   <a class="page-link" href="#">&lt;</a>
               </li>
               <li>
                   <a class="page-link" href="#">1</a>
               </li>
               <li>
                   <a class="page-link" href="#">2</a>
               </li>
               <li>
                   <a class="page-link" href="#">3</a>
               </li>
               <li>
                   <a class="page-link" href="#">4</a>
               </li>
               <li>
                   <a class="page-link" href="#">5</a>
               </li>
               <li>
                   <a class="page-link" href="#">&gt;</a>
               </li>
           </ul>
       </div>

    </div>
    

  







    </body>
</html>