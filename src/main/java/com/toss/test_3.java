package com.toss;

public class test_3 {
    public boolean solution(String amountText) {
        boolean answer = true;
        if(amountText.length() > 1 && Character.getNumericValue(amountText.charAt(0)) == 0){
            return false;
        }
        if(!isValid(amountText)){
            return false;
        }

        if(!isValid_2(amountText)){
            return false;
        }

        if(!isValid_3(amountText)){
            return false;
        }
        return answer;
    }

    private static boolean isValid(String input) {
        return input.matches("^[0-9,]+$");
    }

    public static boolean isValid_2(String input) {
        return input.matches("^[0-9]+(,[0-9]+)*$");
    }

    public static boolean isValid_3(String input) {
        return input.matches("^[0-9]{1,3}(,[0-9]{3})*$");
    }
}
