package com.octl2.api.repository;

import com.octl2.api.dto.ProvinceDTO;
import com.octl2.api.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Long> {

    @Query(value = "SELECT " +
            "   p.prv_id AS id " +
            "   , p.name " +
            "   , p.shortname " +
            "   , p.code " +
            "   , p.dcsr AS description " +
            " FROM lc_province AS p " +
            " WHERE " +
            "   p.prv_id = :id "
            , nativeQuery = true)
    ProvinceDTO getDtoById(@Param("id") long id);
}
