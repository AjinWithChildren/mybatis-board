package bit.edu.comment.service.impl;

import bit.edu.comment.dto.CommentListDto;
import bit.edu.comment.dto.CommentModifyDto;
import bit.edu.comment.dto.CommentRegisterDto;
import bit.edu.comment.mapper.CommentMapper;
import bit.edu.comment.service.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    public List<CommentListDto> findAllComment(int boardNo) {
        return commentMapper.findAllComment(boardNo);
    }

    @Override
    public void createComment(CommentRegisterDto commentRegisterDto) {
        commentMapper.createComment(commentRegisterDto);
    }

    @Override
    public void updateComment(CommentModifyDto commentModifyDto) {
        commentMapper.updateComment(commentModifyDto);
    }

    @Override
    public void deleteComment(int commentNo) {
        commentMapper.deleteComment(commentNo);
    }
}


