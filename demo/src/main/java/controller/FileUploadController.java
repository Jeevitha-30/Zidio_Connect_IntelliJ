//package controller;
//
//import jakarta.annotation.Resource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.UrlResource;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import service.FileUploadService;
//
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Map;
//
//@RestController
//@RequestMapping("api/file")
//public class FileUploadController {
//    @Autowired
//    private FileUploadService fileUploadservice;
//
//    @PostMapping("/upload")
//    public ResponseEntity<Map<String String>> upload(@RequestParam("file") MultipartFile file)throws IOException {
//        Path path = fileUploadService.uploade(file);
//
//        return ResponseEntity.ok(Map.of("ResumeUrl",url));
//
//    }
//    @GetMapping("/{fileName}")
//
//    public ResponseEntity<Resource>download(@PathVariable string fileName) thrwos IOException{
//
//        Path path = Paths.get("uplaod/resumes").resolve(fileName);
//        Resource resource = new UrlResource(path.toUrl());
//
//        return ResponseEntity.ok().connectType(MediaType.APPLICATION_OCTET-STREAM).body(resource);
//    }
//}
