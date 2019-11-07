package com.assessment.services.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.services.SQLCodingAutomationService;
@Service
public class SQLCodingAutomationServiceImpl implements SQLCodingAutomationService{
	@Autowired
	EntityManager entityManager;

	@Override
	public List<Object[]> fireDirectQuery(String query) {
		// TODO Auto-generated method stub
		List<Object[]> results = entityManager.createNativeQuery(query).getResultList();
		return results;
	}

}
