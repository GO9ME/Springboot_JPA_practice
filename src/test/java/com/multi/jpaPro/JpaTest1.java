package com.multi.jpaPro;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.util.Supplier;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;

import com.multi.jpaPro.domain.Member;
import com.multi.jpaPro.repository.MemberRepositroy;

@SpringBootTest
class JpaTest1 {
	@Autowired
	MemberRepositroy repository;

	@Test
	@Disabled
	void insert() {
		repository.save(new Member("jpatest1", "1234", "제이피에이"));
	}

	@Test
	@Disabled
	void find_test() {
		/* List<Member> list = repository.findAll(); */
		/* print(list); */
		System.out.println("======================================");
		/* print(repository.findAll(Sort.by(Direction.ASC,"id"))); */

		//
		print(repository.findAllById(Lists.newArrayList("Yeona12331", "lee0idjj", "djdiwjs")));
	}

	@Test
	@Disabled
	void insertall() {
		Member member1 = new Member("jimin", "1234", "박지민");
		Member member2 = new Member("sugar", "1234", "민윤기");
		Member member3 = new Member("rm", "1234", "김남준");
		repository.saveAll(Lists.newArrayList(member1, member2, member3));
	}

	@Test
	@Transactional
	@Disabled
	void read_test() {
		Member member = repository.getOne("jimin");
		System.out.println(member);
	}

	@Test
	@Disabled
	void read_test2() {
		// Optional 클래스가 내부에서 갖고있는value값을 저장해서 NullPointerException이 발생하지 않도록 처리
		Optional<Member> member = repository.findById("suga");
		System.out.println(member);

		long count = repository.count();
		System.out.println("레코드 개수 : " + count);

		boolean state = repository.existsById("rm");
		System.out.println("실행 결과  => " + state);
	}

	@Test
	@Disabled
	void pagetest() {
		Page<Member> list = repository.findAll(PageRequest.of(0, 5, Direction.DESC, "id"));
		System.out.println("memberlist : " + list);
		System.out.println("total(전체 레코드수) : " + list.getTotalElements());
		System.out.println("totalPage(페이지 수) : " + list.getTotalPages());
		System.out.println("현재 조회한 레코드수 : " + list.getNumberOfElements());
		System.out.println("정렬 : " + list.getSort());
		System.out.println("한페이지의 사이즈 : " + list.getSize());
		print(list.getContent());
	}

	@Test
	@Disabled
	void update_test() {
		repository.save(new Member("jin", "1234", "김석진"));
		Supplier<RuntimeException> obj = new Supplier<RuntimeException>() {
			
			@Override
			public RuntimeException get() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		//Optional 로 wrapping되어 있는 Member객체를 직접 꺼내기 위해 이 객체가 없는 경우 null을 발생시키겠다고 명시
		Member member = repository.findById("jin").orElseThrow(()-> new RuntimeException());
		System.out.println(member);
		
		// save 메소드 객체를 새로 만들어서 호출되는 경우는 insert문이 만들어지고
		// 조회한 객체의 setter메소드를 호출해서 값을 세팅하고 save를 호출하는 경우 update문이 자동으로 만들어짐
		member.setSsn("777111111102666");
		repository.save(member);
		
	}

	@Test
	@Disabled
	void delete_test() {
		//repository.deleteAll();
//		repository.deleteById("jpatest1");
		//repository.deleteAllById(Lists.newArrayList("rm","jin"));
		//repository.deleteAllByIdInBatch(Lists.newArrayList("jimin","suga"));
	}
	@Test
	void mymethod() throws ParseException {
//		print(repository.findByPositionLike("과장"));ㅕㅅ
		print(repository.findByStartdayGreaterThanEqual(new SimpleDateFormat("yyyy-MM-dd").parse("2010-10-2")));
	}
	
	void print(List<Member> list) {
		for (Member member : list) {
			System.out.println(member);
		}
	}

}
