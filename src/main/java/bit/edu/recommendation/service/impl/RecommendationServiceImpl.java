package bit.edu.recommendation.service.impl;

import bit.edu.recommendation.mapper.RecommendationMapper;
import bit.edu.recommendation.service.RecommendationService;
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
public class RecommendationServiceImpl implements RecommendationService {

    private final RecommendationMapper recommendationMapper;

    @Override
    public int findLikeCountByBoardNo(int boardNo) {
        return recommendationMapper.findLikeCountByBoardNo(boardNo);
    }

    @Override
    public boolean existLikeByBoardNoAndUserNo(int boardNo, int userNo) {
        return recommendationMapper.existLikeByBoardNoAndUserNo(boardNo, userNo);
    }


    @Override
    public void createLike(int boardNo, int userNo) {
        recommendationMapper.createLike(boardNo, userNo);
    }
}
