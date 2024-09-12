package ext.group3.pages.docuport;

public class POM {

    private DocuClientPage docuClientPage;
    private DocuLoginPage docuLoginPage;
    private DocuAdvisorClientsPage docuAdvisorClientsPage;
    private DocuAdvisorHomePage docuAdvisorHomePage;

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

    public DocuAdvisorClientsPage getDocuAdvisorClientsPage() {
        if(docuAdvisorClientsPage == null) {
            docuAdvisorClientsPage = new DocuAdvisorClientsPage();
        }
        return docuAdvisorClientsPage;
    }

    public DocuAdvisorHomePage getDocuAdvisorHomePage ()  {
        if(docuAdvisorHomePage == null) {
            docuAdvisorHomePage = new DocuAdvisorHomePage();
        }
        return docuAdvisorHomePage;
    }


}
