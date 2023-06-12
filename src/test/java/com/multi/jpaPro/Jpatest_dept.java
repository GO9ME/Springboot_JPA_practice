package com.multi.jpaPro;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.jpaPro.domain.Dept;
import com.multi.jpaPro.repository.DeptRepository;

//CLRUD처리 하는 메소드 정의하고 테스트홰보기
// - JPATest1 참고해서 작업 
// 부서 생성 
// 전체 부서 조회
// id로 조회
// 부서정보 수정 (부서명 변경)
// 생성한 부서 삭제하기 
@SpringBootTest
class Jpatest_dept {
	@Autowired
	DeptRepository repository;

	@Test
	@Disabled
	void insert() {
		repository.save(new Dept("d015", "1"));
	}

	@Test
	//@Disabled
	void selectALL() {
		List<Dept> list =  repository.findAll();
		//print(list);
		List<Dept> dept = repository.findByDeptnoContaining("dg");
		System.out.println(dept);
		//print(repository.findAllById(Lists.newArrayList("Yeona12331", "lee0idjj", "djdiwjs")));
	}

	void print(List<Dept> list) {
		for (Dept dept : list) {
			System.out.println(dept);
			
		}
	}
}
