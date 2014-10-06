
package com.vriche.adrm.webapp.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.service.ResourceChannelManager;
import com.vriche.adrm.webapp.form.ResourceChannelForm;

/**
 * Action class to handle CRUD on a ResourceChannel object
 *
 * @struts.action name="resourceChannelForm" path="/resourceChannels" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="resourceChannelForm" path="/editResourceChannel" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="resourceChannelForm" path="/saveResourceChannel" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/resourceChannelForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/resourceChannelList.jsp"
 * @struts.action-forward name="search" path="/resourceChannels.html" redirect="true"
 */
public final class ResourceChannelAction extends BaseAction {
    public ActionForward cancel(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        return mapping.findForward("search");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'delete' method");
        }

        ActionMessages messages = new ActionMessages();
        ResourceChannelForm resourceChannelForm = (ResourceChannelForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ResourceChannelManager mgr = (ResourceChannelManager) getBean("resourceChannelManager");
        mgr.removeResourceChannel(resourceChannelForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("resourceChannel.deleted"));

        // save messages in session, so they'll survive the redirect
        saveMessages(request.getSession(), messages);

        return mapping.findForward("search");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'edit' method");
        }

        ResourceChannelForm resourceChannelForm = (ResourceChannelForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        
//        System.out.println("isNew>>>>>>>>>>>>66666666666666666666666666666666666666666666666666>>>>>>>>>>"+resourceChannelForm.getId());
        
        
        
        if (resourceChannelForm.getId() != null) {
            ResourceChannelManager mgr = (ResourceChannelManager) getBean("resourceChannelManager");
            ResourceChannel resourceChannel = mgr.getResourceChannel(resourceChannelForm.getId());
            
     	   ArrayList list = new ArrayList();
    	   for(int i = 0;i<25;i++){
    		    String v = i<10?"0"+i:String.valueOf(i);
    		    list.add(new org.apache.struts.util.LabelValueBean(v,v));
    	   }
    	   resourceChannel.setHourList(list);   
    	   
    	   list = new ArrayList();
    	   for(int i = 0;i<61;i++){
   		    String v = i<10?"0"+i:String.valueOf(i);
   		    list.add(new org.apache.struts.util.LabelValueBean(v,v));
    	   }
    	   resourceChannel.setMinList(list);   

            resourceChannelForm = (ResourceChannelForm) convert(resourceChannel);

            updateFormBean(mapping, request, resourceChannelForm);
        }else{
            ResourceChannel resourceChan= new ResourceChannel();
            
     	   ArrayList list = new ArrayList();
    	   for(int i = 0;i<25;i++){
    		    String v = i<10?"0"+i:String.valueOf(i);
    		    list.add(new org.apache.struts.util.LabelValueBean(v,v));
    	   }
    	   resourceChan.setHourList(list);   
    	   
    	   list = new ArrayList();
    	   for(int i = 0;i<61;i++){
   		    String v = i<10?"0"+i:String.valueOf(i);
   		    list.add(new org.apache.struts.util.LabelValueBean(v,v));
    	   }
    	   resourceChan.setMinList(list);   
            
            resourceChannelForm = (ResourceChannelForm) convert(resourceChan);
            
            updateFormBean(mapping, request, resourceChannelForm);    
        }

        return mapping.findForward("edit");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'save' method");
        }

        // Extract attributes and parameters we will need
        ActionMessages messages = new ActionMessages();
        ResourceChannelForm resourceChannelForm = (ResourceChannelForm) form;
        boolean isNew = ("".equals(resourceChannelForm.getId()) || resourceChannelForm.getId() == null);

        ResourceChannelManager mgr = (ResourceChannelManager) getBean("resourceChannelManager");
        ResourceChannel resourceChannel = (ResourceChannel) convert(resourceChannelForm);
       
        if(resourceChannelForm.getActivation()){
        	resourceChannel.setEnable(new Integer(1));
        }else{
        	 resourceChannel.setEnable(new Integer(0));
        }
        	
        	
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String value ="0";
        try {
 		value = resourceChannelForm.getBroTimeHour()+":"+resourceChannelForm.getBroTimeMin()+":"+resourceChannelForm.getBroTimeSec();

 		
			long millionSeconds = sdf.parse(value).getTime()+28800000;
		    String sec = String.valueOf(millionSeconds/1000);
//		    System.out.println("value2>>>>>>>>>>>>>>>>>>>>>>"+sec);
		    resourceChannel.setValue(sec);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//ºÁÃë
        
        mgr.saveResourceChannel(resourceChannel);

        // add success messages

        
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("resourceChannel.added"));
            
            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);
            
  



            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("resourceChannel.updated"));
            saveMessages(request, messages);

            ResourceChannel resourceChan= mgr.getResourceChannel(resourceChannelForm.getId());

            
            resourceChannelForm = (ResourceChannelForm) convert(resourceChan);

            updateFormBean(mapping, request, resourceChannelForm);           
            
            
            return mapping.findForward("edit");
        }
    }

    public ActionForward search(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'search' method");
        }

        ResourceChannelForm resourceChannelForm = (ResourceChannelForm) form;
        ResourceChannel resourceChannel = (ResourceChannel) convert(resourceChannelForm);
        
        String orgId = request.getParameter("orgId");
        orgId = orgId == null?"0":orgId;
        resourceChannel.setOrgId(new Long(orgId));

        
        System.out.println("orgId >>>>>>>>>>>>>>>>"+orgId);

        ResourceChannelManager mgr = (ResourceChannelManager) getBean("resourceChannelManager");
        request.setAttribute(Constants.RESOURCECHANNEL_LIST, mgr.getResourceChannels(resourceChannel));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
