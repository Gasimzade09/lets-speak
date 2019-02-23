package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository) {
        this.repository = repository;
    }
}
