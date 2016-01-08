<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="Main theme for Bootstrap" content="">
<meta name="author" content="Doug">
<link rel="icon" href="../../favicon.ico">

<title>URL Generator</title>
<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="UrlProcess/css/base.css" rel="stylesheet">
</head>
<body onload="loadRecentUrl();">
	<nav class="navbar navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand nav-urlator" id="HOME" href="#">URL
					Shortener</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"></li>
					<li id="URL_MAPS" class="nav-urlator"><a href="">URL Maps</a></li>
				</ul>
				<form class="navbar-form navbar-right" id="navBarUrlSubmit">
					<div class="form-group lurlInput">

						<input type="text" placeholder="URL" id="lurlInput"
							name="longUrl.url" class="form-control">
					</div>
					<div class="form-group idInput">

						<input type="text" id="idInput" name="desiredId"
							placeholder="Desired ID" class="form-control">
					</div>
					<button id="navSubmit" class="btn urlBtn btn-success">Shorten!</button>

				</form>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<!-- Modal -->
		<div id="shortenModal" class="modal fade" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Missing Information</h4>
					</div>
					<div class="modal-body">
						<div id="navErrorMessages"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>

			</div>
		</div>
		<div id="mainPanel">
			<div class="contentPanel" role="main">
				<!-- Main jumbotron for a primary marketing message or call to action -->
				<div class="bg"></div>
				<div class="jumbotron masthead">
					<div class="container">
						<h1>URL Shortener</h1>
						<p class="lead">Presenting custom shortened url links</p>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-4">
						<form id="urlSubmit">
							<div class="form-group lurlInput" id="inputDiv">
								<label for="lurlInput">URL</label> <input type="text"
									placeholder="Long URL" name="longUrl.url" class="form-control"
									id="lurlInput2">
							</div>
							<div class="form-group idInput">
								<label for="idInput">Desired ID</label> <input type="text"
									placeholder="Desired ID" name="desiredId" class="form-control"
									id="idInput2">
							</div>
							<div id="errorMessages"></div>
							<button id="panelSubmit" class="btn urlBtn btn-default">Shorten!</button>
						</form>

					</div>

					<div class="col-sm-8">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h3 class="panel-title">Most popular links</h3>
							</div>
							<div class="panel-body" id="mostPopularLinks"
								style="height: 180px;">
								<div id="recentPanelTable" style="height: 160px;"></div>
							</div>
						</div>



					</div>
					<!--  col -->
				</div>
				<!--  row -->

			</div>
			<!--  content panel -->
		</div>
		<!--  main panel -->

	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
	<script src="UrlProcess/js/UrlShortenerProcess.js"></script>
	<script src="UrlProcess/js/UrlatorClient.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->

</body>
</html>
