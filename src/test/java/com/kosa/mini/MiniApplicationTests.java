package com.kosa.mini;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class MiniApplicationTests {

	@Value("${test}")
	private String test;

	@Test
	void keytest() {
		System.out.println("=============="+test);
	}





}
