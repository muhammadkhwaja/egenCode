package com.egen.pwtsensor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes=PwtsensorApplication.class)
@SpringBootTest
public class PwtsensorApplicationTests {

	@Test
	public void contextLoads() {
	}

}
