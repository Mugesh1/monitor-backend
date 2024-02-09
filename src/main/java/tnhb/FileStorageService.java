package tnhb;

import models.FileDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import repos.FileDBRepository;

import java.io.IOException;
import java.util.stream.Stream;


@Service
public class FileStorageService {

  @Autowired
  private FileDBRepository fileDBRepository;

  public FileDB store(MultipartFile file) throws IOException {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    FileDB FileDB = new FileDB(fileName,file.getContentType(), file.getBytes());

    return fileDBRepository.save(FileDB);
  }

  public FileDB getFile(String id) {
    return fileDBRepository.findById(id).get();
  }
  
  public Stream<FileDB> getAllFiles() {
    return fileDBRepository.findAll().stream();
  }
  public boolean deleteFile(String id) {
    try {
      if (id != null) {
        fileDBRepository.deleteById(id);
        return true;
      } else {
        // Handle the case where id is null
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }


}
