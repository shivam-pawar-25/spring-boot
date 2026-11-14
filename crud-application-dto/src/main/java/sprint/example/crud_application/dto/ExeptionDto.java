package sprint.example.crud_application.dto;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ExeptionDto {

    private HttpStatus code;
    private String message;
    private String path;

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
