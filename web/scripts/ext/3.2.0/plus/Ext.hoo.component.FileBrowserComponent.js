    /** 
     * Ext.hoo.component.FileBrowserWindow ϵͳ�ļ����ѡ�����������ѡ�������ϵ��ļ����ļ��� 
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
                title: "��ѡ��",  
                items: this.tree,  
                buttons: [{  
                    text: "�½�",  
                    disabled: true,  
                    handler: this.onNewHandler,  
                    scope: this  
                },
                
//                {  
//                    text: "�ϴ�",  
//                    disabled: true,  
//                    handler: this.onUploadHandler,  
//                    scope: this  
//                }, 
                
                {  
                    text: "ȷ��",  
                    disabled: true,  
                    handler: this.onOkHandler,  
                    scope: this  
                }, {  
                    text: "ȡ��",  
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
            Ext.Msg.prompt("�½��ļ�", "�������ļ�������", this.onCreateDir, this);  
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
//								fileSize : 1024*550,//�����ļ���С
//								uploadUrl : 'uploadFiles.action',
//								flashUrl : 'swfupload.swf',
//								filePostName : 'file', //��̨���ղ���
//								fileTypes : '*.*',//���ϴ��ļ�����
//								postParams : {savePath:'upload\\'} //�ϴ��ļ����Ŀ¼
//							}
//						]
//					}).show();

        },  
        onOkHandler: function () {  
            this.setPath();  
            this.setFile();  
            Ext.Msg.alert("·��", this.getPath());  
        },   
        onCreateDir: function (btn, text) {  
            if (btn == "ok") {  
                var path = this.getPath();  
                var node = this.getFile();  
                var dirName = text;  
                if (!!path && !!dirName) {  
                    //�������ģʽ  
                    /*var newNode = new Ext.tree.AsyncTreeNode({ 
                        text: dirName, 
                        path: node.attributes.path + "/" + dirName 
                    }); 
                    node.expand(true, true); 
                    node.appendChild(newNode);*/  
                    //Զ�̼���ģʽ  
                    Ext.Ajax.request({  
                        url: Ext.hoo.tree.FileSystemTree.TREE_CREATE_DIR_URL,  
                        params: {path: encodeURIComponent(path), dirName: encodeURIComponent(dirName)},//���������ļ�������������  
                        success: function (response, options) {  
                            var returnNnode = Ext.decode(response.responseText);  
                            node.appendChild(returnNnode);  
                            node.expand(true);  
                        },  
                        failure: function (response) {  
                            Ext.Msg.alert("�����쳣", response.responseText);  
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
     * Ext.hoo.component.FileBrowserPanel ϵͳ�ļ����ѡ�����������ѡ�������ϵ��ļ����ļ��� 
     * ��ͬ��������ǣ�������һ��panel����ʱ�򵯳�window�������ܴﵽԤ���Ч�����ر���window������ 
     * iframe�е�Object�������棬�磺�ڲ��������浯����������϶�windwo��Ч�������롣 
     * ��ʱ����Ҫ��ģ̬��ģ̬Ƕ��FileBrowserPanel������� 
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
                title: "��ѡ��",  
                items: this.tree,  
                buttons: [{  
                    text: "�½�",  
                    disabled: true,  
                    handler: this.onNewHandler,  
                    scope: this  
                },
                
//                {  
//                    text: "�ϴ�",  
//                    disabled: true,  
//                    handler: this.onUploadHandler,  
//                    scope: this  
//                }, 
                
                {  
                    text: "ȷ��",  
                    disabled: true,  
                    handler: function () {  
                        this.path = this.tree.getSelectedNode().attributes.path || "";  
                        this.nodeFile = this.tree.getSelectedNode() || {};  
                        //window.returnValue = this.path;  
                        //window.close();  
                        Ext.Msg.alert("·��", this.path);  
                    },  
                    scope: this  
                }, {  
                    text: "ȡ��",  
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
            Ext.Msg.prompt("�½��ļ�", "�������ļ�������", this.onCreateDir, this);  
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
//						              title: '�ļ��ϴ�',  
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
//        title : '���ļ��ϴ�ʾ��',
//        width : 500,
//        height : 500,
//        resizable : false,
//        layout : 'fit',
//        items : [{
//            xtype : 'uploadpanel',
//            uploadUrl : 'uploadFiles.action',
//            filePostName : 'myUpload', // �������Ҫ��Ĭ��ֵΪ'fileData',����ƥ��action�е�setMyUpload����
//            flashUrl : 'js/swfupload.swf',
//            fileSize : '500 MB',
//            height : 400,
//            border : false,
//            fileTypes : '*.*', // �����������ļ�����:'*.jpg,*.png,*.gif'
//            fileTypesDescription : '�����ļ�',
//            postParams : {
//                path : 'files\\' // �ϴ�����������filesĿ¼����
//            }
//        }],
//        bbar : ['����:����� | QQ:3990995 | ����:http://yourgame.javaeye.com']
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
                    //�������ģʽ  
                    /*var newNode = new Ext.tree.AsyncTreeNode({ 
                        text: dirName, 
                        path: node.attributes.path + "/" + dirName 
                    }); 
                    node.expand(true, true); 
                    node.appendChild(newNode);*/  
                    //Զ�̼���ģʽ  
                    Ext.Ajax.request({  
                        url: Ext.hoo.tree.FileSystemTree.TREE_CREATE_DIR_URL,  
                        params: {path: encodeURIComponent(path), dirName: encodeURIComponent(dirName)},//���������ļ�������������  
                        success: function (response, options) {  
                            var returnNnode = Ext.decode(response.responseText);  
                            node.appendChild(returnNnode);  
                            node.expand(true, true);  
                        },  
                        failure: function (response) {  
                            Ext.Msg.alert("�����쳣", response.responseText);  
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
     * Ext.hoo.tree.FileSystemTree ϵͳ�ļ�������ʾ���е��ļ� 
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
            //ֻ��δ���ع�������ӽ�㣬���غ����ظ����أ��������������˷���Դ  
            if (!node.attributes.isLoad) { 

                Ext.Ajax.request({  
                    url: Ext.hoo.tree.FileSystemTree.TREE_DATA_URL,  
                    params: {path: encodeURIComponent(node.attributes.path)},//���������ļ�������������  
                    success: function (response, options) {  
                        node.attributes.isLoad = true;//���ü��ر�ʾ  
                        var nodes = Ext.decode(response.responseText);  
                        node.appendChild(nodes);  
                    },  
                    failure: function (response) {  
                        Ext.Msg.alert("�����쳣", response.responseText);  
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