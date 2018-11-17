package me.himna.sb.member.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import me.himna.sb.member.domain.MemberDomain;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MemberDaoTest {

	@Mock
	MemberDao memberMapper;
	
	@Autowired
    private MockMvc mockMvc;
	
	public MemberDomain setMember() {
		MemberDomain member = new MemberDomain();
		member.setLogin_id("test");
		member.setLogin_password("0000");
		return member;
	}
	
	@Test
	public void getMemberTest() {
		
	}
	@Test
	public void memberJoinTest() throws Exception {
		MemberDomain member = new MemberDomain();
		member.setLogin_id("test");
		member.setLogin_password("0000");
		assertEquals(0, memberMapper.memberJoin(setMember()));
		//db에 안들어가! 0:통과 1:불통 
	}
	
	@Test
	public void getCntByLoginIdTest() throws Exception {
		//assertNotNull(memberMapper.getLoginId("whathappen")); // pass
		assertEquals(0,memberMapper.getCntByLoginId("admin")); // bb
	}
	
	
	@Test
	public void getMemberByIdTest() throws Exception {
		//assertNotNull(memberMapper.getMemberById(0));
		//assertNotNull("", memberMapper.getMemberById(1));
		//assertNotNull(memberMapper.getMemberById(0));

				
	}
}
