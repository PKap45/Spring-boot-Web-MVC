package com.springbootweek2.homework.repository;

import com.springbootweek2.homework.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

}
