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
<div>
	<div style="text-align:center;">
		<h2>imadoco?</h2>
		<div style="font-size:x-small">みんなの位置をらくらく共有</div>
	</div>
	<br>
	<div>
		<div style="background-color:#00CC33; color:#FFFFFF;">
		<m:emoji name="メモ" />使い方<m:emoji name="メモ" />
		</div>
		<div style="font-size:x-small">
			<div><m:emoji name="1" />お友達との待ち合わせ<m:emoji name="イベント" />に使う地図を作成<m:emoji name="ウィンク" /></div>
			<div><m:emoji name="2" />作成した地図リンク<m:emoji name="位置情報" />をメール<m:emoji name="メール" />で連絡</div>
			<div><m:emoji name="3" />お友達はメール上のリンクから数回クリック<m:emoji name="携帯電話" />するだけで簡単場所共有<m:emoji name="指でOK" /></div>
		</div>
	</div>
	<br>
	<div style="text-align: center;">
		<m:gps kickBackUrl="mail">
		   地図を作成する
		</m:gps>
	</div>
</div>
</body>
</html>
