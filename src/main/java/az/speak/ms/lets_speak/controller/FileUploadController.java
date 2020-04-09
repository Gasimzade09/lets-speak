package az.speak.ms.lets_speak.controller;

import az.speak.ms.lets_speak.service.FileUploadService;
import io.swagger.annotations.Api;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Api(value = "/api", description = "Котроллер для загрузки файлов")
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
        return fileUploadService.setCvForTeacher(id, file);
    }

    @RequestMapping(value= "/upload/task/{studentId}/{teacherId}/{taskName}", method=RequestMethod.POST)
    public @ResponseBody String handleTaskUpload(@PathVariable Integer studentId,
                                                 @PathVariable Integer teacherId,
                                                 @PathVariable String taskName,
                                                 @RequestParam("file") MultipartFile file){
        return fileUploadService.taskUpload(studentId, teacherId, taskName, file);
    }
}
