
<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="tools.calculator"/></title>




<script language="JavaScript">
<!--
function round(val)
{
	return(Math.round(val*10000000)/10000000);
}
PI = 3.141592654;
function pie()
{
	document.keypad.display.value = PI;
}
function MakeArray(n){
	this.length=n;
   	for(var i=1; i<=n; i++) this[i]=0;
   return this
}
link = new MakeArray(5);
function enter(num)
{
	document.keypad.display.value += num;
}
function calculate(sign)
{
	var temp = document.keypad.display.value * 1;
	document.keypad.display.value = "";
	document.keypad.list.value = temp;
	link[1] = temp;
	if (sign == "/") {link[2] = "/"; document.keypad.list.value += " / ";}
	if (sign == "*") {link[2] = "*"; document.keypad.list.value += " * ";}
	if (sign == "-") {link[2] = "-"; document.keypad.list.value += " - ";}
	if (sign == "+") {link[2] = "+"; document.keypad.list.value += " + ";}
	if (sign == "p") {link[2] = "p"; document.keypad.list.value += " ^ ";}
}

function power()
{
	temp = 1;
	n = link[3];
   	for(var i=1; i<=n; i++) temp *= link[1];
	return(temp);
}

function equal()
{
	if (link[2]) {
		if (document.keypad.display.value != "") {
			var temp = document.keypad.display.value * 1;
			document.keypad.list.value += temp;
			link[3] = temp;
			if (link[2] == "/") {res = link[1] / link[3]; document.keypad.display.value = round(res)}
			if (link[2] == "*") {res = link[1] * link[3]; document.keypad.display.value = round(res)}
			if (link[2] == "-") {res = link[1] - link[3]; document.keypad.display.value = round(res)}
			if (link[2] == "+") {res = link[1] + link[3]; document.keypad.display.value = round(res)}
			if (link[2] == "p") {document.keypad.display.value = round( power() )}
			link[1]=0; link[2]=0; link[3]=0;
		}
	}
}



function calc(code)

{

	var temp = document.keypad.display.value * 1;



	if (code == 1) {temp1 = Math.sin(temp*PI/180); document.keypad.list.value = "sin "}

	if (code == 2) {temp1 = Math.cos(temp*PI/180); document.keypad.list.value = "cos "}

	if (code == 3) {temp1 = Math.tan(temp*PI/180); document.keypad.list.value = "tan "}

	if (code == 4) {temp1 = Math.sqrt(temp); document.keypad.list.value = "sqrt "}

	if (code == 5) {temp1 = Math.log(temp); document.keypad.list.value = "ln "}

	if (code == 6) {temp1 = 1/temp; document.keypad.list.value = "1/x, x="}

	if (code == 7) {temp1 = temp * temp; document.keypad.list.value = "x*x, x="}



	document.keypad.list.value += temp;

	document.keypad.display.value = round(temp1);

}



function fsolve()

{

	var a = document.keypad.c1.value*1;

	var b = document.keypad.c2.value*1;

	var c = document.keypad.c3.value*1;



	if (a==0) {document.keypad.list.value = "<fmt:message key="calculator.notTwo"/>";

		     document.keypad.display.value = "<fmt:message key="calculator.same"/>"}

	else { x1 = (b*b-4*a*c);

		if ( x1 < 0) {document.keypad.list.value = "<fmt:message key="calculator.notTrue"/>";

				  temp = (Math.sqrt(Math.abs(x1)))/(2*a);

				  x2 = round(-b/(2*a)) + "+/- " + round(temp) + "i";

				  document.keypad.display.value = x2}

		else {

			var x1 = (-b + Math.sqrt(b*b-4*a*c)) / (2*a);

			var x2 = (-b - Math.sqrt(b*b-4*a*c)) / (2*a);



			document.keypad.list.value = "x1 = " + round(x1);

			document.keypad.display.value = "x2 = " + round(x2);

		}

	}

}



function change()

{

	var temp = document.keypad.display.value;



	if (temp.substring(0,1) == "-") {document.keypad.list.value = "";

						   document.keypad.display.value = 0 - document.keypad.display.value * 1}

	if (temp.substring(0,1) != "-") {document.keypad.list.value = "";

						   document.keypad.display.value = "-" + temp.substring(0,temp.length)}

}



function eraser()

{

	document.keypad.list.value = "<fmt:message key="calculator.beginIn"/>!";

	document.keypad.display.value = "";

	document.keypad.c1.value = "";

	document.keypad.c2.value = "";

	document.keypad.c3.value = "";

	link[1]=0; link[2]=0; link[3]=0;

}



function backer()

{

	var temp = document.keypad.display.value;

	document.keypad.display.value = temp.substring(0,temp.length*1 -1);

}



var memory = 0;

function mem(val)

{

	if (val == 1 ) {document.keypad.list.value = "--> Memory In";

			    memory = document.keypad.display.value * 1}

	if (val == -1) {document.keypad.display.value = memory}

	if (val == 0 ) {document.keypad.list.value = "Memory Erased";

			    document.keypad.display.value = ""; memory = 0}

}



function message()

{

alert('\n\n请联系您的程序提供商!');

}



function travel(link)

{

window.open(link,"calculator","toolbar=1,location=1,status=1,scrollbars=1,directories=1,copyhistory=1,menubar=1,resizable=1")

}



var screen=" ";

function eraser2()

{

	var ans = confirm('\nDo you want to clear the entire CALCpad?\n');

	if (ans) {screen = document.notes.junk.value; document.notes.junk.value = "";}

}



function copy()

{

document.notes.junk.value = document.keypad.list.value+"\n"+document.keypad.display.value+"\n"+document.notes.junk.value;

}



function help()

{

	screen = document.notes.junk.value;

	msg1 = "Following are some of the\ncalculator functions:\n";

	msg2 = "\n(<-> M) - Erase Memory Contents\n(--> M) - Memory In\n(<-- M) - Memory Out";

	msg3 = "\n(<--)   - Erase last character\n(x^y)   - X to the power of Y";

	msg4 = "\n\nTo Go Back, click 'Restore CALCpad'";

	document.notes.junk.value = "";

	document.notes.junk.value = msg1 + msg2 + msg3 + msg4;

}



function restore()

{

	document.notes.junk.value = "";

	document.notes.junk.value = screen;	

}

</script>



<table width="100%" cellpadding="0" cellspacing="0">
  <tr> 
    <td align="center">

        <table width="100%" border="0">
          <tr>
            <td><form name="keypad">
                <table border=6 cellspacing=2 cellpadding=3 align="center" height="100%">
                  <tr bgcolor="#999999"> 
                    <td colspan=9 align=center valign=middle> <font size=4 color="#000000"><b><fmt:message key="tools.calculator"/>
                    </b></font></td>
                  </tr>
                  <tr> 
                    <td valign=middle align=center colspan=6> <input type="text" name="list" size=22 value="<fmt:message key="calculator.beginIn"/>"> 
                    </td>
                    <td valign=middle align=center colspan=3> <input type="button" name="alex" value="<fmt:message key="calculator.clear"/>" onClick="eraser()"> 
                    </td>
                  </tr>
                  <tr> 
                    <td valign=middle align=center colspan=6> <input type="text" name="display" size=22 value=""> 
                    </td>
                    <td valign=middle align=center colspan=2> <input type="button" name="alex" value="       =      " onClick="equal()"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="  <--  " onClick="backer()"> 
                    </td>
                  </tr>
                  <tr> 
                    <td valign=middle align=center> <input type="button" name="alex" value="  1  " onClick="enter(1)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="  2  " onClick="enter(2)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="  3  " onClick="enter(3)"> 
                    </td>
                    <td></td>
                    <td valign=middle align=center> <input type="button" name="alex" value="   /   " onClick="calculate('/')"> 
                    </td>
                    <td></td>
                    <td valign=middle align=center> <input type="button" name="alex" value=" sin " onClick="calc(1)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value=" x&#189; " onClick="calc(4)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="<->M" onClick="mem(0)"> 
                    </td>
                  </tr>
                  <tr> 
                    <td valign=middle align=center> <input type="button" name="alex" value="  4  " onClick="enter(4)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="  5  " onClick="enter(5)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="  6  " onClick="enter(6)"> 
                    </td>
                    <td></td>
                    <td valign=middle align=center> <input type="button" name="alex" value="   *   " onClick="calculate('*')"> 
                    </td>
                    <td></td>
                    <td valign=middle align=center> <input type="button" name="alex" value="cos" onClick="calc(2)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="  x&#178; " onClick="calc(7)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="--> M" onClick="mem(1)"> 
                    </td>
                  </tr>
                  <tr> 
                    <td valign=middle align=center> <input type="button" name="alex" value="  7  " onClick="enter(7)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="  8  " onClick="enter(8)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="  9  " onClick="enter(9)"> 
                    </td>
                    <td></td>
                    <td valign=middle align=center> <input type="button" name="alex" value="   -   " onClick="calculate('-')"> 
                    </td>
                    <td></td>
                    <td valign=middle align=center> <input type="button" name="alex" value="tan " onClick="calc(3)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="1/x " onClick="calc(6)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="<-- M" onClick="mem(-1)"> 
                    </td>
                  </tr>
                  <tr> 
                    <td valign=middle align=center> <input type="button" name="alex" value="  0  " onClick="enter(0)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value="dot" onClick="enter('.')"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value=" +|- " onClick="change()"> 
                    </td>
                    <td></td>
                    <td valign=middle align=center> <input type="button" name="alex" value="  +   " onClick="calculate('+')"> 
                    </td>
                    <td></td>
                    <td valign=middle align=center> <input type="button" name="alex" value="  pi " onClick="pie()"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value=" Ln " onClick="calc(5)"> 
                    </td>
                    <td valign=middle align=center> <input type="button" name="alex" value=" x^y  " onClick="calculate('p')"> 
                    </td>
                  </tr>
                  <tr> 
                  <tr> 
                    <td valign=middle align=center colspan=9></td>
                  </tr>
                  <tr> 
                    <td valign=middle align=center colspan=9> <input type="text" name="c1" size=4 value=""> 
                      &nbsp;*X&#178;&nbsp;+&nbsp; <input type="text" name="c2" size=4 value=""> 
                      &nbsp;*X&nbsp;+&nbsp; <input type="text" name="c3" size=4 value=""> 
                      &nbsp;=&nbsp;0&nbsp; <input type="button" name="alex" value="<fmt:message key="calculator.beginResult"/>" onClick="fsolve()"> 
                    </td>
                  </tr>
                </table>
              </form></td>
          </tr>
        </table>
	</td>
  </tr>
</table>

            