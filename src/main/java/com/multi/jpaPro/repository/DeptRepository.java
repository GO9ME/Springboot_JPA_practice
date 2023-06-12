package com.multi.jpaPro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multi.jpaPro.domain.Dept;

public interface DeptRepository extends JpaRepository<Dept, String>{
	public List<Dept> findByDeptnoContaining(String deptname);

}
