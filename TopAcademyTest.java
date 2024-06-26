import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.SoftAssertsExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

@ExtendWith({SoftAssertsExtension.class})

public class TopAcademyTest {
    @BeforeAll
    static void Test() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void top_academy_menu() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 120_000;


        open("https://msk.top-academy.ru");
        //sleep(10_000);
        if ($(".demo-popup__cancel").exists()) {
            $(".demo-popup__cancel").click();
        }

        sleep(1_000);
        if ($(".cookies-confirm").exists()) {
            $(".cookies-confirm").click();
        }
//Пункт основного меню можно найти просто по тексту
        $(withText("Об Академии")).hover();
        $(byXpath("//button[contains(text(),'Об Академии')]/parent::*//span[contains(text(),'Центр карьеры')]")).click();
        $("#academy_app > main > section.career-center__banner.banner-top.banner-top--career-center > div > div > a.call-to-action__btn.btn.btn-register-short.form-popup.btn-animate.career-center__btn").click();
        $("#form_construct_main > div.popup-form__set-inputs > input.popup-form__input.input-fio.hide-field").setValue("Сытник Иван Геннадиевич");
        $("#form_construct_main > div.popup-form__set-inputs > input.popup-form__input.input-phone.hide-field").setValue("+79999032836");
        $("#form_construct_main > div.popup-form__set-inputs > input.popup-form__input.input-email.hide-field").setValue("vanchester123456789qwer@gmail.com");
        $("#form_construct_main > div.popup-form__set-inputs > textarea").setValue("Добрый день, подскажите пожалуйста стоимость курса специальности тестировщика");
        $("#form_construct_main > div.gdpr-policy.gdpr-policy--popup-form > label > span.gdpr-policy__checkbox-icon.checkbox-policy").click();
        $("#form_construct_main > button").click();
        sleep(5_000);
    }

    @Test
    void Academy2() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 120_000;


        open("https://msk.top-academy.ru");
        sleep(10_000);
        if ($(".demo-popup__cancel").exists()) {
            $(".demo-popup__cancel").click();
        }

        sleep(1_000);
        if ($(".cookies-confirm").exists()) {
            $(".cookies-confirm").click();
            $(byText("Контакты")).click();
            $("#academy_app > script:nth-child(12)").shouldBe(exist);

        }
    }

    @Test
    void Academy3() {
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadTimeout = 120_000;


        open("https://msk.top-academy.ru");
        sleep(10_000);
        if ($(".demo-popup__cancel").exists()) {
            $(".demo-popup__cancel").click();
        }

        sleep(1_000);
        if ($(".cookies-confirm").exists()) {
            $(".cookies-confirm").click();
        }
        $("#academy_app > main > section:nth-child(4) > div > a").click();
        $("#submit_form > div > form > input:nth-child(5)").setValue("Сытник Иван Геннадиевич");
        $("#submit_form > div > form > input.application-contact-form-input.phone-mask.input-phone.hide-field").setValue("+79999032836");
        $("#submit_form > div > form > input:nth-child(8)").setValue("vanchester123456789qwer@gmail.com");
        $("#submit_form > div > form > div.gdpr-policy.gdpr-policy--show.gdpr-policy--form > label > span.gdpr-policy__checkbox-text").click();
        $("#submit_form > div > form > button").click();
    }
}