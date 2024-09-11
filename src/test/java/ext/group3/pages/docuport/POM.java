package ext.group3.pages.docuport;

public class POM {

    private DocuClientPage docuClientPage;
    private DocuLoginPage docuLoginPage;
    private DocuportBasePage docuportBasePage;
    private DocuEditClientPage docuEditClientPage;

    public DocuClientPage getDocuClientPage() {
        if(docuClientPage == null) {
            docuClientPage = new DocuClientPage();
        }
        return docuClientPage;
    }

    public DocuLoginPage getDocuLoginPage() {
        if(docuLoginPage == null) {
            docuLoginPage = new DocuLoginPage();
        }
        return docuLoginPage;
    }

    public DocuportBasePage getDocuportBasePage() {
        if(docuportBasePage == null) {
            docuportBasePage = new DocuportBasePage();
        }
        return docuportBasePage;
    }

    public DocuEditClientPage getDocuEditClientPage() {
        if(docuEditClientPage == null)
        {
            docuEditClientPage = new DocuEditClientPage();
        }
        return docuEditClientPage;
    }
}
