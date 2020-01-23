package sj.project.eatgo.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sj.project.eatgo.domain.Review;
import sj.project.eatgo.domain.ReviewRepository;

@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review addReview(Long restaurantId, String name, Integer score, String description) {
        Review review = Review.builder()
                .restaurantId(restaurantId).name(name)
                .score(score).description(description)
                .build();

        return reviewRepository.save(review);
    }

}
