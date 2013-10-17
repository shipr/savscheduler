package org.sav.dao;

public class LoginDao
{
    private static LoginDao instance = new LoginDao();

    public static LoginDao getInstance() {
        return instance;
    }

    public boolean login(String name, String password){

        return true;
    }

}
