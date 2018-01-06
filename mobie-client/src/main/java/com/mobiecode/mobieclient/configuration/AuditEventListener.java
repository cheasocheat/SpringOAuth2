/*
package com.mobiecode.mobieclient.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.boot.actuate.audit.listener.AbstractAuditListener;
import org.springframework.stereotype.Component;

*/
/**
 * Developer : cheasocheat
 * Created on 1/6/18 13:43
 *//*

@Component
public class AuditEventListener extends AbstractAuditListener {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final AuditEventRepository auditEventRepository;

    public AuditEventListener(AuditEventRepository auditEventRepository) {
        this.auditEventRepository = auditEventRepository;
    }

    @Override
    protected void onAuditEvent(AuditEvent event) {
        logger.info("On audit event: timestamp: {}, principal: {}, type: {}, data: {}",
                event.getTimestamp(),
                event.getPrincipal(),
                event.getType(),
                event.getData()
        );

        auditEventRepository.add(event);
    }
}
*/
