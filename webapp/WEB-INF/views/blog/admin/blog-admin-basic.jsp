<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">


</head>

<body>
	<div id="wrap">
		
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>

		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${blogInfo.BlogVo.blogId}/admin/basic">기본설정</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${blogInfo.BlogVo.blogId}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${blogInfo.BlogVo.blogId}/admin/writeForm">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
				<form action="${pageContext.request.contextPath}/${blogInfo.BlogVo.blogId}/admin/basic/changeSet" method="post" enctype="multipart/form-data">
	 		      	<table id="admin-basic">
	 		      		<colgroup>
							<col style="width: 100px;">
							<col style="">
						</colgroup>
			      		<tr>
			      			<td><label for="textTitle">블로그 제목</label></td>
			      			<td><input id="textTitle" type="text" name="blogTitle" value=""></td>
			      		</tr>
			      		<tr>
			      			<td><label>로고이미지</label></td>
			      			<c:choose>
				      			<c:when test="${!empty blogInfo.logoFile}">
				      				<td class="text-left"><img src="${pageContext.request.contextPath}/assets/images/spring-logo.jpg"></td>
				      			</c:when>
				      			<c:otherwise>
				      				<td class="text-left"><img src="${pageContext.request.contextPath}/upload/${blogInfo.BlogVo.logoFile}"></td>
				      			</c:otherwise>
			      			</c:choose>

			      		</tr>      		
			      		<tr>
			      			<td>&nbsp;</td>
			      			<td><input id="textLogo" type="file" name="file"></td>      			
			      		</tr>           		
			      	</table>
			      	<div id="btnArea">
			      		<button class="btn_l" type="submit" >기본설정변경</button>
			      	</div>
			      	<input type="hidden" name="blogId" value="${blogInfo.BlogVo.blogId}">
			      	<input type="hidden" name="userName" value="${blogInfo.BlogVo.userName}">
				</form>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		
		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	
	</div>
	<!-- //wrap -->
</body>
</html>
