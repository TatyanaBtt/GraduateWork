import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
@ExtendWith({SoftAssertsExtension.class})
public class GraduateWorkPO {
    @BeforeAll
    static void beforeAll() {
        Configuration.assertionMode = SOFT;
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://msk.top-academy.ru/";
        Configuration.pageLoadTimeout = 50000;
    }
    @BeforeEach
    public void beforeEach() {
        open("");
    }
    @Test
    void order_a_call_back(){
        TopMain tm = new TopMain();
        tm.cookies();
        tm.backCall();
        tm.collForm();
        tm.numberPhone("79851236588");
        tm.agreement();
        tm.waitingCall();
        tm.message_wait_for_call();
    }
    @Test
    void helpWithCourses(){
        TopMain tm = new TopMain();
        tm.cookies();
        tm.helpWithCourses();
        tm.form_help_you_choose();
        tm.enterName("Пользователь_1");
        tm.enterPhone("79031234887");
        tm.enterEmail("98512567@mail.ru");
        tm.send();
        tm.message_thank_you();
    }
    @Test
    void forChildren1(){
        TopMain tm = new TopMain();
        tm.cookies();
        tm.forChildren1();
        tm.text1();
        tm.text2();
        tm.text3();
    }
    @Test
    void forChildren2(){
        TopMain tm = new TopMain();
        tm.cookies();
        tm.forChildren2();
        tm.text1();
        tm.text2();
        tm.text3();
    }
}
