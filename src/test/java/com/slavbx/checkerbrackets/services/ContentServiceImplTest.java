package com.slavbx.checkerbrackets.services;

import com.slavbx.checkerbrackets.models.Content;
import com.slavbx.checkerbrackets.models.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContentServiceImplTest {
    private ContentService contentService;

    @BeforeEach
    public void setup() {
        contentService = new ContentServiceImpl();
    }

    @Test
    public void shouldReturnIsCorrect() {
        Content content = new Content("Вчера я отправился в поход в лес (это мое любимое место для отдыха) " +
                "вместе с друзьями. Мы выбрали маршрут, который проходил через горные потоки и поля " +
                "(для разнообразия). " +
                "В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели. " +
                "Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками, " +
                "(как будто природа готовила нам небольшой сюрприз). Несмотря на это, виды были захватывающими, " +
                "особенно когда мы достигли высшей точки и увидели прекрасный вид на долину " +
                "(я почувствовал, что все усилия стоили того).");
        Response result = contentService.check(content);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.isCorrect());

        Response testResponse = new Response();
        testResponse.setCorrect(true);
        Assertions.assertEquals(testResponse, result);

    }

    @Test
    public void shouldReturnIsIncorrect() {
        Content content = new Content("())");
        Response result = contentService.check(content);
        Assertions.assertFalse(result.isCorrect());

        content.setText("(()");
        result = contentService.check(content);
        Assertions.assertFalse(result.isCorrect());

        content.setText(")(");
        result = contentService.check(content);
        Assertions.assertFalse(result.isCorrect());
    }
}
