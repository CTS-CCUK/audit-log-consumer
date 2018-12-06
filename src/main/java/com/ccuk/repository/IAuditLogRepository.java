package com.ccuk.repository;

import com.ccuk.model.AuditLog;

public interface IAuditLogRepository {

	void createAuditLog(AuditLog auditLog);
}
