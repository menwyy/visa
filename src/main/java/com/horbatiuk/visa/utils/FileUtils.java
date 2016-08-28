package com.horbatiuk.visa.utils;

import com.horbatiuk.visa.PriceResponds;
import com.horbatiuk.visa.Request;
import com.horbatiuk.visa.TravelAgency;
import com.horbatiuk.visa.User;
import com.horbatiuk.visa.dataStorage.AllPriceResponds;
import com.horbatiuk.visa.dataStorage.AllRequests;
import com.horbatiuk.visa.dataStorage.AllTravelAgencies;
import com.horbatiuk.visa.dataStorage.AllUsers;

import java.io.*;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Andrey on 25.08.2016.
 */
public class FileUtils {
    // binary files
    private static final String ALL_USERS_BINARY = "allUsers_new.txt";
    private static final String ALL_TRAVEL_AGENCIES_BINARY = "allTravelAgencies_new.txt";
    private static final String ALL_PRICE_RESPONDS_BINARY = "allPriceResponds_new.txt";
    private static final String ALL_REQUESTS_BINARY = "allRequests_new.txt";
    // text files
    private static final String ALL_USERS_TEXT = "allUsersText.txt";
    private static final String ALL_TRAVEL_AGENCIES_TEXT = "allTravelAgenciesText.txt";
    private static final String ALL_PRICE_RESPONDS_TEXT = "allPriceRespondsText.txt";
    private static final String ALL_REQUESTS_TEXT = "allRequestsText.txt";
    // Separator
    private static final String SEPARATOR = ";";

    // Write Utils

    public static void writeDataToFiles() {
        //Записываем в файл состояние программы

        writeAllUsersToFile();
        writeAllPriceRespondsToFile();
        writeAllRequestsToFile();
        writeAllTravelAgenciesToFile();
    }

    public static void writeAllPriceRespondsToFile() {
        try (ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ALL_PRICE_RESPONDS_BINARY)))) {
            os.writeObject(AllPriceResponds.getAllPriceRespondsMap());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllRequestsToFile() {
        try (ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ALL_REQUESTS_BINARY)))) {
            os.writeObject(AllRequests.getAllRequestsMap());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllTravelAgenciesToFile() {
        try (ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ALL_TRAVEL_AGENCIES_BINARY)))) {
            os.writeObject(AllTravelAgencies.getAllTravelAgenciesMap());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllUsersToFile() {
        try (ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ALL_USERS_BINARY)))) {
            os.writeObject(AllUsers.getAllUsersMap());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read Utils

    public static void readAllDataFromFiles() {
        readAllUsersFromFile();
        readAllPriceRespondsFromFile();
        readAllRequestsFromFile();
        readAllTravelAgenciesFromFile();
    }

    public static void readAllPriceRespondsFromFile() {
        try (ObjectInputStream os = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ALL_PRICE_RESPONDS_BINARY)))) {
            AllPriceResponds.setAllPriceRespondsMap((Map<String, PriceResponds>) os.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readAllRequestsFromFile() {
        try (ObjectInputStream os = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ALL_REQUESTS_BINARY)))) {
            AllRequests.setAllRequestsMap((Map<String, Request>) os.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readAllTravelAgenciesFromFile() {
        try (ObjectInputStream os = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ALL_TRAVEL_AGENCIES_BINARY)))) {
            AllTravelAgencies.setAllTravelAgenciesMap((Map<String, TravelAgency>) os.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readAllUsersFromFile() {
        try (ObjectInputStream os = new ObjectInputStream(new BufferedInputStream(new FileInputStream(ALL_USERS_BINARY)))) {
            AllUsers.setAllUsersMap((Map<String, User>) os.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Readable File Utils
    // Export Files Utils
    public static void writeAllUsersToReadableFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ALL_USERS_TEXT))) {
            Iterator it = AllUsers.getAllUsersMap().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                pw.print(((User) pair.getValue()).getUserEmail());
                pw.print("\n");
                it.remove(); // avoids a ConcurrentModificationException
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllTravelAgenciesToReadableFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ALL_TRAVEL_AGENCIES_TEXT))) {
            Iterator it = AllTravelAgencies.getAllTravelAgenciesMap().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                pw.print((((TravelAgency) pair.getValue()).getTravelAgencyEmail()) + SEPARATOR + ((TravelAgency) pair.getValue()).getTravelAgencyName());
                pw.print("\n");
                it.remove(); // avoids a ConcurrentModificationException
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllRequestsToReadableFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ALL_REQUESTS_TEXT))) {
            Iterator it = AllRequests.getAllRequestsMap().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                pw.print((((Request) pair.getValue()).getRequestId()) + SEPARATOR +
                                ((Request) pair.getValue()).getDateOfRequestCreation() + SEPARATOR +
                                ((Request) pair.getValue()).getUserEmailInRequest() + SEPARATOR +
                                ((Request) pair.getValue()).getRequestCountry() + SEPARATOR +
                                ((Request) pair.getValue()).getNumberOfPersonsInRequest() + SEPARATOR +
                                ((Request) pair.getValue()).getStartTripDate() + SEPARATOR +
                                ((Request) pair.getValue()).getLastTripDate());
                pw.print("\n");
                it.remove(); // avoids a ConcurrentModificationException
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAllPriceRespondsToReadableFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ALL_PRICE_RESPONDS_TEXT))) {
            Iterator it = AllPriceResponds.getAllPriceRespondsMap().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                pw.print((((PriceResponds) pair.getValue()).getTravelAgencyId()) + SEPARATOR +
                        ((PriceResponds) pair.getValue()).getRequestId() + SEPARATOR +
                                ((PriceResponds) pair.getValue()).getPrice());
                pw.print("\n");
                it.remove(); // avoids a ConcurrentModificationException
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Import Files Utils
    public static void readAllUsersFromReadableFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(ALL_USERS_TEXT))) {
            String line;
            while ((line = br.readLine()) != null) {
                new User(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAllTravelAgenciesFromReadableFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(ALL_TRAVEL_AGENCIES_TEXT))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tempStringArray = line.split(SEPARATOR);
                new TravelAgency(tempStringArray[0], tempStringArray[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAllRequestsFromReadableFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(ALL_REQUESTS_TEXT))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tempStringArray = line.split(SEPARATOR);
                Request request = new Request(tempStringArray[0],tempStringArray[2]);
                request.setRequestCountry(tempStringArray[3]);
                try {
                    request.setDateOfRequestCreation(Long.parseLong(tempStringArray[1],10));
                    request.setStartTripDate(Long.parseLong(tempStringArray[4],10));
                    request.setLastTripDate(Long.parseLong(tempStringArray[5],10));
                }
                catch (NumberFormatException e){
                    System.out.println("Check long type of numeric values. It is not long and couldn't be parsed.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAllPriceRespondsFromReadableFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(ALL_PRICE_RESPONDS_TEXT))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tempStringArray = line.split(SEPARATOR);
                try {
                    new PriceResponds(tempStringArray[0], tempStringArray[1], Integer.parseInt(tempStringArray[2]));
                }
                catch (NumberFormatException e){
                    System.out.println("Check int type of price values. It is not int and couldn't be parsed.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
