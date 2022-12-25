<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="<c:url value ="/admin"/>">Admin</a><span
					class="breadcrumb-item active">Figure</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->

<form action="<c:url value="/admin/product"/>" method="post"
	onchange="this.form.submit()">
	<!-- Shop Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<!-- Shop Sidebar Start -->
			<div class="col-lg-3 col-md-4">
				<!-- Price Start -->
				<h5 class="section-title position-relative text-uppercase mb-3">
					<span class="bg-secondary pr-3">All product</span>
				</h5>

				<!-- Price End -->
				<!-- Rating End -->
			</div>
			<!-- Shop Sidebar End -->


			<!-- Shop Product Start -->
			<div class="col-lg-9 col-md-8">
				<div class="row pb-3">
					<div class="col-12 pb-1">
						<div class="d-flex align-items-center justify-content-between mb-4">
							<div class="ml-2">
								<div class="btn-group ml-2">
								<a href="#" ><button>Add product</button></a>	
								</div>
							</div>
							<div class="ml-2">
								<div class="btn-group ml-2">
									<button type="button"
										class="btn btn-sm btn-light dropdown-toggle"
										data-toggle="dropdown">Showing</button>

									<div class="dropdown-menu dropdown-menu-right">
										<select name="productShowing" onchange="this.form.submit()"
											multiple="multiple">
											<option value="3">10</option>
											<option value="6">20</option>
											<option value="9">30</option>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>

					<c:forEach items="${productList}" var="product">
						<div class="col-lg-4 col-md-6 col-sm-6 pb-1">
							<div class="product-item bg-light mb-4">
								<div class="product-img position-relative overflow-hidden">
									<img class="img-fluid w-100" src="assets/img/product-1.jpg"
										alt="">
									<div class="product-action">
										<a class="btn btn-outline-dark btn-square"
											href="<c:url value ="/admin/product/isactive?id=${product.id}"/>"><i
											class="fa fa fa-plus-circle"></i></a> <a
											class="btn btn-outline-dark btn-square"
											href="<c:url value ="/admin/product/unisactive?id=${product.id}"/>"><i
											class="fa fa-minus-circle"></i></a> <a
											class="btn btn-outline-dark btn-square"
											href="<c:url value ="/admin/productdetail?id=${product.id}"/>"><i
											class="fa fa-search"></i></a>
									</div>
								</div>
								<div class="text-center py-4">
									<a class="h6 text-decoration-none text-truncate" href="<c:url value ="/admin/productdetail?id=${product.id}"/>">${product.name }</a>
									<div
										class="d-flex align-items-center justify-content-center mt-2">
										<h5>${product.promotionalPrice }</h5>
										<h6 class="text-muted ml-2">
											<del>${product.price }</del>
										</h6>
									</div>
									<div
										class="d-flex align-items-center justify-content-center mb-1">
										<div>${product.rating }
											<small class="fa fa-star text-primary mr-1"></small>
										</div>

									</div>
									<small>IsActive: ${product.active }</small>
								</div>
							</div>
						</div>
					</c:forEach>
					<div class="col-12">
						<nav>
							<ul class="pagination justify-content-center">
								<li class="page-item disabled"><a class="page-link"
									href="#">Previous</span></a></li>
								<li class="page-item active"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item"><a class="page-link" href="#">Next</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
			<!-- Shop Product End -->
		</div>
	</div>
</form>
<!-- Shop End -->
<a href="#" class="btn btn-primary back-to-top"><i
	class="fa fa-angle-double-up"></i></a>

