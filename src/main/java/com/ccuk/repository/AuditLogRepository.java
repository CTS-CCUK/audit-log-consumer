package com.ccuk.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.ccuk.model.AuditLog;

@Repository
public class AuditLogRepository implements IAuditLogRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(AuditLogRepository.class);
	
	@Override
	public void createAuditLog(AuditLog auditLog) {
		logger.info("Call received in AuditLogRepository : createAuditLog");
		mongoTemplate.save(auditLog);
		logger.info("Audit Log is created Successfully");
	}
}
