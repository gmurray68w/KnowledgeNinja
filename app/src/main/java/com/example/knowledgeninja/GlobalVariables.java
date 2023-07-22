package com.example.knowledgeninja;

import java.util.ArrayList;
import java.util.List;

public class GlobalVariables {
    private static GlobalVariables instance;
    private List<Integer> checkedValues;

    private GlobalVariables(){
        checkedValues = new ArrayList<>();
    }
    public static synchronized GlobalVariables getInstance(){
        if(instance == null){
            instance = new GlobalVariables();
        }
        return instance;
    }

    public List<Integer> getCheckedValues(){
        return checkedValues;
    }
    public void setCheckboxValues(List<Integer> values) {
        checkedValues = values;
    }
}
