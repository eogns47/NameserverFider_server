package potato.nsfServer.Global.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import potato.nsfServer.Global.error.exception.InvalidValueException;
import potato.nsfServer.Global.util.ApiUtils;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidValueException.class)
    private ResponseEntity<?> handleInvalidValueException(final InvalidValueException e){
        return handleException(e, e.getErrorCode(), e.getMessage());
    }

    private ResponseEntity<?> handleException(Exception e, ErrorCode errorCode, String message) {
        log.error(message, e);
        return ApiUtils.error(ErrorResponse.of(errorCode, message));
    }

}
