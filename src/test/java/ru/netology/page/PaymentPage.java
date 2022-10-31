package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class PaymentPage {
    private SelenideElement heading = $$(".heading").find(Condition.exactText("Купить"));
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthField = $("[placeholder='08']");
    private SelenideElement yearField = $("[placeholder='22']");
    private SelenideElement ownerField = $$(".input__top").find(Condition.exactText("Владелец"));
    private SelenideElement cvcField = $("[placeholder='999']");
    private SelenideElement continueButton = $$("button").find(Condition.exactText("Продолжить"));
    private SelenideElement successNotification = $(withText("Операция одобрена Банком."));
    private SelenideElement errorNotification = $(withText("Ошибка! Банк отказал в проведении операции."));


    public void putCardData(DataHelper.Card card) {
        cardNumberField.setValue(card.getCardNumber());
        monthField.setValue(card.getMonth());
        yearField.setValue(card.getYear());
        ownerField.setValue(card.getOwner());
        cvcField.setValue(card.getCvc());
        continueButton.click();
    }


    public void putCardData(String cardNumber, String month, String year, String owner, String cvc) {
    }
}

