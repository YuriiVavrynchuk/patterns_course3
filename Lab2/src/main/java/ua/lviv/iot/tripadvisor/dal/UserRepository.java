package ua.lviv.iot.tripadvisor.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.tripadvisor.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}