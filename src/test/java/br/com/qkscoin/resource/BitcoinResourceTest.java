package br.com.qkscoin.resource;

import static io.restassured.RestAssured.when;

import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(BitcoinResource.class)
class BitcoinResourceTest {

	@Test
	void testarSeStatusCodeDaRequisicaoE200() {
		when().get().then().statusCode(200);
	}

}
