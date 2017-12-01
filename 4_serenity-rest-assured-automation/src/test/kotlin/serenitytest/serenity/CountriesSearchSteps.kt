package serenitytest.serenity

import io.restassured.response.Response
import net.serenitybdd.core.Serenity
import net.serenitybdd.rest.SerenityRest
import net.thucydides.core.annotations.Step

import org.hamcrest.Matchers.`is`

open class CountriesSearchSteps {
    private val ISO_CODE_SEARCH = "http://services.groupkt.com/country/get/iso2code/"
    private var response: Response? = null


    @Step
    open fun saveCode(countryCode: String) {
        Serenity.getCurrentSession().put("code", countryCode);
    }

    @Step
    open fun searchCountryByCode() {
        val code = Serenity.getCurrentSession().get("code")!!
        response = SerenityRest.`when`().get(ISO_CODE_SEARCH + code)
    }

    @Step
    open fun searchIsExecutedSuccessfully() {
        response!!.then().statusCode(200)
    }

    @Step
    open fun iShouldFindCountry(country: String) {
        response!!.then().body("RestResponse.result.name", `is`(country))
    }

    @Step
    open fun alfa3CodeIsEqual(code: String) {
        response!!.then().body("RestResponse.result.alpha3_code", `is`(code))
    }

}