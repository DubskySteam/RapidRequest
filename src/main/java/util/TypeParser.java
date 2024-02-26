package util;

public class TypeParser {

    public static String parseType(ContentType returnType) {
        return switch (returnType) {
            case XML -> "application/xml";
            case HTML -> "text/html";
            case TEXT -> "text/plain";
            case PNG -> "image/png";
            case JPEG -> "image/jpeg";
            case PDF -> "application/pdf";
            default -> "application/json";
        };
    }

}
