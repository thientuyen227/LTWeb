<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!-- Carousel Start -->
<div class="container-fluid mb-3">
	<div class="row px-xl-5">
		<div class="col-lg-8">
			<div id="header-carousel"
				class="carousel slide carousel-fade mb-30 mb-lg-0"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#header-carousel" data-slide-to="0" class="active"></li>
					<li data-target="#header-carousel" data-slide-to="1"></li>
					<li data-target="#header-carousel" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item position-relative active"
						style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="assets/img/carousel-1_OnePiece.jpg"
							style="object-fit: cover;">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<h1
									class="display-4 text-white mb-3 animate__animated animate__fadeInDown">One
									Piece</h1>
								<p class="mx-md-5 px-5 animate__animated animate__bounceIn">Hành
									trình của băng mũ rơm</p>
								<a
									class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
									href="#">Mua ngay</a>
							</div>
						</div>
					</div>
					<div class="carousel-item position-relative" style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="assets/img/carousel-2_DeathNote.jpg"
							style="object-fit: cover;">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<h1
									class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Death
									Note</h1>
								<p class="mx-md-5 px-5 animate__animated animate__bounceIn">Cuộc
									đấu trí của các thiên tài</p>
								<a
									class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
									href="#">Mua ngay</a>
							</div>
						</div>
					</div>
					<div class="carousel-item position-relative" style="height: 430px;">
						<img class="position-absolute w-100 h-100"
							src="assets/img/carousel-3_lol.jpg" style="object-fit: cover;">
						<div
							class="carousel-caption d-flex flex-column align-items-center justify-content-center">
							<div class="p-3" style="max-width: 700px;">
								<h1
									class="display-4 text-white mb-3 animate__animated animate__fadeInDown">League
									of Legends</h1>
								<p class="mx-md-5 px-5 animate__animated animate__bounceIn">Thách
									thức bản lĩnh</p>
								<a
									class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp"
									href="#">Mua ngay</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="product-offer mb-30" style="height: 200px;">
				<img class="img-fluid" src="assets/img/offer-2_Luffy.png" alt="">
				<div class="offer-text">
					<h6 class="text-white text-uppercase">Save 20%</h6>
					<h3 class="text-white mb-3">Special Offer</h3>
					<a href="" class="btn btn-primary">Shop Now</a>
				</div>
			</div>
			<div class="product-offer mb-30" style="height: 200px;">
				<img class="img-fluid" src="assets/img/offer-1_MewTwo.png" alt="">
				<div class="offer-text">
					<h6 class="text-white text-uppercase">Save 20%</h6>
					<h3 class="text-white mb-3">Special Offer</h3>
					<a href="" class="btn btn-primary">Shop Now</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Carousel End -->


<!-- Featured Start -->
<div class="container-fluid pt-5">
	<div class="row px-xl-5 pb-3">
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fa fa-check text-primary m-0 mr-3"></h1>
				<h5 class="font-weight-semi-bold m-0">Quality Product</h5>
			</div>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
				<h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
			</div>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
				<h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
			</div>
		</div>
		<div class="col-lg-3 col-md-6 col-sm-12 pb-1">
			<div class="d-flex align-items-center bg-light mb-4"
				style="padding: 30px;">
				<h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
				<h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
			</div>
		</div>
	</div>
</div>
<!-- Featured End -->


<!-- Categories Start -->
<div class="container-fluid pt-5">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Categories</span>
	</h2>

	<div class="row px-xl-5 pb-3">
		<c:forEach items="${categoryList}" var="category">
			<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
				<a class="text-decoration-none" href="<c:url value ="/home/categorydetail?id=${category.id}"/>">
					<div class="cat-item d-flex align-items-center mb-4">
						<div class="overflow-hidden" style="width: 100px; height: 100px;">
							<img class="img-fluid" src="assets/img/cat-1.jpg" alt="">
						</div>
						<div class="flex-fill pl-3">
							<h6>${category.categoryName}</h6>
							<small class="text-body">100 Products</small>
						</div>
					</div>
				</a>
			</div>
		</c:forEach>
	</div>
</div>
<!-- Categories End -->


<!-- Products Start -->
<div class="container-fluid pt-5 pb-3">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Featured Products</span>
	</h2>

	<div class="row px-xl-5">
		<c:forEach items="${productList }" var="product">
			<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
				<div class="product-item bg-light mb-4">
					<div class="product-img position-relative overflow-hidden">
						<img class="img-fluid w-100" src="assets/img/product-1.jpg" alt="">
						<div class="product-action">
							<a class="btn btn-outline-dark btn-square" href=""><i
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
						<div class="d-flex align-items-center justify-content-center mt-2">
							<h5>${product.promotionalPrice }</h5>
							<h6 class="text-muted ml-2">
								<del>${product.price }</del>
							</h6>
						</div>
						<div class="d-flex align-items-center justify-content-center mb-1">
							<small class="fa fa-star text-primary mr-1"></small> <small
								class="fa fa-star text-primary mr-1"></small> <small
								class="fa fa-star text-primary mr-1"></small> <small
								class="fa fa-star text-primary mr-1"></small> <small
								class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<!-- Products End -->


<!-- Offer Start -->
<div class="container-fluid pt-5 pb-3">
	<div class="row px-xl-5">
		<div class="col-md-6">
			<div class="product-offer mb-30" style="height: 300px;">
				<img class="img-fluid" src="assets/img/offer-1_Erza.jpg" alt="">
				<div class="offer-text">
					<h6 class="text-white text-uppercase">Save 20%</h6>
					<h3 class="text-white mb-3">Special Offer</h3>
					<a href="" class="btn btn-primary">Shop Now</a>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="product-offer mb-30" style="height: 300px;">
				<img class="img-fluid" src="assets/img/offer-2_Luffy.png" alt="">
				<div class="offer-text">
					<h6 class="text-white text-uppercase">Save 20%</h6>
					<h3 class="text-white mb-3">Special Offer</h3>
					<a href="" class="btn btn-primary">Shop Now</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Offer End -->


<!-- Products Start -->
<div class="container-fluid pt-5 pb-3">
	<h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4">
		<span class="bg-secondary pr-3">Recent Products</span>
	</h2>
	<div class="row px-xl-5">
		<c:forEach items="${newListProduct}" var="product">
			<div class="col-lg-3 col-md-4 col-sm-6 pb-1">
				<div class="product-item bg-light mb-4">
					<div class="product-img position-relative overflow-hidden">
						<img class="img-fluid w-100" src="assets/img/product-1.jpg" alt="">
						<div class="product-action">
							<a class="btn btn-outline-dark btn-square" href=""><i
								class="fa fa-shopping-cart"></i></a> <a
								class="btn btn-outline-dark btn-square" href=""><i
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
						<div class="d-flex align-items-center justify-content-center mt-2">
							<h5>$123.00</h5>
							<h6 class="text-muted ml-2">
								<del>$123.00</del>
							</h6>
						</div>
						<div class="d-flex align-items-center justify-content-center mb-1">
							<small class="fa fa-star text-primary mr-1"></small> <small
								class="fa fa-star text-primary mr-1"></small> <small
								class="fa fa-star text-primary mr-1"></small> <small
								class="fa fa-star text-primary mr-1"></small> <small
								class="fa fa-star text-primary mr-1"></small> <small>(99)</small>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
<!-- Products End -->

<a href="#" class="btn btn-primary back-to-top"><i
	class="fa fa-angle-double-up"></i></a>


<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="./../../assets/lib/easing/easing.min.js"></script>
<script src="./../../assets/lib/owlcarousel/owl.carousel.min.js"></script>

<!-- Contact Javascript File -->
<script src="./../../assets/mail/jqBootstrapValidation.min.js"></script>
<script src="./../../assets/mail/contact.js"></script>

<!-- Template Javascript -->
<script src="./../../assets/js/main.js"></script>