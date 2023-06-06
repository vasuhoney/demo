package com.example.demo.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.model.Demo;
import com.example.demo.model.Reports;
import com.example.demo.vo.DemoVO;

import net.sf.jasperreports.engine.JRException;

@Service
public interface DemoService {
	
	String sendSimpleMail(Demo emailDemo);

	List<DemoVO> getDetails();

	String exportService(String format, Reports report) throws FileNotFoundException, JRException;

	List<Reports> getReports();

	Demo updateReports(Long id, Map<String, Object> fields);

}
