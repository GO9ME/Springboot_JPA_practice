package com.multi.jpaPro.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String pass;
	private String name;
	private String deptno;
	private String grade;
	private int salary;
	
	//1대 다 관계
	@OneToMany(fetch= FetchType.EAGER)
	@JoinColumn(name="user_id") // join 하는 테이블의 컬럼명
	private List<PrivateInfo> privteinfos = new ArrayList<>();
	
	
}
