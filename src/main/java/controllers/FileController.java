package controllers;
import message.ResponseFile;
import message.ResponseMessage;
import models.FileDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tnhb.FileStorageService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@CrossOrigin("localhost:4200")
public class FileController {
  @Autowired
  private FileStorageService storageService;
  @PostMapping("/upload")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("files") List<MultipartFile> files) {
    List<String> success = new ArrayList<>();
    List<String> failure  = new ArrayList<>();
    files.forEach(file->{
      try {
        storageService.store(file);
        success.add(file.getOriginalFilename());
      } catch (IOException e) {
        failure.add(file.getOriginalFilename());
      }
    });
    String message = failure.size() > 1 ? String.format("Failed For %s Items", failure.size()) : String.format("Uploaded Successfully %s Items", success.size());
    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
  }
  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
          .path(dbFile.getId())
          .toUriString();

      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
    FileDB fileDB = storageService.getFile(id);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + ".pdf")
        .body(fileDB.getData());
  }

  @DeleteMapping("/files/{id}")
  public ResponseEntity<String> deleteFile(@PathVariable String id) {
    boolean deleted = storageService.deleteFile(id);
    if (deleted) {
      return ResponseEntity.ok("File deleted successfully");
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete file");
    }
  }


}



