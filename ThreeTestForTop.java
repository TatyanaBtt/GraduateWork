import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith({SoftAssertsExtension.class})

public class ThreeTestForTop {
    @BeforeAll
    static void AnderTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://msk.top-academy.ru/";
        Configuration.pageLoadTimeout = 50000;
    }
    @BeforeEach
    public void beforeEach() {
        open("");
    }

    @Test
    void SchoolTest() {

        $(byText("Принять")).click();
        $("#academy_app > header > div > div.header__bottom > nav > ul > li:nth-child(7) > a").click();
        $(byText("Учись как удобно: очно, дистанционно или смотри уроки в записи")).shouldBe(exist);
        $(withText("Для взрослых")).shouldBe(exist);
        $(byText("Популярные статьи")).shouldBe(exist);
        $(byText("Начни бесплатно")).shouldBe(exist);
    }

    @Test
    void StartTest() {

        $(byText("Принять")).click();
        $("[id=form-call-popup]").click();
        $("#academy_app > header > div > div.header-content > form > div > div:nth-child(1) > input").setValue("Петр");
        $("#academy_app > header > div > div.header-content > form > div > div:nth-child(2) > input").setValue("Pet@gmail.com");
        $("#academy_app > header > div > div.header-content > form > div > div:nth-child(3) > input").setValue("999 888-77-77");
        $("#academy_app > header > div > div.header-content > form > div > div.gdpr-policy.gdpr-policy--header.gdpr-policy--show > label > span.gdpr-policy__checkbox-icon.checkbox-policy").click();
        $("[id=send_consultation]").click();
        sleep(10000);
    }

    @Test
    void SeeTest() {

        $(byText("Принять")).click();
        $(byText("Показать все (34)")).click();
        $(byText("Контакты")).shouldBe(exist);
        $(byText("Москва, м. Кутузовская, Кутузовский пр-кт, д 36 стр 2")).shouldBe(exist);
        $(byText("Филиалы в других городах")).shouldBe(exist);

    }

    }

