$(document)
		.ready(
				function() {
						loadUrlMaps();
				});

function loadUrlMaps() {
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		url : 'loadAll.ajax',
		success : function(data) {
			$.each(data, function(i, item) {
				if (i == '@items') {
					var htmldiv = "";
					$.each(item, function(j, link) {
						htmldiv += "<tr><td><a href='" + link.shortUrl + "'>"
								+ link.shortUrl + "</a></td><td>&nbsp;"
								+ link.desiredId + "&nbsp;</td><td>"+link.longUrl+"</td</tr>";
					});
					$("#urlMap").html(htmldiv);
				}
			});
		}
	});

}