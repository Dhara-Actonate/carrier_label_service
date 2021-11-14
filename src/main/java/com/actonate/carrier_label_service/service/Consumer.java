package com.actonate.carrier_label_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

//    @Autowired
//    private AuditLogsService auditLogsService;

    @KafkaListener(topics = "test")
    public void processMessage(String content) {
        System.out.println("Message received: " + content);
    }

    @KafkaListener(topics = "cosmetize-v2-analytics")
    public void saveLogs(Object auditLog) {
        System.out.println("saveLogs Consumer: " + auditLog+ (auditLog instanceof String));

        try {
            // this.auditLogsService.log(auditLog);
        } catch (Exception e) {
            System.out.println("Exception in saveLogs Consumer:" + e.getMessage());
        }

    }
}

