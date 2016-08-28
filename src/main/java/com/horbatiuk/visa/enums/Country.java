package com.horbatiuk.visa.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrey on 15.08.2016.
 */
public enum Country {
    COUNTRY;

    private final List<String> COUNTRIES = Arrays.asList("USA", "Europe", "Asia");

    public List<String> getCOUNTRIES() {
        return new ArrayList<String>(COUNTRIES);
    }
}
