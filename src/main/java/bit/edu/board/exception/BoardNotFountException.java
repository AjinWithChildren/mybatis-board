package bit.edu.board.exception;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public class BoardNotFountException extends RuntimeException {

    private static final String MESSAGE = "게시글을 찾지 못하였습니다.";

    public BoardNotFountException() {
        super(MESSAGE);
    }
}
