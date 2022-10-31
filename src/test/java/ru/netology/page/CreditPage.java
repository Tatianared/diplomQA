package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CreditPage {
    private SelenideElement heading = $$(".heading").find(Condition.exactText("Купить в крудит"));
    private SelenideElement cardNumberField = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthInputField = $("[placeholder='08']");
    private SelenideElement yearInputField = $("[placeholder='22']");
    private SelenideElement ownerField = $x("//*[text()='Владелец']/following-sibling::span/input");
    private SelenideElement cvcInputField = $("[placeholder='999']");
    private SelenideElement continueButton = $$("button").find(Condition.exactText("Продолжить"));
    private SelenideElement successNotification = $(withText("Операция одобрена Банком."));
    private SelenideElement errorNotification = $(withText("Ошибка! Банк отказал в проведении операции."));

    public void putCardData(DataHelper.Card card) {
        cardNumberField.setValue(card.getCardNumber());
        monthInputField.setValue(card.getMonth());
        yearInputField.setValue(card.getYear());
        ownerField.setValue(card.getOwner());
        cvcInputField.setValue(card.getCvc());
        continueButton.click();


    }
}