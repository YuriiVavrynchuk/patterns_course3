package ua.lviv.iot.tripadvisor.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.tripadvisor.domain.Feedback;
import ua.lviv.iot.tripadvisor.service.FeedbackService;

@RequestMapping("/review")
@RestController
public class FeedbackController extends AbstractController<Feedback> {

	private final FeedbackService feedbackService;

	@Autowired
	public FeedbackController(FeedbackService feedbackService) {
		super(feedbackService);
		this.feedbackService = feedbackService;
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Feedback> updateReview(@PathVariable("id") Integer reviewId, @RequestBody Feedback feedback) {
		feedback.setId(reviewId);
		Feedback updatedFeedback = feedbackService.update(reviewId, feedback, new Feedback());
		if (updatedFeedback != null) {
			return new ResponseEntity<Feedback>(updatedFeedback, HttpStatus.OK);
		} else {
			return new ResponseEntity<Feedback>(HttpStatus.NOT_FOUND);
		}
	}
}
