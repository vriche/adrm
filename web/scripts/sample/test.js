function checkword()
{
   var wordvalue=document.getElementById("word").value.toLowerCase();
   var alltxt="管理员|apple苹果|all全|big大|bad坏|cut剪切|car车|daph8|eeg|egg|eat|fuck|fuck you|fix|good|hand|hidden|ill|jack|jad|kevin|long|man|number|oio|part|pp|quit|QQ|rest|reg|set|submit|time|tag|uuzo.cn|uuzo|view|windows|want|xy|xun|young|yuyu|zoo|Zzz|锋.David|David|哈哈|[url]www.uuzo.cn[/url]|[url]www.uuzo.com[/url]";
   var alltxtpp=alltxt.toLowerCase();
   var alltxt_xiang=alltxt.split("|");
   var alltxt_xiang1=alltxtpp.split("|");
   var inhtml="<ul>"
   var isyou=0;
   for (i=0;i<alltxt_xiang1.length;i++)
   {
       if (alltxt_xiang1[i].substr(0,wordvalue.length)==wordvalue)
       {
           inhtml=inhtml+"<li onclick=\"document.getElementById('word').value=this.innerHTML;document.getElementById('showmenu').style.display='none';\" onmouseover=\"this.style.backgroundColor='#666666'\" onmouseout=\"this.style.backgroundColor=''\">"+alltxt_xiang[i]+"</li>";
           isyou=1;
       }
   }
   inhtml=inhtml+"</ul>";
   if (isyou==1)
   {
       document.getElementById("showmenu").innerHTML=inhtml;
       document.getElementById("showmenu").style.display="";
   }
   else
   {
       document.getElementById("showmenu").innerHTML="";
       document.getElementById("showmenu").style.display="none";
   }
   if (wordvalue=="")
   {
       document.getElementById("showmenu").innerHTML="";
       document.getElementById("showmenu").style.display="none";
   }
}