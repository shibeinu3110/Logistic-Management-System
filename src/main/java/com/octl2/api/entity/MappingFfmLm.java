package com.octl2.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cf_mapping_ffm_lm")
@Getter
@Setter
public class MappingFfmLm {
    @Id
    @Column(name = "mapping_id")
    private Long mappingId;
    @Column(name = "ffm_id")
    private Long ffmId;
    @Column(name = "lm_id")
    private Long lmId;
}
