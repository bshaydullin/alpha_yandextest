package ru.testing.gateway;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ru.testing.entities.TranslateRequest;
import ru.testing.entities.TranslateResponse;

@Slf4j
public class YandexTranslateGateway {
    private static final String URL = "https://translate.api.cloud.yandex.net/translate/v2/translate";
    //"expiresAt": "2021-09-14T20:14:06.291667007Z"
    private static final String TOKEN = "t1.9euelZrKnJmSzJOZkI-YkpfHzczKl-3rnpWaz5GYzYzOzZGVm4uZmI6LipDl8_cxTH51-e9AB3Z0_t3z93F6e3X570AHdnT-.bkxLR5JGsgWd5CshBpau6JM5DImiPfv2V4rCYlXA2Iz9ux1BR-jMz7k7XLbVYBBjTQlFGt0KysYWhM8xA9obBQ";
    private static final String FOLDERID = "b1gqtrt8mgf3ae61b58s";
    @SneakyThrows
    public TranslateResponse getTranslate(String[] str, String language) {
        Gson gson = new Gson();
        TranslateRequest requestBody = new TranslateRequest();
        requestBody.folderId = FOLDERID;
        requestBody.texts = str;
        requestBody.targetLanguageCode = language;

        HttpResponse<String> response = Unirest.post(URL)
                .header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer "+TOKEN)
                .body(gson.toJson(requestBody))
                .asString();
        String strResponse = response.getBody();
        log.info("response: "+strResponse);
        return gson.fromJson(strResponse, TranslateResponse.class);
    }
}