package com.octl2.api.dto;

public interface ResultQuery {
    //province
    Integer getProvinceId();
    String getProvinceCode();
    String getProvinceName();

    //district
    Integer getDistrictId();
    String getDistrictCode();
    String getDistrictName();

    //sub-district
    Integer getSubDistrictId();
    String getSubDistrictCode();
    String getSubDistrictName();

    //partner ffm
    Integer getFfmId();
    String getFfmName();
    String getFfmShortName();

    //partner lm
    Integer getLmId();
    String getLmName();
    String getLmShortName();

    //warehouse
    Integer getWhId();
    String getWhName();
    String getWhShortName();

}
