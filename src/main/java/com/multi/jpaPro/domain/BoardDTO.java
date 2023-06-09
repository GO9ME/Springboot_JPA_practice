package com.multi.jpaPro.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Setter
@Getter
@ToString*/
@Data
//전체 멤버변수를 매개변수로 하는 생성자 정의
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tbboard")
public class BoardDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String boardNo;
	String id;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	//@UpdateTimestamp 0
	@CreationTimestamp
	Date write_date;
	String title;
	String content;
	
	@Column(name="category")
	String category;

}
