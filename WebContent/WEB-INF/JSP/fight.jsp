<%@ page language="java" contentType="text/html; charset=windows-1251" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>This is test</title>

<SCRIPT>
//-- Stats pers 1

var Strength1 = 10;
var Intelligence1 = 2;
var Personality1 = 2;
var Endurance1 = 10; 
var Accuracy1 = 10;
var Luck1 = 0; 
var Speed1 = 15;

var uvorot1 = Speed1*2.5+Luck1;
var antiuvorot1 = Speed1*2+Luck1;
var krit1 = Accuracy1*1.5+Luck1;
var antikrit1 = Accuracy1*2.2+Luck1;

//-- Stats pers  2
var Strength2 = 10;
var Intelligence2 = 9;
var Personality2 = 5;
var Endurance2 = 15; 
var Accuracy2 = 15;
var Luck2 = 0; 
var Speed2 = 10;

var uvorot2 = Speed2*2.5+Luck2;
var antiuvorot2 = Speed2*2+Luck2;
var krit2 = Accuracy2*1.5+Luck2;
var antikrit2 = Accuracy2*2.2+Luck2;

var s_attack1, s_attack2, s_defend1, s_defend2;

//-- Change of the hitpoints
var redHP = 0.33;	// lower 30% red color
var yellowHP = 0.66;// lower 60% yellow color, otherwise green
var tkHP1, maxHP1;
var tkHP2, maxHP2;

function set_HP(value, max){
  document.all("stat1").innerHTML="Str: "+Strength1+"<BR>Intellect: "+Intelligence1+"<BR>Personality: "+Personality1+"<BR>Endu: "+Endurance1+"<BR>Accuracy: "+Accuracy1+"<BR>Luck: "+Luck1+"<BR>Speed: "+Speed1;
  document.all("stat2").innerHTML="Str: "+Strength2+"<BR>Intellect: "+Intelligence2+"<BR>Personality: "+Personality2+"<BR>Endu: "+Endurance2+"<BR>Accuracy: "+Accuracy2+"<BR>Luck: "+Luck2+"<BR>Speed: "+Speed2;
  setHP1(value, max);
  setHP2(value, max);
}

function setHP1(value, max) { //HP bar  character 1
	tkHP1=value; maxHP1=max;
	if (tkHP1>maxHP1) { tkHP1=maxHP1; }

	var sz11 = Math.round((149/maxHP1)*tkHP1);
	var sz12 = 150 - sz11;

	if (document.all("HP1")) {
		document.HP11.width=sz11;
		document.HP12.width=sz12;
		if (tkHP1/maxHP1 < redHP) { document.HP11.src='1red.gif'; }
		else {
			if (tkHP1/maxHP1 < yellowHP) { document.HP11.src='1yellow.gif'; }
			else { document.HP11.src='1green.gif'; }
		}
		var s = document.all("HP1").innerHTML;
		document.all("HP1").innerHTML = s.substring(0, s.lastIndexOf(':')+1) + Math.round(tkHP1)+"/"+maxHP1;
	}
}

function setHP2(value, max) { //HP bar character 2
	tkHP2=value; maxHP2=max;
	if (tkHP2>maxHP1) { tkHP2=maxHP1; }

	var sz21 = Math.round((149/maxHP2)*tkHP2);
	var sz22 = 150 - sz21;

	if (document.all("HP2")) {
		document.HP21.width=sz21;
		document.HP22.width=sz22;
		if (tkHP2/maxHP2 < redHP) { document.HP21.src='1red.gif'; }
		else {
			if (tkHP2/maxHP2 < yellowHP) { document.HP21.src='1yellow.gif'; }
			else { document.HP21.src='1green.gif'; }
		}
		var s = document.all("HP2").innerHTML;
		document.all("HP2").innerHTML = s.substring(0, s.lastIndexOf(':')+1) + Math.round(tkHP2)+"/"+maxHP2;
	}
}

function setDamage(){
  // we'll see who hitted where, and are there blocked places?
var lHit1=false;
var lHit2=false;
var povreduha = 0;
var krittrue1=false;
var krittrue2=false;
var uvorottrue1=false;
var uvorottrue2=false;

  document.all("mes").innerHTML="";

//////////// First one hits
//////////// Avoiding the hit
 var minU2 = Math.round(uvorot2/3);
 var maxU2 = uvorot2;
 var minAU1 = antiuvorot1-Math.round(antiuvorot1/3);
 var maxAU1 = antiuvorot1;
 var realU2 = getRandom(minU2,maxU2);
 var realAU1 = getRandom(minAU1,maxAU1);

 if (realU2 > realAU1)
 {
    uvorottrue2 = true;
    document.all("mes").innerHTML="Pers2 avoid the attack!<BR>";
    lHit1=false;
 }
 
//////////// Critical
 var minK1 = Math.round(krit1/3);
 var maxK1 = krit1;
 var minAK2 = antikrit2-Math.round(antikrit2/3);
 var maxAK2 = antikrit2;
 var realK1 = getRandom(minK1,maxK1);
 var realAK2 = getRandom(minAK2,maxAK2);

 if (realK1 > realAK2)
 {
    krittrue1 = true;
    lHit1=false;
 }


  // algoritm to hit the second opponent
  if (krittrue1){
     var maxblow = Math.round((Strength1-1)/3)+3;
     var minblow = Math.round(maxblow/2);
     povreduha = getRandom(minblow*2,maxblow*2);
     tkHP2 = tkHP2 - povreduha;
     document.all("mes").innerHTML="Pers2 got critical hit from the opponent!!! <font color='red'>-"+povreduha+"</font><BR>";
  } else {
    if(!uvorottrue2) {
       var maxblow = Math.round((Strength1-1)/3)+3;
       var minblow = Math.round(maxblow/2);
       povreduha = getRandom(minblow,maxblow);
       tkHP2 = tkHP2 - povreduha;
    }
  }


//////////// Block
if ((!uvorottrue2) && (!krittrue1))
{
  if (s_attack1==1)
  { 
     if((s_defend2==1) || (s_defend2==4)){ 
        document.all("mes").innerHTML="Pers2 Blocked the punch in the Head<BR>";
        lHit1=false;
     }else{
        document.all("mes").innerHTML="Pers2 Got punched in the head -"+povreduha+"<BR>";
        lHit1=true;
     }
  }
  if (s_attack1==2){ 
     if((s_defend2==1) || (s_defend2==2)){ 
        document.all("mes").innerHTML="Pers2 Blocked the punch in the chest<BR>";
        lHit1=false;
     }else{
        document.all("mes").innerHTML="Pers2 Got punched in the chest -"+povreduha+"<BR>";
        lHit1=true;
     }
  }
  if (s_attack1==3){ 
     if((s_defend2==2) || (s_defend2==3)){ 
        document.all("mes").innerHTML="Pers2 Blocked the hit to the belt<BR>";
        lHit1=false;
     }else{
        document.all("mes").innerHTML="Pers2 Got hit in the belt place -"+povreduha+"<BR>";
        lHit1=true;
     }
  }
  if (s_attack1==4){ 
     if((s_defend2==3) || (s_defend2==4)){ 
        document.all("mes").innerHTML="Pers2 Blocked a hit to the legs<BR>";
        lHit1=false;
     }else{
        document.all("mes").innerHTML="Pers2 Got a punch to the legs -"+povreduha+"<BR>";
        lHit1=true;
     }
  }
}


  var S = document.all("mes").innerHTML;

/////////// Second opponent hitting
//////////// First one avoiding the hit?
 var minU1 = Math.round(uvorot1/3);
 var maxU1 = uvorot1;
 var minAU2 = antiuvorot2-Math.round(antiuvorot2/3);
 var maxAU2 = antiuvorot2;
 var realU1 = getRandom(minU1,maxU1);
 var realAU2 = getRandom(minAU2,maxAU2);

 if (realU1 > realAU2)
 {
    uvorottrue1 = true;
    document.all("mes").innerHTML=S+"Pers1 Avoided the hit!<BR>";
    lHit2=false;
 }
 
////////////  Critical strike on the frist opponent?
 var minK2 = Math.round(krit2/3);
 var maxK2 = krit2;
 var minAK1 = antikrit1-Math.round(antikrit1/3);
 var maxAK1 = antikrit1;
 var realK2 = getRandom(minK2,maxK2);
 var realAK1 = getRandom(minAK1,maxAK1);

 if (realAK1 < realK2)
 {
    krittrue2 = true;
    lHit2=false;                           
 }



  // Algoritm to the damage on the first character
  if (krittrue2){
     var maxblow = Math.round((Strength2-1)/3)+3;
     var minblow = Math.round(maxblow/2);
     povreduha = getRandom(minblow*2,maxblow*2);
     tkHP1 = tkHP1 - povreduha;
     document.all("mes").innerHTML=S+"Pers1 hot hit by critical strike!!! <font color='red'>-"+povreduha+"</font><BR>";
  } else{ 
    if(!uvorottrue1) {
       var maxblow = Math.round((Strength2-1)/3)+3;
       var minblow = Math.round(maxblow/2);
       povreduha = getRandom(minblow,maxblow);
       tkHP1 = tkHP1 - povreduha; 
    }
  }


////////////Block
if ((!uvorottrue1) && (!krittrue2))
{
  if (s_attack2==1)
  { 
     if((s_defend1==1) || (s_defend1==4)){ 
        document.all("mes").innerHTML=S+"Pers1 Blocked the hit to the head<BR>";
        lHit2=false;
     }else{
        document.all("mes").innerHTML=S+"Pers1 got hit to the head -"+povreduha+"<BR>";
        lHit2=true;
     }
  }
  if (s_attack2==2)
  { 
     if((s_defend1==1) || (s_defend1==2)){ 
        document.all("mes").innerHTML=S+"Pers1 Blocked the hit to the chest<BR>";
        lHit2=false;
     }else{
        document.all("mes").innerHTML=S+"Pers1 got hit to the chest -"+povreduha+"<BR>";
        lHit2=true;
     }
  }
  if (s_attack2==3)
  { 
     if((s_defend1==2) || (s_defend1==3)){ 
        document.all("mes").innerHTML=S+"Pers1 Blocked the hit to the belt<BR>";
        lHit2=false;
     }else{
        document.all("mes").innerHTML=S+"Pers1 got hit to the belt -"+povreduha+"<BR>";
        lHit2=true;
     }
  }
  if (s_attack2==4)
  { 
     if((s_defend1==3) || (s_defend1==4)){ 
        document.all("mes").innerHTML=S+"Pers1 Blocked the hit to the belt<BR>";
        lHit2=false;
     }else{
        document.all("mes").innerHTML=S+"Pers1 got hit to the to the legs -"+povreduha+"<BR>";
        lHit2=true;
     }
  }
}
  
  if (tkHP1 <= 0){
    tkHP1 = 0;
    alert("Pers1 killed!!! Winner is Pers2");
  } 
  if (tkHP2 <= 0){
    tkHP2 = 0;
    alert("Pers2 killed !!! Winner is Pers1");
  } 

S = document.all("mes").innerHTML+"<br>";
document.all("mes").innerHTML = S+"U1:"+realU1+" AU1:"+realAU1+" K1:"+realK1+" AK1:"+realAK1+" U2:"+realU2+" AU2:"+realAU2+" K2:"+realK2+" AK2:"+realAK2;


  // We'll show here who got how much damage dealed 
  setHP1(tkHP1, 60);
  setHP2(tkHP2, 60);
}

function setattack1(a){
  s_attack1 = a;
}
function setattack2(a){
  s_attack2 = a;

}
function setdefend1(d){
  s_defend1 = d;
}
function setdefend2(d){
  s_defend2 = d;
}

function getRandom(iMin, iMax) {   
var retV = Math.round(Math.random()*iMax);
if (retV < iMin) retV = iMin;  
return retV;
}


</SCRIPT>


</head>

<body bgcolor="#76C5F0" onLoad="set_HP(60, 60)">

<div align="center">
  <center>
  <table border="1" cellpadding="0" cellspacing="0" width="878" height="51" bordercolor="#0000FF">
    <tr>
      <td width="248" height="10">
        Pers1</td>
      <td width="396" height="10" colspan="4"></td>
      <td width="233" height="10" bgcolor="#C0C0C0">

   Pers2</td>
    </tr>
    <tr>
      <td width="248" height="229" rowspan="5">
   <table cellspacing=0 cellpadding=0 border="0" bordercolor="#000080"><tr><td>

   <NOBR><div id=HP1>
	<IMG SRC=1silver.gif WIDTH=1 HEIGHT=10 ALT="Health points" name=HP11><IMG SRC=1silver.gif WIDTH=1 HEIGHT=10 ALT="Health points" name=HP12>:</div>
   </nobr>
	</table>
	<!--  End of section-->



        <p>&nbsp;</td>
      <td width="396" height="54" valign="top" colspan="4"></td>
      <td width="233" height="229" rowspan="5" bgcolor="#C0C0C0">

   <!--  Hp bar of the second character -->
   <table cellspacing=0 cellpadding=0 border="0" bordercolor="#000080"><tr><td>
   <NOBR><div id=HP2>
	 <IMG SRC=1silver.gif WIDTH=1 HEIGHT=10 ALT="Health points" name=HP21><IMG SRC=1silver.gif WIDTH=1 HEIGHT=10 ALT="Health points" name=HP22>:</div>
   </nobr>
	</table>
	<!--  End of the section -->


        <p>&nbsp;</td>
    </tr>
        <form name="form1" method="POST" action="--WEBBOT-SELF--">

    <tr>
      <td width="77" height="15" valign="top" bordercolor="#0000FF">Attack</td>
      <td width="117" height="15" valign="top" bordercolor="#0000FF">Block</td>
      <td width="89" height="15" valign="top" bordercolor="#0000FF" bgcolor="#C0C0C0">Attack</td>
      <td width="105" height="15" valign="top" bordercolor="#0000FF" bgcolor="#C0C0C0">Block</td>
    </tr>

    <tr>
      <td width="76" height="156" valign="top" bordercolor="#0000FF">
          <p><font size="2"><input type="radio" id=A11 name="attack1" value="1" onclick="setattack1(1)">head<br>
          <input type="radio" id=A12 name="attack1" value="2" onclick="setattack1(2)">chest<br>
          <input type="radio" id=A13 name="attack1" value="3" onclick="setattack1(3)">belt<br>
          <input type="radio" id=A14 name="attack1" value="4" onclick="setattack1(4)">legs<br>
          </font>
          </p>
        <p><font size="2">&nbsp;</font></td>
      <td width="115" height="156" valign="top" bordercolor="#0000FF">
      <font size="2">
      <input type="radio" id=D11 name="defend1" value="1" onclick="setdefend1(1)"> head and chest<br>
      <input type="radio" id=D12 name="defend1" value="2" onclick="setdefend1(2)">chest and belt<br>
      <input type="radio" id=D13 name="defend1" value="3" onclick="setdefend1(3)">belt and legs<br>
      <input type="radio" id=D14 name="defend1" value="4" onclick="setdefend1(4)">legs and head</font>
      <p>&nbsp;
      </td>
      <td width="88" height="156" valign="top" bordercolor="#0000FF" bgcolor="#C0C0C0">
          <p><font size="2"><input type="radio" id=A21 name="attack2" value="1" onclick="setattack2(1)">head<br>
          <input type="radio" id=A22 name="attack2" value="2" onclick="setattack2(2)">chest<br>
          <input type="radio" id=A23 name="attack2" value="3" onclick="setattack2(3)">belt<br>
          <input type="radio" id=A24 name="attack2" value="4" onclick="setattack2(4)">legs<br>
          </font>
          </p>
        <p><font size="2">&nbsp;</font></td>
      <td width="103" height="156" valign="top" bordercolor="#0000FF" bgcolor="#C0C0C0">
      <font size="2">
      <input type="radio" id=D21 name="defend2" value="1" onclick="setdefend2(1)">head and chest<br>
      <input type="radio" id=D22 name="defend2" value="2" onclick="setdefend2(2)">chest and belt<br>
      <input type="radio" id=D23 name="defend2" value="3" onclick="setdefend2(3)">belt and legs<br>
      <input type="radio" id=D24 name="defend2" value="4" onclick="setdefend2(4)">legs and head</font>
      <p>&nbsp;
      </td>
    </tr>
    <tr>
      <td width="396" height="26" valign="top" colspan="4">
          <p align="center">
          <input type="button" name="Forward" value="Вперед" onClick="setDamage()"> 
          </p>
      </td>
    </tr>
    </form>
    <tr>
      <td width="396" height="51" valign="top" colspan="4"></td>
    </tr>
    <tr>
      <td width="248" height="73">
      <div id="stat1"></div>
      </td>
      <td width="396" height="51" valign="top" colspan="4">
   
 
      Result:
      <div id="mes">
      </div>
 
      </td>
      <td width="233" height="73" bgcolor="#C0C0C0">
      <div id="stat2"></div>
   &nbsp;</td>
    </tr>
  </table>
  </center>
</div>

</body>

</html>
