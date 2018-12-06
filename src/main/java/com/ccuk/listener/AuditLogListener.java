package com.ccuk.listener;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.ccuk.model.AuditLog;

import com.ccuk.services.AuditLogService;

@Component
@PropertySource("classpath:application.properties")
public class AuditLogListener {
	
	@Autowired
	private AuditLogService auditLogService;
	
	 private static final Logger log = LoggerFactory.getLogger(AuditLogListener.class);
	 
	    @RabbitListener(queues = "${spring.rabbitmq.queuename}")
	    public void receiveMessage(final AuditLog auditLog) throws IOException {
	        log.info("Received Audit Log : " + auditLog);
	        auditLogService.createAuditLog(auditLog);
	    }

}
