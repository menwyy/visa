package com.horbatiuk.visa;

import com.horbatiuk.visa.dataStorage.AllPriceResponds;
import com.horbatiuk.visa.dataStorage.AllTravelAgencies;
import com.horbatiuk.visa.utils.ExceptionUtils;

import java.util.Collections;
import java.util.Comparator;

class PriceRespondSorting {


    static void sortPriceMinMax(String requestId) throws NullPointerException, IllegalArgumentException {
//        Сортирует цены по возрастанию
        ExceptionUtils.checkStringOnNull(requestId);
        ExceptionUtils.checkStringOnEmpty(requestId);

        Collections.sort(PriceRespondUtils.getRespondIdListFromRequestId(requestId), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return Integer.compare(PriceRespondUtils.getPriceRespondObjectFromId(o1).getPrice(), PriceRespondUtils.getPriceRespondObjectFromId(o2).getPrice());
            }
        });
        // return
        for (String s : PriceRespondUtils.getRespondIdListFromRequestId(requestId)) {
            System.out.print(PriceRespondUtils.getPriceRespondObjectFromId(s).getPrice() + "; ");
        }
        ; // return


    }

    static void sortPriceMaxMin(String requestId) throws NullPointerException, IllegalArgumentException {
//      Сортирует цены по убыванию
        ExceptionUtils.checkStringOnNull(requestId);
        ExceptionUtils.checkStringOnEmpty(requestId);

        Collections.sort(PriceRespondUtils.getRespondIdListFromRequestId(requestId), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(PriceRespondUtils.getPriceRespondObjectFromId(o2).getPrice(), PriceRespondUtils.getPriceRespondObjectFromId(o1).getPrice());
            }
        });
        // return
        for (String s : PriceRespondUtils.getRespondIdListFromRequestId(requestId)) {
            System.out.print(AllPriceResponds.getAllPriceRespondsMap().get(s).getPrice() + "; ");
        }
        ; // return
    }

    static void sortTravelAgencyNameAlphabet(String requestId) throws NullPointerException, IllegalArgumentException {
//      Сортирует по имени агентства
        ExceptionUtils.checkStringOnNull(requestId);
        ExceptionUtils.checkStringOnEmpty(requestId);

        Collections.sort(PriceRespondUtils.getRespondIdListFromRequestId(requestId), new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String travelAgencyId1 = PriceRespondUtils.getPriceRespondObjectFromId(o1).getTravelAgencyId();
                String travelAgencyId2 = PriceRespondUtils.getPriceRespondObjectFromId(o2).getTravelAgencyId();

                return TravelAgencyUtils.getTravelAgencyObjectFromId(travelAgencyId1).getTravelAgencyName().compareTo(
                        TravelAgencyUtils.getTravelAgencyObjectFromId(travelAgencyId2).getTravelAgencyName()
                );
            }
        });
        // return
        for (String s : PriceRespondUtils.getRespondIdListFromRequestId(requestId)) {
            System.out.print(AllTravelAgencies.getAllTravelAgenciesMap().get(
                    AllPriceResponds.getAllPriceRespondsMap().get(s).getTravelAgencyId()).getTravelAgencyName() + "; ");
        }
        ; // return
    }

    static void sortTravelAgencyStreetNameAlphabet(String requestId) throws NullPointerException, IllegalArgumentException {
//      Сортирует по имени улицы, на котором находится агентство
        ExceptionUtils.checkStringOnNull(requestId);
        ExceptionUtils.checkStringOnEmpty(requestId);
        ExceptionUtils.checkObjectOnNull(PriceRespondUtils.getRespondIdListFromRequestId(requestId));

        Collections.sort(PriceRespondUtils.getRespondIdListFromRequestId(requestId), new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String travelAgencyId1 = AllPriceResponds.getAllPriceRespondsMap().get(o1).getTravelAgencyId();
                String travelAgencyId2 = AllPriceResponds.getAllPriceRespondsMap().get(o2).getTravelAgencyId();

                return TravelAgencyUtils.getTravelAgencyObjectFromId(travelAgencyId1).getTravelAgencyStreet().compareTo(
                        TravelAgencyUtils.getTravelAgencyObjectFromId(travelAgencyId2).getTravelAgencyStreet());
            }
        });
        // return
        for (String s : PriceRespondUtils.getRespondIdListFromRequestId(requestId)) {
            System.out.print(AllTravelAgencies.getAllTravelAgenciesMap().get(
                    AllPriceResponds.getAllPriceRespondsMap().get(s).getTravelAgencyId()).getTravelAgencyStreet() + "; ");
        }
        ;
        // return
    }

    static void sortMinMaxPriceTravelAgencyNameAlphabetStreetNameAlphabet(String requestId) throws NullPointerException, IllegalArgumentException {
//      Сортирует по цене, с одинаковой ценой - по имени агентстваб с одинаковым именем - по названию улицы.
        ExceptionUtils.checkStringOnNull(requestId);
        ExceptionUtils.checkStringOnEmpty(requestId);
        ExceptionUtils.checkObjectOnNull(PriceRespondUtils.getRespondIdListFromRequestId(requestId));

        Collections.sort(PriceRespondUtils.getRespondIdListFromRequestId(requestId), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result;
                String travelAgency1Id = PriceRespondUtils.getPriceRespondObjectFromId(o1).getTravelAgencyId();
                String travelAgency2Id = PriceRespondUtils.getPriceRespondObjectFromId(o2).getTravelAgencyId();
                result = Integer.compare(PriceRespondUtils.getPriceRespondObjectFromId(o1).getPrice(), PriceRespondUtils.getPriceRespondObjectFromId(o2).getPrice());
                if (result == 0) {
                    result = TravelAgencyUtils.getTravelAgencyObjectFromId(travelAgency1Id).getTravelAgencyName().compareTo(
                            TravelAgencyUtils.getTravelAgencyObjectFromId(travelAgency2Id).getTravelAgencyName()
                    );
                    if (result == 0) {
                        result = TravelAgencyUtils.getTravelAgencyObjectFromId(travelAgency1Id).getTravelAgencyStreet().compareTo(TravelAgencyUtils.getTravelAgencyObjectFromId(travelAgency2Id).getTravelAgencyStreet());
                    }
                }
                return result;
            }
        });
        // return
        for (String s : PriceRespondUtils.getRespondIdListFromRequestId(requestId)) {
            System.out.print(TravelAgencyUtils.getTravelAgencyObjectFromId((
                    PriceRespondUtils.getPriceRespondObjectFromId(s).getTravelAgencyId())).getTravelAgencyName() + " " + TravelAgencyUtils.getTravelAgencyObjectFromId((
                    PriceRespondUtils.getPriceRespondObjectFromId(s).getTravelAgencyId())).getTravelAgencyStreet() +
                    PriceRespondUtils.getPriceRespondObjectFromId(s).getPrice());
        }
        ; // return
    }

}
