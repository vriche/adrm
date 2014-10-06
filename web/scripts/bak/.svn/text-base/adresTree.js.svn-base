		//tree object
		var tree;
		//xml loader to load details from database
		var xmlLoader = new dtmlXMLLoaderObject(doLoadDetails,window);
		//default label for new item
		var newItemLabel = "New Item";
		//id for new (unsaved) item
		var newItemId = "-1";
		
		var treeXML;

       callOnLoad(init);	
     
       function init(){
       	    CarrierManager.getCarriersXml(0,getxml);	
       }
       function getxml(treeXML){
         	loadTree(treeXML);
       }
       
       

		//load tree on page
		function loadTree(treeXML){
            //init menu			
//			    aMenu=new dhtmlXContextMenuObject('120',0,"Demo menu"); 
//       		aMenu.menu.setGfxPath("/adrm_order/image/cmenu/"); 
//       		aMenu.menu.loadXML("_context.xml");
//       		aMenu.setContextMenuHandler(onMenuClick);		
       		
       		
       		//init tree
		    preLoadImages();
			tree = new dhtmlXTreeObject("treebox","100%","100%",0);
			tree.setImagePath("/adrm_order/image/tree/");
//			tree.enableCheckBoxes(true)
			tree.enableThreeStateCheckboxes(true);
			tree.enableDragAndDrop(true);
//			tree.enableItemEditor(true);
			
//          tree.enableContextMenu(aMenu); //link context menu to tree
//			tree.setDragHandler(doOnBeforeDrop);
//			tree.setOnClickHandler(doOnSelect);
// 			tree.setDragHandler(onDrop);//set function object to call on drop 
// 			tree.setOnClickHandler(doOnSelect);//set function object to call on node select 
// 			tree.setOnOpenHandler(aFunc);//set function to call on open/close node 
// 			tree.setOnCheckHandler(aFunc);//set function to call on open/close node 
// 			tree.setOnDblClickHandler(aFunc);//set function to call on dbl click
//            var treeXML = getCarriersXml(0);
//			alert(treeXML);
			tree.loadXMLString(treeXML);	
//			tree.loadXML("tree3.xml");
//			status();
		}
		
		
		function onMenuClick(id){ alert("Menu item "+id+" was clicked"); }		
		
		
		function preLoadImages(){
			var imSrcAr = new Array("line1.gif","line2.gif","line3.gif","line4.gif","minus2.gif","minus3.gif","minus4.gif","plus2.gif","plus3.gif","plus4.gif","book.gif","books_open.gif","books_close.gif","magazines_open.gif","magazines_close.gif","tombs.gif","tombs_mag.gif","book_titel.gif","iconCheckAll.gif")
			var imAr = new Array(0);
				for(var i=0;i<imSrcAr.length;i++){
					imAr[imAr.length] = new Image();
					imAr[imAr.length-1].src = "/adrm_order/image/tree/"+imSrcAr[i]
				}
		}
		
		function tonclick(id){
				alert("Item "+tree.getItemText(id)+" was selected");
		};
		function tondblclick(id){
				alert("Item "+tree.getItemText(id)+" was doubleclicked");
		};			
		function tondrag(id,id2){
				return confirm("Do you want to move node "+tree.getItemText(id)+" to item "+tree.getItemText(id2)+"?");
		};
		function tonopen(id,mode){
				return confirm("Do you want to "+(mode>0?"close":"open")+" node "+tree.getItemText(id)+"?");
		};
		function toncheck(id,state){
				alert("Item "+tree.getItemText(id)+" was " +((state)?"checked":"unchecked"));
		};		
		
		
		
		//add new node next to currently selected (or the first in tree)
		function addNewPeer(){
			if(tree.getLevel(newItemId)!=0){//check if unsaved item already exists
				alert("New Item (unsaved) already exists")
				return false;
			}
			var selectedId = tree.getSelectedItemId();
			if(selectedId!=""){
				tree.insertNewNext(selectedId,newItemId,newItemLabel,"","","","","SELECT,CALL",0)
			}else{
				tree.insertNewItem(0,newItemId,newItemLabel,"","","","","SELECT,CALL",0)
			}
		}
		
		//add new child node to selected item (or the first item in tree)
		function addNewChild(){
			if(tree.getLevel(newItemId)!=0){//check if unsaved item already exists
				alert("New Item (unsaved) already exists")
				return false;
			}
			var selectedId = tree.getSelectedItemId();
			if(selectedId!=""){
				tree.insertNewItem(selectedId,newItemId,newItemLabel,"","","","","SELECT,CALL",0)
			}else{
				tree.insertNewItem(0,newItemId,newItemLabel,"","","","","SELECT,CALL",0)
			}
		}
		
		//delete item (from database)
		function deleteNode(){
			status(true);
			var f = document.forms["detailsForm"];
			if(tree.getSelectedItemId()!=newItemId){//delete node from db
				if(!confirm("Are you sure you want to delete selected node?"))
					return false;
				f.action = "deletenode.php"
				f.submit()
			}else{//delete unsaved node
				doDeleteTreeItem(newItemId);
			}
		}
		
		//remove item from tree
		function doDeleteTreeItem(id){
			document.getElementById("details").style.visibility = "hidden";
			var pId = tree.getParentId(id);
			tree.deleteItem(id);
			if(pId!="0")
				tree.selectItem(pId,true);
			status();
		}
		
		//save item
		function saveItem(){
			status(true);
			var f = document.forms["detailsForm"];
			f.action = "savenode.php";
			f.submit();
		}
		
		//save moved (droped) item to db. Cancel drop if save failed or item is new
		function doOnBeforeDrop(id,parentId){
			if(id==newItemId)
				return false;
			else{
				status(true);
				var dropSaver = new dtmlXMLLoaderObject(null,null,false);//sync mode
//				dropSaver.loadXML("dropprocessor.php?id="+id+"&parent_id="+parentId);
//              dropSaver.loadXMLString(treeXML);	
				dropSaver.loadXML("tree.xml");
				var root = dropSaver.getXMLTopNode("succeedded");
				var id = root.getAttribute("id");
				if(id==-1){
					alert("Save failed");
					status();
					return false;
				}else{
					if(tree.getSelectedItemId()==id){//update details (really need only parent id)
						loadDetails(id);
					}
				}
				status();
				return true;
			}
		}
		
		//update item
		function doUpdateItem(id, label){
			var f = document.forms["detailsForm"];
			f.item_id.value = id;
			tree.changeItemId(tree.getSelectedItemId(),id);
			tree.setItemText(id,label);
			tree.setItemColor(id,"black","white");
			status();
		}
		
		//what to do when item selected
		function doOnSelect(itemId){
			if(itemId!=newItemId){
				if(tree.getLevel(newItemId)!=0){
					if(confirm("Do you want to save changes?")){//save changes to new item
						tree.selectItem(newItemId,false)
						saveItem();
						return;
					}
					tree.deleteItem(newItemId);
				}	
			}else{//set color to new item label
				tree.setItemColor(itemId,"red","pink")
			}
			loadDetails(itemId);//load details for selected item
		}
		//send request to the server to load details
		function loadDetails(id){
			status(true);
//			xmlLoader.loadXML("loaddetails.php?id="+id);
            CarrierManager.getCarriersXml(id,getDetailsXML);
//            xmlLoader.loadXMLString(treeXML3);	
//            xmlLoader.loadXML("tree.xml");
		}

       function getDetailsXML(treeXML){
         	xmlLoader.loadXMLString(treeXML);	
       }
       		
		
		
		
		//populate form of details
		function doLoadDetails(obj){
			var f = document.forms["detailsForm"];
			var root = xmlLoader.getXMLTopNode("details")
			var id = root.getAttribute("id");
			
			
			document.getElementById("details").style.visibility = "visible";
			if(id==newItemId){
				f.item_nm.value = tree.getItemText(id);
				f.item_desc.value = "";
			}else{
				f.item_nm.value = root.getElementsByTagName("name")[0].firstChild.nodeValue;
				if(root.getElementsByTagName("desc")[0].firstChild!=null)
					f.item_desc.value = root.getElementsByTagName("desc")[0].firstChild.nodeValue;
				else
					f.item_desc.value = "";
			}
			f.item_id.value = id
			f.item_parent_id.value = tree.getParentId(id);
			status();
			
		}
		
		//show status of request on page
		function status(fl){
			var d = document.getElementById("showproc");
			if(fl)
				d.style.display = "";
			else
				d.style.display = "none";
		}