package bit.edu.recommendation.service;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public interface RecommendationService {

    int findLikeCountByBoardNo(int boardNo);

    boolean existLikeByBoardNoAndUserNo(int boardNo, int userNo);

    void createLike(int boardNo, int userNo);
}
