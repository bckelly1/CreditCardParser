import connector.DatabaseConnector;
import file.FileParser;
import transaction.CreditCardTransaction;
import transaction.CreditUnionAccountTransaction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Brian on 10/1/2016.
 *
 */
public class TransactionInserter {
    private static String BRIAN_Custom_KING_SOOPERS_CARD = "C:\\Users\\Brian\\Downloads\\export.csv";
    private static String BRIAN_KING_SOOPERS_CARD = "C:\\Users\\Brian\\Downloads\\export-brian.csv";
    private static String MANNY_KING_SOOPERS_CARD = "C:\\Users\\Brian\\Downloads\\export-manny.csv";
    private static String MANNY_Custom_KING_SOOPERS_CARD = "C:\\Users\\Brian\\Downloads\\export.csv";
    private static String REGULAR_CREDIT_UNION = "C:\\Users\\Brian\\Downloads\\ExportedTransactions-8371.csv";
    private static String JOINT_CREDIT_UNION = "C:\\Users\\Brian\\Downloads\\ExportedTransactions-3783.csv";

    public static void main(String[] args) {
        try {
//            ArrayList<transaction.CreditCardTransaction> brianTransactions = new file.FileParser().parseKingSoopersCardFile(BRIAN_KING_SOOPERS_CARD);
            ArrayList<transaction.CreditCardTransaction> mannyTransactions = new file.FileParser().parseKingSoopersCardFile(MANNY_Custom_KING_SOOPERS_CARD);

//            ArrayList<CreditUnionAccountTransaction> creditUnionAccountTransactions = new FileParser().parseFirstTechAccountFile(REGULAR_CREDIT_UNION);
//            ArrayList<CreditUnionAccountTransaction> jointAccountTransactions = new FileParser().parseFirstTechAccountFile(JOINT_CREDIT_UNION);

            DatabaseConnector databaseConnector = new DatabaseConnector();
            Connection connection = databaseConnector.createConnection("localhost", "3306", "Inventory", "Inventory", "BriansInventory");
//            insert_transactions(brianTransactions, BRIAN_KS_CARD, databaseConnector);
//            insert_transactions(mannyTransactions, MANNY_KS_CARD, databaseConnector);
//            insert_transactions(creditUnionAccountTransactions, databaseConnector, COMMON_CHECKING);
//            insert_transactions(jointAccountTransactions, databaseConnector, JOINT_CHECKING );

            connection.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insert_transactions(ArrayList<CreditCardTransaction> creditCardTransactions, String ownersCardLast4, DatabaseConnector databaseConnector) throws SQLException {
        for (CreditCardTransaction creditCardTransaction : creditCardTransactions){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String date = simpleDateFormat.format(creditCardTransaction.getDate());
            String insert = "Insert into credit_card_transactions VALUES(STR_TO_DATE('"
                    +date+ "','%Y-%m-%d'),'"
                    + creditCardTransaction.getTransactionType()
                    +"','"
                    + creditCardTransaction.getName()
                    + "','"
                    + creditCardTransaction.getMemo()
                    +"',"
                    + creditCardTransaction.getAmount()
                    + ",'"
                    +ownersCardLast4
                    +"')";
            int result = databaseConnector.updateDatabase(insert);
            if(result != 1){
                System.out.println("row insert result: "+result);
            }
        }
    }

    private static void insert_transactions(ArrayList<CreditUnionAccountTransaction> transactions, DatabaseConnector databaseConnector, String account) throws SQLException {
        /**
         * column[0] - transactionId
         * column[1] - posting Date
         * column[2] - effective Date
         * column[3] - transaction.CreditCardTransaction Type
         * column[4] - Amount
         * column[5] - Check Number
         * column[6] - Reference Number
         * column[7] - Payee
         * column[8] - Memo
         * column[9] - transaction.CreditCardTransaction Category
         * column[10] - Type
         * column[11] - Balance
         * */
        for (CreditUnionAccountTransaction transaction : transactions){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String effectiveDate = simpleDateFormat.format(transaction.getEffectiveDate());
            String postingDate = simpleDateFormat.format(transaction.getPostingDate());
            String insert = "Insert into bank_account_transactions VALUES(" +
                    "'" + transaction.getTransactionId() + "'," +
                    "STR_TO_DATE('" + postingDate+ "','%Y-%m-%d')," +
                    "STR_TO_DATE('" + effectiveDate+ "','%Y-%m-%d')," +
                    "'"+ transaction.getTransactionType()+ "'," +
                    ""+ transaction.getAmount() + "," +
                    "'"+transaction.getCheckNumber()+ "'," +
                    ""+transaction.getReferenceNumber()+ "," +
                    "'"+transaction.getPayee()+ "'," +
                    "'"+transaction.getMemo()+ "'," +
                    "'"+transaction.getTransactionCategory()+ "'," +
                    "'"+transaction.getType()+ "'," +
                    ""+ transaction.getBalance()+ "," +
                    ""+ account+ "" +
                    ")";


            System.out.println(insert);

            int result = databaseConnector.updateDatabase(insert);
            if(result != 1){
                System.out.println("row insert result: "+result);
            }
        }
    }
}
