package queries;

import common.CommonBankAccountStrings;
import common.CommonCreditCardStrings;

import java.util.ArrayList;

/**
 * Created by Brian on 10/22/2016.
 */
public class QueryBankAccountTransactionCategory {
    static String queryBegin = "select posting_date, memo from bank_account_transactions where memo " +
            "NOT LIKE '' \n";
            //"      AND name NOT like 'ARBYS%'\n"
    static String queryEnd = "order by memo;";

    public static void main(String[] args) {
        String query = queryBegin;
        ArrayList<String> deposits = CommonBankAccountStrings.getDepositsTransactions();
        ArrayList<String> purchases = CommonBankAccountStrings.getPurchases();
        ArrayList<String> withdrawals = CommonBankAccountStrings.getWithdrawalsTransactions();
        ArrayList<String> debits = CommonBankAccountStrings.getAchDebits();
        ArrayList<String> payments = CommonBankAccountStrings.getPaymentsTransactions();
        ArrayList<String> food = CommonBankAccountStrings.getFoodTransactions();
        ArrayList<String> gas = CommonBankAccountStrings.getGasTransactions();
        ArrayList<String> extra = CommonBankAccountStrings.getExtraTransactions();

        for(String index : deposits){
            query = query + " AND memo NOT LIKE '" +index + "%' \n";
        }
        for(String index : withdrawals){
            query = query + " AND memo NOT LIKE '" +index + "%' \n";
        }
        for(String index : payments){
            query = query + " AND memo NOT LIKE '" +index + "%' \n";
        }
        for(String index : purchases){
            query = query + " AND memo NOT LIKE '" +index + "%' \n";
        }
        for(String index : debits){
            query = query + " AND memo NOT LIKE '" +index + "%' \n";
        }
        for(String index : food){
            query = query + " AND memo NOT LIKE '" +index + "%' \n";
        }
        for(String index : gas){
            query = query + " AND memo NOT LIKE '" +index + "%' \n";
        }
        for(String index : extra){
            query = query + " AND memo NOT LIKE '" +index + "%' \n";
        }

        query = query + queryEnd;

        System.out.println(query);
//        DatabaseConnector databaseConnector = new DatabaseConnector();
//        try {
//            databaseConnector.queryDatabase(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
