package com.octl2.api.repository;

import com.octl2.api.consts.Const;
import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.ResultQuery;
import com.octl2.api.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
    @Query(value = "select \n" +
            "\td.district_id as districtId,\n" +
            "\td.name as districtName,\n" +
            "\td.code as districtCode,\n" +
            "\tbp_ffm.partner_id as ffmId,\n" +
            "\tbp_ffm.name as ffmName,\n" +
            "\tbp_ffm.shortname as ffmShortName,\n" +
            "\tbp_lm.partner_id as lmId,\n" +
            "\tbp_lm.name as lmName,\n" +
            "\tbp_lm.shortname as lmShortName,\n" +
            "\tbp_wh.warehouse_id as whId,\n" +
            "\tbp_wh.warehouse_name as whName,\n" +
            "\tbp_wh.warehouse_shortname as whShortName\n" +
            "\n" +
            "from lc_district d \n" +
            "join lc_province p on d.province_id = p.province_id\n" +
            "left join cf_default_delivery cf on p.province_id = cf.location_id\n" +
            "left join bp_partner bp_ffm on cf.ffm_id = bp_ffm.partner_id and bp_ffm.partner_type = " + Const.TYPE_FFM + "\n" +
            "left join bp_partner bp_lm on cf.lastmile_id = bp_lm.partner_id and bp_lm.partner_type = " + Const.TYPE_LM + "\n" +
            "left join bp_warehouse bp_wh on cf.warehouse_id = bp_wh.warehouse_id\n" +
            "where p.province_id = :provinceId\n" +
            "order by d.district_id asc", nativeQuery = true)
    List<ResultQuery> getDistrictLogisticDataLevelOne(@Param("provinceId") Long provinceId);
    @Query(value = "select \n" +
            "\td.district_id as districtId,\n" +
            "\td.name as districtName,\n" +
            "\td.code as districtCode,\n" +
            "\tbp_ffm.partner_id as ffmId,\n" +
            "\tbp_ffm.name as ffmName,\n" +
            "\tbp_ffm.shortname as ffmShortName,\n" +
            "\tbp_lm.partner_id as lmId,\n" +
            "\tbp_lm.name as lmName,\n" +
            "\tbp_lm.shortname as lmShortName,\n" +
            "\tbp_wh.warehouse_id as whId,\n" +
            "\tbp_wh.warehouse_name as whName,\n" +
            "\tbp_wh.warehouse_shortname as whShortName\n" +
            "\n" +
            "from lc_district d \n" +
            "join lc_province p on d.province_id = p.province_id\n" +
            "left join cf_default_delivery cf on d.district_id = cf.location_id\n" +
            "left join bp_partner bp_ffm on cf.ffm_id = bp_ffm.partner_id and bp_ffm.partner_type = " + Const.TYPE_FFM + "\n" +
            "left join bp_partner bp_lm on cf.lastmile_id = bp_lm.partner_id and bp_lm.partner_type = " + Const.TYPE_LM + "\n" +
            "left join bp_warehouse bp_wh on cf.warehouse_id = bp_wh.warehouse_id\n" +
            "where p.province_id = :provinceId\n" +
            "order by d.district_id asc", nativeQuery = true)
    List<ResultQuery> getDistrictLogisticDataLevelTwo(@Param("provinceId") Long provinceId);
    @Query(value = "select \n" +
            "\td.district_id as districtId,\n" +
            "\td.name as districtName,\n" +
            "\td.code as districtCode,\n" +
            "\tbp_ffm.partner_id as ffmId,\n" +
            "\tbp_ffm.name as ffmName,\n" +
            "\tbp_ffm.shortname as ffmShortName,\n" +
            "\tbp_lm.partner_id as lmId,\n" +
            "\tbp_lm.name as lmName,\n" +
            "\tbp_lm.shortname as lmShortName,\n" +
            "\tbp_wh.warehouse_id as whId,\n" +
            "\tbp_wh.warehouse_name as whName,\n" +
            "\tbp_wh.warehouse_shortname as whShortName\n" +
            "\n" +
            "from lc_district d \n" +
            "join lc_province p on d.province_id = p.province_id\n" +
            "join lc_subdistrict sd on d.district_id = sd.district_id \n" +
            "left join cf_default_delivery cf on sd.subdistrict_id = cf.location_id\n" +
            "left join bp_partner bp_ffm on cf.ffm_id = bp_ffm.partner_id and bp_ffm.partner_type = " + Const.TYPE_FFM + "\n" +
            "left join bp_partner bp_lm on cf.lastmile_id = bp_lm.partner_id and bp_lm.partner_type = " + Const.TYPE_LM + "\n" +
            "left join bp_warehouse bp_wh on cf.warehouse_id = bp_wh.warehouse_id\n" +
            "where p.province_id = :provinceId\n" +
            "order by d.district_id asc", nativeQuery = true)
    List<ResultQuery> getDistrictLogisticDataLevelThree(@Param("provinceId") Long provinceId);

    @Query(value = "select \n" +
            "\tp.province_id as provinceId,\n" +
            "\tp.name as provinceName,\n" +
            "\td.district_id as districtId,\n" +
            "\td.name as districtName,\n" +
            "\tbp_ffm.partner_id as ffmId,\n" +
            "\tbp_ffm.name as ffmName,\n" +
            "\tbp_lm.partner_id as lmId,\n" +
            "\tbp_lm.name as lmName,\n" +
            "\tbp_wh.warehouse_id as whId,\n" +
            "\tbp_wh.warehouse_name as whName\n" +
            "\n" +
            "from lc_province p \n" +
            "left join lc_district d on p.province_id = d.province_id\n" +
            "left join cf_default_delivery cf on d.district_id = cf.location_id \n" +
            "left join bp_partner bp_ffm on cf.ffm_id = bp_ffm.partner_id and bp_ffm.partner_type = " +  Const.TYPE_FFM + "\n" +
            "left join bp_partner bp_lm on cf.lastmile_id = bp_lm.partner_id and bp_lm.partner_type = " + Const.TYPE_LM + "\n" +
            "left join bp_warehouse bp_wh on cf.warehouse_id = bp_wh.warehouse_id\n" +
            "order by p.province_id asc, d.district_id asc\n", nativeQuery = true)
    List<ResultQuery> exportDistrictLogistic();



    @Modifying
    @Transactional
    @Query(value = "update cf_default_delivery\n" +
            "set ffm_id = :#{#deliveryDTO.fulfillmentId},\n" +
            "\tlastmile_id = :#{#deliveryDTO.lastMileId},\n" +
            "\twarehouse_id = :#{#deliveryDTO.warehouseId}\n" +
            "where location_id = :locationId", nativeQuery = true)
    void updateLevelTwo(Long locationId, DeliveryDTO deliveryDTO);

    @Modifying
    @Transactional
    @Query(value = "update cf_default_delivery\n" +
            "set ffm_id = :#{#deliveryDTO.fulfillmentId},\n" +
            "\tlastmile_id = :#{#deliveryDTO.lastMileId},\n" +
            "\twarehouse_id = :#{#deliveryDTO.warehouseId}\n" +
            "where location_id in (select sd.subdistrict_id from lc_subdistrict sd where sd.district_id = :locationId)", nativeQuery = true)
    void updateLevelThree(Long locationId, DeliveryDTO deliveryDTO);


    @Query(value = "select count(*) from lc_district d where d.district_id = :locationId", nativeQuery = true)
    Long checkValidDistrict(@Param("locationId") Long locationId);

}
