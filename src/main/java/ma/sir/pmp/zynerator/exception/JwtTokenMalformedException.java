package ma.sir.pmp.zynerator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class JwtTokenMalformedException extends RuntimeException {
    private static final long serialVersionUID = 660337480651099714L;

    public JwtTokenMalformedException() {
    }

    public JwtTokenMalformedException(String message) {
        super(message);
    }
}
