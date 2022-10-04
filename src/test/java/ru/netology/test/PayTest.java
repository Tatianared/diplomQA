package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;

import lombok.val;
import org.junit.jupiter.api.AfterAll;
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


    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }


    @Test
    void shouldBuyTourWithDebetApprovedCard() {
        startPage.openPaymentPage();
        val cardNumber = DataHelper.getApprovedCardNumber();
        val month = DataHelper.getRandomMonth();
        val year = DataHelper.getRandomYear();
        val owner = DataHelper.getRandomOwner();
        val cvc = DataHelper.getRandomCVC();
        paymentPage.putCardData(cardNumber,month,year,owner,cvc);
        DataHelper.getApprovedCardStatus();

    }
}
