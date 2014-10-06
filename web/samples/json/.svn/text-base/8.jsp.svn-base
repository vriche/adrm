 <%  
String start = request.getParameter("start");  
String limit = request.getParameter("limit");  
try {  
    int index = Integer.parseInt(start);  
    int pageSize = Integer.parseInt(limit);  
  
    String json = "{totalCount:100,items:[";  
  
        for (int i = index; i < pageSize + index; i++) {  
            json += "{id:" + i + ",name:'name" + i + "',descn:'descn" + i + "',date:'2010-01-01'}";  
            if (i != pageSize + index - 1) {  
                json += ",";  
            }  
        }  
    json += "]}";  
    response.getWriter().write(json);  
    System.out.println(json);  
} catch(Exception ex) {  
}  
%>    