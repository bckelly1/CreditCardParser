package file;

import transaction.CreditCardTransaction;
import transaction.CreditUnionAccountTransaction;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Brian on 10/1/2016.
 *
 */
public class FileParser {
    public ArrayList<CreditCardTransaction> parseKingSoopersCardFile(String path) throws IOException {
        ArrayList<CreditCardTransaction> creditCardTransactions = new ArrayList<>();
        Object[] array = new FileReader().readInFile(path);
        if (array != null) {
            for(Object line : array){
                String stringLine = (String)line;
                String[] columns = stringLine.replaceAll("\"","").split(",");
                if(columns[0].equals("Date")){
                    continue;
                }
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                Date date = null;
                try {
                    date = simpleDateFormat.parse(columns[0]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //new Date(columns[0]);
                String type = columns[1];
                String name = columns[2].replaceAll("'","");
                String memo = columns[3];

                Double amount = new Double(String.valueOf(columns[4]));
                CreditCardTransaction creditCardTransaction = new CreditCardTransaction(date, type, name, memo, amount);
                creditCardTransactions.add(creditCardTransaction);
            }
        }
        return creditCardTransactions;
    }

    public ArrayList<CreditUnionAccountTransaction> parseFirstTechAccountFile(String path) throws IOException {
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
        ArrayList<CreditUnionAccountTransaction> transactions = new ArrayList<>();
        Object[] array = new FileReader().readInFile(path);
        if (array != null) {
            for(Object line : array){
                String stringLine = (String)line;
                String[] columns = stringLine.split("\",\"");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
                if(columns[0].equals("\"Transaction ID")){
                    continue;
                }


                String transactionId = columns[0].replace("\"","");
                Date postingDate = null;
                Date effectiveDate = null;
                try {
                    postingDate = simpleDateFormat.parse(columns[1]);
                    effectiveDate = simpleDateFormat.parse(columns[2]);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String transactionType = columns[3];
                Double amount = new Double(String.valueOf(columns[4]));
                String checkNumber = columns[5];
                String referenceNumber = columns[6];
                String payee = columns[7];
                String memo = columns[8];
                String transactionCategory = columns[9];
                String type = columns[10];
                Double balance = new Double(String.valueOf(columns[11]).replace("\"",""));

                CreditUnionAccountTransaction transaction = new CreditUnionAccountTransaction(transactionId, postingDate, effectiveDate, transactionType, amount, checkNumber, referenceNumber, payee, memo, transactionCategory, type, balance);
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
