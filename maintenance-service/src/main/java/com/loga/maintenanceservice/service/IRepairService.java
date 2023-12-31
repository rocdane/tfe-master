package com.loga.maintenanceservice.service;

import com.loga.maintenanceservice.entity.Spare;
import com.loga.maintenanceservice.entity.Task;
import com.loga.maintenanceservice.entity.Repair;

import java.util.Date;
import java.util.List;

/**
 * Interface de l'application LoGa représentant les opérations du service Atelier.
 * @author rochdane sabi rocdanesabi@gmail.com
 * @version 2.1
 * @since 2.0
 */
public interface IRepairService {
    Repair createRepair(Repair repair);
    List<Repair> listRepair();
    List<Repair> listRepair(String reference);
    List<Repair> listRepair(Date debut, Date fin);
    Repair findRepair(Long repair);
    void editRepair(Repair repair, Long id);
    void orderRepair(Long id);
    void editTask(Task task, Long id);
    void editSpare(Spare spare, Long id);
    void deleteRepair(Long id);
    void deleteTask(Long id);
    void deleteSpare(Long id);
}
