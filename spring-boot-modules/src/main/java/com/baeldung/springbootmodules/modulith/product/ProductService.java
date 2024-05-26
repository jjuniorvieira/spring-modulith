package com.baeldung.springbootmodules.modulith.product;


import com.baeldung.springbootmodules.modulith.notification.NotificationDTO;
import com.baeldung.springbootmodules.modulith.notification.NotificationService;
import com.baeldung.springbootmodules.modulith.product.internal.Product;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductService {

    private final ApplicationEventPublisher events;
    private final NotificationService notificationService;

    public ProductService(ApplicationEventPublisher events, NotificationService notificationService
    ) {
        this.events = events;
        this.notificationService = notificationService;
    }

    public void create(Product product) {
        notificationService.createNotification(new NotificationDTO(new Date(), "SMS", product.getName()));
        events.publishEvent(new NotificationDTO(new Date(), "SMS", product.getName()));
    }
}