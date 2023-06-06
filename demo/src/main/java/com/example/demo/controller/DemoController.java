package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Demo;
import com.example.demo.model.Reports;
import com.example.demo.service.DemoService;
import com.example.demo.vo.DemoVO;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("mail")
public class DemoController {

	@Autowired
	private DemoService demoService;

	@PostMapping("/sendMail")
	public String sendMail(@RequestBody Demo emailDemo) {
		return demoService.sendSimpleMail(emailDemo);
	}

	@GetMapping(path = "/demo")
	public ResponseEntity<?> getDetails() {
		List<DemoVO> demoList = demoService.getDetails();
		return ResponseEntity.ok(demoList);
	}

	@GetMapping(path = "/reports")
	public ResponseEntity<?> getReports() {
		List<Reports> reportList = demoService.getReports();
		return ResponseEntity.ok(reportList);
	}

	@GetMapping("/report/{format}")
	public String generateReports(@PathVariable String format) throws FileNotFoundException, JRException {

		return demoService.exportService(format, null);

	}

	@PatchMapping("/{id}")
	public ResponseEntity<Demo> updateReports(@PathVariable Long id, @RequestBody Map<String, Object> fields) {

		Demo demo = demoService.updateReports(id, fields);
		return ResponseEntity.ok(demo);

	}

}
