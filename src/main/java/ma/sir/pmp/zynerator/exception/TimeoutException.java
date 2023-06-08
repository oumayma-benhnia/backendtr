package ma.sir.pmp.zynerator.exception;

public class TimeoutException extends RuntimeException {

    private String[] params;

    public TimeoutException(String message) {
        super(message);
    }

    public TimeoutException(String message, String[] params) {
        super(message);
        this.params = params;
    }

    public TimeoutException(Throwable cause) {
        super(cause);
    }

    public TimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

}