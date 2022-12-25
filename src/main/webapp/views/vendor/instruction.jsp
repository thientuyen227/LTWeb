<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="container-fluid">
	<h5>Bạn chưa có cửa hàng. Làm theo hướng dẫn để tạo cửa hàng.</h5>
	<div class="iq-card-body row">
		<div class="col-12">
			<h5>Bước 1:</h5>
			<div class="mt-3">
				<ol>
					<li>Ấn nút "Add store" để tiến hành tạo cửa hàng</li>
					<li>Số dư trong Ví của cửa hàng của bạn khi giao dịch tiền bán
						hàng sẽ được chuyển vào đây</li>
					<li>Đây là số dư Ví của bạn, bạn có thể rút tiền từ ví của
						Store về Ví của mình</li>
				</ol>
			</div>
		</div>
		<div class="col-12">
			<h5>Bước 2:</h5>
			<div class="mt-3">
				<p>Bạn chọn ảnh cho cửa hàng của mình nhé! Nhớ chọn ảnh thật đẹp
					để thui hút thật nhiều khách hàng .</p>
			</div>
		</div>
		<div class="col-12">
			<div class="mt-3">
				<p>Đặt tên cho cửa hàng của bạn và nhớ ghi mô tả cho cửa hàng ..</p>
			</div>
		</div>
		<div class="col-12">
			<h5>Bước 3:</h5>
			<div class="mt-3">
				<p>Cửa hàng của bạn sau khi được tạo thành công.</p>
			</div>
		</div>
		<div class="col-12 d-flex">
			<h5>Để hiểu hơn về cách bán hàng trên hệ thống vui lòng tải tệp
				hướng dẫn sau:</h5>
			<a href="<c:url value="/vendor/download-guide"/>" class="ml-3">
				Hướng dẫn <i class="fa-solid fa-download"></i>
			</a>
		</div>
	</div>

</div>
<script>
	function LoadMore() {
		const amount = document.getElementsByClassName("product").length;
		$.ajax({
			url : "${UrlLoadMore}",
			type : "get",
			data : {
				exist : amount
			},
			success : function(data) {
				$("#list-product").append(data);
			},
			error : function(xhr) {

			}
		})
	}
</script>
