package com.loga.reportservice.service;

import com.loga.reportservice.exception.ReportingErrorException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public interface IReportingService {
    void modelReport(String report, OutputStream outputStream) throws ReportingErrorException;
    void modelReportById(String report, Long id, OutputStream outputStream) throws ReportingErrorException;
    void modelReportByDate(String report, Date date, OutputStream outputStream) throws ReportingErrorException;
    void modelReportBetweenDate(String report, Date start, Date end, OutputStream outputStream) throws ReportingErrorException;
}
