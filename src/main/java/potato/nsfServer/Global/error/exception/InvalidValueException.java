package potato.nsfServer.Global.error.exception;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import potato.nsfServer.Global.error.ErrorCode;

@Getter
public class InvalidValueException extends RuntimeException{
    private final ErrorCode errorCode;

    public InvalidValueException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
