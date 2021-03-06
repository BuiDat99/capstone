<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url value="/view/admin/static" var="url"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý người dùng</title>
<!-- BOOTSTRAP STYLES-->
<link href="../static/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="../static/css/font-awesome.css" rel="stylesheet" />
<!-- MORRIS CHART STYLES-->

<!-- CUSTOM STYLES-->
<link href="../static/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->

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
						<h2>Tất cả người dùng</h2>
					</div>
				</div>
				<!-- /. ROW  -->
				<hr />

				<div class="row">
					<div class="col-md-12">
						<!-- Advanced Tables -->
						<div class="panel panel-default">
							<div class="panel-heading">Bảng chi tiết</div>
							<div class="panel-body">
								<div class="table-responsive">


									<table class="table table-striped table-bordered table-hover"
										id="dataTables-example">
										<thead>

											<!--                                            <div class="row btn">
                                                <form action="">
                                                    <button type="submit">Thêm người dùng mới</button>

                                                </form>      
                                            </div>-->
											<tr>
												<th>STT</th>
												<th>Tên tài khoản</th>
												<th>Mật khẩu</th>
												<th>Địa chỉ</th>
												<th>Email</th>
												<th>Số điện thoại</th>
												<th>Trạng thái</th>
												<th>Tuỳ chỉnh</th>
											</tr>
										</thead>
										<tbody>
											<tr class="odd gradeX">
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td><a href="edit-user.jsp">Sửa</a></td>
											</tr>
										</tbody>

									</table>
								</div>

							</div>
						</div>
						<!--End Advanced Tables -->
					</div>
				</div>

			</div>

		</div>
		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->
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


</body>
</html>