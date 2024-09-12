package com.octl2.api.repository;

import com.octl2.api.consts.Const;
import com.octl2.api.dto.ResultQuery;
import com.octl2.api.entity.MappingFfmLm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MappingFfmLmRepository extends JpaRepository<MappingFfmLm, Long> {
    @Query(value = "select \n" +
            "\tcf.ffm_id as ffmId,\n" +
            "\tffm_pn.name as ffmName,\n" +
            "\tcf.lm_id as lmId,\n" +
            "\tlm_pn.name as lmName,\n" +
            "\tlm_pn.shortname as lmShortname,\n" +
            "\twh.warehouse_id as whId,\n" +
            "\twh.warehouse_name as whName,\n" +
            "\twh.warehouse_shortname as whShortName\n" +
            "\n" +
            "from cf_mapping_ffm_lm cf\n" +
            "left join bp_partner ffm_pn on cf.ffm_id  = ffm_pn.partner_id and ffm_pn.partner_type = " + Const.TYPE_FFM + "\n" +
            "left join bp_partner lm_pn on cf.lm_id = lm_pn.partner_id and lm_pn.partner_type = " + Const.TYPE_LM + "\n" +
            "left join bp_warehouse wh on cf.ffm_id = wh.ffm_id\n" +
            "order by cf.ffm_id asc, cf.lm_id asc\n"
            , nativeQuery = true)
    List<ResultQuery> getFfmInfo();
}
