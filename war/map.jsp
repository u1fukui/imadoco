<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>
<%@taglib prefix="m" uri="http://taglibs.mobylet.org/" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>imadoco?</title>
</head>
<body>
<div style="font-size: x-small;">
	<div>
		<img src="${image_src}" />
	</div>
	<div>▲みんなの位置情報だよ<m:emoji name="るんるん" /></div>
	<br>
	<div>あなたの場所も地図上にマークしよう<m:emoji name="ぴかぴか（新しい）"  /></div>
	<br>
	<div style="text-align: center;">
		<m:gps kickBackUrl="${groupId}">
		   <m:emoji name="位置情報" />居場所を知らせる<m:emoji name="位置情報" />
		</m:gps>
	</div>
</div>
</body>
</html>
