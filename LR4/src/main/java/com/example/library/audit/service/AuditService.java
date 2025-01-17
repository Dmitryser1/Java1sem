package com.example.library.audit.service;

import com.example.library.audit.model.AuditLog;
import com.example.library.audit.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class AuditService {
    @Autowired
    private AuditLogRepository auditLogRepository;

    public void logEvent(String entityType, Long entityId, String action, String changedBy) {
        AuditLog log = new AuditLog();
        log.setEntityType(entityType);
        log.setEntityId(entityId);
        log.setAction(action);
        log.setChangedBy(changedBy);
        log.setChangedAt(new Date());
        auditLogRepository.save(log);
    }
}