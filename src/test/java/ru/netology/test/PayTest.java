package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.PaymentPage;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;

public class PayTest {
    StartPage startPage = new StartPage();
    PaymentPage paymentPage = new PaymentPage();


    @BeforeEach
    void setUp() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }


    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    void shouldBuyTourWithApprovedCard() {
        startPage.openPaymentPage();
        val user = DataHelper.getApprovedUser();
        paymentPage.putCardData(user);
        paymentPage.getSuccessNotification();
    }

    @Test
    void shouldBuyTourWithDeclinedCard(){
        startPage.openPaymentPage();
        val user = DataHelper.getDeclinedUser();
        paymentPage.putCardData(user);
        paymentPage.getErrorNotification();
    }

    @Test
    void shouldBuyTourWithRandomCard(){
        startPage.openPaymentPage();
        val card = DataHelper.getRandomNumber();
        paymentPage.putCardData(card);
        paymentPage.getErrorNotification();
    }



}


