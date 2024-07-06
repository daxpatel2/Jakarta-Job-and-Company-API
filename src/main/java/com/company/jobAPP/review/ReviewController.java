package com.company.jobAPP.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId),HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review) {
        return reviewService.addReview(companyId,review) ? new ResponseEntity<>("Added review",HttpStatus.OK) : new ResponseEntity<>("no review",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        Review review = reviewService.getReview(companyId,reviewId);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review review) {
        boolean status = reviewService.updateReview(companyId,reviewId,review);
        return status ? new ResponseEntity<>("Review updated",HttpStatus.OK) : new ResponseEntity<>("Could not update review", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        boolean status = reviewService.deleteReview(companyId,reviewId);
        return status ? new ResponseEntity<>("Review deleted",HttpStatus.OK) : new ResponseEntity<>("Could not delete review", HttpStatus.BAD_REQUEST);

    }

}
