package com.horbatiuk.visa;

import com.horbatiuk.visa.dataStorage.AllRequests;
import com.horbatiuk.visa.utils.ExceptionUtils;

/**
 * Created by Andrey on 15.08.2016.
 */
public class RequestUtils {

    static boolean checkRequestExistence(String requestId) {
        ExceptionUtils.checkStringOnNull(requestId);
        ExceptionUtils.checkStringOnEmpty(requestId);

        return AllRequests.getAllRequestsMap().containsKey(requestId);
    }

    static Request getRequestObjectFromId(String requestId){
        return AllRequests.getAllRequestsMap().get(requestId);
    }

    void sendRequestToTravelAgencies() {
//        Метод отправляет запрос агентствам
    }

    void sendRequestLinkToUser() {
        //Метод отправляет пользователю на почту ссылку на страницу запроса
    }

    void viewRequest() {
//        Пользователь просматривает список ответов на запрос
    }


}
