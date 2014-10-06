/*
Copyright Scand LLC http://www.scbr.com
To use this component please contact info@scbr.com to obtain license

*/ 
 

dhtmlXTreeObject.prototype.enableItemEditor=function(state){
 this._eItEd=convertStringToBoolean(state);
 if(!this._eItEdFlag){
 var self=this;

 this._ie_aFunc=this.aFunc;
 this._ie_dblclickFuncHandler=this.dblclickFuncHandler;

 this.dblclickFuncHandler=function(a,b){self._editItem(a,b);};
 this.aFunc=function(a,b){self._stopEditItem(a,b);};

 this.setOnClickHandler=this.__setOnClickHandler;
 this.setOnDblClickHandler=this.__setOnDblClickHandler;
 this._eItEdFlag=true;

}
};


dhtmlXTreeObject.prototype.setOnItemTextChange=function(func){
 if(typeof(func)=="function")this._onITCFunc=func;else this._onITCFunc=eval(func);
};

dhtmlXTreeObject.prototype._stopEdit=function(a){
 if(this._editCell){
 if(this._editCell.id!=a){
 this._editCell.span.innerHTML=this._editCell.span.childNodes[0].value;
 this._editCell.span.className="standartTreeRow";
 temp.span.onclick=function(){};
 if(this._onITCFunc)this._onITCFunc(this._editCell.id,this,this._editCell.span.innerHTML);
 this._editCell=null;
}
}
}

dhtmlXTreeObject.prototype._stopEditItem=function(id,tree){
 this._stopEdit(id);
 if(this._ie_aFunc)this._ie_aFunc(id,tree);
};

dhtmlXTreeObject.prototype._editItem=function(id,tree){
 if(this._eItEd){
 this._stopEdit();
 temp=this._globalIdStorageFind(id);
 this._editCell=temp;
 temp.span.innerHTML="<input type='text' class='intreeeditRow' value='"+temp.span.innerHTML+"'/>";
 temp.span.childNodes[0].focus();
 temp.span.onclick=function(e){(e||event).cancelBubble=true;return false;};
 temp.span.className="standartTreeRow";
 var self=this;
 temp.span.childNodes[0].onkeypress=function(e){
 if(!e)e=window.event;
 if(e.keyCode==13)
 self._stopEdit(-1);
}
}
 else
 if(this._ie_dblclickFuncHandler)this._ie_dblclickFuncHandler(id,tree);
};



dhtmlXTreeObject.prototype.__setOnDblClickHandler=function(func){
 if(typeof(func)=="function")this._ie_dblclickFuncHandler=func;else this._ie_dblclickFuncHandler=eval(func);
};

dhtmlXTreeObject.prototype.__setOnClickHandler=function(func){
 if(typeof(func)=="function")this._ie_aFunc=func;else this._ie_aFunc=eval(func);
};


