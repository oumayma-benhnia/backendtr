package ma.sir.pmp.zynerator.security.helper;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {
    private static final long serialVersionUID = -3119742936197757809L;

    private final String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
