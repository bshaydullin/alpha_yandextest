package ru.testing.entities;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

@Getter
public class TranslateResponseArray {
    @SerializedName("text")
    public String text;
    @SerializedName("detectedLanguageCode")
    public String detectedLanguageCode;
}