<%@ page contentType="text/html;charset=gbk" language="java" %>
<%--
/* Licence:
*   Use this however/wherever you like, just don't blame me if it breaks anything.
*
* Credit:
*   If you're nice, you'll leave this bit:
*
*   Class by Pierre-Alexandre Losson -- http://www.telio.be/blog
*   email : plosson@users.sourceforge.net
*/
--%>
<html>
    <head>
        <title>导入收视数据</title>
        <script src='/adrm/samples/upload.js'> </script>
        <script src='/adrm/dwr/interface/UploadMonitor.js'> </script>
        <script src='/adrm/dwr/engine.js'> </script>
        <script src='/adrm/dwr/util.js'> </script>
        <style type="text/css">
            body { font: 11px Lucida Grande, Verdana, Arial, Helvetica, sans serif; }
            #progressBar { padding-top: 5px; }
            #progressBarBox { width: 350px; height: 20px; border: 1px inset; background: #eee;}
            #progressBarBoxContent { width: 0; height: 20px; border-right: 1px solid #444; background: #9ACB34; }
        </style>
    </head>
<body>

<form name="myform" action="/adrm/importExcelServlet" enctype="multipart/form-data" method="post" >
    <p>
        <h1>导入收视数据</h1>
    </p>

    <p>
       <br/>
       
        <input class="default" type="file" id="file1" name="file1"/><br/>
        <input class="default" type="file" id="file2" name="file2"/><br/>
        <input class="default" type="file" id="file3" name="file3"/><br/>
        <input class="default" type="file" id="file4" name="file4"/><br/>
        <input type="button" value=" 开始导入 " id="uploadbutton" onclick="startProgress()"/> <br/>
       
         <!-- input  type="text" id="message" name="message" value="<%=request.getAttribute("message")%>" /><br/ -->
       
   
        <script>
           //alert()
        </script>

        <div id="progressBar" style="display: none;">

            <div id="theMeter">
                <div id="progressBarText"></div>

                <div id="progressBarBox">
                    <div id="progressBarBoxContent"></div>
                </div>
            </div>
        </div>
    </p>
</form>
</body>
</html>