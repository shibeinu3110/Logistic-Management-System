package com.octl2.api.repository;

import com.octl2.api.consts.Const;
import com.octl2.api.dto.DeliveryDTO;
import com.octl2.api.dto.ResultQuery;
import com.octl2.api.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {
    @Query(value = "select\n" +
            "\tp.province_id as provinceId,\n" +
            "\tp.name as provinceName,\n" +
            "\tp.code as provinceCode,\n" +
            "\tbp_ffm.partner_id as ffmId,\n" +
            "\tbp_ffm.name as ffmName,\n" +
            "\tbp_ffm.shortname as ffmShortName,\n" +
            "\tbp_lm.partner_id as lmId,\n" +
            "\tbp_lm.name as lmName,\n" +
            "\tbp_lm.shortname as lmShortName,\n" +
            "\tbp_wh.warehouse_id as whId,\n" +
            "\tbp_wh.warehouse_name as whName,\n" +
            "\tbp_wh.warehouse_shortname as whShortName\n" +
            "\t\n" +
            "from lc_province p \n" +
            "join cf_default_delivery cf on p.province_id = cf.location_id\n" +
            "join bp_partner bp_ffm on cf.ffm_id = bp_ffm.partner_id and bp_ffm.partner_type = " + Const.TYPE_FFM + "\n" +
            "join bp_partner bp_lm on cf.lastmile_id = bp_lm.partner_id and bp_lm.partner_type = " + Const.TYPE_LM + "\n" +
            "join bp_warehouse bp_wh on cf.warehouse_id = bp_wh.warehouse_id\n" +
            "order by p.province_id asc", nativeQuery = true)
    List<ResultQuery> getProvinceLogisticDataLevelOne();
    @Query(value = "select\n" +
            "\tp.province_id as provinceId,\n" +
            "\tp.name as provinceName,\n" +
            "\tp.code as provinceCode,\n" +
            "\tbp_ffm.partner_id as ffmId,\n" +
            "\tbp_ffm.name as ffmName,\n" +
            "\tbp_ffm.shortname as ffmShortName,\n" +
            "\tbp_lm.partner_id as lmId,\n" +
            "\tbp_lm.name as lmName,\n" +
            "\tbp_lm.shortname as lmShortName,\n" +
            "\tbp_wh.warehouse_id as whId,\n" +
            "\tbp_wh.warehouse_name as whName,\n" +
            "\tbp_wh.warehouse_shortname as whShortName\n" +
            "\t\n" +
            "from lc_province p \n" +
            "join lc_district d on p.province_id = d.province_id\n" +
            "join cf_default_delivery cf on d.district_id = cf.location_id\n" +
            "join bp_partner bp_ffm on cf.ffm_id = bp_ffm.partner_id and bp_ffm.partner_type = " + Const.TYPE_FFM + "\n" +
            "join bp_partner bp_lm on cf.lastmile_id = bp_lm.partner_id and bp_lm.partner_type = " + Const.TYPE_LM + "\n" +
            "join bp_warehouse bp_wh on cf.warehouse_id = bp_wh.warehouse_id\n" +
            "order by p.province_id asc", nativeQuery = true)
    List<ResultQuery> getProvinceLogisticDataLevelTwo();
    @Query(value = "select\n" +
            "\tp.province_id as provinceId,\n" +
            "\tp.name as provinceName,\n" +
            "\tp.code as provinceCode,\n" +
            "\tbp_ffm.partner_id as ffmId,\n" +
            "\tbp_ffm.name as ffmName,\n" +
            "\tbp_ffm.shortname as ffmShortName,\n" +
            "\tbp_lm.partner_id as lmId,\n" +
            "\tbp_lm.name as lmName,\n" +
            "\tbp_lm.shortname as lmShortName,\n" +
            "\tbp_wh.warehouse_id as whId,\n" +
            "\tbp_wh.warehouse_name as whName,\n" +
            "\tbp_wh.warehouse_shortname as whShortName\n" +
            "\t\n" +
            "from lc_province p \n" +
            "join lc_district d on p.province_id = d.province_id\n" +
            "join lc_subdistrict sd on d.district_id = sd.district_id\n" +
            "join cf_default_delivery cf on sd.subdistrict_id = cf.location_id\n" +
            "join bp_partner bp_ffm on cf.ffm_id = bp_ffm.partner_id and bp_ffm.partner_type = " + Const.TYPE_FFM + "\n" +
            "join bp_partner bp_lm on cf.lastmile_id = bp_lm.partner_id and bp_lm.partner_type = " + Const.TYPE_LM + "\n" +
            "join bp_warehouse bp_wh on cf.warehouse_id = bp_wh.warehouse_id\n" +
            "order by p.province_id asc", nativeQuery = true)
    List<ResultQuery> getProvinceLogisticDataLevelThree();


    @Query(value = "select \n" +
            "\tp.province_id as provinceId,\n" +
            "\tp.name as provinceName,\n" +
            "\tbp_ffm.partner_id as ffmId,\n" +
            "\tbp_ffm.name as ffmName,\n" +
            "\tbp_lm.partner_id as lmId,\n" +
            "\tbp_lm.name as lmName,\n" +
            "\tbp_wh.warehouse_id as whId,\n" +
            "\tbp_wh.warehouse_name as whName\n" +
            "\t\n" +
            "from lc_province p \n" +
            "left join cf_default_delivery cf on p.province_id = cf.location_id \n" +
            "left join bp_partner bp_ffm on cf.ffm_id = bp_ffm.partner_id and bp_ffm.partner_type = " + Const.TYPE_FFM + "\n" +
            "left join bp_partner bp_lm on cf.lastmile_id = bp_lm.partner_id and bp_lm.partner_type = " + Const.TYPE_LM + "\n" +
            "left join bp_warehouse bp_wh on cf.warehouse_id = bp_wh.warehouse_id\n" +
            "order by p.province_id asc\n", nativeQuery = true)
    List<ResultQuery> exportProvinceExcel();

    @Modifying
    @Transactional
    @Query(value = "update cf_default_delivery\n" +
            "set ffm_id = :#{#deliveryDTO.fulfillmentId},\n" +
            "\tlastmile_id = :#{#deliveryDTO.lastMileId},\n" +
            "\twarehouse_id = :#{#deliveryDTO.warehouseId}\n" +
            "where location_id = :locationId", nativeQuery = true)
    void updateLevelOne(Long locationId, DeliveryDTO deliveryDTO);
    @Modifying
    @Transactional
    @Query(value = "update cf_default_delivery\n" +
            "set ffm_id = :#{#deliveryDTO.fulfillmentId},\n" +
            "\tlastmile_id = :#{#deliveryDTO.lastMileId},\n" +
            "\twarehouse_id = :#{#deliveryDTO.warehouseId}\n" +
            "where location_id in (\n" +
            "\tselect district_id from lc_district where province_id = :locationId \n" +
            ")", nativeQuery = true)
    void updateLevelTwo(Long locationId, DeliveryDTO deliveryDTO);
    @Modifying
    @Transactional
    @Query(value = "update cf_default_delivery\n" +
            "set ffm_id = :#{#deliveryDTO.fulfillmentId},\n" +
            "\tlastmile_id = :#{#deliveryDTO.lastMileId},\n" +
            "\twarehouse_id = :#{#deliveryDTO.warehouseId}\n" +
            "where location_id in (\n" +
            "\tselect sd.subdistrict_id from lc_subdistrict sd left join lc_district d on sd.district_id = d.district_id \n" +
            "\twhere d.province_id = :locationId\n" +
            ")", nativeQuery = true)
    void updateLevelThree(Long locationId, DeliveryDTO deliveryDTO);

    @Query(value = "select count(*) from lc_province p where p.province_id = :locationId", nativeQuery = true)
    Long checkValidProvince(@Param("locationId") Long locationId);
}
