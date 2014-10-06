    
/*    
    
    使用例子：
var cm = new Ext.grid.ColumnModel([  
  {header:'编号',dataIndex:'id',menuDisabled:true},  
  {header:'性别',dataIndex:'name',menuDisabled:true},  
  {header:'名称',dataIndex:'descn',menuDisabled:true},  
  {header:'描述',dataIndex:'date',menuDisabled:true}  
 ]); 
    
    
 var store = new Ext.data.Store({  
        proxy: new Ext.data.HttpProxy({url:'js/8.jsp'}),  
        reader: new Ext.data.JsonReader({  
            totalProperty: 'totalCount',  
            root: 'items',  
            id:id  
        }, [  
          {name: 'id', type: 'int'},  
          {name: 'name', type: 'string'},  
          {name: 'descn', type: 'string'},  
          {name: 'date', type: 'string'}  
        ]),  
        baseParams:{  
         start:0,limit:10  
        }  
    });   
          
      var c = new Ext.form.ComboBox({  
    typeAhead : true,  
    fieldLabel : '名称',  
    hiddenName : 'id',  
    triggerAction : 'all',  
    lazyRender : true,  
    width:300,  
    displayField:'name',  
    valueField:'id',  
    store:store,  
    mode : 'local',  
    listClass : 'x-combo-list-small',  
    selectedClass:'',   
    allowBlank : false,  
    emptyText:'请选择...',  
    cm:cm,  
    onSelect:function(record,rowIndex){  
     c.setValue(record.get("id"));  
     c.setRawValue(record.get("name"));  
    },  
    plugins : [new Ext.plugins.GridCombox()]  
   });      
    
    
 <%  
String start = request.getParameter("start");  
String limit = request.getParameter("limit");  
try {  
    int index = Integer.parseInt(start);  
    int pageSize = Integer.parseInt(limit);  
  
    String json = "{totalCount:100,items:[";  
  
        for (int i = index; i < pageSize + index; i++) {  
            json += "{id:" + i + ",name:'name" + i + "',descn:'descn" + i + "',date:'2010-01-01'}";  
            if (i != pageSize + index - 1) {  
                json += ",";  
            }  
        }  
    json += "]}";  
    response.getWriter().write(json);  
    System.out.println(json);  
} catch(Exception ex) {  
}  
%>    
    
*/
    
    
    
    Ext.ns("Ext.plugins.GridCombox");  
	
		 
    Ext.plugins.GridCombox = function(a) {  
     this.config = Ext.apply({  
        width : 320,  
        height : 350  
       }, a);  
 
    };  
 

    
    Ext.extend(Ext.plugins.GridCombox, Ext.util.Observable, {  
     init : function(b) {  
      Ext.apply(b, {  
       initList : b.initList.createInterceptor((function(d) {  
          return function() {  
           if(!this.list){  
            var cls = 'x-combo-list';  
                     this.list = new Ext.Layer({shadow:this.shadow, constrain:true, shim:true});  
                     var lw = this.listWidth || Math.max(this.wrap.getWidth(), this.minListWidth);  
                     this.list.setWidth(lw);  
                     this.list.swallowEvent('mousewheel');  
                     this.assetHeight = 0;  
                       
                     if(this.title){  
                         this.header = this.list.createChild({cls:cls+'-hd', html: this.title});  
                         this.assetHeight += this.header.getHeight();  
                     }  
                       
                     this.innerList = this.list.createChild({cls:cls+'-inner'});  
                     this.innerList.setWidth(lw - this.list.getFrameWidth('lr'));  

                        
                      this.grid = new Ext.grid.GridPanel({  
                      	id:b.gridId,
                      	name:b.gridId,
							             border:true,  
							        				collapsible: false,   
																loadMask: true ,  
							            	autoScroll:true,  
							             width : this.listWidth || Math.max(this.wrap.getWidth(), this.minListWidth),  
							             height : 250,  
							             store : b.store,  
							             cm : b.cm,
							             sm:b.sm?b.sm:null,
							             tbar:b.tbar?b.tbar:null,
							             plugins:b.filters?b.filters:[],
																bbar:b.paging?new Ext.PagingToolbar({  
																                       id:'PagingToolbar',  
																                       pageSize: b.pageSize || 20,  
																                       store:b.store,  
																                       displayInfo: false  
																                   				}) :[]
           														 });  

            
            
            
            this.grid.render(this.innerList);  
            this.innerList.appendChild(this.grid.getEl());  
            
            
            
            if(b.hideOnSelect){
			            this.grid.on("rowclick", function (g, rowIndex, e) {  
			             var record = b.store.getAt(rowIndex);  
			             this.onSelect(record, rowIndex);  
			             this.collapse();  
			             if (!b.trigger) {  
			              this.focus();  
			             						}  
			            }, this);  
           						 }
//								this.grid.on('rowclick', function(grid, rowIndex, e) {  
//                var r = b.store.getAt(rowIndex);  
//                var me = this;
//                if(me.fireEvent('beforeselect', me, r, rowIndex) !== false){  
//                    me.setValue(r.data[me.valueField || me.displayField]);  
//                    me.collapse();  
//                    me.fireEvent('select', me, r, rowIndex);  } 
//                 },this);
            
            


            
           }  
           return false;  
          }  
         })(this.config), b),  
       onRender : b.onRender.createSequence(function() {  
          if (!this.lazyInit) {  
           this.initList();  
          } else {  
           this.on("focus", this.initList, this, {  
              single : true  
             });  
          }  
         }, b),  
       onTriggerClick : b.onTriggerClick.createInterceptor((function(d) {  
          return function() {  
           if (!this.disabled) {  
            if (this.isExpanded()) {  
             this.collapse();  
             this.el.focus();  
            } else {  
             this.onFocus({});  
             this.expand();  
             this.store.load();//点击时 grid的store加载数据  
            }  
           }  
           return false;  
          };  
         })(this.config), b),  
       expand : b.expand.createInterceptor((function(d) {  
          return function() {  
           if (this.isExpanded()) {  
            return;  
           }  
      
           this.list.alignTo(this.wrap, this.listAlign);  
           this.list.show();  
           if (Ext.isGecko2) {  
            this.innerList.setOverflow('auto'); // necessary  
           }  
           Ext.getDoc().on('mousewheel', this.collapseIf, this);  
            if(b.hideOnSelect){
									Ext.getDoc().on('mousedown', this.collapseIf, this);  
            					}

           this.fireEvent('expand', this);  
          };  
         })(this.config), b)  
      });  
     }  
    });  