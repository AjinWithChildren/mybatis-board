package bit.edu.recommendation.controller;

import bit.edu.recommendation.service.RecommendationService;
import bit.edu.user.dto.UserDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/{boardNo}")
    public ResponseEntity<String> likeUp(@PathVariable("boardNo") int boardNo,
                                         @SessionAttribute("userDetails") UserDetailsDto userDetailsDto) {

        if (recommendationService.existLikeByBoardNoAndUserNo(boardNo, userDetailsDto.getUserNo())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        recommendationService.createLike(boardNo, userDetailsDto.getUserNo());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
