import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TopMain {
    public void cookies(){
        if ($((".cookies-confirm")).exists()) {
            $((".cookies-confirm")).click();
        }
    }
    public void backCall (){
        $(".new_block_to_call.call-popup").click();
    }
    public void collForm(){
        $("#call_form").should(text("Хотите, \n" + "мы Вам перезвоним?"));
    }
    public void numberPhone(String strPhone){
        $("#phone_popup_call").should(exist);
        $("#phone_popup_call").click();
        $("#phone_popup_call").setValue(strPhone);
    }
    public void agreement(){
        $("div.gdpr-policy.gdpr-policy--call-form > label.gdpr-policy__label.gdpr-policy__label--call-form > span.gdpr-policy__checkbox-icon.checkbox-policy").click();
    }
    public void waitingCall(){
        $("div.popup-form__set-inputs.popup-form__set-inputs--form-call > button.popup-form__btn").click();
    }
    public void message_wait_for_call(){
        $(".message-title").should(exist);
        $(".message-title").should(text("Ожидайте звонка"));
    }
    public void helpWithCourses(){
        $(withText("Нужна помощь с курсами")).click();
    }
    public void form_help_you_choose(){
        $(".application-block").should(text("Поможем в выборе!"));
    }
    public void enterName(String strName){
        ElementsCollection ec;
        ec = $$(".application-contact-form-input");
        SelenideElement se;
        se = ec.get(0);
        se.setValue(strName);
    }
    public void enterPhone(String strPhone){
        ElementsCollection ec;
        ec = $$(".application-contact-form-input");
        SelenideElement se;
        se = ec.get(1);
        se.setValue(strPhone);
    }
    public void enterEmail(String strEmail){
        ElementsCollection ec;
        ec = $$(".application-contact-form-input");
        SelenideElement se;
        se = ec.get(2);
        se.setValue(strEmail);
    }
    public void send(){
        $("form.application-input-container.form_consultation > button.btn-application").click();
    }
    public void message_thank_you(){
        $(".message-title").should(text("Спасибо за запрос."));
    }
    public void forChildren1(){
        $("div.flex-row > a[href=\"/IT_courses_for_children\"]").click();
    }
    public void forChildren2(){
        $("div.btn-course-choice > a[href=\"/IT_courses_for_children\"]").click();
    }
    public void text1(){
        $(withText("Программирование для детей и подростков")).should(exist);
    }
    public void text2(){
        $(withText("Детские курсы и школа")).should(exist);
    }
    public void text3(){
        $(withText("Частная школа")).should(exist);
    }
}
