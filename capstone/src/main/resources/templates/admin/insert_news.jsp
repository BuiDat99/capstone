<%-- 
   <%@page import="model.UserAdmin"%>
<%@page import="get.BrandGet"%>
<%@page import="model.Brand"%>
<%@page import="java.util.ArrayList"%>
<%@page import="get.CategoryGet"%>
<%@page import="model.Category"%>
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm bài viết</title>

        <%-- <c:set var="root" value="${pageContext.request.contextPath}"/>--%>

        <link href="css/mos-style.css" rel='stylesheet' type='text/css' />

    </head>
    <body>
        <%--
        <% 
                CategoryGet categoryget = new CategoryGet();
                BrandGet brandget = new BrandGet();
       
                    String error = "";
                    if(request.getParameter("error")!=null){
                        error = (String) request.getParameter("error");
                    }        
        %>
        --%>
        <jsp:include page="header.jsp"></jsp:include>

            <div id="wrapper">

            <jsp:include page="menu.jsp"></jsp:include>

                <div id="rightContent">
                    <h3>BÀI VIẾT MỚI</h3>

                    <div class="informasi">
                        Hãy chỉnh sửa dữ liệu cẩn thận nhé ^^
                    </div>
                    <form method="post" action="/MusicShop/InsertProductServletx" enctype="multipart/form-data">

                        <table width="95%"> <tr>

                            </tr>
                            <tr><td width="125px"><b></b></td><td><input type="hidden" class="sedang" name="maSanPham"><%--<%=error%>--%></td></tr> 

                        <tr><td><b>Loại bài viết</b></td><td>
                                <div>
                                    <span></span>
                                    <select name="maloai">
                                        <%--       <%
                                       for (Category c : categoryget.getListCategory()) {
                                        %>
                                        <option value="<%=c.getCategoryID()%>"><%=c.getCategoryName()%></option>
                                        <% } %>
                                        --%>

                                    </select>
                                </div>
                                        <input type="hidden" class="sedang" name=""><%--<%=error%>--%></td></tr>
                        <tr><td width="125px"><b>Tiêu đề bài viết</b></td><td><input type="text" class="sedang" name="tenSanPham"><%--error%>--%></td></tr>
                        <tr><td><b>Thẻ tag</b></td><td>
                                <div>
                                    <span></span>
                                    <select name="maTag">
                                        <%--<%
                                            for (Brand b : brandget.getListBrand()) {
                                        %>
                                        <option value="<%=b.getBrandID()%>"><%=b.getBrandName()%></option>
                                        <% }%>
                                        --%>
                                    </select>
                                </div>
                                        <input type="hidden" class="sedang" name=""><%--error%>--%></td></tr>
                        <tr><td width="125px"><b>Tác giả</b></td><td><input type="text" class="sedang" name="tacgia"><%--error%>--%></td></tr>
                        <tr><td><b>Hình bài viết</b></td><td><input type="file" placeholder="images/tênhình.jpg" class="sedang" name="daidien"><%--error%>--%></td><</tr>
                     

                        <tr><td><b>Nội dung</b></td><td><textarea type="text"  placeholder="" name="mota"><%--error%>--%></textarea></td></tr>
                        <tr><td></td><td>

                                <input type="submit" class="button" value="Thêm bài viết">
                                <input type="reset" class="button" value="Phục hồi">

                            </td></tr>
                    </table>
                </form>
                        <%--
                <form method="post" action="/MusicShop/UploadProductServlet" enctype="multipart/form-data">
                    <table width="95%">
                        <tr><td><b>Upload hình ảnh sản phẩm</b></td><td><input type="file" class="panjang" name="uploadFile"></td><br>
                        <td><input type="file" class="panjang" name="uploadFile"></td><td><input type="file" class="panjang" name="uploadFile"></td></tr>
                        <br/>
                        <tr><td></td><td>
                                <input type="submit" class="button" value="Tải lên" />
                            </td></tr>
                    </table>
                </form>
                        --%>
            </div>
            <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>

        </div>


    </body>
</html>
