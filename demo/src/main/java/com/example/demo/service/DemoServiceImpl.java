package com.example.demo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.example.demo.model.Demo;
import com.example.demo.model.Reports;
import com.example.demo.repository.DemoRepository;
import com.example.demo.repository.ReportsRepository;
import com.example.demo.vo.DemoVO;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component
public class DemoServiceImpl implements DemoService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Autowired
	private ReportsRepository reportsRepository;
	
	@Autowired
	private DemoRepository demoRepository;

	public String sendSimpleMail(Demo emailDemo) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(sender);
		mailMessage.setTo(emailDemo.getRecipient());
		mailMessage.setText(emailDemo.getMessage());
		mailMessage.setSubject(emailDemo.getSubject());
		javaMailSender.send(mailMessage);
		return "Mail Sent Successfully...";
	}

	@Override
	public List<DemoVO> getDetails() {
		List<DemoVO> demos = new ArrayList<>();
		DemoVO demoVO = new DemoVO();
		demoVO.setName("honey");
		demoVO.setAddress("USA");
		demos.add(demoVO);
		return demos;
	}

	@Override
	public String exportService(String reportFormat, Reports report) throws FileNotFoundException, JRException {

		String path = "D:\\Honey";

		List<Reports> reportList = new ArrayList<>();
		reportList.add(report);
		File file = ResourceUtils.getFile("classpath:reports.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportList);
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("createdBy", "reports");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		if (reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\reports.html");
		}
		if (reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\reports.pdf");
		}
		return "Report Generated In Path : " + path;
	}

	@Override
	public List<Reports> getReports() {
		List<Reports> reportList = reportsRepository.findAll();
		reportList.stream().forEach(report -> {
			try {
				exportService("pdf", report);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (JRException e) {
				e.printStackTrace();
			}
		});

		return reportList;
	}

	@Override
	public Demo updateReports(Long id, Map<String, Object> fields) {
		Optional<Demo> demo = demoRepository.findById(id);
		if (demo.isPresent()) {
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findRequiredField(Demo.class, key);
				ReflectionUtils.setField(field, demo.get(), value);

			});
			demoRepository.save(demo.get());
		}
		return null;
	}

}
