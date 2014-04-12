<%@ page language="java" contentType="text/html; charset=windows-1251"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<c:forEach var="entry" items="${itemsList}">
		<table border="1" width="100%" cellspacing="0" cellpadding="2" bgcolor="#A5A5A5">
			<tbody>
<%-- 			<c:out value="${entry.key}" /></br> --%>
<%--  			<c:out value="${entry.value.aItemName}" /></br> --%>
<%--  			<IMG SRC="${pageContext.request.contextPath}/img/gear/${entry.value.aItemImage}" ALT="Gear" name="Gear" > --%>
				<tr bgcolor="#C7C7C7">
					<td align="center" width="150"><img
						src="${pageContext.request.contextPath}/img/gear/${entry.value.aItemImage}"><br>
						<center>
							<small>(${entry.key})</small>
						</center> <br>
						<a href="?edit=1&amp;dress=365437724">надеть</a> <br> 
						<a href="?edit=1&amp;pocket=1&amp;item=365437724">положить</a>
						<img src="http://i.oldbk.com/i/clear.gif" style="cursor: pointer;" onclick="if (confirm('Предмет Восстановление энергии 60HP будет утерян, вы уверены?')) window.location='main.php?edit=1&amp;destruct=365437724'">
					</td>
					<td>
						<a href="http://oldbk.com/encicl/mag2/cureHP60.html" target="_blank">${entry.value.aItemName}</a>
						<img src="http://i.oldbk.com/i/align_0.gif"> (Масса: 1.0) <br>
						<b>Цена: 1.5 кр.</b> &nbsp; &nbsp;<br> Долговечность: 0/1<br>
						Вероятность срабатывания: 90%<br>
						Требуется минимальное:<br>
						• Уровень: 4<br>
						• Интеллект: 6<br>
						• Мастерство владения серой магией: 2<br>
						<font color="maroon">Наложены заклятия:</font> исцеление<br>
						<font color="maroon">Свойства:</font> может встраиваться в вещи <br>
						<small>
							<font color="maroon">Предмет не подлежит ремонту</font>
						</small><br>
						<small>Сделано в CapitalCity</small></td>
				</tr>
				<tr bgcolor="#C7C7C7">
					<td colspan="2">
						<div id="txt_100" style="display: block;">
							<a href="#100" onclick="showhiddeninv(100,365437724,51);"> показать еще 10шт.</a>
						</div>
						<div id="txt1_100" style="display: none;">
							<a href="#100" onclick="closehiddeninv(100);">скрыть</a>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<div style="display: none;" id="id_100">
			<img src="http://i.oldbk.com/i/ajax-loader.gif" border="0">
		</div>
		<div style="display: none;" id="id_2971">
			<img src="http://i.oldbk.com/i/ajax-loader.gif" border="0">
		</div>
	</c:forEach>
