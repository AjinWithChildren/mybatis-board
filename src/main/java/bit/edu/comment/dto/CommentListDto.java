package bit.edu.comment.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@AllArgsConstructor
@ToString
public class CommentListDto {
    private int commentNo;
    private int boardNo;
    private int userNo;
    private String userId;
    private String commentContent;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate commentWriteTime;
    private boolean deleted;
}
