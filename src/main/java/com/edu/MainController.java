package com.edu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.edu.lecture.LectureRepository;
import com.edu.notice.NoticeRepository;

@Controller
public class MainController {
	@Autowired
	private LectureRepository lectureRepository;
	
	@Autowired
	private NoticeRepository noticeRepository;
	
	//GET  http://localhost:8089/Edu
	@GetMapping("/Edu")
	@ResponseBody
    public String index() {
       return "index";
    }
	
	//GET  http://localhost:8089/
	@GetMapping("/")
	 public String root(Model model) {
		// 홈페이지 통계 데이터
		model.addAttribute("lectureCount", lectureRepository.count());
		model.addAttribute("noticeCount", noticeRepository.count());
		
		// 최신 강의 6개
		model.addAttribute("lectures", lectureRepository.findAll());
		
		// 최신 공지사항 3개
		model.addAttribute("notices", noticeRepository.findAll());
		
		return "index";
	}
}
