package bit.edu.board.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class BoardListDto {
    private int boardNo;
    private String userId;
    private String boardTitle;
    private LocalDateTime createdAt;
    private boolean deleted;
}
