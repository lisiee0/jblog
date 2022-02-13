<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JBlog</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jblog.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery/jquery-1.12.4.js"></script>
</head>

<body>
	<div id="wrap">
		
		<!-- 개인블로그 해더 -->
		<c:import url="/WEB-INF/views/includes/blog-header.jsp"></c:import>


		<div id="content">
			<ul id="admin-menu" class="clearfix">
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${blogInfo.BlogVo.blogId}/admin/basic">기본설정</a></li>
				<li class="tabbtn selected"><a href="${pageContext.request.contextPath}/${blogInfo.BlogVo.blogId}/admin/category">카테고리</a></li>
				<li class="tabbtn"><a href="${pageContext.request.contextPath}/${blogInfo.BlogVo.blogId}/admin/writeForm">글작성</a></li>
			</ul>
			<!-- //admin-menu -->
			
			<div id="admin-content">
			
				<table id="admin-cate-list">
					<colgroup>
						<col style="width: 50px;">
						<col style="width: 200px;">
						<col style="width: 100px;">
						<col>
						<col style="width: 50px;">
					</colgroup>
		      		<thead>
			      		<tr>
			      			<th>번호</th>
			      			<th>카테고리명</th>
			      			<th>포스트 수</th>
			      			<th>설명</th>
			      			<th>삭제</th>      			
			      		</tr>
		      		</thead>
		      		
		      		<tbody id="cateList" value="${blogInfo.BlogVo.blogId}">
		      			<!-- 리스트 영역 -->

						<!-- 리스트 영역 -->
					</tbody>
				</table>
      	
		      	<table id="admin-cate-add" >
		      		<colgroup>
						<col style="width: 100px;">
						<col style="">
					</colgroup>
		      		<tr>
		      			<td class="t">카테고리명</td>
		      			<td><input id="cateName" type="text" name="name" value=""></td>
		      		</tr>
		      		<tr>
		      			<td class="t">설명</td>
		      			<td><input id="description" type="text" name="desc" value=""></td>
		      		</tr>
		      	</table> 
			
				<div id="btnArea">
					<input id="id" type="hidden" name="id" value="${blogInfo.BlogVo.blogId}">
		      		<button id="btnAddCate" class="btn_l" type="submit" >카테고리추가</button>
		      	</div>
			
			</div>
			<!-- //admin-content -->
		</div>	
		<!-- //content -->
		
		
		<!-- 개인블로그 푸터 -->
		<c:import url="/WEB-INF/views/includes/blog-footer.jsp"></c:import>
	
	
	</div>
	<!-- //wrap -->
</body>

<script>
	
	// 로딩되기 전에 요청
	$(document).ready(function() {
		var id= $("#cateList").val();
		showList(id);
	});
		
	
	// (이벤트) '카테고리추가' 버튼 눌렀을때
	$("#btnAddCate").on("click", function() {
		console.log("add button click");

		// 데이터 수집
		var cateName= $("#cateName").val();
		var description= $("#description").val();
		var id= $("#id").val();

		// 객체 만들기
		var CategoryVo= {
			cateName : cateName,
			description : description,
			id : id
		};
		
		add(CategoryVo);
	});
	
	
	// (이벤트) '삭제' 버튼눌렀을때
	$("#cateList").on("click", ".btnCateDel", function() {
		var cateNo= $(this).data("no");
		remove(cateNo);
	});
	
	
		
	// (기능) 카테고리 추가
	function add(CategoryVo) {
		
		$.ajax({

			url : "${pageContext.request.contextPath}/${blogInfo.BlogVo.blogId}/admin/category/add",
			type : "post",
			// contentType : "application/json",
			data : CategoryVo,

			dataType : "json",
			success : function(vo) {
				/*성공시 처리해야될 코드 작성*/
				render(vo, "up");

				// 입력 데이터 초기화
				$("#cateName").val("");
				$("#description").val("");
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});	
	};
		
	
	// (기능) 카테고리 삭제
	function remove(cateNo) {
		
		$.ajax({

			url : "${pageContext.request.contextPath}/${blogInfo.BlogVo.blogId}/admin/category/delete",
			type : "post",
			// contentType : "application/json",
			data : {cateNo: cateNo},

			dataType : "json",
			success : function(state) {
				/*성공시 처리해야될 코드 작성*/
				if(state=="success") {
					$("#t"+cateNo).remove();
				}
				else {

				}
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});	
	};
	
	
	// (기능) 카테고리 리스트 출력
	function showList(id) {
		
		$.ajax({
	
			url : "${pageContext.request.contextPath}/${blogInfo.BlogVo.blogId}/admin/category/list",
			type : "post",
			// contentType : "application/json",
			data : {id: id},
	
			dataType : "json",
			success : function(cList) {
				/*성공시 처리해야될 코드 작성*/
				console.log(cList);
	
				for (var i = 0; i < cList.length; i++) {
					render(cList[i], "down");
				}
	
			},
			error : function(XHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	};
	
	
	// (기능) 리스트 그리기
	function render(vo, updown) {
	
		var str = '';
		str += ' <tr id="t'+vo.cateNo+'"> ';
		str += ' 	<td>'+vo.cateNo+'</td> ';
		str += ' 	<td>'+vo.cateName+'</td> ';
		str += ' 	<td>7</td> ';
		str += ' 	<td>'+vo.description+'</td> ';
		str += ' 	<td class="text-center"> ';
		str += '  		<img class="btnCateDel" data-no="'+vo.cateNo+'" src="${pageContext.request.contextPath}/assets/images/delete.jpg"> ';
		str += ' 	</td> ';
		str += ' </tr> ';

		if (updown == 'down') {
			$("#cateList").append(str);
		} 
		else if (updown == 'up') {
			$("#cateList").prepend(str);
		} 
		else {
			console.log("updown error");
		}
	};




</script>



</html>