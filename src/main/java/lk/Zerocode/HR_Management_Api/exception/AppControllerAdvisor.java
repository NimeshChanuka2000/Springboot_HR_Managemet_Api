package lk.Zerocode.HR_Management_Api.exception;

import lk.Zerocode.HR_Management_Api.controller.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdvisor {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({EmployeeNotFoundException.class})
    public ErrorMessageDTO handelException(Exception exception){

        ErrorMessageDTO errorMessage = new ErrorMessageDTO();
        errorMessage.setMessage(exception.getMessage());

        return errorMessage;


    }
}
