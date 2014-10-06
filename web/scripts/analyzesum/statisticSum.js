


//
//function getStoreList(mode,paramObj){
////	mode = mode || 'local';
//	paramObj = paramObj || {};
//	var fileds=[  
//			  {name: "value1", type: "string"},
//			  {name: "value2", type: "string"},
//			  {name: "value3", type: "string"},
//			  {name: "value4", type: "string"},
//			  {name: "value5", type: "string"},
//			  {name: "value6", type: "string"}
//	    ];
//
//	var store = new Ext.data.Store({
//		proxy: new Ext.data.DWRHttpProxy({url: AnalyseSumManager.getBranchSumJson}),
//		reader: new Ext.data.DWRObjectReader({id: "id"},fileds)
//	});
//	
//	if(mode == 'remote'){
//	  	store.on('beforeload', function(){
//	    	Ext.apply(this.baseParams, {dwrParams:[paramObj]});
//		}); 
//		store.load();			
//	}else{
//		store.load({params:{dwrParams:[paramObj]}});
//	}
//
//	return store;
//}


		
 function get_statistic_sum_tables(){
	
		Ext.QuickTips.init();
        
		var xg = Ext.grid;		
    
//	    var fields = paramObj.fields;
	    
	    var fields =[  
    		  {name: "lable", type: "string"},
			  {name: "value1", type: "string"},
			  {name: "value2", type: "number"},
			  {name: "value3", type: "number"},
			  {name: "value4", type: "number"},
			  {name: "value5", type: "number"},	
			  {name: "value6", type: "number"},	
			  {name: "value7", type: "number"},
			  {name: "value10", type: "number"},
			  {name: "value11", type: "number"},
			  {name: "value12", type: "number"},
			  {name: "value13", type: "number"}
	    ];    
	    
		
		
	   	var params = getParams();
	   	var displayModel = params.displayModel;
	   	var fn = AnalyseSumManager.getStatisticSumJson;
	   	var kk = displayModel ==1?1:3;
	   	
	   	var store = utils.getStore(fn,fields,'remote',true,params,kk);  
	   	
//	   		alert(displayModel);
//	   		console.log(store);

	    if(displayModel == 2){
	        store.sortInfo  = {field: 'lable', direction: 'ASC'};
		    store.groupOnSort  = true;
		    store.remoteGroup  = true;
		    store.groupField  = 'value1'	
	    }

	    
//	    console.log(ds)
        var summary;
         if(displayModel == 1){
			summary　=　new　Ext.ux.grid.GridSummary();
         }else{
			summary = new Ext.ux.grid.GroupSummary();
         }

		

		var　renderSummary1　=　function(o,　cs,　cm)　{return　'合计：';}	
		var　renderSummary2　=　function(o,　cs,　cm)　{return　'小计：';}	

 		if(displayModel == 1){
//		    Ext.ux.grid.GridSummary.Calculations['totalCost1'] = function(v, record, colName, data, rowIdx){
//	            if(field == 'value4'){
//	            	 return (record.data.value3/record.data.value11);
//	            }
//		        if(field == 'value7'){
//	            	 return (record.data.value5/record.data.value13);
//	            }
//		    }
 		}else{
		    Ext.grid.GroupSummary.Calculations['totalCost'] = function(v, record, field){
	            if(field == 'value4'){
	            	 return (record.data.value10/record.data.value11);
	            				}
	           if(field == 'value5'){
	            		return Ext.util.Format.number(record.data.value5,'0,000.00');
	         
	            				}
		        if(field == 'value7'){
	            	 return (record.data.value12/record.data.value13);
	            }
		    }
 		}
	    
	    
	    
       var rowNum = new Ext.grid.RowNumberer({hidden: false, name:"序" });

		
//		var　renderSummary　=　function(o,　cs,　cm)　{
//			  alert(ds.reader.dataSum)
//		　　　　return　 ds.reader.dataSum;
//		}
    
    
        // define a custom summary function
//    Ext.grid.GroupSummary.Calculations['totalCost'] = function(v, record, field){
//        return v + (record.data.estimate * record.data.rate);
//    }

//		{
//                id: 'cost',
//                header: "Cost",
//                width: 20,
//                sortable: false,
//                groupable: false,
//                renderer: function(v, params, record){
//                    return Ext.util.Format.usMoney(record.data.estimate * record.data.rate);
//                },
//                dataIndex: 'cost',
//                summaryType:'totalCost',
//                summaryRenderer: Ext.util.Format.usMoney
//            }
    
//,renderer: function(val) {return Ext.util.Format.Currency(val)*100+'%';}
//,renderer: function(val){return Ext.util.Format.number(val,'0,000.00');}
     //现在配置列信息
    var cm0 = []; var cm1 = [];var cm2 = [];var cm11 = [];
    
    if(curActiveTabIndex == 1){ 
 			cm0 =[{header:'部门',width:50,sortable:false,align:'left',dataIndex:'lable'}];
 			cm11 =[{header:'业务员',sortable:true,align:'left',dataIndex:'value1'}]; 	
 			if(displayModel == 1){ 
 				cm1 = cm0;
 			}else{
 				cm1 = cm0.concat(cm11);
 			}
    }    
     
    if(curActiveTabIndex == 2){ 
    		cm0 =[{header:'频道',width:80,sortable:false,align:'left',dataIndex:'lable'}];
			cm11 =[{header:'业务员',width:80,sortable:true,align:'left',dataIndex:'value1'}];
			if(displayModel == 1){
				cm1 = cm0;
			}else{
				cm1 = cm0.concat(cm11);
			}
    }  
    
    if(curActiveTabIndex == 3){ 
    		cm0 =[{header:'时段类型',width:80,sortable:false,align:'left',dataIndex:'lable'}];
			cm11 =[{header:'时段名称',width:150,sortable:true,align:'left',dataIndex:'value1'}];
			if(displayModel == 1){
				cm1 = cm0;
			}else{
				cm1 = cm0.concat(cm11);
			}
    }    
    
    if(curActiveTabIndex == 4){ 
    		cm0 =[{header:'业务员',width:80,sortable:false,align:'left',dataIndex:'lable'}];
			cm11 =[{header:'客户',width:150,sortable:true,align:'left',dataIndex:'value1'}];
			if(displayModel == 1){
				cm1 = cm0;
			}else{
				cm1 = cm0.concat(cm11);
			}
    }   
    
    if(curActiveTabIndex == 5){ 
    		cm0 =[{header:'行业类别',width:80,sortable:false,align:'left',dataIndex:'lable'}];
			cm11 =[{header:'子类别',width:120,sortable:true,align:'left',dataIndex:'value1'}];
			if(displayModel == 1){
				cm1 = cm0;
			}else{
				cm1 = cm0.concat(cm11);
			}
    }      
       
     if(curActiveTabIndex == 6){ 
    		cm0 =[{header:'订单类别',width:80,sortable:false,align:'left',dataIndex:'lable'}];
			cm11 =[{header:'子类别',width:120,sortable:true,align:'left',dataIndex:'value1'}];
			if(displayModel == 1){
				cm1 = cm0;
			}else{
				cm1 = cm0.concat(cm11);
			}
    }  
    
      if(curActiveTabIndex == 7){ 
    		cm0 =[{header:'品牌',width:80,sortable:false,align:'left',dataIndex:'lable'}];
			cm11 =[{header:'版本',width:120,sortable:true,align:'left',dataIndex:'value1'}];
			if(displayModel == 1){
				cm1 = cm0;
			}else{
				cm1 = cm0.concat(cm11);
			}
    }  
    
     if(curActiveTabIndex == 8){ 
    		cm0 =[{header:'客户类别',width:80,sortable:false,align:'left',dataIndex:'lable'}];
			cm11 =[{header:'客户',width:150,sortable:true,align:'left',dataIndex:'value1'}];
			if(displayModel == 1){
				cm1 = cm0;
			}else{
				cm1 = cm0.concat(cm11);
			}
    }     
    
       if(curActiveTabIndex == 9){ 
    		cm0 =[{header:'客户名称',width:80,sortable:false,align:'left',dataIndex:'lable'}];
			cm11 =[{header:'品牌',width:150,sortable:true,align:'left',dataIndex:'value1'}];
			if(displayModel == 1){
				cm1 = cm0;
			}else{
				cm1 = cm0.concat(cm11);
			}
    }       
    
    
//Ext.util.Format.numberRenderer('00.00')


    var cm2 = [
//    			{header:'时长',sortable:true,dataIndex:'value2',summaryType: 'sum'},
    			{header:'时长',sortable:true,width:85,dataIndex:'value2',renderer: function(val){
    				return myDate.FormatDate2(val);
    				},summaryType: 'sum'},
				{header:'应收',sortable:true,dataIndex:'value3',renderer: function(val){return Ext.util.Format.number(val,'0,000.00');},summaryType: 'sum'},
				{header:'应收比例',sortable:true,width:75,dataIndex:'value4',renderer: function(val){
					var vv = Ext.util.Format.number(val, "0.0000")*1;
					return  Ext.util.Format.number(vv*100, "0.00")+'%';
					}},
				{header:'实收',sortable:true,dataIndex:'value5',renderer: function(val){return Ext.util.Format.number(val,'0,000.00');},summaryType: 'sum'},
				{header:'欠款',sortable:true,dataIndex:'value6',renderer: function(val){return Ext.util.Format.number(val,'0,000.00');},summaryType: 'sum'},
				{header:'到款率',sortable:true,width:60,dataIndex:'value7',renderer: function(val) {
					var vv = Ext.util.Format.number(val, "0.0000")*1;
					return  Ext.util.Format.number(vv*100, "0.00")+'%';
//					return ForDight((Ext.util.Format.Currency(val)),4)*100+'%';
					
					}}
    ];
    
    if(displayModel == 2){ 
    	cm1[1].summaryRenderer = renderSummary2;
    	cm2[2].summaryType = 'totalCost';
    	cm2[5].summaryType = 'totalCost';
    }else{
    	cm1[0].summaryRenderer = renderSummary1;
//    	cm2[2].summaryType = 'totalCost1';
//    	cm2[5].summaryType = 'totalCost1';
    }
    cm1[0].id = 'company';
    
    var cm = cm1.concat(cm2);
    
   
     
    var columnModel=new Ext.grid.ColumnModel({
    columns:cm,
    defaults: {
	            sortable: true,
	            menuDisabled: false,
//	            height:'auto',
	            align: 'right',
	            width:110
	        }
    });       
        
    var view = new Ext.grid.GroupingView({
	        forceFit: true,
	        hideGroupedColumn: true,
	        showGroupName: false,
	           //enableColumnMove: false,
	        // custom grouping text template to display the number of items per group
//	        groupTextTpl: '{text} ({[values.rs.length]} {[values.rs.length > 1 ? "位业务员" : "位业务员"]})'
	        groupTextTpl: '{text}'
	    });
       
    var conf = {
			frame:true,
//			width:'auto',
//			id:'sum_grid_pan'+"_"+curActiveTabIndex+"_"+displayModel,
//			height:'auto', 
 			height: currentWindow.get("mainTab").getInnerHeight()-5,
	        store: store,
	        cm: columnModel,
	        loadMask: true,
	        trackMouseOver:false,
			stripeRows: true,
			columnLines: true,
			plugins:[summary],
//			renderTo:'grid-branch_sum_div',			
//			viewConfig: {
//				forceFit: true
//	            enableRowBody:true,
//	            showPreview:true,  
//	            scrollOffset:-100
//	            getRowClass:function(record,rowIndex,rp,ds){
//	            	return 'x-grid-with-cell';
//	            }
//			},
//		    width: "100%",
//		    width:currentWindow.get("mainTab").getInnerWidth()-7,
		    autoExpandColumn: 'company',
//		    height: 430,
//		    layout : 'fit',  
//		    animCollapse: false,
		    iconCls: 'icon-grid'
		};   
		
	
		
		if(displayModel == 2){
			conf.view = view;
		}			
		

	    if(curActiveTabIndex == 1){
	    	if(displayModel == 1){
				branch_sum_grid = new Ext.grid.GridPanel(conf);
				branch_sum_grid.render('branch_sum_chart_div');
//				if(branch_sum_grid2) branch_sum_grid2.hide();
				return branch_sum_grid;
	    	}else{
				branch_sum_grid2 = new Ext.grid.GridPanel(conf);
				branch_sum_grid2.render('branch_sum_chart_div');
//				if(branch_sum_grid) branch_sum_grid.hide();
				return branch_sum_grid2;
	    	}
	
	    	
	    }
	    
	    if(curActiveTabIndex == 2){
	    	if(displayModel == 1){
	    		channel_sum_grid = new Ext.grid.GridPanel(conf);	
	    		channel_sum_grid.render('channel_sum_chart_div');
	    		return channel_sum_grid;    		
	    	}else{
	    		channel_sum_grid2 = new Ext.grid.GridPanel(conf);
	    		channel_sum_grid2.render('channel_sum_chart_div');
				return channel_sum_grid2;    		
	    	}

	    }
	    if(curActiveTabIndex == 3){
	    	if(displayModel == 1){
	    		pos_sum_grid = new Ext.grid.GridPanel(conf);	
	    		pos_sum_grid.render('pos_sum_chart_div');
	    		return pos_sum_grid;    		
	    	}else{
	    		pos_sum_grid2 = new Ext.grid.GridPanel(conf);
	    		pos_sum_grid2.render('pos_sum_chart_div');
				return pos_sum_grid2;    		
	    	}
	    }	    

	    if(curActiveTabIndex == 4){
	    	if(displayModel == 1){
	    		sign_cut_sum_grid = new Ext.grid.GridPanel(conf);	
	    		sign_cut_sum_grid.render('sign_user_customer_sum_chart_div');
	    		return sign_cut_sum_grid;    		
	    	}else{
	    		sign_cut_sum_grid2 = new Ext.grid.GridPanel(conf);
	    		sign_cut_sum_grid2.render('sign_user_customer_sum_chart_div');
				return sign_cut_sum_grid2;    		
	    	}
	    }	
	    
	    
	   if(curActiveTabIndex == 5){
	    	if(displayModel == 1){
	    		instry_sum_grid = new Ext.grid.GridPanel(conf);	
	    		instry_sum_grid.render('instry_sum_chart_div');
	    		return instry_sum_grid;    		
	    	}else{
	    		instry_sum_grid2 = new Ext.grid.GridPanel(conf);
	    		instry_sum_grid2.render('instry_sum_chart_div');
				return instry_sum_grid2;    		
	    	}
	    }	
	    
	    
	   if(curActiveTabIndex == 6){
	    	if(displayModel == 1){
	    		order_cate_sum_grid = new Ext.grid.GridPanel(conf);	
	    		order_cate_sum_grid.render('order_cate_sum_chart_div');
	    		return order_cate_sum_grid;    		
	    	}else{
	    		order_cate_sum_grid2 = new Ext.grid.GridPanel(conf);
	    		order_cate_sum_grid2.render('order_cate_sum_chart_div');
				return order_cate_sum_grid2;    		
	    	}
	    }	
	    
	   if(curActiveTabIndex == 7){
	    	if(displayModel == 1){
	    		brand_edit_sum_grid = new Ext.grid.GridPanel(conf);	
	    		brand_edit_sum_grid.render('brand_edit_sum_chart_div');
	    		return brand_edit_sum_grid;    		
	    	}else{
	    		brand_edit_sum_grid2 = new Ext.grid.GridPanel(conf);
	    		brand_edit_sum_grid2.render('brand_edit_sum_chart_div');
				return brand_edit_sum_grid2;    		
	    	}
	    }	   
	    
	   if(curActiveTabIndex == 8){
	    	if(displayModel == 1){
	    		customer_cate_sum_grid = new Ext.grid.GridPanel(conf);	
	    		customer_cate_sum_grid.render('customer_cate_sum_chart_div');
	    		return customer_cate_sum_grid;    		
	    	}else{
	    		customer_cate_sum_grid2 = new Ext.grid.GridPanel(conf);
	    		customer_cate_sum_grid2.render('customer_cate_sum_chart_div');
				return customer_cate_sum_grid2;    		
	    	}
	    }	  
	    
	   if(curActiveTabIndex == 9){
	    	if(displayModel == 1){
	    		customer_brand_sum_grid = new Ext.grid.GridPanel(conf);	
	    		customer_brand_sum_grid.render('customer_brand_sum_chart_div');
	    		return customer_brand_sum_grid;    		
	    	}else{
	    		customer_brand_sum_grid2 = new Ext.grid.GridPanel(conf);
	    		customer_brand_sum_grid2.render('customer_brand_sum_chart_div');
				return customer_brand_sum_grid2;    		
	    	}
	    }	  
	    
	      
	         
	    	    
    
//	branch_sum_grid = new Ext.grid.GridPanel
//		({
//			frame:true,
////			width:'auto',
//			id:'branch_sum_grid_pan'+curActiveTabIndex,
////			height:'auto', 
// 			height: currentWindow.get("mainTab").getInnerHeight()-5,
//	        store: ds,
//	        cm: columnModel,
//	        view: view,
//	        loadMask: true,
//	        trackMouseOver:false,
//			stripeRows: true,
//			plugins: summary,
//			columnLines: true,
////			renderTo:'grid-branch_sum_div',			
////			viewConfig: {
////				forceFit: true
////	            enableRowBody:true,
////	            showPreview:true,  
////	            scrollOffset:-100
////	            getRowClass:function(record,rowIndex,rp,ds){
////	            	return 'x-grid-with-cell';
////	            }
////			},
////		    width: "100%",
////		    width:currentWindow.get("mainTab").getInnerWidth()-7,
//		    autoExpandColumn: 'company',
////		    height: 430,
////		    layout : 'fit',  
////		    animCollapse: false,
//		    iconCls: 'icon-grid'
//		});
		
//		var col_width = Ext.getCmp("branch_sum_grid").getWidth();
//		alert(col_width)

//		branch_sum_grid.render('grid-branch_sum_div');
//		branch_sum_grid.getSelectionModel().selectFirstRow();
	
//		window.onresize=function(){
//			branch_sum_grid.setWidth(0);
//			branch_sum_grid.setWidth(Ext.get("grid-branch_sum_div").getWidth());
//		};
		
//		branch_sum_grid.fields = fields;
	

	
}