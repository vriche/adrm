cd D:\work\3.1\adrm\extras\appgen

d:
 
rem for %%i in (oaApplyInfo oaAreaCity oaAreaPc oaAssets oaAssetsState oaAssetsType oaBusinessCard oaBusinessCardType oaCalendarEvent oaDocument oaDocumentCatalog oaDocumentCatalogPermitType oaDocumentFile oaInfo oaInfoType oaProductInfo oaProductType oaProductUsed oaScratchpad oaWorkFlow oaWorkFlowCheck oaWorkFlowCheckResult oaWorkFlowType sysEnentState sysEnentType sysEvent sysEventState sysEventType sysPromptMode sysUserType) do ant install-detailed -Dappgen.type=pojo -Dobject.name=%%i
for %%i in (FinanceTarget) do ant install-detailed -Dappgen.type=pojo -Dobject.name=%%i
pause
