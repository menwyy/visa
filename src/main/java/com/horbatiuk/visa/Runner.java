package com.horbatiuk.visa;

import com.horbatiuk.visa.dataStorage.AllPriceResponds;
import com.horbatiuk.visa.dataStorage.AllRequests;
import com.horbatiuk.visa.dataStorage.AllTravelAgencies;
import com.horbatiuk.visa.dataStorage.AllUsers;
import com.horbatiuk.visa.utils.FileUtils;

/**
 * Created by Andrey on 11.08.2016.
 */
public class Runner {
    public static void main(String[] args) {
        FileUtils.readAllDataFromFiles();
        System.out.println(AllRequests.getAllRequestsMap().size());
        System.out.println(AllUsers.getAllUsersMap().size());
        System.out.println(AllPriceResponds.getAllPriceRespondsMap().size());
        System.out.println(AllTravelAgencies.getAllTravelAgenciesMap().size());

//        FileUtils.readAllRequestsFromReadableFile();
//        FileUtils.readAllUsersFromReadableFile();
//        FileUtils.readAllTravelAgenciesFromReadableFile();
//        FileUtils.readAllPriceRespondsFromReadableFile();

//        System.out.println(AllRequests.getAllRequestsMap().size());
//        System.out.println(AllUsers.getAllUsersMap().size());
//        System.out.println(AllPriceResponds.getAllPriceRespondsMap().size());
//        System.out.println(AllTravelAgencies.getAllTravelAgenciesMap().size());


//        FileUtils.writeDataToFiles();

//        Iterator it = AllRequests.getAllRequestsMap().entrySet().iterator();
//        List<Request> listOfRequests = new ArrayList<>();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry) it.next();
//            if (((Request) pair.getValue()).getPriceRespondsIdList().size() > 4) {
//                System.out.println(((Request) pair.getValue()).getRequestId());
//                PriceRespondSorting.sortPriceMinMax(((Request) pair.getValue()).getRequestId());
//                System.out.println();
//                PriceRespondSorting.sortPriceMaxMin(((Request) pair.getValue()).getRequestId());
//                System.out.println();
//                PriceRespondSorting.sortTravelAgencyNameAlphabet(((Request) pair.getValue()).getRequestId());
//                PriceRespondSorting.sortMinMaxPriceTravelAgencyNameAlphabetStreetNameAlphabet(((Request) pair.getValue()).getRequestId());
//                PriceRespondFiltering.filterByPrice(((Request) pair.getValue()).getRequestId(), 4000, 5900);
//
//            }
//            it.remove(); // avoids a ConcurrentModificationException
//        }
//@TODO Нужно ли делать обращение по id обьекта через метод или запрашивать через геттер у хешмепа?

    }
}
