package common;

import java.util.ArrayList;

/**
 * Created by Brian on 10/22/2016.
 */
public class CommonBankAccountStrings {
    //Deposits
    static String CA_DIRECT_DEPOSIT = "ACH DEPOSIT CA";
    static String KEYSIGHT_DIRECT_DEPOSIT = "ACH DEPOSIT KEYSIGHT TECH";
    static String CO_TAX_RETURN= "ACH Deposit CO DEPT REVENUE";
    static String FED_TAX_RETURN = "ACH DEPOSIT IRS";
    static String PAYPAL_DEPOSIT = "ACH Deposit PAYPAL";
    static String PAYPAL_CREDIT = "Credit PAYPAL";
    static String CREDIT_DIVIDEND = "Credit Dividend";
    static String CREDIT_CSU_BOOKSTORE = "Credit%CSU BOOKSTORE";
    static String DEPOSIT_TRANSFER_FROM = "Deposit%Transfer From";

    //WITHDRAWAL
    static String WITHDRAWAL_TO_60537700 = "Withdrawal%60537700";
    static String WITHDRAWAL_TO_60537701 = "Withdrawal%60537701";
    static String WITHDRAWAL_TO_607476900 = "Withdrawal%607476900";
    static String WITHDRAWAL_TO_9318963783 = "Withdrawal%9318963783";
    static String WITHDRAWAL_TO_9327080637 = "Withdrawal%9327080637";
    static String WITHDRAWAL_TO_9327082633 = "Withdrawal%9327082633";
    static String WITHDRAWAL_TO_9327278371 = "Withdrawal%9327278371";
    static String ATM_WITHDRAWAL = "ATM Withdrawal";

    //PAYMENTS
    static String STATE_FARM = "ACH Debit STATE FARM";
    static String CARDMEMBER_SERV = "ACH Debit CARDMEMBER SERV";
    static String DISCOVER_CARD = "ACH Debit DISCOVER DC";
    static String FORT_COLLINS_UTILITIES = "ACH Debit FORTCOLUTILITIES";
    static String EVERGREEN_PROPERTY_MANAGEMENT = "ACH Debit Evergreen Proper";
    static String DEPT_EDUCATION_LOAN = "ACH Debit DEPT EDUCATION";
    static String CSU_TUITION = "ACH Debit COLO STATE UNIV";
    static String ATM_DEPOSIT = "ATM Deposit";
    static String POS_VESTA = "POS Transaction%VESTA";//old blue cell phone
    static String CHECK_NUMBER = "Check #";


    //FOOD
    static String POS_TOYS_THAI = "POS Transaction%TOY*S THAI CAFE";
    static String POS_HUHOT = "POS Transaction%HUHOT";
    static String POS_COOPERSMITHS = "POS Transaction%COOPERSMITHS";
    static String POS_YUM_YUM = "POS Transaction%YUM YUM";
    static String POS_PANDA_EXPRESS = "POS Transaction%PANDA EXPRESS";
    static String POS_NOODLES = "POS Transaction%NOODLES";
    static String POS_COLLEGE_CAFE = "POS Transaction%COLLEGE CAFE";
    static String POS_YUNGS = "POS Transaction%YUNGS";

    //GAS
    static String POS_KING_SOOPERS_FUEL = "POS Transaction%KING SOOPERS%FUEL";

    //POS PURCHASES
    static String POS_TARGET = "POS Transaction%TARGET";
    static String POS_CORNER_STORE = "POS Transaction%CORNER STORE";
    static String POS_AMAZON = "POS Transaction%AMAZON";
    static String POS_OFFICE_DEPOT = "POS Transaction%OFFICE DEPOT";
    static String POS_ADVANCED_AUTO_PARTS = "POS Transaction%ADVANCE";//Advanced Auto parts
    static String POS_AUTO_ZONE = "POS Transaction%AutoZone";
    static String POS_FAMOUS_FOOTWEAR = "POS Transaction%FAMOUS FOOTWEAR";
    static String POS_THE_MENS_WEARHOUSE = "POS Transaction%THE MENS WEARHOUSE";
    static String POS_ALS_FORMAL_WEAR = "POS Transaction%AL*S FORMAL WEAR";
    static String POS_SAFEWAY = "POS Transaction%SAFEWAY";
    static String POS_KING_SOOPERS = "POS Transaction%KING SOOPERS";
    static String POS_WALMART = "POS Transaction%Wal-Mart";
    static String POS_HOME_DEPOT = "POS Transaction%HOME DEPOT";
    static String POS_NEWEGG = "POS Transaction%NEWEGG";
    static String POS_STEAMPOWERED = "POS Transaction%STEAMPOWERED";
    static String POS_UBISOFT = "POS Transaction%UBISOFT";
    static String POS_CINEMARK = "POS Transaction%CINEMARK";
    static String POS_EVERGREEN_PROPERTY = "POS Transaction%EVERGREEN PROPERTY";
    static String POS_CSU = "POS Transaction%CSU";
    static String POS_CARMIKE = "POS Transaction%CARMIKE";
    static String POS_CENTURYLINK = "POS Transaction%CENTURYLINK";
    static String POS_WASH_TIME = "POS Transaction%WASH TIME";
    static String POS_HARVARD_BUSINESS = "POS Transaction%HARVARD BUSNSS";

    //ACH DEBITS
    static String ACH_DEBIT_CHASE = "ACH Debit%CHASE";
    static String ACH_DEBIT_TELEPHONE = "ACH Debit%TELEPHONE";
    static String ACH_DEBIT_PAYPAL = "ACH Debit%PAYPAL";
    static String ACH_DEBIT_STUDENT_LOAN = "ACH Debit%STUDNTLOAN";
    static String ACH_DEBIT_ELEVATIONS = "ACH Debit%ELEVATIONS CREDIT UNION";

    //EXTRA STUFF
    static String DESCRIPTIVE_WITHDRAWAL_ATM = "Descriptive Withdrawal  ATM dep cor:08 27 14:K4084:6862: Miskey 40.50 S B 40.00";
    static String DEPOSIT = "Deposit";
    static String DESCRIPTIVE_WITHDRAWAL_CAR = "Descriptive Withdrawal  car";
    static String DESCRIPTIVE_WITHDRAWAL_OLB = "Descriptive Withdrawal OLB External Transfer";
    static String NSF_RETURNED_ITEMS = "NSF/Returned Items";
    static String OVERDRAFT_TRANSFER = "Overdraft Transfer";
    static String POS_CAUS = "POS Transaction  2211 North First StreetSan Jose     CAUS";



    public static ArrayList<String> getPurchases(){
        ArrayList<String> purchases = new ArrayList<>();
        purchases.add(POS_OFFICE_DEPOT);
        purchases.add(POS_ADVANCED_AUTO_PARTS);
        purchases.add(POS_AMAZON);
        purchases.add(POS_CORNER_STORE);
        purchases.add(POS_TARGET);
        purchases.add(POS_AUTO_ZONE);
        purchases.add(POS_FAMOUS_FOOTWEAR);
        purchases.add(POS_SAFEWAY);
        purchases.add(POS_HOME_DEPOT);
        purchases.add(POS_NEWEGG);
        purchases.add(POS_UBISOFT);
        purchases.add(POS_CINEMARK);
        purchases.add(POS_EVERGREEN_PROPERTY);
        purchases.add(POS_ALS_FORMAL_WEAR);
        purchases.add(POS_STEAMPOWERED);
        purchases.add(POS_CSU);
        purchases.add(POS_CARMIKE);
        purchases.add(POS_CENTURYLINK);
        purchases.add(POS_KING_SOOPERS);
        purchases.add(POS_THE_MENS_WEARHOUSE);
        purchases.add(POS_WASH_TIME);
        purchases.add(POS_HARVARD_BUSINESS);
        purchases.add(POS_WALMART);
        return purchases;
    }

    public static ArrayList<String> getPaymentsTransactions(){
        ArrayList<String> paymentsTransactions = new ArrayList<>();
        paymentsTransactions.add(STATE_FARM);
        paymentsTransactions.add(CARDMEMBER_SERV);
        paymentsTransactions.add(DISCOVER_CARD);
        paymentsTransactions.add(FORT_COLLINS_UTILITIES);
        paymentsTransactions.add(EVERGREEN_PROPERTY_MANAGEMENT);
        paymentsTransactions.add(CSU_TUITION);
        paymentsTransactions.add(ATM_DEPOSIT);
        paymentsTransactions.add(POS_VESTA);
        paymentsTransactions.add(CHECK_NUMBER);
        paymentsTransactions.add(DEPT_EDUCATION_LOAN);
        return paymentsTransactions;
    }

    public static ArrayList<String> getFoodTransactions(){
        ArrayList<String> foodTransactions = new ArrayList<>();
        foodTransactions.add(POS_TOYS_THAI);
        foodTransactions.add(POS_NOODLES);
        foodTransactions.add(POS_HUHOT);
        foodTransactions.add(POS_COOPERSMITHS);
        foodTransactions.add(POS_YUM_YUM);
        foodTransactions.add(POS_PANDA_EXPRESS);
        foodTransactions.add(POS_COLLEGE_CAFE);
        foodTransactions.add(POS_YUNGS);
        return foodTransactions;
    }

    public static ArrayList<String> getGasTransactions(){
        ArrayList<String> gasTransactions = new ArrayList<>();
        gasTransactions.add(POS_KING_SOOPERS_FUEL);
        return gasTransactions;
    }

    public static ArrayList<String> getWithdrawalsTransactions(){
        ArrayList<String> withdrawalTransactions = new ArrayList<>();
        withdrawalTransactions.add(WITHDRAWAL_TO_60537700);
        withdrawalTransactions.add(WITHDRAWAL_TO_60537701);
        withdrawalTransactions.add(WITHDRAWAL_TO_607476900);
        withdrawalTransactions.add(WITHDRAWAL_TO_9318963783);
        withdrawalTransactions.add(WITHDRAWAL_TO_9327080637);
        withdrawalTransactions.add(WITHDRAWAL_TO_9327082633);
        withdrawalTransactions.add(WITHDRAWAL_TO_9327278371);
        withdrawalTransactions.add(ATM_WITHDRAWAL);
        return withdrawalTransactions;
    }

    public static ArrayList<String> getAchDebits(){
        ArrayList<String> achDebits = new ArrayList<>();
        achDebits.add(ACH_DEBIT_CHASE);
        achDebits.add(ACH_DEBIT_TELEPHONE);
        achDebits.add(ACH_DEBIT_PAYPAL);
        achDebits.add(ACH_DEBIT_STUDENT_LOAN);
        achDebits.add(ACH_DEBIT_ELEVATIONS);
        return achDebits;
    }

    public static ArrayList<String> getDepositsTransactions(){
        ArrayList<String> depositsTransactions = new ArrayList<>();
        depositsTransactions.add(CA_DIRECT_DEPOSIT);
        depositsTransactions.add(KEYSIGHT_DIRECT_DEPOSIT);
        depositsTransactions.add(CO_TAX_RETURN);
        depositsTransactions.add(FED_TAX_RETURN);
        depositsTransactions.add(PAYPAL_CREDIT);
        depositsTransactions.add(PAYPAL_DEPOSIT);
        depositsTransactions.add(CREDIT_DIVIDEND);
        depositsTransactions.add(CREDIT_CSU_BOOKSTORE);
        depositsTransactions.add(DEPOSIT_TRANSFER_FROM);
        return depositsTransactions;
    }

    public static ArrayList<String> getExtraTransactions(){
        ArrayList<String> extraTransactions = new ArrayList<>();
        extraTransactions.add(DESCRIPTIVE_WITHDRAWAL_ATM);
        extraTransactions.add(DESCRIPTIVE_WITHDRAWAL_CAR);
        extraTransactions.add(DESCRIPTIVE_WITHDRAWAL_OLB);
        extraTransactions.add(DEPOSIT);
        extraTransactions.add(NSF_RETURNED_ITEMS);
        extraTransactions.add(POS_CAUS);
        extraTransactions.add(OVERDRAFT_TRANSFER);
        return extraTransactions;
    }

}
