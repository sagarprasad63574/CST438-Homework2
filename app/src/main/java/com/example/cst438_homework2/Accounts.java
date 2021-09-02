package com.example.cst438_homework2;

import java.util.ArrayList;
import java.util.List;

public class Accounts {
    public static final List <Accounts> accounts = new ArrayList<>();
    //username, password, userID

    public String username;
    public String password;
    public int userId;
    static int userID = 1;

    public Accounts(String username, String password) {
        this.username = username;
        this.password = password;
        userId+=userID;
        userID+=1;
    }

    public static void createAccounts(){
        accounts.add(new Accounts("bob", "bob123"));
        accounts.add(new Accounts("alice", "alice123"));
        accounts.add(new Accounts("tom", "tom123"));
        accounts.add(new Accounts("bret", "bret123"));
        accounts.add(new Accounts("antonette", "antonette123"));
        accounts.add(new Accounts("samantha", "samantha123"));
        accounts.add(new Accounts("karianne", "karianne123"));
        accounts.add(new Accounts("kamren", "kamren123"));
        accounts.add(new Accounts("elwyn.skiles", "elwyn.skiles123"));
        accounts.add(new Accounts("maxime_nienow", "maxime_nienow123"));
    }

    public static Accounts getByUsername(String username) {
        for(Accounts a: accounts) {
            if(a.username.equals(username)) {
                return a;
            }

        }
        return null;
    }

    public static Accounts getByPassword(String password) {
        for(Accounts a:accounts) {
            if(a.password.equals(password)) {
                return a;
            }
        }
        return null;
    }

}

