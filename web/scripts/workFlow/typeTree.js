	//////////////////tree object//////////////////////
		var tree;
		//default label for new item
		var newItemLabel = "New Item";
		//id for new (unsaved) item
		var newItemId = "-1";
		var gParentId = "0";
		var gFatherNodeType = "0";
		var treeXML;
		var IdPrefix = "workFlowTypeId";
		
		/////////////////grid//////////////////////////
		var timeoutHnd;
		var flAuto = false;
		
		
		var workFlowType = 
			{
			id:null, 					
			name:null,
			parentId:null,
			value:null
			};			
		
		
	   function getxml(treeXML){ loadTree(treeXML); }  	
       


       //load tree on page
	   function loadTree(treeXML){
			tree = new dhtmlXTreeObject("treebox","100%","100%",0);
			tree.setImagePath("image/tree/");
			tree.enableCheckBoxes(false)
			tree.setSubChecked(0,true);
			tree.enableThreeStateCheckboxes(true);
			tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
			tree.loadXMLString(treeXML);	
		}
		
      //为后边提供图片数组
       function preLoadImages(){
			var imSrcAr = new Array("line1.gif","line2.gif","line3.gif","line4.gif","minus2.gif","minus3.gif","minus4.gif","plus2.gif","plus3.gif","plus4.gif","book.gif","books_open.gif","books_close.gif","magazines_open.gif","magazines_close.gif","tombs.gif","tombs_mag.gif","book_titel.gif","iconCheckAll.gif")
			var imAr = new Array(0);
				for(var i=0;i<imSrcAr.length;i++){
					imAr[imAr.length] = new Image();
					imAr[imAr.length-1].src = "image/tree/"+imSrcAr[i]
				}
		}   	
	
			//what to do when item selected
		function doOnSelect(itemId){
//			alert(itemId);
			if(itemId != 'books'){
				$("viewFlowSchem").show();
				$("oaWorkFlowForm").hide();
	            var workFlowTypeId = tree.getUserData(itemId,"id");
				getWorkFlows(workFlowTypeId,0);
			}				
		}

			
 