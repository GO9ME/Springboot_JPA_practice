package com.multi.jpaPro.exam;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.multi.jpaPro.domain.BoardDTO;
import com.multi.jpaPro.domain.Dept;

@Repository
public class JPADAOImpl implements JPADAO {
	private EntityManager entityManager;

	@Autowired
	public JPADAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public BoardDTO board_insert(BoardDTO board) {
		// TODO Auto-generated method stub
		entityManager.persist(board);
		return null;
	}

	@Override
	public Dept getDept(String deptno) {
		// TODO Auto-generated method stub
		Dept dept = entityManager.find(Dept.class, deptno);
		return dept;
	}

	@Override
	public void update(BoardDTO updatedata) {
		// 업데이트와 삭제는 조회를 먼저하고 수정과 삭제를 한다.
		System.out.println("===========updatedata==========");
		System.out.println(updatedata);
		BoardDTO data = entityManager.find(BoardDTO.class, updatedata.getBoardNo());
		data.setTitle(updatedata.getTitle());
		data.setContent(updatedata.getContent());
		System.out.println("===========data==========");
		System.out.println(data);
		entityManager.merge(data);

	}

	@Override
	public List<BoardDTO> findAll() {
		// TODO Auto-generated method stub
		String jpql = "select board from BoardDTO as board";
		List<BoardDTO> list = entityManager.createQuery(jpql).getResultList();
		return list;
	}

	@Override
	public void delete(String board_no) {
		// TODO Auto-generated method stub
		// 삭제할 엔티티를 조회
		BoardDTO data = entityManager.find(BoardDTO.class, board_no);
		// 조회한 엔티티 삭제
		entityManager.remove(data);
	}

}
