package com.ApiRest.ApiRest.repository;

import com.ApiRest.ApiRest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Long>{

}
