package com.horbatiuk.visa;

import com.horbatiuk.visa.dataStorage.AllPriceResponds;
import com.horbatiuk.visa.utils.ExceptionUtils;

import java.util.List;

/**
 * Created by Andrey on 19.08.2016.
 */
public class PriceRespondUtils {
    public static List<String> getRespondIdListFromRequestId(String requestId) throws NullPointerException, IllegalArgumentException {
        ExceptionUtils.checkStringWithExceptions(requestId);
        ExceptionUtils.checkObjectOnNull(RequestUtils.getRequestObjectFromId(requestId));
        ExceptionUtils.checkObjectOnNull(RequestUtils.getRequestObjectFromId(requestId).getPriceRespondsIdList());

        return RequestUtils.getRequestObjectFromId(requestId).getPriceRespondsIdList();
    }

    public static boolean isRespondFromTravelAgency(String travelAgencyId, String requestId) {
       List<String> listOfResponds = RequestUtils.getRequestObjectFromId(requestId).getPriceRespondsIdList();
        for(String s : listOfResponds){
            if(PriceRespondUtils.getPriceRespondObjectFromId(s).getTravelAgencyId().equals(travelAgencyId)){
                return true;
            }
        }
        return false;

    }

    static PriceResponds getPriceRespondObjectFromId(String priceRespondId){
        return AllPriceResponds.getAllPriceRespondsMap().get(priceRespondId);
    }

}

