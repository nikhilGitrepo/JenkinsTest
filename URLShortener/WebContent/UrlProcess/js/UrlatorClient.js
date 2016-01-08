var pageMap = {
	URL_MAPS : 'UrlProcess/js/urlmaps/urlmaps.jsp',
	HOME : 'HOME',
	BACK_HOME : 'backHome',
	URL_SUCCESS : 'UrlProcess/js/submissionResult/submissionResultSuccess.jsp',
	URL_FAILURE : 'UrlProcess/js/submissionResult/submissionResultFailed.jsp'
};

function parallax(jumboHeight) {
	var scrolled = $(window).scrollTop();
	$('.bg').css('height', (jumboHeight - scrolled) + 'px');
}

function extractDomain(url) {
	var domain;
	// find & remove protocol (http, ftp, etc.) and get domain
	if (url.indexOf("://") > -1) {
		domain = url.split('/')[2];
	} else {
		domain = url.split('/')[0];
	}

	// find & remove port number
	domain = domain.split(':')[0];

	return domain;
}

function validateHost(longUrl, fn) {
	var host = extractDomain(longUrl);
	ping(host, function(status, e) {
		fn(status);
	});

}

function ping(ip, callback) {

	if (!this.inUse) {
		this.status = 'unchecked';
		this.inUse = true;
		this.callback = callback;
		this.ip = ip;
		var _that = this;
		this.img = new Image();
		this.img.onload = function() {
			_that.inUse = false;
			_that.callback('responded');

		};
		this.img.onerror = function(e) {
			if (_that.inUse) {
				_that.inUse = false;
				_that.callback('failed', e);
			}

		};
		this.start = new Date().getTime();
		this.img.src = "http://" + ip;
		this.timer = setTimeout(function() {
			if (_that.inUse) {
				_that.inUse = false;
				_that.callback('success');
			}
		}, 150);
	}
}

$(document)
		.ready(
				function() {
					$(".nav-urlator").click(
							function(e) {
								e.preventDefault();
								if (this.id == pageMap.HOME
										|| this.id == pageMap.BACK_HOME) {
								/*	$('#mainPanel').load(location.href, function(){
										//loadRecentUrl();
										});
								*/
									window.location.reload();
								} else if (this.id == 'URL_MAPS') {
									$("#mainPanel").load(pageMap[this.id], function(){
										loadUrlMaps();
									});
								}
							});

					var jumboHeight = $('.jumbotron').outerHeight();

					$(window).scroll(function(e) {
						parallax(jumboHeight);
					});

					// Submits url and displays the panel based on success or
					// fail
					$(".urlBtn")
							.click(
									function(e) {
										e.preventDefault();
										var lUrl = "";
										var desiredId = "";
										var formId;
										switch (this.id) {
										case "navSubmit":
											formId = "navBarUrlSubmit";
											lUrl = $('#lurlInput').val();
											desiredId = $('#idInput').val();
											// validate that longurl and
											// shorturl fields are populated, if
											// not show the warning as a modal,
											// since thi
											// is submitted from the navbar.
											if (lUrl == "" || desiredId == "") {
												var errorMessages = '<div class="alert alert-danger">Missing information: '
												if (lUrl == "") {
													errorMessages += 'Long URL';
												}
												if (desiredId == "") {
													errorMessages += ' Desired Id';
												}
												errorMessages += '</div>';
												$('#navErrorMessages').html(
														errorMessages);
												$('#shortenModal')
														.modal('show');
												return;
											}

											break;
										case "panelSubmit":
											formId = "urlSubmit";
											lUrl = $('#lurlInput2').val();
											desiredId = $('#idInput2').val();
											// validate that longurl and
											// shorturl fields are populated, if
											// not show the warning in the panel
											if (lUrl == "" || desiredId == "") {
												var errorMessages = '<div class="alert alert-danger">Missing information: '
												if (lUrl == "") {
													errorMessages += 'Long URL';
												}
												if (desiredId == "") {
													errorMessages += ' Desired Id';
												}
												errorMessages += '</div>';
												$('#errorMessages').html(
														errorMessages);
												return;
											} else {
												$('#errorMessages').html("");
											}
											break;
										default:
											break;
										}

										console.log("longurl:" + lUrl);
										console.log("id:" + desiredId);
										var isUrlOk =true;
										 /* var resp; validateHost(lUrl,
										  function(pingResp){ resp = pingResp;
										  		if(resp === "failed"){
										  			isUrlOk=false;
										  		$('#navErrorMessages').html("<p>It appears that the entered url is not in use!</p>");
															  $('#navErrorMessages').append("<p>Why not claim it for yourself through our sponser site?</p>");
															  $('#shortenModal').modal('show');
										  		}
										  });
										/*
										 * console.log("response: "+ resp); if
										 * (resp === "failed"){
										 * $('#navErrorMessages').html("<p>It
										 * appears that the entered url is not a
										 * real domain!</p>");
										 * $('#navErrorMessages').append("<p>Why
										 * not claim it for yourself through our
										 * sponser site?</p>");
										 * $('#shortenModal').modal('show');
										 * return; }
										 */

										$(function() {
											var jsonResponse;
											var dataStr = $("#" + formId)
													.serialize();
											$
													.ajax({
														type : 'post',
														url : 'addurl.urlview',
														dataType : 'text',
														data : dataStr,
														success : function(
																callback) {
															$('#mainPanel')
																	.html(
																			callback);
															console
																	.log("post successful!");
														},
														error : function(
																XMLHttpRequest,
																textStatus,
																errorThrown) {
															alert("some error");
														}

													});
										});
									});

					// Limit id inputs to alphanumeric and _ only
					$(".idInput").keypress(
							function(e) {
								var regex = new RegExp("^[a-zA-Z0-9\b_]+$");
								var str = String
										.fromCharCode(!e.charCode ? e.which
												: e.charCode);
								if (regex.test(str)) {
									return true;
								}

								e.preventDefault();
								return false;
							});

					// [a-zA-Z0-9!@#$%^*_|]{6,25}
					// limit Long url to html characters only
					$("lurlInput").keypress(
							function(e) {
								var regex = new RegExp(
										"^[a-zA-Z0-9!@#$%^*_|]{6,25}+$");
								var str = String
										.fromCharCode(!e.charCode ? e.which
												: e.charCode);
								if (regex.test(str)) {
									return true;
								}
								e.preventDefault();
								return false;
							});
				});

