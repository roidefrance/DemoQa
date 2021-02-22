package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {
    @BeforeAll
    static void setup(){
        Configuration.startMaximized=true;
    }
    @Test
    void FillFormCheckOutput() {
        String name = "Kirill";
        String email = "email@address.com";
        String addressc = "Citi 1";
        String addressp = "City 2";

        open("https://demoqa.com/text-box");
        $((".main-header")).shouldHave(text("Text Box"));
        $("#userName").val(name);
        $("#userEmail").val(email);
        $("#currentAddress").val(addressc);
        $("#permanentAddress").val(addressp);
        $("#submit").scrollTo();
        $("#submit").click();
        $("#output").shouldHave(text (name), text (addressc));

    }


}
