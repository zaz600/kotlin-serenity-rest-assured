package tests

import net.serenitybdd.junit.runners.SerenityRunner
import net.thucydides.core.annotations.Steps
import org.junit.Test
import org.junit.runner.RunWith
import steps.CountriesSearchSteps

@RunWith(SerenityRunner::class)
class CountriesSearchTests {

    @Steps
    lateinit var countriesSearchSteps: CountriesSearchSteps

    @Test
    fun verifyThatWeCanFindRussiaUsingTheCodeRU() {
        countriesSearchSteps.searchCountryByCode("RU")
        countriesSearchSteps.searchIsExecutedSuccesfully()
        countriesSearchSteps.iShouldFindCountry("Russian Federation")
        countriesSearchSteps.alfa3CodeIsEqual("RUS")
    }

    @Test
    fun verifyThatWeCanFindIndiaCountryUsingTheCodeIN() {
        countriesSearchSteps.searchCountryByCode("IN")
        countriesSearchSteps.searchIsExecutedSuccesfully()
        countriesSearchSteps.iShouldFindCountry("India")
    }

    @Test
    fun verifyThatWeCanFindBrazilCountryUsingTheCodeBR() {
        countriesSearchSteps.searchCountryByCode("BR")
        countriesSearchSteps.searchIsExecutedSuccesfully()
        countriesSearchSteps.iShouldFindCountry("Brazil")
    }
}