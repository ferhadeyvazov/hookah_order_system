package hos.hookahordersystem.common.enums;

public enum ErrorCode {
    TOBACCO_BRAND_NOT_FOUND("TB001", "Tobacco brand not found"),
    TOBACCO_BRAND_ALREADY_EXISTS("TB002", "Tobacco brand already exists"),
    INVALID_TOBACCO_BRAND_DATA("TB003", "Invalid tobacco brand data"),
    TOBACCO_NOT_FOUND("TB004", "Tobacco not found");

    private final String code;
    private final String message;
    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
