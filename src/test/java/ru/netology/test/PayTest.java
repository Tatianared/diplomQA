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

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;
import static java.time.Duration.ofSeconds;

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
    void shouldBuyTourWithDebetApprovedCard() {
        startPage.openPaymentPage();
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getMonth;
        val year = DataHelper.getYear;
        val owner = DataHelper.getOwner;
        val cvc = DataHelper.getCVC;
        paymentPage.putCardData(cardNumber, month, year, owner, cvc);
       DataHelper.getApprovedCardStatus();
    }
}


