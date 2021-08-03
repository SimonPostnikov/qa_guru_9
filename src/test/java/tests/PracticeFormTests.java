package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Other";
    String phone = faker.numerify("##########");
    String dayOfBirth = "10";
    String monthOfBirth = "May";
    String yearOfBirth = "1988";
    String subjects = "Biology";
    String hobbies = "Music";
    String picture = "fox5.jpeg";
    String address = faker.address().fullAddress();
    String state = "NCR";
    String city = "Noida";

    @Test
    void successfulFillFormTest() {
        step("Open students registration form", () -> {
        registrationPage.openPage();});
        step("Fill students registration form", () -> {
        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .selectGender(gender)
                .typePhone(phone)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .typeSubjects(subjects)
                .typeHobbies(hobbies)
                .uploudFile(picture)
                .typeAdress(address)
                .selectState(state)
                .selectCity(city);
        registrationPage.clickButton();});
        step("Verify successful form submit", () -> {
        registrationPage.checkResultsTitle();
        registrationPage.checkResultsValue(firstName + " " + lastName)
                .checkResultsValue(email)
                .checkResultsValue(gender)
                .checkResultsValue(phone)
                .checkResultsValue(dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResultsValue(subjects)
                .checkResultsValue(hobbies)
                .checkResultsValue(picture)
                .checkResultsValue(address)
                .checkResultsValue(state + " " + city);});
            step("Open students registration form", () -> {
                open("https://demoqa.com/automation-practice-form");
                $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
            });
    }
}



