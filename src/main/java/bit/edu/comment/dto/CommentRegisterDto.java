package bit.edu.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@AllArgsConstructor
public class CommentRegisterDto {
    private int boardNo;
    private int userNo;
    private String userId;
    private String commentContent;

}
