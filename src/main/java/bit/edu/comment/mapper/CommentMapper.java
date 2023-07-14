package bit.edu.comment.mapper;

import bit.edu.comment.dto.CommentListDto;
import bit.edu.comment.dto.CommentModifyDto;
import bit.edu.comment.dto.CommentRegisterDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Mapper
public interface CommentMapper {

    List<CommentListDto> findAllComment(@Param("boardNo") int boardNo);

    void createComment(CommentRegisterDto commentRegisterDto);

    void updateComment(CommentModifyDto commentModifyDto);

    void deleteComment(@Param("commentNo") int commentNo);
}
