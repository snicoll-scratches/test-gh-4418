package com.example;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

	@Service
	public static class Invoker {

		private final MyService myService;

		private final Random random;

		@Autowired
		public Invoker(MyService myService) {
			this.myService = myService;
			this.random = new Random();
		}

		@Scheduled(fixedRate = 500)
		public void doIt() {
			int i = random.nextInt(100);
			System.out.println("Foo: " + i);
			myService.getFoo(i);
		}
	}
}
