

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm bài viết</title>
        <link href="css/mos-style.css" rel='stylesheet' type='text/css' />
        <script src="ckeditor/ckeditor.js" type="text/javascript"></script>
    </head>
    <body>

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
                                    </select>
                                </div>
                                <input type="hidden" class="sedang" name=""><%--<%=error%>--%></td></tr>
                        <tr><td width="125px"><b>Tiêu đề bài viết</b></td><td><input type="text" class="sedang" name="tenSanPham"><%--error%>--%></td></tr>
                        <tr><td><b>Thẻ tag</b></td><td>
                                <div>
                                    <span></span>
                                    <select name="maTag">

                                    </select>
                                </div>
                                <input type="hidden" class="sedang" name=""><%--error%>--%></td></tr>
                        <tr><td width="125px"><b>Tác giả</b></td><td><input type="text" class="sedang" name="tacgia"><%--error%>--%></td></tr>
                        <tr><td><b>Hình bài viết</b></td><td><input type="file" placeholder="images/tênhình.jpg" class="sedang" name="daidien"><%--error%>--%></td><</tr>

 
                        <tr><td><b>Nội dung</b></td><td><textarea class="ckeditor" name="editor1" ><%--error%>--%></textarea></td></tr>
                        <tr><td></td><td>
                                <input type="submit" class="button" value="Thêm bài viết">
                                <input type="reset" class="button" value="Phục hồi">
                            </td></tr>
                    </table>
                </form>
            </div>
            <div class="clear"></div>

            <jsp:include page="footer.jsp"></jsp:include>
        </div> <!--end wapper-->
        
    </body>
</html>
