package com.memo.post;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.memo.post.bo.PostBO;

@RestController("/post")
public class PostRestController {

	@Autowired
	private PostBO postBO;
	
	
	@PostMapping("/create")
	public Map<String, Object> create(
			@RequestParam("subject") String subject,
			@RequestParam("content") String content,
			@RequestParam(value = "file", required=false) MultipartFile file,
			HttpServletRequest request
			){
		
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		String userLoginId = (String) session.getAttribute("userLoginId");
		
		// BO create
		int row = postBO.addPost(userLoginId, userId, subject, content, file);
		
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		if(row < 1) {
			result.put("result", "error");
			result.put("error_message", "메모 저장에 실패했습니다. 다시 시도해주세요.");
		}
		
		
		return result;
	} 
}
