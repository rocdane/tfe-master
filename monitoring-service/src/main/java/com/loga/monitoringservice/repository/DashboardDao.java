package com.loga.monitoringservice.repository;

import com.loga.monitoringservice.app.factory.*;
import com.loga.monitoringservice.vendor.io.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.tools.Diagnostic;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DashboardDao {

    public Stats getStats() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("select (select count(fd.dossier_pk) from fact_dossiers fd) as dossiers,");
        query.append("(select count(fdi.pk_diagnosis) from fact_diagnosis fdi) as diagnosis,");
        query.append("(select count(ft.pk_task) from fact_tasks ft) as tasks,");
        query.append("(select count(fsp.pk_spare) from fact_spares fsp) as spares;");

        ResultSet rs = Database.getConnection().createStatement().executeQuery(query.toString());
        if(rs.next()){
            return new Stats(rs.getInt("dossiers"),
                    rs.getInt("diagnosis"),
                    rs.getInt("spares"),
                    rs.getInt("tasks"));
        }else {
            return null;
        }
    }

    public List<Diagnosis> getDiagnosis() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("select distinct fd.period,");
        query.append("(select count(pk_diagnosis) from fact_diagnosis fd2 where fd.diagnosis=fd2.diagnosis group by fd.period) as diagnoses ");
        query.append("from fact_diagnosis fd;");

        ResultSet rs = Database.getConnection().createStatement().executeQuery(query.toString());

        List<Diagnosis> diagnoses = new ArrayList<>();

        while (rs.next()){
            diagnoses.add(new Diagnosis(rs.getInt("diagnoses"),
                    rs.getTimestamp("period")));
        }
        return diagnoses;
    }

    public List<Spares> getSpares() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("select distinct s.period,");
        query.append("(select count(s2.pk_spare) from fact_spares s2 where s.reference = s2.reference group by s.period) as spares,");
        query.append("(select sum(s3.amount) from fact_spares s3 where s.reference = s3.reference group by s.period) as amount ");
        query.append("from fact_spares s;");

        ResultSet rs = Database.getConnection().createStatement().executeQuery(query.toString());

        List<Spares> spares = new ArrayList<>();

        while (rs.next()){
            spares.add(new Spares(rs.getInt("spares"),
                    rs.getInt("amount"),
                    rs.getTimestamp("period")));
        }

        return spares;
    }

    public List<Tasks> getTasks() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append(" select distinct s.period,");
        query.append("(select count(s2.pk_task) from fact_tasks s2 where s.reference = s2.reference group by s.period) as tasks,");
        query.append("(select sum(s3.cost) from fact_tasks s3 where s.reference = s3.reference group by s.period) as amount ");
        query.append("from fact_tasks s;");

        ResultSet rs = Database.getConnection().createStatement().executeQuery(query.toString());

        List<Tasks> tasks = new ArrayList<>();

        while (rs.next()){
            tasks.add(new Tasks(rs.getInt("tasks"),rs.getInt("amount"),rs.getTimestamp("period")));
        }

        return tasks;
    }

    public List<Diagnoses> getDiagnoses() throws SQLException {
        StringBuilder query = new StringBuilder();
        query.append("select distinct dysfunction, maintenance from fact_diagnosis;");

        ResultSet rs = Database.getConnection().createStatement().executeQuery(query.toString());

        List<Diagnoses> diagnoses = new ArrayList<>();

        while (rs.next()){
            diagnoses.add(new Diagnoses(rs.getString("dysfunction"),rs.getString("maintenance")));
        }

        return diagnoses;
    }
}
