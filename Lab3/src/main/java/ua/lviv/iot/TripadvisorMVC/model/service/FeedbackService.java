package ua.lviv.iot.TripadvisorMVC.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.TripadvisorMVC.model.dal.FeedbackRepository;
import ua.lviv.iot.TripadvisorMVC.model.domain.Feedback;

@Service
public class FeedbackService extends AbstractService<Feedback> {


	@Autowired
	public FeedbackService(FeedbackRepository feedbackRepository) {
		super(feedbackRepository);
	}
}
