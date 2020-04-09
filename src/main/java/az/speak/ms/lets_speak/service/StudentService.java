package az.speak.ms.lets_speak.service;

import az.speak.ms.lets_speak.dto.OrderDto;
import az.speak.ms.lets_speak.dto.StudentDto;
import az.speak.ms.lets_speak.mappers.StudentMapper;
import az.speak.ms.lets_speak.model.*;
import az.speak.ms.lets_speak.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final TariffRepository tariffRepository;
    private final ScheduleRepository scheduleRepository;
    private final TeacherRepository teacherRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ScheduleCountRepository scheduleCountRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, TariffRepository tariffRepository, ScheduleRepository scheduleRepository, TeacherRepository teacherRepository, OrderRepository orderRepository, UserRepository userRepository, ScheduleCountRepository scheduleCountRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.tariffRepository = tariffRepository;
        this.scheduleRepository = scheduleRepository;
        this.teacherRepository = teacherRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.scheduleCountRepository = scheduleCountRepository;
    }

    public List<StudentDto> getStudentsByTeacherId(Integer id){
        List<StudentEntity> studentEntities = new ArrayList<>();
        for (StudentEntity s: teacherRepository.getOne(id).getStudents()) {
            studentEntities.add(s);
        }

        return StudentMapper.entityListToDtoList(studentEntities);

    }

    public StudentDto saveStudent(StudentDto studentDto){
        StudentEntity studentEntity = StudentMapper.dtoToEntity(studentDto);
        return StudentMapper.entityToDto(studentRepository.save(studentEntity));
    }

    public void setRank(Integer id, Double rank){
        StudentEntity student = studentRepository.getOne(id);
        student.setRank(student.getRank()+rank);
        studentRepository.save(student);
    }

    public Integer getIdByEmail(String email){
        System.out.println(email + " " + studentRepository.getIdByEmail(email));
        return studentRepository.getIdByEmail(email);
    }

    public StudentDto getStudentById(Integer id) {
        return StudentMapper.entityToDto(studentRepository.getOne(id));
    }

    public void getTeacherByDate(Integer tariffId, StudentDto dto){
        //System.out.println(dto.getFreeDays().get(0));
        List<LocalDate> freeDates = new ArrayList<>();
        List<LocalTime> freeTimes = new ArrayList<>();
        List<ScheduleEntity> scheduleEntities = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(0);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        for (int i = 0; i < dto.getFreeDays().size(); i++) {
            freeDates.add(LocalDate.now()
                    .plusDays(7-LocalDate.now()
                            .getDayOfWeek()
                            .getValue())
                    .plusDays(dto.getFreeDays().get(i)));

            LocalTime freeTime = LocalTime.parse(dto.getFreeTimes().get(i), timeFormatter);
            freeTimes.add(freeTime);
        }
        for (int i = 0; i < freeDates.size(); i++) {
            for (int j = 0; j < scheduleRepository.getScheduleEntitiesByDateAndTime(freeDates.get(i), freeTimes.get(i)).size(); j++) {
                scheduleEntities.add(scheduleRepository.getScheduleEntitiesByDateAndTime(freeDates.get(i), freeTimes.get(i)).get(i));
                if(scheduleEntities.get(i).getTeacher().getCourse().getName().equals(tariffRepository.getOne(tariffId).getName())){
                    ids.add(scheduleEntities.get(i).getTeacher().getId());
                }
            }
        }
        Integer teacherId = searchTeacher(ids);
        setSchedule(freeDates, freeTimes, teacherId, tariffId, dto.getId());
    }

    public Integer searchTeacher(List<Integer> teacherIds){
        List<ScheduleCountEntity> sce = scheduleCountRepository.findAll();
        List<Integer> ids = new ArrayList<>();
        boolean exist = true;
        for (int i = 0; i < sce.size(); i++) {
            for (int j = 0; j < teacherIds.size(); j++) {
                if (sce.get(i).getId()== teacherIds.get(j)){
                    exist = true;
                    break;
                }
                else {
                    exist = false;
                }
            }
            if (!exist)
                ids.add(sce.get(i).getId());
        }
        System.out.println(ids);
        sce = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            sce.add(scheduleCountRepository.getOne(ids.get(i)));
        }
        Collections.sort(sce);
        return sce.get(0).getId();
    }

    public void setSchedule(List<LocalDate> freeDates, List<LocalTime> freeTimes, Integer teacherId, Integer tariffId, Integer studentId){
        Integer scheduleCount = tariffRepository.getOne(tariffId).getCount();
        for (int i = 0; i < scheduleCount/freeDates.size(); i++) {
            for (int j = 0; j < freeDates.size(); j++) {
                ScheduleEntity sc = ScheduleEntity.builder()
                        .date(freeDates.get(j))
                        .time(freeTimes.get(j))
                        .student(studentRepository.getOne(studentId))
                        .teacher(teacherRepository.getOne(teacherId))
                        .build();
                scheduleRepository.save(sc);
                freeDates.set(j, freeDates.get(j).plusDays(7));
                System.out.println(freeDates.get(j));
                System.out.println(sc);
            }
        }

        for (int i = 0; i < scheduleCount % freeDates.size(); i++) {
            ScheduleEntity sc = ScheduleEntity.builder()
                    .date(freeDates.get(i))
                    .time(freeTimes.get(i))
                    .student(studentRepository.getOne(studentId))
                    .teacher(teacherRepository.getOne(teacherId))
                    .build();
            scheduleRepository.save(sc);
            freeDates.set(i, freeDates.get(i).plusDays(7));
        }
        OrderEntity orderEntity = OrderEntity.builder()
                .course((teacherRepository.getOne(teacherId).getCourse()))
                .student(studentRepository.getOne(studentId))
                .teacher(teacherRepository.getOne(teacherId))
                .tariff(tariffRepository.getOne(tariffId))
                .build();
        orderRepository.save(orderEntity);

        TeacherEntity teacher = teacherRepository.getOne(teacherId);
        teacher.getStudents().add(studentRepository.getOne(studentId));
        teacherRepository.save(teacher);
    }
}
