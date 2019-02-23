package az.lets_speak.ms.lets_speak.service;

import az.lets_speak.ms.lets_speak.repository.GroupRepository;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    private final GroupRepository repository;

    public GroupService(GroupRepository repository) {
        this.repository = repository;
    }
}
