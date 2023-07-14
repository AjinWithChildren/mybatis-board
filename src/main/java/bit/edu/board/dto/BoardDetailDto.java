package bit.edu.board.dto;

import java.time.LocalDateTime;
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
public class BoardDetailDto {
    private int boardNo;
    private int userNo;
    private String userId;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime createdAt;
}
