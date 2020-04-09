package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.model.UserEntity;
import az.speak.ms.lets_speak.repository.UserRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@EnableScheduling
public class SchedulingService {
    private final UserRepository userRepository;
    private final EmailService emailService;

    public SchedulingService(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @Scheduled(cron = "0 32 11 * * ?")
    private void sendHappyBirthDay(){
        
        LocalDate date = LocalDate.now();
        List<UserEntity> userEntities = userRepository.findAll();
        System.out.println(date.toString());
        for (UserEntity user : userEntities) {
            if(user.getBirthDate().getMonth() == date.getMonth() &&
                    user.getBirthDate().getDayOfMonth() == date.getDayOfMonth()){
                System.out.println("sending message to " + user.getName());
                String message = emailGenerator(user);
                emailService.send(user.getEmail(), "Happy birthday", message);
            }

        }
    }

    private String emailGenerator(UserEntity user){
        StringBuilder message = new StringBuilder();
        message.append("\tDear "+user.getName() + "\n");
        message.append("We sincerely wish you a happy birthday\n");
        return message.toString();
    }
}
