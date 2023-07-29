package com.loga.monitoringservice.service;

import com.loga.monitoringservice.app.factory.*;
import com.loga.monitoringservice.repository.DashboardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;

@Service
public class Monitoring implements IMonitoring {

    @Autowired
    private DashboardDao dashboardDao;

    private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

        @Override
        public void run() {
            new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .forEach(consumer);
        }
    }

    @Override
    @Scheduled(fixedRate = 5000)
    public void etl() throws InterruptedException, IOException{

        boolean isWindows = System.getProperty("os.name")
                .toLowerCase().startsWith("windows");

        ProcessBuilder builder = new ProcessBuilder();

        if (isWindows) {
            builder.command(System.getProperty("user.dir") + "\\etl\\tfe_master\\tfe_master_run.bat");
        } else {
            builder.command("sh","-c", "./etl/tfe_master/tfe_master_run.sh");
        }

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Process process = builder.start();

        StreamGobbler streamGobbler =
                new StreamGobbler(process.getInputStream(), System.out::println);

        executorService.submit(streamGobbler);

        int exitCode = process.waitFor();

        if (exitCode == 0) {
            System.out.println("ETL Success !");
        } else {
            System.out.println("ETL Failed !");
        }
    }

    public Dashboard load() throws SQLException {
        Stats stats = dashboardDao.getStats();
        List<Diagnosis> diagnoses = dashboardDao.getDiagnosis();
        List<Spares> spares = dashboardDao.getSpares();
        List<Tasks> tasks = dashboardDao.getTasks();
        return new Dashboard(stats,diagnoses,tasks,spares);
    }

    @Override
    public List<Diagnoses> diagnose() throws SQLException {
        return dashboardDao.getDiagnoses();
    }
}
