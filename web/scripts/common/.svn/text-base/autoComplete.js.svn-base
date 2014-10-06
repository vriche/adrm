function AutoCompleteDB()
{
	// set the initial values.
	this.bEnd = false;
	this.nCount = 0;
	this.aStr = new Object;
	this.rowObj = new Object;
}


AutoCompleteDB.prototype.add = function(str,rowObj)
{
	// increment the count value.
	this.nCount++;

	// if at the end of the string, flag this node as an end point.
	if ( str == "" )
		this.bEnd = true;
	else
	{
		// otherwise, pull the first letter off the string
		var letter = str.substring(0,1);
		var rest = str.substring(1,str.length);
		

		// and either create a child node for it or reuse an old one.
		if ( !this.aStr[letter] ){
			this.aStr[letter] = new AutoCompleteDB();
			this.aStr[letter].rowObj = rowObj;
		}
			 
		this.aStr[letter].add(rest,rowObj);
		
	}
}



AutoCompleteDB.prototype.getCount = function(str, bExact)
{
	// if end of search string, return number
	if ( str == "" )
		if ( this.bEnd && bExact && (this.nCount == 1) ) return 0;
		else return this.nCount;
	
	// otherwise, pull the first letter off the string
	var letter = str.substring(0,1);
	var rest = str.substring(1,str.length);
	
	// and look for case-insensitive matches
	var nCount = 0;
	var lLetter = letter.toLowerCase();
	if ( this.aStr[lLetter] )
		nCount += this.aStr[lLetter].getCount(rest, bExact && (letter == lLetter));
	
	var uLetter = letter.toUpperCase();
	if ( this.aStr[uLetter] && lLetter !=uLetter)
		nCount += this.aStr[uLetter].getCount(rest, bExact && (letter == uLetter));
	
	return nCount;	
}

AutoCompleteDB.prototype.getStrings = function(str1, str2,rowObj)
{

	if ( str1 == "" )
	{
		// add matching strings to the array
		if ( this.bEnd ){
//			outStr.push(str2);
			rowObj.push(this.rowObj);			
		}


		// get strings for each child node
		for ( var i in this.aStr )
			this.aStr[i].getStrings(str1, str2 + i ,rowObj);
	}
	else
	{
		// pull the first letter off the string
		var letter = str1.substring(0,1);
		var rest = str1.substring(1,str1.length);
		
		// and get the case-insensitive matches.
		var lLetter = letter.toLowerCase();
		if ( this.aStr[lLetter] )
			this.aStr[lLetter].getStrings(rest, str2 + lLetter ,rowObj);

		var uLetter = letter.toUpperCase();
		if ( this.aStr[uLetter] && lLetter !=uLetter)
			this.aStr[uLetter].getStrings(rest, str2 + uLetter ,rowObj);
	}
}


function AutoComplete(aStr, oText, oDiv, nMaxSize,onDivMouseDown,onTextBlur,hidenColumName,indexColumName,allColumsName,allColumsTitle)
{
	// initialize member variables
	this.oText = oText;
	this.oDiv = oDiv;
	this.reposition(oText,oDiv);
	this.nMaxSize = nMaxSize;
	this.onDivMouseDown = onDivMouseDown;
	this.onTextBlur = onTextBlur;
	this.hidenColumName = hidenColumName;
	this.indexColumName = indexColumName;
	this.allColumsName = allColumsName;
	this.allColumsTitle = allColumsTitle;
	
	
	

	
	// preprocess the texts for fast access
	this.db = new AutoCompleteDB();
	var i, n = aStr.length;
	for ( i = 0; i < n; i++ )
	{
		var indexColumStr = this.getIndexColumStr(aStr[i]);
		if(indexColumStr !=""){
		   this.db.add(indexColumStr,aStr[i]);
		}
	}
			
	// attach handlers to the text-box
	oText.AutoComplete = this;
	oText.onkeyup = AutoComplete.prototype.onTextChange;
//	oText.onblur = AutoComplete.prototype.onTextBlur;
	oText.onblur = this.onTextBlur;
//	oText.onclick = AutoComplete.prototype.onTextChange;
	oText.ondblclick = AutoComplete.prototype.onTextChange;
	

}


//function AutoComplete(oText, oDiv,onDivMouseDown,onTextBlur,onTextChange)
//{
//	// initialize member variables
//	this.oText = oText;
//	this.oDiv = oDiv;
//	this.reposition(oText,oDiv);
//	this.onDivMouseDown = onDivMouseDown;
//	this.onTextBlur = onTextBlur;
//	
//	oText.AutoComplete = this;
//	oText.onkeyup = onTextChange;
//	oText.onblur = this.onTextBlur;
//	oText.ondblclick = onTextChange;
//}

AutoComplete.prototype.getColumStr = function(obj,columName){
	eval("var value=obj."+ columName);
//	var type = ( typeof  value);  
//	if(type == "boolean") value = "<input type=\"checkbox\" id=\"" + columName + "\" value=\""+ value +"\">"
    return value;
}

AutoComplete.prototype.getIndexColumStr = function(obj){
	var indexColumStr = "";
	for(var i = 0;i< this.indexColumName.length;i++){
		eval("var value=obj."+ this.indexColumName[i]);
		indexColumStr += null2empty(value);
	}
    return indexColumStr;
}

AutoComplete.prototype.isHidenColumName = function(columName){
	if(this.hidenColumName.indexOf(columName)> -1) return true;
}




//AutoComplete.prototype.onTextBlur = function()
//{
//	this.AutoComplete.onblur();
//}
//
//AutoComplete.prototype.onblur = function()
//{
//	this.oDiv.style.visibility = "hidden";
//}

AutoComplete.prototype.onTextChange = function()
{
	this.AutoComplete.onchange();
}

//AutoComplete.prototype.onDivMouseDown = function()
//{
//	this.AutoComplete.oText.value = this.innerHTML;
//}

AutoComplete.prototype.onDivMouseOver = function()
{
//	this.className = "AutoCompleteHighlight";

	this.style.backgroundColor = '#666666';
//	this.style.color = "#FFFFFF";
    highlightTableRow(this,"#FFFFFF");
	this.style.cursor = "pointer";
		
}

AutoComplete.prototype.onDivMouseOut = function()
{
//	this.className = "AutoCompleteBackground";
	this.style.backgroundColor='' ;
//	this.style.color="#000000" 
    highlightTableRow(this,"#000000");
	this.style.cursor = "default";
}


AutoComplete.prototype.onchange = function()
{
	var txt = this.oText.value;
//	this.reposition(this.oText,this.oDiv);
	
	// count the number of strings that match the text-box value
	var nCount = this.db.getCount(txt, true);
	
	
	// if a suitable number then show the popup-div
	if ( (this.nMaxSize == -1 ) || ((nCount < this.nMaxSize) && (nCount > 0)) )
	{
		// clear the popup-div.
		while ( this.oDiv.hasChildNodes() )
			this.oDiv.removeChild(this.oDiv.firstChild);
			
		// get all the matching strings from the AutoCompleteDB
//		var aStr = new Array();
		var rowObj = new Array();
		this.db.getStrings(txt, "",rowObj);
		
		// add each string to the popup-div
		var i, n = rowObj.length;
		
			
		
		var table = document.createElement('TABLE');
		
		if(!isUndefined(this.allColumsTitle)){
			var title = this.createTitle();
			table.appendChild(title);	
		}

			
		for ( i = 0; i < n; i++ )
		{   
			var tr = this.createRow(rowObj[i]);
			table.appendChild(tr);			
		}
		

		this.oDiv.appendChild(table);
		table.style.width =  (this.oDiv.scrollWidth) +"px";	
		this.oDiv.style.visibility = "visible";
		
	}
	else // hide the popup-div
	{
		this.oDiv.innerHTML = "";
		this.oDiv.style.visibility = "hidden";
	}
}

AutoComplete.prototype.createTitle = function(){
	var tr = document.createElement('tr');	
	var cls = this.allColumsTitle;
	for(var i = 0; i< cls.length;i++){
		var td = document.createElement('td');

		td.innerHTML  = cls[i];
		td.style.backgroundColor='#CCCCCC'
		tr.appendChild(td);			
	}
	return tr;
}



AutoComplete.prototype.createRow = function(rowObj){
	var tr = document.createElement('tr');
	tr.onmousedown = this.onDivMouseDown;
	tr.onmouseover = AutoComplete.prototype.onDivMouseOver;
	tr.onmouseout = AutoComplete.prototype.onDivMouseOut;
	tr.AutoComplete = this;

//	//create id colum
//	var td = document.createElement('td');
//	td.innerHTML  = this.getColumStr(rowObj,this.idColumName);
//	tr.appendChild(td);		
//	
//	//create Index  colum
//	var td = document.createElement('td');
//	td.innerHTML  = this.getColumStr(rowObj,this.indexColumName);
//	tr.appendChild(td);		
		

	//create other  colums
	var cls = this.allColumsName;
	
			
			
	var div = document.createElement('div');
    var cllls = this.allColumsTitle?this.allColumsTitle.length:1;
	var wd =  (this.oDiv.scrollWidth/cllls)+"px";	

	div.style.cssTex ="overflow:hidden;height:20px;width:"+ wd +";line-height:20px;";
			
			
	for(var i = 0; i< cls.length;i++){
		var td = document.createElement('td');
		if(this.isHidenColumName(cls[i])) td.style.display ="none";
		var value = this.getColumStr(rowObj,cls[i]);
		var type = (typeof  value);  

		if(type == "object"){
			td.obj  = value;
		}else{
			td.innerHTML  = value;	
//			td.innerHTML  = div.innerHTML + value +"</div>";	
		}

		tr.appendChild(td);			
	}

	return tr;
	
}




//AutoComplete.prototype.onchange = function()
//{
//	var txt = this.oText.value;
////	this.reposition(this.oText,this.oDiv);
//	
//	// count the number of strings that match the text-box value
//	var nCount = this.db.getCount(txt, true);
//	
//	// if a suitable number then show the popup-div
//	if ( (this.nMaxSize == -1 ) || ((nCount < this.nMaxSize) && (nCount > 0)) )
//	{
//		// clear the popup-div.
//		while ( this.oDiv.hasChildNodes() )
//			this.oDiv.removeChild(this.oDiv.firstChild);
//			
//		// get all the matching strings from the AutoCompleteDB
//		var aStr = new Array();
//		this.db.getStrings(txt, "", aStr);
//		
//		// add each string to the popup-div
//		var i, n = aStr.length;
//		for ( i = 0; i < n; i++ )
//		{
//			var oDiv = document.createElement('div');
//			this.oDiv.appendChild(oDiv);
//			oDiv.innerHTML = aStr[i];
//			oDiv.onmousedown = AutoComplete.prototype.onDivMouseDown;
//			oDiv.onmouseover = AutoComplete.prototype.onDivMouseOver;
//			oDiv.onmouseout = AutoComplete.prototype.onDivMouseOut;
//			oDiv.AutoComplete = this;			
//		}
//		this.oDiv.style.visibility = "visible";
//	}
//	else // hide the popup-div
//	{
//		this.oDiv.innerHTML = "";
//		this.oDiv.style.visibility = "hidden";
//	}
//}

AutoComplete.prototype.reposition = function(o,e){
	//width:180px;height:445px;
		
	var width = e.style.width;
	var heigth = e.style.height;
	if(width =="" || width == null ) width = o.offsetWidth;
	if(heigth =="" || heigth == null ) heigth = 200;
	e.style.width = width + "px";
	e.style.height = heigth +"px";;
}

