package sprint.example.crud_application.exeption;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.Email;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import sprint.example.crud_application.dto.ExeptionDto;

@RestControllerAdvice
public class ExeptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExeptionDto> userCreationExeption(MethodArgumentNotValidException ex , HttpServletRequest request) {
        ExeptionDto exeptionDto = new ExeptionDto();

        exeptionDto.setMessage(ex.getMessage());
        exeptionDto.setCode(HttpStatus.BAD_REQUEST);
        exeptionDto.setPath(request.getRequestURI());


        return new ResponseEntity<>(exeptionDto , HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ExeptionDto> dataNotFound(ResourceNotFound ex , HttpServletRequest request) {
        ExeptionDto exeptionDto = new ExeptionDto();

        exeptionDto.setMessage(ex.getMessage());
        exeptionDto.setCode(HttpStatus.NOT_FOUND);
        exeptionDto.setPath(request.getRequestURI());


        return new ResponseEntity<>(exeptionDto , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExeptionDto> exeption(Exception ex , HttpServletRequest request) {
        ExeptionDto exeptionDto = new ExeptionDto();

        exeptionDto.setMessage("Something went wrong, try again later");
        exeptionDto.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
        exeptionDto.setPath(request.getRequestURI());


        return new ResponseEntity<>(exeptionDto , HttpStatus.BAD_REQUEST);
    }
}
