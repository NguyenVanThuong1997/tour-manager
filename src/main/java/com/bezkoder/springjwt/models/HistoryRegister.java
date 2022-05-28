package com.bezkoder.springjwt.models;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class HistoryRegister {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String emailCustomer;
    private String addressCustomer;
    private String phone;
    private String scheduleRegis;
    private String status;

    @CreatedDate
    private Date timeRegis;

}
