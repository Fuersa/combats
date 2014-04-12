<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>



</head>
<body>
	<center>
		<form name="regform" action="${pageContext.request.contextPath}/adduser" method="POST">
			<p>
				<br> &nbsp;
			</p>
			<table width="960" cellpadding="0" border="0"
				style="border-style: dashed; border-width: 1px" bgcolor="#FFE5B6">
				<tbody>
					<tr>
						<td width="72">Login:<font color="#FF0000">*</font></td>
						<td width="204"><input name="login" size="20"></td>
						<td width="98">Pw:<font color="#FF0000">*</font></td>
						<td width="193"><input type="password" name="password" size="20"></td>
					</tr>
					<tr>
						<td width="72"><span lang="en-us">E-Mail</span><font
							color="#FF0000">*</font></td>
						<td width="204"><input name="email" size="20"></td>
						<td width="98">Name<font color="#FF0000">*</font></td>
						<td width="193"><input name="name" size="37"></td>
					</tr>
					<tr>
						<td width="72">Secret Question<font color="#FF0000">*</font>
						<p></p>
						</td>
						<td style="PADDING-BOTTOM: 10px" width="204"><select size="1" name="question">
								<option value="1">Name of your pet</option>
								<option value="2">Your favorite movie</option>
								<option value="3">Your favorite color</option>
						</select></td>
						<td style="PADDING-BOTTOM: 10px" width="98"> Secret Answer<font color="#FF0000">*</font>
						</td>
						<td style="PADDING-BOTTOM: 10px" width="193">
							<input name="answer" size="37">
						</td>
					</tr>
					<tr>
						<td width="72">Gender:<font color="#FF0000">*</font><br>
							&nbsp;
						</td>
						<td style="PADDING-BOTTOM: 10px" width="307" colspan="2">
							<input type="radio" name="gender" value="1" style="cursor: hand" id="A1" checked="">
							<label for="A1"> Male </label>
							<input type="radio" name="gender" value="2" style="cursor: hand" id="A2"><label for="A2"> Female</label>
						</td>
						<td style="PADDING-BOTTOM: 10px" width="193">&nbsp;</td>
					</tr>
					<tr>
						<td width="72">City:</td>
						<td style="PADDING-BOTTOM: 10px" width="204"><input
							type="text" name="city" size="20" maxlength="40"></td>
						<td style="PADDING-BOTTOM: 10px" width="98">ICQ:</td>
						<td style="PADDING-BOTTOM: 10px" width="193"><input
							type="text" name="icq" size="20" maxlength="20" value=""></td>
					</tr>
					<tr>
						<td width="72">Birthday:<font color="#FF0000">*</font></td>
						<td style="PADDING-BOTTOM: 10px" width="495" colspan="3">Day:&nbsp;
							<select size="1" name="day">
								<option value="1">01</option>
								<option value="2">02</option>
								<option value="3">03</option>
								<option value="4">04</option>
								<option value="5">05</option>
								<option value="6">06</option>
								<option value="7">07</option>
								<option value="8">08</option>
								<option value="9">09</option>
								<option value="10">10</option>
								<option value="11">11</option>
								<option value="12">12</option>
								<option value="13">13</option>
								<option value="14">14</option>
								<option value="15">15</option>
								<option value="16">16</option>
								<option value="17">17</option>
								<option value="18">18</option>
								<option value="19">19</option>
								<option value="20">20</option>
								<option value="21">21</option>
								<option value="22">22</option>
								<option value="23">23</option>
								<option value="24">24</option>
								<option value="25">25</option>
								<option value="26">26</option>
								<option value="27">27</option>
								<option value="28">28</option>
								<option value="29">29</option>
								<option value="30">30</option>
								<option value="31">31</option>
						</select>&nbsp;&nbsp; Month: <select size="1" name="month">
								<option value="01">January</option>
								<option value="02">February</option>
								<option value="03">March</option>
								<option value="04">April</option>
								<option value="05">May</option>
								<option value="06">June</option>
								<option value="07">July</option>
								<option value="08">August</option>
								<option value="09">September</option>
								<option value="10">October</option>
								<option value="11">November</option>
								<option value="12">December</option>
						</select>&nbsp; Year: <select size="1" name="year">
								<option value="1960">1960</option>
								<option value="1961">1961</option>
								<option value="1962">1962</option>
								<option value="1963">1963</option>
								<option value="1964">1964</option>
								<option value="1965">1965</option>
								<option value="1966">1966</option>
								<option value="1967">1967</option>
								<option value="1968">1968</option>
								<option value="1969">1969</option>
								<option value="1970">1970</option>
								<option value="1971">1971</option>
								<option value="1972">1972</option>
								<option value="1973">1973</option>
								<option value="1974">1974</option>
								<option value="1975">1975</option>
								<option value="1976">1976</option>
								<option value="1977">1977</option>
								<option value="1978">1978</option>
								<option value="1979">1979</option>
								<option value="1980">1980</option>
								<option value="1981" selected="">1981</option>
								<option value="1982">1982</option>
								<option value="1983">1983</option>
								<option value="1984">1984</option>
								<option value="1985">1985</option>
								<option value="1986">1986</option>
								<option value="1987">1987</option>
								<option value="1988">1988</option>
								<option value="1989">1989</option>
								<option value="1990">1990</option>
								<option value="1991">1991</option>
								<option value="1992">1992</option>
								<option value="1993">1993</option>
								<option value="1994">1994</option>
								<option value="1995">1995</option>
								<option value="1996">1996</option>
								<option value="1997">1997</option>
								<option value="1998">1998</option>
								<option value="1999">1999</option>
								<option value="2000">2000</option>
								<option value="2001">2001</option>
								<option value="2002">2002</option>
						</select>
						</td>
					</tr>
					<tr>
						<td width="107"></td>
						<td width="462" colspan="3"></td>
					</tr>
					<tr>
						<td width="567" colspan="4"><br>
						<input type="checkbox" id="A4" name="law" style="cursor: hand">
							<span lang="ru">I've read the<a href="law.html">rules</a> of the game </span>MMCLUB<br> &nbsp;
						</td>
					</tr>
					<tr>
						<td width="72">
							<input type="submit" name="reg" value="Registration">
						</td>
					</tr>
				</tbody>
			</table>
		</form>

	</center>

</body>
</html>