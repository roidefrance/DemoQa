import com.codeborne.selenide.commands.ScrollTo;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

class demoqaTests {


    @Test
    void siteExists() {

        open("https://demoqa.com/");
        $("html").shouldHave(text("Forms"));
        $(byText("Forms")).scrollTo();
        $(byText("Forms")).click();
        $(byText("Practice Form")).click();
        $(byText("Student Registration Form")).scrollTo();
        $("#firstName").setValue("Kirill");
        $("#lastName").setValue("Melnikov");
        $("#userEmail").setValue("xyz@aaa.net");
        $(byText("Male")).click();
        $("#userNumber").setValue("9515082525");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1985");
        $(".react-datepicker__day--030").click();
        $("#subjectsInput").val("M");
        $(".subjects-auto-complete__menu-list").$(byText("Maths")).click();
        $("#subjectsInput").val("A");
        $(".subjects-auto-complete__menu-list").$(byText("Arts")).click();
        $(byText("Music")).click();
        $("#currentAddress").setValue("elm st");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $("html").shouldHave(text("Thanks for submitting the form"));



    }

}