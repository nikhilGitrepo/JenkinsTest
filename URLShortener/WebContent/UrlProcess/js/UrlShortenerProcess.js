function loadRecentUrl() {
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		url : 'getrecent.ajax',
		success : function(data) {
			$.each(data, function(i, item) {
				if (i == '@items') {
					var htmldiv = "";
					var count = 1;
					var htmldiv = "<table id='recentUrlTable'><tbody>";
					$.each(item, function(j, link) {
						//$.each(link, function(i, link) {
							htmldiv += "<tr><td>&nbsp;"+count+"&nbsp;</td><td><a target='_blank' href='" + link.url + "'>" + link.url + "</a></td></tr>";
							count+=1;
						//});
				});
				htmldiv+= "</tbody></table>";
				$("#recentPanelTable").append(htmldiv);
		}
	});
	}
	});
	
}
