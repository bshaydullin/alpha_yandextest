package ru.testing.entities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TranslateResponse {
    @SerializedName("translations")
    public TranslateResponseArray[] translations;
}