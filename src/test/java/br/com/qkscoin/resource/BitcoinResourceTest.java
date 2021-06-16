package br.com.qkscoin.resource;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
class BitcoinResourceTest {

	@Test
	void testarSeStatusCodeDaRequisicaoE200() {
		RestAssured
			.given().get("bitcoins").then().statusCode(200);
	}

}
