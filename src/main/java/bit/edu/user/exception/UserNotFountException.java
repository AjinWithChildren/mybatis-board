package bit.edu.user.exception;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public class UserNotFountException extends RuntimeException {

    private static final String MESSAGE = "해당 유저를 찾지 못했다.";

    public UserNotFountException() {
        super(MESSAGE);
    }
}
