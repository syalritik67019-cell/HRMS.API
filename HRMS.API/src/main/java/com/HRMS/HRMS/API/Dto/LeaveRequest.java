package com.HRMS.HRMS.API.Dto;

import com.HRMS.HRMS.API.Entity.LeaveType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class LeaveRequest {
    @NotNull(message = "Leave type is required")
    private LeaveType leavetype;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @NotBlank(message = "Reason is required")
    private String reason;

    @NotNull(message = "Employee ID is required")
    private Integer employeeId;

    public LeaveRequest() {
    }

    public LeaveType getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(LeaveType leavetype) {
        this.leavetype = leavetype;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
