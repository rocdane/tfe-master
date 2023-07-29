package com.loga.monitoringservice.service;

import com.loga.monitoringservice.app.factory.Dashboard;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

public interface IMonitoring {
    Dashboard load() throws SQLException;
    String etl() throws InterruptedException, IOException, ExecutionException, TimeoutException;
}
