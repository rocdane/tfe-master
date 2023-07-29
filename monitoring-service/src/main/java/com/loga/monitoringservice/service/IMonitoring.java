package com.loga.monitoringservice.service;

import com.loga.monitoringservice.app.factory.Dashboard;
import com.loga.monitoringservice.app.factory.Diagnoses;
import com.loga.monitoringservice.app.factory.Tasks;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface IMonitoring {
    Dashboard load() throws SQLException;
    void etl() throws InterruptedException, IOException, ExecutionException, TimeoutException;
    List<Diagnoses> diagnose() throws SQLException;
}
