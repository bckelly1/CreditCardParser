package queries;

import common.CommonBankAccountStrings;
import common.CommonCreditCardStrings;
import connector.DatabaseConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Brian on 10/20/2016.
 *
 */
public class Queries {
    private static String monthlyCreditCardSpendingQuery = "select SUM(amount) Total from credit_card_transactions where Date BETWEEN (CURRENT_DATE - INTERVAL 1 MONTH ) AND current_date AND amount < 0 order by Date;";
    private static String yearlyCreditCardSpendingQuery = "select SUM(amount) Total from credit_card_transactions where Date BETWEEN (CURRENT_DATE - INTERVAL 1 YEAR ) AND current_date AND amount < 0 order by Date;";
    private static String yearlyCreditCardSpendingByMonthQuery = "select ROUND(SUM(amount),2) Total, DATE_FORMAT(Date, '%M-%Y') from credit_card_transactions where Date BETWEEN (CURRENT_DATE - INTERVAL 1 YEAR ) AND current_date AND amount < 0 GROUP BY DATE_FORMAT(Date, '%M-%Y') order by Date;";
    private static String lastMonthCreditCardSpendingByDayQuery = "select ROUND(SUM(amount),2) Total, DATE_FORMAT(Date, '%D-%M') from credit_card_transactions where Date BETWEEN (CURRENT_DATE - INTERVAL 1 MONTH ) AND current_date AND amount < 0 GROUP BY DATE_FORMAT(Date, '%D-%M') order by Date;";
    private static String beginLastYearGas = "";

    public int getLastMonthSpendingAll(DatabaseConnector databaseConnector) throws SQLException {
        return getTotal(databaseConnector.queryDatabase(monthlyCreditCardSpendingQuery));
    }

    public int getLastYearSpendingAll(DatabaseConnector databaseConnector) throws SQLException {
        return getTotal(databaseConnector.queryDatabase(yearlyCreditCardSpendingQuery));
    }

    public static HashMap getLastYearGas(DatabaseConnector databaseConnector) throws SQLException{
        HashMap<String, Integer> gasTransactions = new HashMap<>();
        ArrayList<String> gasTransactionsBankAccounts = CommonBankAccountStrings.getGasTransactions();
        ArrayList<String> gasTransactionsCreditCards = CommonCreditCardStrings.getGasTransactions();
        String beginningBank = "select \n" +
                "    ROUND(SUM(amount),2) Total, DATE_FORMAT(bank.posting_date, '%M-%Y') Date \n" +
                "  from bank_account_transactions bank\n" +
                "  where bank.posting_date BETWEEN (CURRENT_DATE - INTERVAL 3 YEAR ) AND current_date \n" +
                "   AND ( " ;
        String endingBank = " ) GROUP BY DATE_FORMAT(bank.posting_date, '%M-%Y')\n" +
                " order by bank.posting_date desc";
        for(String index : gasTransactionsBankAccounts){
            if(beginningBank.contains(" bank.memo like ")){
                beginningBank = beginningBank + " OR bank.memo like '" + index + "%' \n";
            }
            else{
                beginningBank = beginningBank + " bank.memo like '" + index + "%' \n";
            }
        }
        String query = beginningBank + endingBank;
//        System.out.println(query);
        ResultSet resultSet = databaseConnector.queryDatabase(query);
        while(resultSet.next()){
            String date = resultSet.getString("Date");
            Integer total = resultSet.getInt("Total");
            if(gasTransactions.containsKey(date)){
                gasTransactions.put(date, gasTransactions.get(date) + total);
            }
            else{
                gasTransactions.put(date, total);
            }
        }

        String beginningCard = "select \n" +
                " ROUND(SUM(amount),2) Total, DATE_FORMAT(Date, '%M-%Y') Date \n" +
                " from credit_card_transactions card\n" +
                "  where card.Date BETWEEN (CURRENT_DATE - INTERVAL 3 YEAR ) AND current_date \n" +
                " AND ( ";
        for(String index : gasTransactionsCreditCards){
            if(beginningCard.contains(" card.name like ")){
                beginningCard = beginningCard + " OR card.name like '" + index + "%' \n";
            }
            else{
                beginningCard = beginningCard + " card.name like '" + index + "%' \n";
            }
        }
        String endingCard = ") " +
                "GROUP BY DATE_FORMAT(Date, '%M-%Y') \n" +
                " order by card.Date desc";
        query = beginningCard + endingCard;
//        System.out.println(query);
        resultSet = databaseConnector.queryDatabase(query);
        while(resultSet.next()){
            String date = resultSet.getString("Date");
            Integer total = resultSet.getInt("Total");
            if(gasTransactions.containsKey(date)){
                gasTransactions.put(date, gasTransactions.get(date) + total);
            }
            else{
                gasTransactions.put(date, total);
            }
        }
        return gasTransactions;
    }

    private int getTotal(ResultSet resultSet){
        int total = 0;
        try {
            while(resultSet.next()){
                total = resultSet.getInt("Total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public static void main(String[] args) {
        try {
            HashMap lastYearGas = getLastYearGas(new DatabaseConnector());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
