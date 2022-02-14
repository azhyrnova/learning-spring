package com.az.learningspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

	@Value("${test.phrase}")
	private String testPhrase;

	private static Logger LOG = LoggerFactory
			.getLogger(SpringBootConsoleApplication.class);
	private static final String SEPARATOR = "=======================";
	private static final String NEW_LINE = "\n";

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info(buildPhrase());
	}

	private String getDate(){
		return LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
	}

	private String buildPhrase(){
		StringBuilder sb = new StringBuilder();
		return (sb.append(NEW_LINE)
				.append(SEPARATOR)
				.append(NEW_LINE)
				.append(testPhrase)
				.append(getDate())
				.append(NEW_LINE)
				.append(SEPARATOR)
				.append(NEW_LINE).toString());
	}
}
