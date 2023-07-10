package com.loga.reportservice.controller;

import com.loga.reportservice.exception.ReportingErrorException;
import com.loga.reportservice.service.IReportingService;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(path = "/report-service")
public class ReportingController {

    @Autowired
    private IReportingService reportService;

    private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @GetMapping(value = "/{src}", produces = MediaType.APPLICATION_PDF_VALUE)
    public void report(HttpServletResponse response,
                       @PathVariable("src") String src) throws ReportingErrorException {
        String path = "report_"+src+"_"+sdf.format(new Date());
        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "inline; filename="+path+".pdf");

        try {
            OutputStream outputStream = response.getOutputStream();
            reportService.modelReport(src,outputStream);
        } catch (IOException e) {
            throw new ReportingErrorException(e);
        }
    }

    @GetMapping(value = "/{src}/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    public void reportById(HttpServletResponse response,
                           @PathVariable("src") String src,
                           @PathVariable("id") Long id) throws ReportingErrorException {

        String path = "report_"+src+"_"+id;

        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "inline; filename="+path+".pdf");

        try {
            OutputStream outputStream = response.getOutputStream();
            reportService.modelReportById(src, id, outputStream);
        } catch (IOException e) {
            throw new ReportingErrorException(e);
        }
    }

    @GetMapping(value = "/{src}/date", produces = MediaType.APPLICATION_PDF_VALUE)
    public void reportByDate(HttpServletResponse response,
                             @PathVariable("src") String src,
                             @RequestParam(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) throws ReportingErrorException {
        String path = "report_"+src+"_"+sdf.format(date);
        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "inline; filename="+path+".pdf");
        try {
            OutputStream outputStream = response.getOutputStream();
            reportService.modelReportByDate(src,date,outputStream);
        } catch (IOException e) {
            throw new ReportingErrorException(e);
        }
    }

    @GetMapping(value = "/{src}/period", produces = MediaType.APPLICATION_PDF_VALUE)
    public void reportBetweenDate(HttpServletResponse response,
                                  @PathVariable("src") String src,
                                  @RequestParam(name = "start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
                                  @RequestParam(name = "end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) throws ReportingErrorException {
        String path = "report_"+src+"_"+sdf.format(start)+"_"+sdf.format(end);
        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "inline; filename="+path+".pdf");
        try {
            OutputStream outputStream = response.getOutputStream();
            reportService.modelReportBetweenDate(src,start,end,outputStream);
        } catch (IOException e) {
            throw new ReportingErrorException(e);
        }
    }
}
