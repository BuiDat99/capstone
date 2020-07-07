<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<c:url value="/view/admin/static" var="url"></c:url>
    <!DOCTYPE html>
    <html>
        <head>
            <script src="../static/ckeditor/ckeditor.js" type="text/javascript"></script>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1.0" />
            <title>Thêm bài viết mới</title>
            <!-- BOOTSTRAP STYLES-->
            <link href="../static/css/bootstrap.css" rel="stylesheet" />
            <!-- FONTAWESOME STYLES-->
            <link href="../static/css/font-awesome.css" rel="stylesheet" />
            <!-- MORRIS CHART STYLES-->

            <!-- CUSTOM STYLES-->
            <link href="../static/css/custom.css" rel="stylesheet" />
            <!-- GOOGLE FONTS-->
            <link href='http://fonts.googleapis.com/css?family=Open+Sans'
                  rel='stylesheet' type='text/css' />
            <!-- TABLE STYLES-->
            <link href="../static/js/dataTables/dataTables.bootstrap.css"
                  rel="stylesheet" />
        </head>
        <body>
            <div id="wrapper">
            <jsp:include page="../view/nav-bar.jsp"></jsp:include>

                <!-- /. NAV TOP  -->
            <jsp:include page="../view/slide-bar.jsp"></jsp:include>
                <!-- /. NAV SIDE  -->
                <div id="page-wrapper">
                    <div id="page-inner">
                        <div class="row">
                            <div class="col-md-12">
                                <h2>Thêm bài viết mới</h2>

                            </div>
                        </div>
                        <!-- /. ROW  -->
                        <hr />
                        <div class="row">
                            <div class="col-md-12">
                                <!-- Form Elements -->
                                <div class="panel panel-default">
                                    <div class="panel-heading">Thêm bài viết mới</div>
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <h3>Thông tin bài viết:</h3>

                                                <form role="form" action="add" method="post"
                                                      enctype="multipart/form-data">
                                                    <div class="form-group">
                                                        <label>Loaị bài viết:</label> 
                                                        <div class="checkbox">
                                                            <select name="category-news">

                                                            </select>
                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        <label>Tiêu đề bài viết</label> <input class="form-control"
                                                                                               placeholder="Tiêu đề bài viết" name="title" />
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Thẻ tag</label> 
                                                        <div class="checkbox">
                                                            <select name="category-tag">

                                                            </select>
                                                        </div>

                                                    </div>
                                                    <div class="form-group">
                                                        <label>Tác giả</label> <input class="form-control"
                                                                                      placeholder="tên tác giả" name="author-name" />
                                                    </div>
                                                    <div class="form-group">
                                                        <label>Người đăng bài</label> <input class="form-control"
                                                                                             placeholder="tên người đăng" name="poster-news" />
                                                    </div>

                                                    <div class="form-group">
                                                        <label>Nội dung </label>
                                                        <br>
                                                        <textarea class="ckeditor" rows="4" cols="50" name="des" id="editer"></textarea>

                                                    </div>
                                                    <div class="form-group">
                                                        <label>Trạng thái </label>
                                                        <br>
                                                        <input type="radio" id="active" name="status" value="active"><a>Hoạt động</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                                                        <input type="radio" id="deactive" name="status" value="deactive"><a>Không hoạt động</a>
                                                    </div>

                                                    <button type="submit" class="btn btn-default">Thêm bài viết</button>
                                                    <button type="reset" class="btn btn-primary">Làm mới</button>
                                                </form>


                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- End Form Elements -->
                            </div>
                        </div>
                        <!-- /. ROW  -->
                        <div class="row">
                            <div class="col-md-12"></div>
                        </div>
                        <!-- /. ROW  -->
                    </div>
                    <!-- /. PAGE INNER  -->
                </div>
                <!-- /. PAGE WRAPPER  -->
            </div>
            <!-- /. WRAPPER  -->
            <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
            <!-- JQUERY SCRIPTS -->
        <script src="../static/js/jquery-1.10.2.js"></script>
        <!-- BOOTSTRAP SCRIPTS -->
        <script src="../static/js/bootstrap.min.js"></script>
        <!-- METISMENU SCRIPTS -->
        <script src="../static/js/jquery.metisMenu.js"></script>
        <!-- DATA TABLE SCRIPTS -->
        <script src="../static/js/dataTables/jquery.dataTables.js"></script>
        <script src="../static/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
        </script>
        <!-- CUSTOM SCRIPTS -->
    </body>
</html>