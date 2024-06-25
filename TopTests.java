import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;



import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;


@ExtendWith({SoftAssertsExtension.class})

public class TopTests {
    @BeforeAll
    static void AnderTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        baseUrl = "https://msk.top-academy.ru/";
    }

    @Test
    void oneTest() {
        open(baseUrl);
        sleep(50000);

        $(byText("Принять")).click();
        $("#menu__link.menu__link--hiddenMob.menu__link--active.font_lang_ru").click();
        $("#academy_app header div div.header__bottom nav ul li:nth-child(2) div.mobile-list-adult-education.accordeon ul li:nth-child(1) a").click();
        $(byText("обучения для взрослых")).shouldBe(visible);
        $(byText("Курс: Тестирование ПО (QA)")).click();
        $(byText("Забронируй обучение в июне и получи курс в подарок")).shouldBe(visible);
    }

    @Test
    void TwoTest() {
        open(baseUrl);
        sleep(50000);
        $(byText("Принять")).click();
        $(By.cssSelector(".main-nav__right-menu.right-menu")).click();
        $(byText("Абакан")).click();
        $(By.xpath("//a[@href='/contacts']")).click();
        $(byText("Абакан, ул Кирова, д 120 к 2 ")).shouldHave();

    }

    @Test
    void SeeTest() {

        open("https://msk.top-academy.ru/");
        sleep(10000);
        $(byText("Принять")).click();
        $(By.xpath("//a[@href=/graphic_designer']")).click();
        $(byText("Актуальность, профессионализм, забота")).shouldBe(exist);
        $(byText("Помощь в трудоустройстве ")).shouldBe(exist);


    }





}


