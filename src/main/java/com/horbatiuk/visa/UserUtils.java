package com.horbatiuk.visa;

import com.horbatiuk.visa.dataStorage.AllUsers;
import com.horbatiuk.visa.utils.ExceptionUtils;

/**
 * Created by Andrey on 17.08.2016.
 */
public class UserUtils {

    //Проверяет: существует ли пользователь в общем списке пользователей

    static boolean checkUserExistence(String userId) {
        ExceptionUtils.checkStringWithExceptions(userId);

        return AllUsers.getAllUsersMap().containsKey(userId);
    }

    //Обработка нового запроса (с проверкой на существование пользователя)
    static void checkUserNewRequest(String userEmailInRequest, String requestId) throws NullPointerException, IllegalArgumentException {
        ExceptionUtils.checkStringWithExceptions(userEmailInRequest);
        ExceptionUtils.checkStringWithExceptions(requestId);

        if (checkUserExistence(userEmailInRequest)) {
            addRequestToUser(requestId, userEmailInRequest);
        } else {
            new User(userEmailInRequest);
            addRequestToUser(requestId,userEmailInRequest);
        }
    }

//Добавляет запрос в список запросов пользователя

    static void addRequestToUser(String requestId, String userId) throws NullPointerException, IllegalArgumentException {
        ExceptionUtils.checkStringWithExceptions(userId);
        ExceptionUtils.checkStringWithExceptions(requestId);

        UserUtils.getUserObjectFromId(userId).getUserRequestsIdList().add(requestId);
    }

    static User getUserObjectFromId(String userId){
        return AllUsers.getAllUsersMap().get(userId);
    }

}
