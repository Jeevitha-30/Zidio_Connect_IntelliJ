package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileUploadService {

    @Value("${file.upload-dir}")
    private String UploadDir;

    public String uplaod(MultipartFile file)throws IOException {
        Path path = Paths.get(UploadDir);
        if(!Files.exists(path)) {

            Files.createDirectories(path);
        }
        String fileName= UUID.randomUUID()+"_"+ file.getOriginalFilename();
        Path targetPath= path.resolve(fileName);
        Files.copy(file.getInputStream(),targetPath, StandardCopyOption.REPLACE_EXISTING);

        return "/files/" +fileName;

    }
}
