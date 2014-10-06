var Charts = Class.create({
  initialize: function() {
    this.Chart = {//
        objs:null,
        name:null,
        chartdiv:null,
        contPath:null,
    	transparent:false,
        chartType:        null,//
        chartWidth:        0,//
        chartHeight:        0,//
        imageSave:        0,//
        imageSaveURL:        null,//
        dataDrill:false,
        customXML:         null
   
    };
    this.ChartParams = {//
        caption:        null,//
        subCaption:        null,//
        labelDisplay:        0,//
        baseFontSize: 	    12,
        showValues: 	    0,
        slantLabels:        1//
//        bgColor:"FFFFFF"
    };
    
    this.LabelsData = {//
        cols:        null,//
        displays:        null,//
        parentYAxisP:        null,//
        dataparamsURL:null,
        parentYAxisS:        null//
    };
   
    return this;
  },
  buildChart: function() {
  	
	var chartStr = '&chart=[';
		chartStr += 'chartType='+ this.Chart.chartType +';';
		chartStr += 'chartWidth='+this.Chart.chartWidth+';';
		chartStr += 'chartHeight='+this.Chart.chartHeight+';';
		chartStr += ']';
		
	return chartStr;
  },
  
  buildChartParams: function(args) {
			var chartStr = '&chartParams=[';
			if(!isUndefined(this.ChartParams.caption)) chartStr += 'caption='+ this.ChartParams.caption +';';
			if(!isUndefined(this.ChartParams.subCaption)) chartStr += 'subCaption='+ this.ChartParams.subCaption +';';
			if(!isUndefined(this.ChartParams.labelDisplay)) chartStr += 'labelDisplay='+ this.ChartParams.labelDisplay +';';
			if(!isUndefined(this.ChartParams.slantLabels)) chartStr += 'slantLabels='+ this.ChartParams.slantLabels +';';
			if(!isUndefined(this.ChartParams.baseFontSize)) chartStr += 'baseFontSize='+ this.ChartParams.baseFontSize +';';
			if(!isUndefined(this.ChartParams.showValues)) chartStr += 'showValues='+ this.ChartParams.showValues +';';
			chartStr += 'imageSave=1;';
			chartStr += 'imageSaveURL='+this.Chart.imageSaveURL+';';
//			chartStr += 'numberScaleValue=1000,10,10000;';
//			chartStr += 'numberScaleUnit=Ǫ,��,��;';		
			chartStr += 'numberScaleValue=10000,10000,10000;';
			chartStr += 'numberScaleUnit=��,��,��;';				
				
			
//			chartStr += 'numberScaleValue=1000,10,10000;';
//			chartStr += 'numberScaleUnit=Ǫ,��,��;';
//			chartStr += 'thousandSeparator=,;';
			chartStr += 'useRoundEdges=1;';
//			chartStr += 'bgColor=FFFFFF;';
							
			//chartStr += 'rotateValues=1,B?;	
			chartStr += ']';
			
			return chartStr;
		
  },
  //objs �������� ��֯������
 //&labels=Label 1;Label 2;Label 3 
 //&data=[seriesName=Total Quantity;parentYAxis=P]10;20;30;40
 //&data=[seriesName=Total Quantity;parentYAxis=S]50;10;70;100  
    buildLabelsData: function() {

		var objs = this.Chart.objs;
		var cols = this.LabelsData.cols;
		var displays =  this.LabelsData.displays;
		var parentYAxisP =  this.LabelsData.parentYAxisP;
		var parentYAxisS =  this.LabelsData.parentYAxisS;
		var dataparamsURL = this.LabelsData.dataparamsURL;
		var dataArray = new Array();
		var labels='&labels=';
		var dataP='&data=';
		var dataS='&data=';
		var dataparams ='';
		var dataParamsBody ='';
		
		var isLink = !isUndefined(dataparamsURL) && dataparamsURL !=null && dataparamsURL !="";

		
		parentYAxisP.each(function(p){
			if(displays[p]== 'true') dataArray[p] ='&data=[seriesName='+ cols[p] +';parentYAxis=P]';}
		);	
		
		parentYAxisS.each(function(p){
			if(displays[p]== 'true') dataArray[p] ='&data=[seriesName='+ cols[p] +';parentYAxis=S]';}
		);
		
			
	
		for(var i=0;i< objs.length;i++){
			var lable = objs[i].lable;
			
			labels += lable +';';
			
			//dataParamsBody +='[link=n-DemoLink2.htm]';
			if(this.Chart.dataDrill){
				var id = objs[i].id;
				dataParamsBody +='[link=j-myDrill('+ id +')]';
			}
			

			parentYAxisP.each(function(p){
					if(displays[p] == 'true'){
						eval("var value = objs[i].value"+ p);
						dataArray[p] += value+';';
					}
				}
			);
		
			
			parentYAxisS.each(function(p){
					if(displays[p] == 'true'){
						eval("var value = objs[i].value"+ p);
						dataArray[p] += value+';';
					}
				}
			);
				
		
	        
		}
		
		if(objs.length>0) labels = labels.substring(0,labels.length-1);
		//if(dataArrayP.length>0) dataArrayP = dataArrayP.substing(0,labels.length-1);
		var dataArrayNew= new Array();
		for(var k =0;k<dataArray.length;k++){if(!isUndefined(dataArray[k])){dataArrayNew.push(dataArray[k]);}}
		var dataArrayStr = "";
		for(var k =0;k<dataArrayNew.length;k++){
			dataArrayStr +=dataArrayNew[k];
			if(this.Chart.dataDrill) dataparams +='&dataparams='+dataParamsBody;
			
		}
		var res = this.Chart.dataDrill?labels + dataparams + dataArrayStr: labels + dataArrayStr;
		return res;
  },
  	//labelDisplay='WRAP'
	//labelDisplay='ROTATE'
	//labelDisplay='Rotate' slantLabels='1'
	//labelDisplay='Stagger' staggerLines='n' 
   buildFusionCharts: function() {
		var chart = this.buildChart();
		var chartParams = this.buildChartParams();
		var LabelsData =  this.buildLabelsData();
		var FCQS ="?v=3"+ chart  + chartParams + LabelsData + this.Chart.customXML; 
	
		//FCQS ="?v=3&chart=[chartType=scrollcombidy2d;chartWidth=620;chartHeight=400;labelDisplay=Rotate;slantLabels=45]&data=[seriesName=Total Quantity;parentYAxis=P]10;20;30;40&labels=Label111111111111111111111111 1;Label 122222222222222222222222222;Label 3333333333333333333333333;Label 44444444444444444444&data=[seriesName=Total Quantity;parentYAxis=S]50;10;70;100";
		var FCC = new FusionChartsCreator(FCQS); 
		
	
		
		var dataXML = FCC.getXML(this.Chart.customXML);
		var chart = new FusionCharts(this.Chart.contPath+"scripts/fusionCharts/fresh/"+FCC.getSWF()+FCC.getChartMSG() , this.Chart.name , FCC.getWidth() , FCC.getHeight(), FCC.getDebugMode(), "1" );
		chart.setDataXML(dataXML);	
		chart.setTransparent(this.Chart.transparent);
		chart.render(this.Chart.chartdiv);		
  },
  

//    makeColunmCheck: function(el,name,args,allSelected) {
//           var html ="<div style='position:relative;overflow:visible;border:solid black 1px;background-color:white;width:80px;height:17px;'>";
//           html +="<table border=0 cellspacing=0 cellpadding=0><tr><td>";
//           html +="<span style='CURSOR: pointer;width:60px;border:none;' onclick='javaScript:showHidden();'>&nbsp;&nbsp;&nbsp;ѡ����&nbsp;&nbsp;&nbsp;</sapn>";
//           html +="</td><td>";
//           html +="<image src='"+ contPath +"image/combo_select.gif' onclick='javaScript:showHidden();' style='CURSOR: pointer;height:17px;'/>";
//           html +="</td></tr></table>";
//          
//           html +="<div id="+ name +" style='position:absolute;OVERFLOW: auto;left:0px;top:18px;width:120px;height:230px;visibility:hidden;border:solid black 1px;background-color:white;z-index:0'>";
//		var arr = args.split(",");
//		var check = allSelected?"checked":"";
//		
//		html +="<table>";
//		for(var i = 0;i<arr.length;i++){
//			if(arr[i] == "" && arr.length==1) break;
//			html +="<tr><td>";
//			html += "<label style='cursor: pointer;' for=\""+ arr[i] +"\">";	
//			html +="<input " + check +" name='" + arr[i] +"' id='" + arr[i] +"' type='checkbox' value='"+ arr[i] +"' onchange='renderFromQS()'>";
//			html +=  arr[i];
//			html += "&nbsp;&nbsp;&nbsp";
//			html += "</label>";
//			html += "</td></tr>";
//					
//		}
//	        html +="<table>";
//	        html +="</div></div>";
//	        el.innerHTML = html;
//
//  },
  
      makeColunmCheck: function(renderId,id,width,args,allSelected,xtype) {
      	 var stores =[];
      	 var arr = args.split(",");
      	 for(var i = 0;i<arr.length;i++){
      	    var store =[];
      	 	store.push( arr[i]);
      	 	store.push( arr[i]);
      	 	stores.push(store);
      	 }
      	 
      	var conf = {
		 	     fieldLabel: '��������'
				 ,id:id
				  ,name:id
				,width:width
				,hideOnSelect:false
//				,renderTo:renderId
//				,selectAllOn : true
				,maxHeight:width
				,readOnly: false 
		  		,editable: false
		  		,typeAhead: true
				,emptyText: '��ѡ����...' 
				,store:new Ext.data.SimpleStore({
					 id:0
					,fields:[{name:'id',type:'string'}, 'name']
					,data:stores
				})
				,triggerAction:'all'
				,valueField:'id'
				,displayField:'name'
				,mode:'local'
			};
			if(renderId) conf.renderTo= renderId;
			
			if(xtype){
		    	conf.xtype = 'lovcombo';
 				conf.listeners = {
			            select:function(combo,record,index){
			                renderFromQS();
			            },
//			            load:function(combo,record,index){
//			                	combo.selectAll();
//								combo.setRawValue("��ѡ����...");
//			            }
       			 };		    	
		    	
		    	return conf;
		    }else{
			    var comboBox =  new Ext.ux.form.LovCombo(conf);	
				if(allSelected)	{
					comboBox.selectAll();
					comboBox.setRawValue("��ѡ����...");
				}		
				comboBox.on("select" , function(box) {renderFromQS();} );    
			    return comboBox
		    } 	 		
			

			

  },
  
      makeStyleCommand: function(el,name,width,defV,model,xtype) {
		var chartList=new Array();
		chartList.push(["log2D������״ͼ","logcolumn2d"]);
		chartList.push(["log����ͼ","logline2d"]);
		chartList.push(["Bar3D������״ͼ","bar3d"]);
		chartList.push(["Bar3D��ջͼ","stackedbar3d"]);
		chartList.push(["�״�ͼ","radar"]);
		chartList.push(["2D��������ͼ","spline2d"]);
		chartList.push(["3D��������ͼ","spline3d"]);
		chartList.push(["2D��������ͼ","splinearea2d"]);
		chartList.push(["3D����ͼ","splinearea3d"]);
		chartList.push(["2D��ת����ͼ","inversearea2d"]);
		chartList.push(["2D��ת������״ͼ","inversecolumn2d"]);
		chartList.push(["2D��ת��������ͼ","inverseline2d"]);
		chartList.push(["2D�ٲ�ͼ","waterfall"]);
		chartList.push(["Scatter","scatter"]);
		chartList.push(["Bubble","bubble"]);
		chartList.push(["3D����ͼ","column3d"]);
		chartList.push(["2D����ͼ","column2d"]);
		chartList.push(["MS3D����ͼ","column3d"]);
		chartList.push(["MS2D����ͼ","column2d"]);
		chartList.push(["3D��ջ����ͼ","stackedcolumn3d"]);
		chartList.push(["2D��ջ����ͼ","stackedcolumn2d"]);
		chartList.push(["2D��ͼ","pie2d"]);
		chartList.push(["3D��ͼ","pie3d"]);
		chartList.push(["2D��ͼ","doughnut2d"]);
		chartList.push(["3D��ͼ","doughnut3d"]);
		chartList.push(["MS2D��ջ����ͼ","msstackedcolumn2d"]);
		chartList.push(["MS2D��ջ����ͼlinedy","msstackedcolumn2dlinedy"]);
		chartList.push(["����ͼ","line2d"]);
		chartList.push(["MS����ͼ","line2d"]);
		chartList.push(["Bar2D","bar2d"]);
		chartList.push(["MSBar2D","bar2d"]);
		chartList.push(["Bar2D��ջͼ","stackedbar2d"]);
		chartList.push(["2D����ͼ","area2d"]);
		chartList.push(["MS2D����ͼ","area2d"]);
		chartList.push(["2D��ջ����ͼ","stackedarea2d"]);
		chartList.push(["2D������״ͼ","combi2d"]);
		chartList.push(["2D�����������״ͼ","combi2ddy"]);
		chartList.push(["3D��״��ջ����ͼ","stackedcolumn3dlinedy"]);
		chartList.push(["MS3D�������״����ͼ","column3dlinedy"]);
		chartList.push(["MS3D��״����ͼ","column3dline"]);
		chartList.push(["Scroll2D����ͼ","scrollarea2d"]);
		chartList.push(["Scroll2D��״ͼ","scrollcolumn2d"]);
		chartList.push(["ScrollLine2D","scrollline2d"]);
		chartList.push(["2D������״ͼ","scrollcombi2d"]);
		chartList.push(["2D�����������״ͼ","scrollcombidy2d"]);
		chartList.push(["2D��ջ��״ͼ","scrollstackedcolumn2d"]);
		chartList.push(["MS3D����ͼ","mscombi3d"]);
		chartList.push(["SS����ͼ","ssgrid"]);
			
			
		if(model ==1){

		    var store  = new Ext.data.SimpleStore({
		        fields : ['lable', 'value'],
		        data :  chartList
		    });
		   
		   var conf = {    
		        	fieldLabel: '',    
		            id:name,
		            name: name,
		            editable:false,
		            allowBlank:false,
		            store:store,
		            mode: 'local',
		            typeAhead: true,
		            triggerAction: 'all',
		            selectOnFocus:true,
		            displayField : 'lable',
		        	valueField : 'value',
		            width:width,
		//            anchor:'95%',
		            frame:true,
		            resizable:true
		        }; 
		        
		    if(xtype){
		    	conf.xtype = 'combo';
		    	 if(defV)  conf.value = defV;  
		    	 conf.listeners = {
			            select:function(combo,record,index){
			                renderFromQS();
			            }
       			 };
		    	return conf;
		    }else{
			    var comboBox =   new Ext.form.ComboBox(conf);
			    if(defV)  comboBox.setValue(defV);  
			    return comboBox
		    } 	        

		}else{
			var html="";
			html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:"+ width +"px;' onchange='renderFromQS()'>";	
			for(var i = 0;i<chartList.length;i++){
				var lable = chartList[i][0];
				var value = chartList[i][1];
				var selectedStr =(defV == value)?"selected":"";
				html +="<option "+ selectedStr +" value='"+ value +"'>" + lable +"</option>";		
			}
			html += "</select>";	
		     
			el.innerHTML = html;

		}

  },
  
    makeFontSizeCommand: function(el,name,width,defV,model,xtype) {
    	if(model == 1){
    		var fontSizeStore = new Array();
			var range = $R(9, 15, false);
		        range.each(function(value, index){
		        	fontSizeStore.push(value);
		     });
		     
			var conf = {    
	        	fieldLabel: '����',    
	            id:name,
	            name: name,
	            editable:false,
	            allowBlank:false,
	            store:fontSizeStore,
	            mode: 'local',
	            typeAhead: true,
	            triggerAction: 'all',
	            selectOnFocus:true,
	            width:width,
	            frame:true,
	            resizable:true
	        };
		    if(xtype){
		    	conf.xtype = 'combo';
		    	 if(defV)  conf.value = defV;  
		    	return conf;
		    }else{
			    var comboBox =   new Ext.form.ComboBox(conf);
			    if(defV)  comboBox.setValue(defV);  
			    return comboBox
		    }  	        
	        
		     
    	}else{
			var html="";
			html += "<select name='"+ name +"' id='"+ name +"' style='cursor: pointer;width:"+ width +"px;' onchange='renderFromQS()'>";	
			var range = $R(9, 15, false);
		        	range.each(function(value, index){
				var selectedStr =(defV == value)?"selected":"";
				html +="<option "+ selectedStr +" value='"+ value +"'>" + value +"</option>";
		        });
	        
			html += "</select>";	
		     
			el.innerHTML = html;		
    	}

  },
  
//      getDisplay: function(el,cols) {
//      	var arr = new Array();
//      	var inputValues = new Array();
//      	var colNum = cols.length;
//	
//		var inputs = el.getElementsByTagName("input");
//		inputs = $A(inputs);
//		inputs.each(function(ip){if(ip.checked)inputValues.push(ip.value);});
//		
//	
//		for(i =0;i<colNum;i++){
//			var k = inputValues.indexOf(cols[i]);
//			
//			if(k > -1){
//				arr.push('true');
//			}else{
//				arr.push('false');
//			}
//		}		
//		
//		
//		//alert(inputs.length)
//		if(inputs.length == 0){
//			for(i =0;i<colNum;i++){arr.push('true');}
//		}
//		
//		return arr;
//  },
  
        getDisplay: function(name,cols) {
        	var arr = new Array();
        	var colNum = cols.length;
        	var inputs =  Ext.getCmp(name).getCheckedValue();
			for(i =0;i<colNum;i++){
				var k = inputs.indexOf(cols[i]);
				if(k > -1){
					arr.push('true');
				}else{
					arr.push('false');
				}
			}	
			
		if(inputs.length == 0){
			for(i =0;i<colNum;i++){arr.push('true');}
		}

		
		return arr;
      	
  },  getDisplay2: function(cmd,cols) {
        	var arr = new Array();
        	var colNum = cols.length;
        	var inputs =  cmd.getCheckedValue();
			for(i =0;i<colNum;i++){
				var k = inputs.indexOf(cols[i]);
				if(k > -1){
					arr.push('true');
				}else{
					arr.push('false');
				}
			}	
			
		if(inputs.length == 0){
			for(i =0;i<colNum;i++){arr.push('true');}
		}

		
		return arr;
      	
  },
  
  
});
