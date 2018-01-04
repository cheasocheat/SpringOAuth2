package com.mobiecode.mobieclient;

import com.mobiecode.core.CoreApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CoreApplication.class)
public class MobieClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobieClientApplication.class, args);
	}
}
