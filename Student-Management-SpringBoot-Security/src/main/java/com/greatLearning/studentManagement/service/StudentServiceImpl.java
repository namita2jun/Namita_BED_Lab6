package com.greatLearning.studentManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatLearning.studentManagement.entity.Student;
import com.greatLearning.studentManagement.repository.StudentJpaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

	private final StudentJpaRepository studentRepository;

	@Override
	public List<Student> findAll() {
		List<Student> students = this.studentRepository.findAll();
		return students;
	}

	@Override
	public Student findById(int theId) {
		return this.studentRepository.findById(theId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid book id is passed"));
	}

	@Override
	public void save(Student theStudent) {
		this.studentRepository.save(theStudent);
	}

	@Override
	public void deleteById(int theId) {
		this.studentRepository.deleteById(theId);

	}

}
