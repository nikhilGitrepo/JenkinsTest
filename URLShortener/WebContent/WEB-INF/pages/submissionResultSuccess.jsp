<div class="contentPanel" id="mainSuccPanel">
	<div class="row">
		<div class="col-md-4">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">Shortened URL ready!</h3>
				</div>
				<div class="panel-body" id="urlSuccess" style="height: 180px;">
					<p>${shUrl.message}</p>
					<a href="${shUrl.shortUrl.url}"> ${shUrl.shortUrl.url}</a>

				</div>
			</div>
		</div>
		<!--  column -->

		<div class="col-md-4">
			<h1>Thank you for using URLShortener! Your #1 provider for
				custom shortened URLs"</h1>
		</div>
		<!-- coluumn -->

		<div class="col-md-4">
			<img
				src="http://www.magicandmayhemwriters.com/wp-content/uploads/2011/04/your_ad_here_banner.jpg"
				style="width: 304px; height: 228px;">
		</div>
		<!-- column -->
		<button type="submit" id="backHome"
			class="btn nav-urlator btn-default">Make another!</button>
	</div>
</div>
<script src="UrlProcess/js/UrlatorClient.js"></script>
