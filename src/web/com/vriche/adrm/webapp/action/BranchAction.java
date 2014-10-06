
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
import com.vriche.adrm.model.Branch;
import com.vriche.adrm.service.BranchManager;
import com.vriche.adrm.webapp.form.BranchForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a Branch object
 *
 * @struts.action name="branchForm" path="/branchs" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="branchForm" path="/editBranch" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="branchForm" path="/saveBranch" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/admin/branchForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/admin/branchList.jsp"
 * @struts.action-forward name="search" path="/branchs.html" redirect="true"
 */
public final class BranchAction extends BaseAction {
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
        BranchForm branchForm = (BranchForm) form;

        // Exceptions are caught by ActionExceptionHandler
        BranchManager mgr = (BranchManager) getBean("branchManager");
        mgr.removeBranch(branchForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("branch.deleted"));

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
       
        BranchForm branchForm = (BranchForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (branchForm.getId() != null) {
            BranchManager mgr = (BranchManager) getBean("branchManager");
            Branch branch = mgr.getBranch(branchForm.getId());
            branchForm = (BranchForm) convert(branch);
            updateFormBean(mapping, request, branchForm);
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
        BranchForm branchForm = (BranchForm) form;
        boolean isNew = ("".equals(branchForm.getId()) || branchForm.getId() == null);

        BranchManager mgr = (BranchManager) getBean("branchManager");
        Branch branch = (Branch) convert(branchForm);
        

        if(branch.getParentId().equals("")|| branch.getParentId() == null){
        	branch.setParentId("0");
        }
        if(branch.getDisplayNo() == null){
        	branch.setDisplayNo(new Integer(0));
        }
        mgr.saveBranch(branch);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("branch.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);
            return mapping.findForward("search");
            
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("branch.updated"));
            saveMessages(request, messages);
            System.out.println("cccccc");
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

        BranchForm branchForm = (BranchForm) form;
        Branch branch = (Branch) convert(branchForm);
        BranchManager mgr = (BranchManager) getBean("branchManager");
        branch = null;
        int resultSize = Integer.parseInt(mgr.getBranchsCount(branch));
        Page page = new Page(Constants.BRANCH_LIST,request);        
        PaginatedList pageList = mgr.getBranchsPage(branch,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.BRANCH_LIST, pageList);                    
        //request.setAttribute(Constants.BRANCH_LIST, mgr.getBranchs(branch));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
