package com.example.library.audit.service;

import com.example.library.audit.model.AuditEvent;
import com.example.library.audit.repository.AuditEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class AuditService {
    @Autowired
    private AuditEventRepository auditEventRepository;

    public void logEvent(String entityType, Long entityId, String action, String changedBy) {
        AuditEvent event = new AuditEvent();
        event.setEntityType(entityType);
        event.setEntityId(entityId);
        event.setAction(action);
        event.setChangedBy(changedBy);
        event.setChangedAt(new Date());
        auditEventRepository.save(event);
    }
}