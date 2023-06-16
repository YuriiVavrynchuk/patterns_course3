package ua.lviv.iot.tripadvisor.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.tripadvisor.domain.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}