package com.multi.jpaPro.springdata;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.multi.jpaPro.domain.BoardDTO;
import com.multi.jpaPro.domain.Dept;

@Service
public class SpringDataJPAServiceImpl implements SpringDataJPAService {
	SpringDataJPADAO dao;
	@Autowired
	public SpringDataJPAServiceImpl(SpringDataJPADAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public BoardDTO board_insert(BoardDTO board) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dept getDept(String deptno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String board_no) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(BoardDTO updatedata) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BoardDTO> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<BoardDTO> getBoard(String board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> findAll(int pageNo) {
		// TODO Auto-generated method stub
		return dao.findAll(pageNo);
	}

}
