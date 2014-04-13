<%@ page language="java" contentType="text/html; charset=windows-1251"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css"> 
html {height:100%}
body {
margin:0;
height:100%;
overflow:hidden
}
</style>
<link media="screen" rel="stylesheet" type="text/css"
	href="css/main.css" />
<link media="screen" rel="stylesheet" type="text/css"
	href="css/iframes.css" />
<title>Char jsp</title>
<script>
			var delay = 2; // задержка изменения очков здоровья
			var redHP = 0.33; // меньше 30% красный цвет
			var yellowHP = 0.66; // меньше 60% желтый цвет, иначе зеленый
			var TimerOn = -1; // id таймера
			var tkHP, maxHP;
			var speed = 100;
			var mspeed = 100;

			//-- Смена хитпоинтов (очков здоровья) со временем
			function setHP(value, max, newspeed) {
				tkHP = ${curHealth};
				maxHP = ${maxHealth};
				if (TimerOn >= 0) {
					clearTimeout(TimerOn);
					TimerOn = -1;
				}
				speed = newspeed;
				setHPlocal();
			}

			function setHPlocal() {
				if (tkHP > maxHP) {
					tkHP = maxHP;
				}
				var sz1 = Math.round((200 / maxHP) * tkHP);
				var sz2 = 200 - sz1;
				if (document.all("HP")) {
					document.HP1.width = sz1;
					document.HP2.width = sz2;
					if (tkHP / maxHP < redHP) {
						document.HP1.src = 'img/1red.gif';
					} else {
						if (tkHP / maxHP < yellowHP) {
							document.HP1.src = 'img/1yellow.gif';
						} else {
							document.HP1.src = 'img/1green.gif';
						}
					}
					var s = document.all("HP").innerHTML;
					document.all("HP").innerHTML = s.substring(0, s.lastIndexOf(':') + 1) + Math.round(tkHP) + "/" + maxHP;
				}
				tkHP = (tkHP + (maxHP / 100) * speed / 1000);
				if (tkHP < maxHP) {
					TimerOn = setTimeout('setHPlocal()', delay * 100);
				} else {
					TimerOn = -1;
				}
			}
		</SCRIPT>
</head>
<body onLoad="setHP(${user.curHealth}, ${user.endurance},100)">
	<table>
		<tbody id="charTbody">
			<tr>
				<td id="nickNameChar" valign="top" align="left" width="25"
					height="15"><b>${user.login}</b> [${user.charLevel}] <a
					href="${pageContext.request.contextPath}/inf" target="_blank"><img
						src="http://i.oldbk.com/i/inf.gif" width="12" height="11"
						alt="Инф. о ${user.login}"></a>
					<div id="HP">
						<IMG SRC="${pageContext.request.contextPath}/img/1silver.gif"
							WIDTH=1 HEIGHT=10 ALT="Уровень жизни" name=HP1> <IMG
							SRC="${pageContext.request.contextPath}/img/1silver.gif" WIDTH=1
							HEIGHT=10 ALT="Уровень жизни" name=HP2>:
					</div>
					<table id="character">
						<tbody>
							<tr>
								<td valign="top" align="left"><table border="0"
										cellspacing="0" cellpadding="0" width="100%">
										<tbody>
											<tr>
												<td>
													<table
														style="border-right-color: #666666; border-right-style: solid; border-right-width: 1px; border-bottom-color: #666666; border-bottom-style: solid; border-bottom-width: 1px; border-left-color: #FFFFFF; border-left-style: solid; border-left-width: 1px; border-top-color: #FFFFFF; border-top-style: solid; border-top-width: 1px;"
														border="0" cellspacing="0" cellpadding="0">
														<tbody>
															<tr valign="top">
																<td id="left_items">
																	<table border="0" cellspacing="0" cellpadding="0"
																		width="100%">
																		<tbody>
																			<tr>
																				<td width="60" height="60"><img
																					src="${pageContext.request.contextPath}/img/gear/w9.gif"></td>
																			</tr>
																			<tr>
																				<td width="60" height="40"><img
																					src="${pageContext.request.contextPath}/img/gear/w18.gif"></td>
																			</tr>
																			<tr>
																				<td width="60" height="60"><img
																					src="${pageContext.request.contextPath}/img/gear/w3.gif"></td>
																			</tr>
																			<tr>
																				<td width="60" height="80"><img
																					src="${pageContext.request.contextPath}/img/gear/w4.gif"></td>
																			</tr>
																			<tr>
																				<td width="60" height="40"><img
																					src="${pageContext.request.contextPath}/img/gear/w5.gif"></td>
																			</tr>
																		</tbody>
																	</table>
																</td>
																<td>
																	<table border="0" cellspacing="0" cellpadding="0"
																		width="100%">
																		<tbody>
																			<tr>
																				<td height="220" valign="top" width="120"
																					style="background: url('${pageContext.request.contextPath}/img/avatars/${user.charImage}') top no-repeat;"
																					align="left"></td>
																			</tr>
																			<tr>
																				<td width="120" height="40">
																					<table width="100%" border="0" cellspacing="0"
																						cellpadding="0">
																						<tbody>
																							<tr>
																								<td><img
																									src="${pageContext.request.contextPath}/img/gear/w20.gif"
																									alt=""></td>
																								<td><img
																									src="${pageContext.request.contextPath}/img/gear/w20.gif"
																									alt=""></td>
																								<td><img
																									src="${pageContext.request.contextPath}/img/gear/w20.gif"
																									alt=""></td>
																							</tr>
																						</tbody>
																					</table>
																				</td>
																			</tr>
																		</tbody>
																	</table>
																</td>
																<td id="right_items">
																	<table border="0" cellspacing="0" cellpadding="0"
																		width="100%">
																		<tbody>
																			<tr>
																				<td width="60" height="20"><img
																					src="${pageContext.request.contextPath}/img/gear/w1.gif"></td>
																			</tr>
																			<tr>
																				<td width="60" height="20"><img
																					src="${pageContext.request.contextPath}/img/gear/w2.gif"></td>
																			</tr>
																			<tr>
																				<td id="rings">
																					<table border="0" cellspacing="0" cellpadding="0">
																						<tbody>
																							<tr>
																								<td width="20" height="20"><img
																									src="${pageContext.request.contextPath}/img/gear/w6.gif"></td>
																								<td width="20" height="20"><img
																									src="${pageContext.request.contextPath}/img/gear/w6.gif"></td>
																								<td width="20" height="20"><img
																									src="${pageContext.request.contextPath}/img/gear/w6.gif"></td>
																							</tr>
																						</tbody>
																					</table>
																				</td>
																			</tr>
																			<tr>
																				<td width="60" height="40"><img
																					src="${pageContext.request.contextPath}/img/gear/w11.gif"></td>
																			</tr>
																			<tr>
																				<td width="60" height="60"><img
																					src="${pageContext.request.contextPath}/img/gear/w10.gif"></td>
																			</tr>
																			<tr>
																				<td width="60" height="80"><img
																					src="${pageContext.request.contextPath}/img/gear/w19.gif"></td>
																			</tr>
																			<tr>
																				<td width="60" height="40"><img
																					src="${pageContext.request.contextPath}/img/gear/w12.gif"></td>
																			</tr>
																		</tbody>
																	</table>
																</td>
															</tr>
														</tbody>
													</table>
												</td>
											</tr>
										</tbody>
									</table></td>
							</tr>
							<tr>
								<td><small><b>Town: ${city}</b><br> Location:
										<b>${location}</b> </small></td>
							</tr>
						</tbody>
					</table></td>
				<td width="267" valign="top" height="15">
					<!-- Тут размещено здоровье персонажа -->
					<table cellspacing=3 cellpadding=3 border="0" bordercolor="#000080">
						<tr>
							<td id="characterStats" valign="top" style="width: 350px;">
								<table>
									<tbody>
										<tr>
											<c:if test="${not empty user}">
												<td>Strength: ${user.strength} <c:if
														test="${user.notUsedStats >'0'}">
														<a
															href="${pageContext.request.contextPath}/addStats?nickName=${user.login}&stat=${user.strength}&setstat=str&notUsedStats=${user.notUsedStats}&userId=${user.userId}"><img
															src="img/plus.gif" border=0></a>
													</c:if><br> Dexterity: ${user.dexterity} <c:if
														test="${user.notUsedStats >'0'}">
														<a
															href="${pageContext.request.contextPath}/addStats?nickName=${user.login}&stat=${user.dexterity}&setstat=dex&notUsedStats=${user.notUsedStats}&userId=${user.userId}"><img
															src="img/plus.gif" border=0></a>
													</c:if><br> Luck: ${user.accuracy} <c:if
														test="${user.notUsedStats >'0'}">
														<a
															href="${pageContext.request.contextPath}/addStats?nickName=${user.login}&stat=${user.accuracy}&setstat=acc&notUsedStats=${user.notUsedStats}&userId=${user.userId}"><img
															src="img/plus.gif" border=0></a>
													</c:if><br> Endurance: ${user.endurance} <c:if
														test="${user.notUsedStats >'0'}">
														<a
															href="${pageContext.request.contextPath}/addStats?nickName=${user.login}&stat=${user.endurance}&setstat=endu&notUsedStats=${user.notUsedStats}&userId=${user.userId}"><img
															src="img/plus.gif" border=0></a>
													</c:if><br> Intellect: ${user.intellect} <c:if
														test="${user.notUsedStats >'0'}">
														<a
															href="${pageContext.request.contextPath}/addStats?nickName=${user.login}&stat=${user.intellect}&setstat=intellect&notUsedStats=${user.notUsedStats}&userId=${user.userId}"><img
															src="img/plus.gif" border=0></a>
													</c:if><br> Wisdome: ${user.wisdome} <c:if
														test="${user.notUsedStats >'0'}">
														<a
															href="${pageContext.request.contextPath}/addStats?nickName=${user.login}&stat=${user.wisdome}&setstat=wisdome&notUsedStats=${user.notUsedStats}&userId=${user.userId}"><img
															src="img/plus.gif" border=0></a>
													</c:if><br> Not used stats: ${user.notUsedStats} <br>
													<hr> Experience: <a href="#" target="_blank">${user.exp}</a>
													(${user.nextExp}) <br> Level: ${user.charLevel}<br>
													Wins: ${wins}<br> Loses: ${loses}<br> Money: <b>${user.money}</b>
													кр.<br> Clan: ${clan}<br> Session ID:
													${sessionID}<br> Session User: ${currentSessionUser} <br>
												</td>
											</c:if>


										</tr>
									</tbody>
								</table>
							</td>
						</tr>
					</table>
				</td>
				<!-- Конец Секции-->
				<td align="right" valign="top" width="100%">
					<div id="menu"></div>
					<table>
						<tbody>
							<tr>
								<td>
									<table border="0" width="750px" cellspacing="0" cellpadding="3" bgcolor="#d4d2d2">
										<tbody>
											<tr>
												<td align="center" bgcolor="#A5A5A5">
													<input name="ssave" type="hidden" value="1">
													<input type="hidden" id="rzd0" name="rzd0" value="0">
													<img src="http://i.oldbk.com/i/g0.gif" onclick="save1(0);" style="cursor: pointer;">
													<a href="${pageContext.request.contextPath}/char?nickname=${user.login}&id=${user.userId}">&nbsp;Inventory</a>
												</td>
												<td align="center" bgcolor="#C7C7C7">
													<input type="hidden" id="rzd1" name="rzd1" value="1">
													<img src="http://i.oldbk.com/i/g1.gif" onclick="save1(1);" style="cursor: pointer;">
													<a href="?edit=1&amp;razdel=1">&nbsp;Scrolls</a>
												</td>
												<td align="center" bgcolor="#C7C7C7">
													<input type="hidden" id="rzd2" name="rzd2" value="1">
													<img src="http://i.oldbk.com/i/g1.gif" onclick="save1(2);" style="cursor: pointer;">
													<a href="?edit=1&amp;razdel=2">&nbsp;Other</a>
												</td>
												<td align="center" bgcolor="#C7C7C7">
													<input type="hidden" id="rzd4" name="rzd4" value="1">
													<img src="http://i.oldbk.com/i/g1.gif" onclick="save1(4);" style="cursor: pointer;">
													<a href="?edit=1&amp;razdel=4">&nbsp;Gifts</a>
												</td>
												<td align="center" bgcolor="#C7C7C7">
													<input type="hidden" id="rzd5" name="rzd5" value="1">
													<img src="http://i.oldbk.com/i/g1.gif" onclick="save1(5);" style="cursor: pointer;">
													<a href="?edit=1&amp;razdel=5">&nbsp;Resources</a>
												</td>
												<td align="center" bgcolor="#C7C7C7">
													<input type="hidden" id="rzd3" name="rzd3" value="0">
													<img src="http://i.oldbk.com/i/g0.gif" onclick="save1(3);" style="cursor: pointer;">
													<a href="?edit=1&amp;razdel=3">&nbsp;Extra one</a>
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<td align="center"><b> Рюкзак (масса: 40/108)</b></td>
							</tr>
							<tr>
								<td align="center">
									<!--Рюкзак--> 
									[<a href="?edit=1&amp;razdel=1&amp;all=1">все</a>]
									<table border="0" width="100%" cellspacing="1" cellpadding="2" bgcolor="#A5A5A5"></table>
									<c:if test="${frameIsActive == !false}">
										<iframe id="inventory" src="${pageContext.request.contextPath}/inventory?nickName=${user.login}&userId=${user.userId}" scrolling="yes">
											<p>Your browser does not support iframes.</p>
										</iframe>
									</c:if>
								</td>
							</tr>
						</tbody>
					</table> 
				</td>
			</tr>
		</tbody>
	</table>

	<%-- 	<h1>You are logged in as: ${login}</h1> --%>
	<%-- 	<div>Your name is: ${name}</div> --%>
	<%-- 	<div>Your Birth day is: ${bday}</div> --%>
</body>
</html>