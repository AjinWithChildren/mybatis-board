package bit.edu.board.service.impl;

import bit.edu.board.dto.BoardDetailDto;
import bit.edu.board.dto.BoardListDto;
import bit.edu.board.dto.BoardModifyDto;
import bit.edu.board.dto.BoardRegisterDto;
import bit.edu.board.exception.BoardNotFountException;
import bit.edu.board.mapper.BoardMapper;
import bit.edu.board.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public void createBoard(BoardRegisterDto boardRegisterDto) {
        boardMapper.createBoard(boardRegisterDto);
    }

    @Override
    public List<BoardListDto> findAllBoards() {
        return boardMapper.findAllBoards();
    }

    @Override
    public BoardDetailDto findBoardByBoardNo(int boardNo) {
        return boardMapper.findBoardByBoardNo(boardNo)
            .orElseThrow(BoardNotFountException::new);
    }

    @Override
    public void updateBoard(BoardModifyDto boardModifyDto) {
        boardMapper.updateBoardByBoardNo(boardModifyDto);
    }

    @Override
    public void deleteBoard(int boardNo) {
        boardMapper.deleteBoardByBoardNo(boardNo);
    }
}
