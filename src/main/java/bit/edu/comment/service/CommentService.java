package bit.edu.comment.service;

import bit.edu.comment.dto.CommentListDto;
import bit.edu.comment.dto.CommentModifyDto;
import bit.edu.comment.dto.CommentRegisterDto;
import java.util.List;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public interface CommentService {

    List<CommentListDto> findAllComment(int boardNo);

    void createComment(CommentRegisterDto commentRegisterDto);

    void updateComment(CommentModifyDto commentModifyDto);

    void deleteComment(int commentNo);
}
