import net.thucydides.core.annotations.Steps
import org.jbehave.core.annotations.Given
import org.jbehave.core.annotations.Then
import org.jbehave.core.annotations.When
import serenitytest.serenity.CountriesSearchSteps

open class CountrySearchStepsDefinitions {

    @Steps
    lateinit var countriesSearchSteps: CountriesSearchSteps

    @Given("У меня есть код страны \$countryCode")
    open fun givenIHaveAnCountryCode(countryCode: String) {
        countriesSearchSteps.saveCode(countryCode)
    }

    @When("Я выполняю поиск страны с помощью кода")
    open fun whenISearchCode() {
        countriesSearchSteps.searchCountryByCode()
    }

    @Then("Поиск должен завершиться успешно")
    open fun thenSearchExecutedSuccess() {
        countriesSearchSteps.searchIsExecutedSuccessfully()
    }

    @Then("Я должен найти страну \$countryName")
    open fun thenIShouldFindCountry(countryName: String) {
        countriesSearchSteps.iShouldFindCountry(countryName)
    }

}