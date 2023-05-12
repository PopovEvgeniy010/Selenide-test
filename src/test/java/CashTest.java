import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CashTest {
    @Test void cashTest(){
        String planningDate = DataGenerator.generateDate(4);
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT,Keys.HOME),Keys.BACK_SPACE);
        $("[data-test-id=date] input").setValue(planningDate);
        $("[data-test-id=name] input ").setValue("Попов Евгений");
        $("[data-test-id=phone] input ").setValue("+79150034567");
        $("[data-test-id=agreement] ").click();
        $x("//span[contains(text(),'Забронировать')]").click();
        $("[data-test-id=\"notification\"]").should(Condition.appear, Duration.ofSeconds(15));
        $(".notification__content").shouldHave(Condition.text("Встреча успешно забронирована на " + planningDate), Duration.ofSeconds(15))
                .shouldBe(Condition.visible);

    }
}
