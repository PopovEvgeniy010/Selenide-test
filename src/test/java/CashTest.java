import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;

public class CashTest {
    @Test void cashTest(){
        Configuration.holdBrowserOpen = true;
        open("http://localhost:9999");
        $("[data-test-id=city] input").setValue("Москва");
        $("[data-test-id=date] input").clear();
        $("[data-test-id=name] input ").setValue("Попов Евгений");
        $("[data-test-id=phone] input ").setValue("+79150034567");
        $("[data-test-id=agreement] ").click();
        $x("//span[contains(text(),'Забронировать')]").click();
        $("[data-test-id=\"notification\"]").should(Condition.appear, Duration.ofSeconds(15));

    }
}
