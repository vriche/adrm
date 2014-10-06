/**
 * Ext.ux.ActionGridPanel
 *
 * @author  zhangle zhangle2006@gmail.com
 * @version $Id: Ext.ux.ActionGridPanel.js 001 2008-08-23 08:42:48$
 * @date    24. March 2008
 *
 * @license Ext.ux.ActionGridPanel is licensed under the terms of
 * the Open Source LGPL 3.0 license.  Commercial use is permitted to the extent
 * that the code/component(store) do NOT become part of another Open Source or Commercially
 * licensed development library or toolkit without explicit permission.
 * 
 * License details: http://www.gnu.org/licenses/lgpl.html
 */

/**
 * @class Ext.ux.ActionGridPanel
 * @extends Ext.grid.GridPanel
 */
Ext.ux.ActionGridPanel = Ext.extend(Ext.grid.GridPanel, {
	
	// configuration options overridable from outside
	// {{{
	/**
	 * @cfg {Array} actions array for the config of toolbar'store buttons
	 * array item attributes
	 * {
	 * 	text: //button text
	 *	tooltip: // button tooltip
	 *	iconCls: // button iconCls
	 *	url: // button action url
	 *	disabledIfLessThan: // diable the button if disabledIfLessThan > specified value at initialization
	 * }
	 */
    actions: null
	
	/**
	 * @cfg {Boolean} hasPaging true for  enable PagingToolbar for the grid
	 */
	,hasPaging: true
	
	/**
	 * @cfg {Number} pageSize page size for  PagingToolbar
	 */
	,pageSize: 20
	
	/**
	 * @cfg {Function} callback function will be called after the action for grid has been done
	 */
	,callback: null
	// }}}
	
	// private
	// {{{
	/**
	 *  {Array} action_buttons  saved array for the object of toolbar'store buttons
	 * @private
	 */
	,action_buttons: null
	// }}}
	
	,checkHander : function(action){
		if(action.url == null){
			action.handler();
		}else{

			this.doActionToGrid(action);
		}
	}



	// overrides
	// {{{
    ,initComponent : function(){
    	var self = this;
		
		// initialize Toolbar and buttons
    	if (this.actions != null && this.actions.length > 0)
    	{
    		this.action_buttons = new Array();
//    		var tbar = new Ext.Toolbar();
    		
	        for (var i = 0; i < this.actions.length; i++)
	        {
	        	var action = this.actions[i];
	        	if(action.url != null){
					var btn = new Ext.Button({
						text: action.text,
						tooltip: action.tooltip,
						iconCls: action.iconCls, 
	//					disabled:action.disabled,
						handler: self.checkHander.createDelegate(self,[action])
					});
	//				btn.disabledIfLessThan = action.disabledIfLessThan;
	//				btn.disabledPrivilege = action.disabled;
					this.action_buttons.push(btn);	        		
	        	}else{
	        		this.action_buttons.push(action);	 
	        	}

	        }
	        
	        
	        this.tbar = new Ext.Toolbar({
		        items:this.action_buttons
		    });
    	}
        
		// initialize PagingToolbar
        if (this.hasPaging)
        	this.bbar = new Ext.PagingToolbar({
				pageSize: this.pageSize,
				store: this.getStore(),
				displayInfo: true
			});
        
        Ext.ux.ActionGridPanel.superclass.initComponent.apply(this, arguments);
	}// eo function initComponent
	// }}}
	
	// {{{
	/**
	 * onRender override, saves references to buttons
	 * @private
	 */
	,onRender:function() {
		var abuttons = this.action_buttons;
		
		var self = this;
		
		// determine whether the buttons should be disabled or not at first
//		for (var i = 0; i < abuttons.length; i ++)
//		{
//			abuttons[i].disabledIfLessThan > 0 ? abuttons[i].disable() : abuttons[i].enable();
//		}
		
		// determine whether the buttons should be disabled or not when selecting
//		this.getSelectionModel().on("selectionchange", function(csm, rowIndex, record){
////			var c = _sub_grid_new_msg.getSelectionModel().getCount();
//			var c = self.getSelectionModel().getCount();
//			for (var i = 0; i < abuttons.length; i ++)
//			{
////	    			c > 0 ? abuttons[i].enable() : abuttons[i].disable();
//		    	if(!abuttons[i].disabledPrivilege && abuttons[i].disabledIfLessThan > 0 ){
//					c > 0 ? abuttons[i].enable() : abuttons[i].disable();
//				}
//			}
//		});
		
		// refresh the store when the grid is activated
		this.on("activate", function(self) {
        	self.getStore().load({params:{start:0, limit: self.pageSize}});
    	});
		
		Ext.ux.ActionGridPanel.superclass.onRender.apply(this, arguments);
	}// eo function onRender
	// }}}
	
	// added methods
	// {{{
	/**
	 * called by button handler to prompt for confirmation
	 * @private
	 * @param {String} action_url action url
	 */
    ,doActionToGrid: function(action){
    	var action_url = action.url;
    	var action_text = action.text;
    	var c = this.getSelectionModel().getCount();
    	var self = this;
    	if (c > 0)
			Ext.MessageBox.confirm('系统提示', '你是否确定'+ action_text +'?', function(btn, text){
				if(btn=='yes'){
					self.doActualActionToGrid(action_url);
				}
			});
    	else
    		Ext.MessageBox.alert('系统提示', '请选择要操作的数据!');
    }// eo function doActionToGrid
	// }}}
    	
    // {{{
	/**
	 * called by doActionToGrid to do actual action
	 * @private
	 * @param {String} action_url action url
	 */
    ,doActualActionToGrid: function(action_url){
    	var selections = this.getSelectionModel().getSelections();
    	var selection_ids = new Array();
	    for (var i = 0; i < selections.length; i++ )
    	{
    		selection_ids[i] = selections[i].id;
    	}
    	var store = this.getStore();
    	var start = this.getBottomToolbar().paramNames.start;
    	var conn = new Ext.data.Connection();
    	conn.request({
    		url: action_url,
    		params:{selectedItems:selection_ids},
    		method: 'post',
    		scope: this,
    		callback:function(options, success, response){ 
    			if(success){   
    				Ext.MessageBox.alert('系统提示','您的操作成功完成!');
					// Refresh current page when the action was done. Calculating the correct start numbner if some rows were deleted, 
    				var st = 0;
    				if(store.lastOptions && store.lastOptions.params && store.lastOptions.params[start])
	    			{
						st = store.lastOptions.params[start];
						var cur_page_size = store.getTotalCount() - st;
						if (cur_page_size <= this.pageSize)
						{
							if (selections.length >= cur_page_size)
								st -= this.pageSize; 
						}
					}
    				store.load({params:{start:st, limit:this.pageSize}});
					// execute the callback function is the callback is assigned
    				if (this.callback != null)
    				{
    					this.callback();
    				}
    			}
    			else {
    				Ext.MessageBox.alert('系统提示','您的操作操作失败!');
    			}
    		}
    	})
    }// eo function doActualActionToGrid
	// }}}
});

Ext.reg('actiongridpanel', Ext.ux.ActionGridPanel);