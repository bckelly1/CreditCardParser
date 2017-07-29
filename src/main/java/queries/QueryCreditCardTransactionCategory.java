package queries;

import common.CommonCreditCardStrings;

import java.util.ArrayList;

/**
 * Created by Brian on 10/22/2016.
 */
public class QueryCreditCardTransactionCategory {
    static String queryBegin = "select * from credit_card_transactions where name " +
            "NOT LIKE 'AMAZON%' \n";
            //"      AND name NOT like 'ARBYS%'\n"
    static String queryEnd = "order by name;";

    public static String getAllCreditCardTransactions() {
        String query = queryBegin;
        ArrayList<String> foodTransactions = CommonCreditCardStrings.getRestaurantFoodTransactions();
        ArrayList<String> gas = CommonCreditCardStrings.getGasTransactions();
        ArrayList<String> grocery = CommonCreditCardStrings.getGroceryTransactions();
        ArrayList<String> medical = CommonCreditCardStrings.getMedicalTransactions();
        ArrayList<String> travel = CommonCreditCardStrings.getTravelTransactions();
        ArrayList<String> shopping = CommonCreditCardStrings.getShoppingTransactions();
        ArrayList<String> maine = CommonCreditCardStrings.getMaineTransactions();
        ArrayList<String> games = CommonCreditCardStrings.getWeddingTransactions();
        ArrayList<String> wedding = CommonCreditCardStrings.getGamesTransactions();
        ArrayList<String> supermarket = CommonCreditCardStrings.getSupermarketTransactions();
        ArrayList<String> phone = CommonCreditCardStrings.getPhoneTransactions();
        ArrayList<String> car = CommonCreditCardStrings.getCarTransactions();
        ArrayList<String> general = CommonCreditCardStrings.getGeneralTransactions();

        for(String index : foodTransactions){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : gas){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : grocery){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : medical){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : general){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : shopping){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : supermarket){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : games){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : wedding){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : car){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : maine){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : phone){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }
        for(String index : travel){
            query = query + " AND name NOT LIKE '" +index + "%' \n";
        }

        query = query + queryEnd;
        return query;
    }
}
