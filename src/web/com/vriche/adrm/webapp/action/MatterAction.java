
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hsqldb.lib.StringUtil;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.MatterManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.webapp.form.MatterForm;

/**
 * Action class to handle CRUD on a Matter object
 *
 * @struts.action name="matterForm" path="/matters" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="matterForm" path="/editMatter" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="matterForm" path="/saveMatter" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adver/matterForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adver/matterList.jsp"
 * @struts.action-forward name="search" path="/matters.html" redirect="true"
 */
public final class MatterAction extends BaseAction {
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
        ActionMessages messagedel = new ActionMessages();
        MatterForm matterForm = (MatterForm) form;

        // Exceptions are caught by ActionExceptionHandler
        MatterManager mgr = (MatterManager) getBean("matterManager");
        OrderDetailManager ogr = (OrderDetailManager) getBean("orderDetailManager");
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setMatterId(new Long(matterForm.getId()));
        if(ogr.getOrderDetails(orderDetail).size()!=0){
        	messagedel.add(ActionMessages.GLOBAL_MESSAGE,
        			new ActionMessage("matter.deletedFied"));
        	saveMessages(request.getSession(), messagedel);
        	return mapping.findForward("edit");
        }else{
        mgr.removeMatter(matterForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("matter.deleted"));
        
        // save messages in session, so they'll survive the redirect
        saveMessages(request.getSession(), messages);
        }
        return mapping.findForward("search");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'edit' method");
        }

        MatterForm matterForm = (MatterForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (matterForm.getId() != null) {
            MatterManager mgr = (MatterManager) getBean("matterManager");
            Matter matter = mgr.getMatter(matterForm.getId());
            matterForm = (MatterForm) convert(matter);
            updateFormBean(mapping, request, matterForm);
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
        
        System.out.println(" matterID>>>>>>>>>>>>>>  my   my  my   " );
       
        // Extract attributes and parameters we will need
        ActionMessages messages = new ActionMessages();
        ActionMessages messageadd = new ActionMessages();
        
        MatterForm matterForm = (MatterForm) form;
        boolean isNew = ("".equals(matterForm.getId()) || matterForm.getId() == null);

        MatterManager mgr = (MatterManager) getBean("matterManager");
        
//        System.out.println(" matterForm.getCarrier().getId()>>>>>>>>>>>>>>>>>>>>>>> 999 888 777 >>>>   "+matterForm.getCarrierForm().getId());
        
        Matter matter = (Matter) convert(matterForm);
       
        Matter mattapcode = new Matter();
        mattapcode.setTapeCode(matter.getTapeCode());
//        if(matter.getBrandId2() == null) matter.setBrandId2(new Long(0));
        
        System.out.println(" matter.getCarrier().getId()>>>>>>>>>>>>>>>>>>>>>>> 999 888 777 >>>>   "+matter.getCarrier().getId());
//        System.out.println(" matterID   "+matter.getEnable().booleanValue());
        
        SysParam sysParam = (SysParam)Constants.APPLACTION_MAP.get(Constants.GLOBAL_SYS_PARAM);
    	boolean isAuto = (sysParam.getAdverCodeModelParam().equals("0")|| sysParam.getAdverCodeModelParam() == null)?false:true;
//     	System.out.println(" isAuto   "+isAuto);
//    	System.out.println(" isNew   "+isNew);
        if(!isAuto){
	        if(mgr.getMatterByTapCode(mattapcode)!=null && isNew){
	        	messageadd.add(ActionMessages.GLOBAL_MESSAGE,
	        			new ActionMessage("matter.addFied"));
	        	saveMessages(request.getSession(), messageadd);
	        	return mapping.findForward("edit");
	        }
        }
        
//        System.out.println(" matterID>>>>>>>>>>>>>>  my   my  my   " +matter.getIndustryType());
//        System.out.println(" matterID>>>>>>>>>>>>>>  my   my  my   " +matter.getBrandId());
//        System.out.println(" matterID>>>>>>>>>>>>>>  my   my  my   " +matter.getBrandId2());
//        System.out.println(" pos>>>>>>>>>>>>>>  my   my  my   " +matter.getPos());
        
        
        matter.setSave2dayang("1");
        matter.setCustomerId(new Long(0));
        mgr.saveMatter(matter);
        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("matter.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("matter.updated"));
            saveMessages(request, messages);

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

//        MatterForm matterForm = (MatterForm) form;
//        Matter matter = (Matter) convert(matterForm);
//
//        MatterManager mgr = (MatterManager) getBean("matterManager");
//        request.setAttribute(Constants.MATTER_LIST, mgr.getMatters(matter));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
