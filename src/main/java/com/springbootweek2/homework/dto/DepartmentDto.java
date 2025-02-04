package com.springbootweek2.homework.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbootweek2.homework.annotations.HandlePrime;
import com.springbootweek2.homework.annotations.PasswordValidation;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;


public class DepartmentDto {

    private long id;

    @NotNull(message = "The name not should be null")
    @Size(min = 3, max = 10, message = "The title should having minimum 3 letters or maximum 10 letters")
    private String title;

    @AssertTrue(message = "The Department Should be Active")
    @JsonProperty("isActive")
    private Boolean active;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @PastOrPresent(message = "The date should either present or from the past")
    private LocalDate createdAt;

    @Min(value = 10)
    @Max(value = 500)
    private Integer departmentStaff;

    @Null(message = "Don't enter anything")
    private String departmentHead;

    @DecimalMin(value = "105345.23")
    @DecimalMax(value = "10000345.43")
    @Digits(integer = 8, fraction = 3)
    private Double totalSalary;

    @NegativeOrZero(message = "The loss should be in negative or zero")
    private Double departmentLoss;
    @PositiveOrZero(message = "The Profit should be zero or positive")
    private Double departmentProfit;

    @Range(min = 5, max = 50)
    @HandlePrime
    private Integer totalDepartments;

    @Pattern(regexp = "^[A-Z]{3}-\\d{4}$", message = "Department Code must follow the pattern: ABC-1234")
    private String departmentCode;


    @URL(message = "The Url must be valid")
    private String url;

    @PasswordValidation
    private String password;


    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getDepartmentStaff() {
        return departmentStaff;
    }

    public void setDepartmentStaff(Integer departmentStaff) {
        this.departmentStaff = departmentStaff;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public Double getDepartmentLoss() {
        return departmentLoss;
    }

    public void setDepartmentLoss(Double departmentLoss) {
        this.departmentLoss = departmentLoss;
    }

    public Double getDepartmentProfit() {
        return departmentProfit;
    }

    public void setDepartmentProfit(Double departmentProfit) {
        this.departmentProfit = departmentProfit;
    }

    public Integer getTotalDepartments() {
        return totalDepartments;
    }

    public void setTotalDepartments(Integer totalDepartments) {
        this.totalDepartments = totalDepartments;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
