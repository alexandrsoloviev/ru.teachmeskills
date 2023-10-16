package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TMSTest extends BaseTest{
    @Test
    void siteIsOpened(){
        step("Открыть сайт", () -> {
            open("/wqeqwe");
        });
        step("Кнопки для заявок загружены", ()->{
            $$x("//button[contains(@class,'ContactForm__StyledButton')]").
                    shouldHave(size(3));
        });
        step("Блок 'IT курсы в формате онлайн' загружен", ()->{
           $x("//h2[text()='IT курсы в формате онлайн']/../../../..").shouldBe(visible);
        });
        step("Блок 'Учебный процесс' загружен", ()->{
            $x("//h2[text()='Учебный процесс']/..").shouldBe(visible);
        });
        step("Загружено 2 блока 'Поможем в выборе'", ()->{
            $$x("//div//p[text()='Поможем в выборе!']").
                    shouldHave(size(2));
        });
        step("Блок 'Успешные истории наших выпускников' загружен", ()->{
            $x("//div[contains(@class,'GraduateStories__Reviews')]//h2[text()='Успешные истории наших выпускников']")
                    .shouldBe(visible);
        });
        step("Блок 'Преподаватели о которых можно только мечтать' загружен", ()->{
            $$x("//div[contains(@class,'TeachersBlock__List')]/div").shouldHave(size(8));
        });


    }
}
