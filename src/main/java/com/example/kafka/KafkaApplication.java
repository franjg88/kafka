package com.example.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.core.KafkaTemplate;

import com.example.producer.ConfigProperties;
import com.example.producer.KafkaConfiguration;

@SpringBootApplication
@Import({ KafkaConfiguration.class, ConfigProperties.class })
public class KafkaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(KafkaApplication.class)
			.web(false)
			.run(args);
		TestBean testBean = context.getBean(TestBean.class);
		testBean.send("foo");
	}

	@Bean
	public TestBean test() {
		return new TestBean();
	}

	public static class TestBean {

		@Autowired
		private ConfigProperties configProperties;

		@Autowired
		private KafkaTemplate<String, String> template;

		public void send(String foo) {
			this.template.send(this.configProperties.getTopic(), foo);
		}

	}
}
