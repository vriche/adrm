
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;



import com.vriche.adrm.Constants;
import com.vriche.adrm.model.PriceRegular;
import com.vriche.adrm.service.PriceRegularManager;
import com.vriche.adrm.webapp.form.PriceRegularForm;

/**
 * Action class to handle CRUD on a PriceRegular object
 *
 * @struts.action name="priceRegularForm" path="/priceRegulars" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="priceRegularForm" path="/editPriceRegular" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="priceRegularForm" path="/savePriceRegular" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/priceRegularForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/priceRegularList.jsp"
 * @struts.action-forward name="search" path="/priceRegulars.html" redirect="true"
 */
public final class PriceRegularAction extends BaseAction {
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
        PriceRegularForm priceRegularForm = (PriceRegularForm) form;

        // Exceptions are caught by ActionExceptionHandler
        PriceRegularManager mgr = (PriceRegularManager) getBean("priceRegularManager");
        mgr.removePriceRegular(priceRegularForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("priceRegular.deleted"));

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

        PriceRegularForm priceRegularForm = (PriceRegularForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (priceRegularForm.getId() != null) {
            PriceRegularManager mgr = (PriceRegularManager) getBean("priceRegularManager");
            PriceRegular priceRegular = mgr.getPriceRegular(priceRegularForm.getId());
            priceRegularForm = (PriceRegularForm) convert(priceRegular);
            updateFormBean(mapping, request, priceRegularForm);
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
        PriceRegularForm priceRegularForm = (PriceRegularForm) form;
        boolean isNew = ("".equals(priceRegularForm.getId()) || priceRegularForm.getId() == null);
      
        boolean isNull = ("".equals(priceRegularForm.getOtherBase()) || priceRegularForm.getOtherBase() == null);
//        System.out.println("priceRegularForm.getOtherBase()>>>>>>>>"+priceRegularForm.getOtherBase());
//        System.out.println(isNull);
        if(isNull){
        	priceRegularForm.setOtherBase("0");
        }
       		
        PriceRegularManager mgr = (PriceRegularManager) getBean("priceRegularManager");
        PriceRegular priceRegular = (PriceRegular) convert(priceRegularForm);
       
        PriceRegular p = new PriceRegular();
        p.setName(priceRegularForm.getName());
       
        if(isNew && mgr.getPriceRegulars(p).size()>0){
        	messages.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("priceRegular.addFile"));

       // save messages in session to survive a redirect
       saveMessages(request.getSession(), messages);
       return mapping.findForward("edit");
        }else{
        
        
        
        mgr.savePriceRegular(priceRegular);
       
  //       add success messages
        if (isNew) {
        	
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("priceRegular.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("priceRegular.updated"));
            saveMessages(request, messages);

            return mapping.findForward("edit");
        }
        }
    }

    public ActionForward search(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'search' method");
        }

        PriceRegularForm priceRegularForm = (PriceRegularForm) form;
        PriceRegular priceRegular = (PriceRegular) convert(priceRegularForm);

        PriceRegularManager mgr = (PriceRegularManager) getBean("priceRegularManager");
        request.setAttribute(Constants.PRICEREGULAR_LIST, mgr.getPriceRegulars(priceRegular));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
