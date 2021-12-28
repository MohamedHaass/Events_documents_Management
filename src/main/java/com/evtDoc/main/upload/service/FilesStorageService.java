package com.evtDoc.main.upload.service;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FilesStorageService {
  public void init(String location);

  public void save(MultipartFile file,String location);

  public Resource load(String filename,String location);

  public void deleteAll(String location);

  public Stream<Path> loadAll(String location);
}
