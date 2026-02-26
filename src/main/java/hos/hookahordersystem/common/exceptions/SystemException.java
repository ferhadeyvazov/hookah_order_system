package hos.hookahordersystem.common.exceptions;

import hos.hookahordersystem.common.enums.ErrorCode;

import java.util.HashMap;
import java.util.Map;

public class SystemException extends RuntimeException {
    private final ErrorCode errorCode;
    private final Map<String, Object> errorDetails;

    public SystemException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.errorDetails = new HashMap<>();
    }

    public SystemException addDetail(String key, Object value) {
        this.errorDetails.put(key, value);
        return this;
    }

    public String getCode() {
        return errorCode.getCode();
    }

    public Map<String, Object> getDetails() {
        return errorDetails;
    }

}
