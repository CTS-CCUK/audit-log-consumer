package com.ccuk.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ccuk.model.AuditLog;
import com.ccuk.model.enums.CountryCode;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AuditLogRepositoryTest {
	
    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Autowired
    private AuditLogRepository auditLogRepositoryMock;

	@Test
	public void testCreateAuditLog() {
        mongoTemplate.dropCollection(AuditLog.class);
        AuditLog auditLog = getDummyAuditLogDetails();
        auditLog.setCountryCode(CountryCode.FR);
        
        //when
        auditLogRepositoryMock.createAuditLog(auditLog);
        
        //then
        List<AuditLog> saved = mongoTemplate.findAll(AuditLog.class);
        assertEquals(1, saved.size());
        assertEquals(auditLog.getId(), saved.get(0).getId());
        assertEquals(auditLog.getAnnexFileName(), saved.get(0).getAnnexFileName());
        assertEquals(auditLog.getCountryCode(), saved.get(0).getCountryCode());
        assertEquals(auditLog.getDateScheduled().size(), saved.get(0).getDateScheduled().size());
        assertEquals(auditLog.getScheduleFileName(), saved.get(0).getScheduleFileName());
        assertEquals(auditLog.getUniqueId(), saved.get(0).getUniqueId());
        assertEquals(auditLog.getUsername(), saved.get(0).getUsername());

	}
	
    private AuditLog getDummyAuditLogDetails() {
        PodamFactory factory = new PodamFactoryImpl();
        AuditLog auditLog = factory.manufacturePojo(AuditLog.class);
        return auditLog;
    }

}
