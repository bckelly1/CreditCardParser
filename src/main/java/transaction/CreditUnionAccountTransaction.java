package transaction;

import java.util.Date;

/**
 * Created by Brian on 10/10/2016.
 */
public class CreditUnionAccountTransaction {
    private String TransactionId;
    private Date PostingDate;
    private Date EffectiveDate;
    private String TransactionType;
    private String CheckNumber;
    private String ReferenceNumber;
    private String Payee;
    private String TransactionCategory;
    private String Type;
    private String Memo;
    private double Amount;
    private double Balance;

    public CreditUnionAccountTransaction(String transactionId, Date postingDate, Date effectiveDate, String transactionType, double amount, String checkNumber, String referenceNumber, String payee, String memo, String transactionCategory, String type, double balance) {
        TransactionId = transactionId;
        PostingDate = postingDate;
        EffectiveDate = effectiveDate;
        TransactionType = transactionType;
        Amount = amount;
        CheckNumber = checkNumber;
        ReferenceNumber = referenceNumber;
        Payee = payee;
        Memo = memo;
        TransactionCategory = transactionCategory;
        Type = type;
        Balance = balance;
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public Date getPostingDate() {
        return PostingDate;
    }

    public Date getEffectiveDate() {
        return EffectiveDate;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public String getCheckNumber() {
        return CheckNumber;
    }

    public String getReferenceNumber() {
        return ReferenceNumber;
    }

    public String getPayee() {
        return Payee;
    }

    public String getTransactionCategory() {
        return TransactionCategory;
    }

    public String getType() {
        return Type;
    }

    public String getMemo() {
        return Memo;
    }

    public double getAmount() {
        return Amount;
    }

    public double getBalance() {
        return Balance;
    }
}
