package bit.edu.board.dto;

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
public class BoardModifyDto {

    private int boardNo;
    private String boardTitle;
    private String boardContent;

}
