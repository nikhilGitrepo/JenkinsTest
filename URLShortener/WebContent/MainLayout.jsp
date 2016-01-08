<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function setFrameHeight(){
    var mainLayoutFrame = document.getElementById('mainLayoutFrame');
    if(mainLayoutFrame) {
    	mainLayoutFrame.height = "";
    	mainLayoutFrame.height = mainLayoutFrame.contentWindow.document.body.scrollHeight + "px";
    } 
}
</script>

<title>URLShortener</title>



 <script type="text/javascript">var switchTo5x=true;</script>
<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
<script type="text/javascript">stLight.options({publisher: "368f030c-3c23-4e08-a39d-c8d33ad7aa64", doNotHash: false, doNotCopy: false, hashAddressBar: false});</script>

</head>
<body onload="setFrameHeight();">

<iframe id="mainLayoutFrame" align="middle" id="homePage" src="redirect.urlview" frameborder="0" height="" width="100%"></iframe>
<center>
<span class='st_sharethis_large' displayText='ShareThis'></span>
<span class='st_facebook_large' displayText='Facebook'></span>
<span class='st_twitter_large' displayText='Tweet'></span>
<span class='st_linkedin_large' displayText='LinkedIn'></span>
<span class='st_pinterest_large' displayText='Pinterest'></span>
<span class='st_email_large' displayText='Email'></span>
</center>

</body>

</html>
