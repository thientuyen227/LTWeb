<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!-- Breadcrumb Start -->
<div class="container-fluid">
	<div class="row px-xl-5">
		<div class="col-12">
			<nav class="breadcrumb bg-light mb-30">
				<a class="breadcrumb-item text-dark" href="<c:url value ="/admin"/>">Admin</a> <a
					class="breadcrumb-item text-dark" href="<c:url value ="/admin/store"/>">Store</a> <span
					class="breadcrumb-item active">Store Detail</span>
			</nav>
		</div>
	</div>
</div>
<!-- Breadcrumb End -->


<!-- Shop Detail Start -->
<div class="container-fluid pb-5">
	<div class="row px-xl-5">
		<div class="col-lg-5 mb-30">
			<div id="product-carousel" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner bg-light">
					<div class="carousel-item active">
						<img class="w-100 h-100" src="assets/img/product-1.jpg"
							alt="Image">
					</div>
					<div class="carousel-item">
						<img class="w-100 h-100" src="assets/img/product-2.jpg"
							alt="Image">
					</div>
					<div class="carousel-item">
						<img class="w-100 h-100" src="assets/img/product-3.jpg"
							alt="Image">
					</div>
					<div class="carousel-item">
						<img class="w-100 h-100" src="assets/img/product-4.jpg"
							alt="Image">
					</div>
				</div>
				<a class="carousel-control-prev" href="#product-carousel"
					data-slide="prev"> <i class="fa fa-2x fa-angle-left text-dark"></i>
				</a> <a class="carousel-control-next" href="#product-carousel"
					data-slide="next"> <i class="fa fa-2x fa-angle-right text-dark"></i>
				</a>
			</div>
		</div>

		<div class="col-lg-7 h-auto mb-30">
			<div class="h-100 bg-light p-30">
				<h3>${store.name}</h3>
				<div class="d-flex mb-3">
					<div class="text-primary mr-2">
						<small class="fas fa-star"></small> <small class="fas fa-star"></small>
						<small class="fas fa-star"></small> <small
							class="fas fa-star-half-alt"></small> <small class="far fa-star"></small>
					</div>
					<small class="pt-1">${store.rating }</small>
					
				</div>
				<p class="mb-4">${store.bio}</p>
				<p class="mb-4">Owner Id: ${store.ownerID}</p>
				<div class="d-flex pt-2">
					<strong class="text-dark mr-2">Share on:</strong>
					<div class="d-inline-flex">
						<a class="text-dark px-2" href=""> <i
							class="fab fa-facebook-f"></i>
						</a> <a class="text-dark px-2" href=""> <i class="fab fa-twitter"></i>
						</a> <a class="text-dark px-2" href=""> <i
							class="fab fa-linkedin-in"></i>
						</a> <a class="text-dark px-2" href=""> <i
							class="fab fa-pinterest"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row px-xl-5">
		<div class="col">
			<div class="bg-light p-30">
				<div class="nav nav-tabs mb-4">
					<a class="nav-item nav-link text-dark active" data-toggle="tab"
						href="#tab-pane-1">Description</a> <a
						class="nav-item nav-link text-dark" data-toggle="tab"
						href="#tab-pane-2">Information</a>
				</div>
				<div class="tab-content">
					<div class="tab-pane fade show active" id="tab-pane-1">
						<h4 class="mb-3">Store bio</h4>
						<p>${store.bio}</p>
					</div>
					<div class="tab-pane fade" id="tab-pane-2">
						<h4 class="mb-3">Additional Information</h4>
						<p>Eos no lorem eirmod diam diam, eos elitr et gubergren diam
							sea. Consetetur vero aliquyam invidunt duo dolores et duo sit.
							Vero diam ea vero et dolore rebum, dolor rebum eirmod consetetur
							invidunt sed sed et, lorem duo et eos elitr, sadipscing kasd
							ipsum rebum diam. Dolore diam stet rebum sed tempor kasd eirmod.
							Takimata kasd ipsum accusam sadipscing, eos dolores sit no ut
							diam consetetur duo justo est, sit sanctus diam tempor aliquyam
							eirmod nonumy rebum dolor accusam, ipsum kasd eos consetetur at
							sit rebum, diam kasd invidunt tempor lorem, ipsum lorem elitr
							sanctus eirmod takimata dolor ea invidunt.</p>
						<div class="row">
							<div class="col-md-6">
								<ul class="list-group list-group-flush">
									<li class="list-group-item px-0">Sit erat duo lorem duo ea
										consetetur, et eirmod takimata.</li>
									<li class="list-group-item px-0">Amet kasd gubergren sit
										sanctus et lorem eos sadipscing at.</li>
									<li class="list-group-item px-0">Duo amet accusam eirmod
										nonumy stet et et stet eirmod.</li>
									<li class="list-group-item px-0">Takimata ea clita labore
										amet ipsum erat justo voluptua. Nonumy.</li>
								</ul>
							</div>
							<div class="col-md-6">
								<ul class="list-group list-group-flush">
									<li class="list-group-item px-0">Sit erat duo lorem duo ea
										consetetur, et eirmod takimata.</li>
									<li class="list-group-item px-0">Amet kasd gubergren sit
										sanctus et lorem eos sadipscing at.</li>
									<li class="list-group-item px-0">Duo amet accusam eirmod
										nonumy stet et et stet eirmod.</li>
									<li class="list-group-item px-0">Takimata ea clita labore
										amet ipsum erat justo voluptua. Nonumy.</li>
								</ul>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Shop Detail End -->

	<a href="#" class="btn btn-primary back-to-top"><i
		class="fa fa-angle-double-up"></i></a>


	<!-- JavaScript Libraries -->
	<script href="<c:url value ="/https://code.jquery.com/jquery-3.4.1.min.js"/>"></script>
	<script
		href="<c:url value ="/https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"/>"></script>
	<script href="<c:url value ="/assets/lib/easing/easing.min.js"/>"></script>
	<script href="<c:url value ="/assets/lib/owlcarousel/owl.carousel.min.js"/>"></script>

	<!-- Contact Javascript File -->
	<script href="<c:url value ="/assets/mail/jqBootstrapValidation.min.js"/>"></script>
	<script href="<c:url value ="/assets/mail/contact.js"/>"></script>

	<!-- Template Javascript -->
	<script href="<c:url value ="/assets/js/main.js"/>"></script>