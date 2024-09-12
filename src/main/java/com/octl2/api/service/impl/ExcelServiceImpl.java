package com.octl2.api.service.impl;

import com.octl2.api.commons.exception.ErrorMessages;
import com.octl2.api.commons.exception.OctException;
import com.octl2.api.consts.Const;
import com.octl2.api.consts.ExcelConst;
import com.octl2.api.dto.ResultQuery;
import com.octl2.api.repository.DistrictRepository;
import com.octl2.api.repository.ProvinceRepository;
import com.octl2.api.repository.SubDistrictRepository;
import com.octl2.api.service.ExcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExcelServiceImpl implements ExcelService {
    @Value("${levelMapping}")
    private int levelMapping;
    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;
    private final SubDistrictRepository subDistrictRepository;


    @Override
    public Object exportExcelFile(HttpServletResponse response) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        createSheetAndHeader(workbook);
        response.setContentType(ExcelConst.CONTENT_TYPE);
        response.setHeader(ExcelConst.KEY, ExcelConst.VALUE);
        ServletOutputStream sos = response.getOutputStream();
        workbook.write(sos);
        workbook.close();
        sos.close();
        return HttpStatus.OK;
    }

    public void createSheetAndHeader(Workbook workbook) {
        //Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(ExcelConst.SHEET_NAME);
        Row row = sheet.createRow(0);
        switch (levelMapping) {
            case Const.LEVEL_ONE:
                log.info("check");
                for (int i = 0; i < ExcelConst.HEADER_TITLE_LEVEL_ONE.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(ExcelConst.HEADER_TITLE_LEVEL_ONE[i]);
                    sheet.setColumnWidth(i, 5000);
                }
                break;
            case Const.LEVEL_TWO:
                for (int i = 0; i < ExcelConst.HEADER_TITLE_LEVEL_TWO.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(ExcelConst.HEADER_TITLE_LEVEL_TWO[i]);
                    sheet.setColumnWidth(i, 5000);
                }
                break;
            case Const.LEVEL_THREE:
                for (int i = 0; i < ExcelConst.HEADER_TITLE_LEVEL_THREE.length; i++) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(ExcelConst.HEADER_TITLE_LEVEL_THREE[i]);
                    sheet.setColumnWidth(i, 5000);
                }
                break;
        }
        insertData(sheet);
    }


    public void insertData(Sheet sheet) {
        int index = 1;
        List<ResultQuery> resultQueries = null;
        switch (levelMapping) {
            case Const.LEVEL_ONE:
                resultQueries = provinceRepository.exportProvinceExcel();
                for (ResultQuery resultQuery : resultQueries) {
                    Row row = sheet.createRow(index);
                    row.createCell(0).setCellValue(resultQuery.getProvinceId());
                    row.createCell(1).setCellValue(resultQuery.getProvinceName());
                    row.createCell(2).setCellValue(resultQuery.getFfmId() != null ? (resultQuery.getFfmId()).toString() : "null");
                    row.createCell(3).setCellValue(resultQuery.getFfmName());
                    row.createCell(4).setCellValue(resultQuery.getLmId() != null ? (resultQuery.getLmId()).toString() : "null");
                    row.createCell(5).setCellValue(resultQuery.getLmName());
                    row.createCell(6).setCellValue(resultQuery.getWhId() != null ? (resultQuery.getWhId()).toString() : "null");
                    row.createCell(7).setCellValue(resultQuery.getWhName());
                    index++;
                }
                break;
            case Const.LEVEL_TWO:
                resultQueries = districtRepository.exportDistrictLogistic();
                for(ResultQuery resultQuery : resultQueries) {
                    Row row = sheet.createRow(index);
                    row.createCell(0).setCellValue(resultQuery.getProvinceId());
                    row.createCell(1).setCellValue(resultQuery.getProvinceName());
                    row.createCell(2).setCellValue(resultQuery.getDistrictId() != null ? (resultQuery.getDistrictId()).toString() : "null");
                    row.createCell(3).setCellValue(resultQuery.getDistrictName());
                    row.createCell(4).setCellValue(resultQuery.getFfmId() != null ? (resultQuery.getFfmId()).toString() : "null");
                    row.createCell(5).setCellValue(resultQuery.getFfmName());
                    row.createCell(6).setCellValue(resultQuery.getLmId() != null ? (resultQuery.getLmId()).toString() : "null");
                    row.createCell(7).setCellValue(resultQuery.getLmName());
                    row.createCell(8).setCellValue(resultQuery.getWhId() != null ? (resultQuery.getWhId()).toString() : "null");
                    row.createCell(9).setCellValue(resultQuery.getWhName());
                    index++;
                }
                break;
            case Const.LEVEL_THREE:
                resultQueries = subDistrictRepository.exportSubDistrictLogistic();
                for(ResultQuery resultQuery : resultQueries) {
                    Row row = sheet.createRow(index);
                    row.createCell(0).setCellValue(resultQuery.getProvinceId());
                    row.createCell(1).setCellValue(resultQuery.getProvinceName());
                    row.createCell(2).setCellValue(resultQuery.getDistrictId() != null ? (resultQuery.getDistrictId()).toString() : "null");
                    row.createCell(3).setCellValue(resultQuery.getDistrictName());
                    row.createCell(4).setCellValue(resultQuery.getSubDistrictId() != null ? (resultQuery.getSubDistrictId()).toString() : "null");
                    row.createCell(5).setCellValue(resultQuery.getSubDistrictName());
                    row.createCell(6).setCellValue(resultQuery.getFfmId() != null ? (resultQuery.getFfmId()).toString() : "null");
                    row.createCell(7).setCellValue(resultQuery.getFfmName());
                    row.createCell(8).setCellValue(resultQuery.getLmId() != null ? (resultQuery.getLmId()).toString() : "null");
                    row.createCell(9).setCellValue(resultQuery.getLmName());
                    row.createCell(10).setCellValue(resultQuery.getWhId() != null ? (resultQuery.getWhId()).toString() : "null");
                    row.createCell(11).setCellValue(resultQuery.getWhName());
                    index++;
                }
                break;
        }
    }
}


















