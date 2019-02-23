package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
}
