package com.example.cst438_homework2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    //This test shows a valid username
    @Test
    public void usernameTestTrue (){
        Accounts test = null;
        test.createAccounts();
        test = Accounts.getByUsername("bob");
        assertNotNull(test);
    }

    //This test shows a invalid username
    @Test
    public void usernameTestFalse () {
        Accounts test = null;
        test.createAccounts();
        test = Accounts.getByUsername("john");
        assertNull(test);

    }

    //This test shows a valid password
    @Test
    public void passwordTestTrue () {
        Accounts test = null;
        test.createAccounts();
        test = Accounts.getByPassword("bob123");
        assertNotNull(test);
    }

    //This test shows a invalid password
    @Test
    public void passwordTestFalse () {
        Accounts test = null;
        test.createAccounts();
        test = Accounts.getByPassword("john123");
        assertNull(test);
    }
}