package bit.edu.recommendation.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Mapper
public interface RecommendationMapper {

    int findLikeCountByBoardNo(int boardNo);

    boolean existLikeByBoardNoAndUserNo(@Param("boardNo") int boardNo, @Param("userNo") int userNo);

    void createLike(@Param("boardNo") int boardNo, @Param("userNo") int userNo);
}
