package com.spring.book.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Component
public class helper {

//	public final String UPLOAD_DIR = "/Users/ankit/Documents/workspace-spring-tool-suite-4-4.22.0.RELEASE/SpringBook/src/main/resources/static/image";
	public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();
	

	/*
	 * this code is added for the aboveline to handle the exception thrown by the ClassPathResource
	 */
	public helper() throws IOException {

	}

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
