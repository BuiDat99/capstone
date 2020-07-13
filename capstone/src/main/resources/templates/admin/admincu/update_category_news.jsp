<%-- 
 <%@page import="model.Category"%>
<%@page import="get.CategoryGet"%>
<%@page import="get.ProductGet"%>
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cập nhật loại bài viết</title>

<%--<c:set var="root" value="${pageContext.request.contextPath}"/>--%>
<link href="css/mos-style.css" rel='stylesheet' type='text/css' />

</head>
<body>

	<%--
            String error = "";
            if(request.getParameter("error")!=null){
                error = (String) request.getParameter("error");
            }
            Category category = new CategoryGet().getCategory(Long.parseLong(request.getParameter("category_id")));
           
            CategoryGet categoryGet = new CategoryGet();
            
        --%>

	<jsp:include page="header.jsp"></jsp:include>

	<div id="wrapper">

		<jsp:include page="menu.jsp"></jsp:include>

		<div id="rightContent">
			<h3>Cập nhật loại bài viết</h3>
			<form action="/MusicShop/ManagerCategoryServlet" method="post">
				<table width="95%">
					<tr>
						<td style="float: right"><b>Tên loại bài viết</b></td>
						<td><input type="text" class="sedang" name="tenDanhMuc"
							value=""></td>
					</tr>
					<tr>
						<td style="float: right"><b>Mã loại bài viết</b></td>
						<td><input type="text" class="sedang" name="maDanhMuc"
							value=""></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="hidden" name="command" value="update">
							<input type="hidden" name="category_id" value=""> <input
							type="submit" class="button" value="Lưu dữ liệu"></td>
					</tr>
				</table>
			</form>
		</div>
		<div class="clear"></div>

		<jsp:include page="footer.jsp"></jsp:include>

	</div>


</body>
</html>