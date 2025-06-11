package com.photon.lms.primary.repository.impl;

import com.photon.lms.primary.entity.Leave;
import com.photon.lms.primary.repository.LeaveRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class LeaveRepositoryImpl implements LeaveRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Leave> findLeavesByEmployeeAndDateRange(Integer employeeCode, LocalDate fromDate, LocalDate toDate) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GetLeaveDetailsByEmployeeAndDateRange", Leave.class);
        query.registerStoredProcedureParameter("p_employee_code", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_from_date", Date.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("p_to_date", Date.class, ParameterMode.IN);

        query.setParameter("p_employee_code", employeeCode);
        query.setParameter("p_from_date", java.sql.Date.valueOf(fromDate));
        query.setParameter("p_to_date", java.sql.Date.valueOf(toDate));

        return query.getResultList();
    }
}
