package me.himna.sb.member.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
	private static MediaType PLAIN_CONTENT_TYPE = new MediaType(
										MediaType.TEXT_PLAIN
										, Charset.forName("utf8"));

	@Test
	public void registerControllerTest() throws Exception {
		mockMvc.perform(get("/member/register"))
					.andExpect(status().isOk())
					.andExpect(content()
							.contentType(
									new MediaType(MediaType.TEXT_HTML
											, Charset.forName("utf8"))));
	}

//	@Test
//	public void test() throws Exception {
//		File register = new ClassPathResource("templates/fragments"
//				+ "/member/register.html").getFile();
//		String html = new String(Files.readAllBytes(register.toPath()));
//		
//		mockMvc.perform(get("/member/register"))
//					.andExpect(status().isOk())
//					.andExpect(content().string(html))
//					.andDo(print());
//	}
	
	@Test
	public void joinControllerTest() throws Exception {
		mockMvc.perform(post("/member/join"))
					.andExpect(status().isOk())
					.andDo(print())
					.andExpect(content().contentType(PLAIN_CONTENT_TYPE));
	}
	
	@Test
	public void idCheckControllerTest() throws Exception {
		mockMvc.perform(get("/member/idcheck"))
					.andExpect(status().isOk())
					.andDo(print())
					.andExpect(content().contentType(PLAIN_CONTENT_TYPE));
	}
}