package com.springbootweek2.homework.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "department")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    @JsonProperty("isActive")
    private Boolean active;


    private LocalDate createdAt;

    private Integer departmentStaff;

    private String departmentHead;

    private Double totalSalary;

    private Double departmentLoss;

    private Double departmentProfit;

    private Integer totalDepartments;

    private String departmentCode;

    private String url;

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
