package com.multi.jpaPro.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multi.jpaPro.domain.BoardDTO;

@Repository
public interface SpringDataDeptRepository extends JpaRepository<BoardDTO,String>{

}
