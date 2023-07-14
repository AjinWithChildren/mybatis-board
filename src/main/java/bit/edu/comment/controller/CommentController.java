package bit.edu.comment.controller;

import bit.edu.comment.dto.CommentDeleteDto;
import bit.edu.comment.dto.CommentModifyDto;
import bit.edu.comment.dto.CommentRegisterDto;
import bit.edu.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Slf4j
@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/register")
    public String commentRegister(@ModelAttribute CommentRegisterDto commentRegisterDto) {
        commentService.createComment(commentRegisterDto);
        return "redirect:/boards/".concat(String.valueOf(commentRegisterDto.getBoardNo()));
    }

    @PostMapping("/modify")
    public String commentModify(@ModelAttribute CommentModifyDto commentModifyDto) {
        log.info("modifyDto {}", commentModifyDto);
        commentService.updateComment(commentModifyDto);
        return "redirect:/boards/".concat(String.valueOf(commentModifyDto.getBoardNo()));
    }

    @GetMapping("/delete")
    public String commentDelete(@ModelAttribute CommentDeleteDto commentDeleteDto) {
        commentService.deleteComment(commentDeleteDto.getCommentNo());
        return "redirect:/boards/".concat(String.valueOf(commentDeleteDto.getBoardNo()));
    }

}
