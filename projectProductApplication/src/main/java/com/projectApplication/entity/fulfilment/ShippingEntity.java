package com.projectApplication.entity.fulfilment;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
public class ShippingEntity {
    @Id
    private Long orderCode;
    private String status;

    public ShippingEntity(Long orderCode, String status) {
        this.orderCode = orderCode;
        this.status = status;
    }

    public Long getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Long orderCode) {
        this.orderCode = orderCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
