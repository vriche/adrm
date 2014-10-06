	//////////////////tree object//////////////////////
		var treeUserPermit;
		var userTreeXML;
		var IdPrefix="uid"
		

		var user = 
			{
			id:null, 					
			username:null
			};			
		
		
	   function getUserXML(userTreeXML){ loadTreeUser(userTreeXML); }  	
       


       //load tree on page
	   function loadTreeUser(userTreeXML){
			treeUserPermit = new dhtmlXTreeObject("treeBoxUserPermit","100%","100%",0);
			treeUserPermit.setImagePath("image/tree/");
			treeUserPermit.enableCheckBoxes(true)
			treeUserPermit.setSubChecked(0,true);
			treeUserPermit.enableThreeStateCheckboxes(true);
			treeUserPermit.loadXMLString(userTreeXML);	
		}


		function loadDataTree(treeName,ids){
			//Ë¢ÐÂÊý
			refreshTree(treeName);
			if(ids != '' || ids != null){
				for (var i = 0; i < ids.length; i++){
					for (var j = 0; j < ids[i].length; j++){
						treeName.setCheck(IdPrefix +ids[i][j],1);					
					}				
				}
			}
		}	




			
 