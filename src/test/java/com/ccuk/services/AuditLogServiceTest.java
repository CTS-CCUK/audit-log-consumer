package com.ccuk.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.ccuk.model.AuditLog;
import com.ccuk.model.enums.CountryCode;
import com.ccuk.repository.AuditLogRepository;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(SpringRunner.class)
public class AuditLogServiceTest {
	
    @Mock
    private AuditLogRepository auditLogRepositoryMock;
    
    @InjectMocks
    private AuditLogService AuditLogServiceMock;

	@Test
	public void verifyCreateAuditLog() {
		//given
		AuditLog auditLog  = getDummyAuditLogDetails();
		auditLog.setCountryCode(CountryCode.FR);
		auditLog.setUniqueId("000123");
		
		//when
		AuditLogServiceMock.createAuditLog(auditLog);
		
		//then
		verify(auditLogRepositoryMock, times(1)).createAuditLog(auditLog);
	}
	
    private AuditLog getDummyAuditLogDetails() {
        PodamFactory factory = new PodamFactoryImpl();
        AuditLog auditLog = factory.manufacturePojo(AuditLog.class);
        return auditLog;
    }

}
