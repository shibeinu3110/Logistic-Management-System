package com.octl2.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "bp_partner")
@Getter
@Setter
public class Partner {
    @Id
    @Column(name = "partner_id")
    private Long partnerId;

    @Column(name = "partner_type")
    private Long partnerType;

    @Column(name = "name")
    private String name;

    @Column(name = "shortname")
    private String shortName;

    @Column(name = "contact")
    private String contact;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "modifyby")
    private Long modifyBy;

    @Column(name = "modifydate")
    private Timestamp modifyDate;

    @Column(name = "logo_path_01")
    private String logoPath01;

    @Column(name = "logo_path_02")
    private String logoPath02;

    @Column(name = "type")
    private Long type;

    @Column(name = "skill_level")
    private Long skillLevel;

    @Column(name = "org_id")
    private Long orgId;


}
