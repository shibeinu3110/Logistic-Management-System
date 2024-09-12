package com.octl2.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "lc_subdistrict")
@Getter
@Setter
public class Subdistrict {
    @Id
    @Column(name = "subdistrict_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "code")
    private String code;

    @Column(name = "dcsr")
    private String description;


}
