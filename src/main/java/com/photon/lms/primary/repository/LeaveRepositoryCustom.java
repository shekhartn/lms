package com.photon.lms.primary.repository;

import com.photon.lms.primary.entity.Leave;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRepositoryCustom {
    List<Leave> findLeavesByEmployeeAndDateRange(Integer employeeCode, LocalDate fromDate, LocalDate toDate);
}
