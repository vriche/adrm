/*
 * 带清空功能的 ComboBox
*/
Ext.form.ClearableComboBox = Ext.extend(Ext.form.ComboBox, {
 initComponent: function(){
	 Ext.form.ClearableComboBox.superclass.initComponent.call(this);
	 this.addEvents('clear');
	 
	 this.triggerConfig = {
	 tag:'span',
	 cls:'x-form-twin-triggers',
	 style:'padding-right:2px',
	 cn:[
	 {tag: "img", src: Ext.BLANK_IMAGE_URL, cls: "x-form-trigger"},
	 {tag: "img", src: Ext.BLANK_IMAGE_URL, cls: "x-form-trigger x-form-clear-trigger"}
	 ]
	 };
 },
// initList : function(){  
//        if((!this.tpl)&&(this.displayFields)){  // 展示多列  
//            var tplString = "" ;  
//            var cls = 'x-combo-list';   
//            var cbW = this.width || 150 ;         
//            var dfLen = this.displayFields.length ;  
//            var w = (cbW/dfLen).toFixed(2) ;              
//            var f = this.store.fields ;  
//            Ext.each(this.displayFields , function(name){  
//                name = f.containsKey(name) ? name : f.keys[name] ;  //列名或列号  
//                tplString += '<td width='+w+'>{'+name+'}</td>' ;  
//            },this);                      
//            this.tpl = new Ext.XTemplate(  
//                '<table><tpl for="."><tr class="'+cls+'-item" height="20px" >',  
//                    tplString,  
//                '</tr></tpl></table>'  
//            );  
//        }  
//
//         Ext.form.ClearableComboBox.superclass.initList.call(this);
//    },  
 

 getTrigger: function(index){
 return this.triggers[index];
 },

 initTrigger: function(){
 var ts = this.trigger.select('.x-form-trigger', true);
 this.wrap.setStyle('overflow', 'hidden');
 var triggerField = this;
 ts.each(function(t, all, index){
 t.hide = function(){
 var w = triggerField.wrap.getWidth();
 this.dom.style.display = 'none';
 triggerField.el.setWidth(w-triggerField.trigger.getWidth());
 };
 t.show = function(){
 var w = triggerField.wrap.getWidth();
 this.dom.style.display = '';
 triggerField.el.setWidth(w-triggerField.trigger.getWidth());
 };
 var triggerIndex = 'Trigger'+(index+1);

 if(this['hide'+triggerIndex]){
 t.dom.style.display = 'none';
 }
 t.on("click", this['on'+triggerIndex+'Click'], this, {preventDefault:true});
 t.addClassOnOver('x-form-trigger-over');
 t.addClassOnClick('x-form-trigger-click');
 }, this);
 this.triggers = ts.elements;
 },

 onTrigger1Click: function() {this.onTriggerClick()},
 onTrigger2Click: function() {this.clearValue(); this.fireEvent('clear', this)}
});

  Ext.reg('clearableComboBox', Ext.form.ClearableComboBox);