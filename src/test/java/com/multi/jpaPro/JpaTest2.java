package com.multi.jpaPro;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.jpaPro.domain.PrivateInfo;
import com.multi.jpaPro.domain.User;
import com.multi.jpaPro.repository.PrivateInfoRepository;
import com.multi.jpaPro.repository.UserRepository;

@SpringBootTest
class JpaTest2 {
	@Autowired
	UserRepository userRepo;
	@Autowired
	PrivateInfoRepository privateinfoRepo;
	
	@Test
	void test() {
		User user = userRepo.findById("1").orElseThrow(()->new RuntimeException());
		List<PrivateInfo> list = user.getPrivteinfos();
		System.out.println(list);
	}
	
	

}
