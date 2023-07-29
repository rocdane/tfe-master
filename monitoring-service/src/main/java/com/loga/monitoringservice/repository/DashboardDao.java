package com.loga.monitoringservice.repository;

import com.loga.monitoringservice.app.factory.Diagnosis;
import com.loga.monitoringservice.app.factory.Spares;
import com.loga.monitoringservice.app.factory.Stats;
import com.loga.monitoringservice.app.factory.Tasks;
import com.loga.monitoringservice.vendor.io.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DashboardDao {

    public Stats getStats() throws SQLException {
        StringBuilder stmt = new StringBuilder();
        stmt.append("select (select count(fd.dossier_pk) from fact_dossiers fd) as dossiers,");
        stmt.append("(select count(fdi.pk_diagnosis) from fact_diagnosis fdi) as diagnosis,");
        stmt.append("(select count(ft.pk_task) from fact_tasks ft) as tasks,");
        stmt.append("(select count(fsp.pk_spare) from fact_spares fsp) as spares;");

        ResultSet rs = Database.getConnection().createStatement().executeQuery(stmt.toString());
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
        StringBuilder stmt = new StringBuilder();
        stmt.append("select distinct fd.period,");
        stmt.append("(select count(pk_diagnosis) from fact_diagnosis fd2 where fd.diagnosis=fd2.diagnosis group by fd.period) as diagnoses ");
        stmt.append("from fact_diagnosis fd;");

        ResultSet rs = Database.getConnection().createStatement().executeQuery(stmt.toString());

        List<Diagnosis> diagnoses = new ArrayList<>();

        while (rs.next()){
            diagnoses.add(new Diagnosis(rs.getInt("diagnoses"),
                    rs.getDate("period")));
        }
        return diagnoses;
    }

    public List<Spares> getSpares() throws SQLException {
        StringBuilder stmt = new StringBuilder();
        stmt.append("select distinct s.period,");
        stmt.append("(select count(s2.pk_spare) from fact_spares s2 where s.reference = s2.reference group by s.period) as spares,");
        stmt.append("(select sum(s3.amount) from fact_spares s3 where s.reference = s3.reference group by s.period) as amount ");
        stmt.append("from fact_spares s;");

        ResultSet rs = Database.getConnection().createStatement().executeQuery(stmt.toString());

        List<Spares> spares = new ArrayList<>();

        while (rs.next()){
            spares.add(new Spares(rs.getInt("spares"),rs.getFloat("amount"),rs.getDate("period")));
        }

        return spares;
    }

    public List<Tasks> getTasks() throws SQLException {
        StringBuilder stmt = new StringBuilder();
        stmt.append(" select distinct s.period,");
        stmt.append("(select count(s2.pk_task) from fact_tasks s2 where s.reference = s2.reference group by s.period) as tasks,");
        stmt.append("(select sum(s3.cost) from fact_tasks s3 where s.reference = s3.reference group by s.period) as amount ");
        stmt.append("from fact_tasks s;");

        ResultSet rs = Database.getConnection().createStatement().executeQuery(stmt.toString());

        List<Tasks> tasks = new ArrayList<>();

        while (rs.next()){
            tasks.add(new Tasks(rs.getInt("tasks"),rs.getFloat("amount"),rs.getDate("period")));
        }

        return tasks;
    }
}
