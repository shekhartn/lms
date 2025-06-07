package com.photon.lms.service;

import com.photon.lms.dto.LeaveRequest;
import com.photon.lms.entity.Leave;

import java.util.List;

public interface ILeaveService {
    List<Leave> getAllLeaves();

    List<Leave> getLeaveDetails(LeaveRequest leaveRequest);

    List<Leave> getLeaveDetailsByEmployeeCode(LeaveRequest leaveRequest);
}
