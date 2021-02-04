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

class DemoQaTests {

@BeforeAll
static void setup(){
    Configuration.startMaximized = true;
    Configuration.timeout = 6000;
}
    @Test
    void UserFormTest() {

        open("https://demoqa.com/automation-practice-form");
        $("#firstName").val("Kirill").shouldBe(visible);
        $("#lastName").val("Melnikov");
        $("#userEmail").val("xyz@aaa.net");
        $(byText("Male")).click();
        $("#userNumber").val("9515082525");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day--030").click();
        $("#subjectsInput").val("Math").pressEnter();
        $("#subjectsInput").val("Arts").pressEnter();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/1.txt"));
        $("#currentAddress").val("elm st");
        $("#state").scrollTo();
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-body").shouldHave(text("Kirill"), text("Melnikov"), text("xyz@aaa.net"));
        $("#closeLargeModal").scrollTo();
        $("#closeLargeModal").click();

    }

}