package bit.edu.board.advisor;

import bit.edu.user.exception.UserNotFountException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Slf4j
@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(value = {UserNotFountException.class})
    public String notFoundException(Exception exception) {
        log.error(exception.getMessage());
        return "redirect/";
    }

    @ExceptionHandler(value = {RuntimeException.class, Exception.class})
    public String internalException(Exception exception) {
        log.error(exception.getMessage());
        return "redirect:/";
    }
}
