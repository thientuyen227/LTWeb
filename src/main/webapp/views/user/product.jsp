<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>


<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="#">Home</a> <a
					class="breadcrumb-item text-dark" href="#">Shop</a> <span
					class="breadcrumb-item active">Figure</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->

<form action="<c:url value="/home/product"/>" method="post"
	onchange="this.form.submit()">
	<!-- Shop Start -->
	<div class="container-fluid">
		<div class="row px-xl-5">
			<!-- Shop Sidebar Start -->
			<div class="col-lg-3 col-md-4">
				<!-- Price Start -->
					<h5 class="section-title position-relative text-uppercase mb-3">
						<span class="bg-secondary pr-3">Filter by price</span>
					</h5>
					<div class="bg-light p-4 mb-30">
						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
							<input name="filterByPrice" value="0-50000" type="submit"
								class="custom-control-input" id="price-1" > <label
								class="custom-control-label" for="price-1" onchange="this.form.submit()">0k - 50K</label>
						</div>
						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
							<input name="filterByPrice" value="50000-100000" type="submit"
								class="custom-control-input" id="price-2"> <label
								class="custom-control-label" for="price-2" onchange="this.form.submit()">50K - 100K</label>
						</div>
						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
							<input name="filterByPrice" value="100000-150000" type="submit"
								class="custom-control-input" id="price-3"> <label
								class="custom-control-label" for="price-3" onchange="this.form.submit()">100K - 150K</label>
						</div>
						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
							<input name="filterByPrice" value="150000-200000" type="submit"
								class="custom-control-input" id="price-4"> <label
								class="custom-control-label" for="price-4" onchange="this.form.submit()">150K - 200K</label>
						</div>
						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
							<input name="filterByPrice" value="200000-300000" type="submit"
								class="custom-control-input" id="price-5"> <label
								class="custom-control-label" for="price-5" onchange="this.form.submit()">200K - 300K</label>
						</div>
					</div>
					<!-- Price End -->


					<!-- Rating Start -->
					<h5 class="section-title position-relative text-uppercase mb-3">
						<span class="bg-secondary pr-3">Filter by rating</span>
					</h5>
					<div class="bg-light p-4 mb-30">
						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
							<input name="filterByRating" value="5" type="submit"
								class="custom-control-input" id="color-1"> <label
								class="custom-control-label" for="color-1" onchange="this.form.submit()">5 star</label>
						</div>
						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
							<input name="filterByRating" value="4" type="submit"
								class="custom-control-input" id="color-2"> <label
								class="custom-control-label" for="color-2" onchange="this.form.submit()">4 star</label>
						</div>
						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
							<input name="filterByRating" value="3" type="submit"
								class="custom-control-input" id="color-3"> <label
								class="custom-control-label" for="color-3" onchange="this.form.submit()">3 star</label>
						</div>
						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between mb-3">
							<input name="filterByRating" value="2" type="submit"
								class="custom-control-input" id="color-4"> <label
								class="custom-control-label" for="color-4" onchange="this.form.submit()">2 star</label>
						</div>
						<div
							class="custom-control custom-checkbox d-flex align-items-center justify-content-between">
							<input name="filterByRating" value="1" type="submit"
								class="custom-control-input" id="color-5"> <label
								class="custom-control-label" for="color-5" onchange="this.form.submit()">1 star</label>
						</div>

					</div>
					<!-- Rating End -->
			</div>
			<!-- Shop Sidebar End -->


			<!-- Shop Product Start -->
			<div class="col-lg-9 col-md-8">
				<div class="row pb-3">
					<div class="col-12 pb-1">
						<div
							class="d-flex align-items-center justify-content-between mb-4">
							<div>
								<button class="btn btn-sm btn-light">
									<i class="fa fa-th-large"></i>
								</button>
								<button class="btn btn-sm btn-light ml-2">
									<i class="fa fa-bars"></i>
								</button>
							</div>
							<div class="ml-2">
								<div class="btn-group ml-2">
									<button type="button"
										class="btn btn-sm btn-light dropdown-toggle"
										data-toggle="dropdown">Showing</button>

									<div class="dropdown-menu dropdown-menu-right">
										<select name="productShowing"  onchange="this.form.submit()"
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
										<a class="btn btn-outline-dark btn-square" href="<c:url value ="/home/cart/add?id=${product.id}"/>"><i
											class="fa fa-shopping-cart"></i></a> <a
											class="btn btn-outline-dark btn-square" href="<c:url value ="/home/followingproduct/add?id=${product.id}"/>"><i
											class="far fa-heart"></i></a> <a
											class="btn btn-outline-dark btn-square" href=""><i
											class="fa fa-sync-alt"></i></a> <a
											class="btn btn-outline-dark btn-square"
											href="<c:url value ="/home/productdetail?id=${product.id}"/>"><i
											class="fa fa-search"></i></a>
									</div>
								</div>
								<div class="text-center py-4">
									<a class="h6 text-decoration-none text-truncate" href="">${product.name }</a>
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
										<small>(99)</small>
									</div>
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

