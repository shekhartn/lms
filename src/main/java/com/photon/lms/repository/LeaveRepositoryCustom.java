package com.photon.lms.repository;

import com.photon.lms.entity.Leave;

import java.time.LocalDate;
import java.util.List;

public interface LeaveRepositoryCustom {
    List<Leave> findLeavesByEmployeeAndDateRange(Integer employeeCode, LocalDate fromDate, LocalDate toDate);
}
