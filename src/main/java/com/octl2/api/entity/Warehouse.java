package com.octl2.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "bp_warehouse")
@Getter
@Setter
public class Warehouse {
    @Column(name = "org_id")
    private Long orgId;

    @ManyToOne
    @JoinColumn(name = "ffm_id")
    private Partner ffmPartner;

    @Id
    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "warehouse_name")
    private String warehouseName;

    @Column(name = "warehouse_shortname")
    private String warehouseShortname;

    @Column(name = "contact_name")
    private String contactName;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "address")
    private String address;

    @Column(name = "full_address")
    private String fullAddress;

    @Column(name = "wards_id")
    private Long wardsId;

    @Column(name = "wards_code")
    private String wardsCode;

    @Column(name = "wards_name")
    private String wardsName;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "district_code")
    private String districtCode;

    @Column(name = "district_name")
    private String districtName;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "province_code")
    private String provinceCode;

    @Column(name = "provinceName")
    private String provinceName;

    @Column(name = "email")
    private String email;

    @Column(name = "is_edit_wh")
    private Long isEditWH;

    @Column(name = "ismain")
    private Long isMain;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "is_active")
    private Long isActive;

    @Column(name = "createby")
    private Long createBy;

    @Column(name = "createdate")
    private Timestamp createDate;

    @Column(name = "modifyby")
    private Long modifyBy;

    @Column(name = "modifydate")
    private Timestamp modifyDate;

    @Column(name = "wh_code_inpartner")
    private String whCodeInpartner;







}
