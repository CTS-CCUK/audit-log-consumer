package com.ccuk.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccuk.model.AuditLog;
import com.ccuk.repository.AuditLogRepository;

@Service
public class AuditLogService {

	private static final Logger log = LoggerFactory.getLogger(AuditLogService.class);
	
	@Autowired
	private AuditLogRepository auditLogRepository;
	
	public void createAuditLog(AuditLog auditLog)
	{
		log.info("Call received in AuditLogService : createAuditLog: {}",auditLog);
		auditLogRepository.createAuditLog(auditLog);
	}
}
