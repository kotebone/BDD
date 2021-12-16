package ru.netology.page;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import lombok.val;

public class DashBoardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item");
    private SelenideElement redButton1 = $("[data-test-id = '92df3f1c-a033-48e6-8390-206f6b1f56c0'] [class=button__text]");
    private SelenideElement redButton2 = $("[data-test-id= '0f3f5c2a-249e-4c3d-8287-09f7a039391d'] [class=button__text]");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashBoardPage() {
        heading.shouldBe(visible);
    }

    public TransferPage transferFirstCard(){
        redButton1.click();
        return new TransferPage();
    }

    public TransferPage transferSecondCard(){
        redButton2.click();
        return new TransferPage();
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public int getFirstCardBalance() {
        val text = cards.first().text();
        return extractBalance(text);
    }

    public int getSecondCardBalance() {
        val text = cards.last().text();
        return extractBalance(text);
    }





}