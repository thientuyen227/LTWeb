<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@include file="/common/taglib.jsp" %>

<div class="container-fluid">
        <div class="row px-xl-5">
            <div class="col-12">
                <nav class="breadcrumb bg-light mb-30">
                    <a class="breadcrumb-item text-dark" href="#">Home</a>
                    <a class="breadcrumb-item text-dark" href="#">Shop</a>
                    <span class="breadcrumb-item active">Sign In</span>
                </nav>
            </div>
        </div>
    </div>	
	
<div class="pagination justify-content-center">
	<h5 class="text-secondary text-uppercase  mb-4">SIGN IN</h5>
	<form action="" method="post">
		<div class="input-group">
			<input name="username" type="text" class="form-control"
				placeholder="Your Email Address">
		</div>
		<p></p>
		<div class="input-group">
			<input name="password" type="text" class="form-control" placeholder="Your Password">
			<div class="input-group-append">
				<button class="btn btn-primary">Sign In</button>
			</div>
		</div>
	</form>
	</div>