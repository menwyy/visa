package com.horbatiuk.visa;

import com.horbatiuk.visa.dataStorage.AllTravelAgencies;
import com.horbatiuk.visa.utils.ExceptionUtils;

import java.util.Scanner;

/**
 * Created by Andrey on 17.08.2016.
 */
public class TravelAgencyUtils {

    static boolean checkTravelAgencyExistence(String travelAgencyId) {
        //@TODO Подумать как сделать через метод доступ к хешмепу
        ExceptionUtils.checkStringWithExceptions(travelAgencyId);

        return AllTravelAgencies.getAllTravelAgenciesMap().containsKey(travelAgencyId);
    }

   public static void addPriceRespond(String requestId, String travelAgencyId, int price) throws NullPointerException, IllegalArgumentException {
        ExceptionUtils.checkStringWithExceptions(requestId);
        ExceptionUtils.checkStringWithExceptions(travelAgencyId);

        new PriceResponds(travelAgencyId, requestId, price);
    }

    static TravelAgency getTravelAgencyObjectFromId(String travelAgencyId){
        return AllTravelAgencies.getAllTravelAgenciesMap().get(travelAgencyId);
    }

    public static int getPrice() {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        return price;
    }
}
