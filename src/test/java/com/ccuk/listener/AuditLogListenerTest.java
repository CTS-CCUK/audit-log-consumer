package com.ccuk.listener;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ccuk.model.AuditLog;
import com.ccuk.services.AuditLogService;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(MockitoJUnitRunner.class)
public class AuditLogListenerTest {
	
	@InjectMocks
	private AuditLogListener auditLogListener;
	
	@Mock
	private AuditLogService auditLogServiceMock;

	@Test
	public void createAuditLog() throws IOException {
		
        //given
		AuditLog auditLog = getDummyAuditLogDetails();

        //when
		auditLogListener.receiveMessage(auditLog);

        //then
        verify(auditLogServiceMock, times(1)).createAuditLog(auditLog);
	}

	
    private AuditLog getDummyAuditLogDetails() {
        PodamFactory factory = new PodamFactoryImpl();
        AuditLog auditLog = factory.manufacturePojo(AuditLog.class);
        return auditLog;
    }
}
