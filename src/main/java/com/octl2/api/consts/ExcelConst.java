package com.octl2.api.consts;

public class ExcelConst {
    public static final String SHEET_NAME = "Logistic Information";
    public static final String[] HEADER_TITLE_LEVEL_ONE = {"Province ID", "Province Name", "Fulfillment ID", "Fulfillment Name", "Last Mile ID", "Last Mile Name", "Warehouse ID", "Warehouse Name"};
    public static final String[] HEADER_TITLE_LEVEL_TWO = {"Province ID", "Province Name", "District ID", "District Name", "Fulfillment ID", "Fulfillment Name", "Last Mile ID", "Last Mile Name", "Warehouse ID", "Warehouse Name"};
    public static final String[] HEADER_TITLE_LEVEL_THREE = {"Province ID", "Province Name", "District ID", "District Name", "Sub District ID", "Sub District Name", "Fulfillment ID", "Fulfillment Name", "Last Mile ID", "Last Mile Name", "Warehouse ID", "Warehouse Name"};
    public static final String CONTENT_TYPE = "application/octet-stream";
    public static final String KEY = "Content-Disposition";
    public static final String VALUE = "attachment;filename=logistic.xlsx";

}
