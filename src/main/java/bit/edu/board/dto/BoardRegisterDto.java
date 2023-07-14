package bit.edu.board.dto;

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
public class BoardRegisterDto {
    private int userNo;
    private String userId;
    private String boardTitle;
    private String boardContent;
}
