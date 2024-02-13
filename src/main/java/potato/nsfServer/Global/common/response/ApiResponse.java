package potato.nsfServer.Global.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import potato.nsfServer.Global.error.ErrorResponse;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class ApiResponse<T> {

    private final Boolean isSuccess;

    @JsonProperty(value = "response")
    private final T response;

    @JsonProperty(value = "errorResponse")
    private final ErrorResponse errorResponse;

    public static <T> ApiResponse<T> create(boolean isSuccess, T response, ErrorResponse errorResponse) {
        return new ApiResponse<>(isSuccess, response, errorResponse);
    }

}