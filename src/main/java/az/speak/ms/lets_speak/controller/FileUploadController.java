package az.speak.ms.lets_speak.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import az.speak.ms.lets_speak.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class FileUploadController {
    private final TeacherRepository teacherRepository;
    private int i = 10;

    public FileUploadController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }

    @RequestMapping(value="/upload/{id}", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@PathVariable Integer id,
                                                 @RequestParam("file") MultipartFile file){
        String name = file.getOriginalFilename();
        int lastIndexOf = name.lastIndexOf(".");

        File upload = new File("src\\main\\resources\\static\\uploads\\uploaded-"+
                i+name.substring(lastIndexOf));
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(upload));
                stream.write(bytes);
                stream.close();
                teacherRepository.setCvByTeacherId(id, "/uploads/uploaded-"+i+name.substring(lastIndexOf));
                i++;
                return "Вы удачно загрузили " + name + " в " + name + "-uploaded !";
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }

    }

}
