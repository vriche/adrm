
//使用方法:
//<html>
//<body>
//<div id="toolTipLayer" style="position:absolute; visibility: hidden"></div><script>initToolTips()</script>
//<a id="Hyperlink1" class="word" NAME="Hyperlink1" href="ksdtxx_detail.aspx?BoardID=179">博客园1</a>
//<a id="Hyperlink2" class="word" NAME="Hyperlink2" href="ksdtxx_detail.aspx?BoardID=179">博客园2</a>
//</body>
//</html>
// <script type="text/javascript">
//        tip = new Tip("Hyperlink1", "博客园1");
//        ToolTip.Add(tip);
//
//        tip = new Tip("Hyperlink2", "博客园2");
//        ToolTip.Add(tip);
//
//ToolTip.Init();
//</script>


function ToolTip()
    {
    }
   
    ToolTip.Items = [];
   
    ToolTip.Add = function(tip)
    {
        this.Items.push(tip);
    };
   
    ToolTip.Init = function()
    {
        for(var i=0; i<this.Items.length; ++i)
        {
            var tip = this.Items[i];
            var obj = document.getElementById(tip.ID);
            obj.Object = tip;
            obj.timer = null;
           
            obj.onmousemove = function(evt)
            {
                var o = this.Object;
                if( o.Tip == null )
                {
                    var div = document.createElement("DIV");
                    div.id = "toolTip";
                    if(!o.Border) o.Border = "solid 2px ";
                    if(!o.BorderColor) o.BorderColor = "red";
                    if(!o.BgColor) o.BgColor = "white";
                    if(!o.Color) o.Color = "black";
                    div.innerHTML = o.Text;
                   
                    with(div.style)
                    {
                        border = o.Border + o.BorderColor;
                        backgroundColor = o.BgColor;
                        position = "absolute";
                        display = "none";
                        padding = "5px";
                        fontSize = "9pt";
                        textAlign = "left";
                        color = o.Color;
                    }

                    document.body.appendChild(div);
                   
                    o.Tip = div;
                }
               
                var left,top;
                if( evt )
                {
                    left = evt.clientX;
                    top = evt.clientY;
                }
                else
                {
                    left = event.x;
                    top = event.y;
                }
              
                left += (window.document.documentElement.scrollLeft + 10);
                top += (window.document.documentElement.scrollTop + 10);
               
                window.stats = left + "," + top;
               
                o.Tip.style.top = top + "px";
                o.Tip.style.left = left + "px";
                if( o.Tip.style.display == "none")
                {
                    ToolTip.DoFading("Fade", false, o.Tip);
                }
            };
          
           obj.onmouseover = function(evt)
           {
                this.timer = window.setTimeout(ToolTip.HideToolTip, 5000, this);
           };
           
            obj.onmouseout = function(evt)
            {
                ToolTip.DoFading("Fade", true, this.Object.Tip);
                window.clearTimeout(this.timer);
            };
        }
    };
   
    ToolTip.HideToolTip = function(e)
    {
         ToolTip.DoFading("Fade", true, e.Object.Tip);
         window.clearTimeout(e.timer);
    };
   
    ToolTip.GetFilters = function(effect, e, alphaValue)
    {
     var filterString = 'progid:DXImageTransform.Microsoft.';
     switch(effect)
     {
      case 'GradientWipeLeft2Right' :
      {
       filterString += "GradientWipe(duration='0.5',gradientSize='0.75',motion='forward')";
       break;
      }
      case 'GradientWipeUp2Down' :
      {
       filterString += "GradientWipe(duration='0.5',gradientSize='0.25',motion='forward',wipeStyle='1')";
       break;
      }
      case 'RevealTrans' :
      {
       filterString += "RevealTrans(duration='0.5',transition='12')";
       break;
      }
      case 'Fade' :
      {
       filterString += 'Fade()';
       break;
      }
      case 'Alpha':
      {
          filterString += 'Alpha(' + alphaValue + ')';
          break;
      }
      default :
      {
       filterString = ''; 
       break;
      }
     }
    
     e.style.filter = filterString;
    };
   
    ToolTip.DoFading = function(effect, out, e)
    {
     this.GetFilters(effect, e);
        if( e.filters && e.filters.length > 0 )
        {
            var filter = e.filters.item(0);
            filter.apply();
            if( out )
            {
                e.style.display = "";
                e.style.display = "none";
                filter.play(0.25);
            }
            else
            {
                e.style.display = "none";
                e.style.display = "";
                filter.play(0.25);
            }      
     }
     else
     {
         e.style.display = out ? "none" : "";
     }
    };
       
    function Tip(id, text, border, borderColor, backgroundColor, color)
    {
        this.ID = id;
        this.Text = text;
        this.Border = border;
        this.BorderColor = borderColor;
        this.BgColor = backgroundColor;
        this.Color = color;
        this.Tip = null;
    }