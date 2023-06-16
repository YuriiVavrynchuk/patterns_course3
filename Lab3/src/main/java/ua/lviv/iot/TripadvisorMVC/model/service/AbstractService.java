package ua.lviv.iot.TripadvisorMVC.model.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractService<T> {

	private final JpaRepository<T, Integer> repository;

	public AbstractService(JpaRepository<T, Integer> repository) {
		this.repository = repository;
	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public T getById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	public T saveToDatabase(T newObject) {
		return repository.save(newObject);
	}

	public boolean deleteById(Integer id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public T update(Integer id, T newObject, T oldObject) {
		if (repository.existsById(id)) {
			BeanUtils.copyProperties(repository.findById(id).get(), oldObject);
			repository.save(newObject);
		}
		return oldObject;
	}
}
