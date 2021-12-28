package com.evtDoc.main.upload.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService {

  @Override
  public void init(String location) {
    try {
      Files.createDirectory(Paths.get("uploads/"+location));
    } catch (IOException e) {
      throw new RuntimeException("Could not initialize folder for upload!");
    }
  }

  @Override
  public void save(MultipartFile file,String location) {
    try {
      Files.copy(file.getInputStream(), Paths.get("uploads/"+location).resolve(file.getOriginalFilename()));
    } catch (Exception e) {
      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
    }
  }

  @Override
  public Resource load(String filename,String location) {
    try {
      Path file = Paths.get("uploads/"+location).resolve(filename);
      Resource resource = new UrlResource(file.toUri());

      if (resource.exists() || resource.isReadable()) {
        return resource;
      } else {
        throw new RuntimeException("Could not read the file!");
      }
    } catch (MalformedURLException e) {
      throw new RuntimeException("Error: " + e.getMessage());
    }
  }

  @Override
  public void deleteAll(String location) {
    FileSystemUtils.deleteRecursively(Paths.get("uploads/"+location).toFile());
  }

  @Override
  public Stream<Path> loadAll(String location) {
    try {
      return Files.walk(Paths.get("uploads/"+location), 1).filter(path -> !path.equals(Paths.get("uploads/"+location))).map(Paths.get("uploads/"+location)::relativize);
    } catch (IOException e) {
      throw new RuntimeException("Could not load the files!");
    }
  }

}
