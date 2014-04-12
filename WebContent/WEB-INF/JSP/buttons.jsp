<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function getCookie(Name) {
		var search = Name + "="
		if (document.cookie.length > 0) {
			offset = document.cookie.indexOf(search)
			if (offset != -1) {
				offset += search.length
				end = document.cookie.indexOf(";", offset)
				if (end == -1)
					end = document.cookie.length
				return unescape(document.cookie.substring(offset, end))
			}
		}
	}

	var UserName = "<a href=toad.html><SPAN>[" + getCookie("MMCLUB_NICK_NAME")
			+ "]</SPAN></a>" + " "

	function rslength() // изменяет размер строки ввода текста
	{
		var size = document.body.clientWidth - (3 * 30) - 21 - 59 - 256 - 18
				- 30;
		if (size < 100) {
			size = 100
		}
		document.F1.text.width = size;
		document.all('T2').width = size;
	}
	window.onresize = rslength;

	function AddToChat() {
		var hsh = new Date();
		var S = top.frames['chat'].mes.innerHTML;
		cAdd = top.frames['buttons'].F1.text.value;
		top.frames['chat'].mes.innerHTML = S + "<font color=red>"
				+ hsh.getHours() + ":" + hsh.getMinutes() + "</font> "
				+ UserName + cAdd + "<BR>";
		top.frames['buttons'].F1.text.value = "";
		top.frames['chat'].window.scrollBy(0, 65000);
	}
</script>

</head>

<body leftmargin=0 topmargin=0 marginheight=0 marginwidth=0
	bgcolor=#E6E6E6 onload="rslength()">
	<form method="GET" name="F1" id="F1">
		<table width="100%" height="30" cellspacing="0" cellpadding=0">
			<tr valign="top"
				style="background-image: url(http://mmclub.com/img/beg_chat_03.gif); background-position: top; background-repeat: repeat-x;">
				<td width="30"><img src="img/chat/b.gif" width="30" height="30"
					alt="Чат" /></td>
				<td valign="middle" id="T2"><input type="text" name="text"
					maxlength="240" size="80" /></td>
				<td nowrap id="T3"><img src="img/chat/b_ok.gif" width="30"
					height="30" alt="Добавить текст в чат" style="cursor: hand"
					onclick="AddToChat()" /> <img src="img/chat/1x1.gif" width="8"
					height="1" alt="" /> <img src="img/chat/b_clear.gif" width="30"
					height="30" alt="Очистить строку ввода/чат" style="cursor: hand">
					<img src="img/chat/b_smile.gif" width="30" height="30"
					alt="Смайлики" style="cursor: hand"></td>

				<td width="19" id="T4" background="img/chat/b_bg2.gif"><img
					src="img/chat/beg_chat_05.gif" width="19" height="30" alt="" /></td>
				<td align="right" nowrap="nowrap" bgcolor="BAB7B3" id="T5"
					background="img/chat/b_bg2.gif"><img src="img/chat/a_inv.gif"
					width="30" height="30" alt="Настройки/Инвентарь"
					style="cursor: hand"> <img src="img/chat/a_friend.gif"
					width="30" height="30" alt="Друзья" style="cursor: hand"> <img
					src="img/chat/a_ext.gif" width="30" height="30" alt="Выход из игры"
					style="cursor: hand"
					onclick="if (confirm('Exit game?')) top.window.navigate('/userLogged.jsp?exit=0.781520416407446')" /></td>
				<td width="70" valign="middle" background="img/chat/b_bg2.gif"
					bgcolor="BAB7B3" id="T6"><object
						classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
						codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=6,0,29,0"
						width="70" height="26">
						<param name="movie"
							value="img/chat/clock.swf?<?php echo 'hours='.$aHours.'&minutes='.$aMinutes.'&sec='.$aSeconds ?>" />
						<param name="quality" value="high" />
					</object></td>
				<td width="9" valign="middle" background="img/chat/b_bg2.gif"
					bgcolor="BAB7B3">
			</tr>
		</table>
	</form>
</body>
</html>