package ma.sir.pmp.zynerator.security.helper;

import java.io.Serializable;
import java.util.Date;

public class Token implements Serializable {

    private String value;

    private Date issuedAt;

    private Date expirationDate;

    public Token(Date issuedAt, Date expirationDate, String value) {
        this.issuedAt = issuedAt;
        this.expirationDate = expirationDate;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}
