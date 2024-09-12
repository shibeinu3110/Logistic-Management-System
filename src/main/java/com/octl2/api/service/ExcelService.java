package com.octl2.api.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ExcelService {
    Object exportExcelFile(HttpServletResponse response) throws IOException;
}
