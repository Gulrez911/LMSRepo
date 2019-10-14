package com.assessment.services.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.assessment.data.FileStatus;
import com.assessment.repositories.FileStatusRepository;
import com.assessment.services.FileStatusService;
@Service
public class FileStatusServiceImpl implements FileStatusService{
	@Autowired
	FileStatusRepository rep;
	
	Logger logger = LoggerFactory.getLogger(FileStatusServiceImpl.class);

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public void saveFileStatus(FileStatus status) {
		// TODO Auto-generated method stub
		logger.info("saving status "+status.getEmail());
		System.out.println("saving status");
		FileStatus status2 = rep.getUniqueFileStatus(status.getEmail());
			if(status2 == null){
				status.setCreateDate(new Date());
				rep.save(status);
			}
			else{
				status2.setUpdateDate(new Date());
				status2.setStatus(status.getStatus());
				rep.save(status2);
			}
			logger.info("saved");
			System.out.println("saved status "+status.getEmail());
	}

}
