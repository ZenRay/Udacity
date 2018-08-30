/**
 * Date:2018/08/29
 * Purpose: Course ud283 about Inheritance
 */

class BankAccount {
    public String account;
    public int balance;

    // constructor
    BankAccount() {
        this.account = "";
        this.balance = 0;
    }

    BankAccount(String bankAccount, int bankBalance){
        this.account = bankAccount;
        this.balance = bankBalance;
    }
}


class CheckingAccount extends BankAccount{
    int limit;
}

class SavingAccount extends BankAccount {

}

class CertificateOfDeposit extends BankAccount {

}