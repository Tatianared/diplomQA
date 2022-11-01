package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.CreditPage;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;


    public class CreditTest {
        StartPage startPage = new StartPage();
        CreditPage creditPage = new CreditPage();


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
            startPage.openCreditPage();
            val user = DataHelper.getApprovedUser();
            creditPage.putCardData(user);
            creditPage.getSuccessNotification();
        }

        @Test
        void shouldBuyTourWithDeclinedCard(){
            startPage.openPaymentPage();
            val user = DataHelper.getDeclinedUser();
            creditPage.putCardData(user);
            creditPage.getErrorNotification();
        }

        @Test
        void shouldBuyTourWithRandomCard(){
            startPage.openPaymentPage();
            val card = DataHelper.getRandomNumber();
            creditPage.putCardData(card);
            creditPage.getErrorNotification();
        }
    }
