package vn.com.unit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.unit.repository.LogRepository;
import vn.com.unit.service.LogService;

@Service
@Transactional
public class LogServiceImpl implements LogService {

	@Autowired
	LogRepository logRepository;
	
	@Override
	public void saveLog(String log, String type, String author) {
		logRepository.saveLog(log, type, author);
	}

}
