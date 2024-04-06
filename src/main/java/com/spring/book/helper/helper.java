package com.spring.book.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class helper {

	public final String UPLOAD_DIR = "/Users/ankit/Documents/workspace-spring-tool-suite-4-4.22.0.RELEASE/SpringBook/src/main/resources/static/image";

	public boolean uploadFile(MultipartFile multipartFile) {
		boolean f = false;
		try {

			Files.copy(multipartFile.getInputStream(),
					Paths.get(UPLOAD_DIR + File.separator + multipartFile.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}
}
