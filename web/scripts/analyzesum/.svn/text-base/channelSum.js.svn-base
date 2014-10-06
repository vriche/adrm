

 function get_channel_sum_tables(){
	
		Ext.QuickTips.init();
        
		var xg = Ext.grid;		
    

	    var fields =[  
    		  {name: "lable", type: "string"},
			  {name: "value1", type: "string"},
			  {name: "value2", type: "number"},
			  {name: "value3", type: "number"},
			  {name: "value4", type: "number"},
			  {name: "value5", type: "number"},	
			  {name: "value6", type: "number"},
			  {name: "value7", type: "number"},
			  {name: "value8", type: "number"},	 
	    ];    
	    
		
		
	   	var params = getParams();
	   	
	   	var fn = AnalyseSumManager.getStatisticSumJson;
	   	var store = utils.getStore(fn,fields,'remote',true,params,3); 

//		var　summary　=　new　Ext.ux.grid.GridSummary();
		var　renderSummary　=　function(o,　cs,　cm)　{return　'合计：';};
		
		

	    store.sortInfo  = {field: 'lable', direction: 'ASC'};
	    store.groupOnSort  = true;
	    store.remoteGroup  = true;
	    store.groupField  = 'value1'
    
        var summary = new Ext.ux.grid.GroupSummary();
        var rowNum = new Ext.grid.RowNumberer({hidden: false, name:"序" });
 
    
		channel_sum_grid = new Ext.grid.GridPanel({
		    // A groupingStore is required for a GroupingView
		    store: store,
		    id:'channel_sum_grid_pan',
		    colModel: new Ext.grid.ColumnModel({
		    columns:[
						{header:'频道',sortable:false,align:'center',dataIndex:'lable',id:'company'},
						{header:'业务员',sortable:true,align:'center',dataIndex:'value1',summaryRenderer:renderSummary},
						{header:'时长',sortable:true,dataIndex:'value2',summaryType: 'sum'},
						{header:'应收',sortable:true,dataIndex:'value3',renderer: function(val){return Ext.util.Format.number(val,'0,000');},summaryType: 'sum'},
						{header:'比例',sortable:true,dataIndex:'value4',renderer: function(val){return Ext.util.Format.Currency(val)*100+'%';},summaryType: 'sum'},
						{header:'实收',sortable:true,dataIndex:'value5',renderer: function(val){return Ext.util.Format.number(val,'0,000');},summaryType: 'sum'},
						{header:'欠款',sortable:true,dataIndex:'value6',renderer: function(val){return Ext.util.Format.number(val,'0,000');},summaryType: 'sum'},
						{header:'到款率',sortable:true,dataIndex:'value7',renderer: function(val) {return Ext.util.Format.Currency(val)*100+'%';}}
		  		  ],
		        defaults: {
	//	            sortable: true,
		            align: 'right',
		            menuDisabled: false,
		            width:90
		        }
		    }),
		
		    view: new Ext.grid.GroupingView({
		        forceFit: true,
		        // custom grouping text template to display the number of items per group
		        groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "位业务员" : "位业务员"]})'
		    }),
	
	        
	//         // paging bar on the bottom
	//        bbar: new Ext.PagingToolbar({
	//            pageSize: 25,
	//            store: ds,
	//            displayInfo: true,
	//            displayMsg: 'Displaying topics {0} - {1} of {2}',
	//            emptyMsg: "No topics to display",
	//            items:[
	//                '-', {
	//                pressed: true,
	//                enableToggle:true,
	//                text: 'Show Preview',
	//                cls: 'x-btn-text-icon details',
	//                toggleHandler: function(btn, pressed){
	//                    var view = channel_sum_grid.getView();
	//                    view.showPreview = pressed;
	//                    view.refresh();
	//                }
	//            }]
	//        }),
			plugins: summary, //添加分组插件  
		    frame:true,
		    width: "100%",
		    height: currentWindow.get("mainTab").getInnerHeight()-5,
		    layout : 'fit',  
		    loadMask: true,
		    animCollapse: false,
		    autoExpandColumn: 'company',
		    columnLines: true,
		    iconCls: 'icon-grid'
		});  
    
    
	return channel_sum_grid;
	
}