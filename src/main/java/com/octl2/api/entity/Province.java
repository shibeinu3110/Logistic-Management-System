package com.octl2.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lc_province")
@Getter
@Setter
public class Province {
    @Id
    @Column(name = "province_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "shortname")
    private String shortname;

    @Column(name = "code")
    private String code;

    @Column(name = "dcsr")
    private String description;

    @Column(name = "region_id")
    private Long regionId;

    @Column(name = "org_id")
    private Long orgId;

}
