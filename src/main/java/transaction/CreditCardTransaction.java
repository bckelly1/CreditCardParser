package transaction;

import java.util.Date;
/**
 * Created by Brian on 10/1/2016.
 *
 */
public class CreditCardTransaction {
    private Date Date;
    private String TransactionType;
    private String Name;
    private String Memo;
    private double Amount;
    public CreditCardTransaction(Date date, String transactionType, String name, String memo, double amount) {
        Date = date;
        TransactionType = transactionType;
        Name = name;
        Memo = memo;
        Amount = amount;
    }

    public Date getDate() {
        return Date;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public String getName() {
        return Name;
    }

    public String getMemo() {
        return Memo;
    }

    public double getAmount() {
        return Amount;
    }
}
