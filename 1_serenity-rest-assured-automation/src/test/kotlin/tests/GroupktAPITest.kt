package tests

import io.restassured.RestAssured
import net.serenitybdd.junit.runners.SerenityRunner
import org.junit.Test

import org.hamcrest.Matchers.`is`
import org.junit.runner.RunWith

const val ROOT_API_URL = "http://services.groupkt.com"


@RunWith(SerenityRunner::class)
class CountriesSearchTests {

    @Test
    fun verifyThatWeCanFindRussiaUsingTheCodeRU() {
        RestAssured.`when`().get("$ROOT_API_URL/country/get/iso2code/RU")
                .then().assertThat().statusCode(200)
                .and().body("RestResponse.result.name", `is`("Russian Federation"))
    }

    @Test
    fun verifyThatWeCanFindIndiaUsingTheCodeIN() {
        RestAssured.`when`().get("$ROOT_API_URL/country/get/iso2code/IN")
                .then().assertThat().statusCode(200)
                .and().body("RestResponse.result.name", `is`("India"))
    }

    @Test
    fun verifyThatWeCanFindUSAUsingTheCodeUS() {
        RestAssured.`when`().get("$ROOT_API_URL/country/get/iso2code/US")
                .then().assertThat().statusCode(200)
                .and().body("RestResponse.result.name", `is`("United States of America"))
    }

}