    /** 
     * Ext.hoo.component.FileBrowserWindow 系统文件浏览选择组件，可以选定电脑上的文件或文件夹 
     * @author: hoojo 
     * @createDate 2010-10-17 
     * @email: hoojo_@126.com 
     * @blog: http://blog.csdn.net/IBM_hoojo 
     * @ext_lib: v2.2 
     * @version 1.0  
     */  
    Ext.ns("Ext.hoo.component");  
    Ext.hoo.component.FileBrowserWindow = Ext.extend(Ext.Window, {  
        constructor: function (config) {  
            config = config || {};  
            Ext.apply(this, config);  
            this.tree = new Ext.hoo.tree.FileSystemTree();  
            Ext.hoo.component.FileBrowserWindow.superclass.constructor.call(this, {  
                renderTo: Ext.getBody(),  
                width: 300,  
                height: 300,  
                frame: true,  
                layout: "fit",  
                border: false,  
                title: "请选择",  
                items: this.tree,  
                buttons: [{  
                    text: "新建",  
                    disabled: true,  
                    handler: this.onNewHandler,  
                    scope: this  
                },
                
//                {  
//                    text: "上传",  
//                    disabled: true,  
//                    handler: this.onUploadHandler,  
//                    scope: this  
//                }, 
                
                {  
                    text: "确定",  
                    disabled: true,  
                    handler: this.onOkHandler,  
                    scope: this  
                }, {  
                    text: "取消",  
                    handler: function () {  
                        this.hide(Ext.getBody());  
                    },  
                    scope: this  
                }]  
            });  
        },  
        onNewHandler: function () {  
            this.setPath();  
            this.setFile();  
            Ext.Msg.prompt("新建文件", "请输入文件夹名称", this.onCreateDir, this);  
        },  
   onUploadHandler: function () {  
 
//					new Ext.Window({
//						width : 650,
//						title : 'swfUpload demo',
//						height : 300,
//						layout : 'fit',
//						items : [
//							{
//								xtype:'uploadPanel',
//								border : false,
//								fileSize : 1024*550,//限制文件大小
//								uploadUrl : 'uploadFiles.action',
//								flashUrl : 'swfupload.swf',
//								filePostName : 'file', //后台接收参数
//								fileTypes : '*.*',//可上传文件类型
//								postParams : {savePath:'upload\\'} //上传文件存放目录
//							}
//						]
//					}).show();

        },  
        onOkHandler: function () {  
            this.setPath();  
            this.setFile();  
            Ext.Msg.alert("路径", this.getPath());  
        },   
        onCreateDir: function (btn, text) {  
            if (btn == "ok") {  
                var path = this.getPath();  
                var node = this.getFile();  
                var dirName = text;  
                if (!!path && !!dirName) {  
                    //本地添加模式  
                    /*var newNode = new Ext.tree.AsyncTreeNode({ 
                        text: dirName, 
                        path: node.attributes.path + "/" + dirName 
                    }); 
                    node.expand(true, true); 
                    node.appendChild(newNode);*/  
                    //远程加载模式  
                    Ext.Ajax.request({  
                        url: Ext.hoo.tree.FileSystemTree.TREE_CREATE_DIR_URL,  
                        params: {path: encodeURIComponent(path), dirName: encodeURIComponent(dirName)},//处理中文文件名，乱码问题  
                        success: function (response, options) {  
                            var returnNnode = Ext.decode(response.responseText);  
                            node.appendChild(returnNnode);  
                            node.expand(true);  
                        },  
                        failure: function (response) {  
                            Ext.Msg.alert("程序异常", response.responseText);  
                        }  
                    });  
                }  
            }  
        },  
        setPath: function () {  
            this.path = this.tree.getSelectedNode().attributes.path || "";  
        },  
        setFile: function () {  
            this.nodeFile = this.tree.getSelectedNode() || {};  
        },  
        getPath: function () {  
            return this.path;     
        },  
        getFile: function () {  
            return this.nodeFile;  
        }  
    });  
      
    /** 
     * Ext.hoo.component.FileBrowserPanel 系统文件浏览选择组件，可以选定电脑上的文件或文件夹 
     * 不同于上面的是，这里是一个panel。有时候弹出window，并不能达到预想的效果。特别是window弹出在 
     * iframe中的Object对象上面，如：在播放器上面弹出此组件，拖动windwo的效果不理想。 
     * 这时就需要用模态，模态嵌入FileBrowserPanel组件即可 
     * @author: hoojo 
     * @createDate 2010-10-17 
     * @email: hoojo_@126.com 
     * @blog: http://blog.csdn.net/IBM_hoojo 
     * @ext_lib: v2.2 
     * @version 1.0  
     */  
    Ext.hoo.component.FileBrowserPanel = Ext.extend(Ext.Panel, {  
        constructor: function (config) {  
            config = config || {};  
            Ext.apply(this, config);  
            this.tree = new Ext.hoo.tree.FileSystemTree();  
            Ext.hoo.component.FileBrowserPanel.superclass.constructor.call(this, {  
                renderTo: Ext.getBody(),  
                border: false,  
                width: 300,  
                height: 400,  
                layout: "fit",  
                title: "请选择",  
                items: this.tree,  
                buttons: [{  
                    text: "新建",  
                    disabled: true,  
                    handler: this.onNewHandler,  
                    scope: this  
                },
                
//                {  
//                    text: "上传",  
//                    disabled: true,  
//                    handler: this.onUploadHandler,  
//                    scope: this  
//                }, 
                
                {  
                    text: "确定",  
                    disabled: true,  
                    handler: function () {  
                        this.path = this.tree.getSelectedNode().attributes.path || "";  
                        this.nodeFile = this.tree.getSelectedNode() || {};  
                        //window.returnValue = this.path;  
                        //window.close();  
                        Ext.Msg.alert("路径", this.path);  
                    },  
                    scope: this  
                }, {  
                    text: "取消",  
                    handler: function () {  
                        this.hide(Ext.getBody());  
                        //window.close();  
                    },  
                    scope: this  
                }]  
            });  
        },  
        onNewHandler: function () {  
            this.setPath();  
            this.setFile();  
            Ext.Msg.prompt("新建文件", "请输入文件夹名称", this.onCreateDir, this);  
        }, 
        
          onUploadHandler: function () {  
          	
//						    var dialog = new Ext.ux.UploadDialog.Dialog(null, {  
//						              autoCreate: true,  
//						              closable: true,  
//						              collapsible: false,  
//						              draggable: true,  
//						              minWidth: 400,        
//						              minHeight: 200,  
//						              width: 400,  
//						              height: 350,  
//						              permitted_extensions:['JPG','jpg','jpeg','JPEG','GIF','gif'],  
//						              proxyDrag: true,  
//						              resizable: true,  
//						              constraintoviewport: true,  
//						              title: '文件上传',  
//						              url: 't_file_upload.php',  
//						              reset_on_hide: false,  
//						              allow_close_on_upload: true  
//						            });  
//						    dialog.show();  


//Ext.QuickTips.init();
//	new Ext.Window({
//		width : 650,
//		title : 'swfUpload demo',
//		height : 300,
//		layout : 'fit',
//		items : [
//			{
//				xtype:'uploadPanel',
//				border : false,
//				fileSize : 1024*50,
//				uploadUrl : 'uploadFiles.action',
//				flashUrl : 'swfupload.swf',
//				filePostName : 'file',
//				fileTypes : '*.*',
//				postParams : {savePath:'upload\\'}
//			}
//		]
//	}).show();
 
//var win = new Ext.Window({
//        title : '多文件上传示例',
//        width : 500,
//        height : 500,
//        resizable : false,
//        layout : 'fit',
//        items : [{
//            xtype : 'uploadpanel',
//            uploadUrl : 'uploadFiles.action',
//            filePostName : 'myUpload', // 这里很重要，默认值为'fileData',这里匹配action中的setMyUpload属性
//            flashUrl : 'js/swfupload.swf',
//            fileSize : '500 MB',
//            height : 400,
//            border : false,
//            fileTypes : '*.*', // 在这里限制文件类型:'*.jpg,*.png,*.gif'
//            fileTypesDescription : '所有文件',
//            postParams : {
//                path : 'files\\' // 上传到服务器的files目录下面
//            }
//        }],
//        bbar : ['作者:廖瀚卿 | QQ:3990995 | 博客:http://yourgame.javaeye.com']
//    });
//
//    win.show();



        },  
        onCreateDir: function (btn, text) {  
            if (btn == "ok") {  
                var path = this.getPath();  
                var node = this.getFile();  
                var dirName = text;  
                if (!!path && !!dirName) {  
                    //本地添加模式  
                    /*var newNode = new Ext.tree.AsyncTreeNode({ 
                        text: dirName, 
                        path: node.attributes.path + "/" + dirName 
                    }); 
                    node.expand(true, true); 
                    node.appendChild(newNode);*/  
                    //远程加载模式  
                    Ext.Ajax.request({  
                        url: Ext.hoo.tree.FileSystemTree.TREE_CREATE_DIR_URL,  
                        params: {path: encodeURIComponent(path), dirName: encodeURIComponent(dirName)},//处理中文文件名，乱码问题  
                        success: function (response, options) {  
                            var returnNnode = Ext.decode(response.responseText);  
                            node.appendChild(returnNnode);  
                            node.expand(true, true);  
                        },  
                        failure: function (response) {  
                            Ext.Msg.alert("程序异常", response.responseText);  
                        }  
                    });  
                }  
            }  
        },  
        setPath: function () {  
            this.path = this.tree.getSelectedNode().attributes.path || "";  
        },  
        setFile: function () {  
            this.nodeFile = this.tree.getSelectedNode() || {};  
        },  
        getPath: function () {  
            return this.path;     
        },  
        getFile: function () {  
            return this.nodeFile;  
        }  
    });  
      
    /** 
     * Ext.hoo.tree.FileSystemTree 系统文件树，显示所有的文件 
     * @author: hoojo 
     * @createDate 2010-10-17 
     * @email: hoojo_@126.com 
     * @blog: http://blog.csdn.net/IBM_hoojo 
     * @ext_lib: v2.2 
     * @version 1.0  
     */  
    Ext.ns("Ext.hoo.tree");  
    Ext.hoo.tree.FileSystemTree = Ext.extend(Ext.tree.TreePanel, {  
        constructor: function () {        
            Ext.hoo.tree.FileSystemTree.superclass.constructor.call(this, {  
                //rootVisible: false,  
                autoScroll: true,  
                root: new Ext.tree.AsyncTreeNode({  
                    text: Ext.hoo.tree.FileSystemTree.TREE_ROOT_LABLE,  
                    id: "0",  
//                    expand: true,
//                    path: "/usr/local/java/jakarta-tomcat-5.0.28/webapps/ctr_data",  
                       path: Ext.hoo.tree.FileSystemTree.TREE_ROOT_PATH,  
                    
                    children:[]  
                }),  
                listeners: {  
                    expandnode: {  
                        fn: this.onExpandNode,  
                        scope: this  
                    }  
                }  
            });  
        },  
        onExpandNode: function (node) {  
            //只对未加载过的添加子结点，加载后不在重复加载；避免增加请求，浪费资源  
            if (!node.attributes.isLoad) { 

                Ext.Ajax.request({  
                    url: Ext.hoo.tree.FileSystemTree.TREE_DATA_URL,  
                    params: {path: encodeURIComponent(node.attributes.path)},//处理中文文件名，乱码问题  
                    success: function (response, options) {  
                        node.attributes.isLoad = true;//设置加载标示  
                        var nodes = Ext.decode(response.responseText);  
                        node.appendChild(nodes);  
                    },  
                    failure: function (response) {  
                        Ext.Msg.alert("程序异常", response.responseText);  
                    }  
                });  
            }  
        },   
        getSelectedNode: function () {  
            return this.getSelectionModel().getSelectedNode();  
        }  
    });  
    
//	Ext.hoo.tree.FileSystemTree.TREE_CREATE_DIR_URL = "http://127.0.0.1:8081/adrm/servlet/fileBrowserServlet?method=mkDir";  
//	Ext.hoo.tree.FileSystemTree.TREE_DATA_URL = "http://127.0.0.1:8081/adrm/servlet/fileBrowserServlet?method=getData";  