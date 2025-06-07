package com.photon.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveRequest {
    private Integer employeeCode;
    private LocalDate fromDate;
    private LocalDate toDate;
}
