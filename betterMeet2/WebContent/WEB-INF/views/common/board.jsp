<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.btm.better.board.model.vo.FreeBoard"%>
<%@page import="java.util.List"%>
<%@page import="com.btm.better.member.model.vo.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>




<% List<FreeBoard> fBoardList = (List<FreeBoard>)request.getAttribute("fBoardList"); %>


<!-- 현재 표시할 수 있는 게시물의 개수를 측정하고, 10개 이상의 글이 조회됐을 경우 다음 페이지로 넘깁니다. 아닐경우 현재 페이지에 모두 표시합니다. -->
<%   
int boardNum = 0;

if (fBoardList.size()<10){
	boardNum = fBoardList.size();
}else{
	boardNum = 9;
}



int ListNum = fBoardList.size()/10;

int listMax = 10;

int viewList = 0;

int viewListCount = 0;


if(ListNum<listMax){
	viewList = ListNum;
}
else{
	viewList = listMax;
}



for(int i = 0; i<boardNum; i++) {%>



<div class="free_board_notice">    


<div class="free_board_no cute_font"> #<%=fBoardList.get(i).getFreeBoardNo() %> </div>    
<span class="tag_board cute_font"   >#<%=fBoardList.get(i).getFreeBoardTag() %></span>   
<span class="tag_board cute_font" >#<%=fBoardList.get(i).getFreeBoardTag() %></span>   
<span  class="tag_board cute_font" >#<%=fBoardList.get(i).getFreeBoardTag() %></span>      





<div class="board_Info">
<span class="post_infomation cute_font"> 조회수 
<span class="board_click_no"><%=fBoardList.get(i).getReadCount() %> </span>  </span>
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




		<button type="button" class="btn btn-outline cute_font" onclick="location.href='<%=request.getContextPath()%>/board/fBoardWrite.do' ">글쓰기</button>
	

		
		<script>
		
		
		
		
		
		
		
	
		
		
		</script>

	





    <span class="my-5" style="clear: both;">
           <ul class="pagination">
     
            <li>
                   <a class="page-link" href="#">&lt;&lt;</a>
               </li>
               
                <li>
                  &nbsp; &nbsp; &nbsp;
               </li>
           
               <li>
                   <a class="page-link" href="#">&lt;</a>
               </li>
               
             <%for (int i = 0; i<viewList; i++) {%>
               <li>
                   <a class="page-link" href="#" id="boardList"><%=viewListCount++%></a>
               </li>
               <%} %>
               
               
              
               <script>
               
               
               
               
               </script>
               
               
               
               
               
               
               
               
               
               
               
               <li>
                   <a class="page-link" href="#">&gt;</a>
               </li>
               
                  <li>
                  &nbsp; &nbsp; &nbsp;
               </li>
           
               
               <li>
                   <a class="page-link" href="#">&gt;&gt;</a>
               </li>
           </ul>
       </span>



</body>
</html>