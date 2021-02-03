package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.ScrollTo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class demoqaTests {

@BeforeAll
static void setup(){
    Configuration.startMaximized = true;
    Configuration.timeout = 60000;
}
    @Test
    void siteExists() {

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Kirill").shouldBe(visible);
        $("#lastName").setValue("Melnikov");
        $("#userEmail").setValue("xyz@aaa.net");
        $(byText("Male")).click();
        $("#userNumber").setValue("9515082525");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day--030").click();
        $("#subjectsInput").val("Math").pressEnter();
        $("#subjectsInput").val("Arts").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/java/tests/resources/1.txt"));
        $("#currentAddress").setValue("elm st");
        $("#state").scrollTo();
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-body").shouldHave(text("Thanks for submitting the form"), text("Kirill"));

    }

}