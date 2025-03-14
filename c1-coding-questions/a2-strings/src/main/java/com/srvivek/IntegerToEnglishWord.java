package com.srvivek;

public class IntegerToEnglishWord {

    String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    final String HUNDRED = "Hundred";

    String[] thousands = {"", "Thousand", "Million", "Billion", "Trillion"};


    public String integerToEnglish(Integer value) {

        if (value == null ) return "";
        if(value == 0) return "zero";

        int x = value;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(value != 0) {
            if(value % 1000 > 0) {
                String t = helper(value % 1000);
                if(index == 0) {
                    sb.insert(0, t);
                } else {
                    sb.insert(0, t + " " + thousands[index] + (sb.isEmpty() ? "" : " "));
                }
            }
            value /= 1000;
            ++index;
        }

        String word = sb.toString();
        System.out.printf("Input : %d %nOutput: %s%n", x, word);
        return word;
    }

    private String helper(int value) {
        if (value == 0) return "";
        if (value < 20) return belowTwenty[value];
        if(value < 100) return tens[value/10] + " " + helper(value % 10);
        else return belowTwenty[value / 100] + " " + HUNDRED + " " +helper(value % 100);
    }

    public String integerToEnglishImprovedCpuTime(Integer num) {
        if (num == null) return "";

        if(num == 0) {
            return "Zero";
        } else {
            return helperX(num);
        }
    }

    public String helperX(int num) {
        StringBuilder sb = new StringBuilder();

        if(num < 20)
            sb.append(belowTwenty[num]);
        else if(num < 100)
            sb.append(tens[num / 10]).append(" ").append(helperX(num % 10));
        else if(num < 1000)
            sb.append(helperX(num / 100)).append(" Hundred ").append(helperX(num % 100));
        else if(num < 1000000)
            sb.append(helperX(num / 1000)).append(" Thousand ").append(helperX(num % 1000));
        else if(num < 1000000000)
            sb.append(helperX(num / 1000000)).append(" Million ").append(helperX(num % 1000000));
        else
            sb.append(helperX(num / 1000000000)).append(" Billion ").append(helperX(num % 1000000000));

        return sb.toString().trim();
    }
}
