package com.burst.text.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

public class JsonURLDateSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String url, JsonGenerator gen,
                          SerializerProvider provider) throws IOException, JsonProcessingException {
        String value = "";
        if (StringUtils.isBlank(url)) {
            gen.writeString("");

        } else {
            if (url.indexOf(",") != 0) {
                StringBuilder builder = new StringBuilder();
                String[] urls = url.split(",");
                for (int i = 0; i < urls.length; i++) {
                    String temp = urls[i];
                    if (temp.indexOf("http") >= 0) {
                        builder.append(temp);
                    } else {
                        builder.append(ImageUrlUtil.getThumbnailUrl(temp));
                    }

                    if (i != urls.length - 1) {
                        builder.append(",");
                    }
                }
                value = builder.toString();
            } else {
                if (url.indexOf("http") >= 0) {
                    value = url;
                } else {
                    value = ImageUrlUtil.getThumbnailUrl(url);
                }
            }
            gen.writeString(value);
        }
    }
}
