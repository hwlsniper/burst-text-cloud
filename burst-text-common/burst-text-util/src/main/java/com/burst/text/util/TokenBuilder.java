package com.burst.text.util;

import java.util.UUID;

public class TokenBuilder {
    public static UUIDCreator uuidCreator = TokenBuilder.UUIDCreator.getInstance();

    public static interface TokenCreator {
        public String create();
    }


    public static class UUIDCreator implements TokenCreator {

        private static UUIDCreator ins = new UUIDCreator();

        public static UUIDCreator getInstance() {
            return ins;
        }

        @Override
        public String create() {
            return UUID.randomUUID().toString().replace("-", "");
        }

    }
}
