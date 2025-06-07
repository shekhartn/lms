package com.photon.lms.service.impl;

import com.photon.lms.dto.LeaveRequest;
import com.photon.lms.entity.Leave;
import com.photon.lms.repository.LeaveRepository;
import com.photon.lms.service.ILeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveService implements ILeaveService {
    @Autowired
    private LeaveRepository leaveRepository;
    @Override
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    @Override
    public List<Leave> getLeaveDetails(LeaveRequest leaveRequest) {
        return leaveRepository.findByEmployeeCodeAndFromDateAfter(leaveRequest.getEmployeeCode(), leaveRequest.getFromDate());
    }

    @Override
    public List<Leave> getLeaveDetailsByEmployeeCode(LeaveRequest leaveRequest) {
        return leaveRepository.findLeavesByEmployeeAndDateRange(leaveRequest.getEmployeeCode(), leaveRequest.getFromDate(), leaveRequest.getToDate());
    }
}
