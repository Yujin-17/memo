package com.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManagerService {
	// 실제 이미지가 저장되는 경로
	public final static String FILE_UPLOAD_PATH = "C:\\Users\\유진\\Desktop\\코딩\\6_spring_project\\ex_memo\\workspace\\images/";
	
	// input: file 
	// output: image path
	public String saveFile(String loginId, MultipartFile file) throws IOException {
		// 파일 디렉토리 경로 예: lyjyellow_202207071422/sum.png
		// 파일명이 겹치지 않게 하기 위해 현재시간을 경로에 붙여준다. 
		String directoryName =  loginId + "_" + System.currentTimeMillis() + "/";
		// C:\\Users\\유진\\Desktop\\코딩\\6_spring_project\\ex_memo\\workspace\\images/lyjyellow_202207071422/
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			return null; // 디렉토리 생성 실패시 path null 리턴 
		}
		
		// 파일 업로드: byte 단위로 업로드 한다. 
		byte[] bytes = file.getBytes();
		// C:\\Users\\유진\\Desktop\\코딩\\6_spring_project\\ex_memo\\workspace\\images/lyjyellow_202207071422/sun.png
		Path path = Paths.get(filePath + file.getOriginalFilename());
		Files.write(path, bytes);
		
		// http://localhost/images/lyjyellow_202207071422/sun.png
		return "/images/" + directoryName + file.getOriginalFilename();
		
		
	}
}
