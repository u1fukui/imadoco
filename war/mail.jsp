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
	<div>▲あなたの場所をマークしたよ<m:emoji name="るんるん" /></div>
	<br>
	<div>この地図のURLをお友達に送って、位置情報を共有しよう<m:emoji name="わーい（嬉しい顔）" /></div>
	<br>
	<div style="text-align:center;">
		<a href="<c:url value="mailto:">
				<c:param name="subject" value="[imadoco]地図を作ったよー" />
				<c:param name="body" value="待ち合わせ用の地図を作成したよ！以下のリンクから自分の居場所を知らせてね。
${link_url}" />
			</c:url>">この地図をお友達に教える<m:emoji name="メール" /></a>
	</div>
</div>
</body>
</html>
