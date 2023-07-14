package bit.edu.board.service;

import bit.edu.board.dto.BoardDetailDto;
import bit.edu.board.dto.BoardListDto;
import bit.edu.board.dto.BoardModifyDto;
import bit.edu.board.dto.BoardRegisterDto;
import java.util.List;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public interface BoardService {

    void createBoard(BoardRegisterDto boardRegisterDto);

    List<BoardListDto> findAllBoards();

    BoardDetailDto findBoardByBoardNo(int boardNo);

    void updateBoard(BoardModifyDto boardModifyDto);

    void deleteBoard(int boardNo);
}
