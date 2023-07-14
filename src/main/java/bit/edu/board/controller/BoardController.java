package bit.edu.board.controller;

import bit.edu.board.dto.BoardModifyDto;
import bit.edu.board.dto.BoardRegisterDto;
import bit.edu.board.service.BoardService;
import bit.edu.comment.service.CommentService;
import bit.edu.user.dto.UserDetailsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Slf4j
@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private final CommentService commentService;

    @GetMapping
    public String boardListForm(Model model) {
        model.addAttribute("boards", boardService.findAllBoards());
        return "/boardList";
    }

    @GetMapping("/register")
    public String boardRegisterForm(@SessionAttribute("userDetails") UserDetailsDto userDetailsDto,
                                    Model model) {
        model.addAttribute("userDetails", userDetailsDto);
        return "/boardRegister";
    }


    @PostMapping("/register")
    public String boardRegister(@ModelAttribute BoardRegisterDto boardRegisterDto) {
        boardService.createBoard(boardRegisterDto);
        return "redirect:/boards";
    }

    @GetMapping("/{boardNo}")
    public String boardDetail(@PathVariable(value = "boardNo") int boardNo,
                              Model model) {
        model.addAttribute("board", boardService.findBoardByBoardNo(boardNo));
        model.addAttribute("comments", commentService.findAllComment(boardNo));
        return "/boardDetail";
    }

    @GetMapping("/{boardNo}/modify")
    public String boardModifyForm(@PathVariable(value = "boardNo") int boardNo,
                                  Model model) {
        model.addAttribute("board", boardService.findBoardByBoardNo(boardNo));
        return "/boardModify";
    }

    @PostMapping("/modify")
    public String boardModify(@ModelAttribute BoardModifyDto boardModifyDto) {
        boardService.updateBoard(boardModifyDto);
        return "redirect:/boards";
    }

    @GetMapping("/{boardNo}/delete")
    public String boardDelete(@PathVariable(value = "boardNo") int boardNo) {
        boardService.deleteBoard(boardNo);
        return "redirect:/boards";
    }
}
