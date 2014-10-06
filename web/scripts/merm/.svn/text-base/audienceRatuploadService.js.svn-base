/* Licence:
*   Use this however/wherever you like, just don't blame me if it breaks anything.
*
* Credit:
*   If you're nice, you'll leave this bit:
*
*   Class by Pierre-Alexandre Losson -- http://www.telio.be/blog
*   email : plosson@users.sourceforge.net
*/
function refreshProgress()
{
    UploadMonitor.getUploadInfo(updateProgress);
}

function updateProgress(uploadInfo)
{
    if (uploadInfo.inProgress)
    {
        document.getElementById('uploadbutton').disabled = true;
        document.getElementById('file1').disabled = true;
        document.getElementById('file2').disabled = true;
        document.getElementById('file3').disabled = true;
        document.getElementById('file4').disabled = true;

        var fileIndex = uploadInfo.fileIndex;

        var progressPercent = Math.ceil((uploadInfo.bytesRead / uploadInfo.totalSize) * 100);

        document.getElementById('progressBarText').innerHTML = 'upload in progress: ' + progressPercent + '%';

        document.getElementById('progressBarBoxContent').style.width = parseInt(progressPercent * 3.5) + 'px';

        window.setTimeout('refreshProgress()', 1000);
    }
    else
    {
        document.getElementById('uploadbutton').disabled = false;
        document.getElementById('file1').disabled = false;
        document.getElementById('file2').disabled = false;
        document.getElementById('file3').disabled = false;
        document.getElementById('file4').disabled = false;
    }

    return true;
}

function startProgress()
{
    if(ckeckFilesTypes()){
    	    //document.myform.action = "/adrm/importExcelServlet";
    	    document.myform.submit();
    	    
	    document.getElementById('progressBar').style.display = 'block';
	    document.getElementById('progressBarText').innerHTML = 'upload in progress: 0%';
	    document.getElementById('uploadbutton').disabled = true;
	
	    // wait a little while to make sure the upload has started ..
	    window.setTimeout("refreshProgress()", 1500);
	    return true;	
    	
    }else{
    
        return false;
     }

}

function ckeckFileType(el){
	 var AllowExt=".xls|"  //允许上传的文件类型 ?为无限制 每个扩展名后边要加一个"|" 小写字母表示  
	 var File1 =  el;
	 var FileExt=File1.value.substr(File1.value.lastIndexOf(".")).toLowerCase();  
	  
	 if(AllowExt!=0&&AllowExt.indexOf(FileExt+"|")==-1)  //判断文件类型是否允许上传  
   	{  
	     var ErrMsg="\n该文件类型不允许上传。请上传 "+AllowExt+" 类型的文件，当前文件类型为"+FileExt;  
	     alert(ErrMsg);  
	     return false;  
  	}else{
  	     return true;  
  	
	}

}

function ckeckFilesTypes(){
	 var File1 =  document.getElementById('file1');
	 var File2 =  document.getElementById('file2');
	 var File3 =  document.getElementById('file3');
	 var File4 =  document.getElementById('file4');
	 if(File1.value !="")  return ckeckFileType(File1);
	 if(File2.value !="")  return ckeckFileType(File2);
	 if(File3.value !="")  return ckeckFileType(File3);
	 if(File4.value !="")  return ckeckFileType(File4);
}


