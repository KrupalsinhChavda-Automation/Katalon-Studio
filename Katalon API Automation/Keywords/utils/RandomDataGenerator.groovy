package utils

import com.github.javafaker.Faker


public class RandomDataGenerator {
	static Faker faker = new Faker()

	static String randomEmail() {
		return faker.internet().emailAddress()
	}

	static String randomName() {
		return faker.name().fullName()
	}

	static String randomTitle() {
		return faker.book().title()
	}
}