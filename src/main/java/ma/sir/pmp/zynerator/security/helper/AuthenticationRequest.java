package ma.sir.pmp.zynerator.security.helper;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {
    private static final long serialVersionUID = 2748928758378354357L;

    private String username;
    private String password;

    public AuthenticationRequest() {
        super();
    }

    public AuthenticationRequest(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
