package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQaTest {
    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
        Configuration.timeout = 3000;
    }
    @Test
    void UserFormTest() {
        String firstName = "Paul",
        lastName = "White",
        email = "p.white@mail.eu",
        number = "4412345678",
        birthMonth = "May",
        birthYear = "1980",
        birthDay = "15",
        subject1 = "Maths",
        subject2 = "English",
        hobby1 = "Reading",
        hobby2 = "Music",
        file = "1.txt",
        currentAddress = "elm st",
        state = "NCR",
        city = "Delhi";

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").val(firstName);
        $("#lastName").val(lastName);
        $("#userEmail").val(email);
        $(byText("Male")).click();
        $("#userNumber").val(number);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__day--0" + birthDay).click();
        $("#subjectsInput").val(subject1);
        $(".subjects-auto-complete__menu-list").$(byText(subject1)).click();
        $("#subjectsInput").val(subject2);
        $(".subjects-auto-complete__menu-list").$(byText(subject2)).click();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#uploadPicture").uploadFromClasspath(file);
        $("#currentAddress").val(currentAddress);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();
        $(".modal-body").shouldHave(text(firstName), text(lastName), text(email));
    }
}
