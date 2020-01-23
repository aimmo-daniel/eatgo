package sj.project.eatgo.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sj.project.eatgo.application.EmailNotExistedException;
import sj.project.eatgo.application.PasswordWrongException;

@ControllerAdvice
public class SessionErrorAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailNotExistedException.class)
    public String handleEmailNotExisted() {
        return "{}";
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordWrongException.class)
    public String handlePasswordWrong() {
        return "{}";
    }

}
