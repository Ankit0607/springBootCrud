package com.spring.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.spring.book.helper.helper;

@RestController
public class fileUploadController {
	@Autowired
	helper helper;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadfile(@RequestParam("file") MultipartFile file) {

		try {
			// validation
			if (file.isEmpty())
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file must not be empty");
			if (!file.getContentType().equals("image/jpeg"))
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("file type must be JPEG or JPG only");
			else if (file.getContentType().equals("image/jpg"))
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("file type must be JPEG or JPG only");

			boolean f = helper.uploadFile(file);
			if (f)
				return ResponseEntity.ok("File Uploaded Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("working");
	}

}
