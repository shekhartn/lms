package com.photon.lms.secondary.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "get_LMS_Employee_Leave_History_Search",
        procedureName = "get_LMS_Employee_Leave_History_Search",
        resultClasses = SearchHistoryVO.class
)
public class SearchHistoryVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Leave_Request_Id", columnDefinition = "")
    private String leaveRequestId;
    @Column(name = "From_date")
    private Date fromDate;
    @Column(name = "TO_Date")
    private Date toDate;
    @Column(name = "Days")
    private String numberDays;
    @Column(name = "Leave_Type_Id")
    private String leaveTypeId;
    @Column(name = "Code")
    private String leaveCode;
    @Column(name = "Type")
    private String leaveTypeName;
    @Column(name = "Contact_Number")
    private String contactNumber;
    @Column(name = "Reason")
    private String leaveReason;
    @Column(name = "Applied_On")
    private String appliedOnDate;
    @Column(name = "Approved_By")
    private String approvedById;
    @Column(name = "Approved_Date")
    private String approvedDate;
    @Column(name = "Status")
    private String leaveStatus;
    @Column(name = "Approved_Status")
    private String approvedStatus;
    @Column(name = "OD_Option_Code")
    private String odOptioncode;
    @Column(name = "Option_Name")
    private String odOptionName;
    @Column(name = "Is_Same_LeaveType")
    private Integer isSameLeaveType;
    @Column(name = "Is_Max_LeaveReq")
    private Integer isMaxLeaveReq;
    @Column(name = "Is_Client_Location")
    private Integer isClientLocation;
    @Column(name = "toggleHalf")
    private Integer toggleHalf;
    @Column(name = "Is_Full_Day")
    private Integer isFullDay;


}