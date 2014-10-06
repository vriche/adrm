	//////////////////tree object//////////////////////
		var treeUserIncome;
		var treeUserCheck;
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
			treeUserIncome = new dhtmlXTreeObject("treeBoxUserIncome","100%","100%",0);
			treeUserIncome.setImagePath("image/tree/");
			treeUserIncome.enableCheckBoxes(true)
			treeUserIncome.setSubChecked(0,true);
			treeUserIncome.enableThreeStateCheckboxes(true);
//			treeUserIncome.setOnClickHandler(doOnSelect);//set function to call on dbl click
			treeUserIncome.loadXMLString(userTreeXML);	
		
			
			treeUserCheck = new dhtmlXTreeObject("treeBoxUserCheck","100%","100%",0);
			treeUserCheck.setImagePath("image/tree/");
			treeUserCheck.enableCheckBoxes(true)
			treeUserCheck.setSubChecked(0,true);
			treeUserCheck.enableThreeStateCheckboxes(true);
//			treeUserCheck.setOnClickHandler(doOnSelect);//set function to call on dbl click

			treeUserCheck.loadXMLString(userTreeXML);	
		}


		function loadDataTree(treeName,ids){
			//Ë¢ÐÂÊý
			refreshTree(treeName);
			
			for (var i = 0; i < ids.length; i++){
				for (var j = 0; j < ids[i].length; j++){
					treeName.setCheck(IdPrefix + ids[i][j],1);					
				}
		}
		
		
		

}
		
	
	


			
 