package kr.co.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import chapter12.MemberMapper;
import chapter12.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {chapter12.MvcConfig.class})
@WebAppConfiguration
public class TestMember {
	@Autowired
	MemberMapper mapper;
	
	@Test
	public void loginTest() {
		MemberVO vo = new MemberVO();
		vo.setId("test");
		vo.setPwd("test12345");
		MemberVO login = mapper.login(vo);
		assertNotNull(login);
		System.out.println(login);
	}
	
	
}
