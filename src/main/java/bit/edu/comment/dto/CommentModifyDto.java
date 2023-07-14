package bit.edu.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@AllArgsConstructor
@ToString
public class CommentModifyDto {

    private int boardNo;
    private int commentNo;
    private String commentContent;
}
