package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.service.FileUploadService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@CrossOrigin
public class FileUploadController<handle> {

    private final FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @RequestMapping(value="/upload", method=RequestMethod.GET)
    public @ResponseBody String provideUploadInfo() {
        return "Вы можете загружать файл с использованием того же URL.";
    }

    @RequestMapping(value="/upload/{id}", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@PathVariable Integer id,
                                                 @RequestParam("file") MultipartFile file){
        return fileUploadService.fileUpload(id, file);
    }

    @RequestMapping(value= "/upload/task/{studentId}/{teacherId}/{taskName}", method=RequestMethod.POST)
    public @ResponseBody String handleTaskUpload(@PathVariable Integer studentId,
                                                 @PathVariable Integer teacherId,
                                                 @PathVariable String taskName,
                                                 @RequestParam("file") MultipartFile file){
        return fileUploadService.taskUpload(studentId, teacherId, taskName, file);
    }
}
