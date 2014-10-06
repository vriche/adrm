
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.Constants;
import com.vriche.adrm.model.OaBusinessCard;
import com.vriche.adrm.service.OaBusinessCardManager;
import com.vriche.adrm.webapp.form.OaBusinessCardForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaBusinessCard object
 *
 * @struts.action name="oaBusinessCardForm" path="/oaBusinessCards" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaBusinessCardForm" path="/editOaBusinessCard" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaBusinessCardForm" path="/saveOaBusinessCard" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/tools/oaBusinessCardForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/tools/oaBusinessCardList.jsp"
 * @struts.action-forward name="search" path="/oaBusinessCards.html" redirect="true"
 */
public final class OaBusinessCardAction extends BaseAction {
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
        OaBusinessCardForm oaBusinessCardForm = (OaBusinessCardForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaBusinessCardManager mgr = (OaBusinessCardManager) getBean("oaBusinessCardManager");
        mgr.removeOaBusinessCard(oaBusinessCardForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaBusinessCard.deleted"));

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

        OaBusinessCardForm oaBusinessCardForm = (OaBusinessCardForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaBusinessCardForm.getId() != null) {
            OaBusinessCardManager mgr = (OaBusinessCardManager) getBean("oaBusinessCardManager");
            OaBusinessCard oaBusinessCard = mgr.getOaBusinessCard(oaBusinessCardForm.getId());
            oaBusinessCardForm = (OaBusinessCardForm) convert(oaBusinessCard);
            updateFormBean(mapping, request, oaBusinessCardForm);
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
        OaBusinessCardForm oaBusinessCardForm = (OaBusinessCardForm) form;
        boolean isNew = ("".equals(oaBusinessCardForm.getId()) || oaBusinessCardForm.getId() == null);

        OaBusinessCardManager mgr = (OaBusinessCardManager) getBean("oaBusinessCardManager");
        OaBusinessCard oaBusinessCard = (OaBusinessCard) convert(oaBusinessCardForm);
        mgr.saveOaBusinessCard(oaBusinessCard);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaBusinessCard.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaBusinessCard.updated"));
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

        OaBusinessCardForm oaBusinessCardForm = (OaBusinessCardForm) form;
        OaBusinessCard oaBusinessCard = (OaBusinessCard) convert(oaBusinessCardForm);
        OaBusinessCardManager mgr = (OaBusinessCardManager) getBean("oaBusinessCardManager");
        oaBusinessCard = null;
        int resultSize = Integer.parseInt(mgr.getOaBusinessCardsCount(oaBusinessCard));
        Page page = new Page(Constants.OABUSINESSCARD_LIST,request);        
        PaginatedList pageList = mgr.getOaBusinessCardsPage(oaBusinessCard,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OABUSINESSCARD_LIST, pageList);                    
        //request.setAttribute(Constants.OABUSINESSCARD_LIST, mgr.getOaBusinessCards(oaBusinessCard));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
