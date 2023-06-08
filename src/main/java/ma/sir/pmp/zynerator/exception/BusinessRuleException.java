package ma.sir.pmp.zynerator.exception;


public class BusinessRuleException extends RuntimeException {

    private String[] params;

    public BusinessRuleException(String message) {
        super(message);
    }

    public BusinessRuleException(String message, String[] params) {
        super(message);
        this.params = params;
    }

    public BusinessRuleException(Throwable cause) {
        super(cause);
    }

    public BusinessRuleException(String message, Throwable cause) {
        super(message, cause);
    }

    public String[] getParams() {
        return this.params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

}