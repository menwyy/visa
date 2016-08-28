package com.horbatiuk.visa.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrey on 15.08.2016.
 */
public enum City {
    CITY;

    private final List<String> CITIES = Arrays.asList("Kiev", "Odessa", "Poltava");

    public List<String> getCITIES() {
        return new ArrayList<String>(CITIES);
    }
}
