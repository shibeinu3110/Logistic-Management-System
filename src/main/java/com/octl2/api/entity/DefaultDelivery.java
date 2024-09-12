package com.octl2.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "cf_default_delivery")
@Getter
@Setter
public class DefaultDelivery {
    @Id
    @Column(name = "cf_default_do_id")
    private Long id;

    @Column(name = "org_id")
    private Long orgId;

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "ffm_id")
    private Long ffmId;

    @Column(name = "lastmile_id")
    private Long lmId;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "createby")
    private Long createBy;

    @Column(name = "createdate")
    private Timestamp createDate;

    @Column(name = "modifyby")
    private Long modifyBy;

    @Column(name = "modifydate")
    private Timestamp modifyDate;
}
