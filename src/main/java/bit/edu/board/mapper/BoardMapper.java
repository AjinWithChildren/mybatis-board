package bit.edu.board.mapper;

import bit.edu.board.dto.BoardDetailDto;
import bit.edu.board.dto.BoardListDto;
import bit.edu.board.dto.BoardModifyDto;
import bit.edu.board.dto.BoardRegisterDto;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Mapper
public interface BoardMapper {

    void createBoard(BoardRegisterDto boardRegisterDto);

    List<BoardListDto> findAllBoards();

    Optional<BoardDetailDto> findBoardByBoardNo(int boardNo);

    void updateBoardByBoardNo(BoardModifyDto boardModifyDto);
    void deleteBoardByBoardNo(int boardNo);
}
