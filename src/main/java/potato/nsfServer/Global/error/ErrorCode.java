package potato.nsfServer.Global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // Data
    DATA_IS_NOT_EXIST(HttpStatus.BAD_REQUEST,"D01","데이터가 더이상 존재하지 않습니다"),

    ;

    private final HttpStatus status;
    private final String code;
    private final String message;

}

