package board.game.score.back.handler;

import board.game.score.back.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class CustomExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BgsException.class, ConstraintViolationException.class})
    protected ResponseEntity<ErrorResponseDto> handleFunctionalException(BgsException exception) {
        return getResponseEntity(exception, BAD_REQUEST);
    }

    private ResponseEntity<ErrorResponseDto> getResponseEntity(Exception exception, HttpStatus httpStatus) {
        var response = ErrorResponseDto.builder().message(exception.getMessage()).build();
        return new ResponseEntity<>(response, httpStatus);
    }

}
