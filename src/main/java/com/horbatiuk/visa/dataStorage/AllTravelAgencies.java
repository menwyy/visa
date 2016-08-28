package com.horbatiuk.visa.dataStorage;

import com.horbatiuk.visa.TravelAgency;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrey on 17.08.2016.
 */
public final class AllTravelAgencies implements Serializable {
    private static final long serialVersionUID = -3765330724073400694L;
    private static Map<String, TravelAgency> allTravelAgenciesMap = new HashMap<>();

    private AllTravelAgencies() {
    }

    public static Map<String, TravelAgency> getAllTravelAgenciesMap() {
        return allTravelAgenciesMap;
    }

    public static void setAllTravelAgenciesMap(Map<String, TravelAgency> allTravelAgenciesMap) {
        AllTravelAgencies.allTravelAgenciesMap = allTravelAgenciesMap;
    }
}
