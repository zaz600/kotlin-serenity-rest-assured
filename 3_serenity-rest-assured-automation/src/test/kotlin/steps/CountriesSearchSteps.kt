package steps

import io.restassured.response.Response
import net.serenitybdd.rest.SerenityRest
import net.thucydides.core.annotations.Step

import org.hamcrest.Matchers.`is`

open class CountriesSearchSteps {
    private val ISO_CODE_SEARCH = "http://services.groupkt.com/country/get/iso2code/"
    private var response: Response? = null

    @Step("I try to search the country by {0} code")
    open fun searchCountryByCode(code: String) {
        response = SerenityRest.`when`().get(ISO_CODE_SEARCH + code)
    }

    @Step("Search finished successfully")
    open fun searchIsExecutedSuccessfully() {
        response!!.then().statusCode(200)
    }

    @Step("Country name is {0}")
    open fun iShouldFindCountry(country: String) {
        response!!.then().body("RestResponse.result.name", `is`(country))
    }

    @Step
    open fun alfa3CodeIsEqual(code: String) {
        response!!.then().body("RestResponse.result.alpha3_code", `is`(code))
    }

}