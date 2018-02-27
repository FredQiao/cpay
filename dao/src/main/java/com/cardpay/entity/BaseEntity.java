package com.cardpay.entity;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    private String id;


    protected BaseEntity() {
        this.id = UUID.randomUUID().toString().replaceAll("-","");
    }
}
