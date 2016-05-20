package com.example.cristobal.i_lender_u;

/**
 * Created by cristobal on 5/19/16.
 */
public class DataProvider {

    private String name;
    private String who;

    public DataProvider(String name,String who){
        this.name=name;
        this.who=who;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }
}
