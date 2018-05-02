import java.util.*;
import java.lang.*;   
import java.io.*;

class IntegerToEnglishWords {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		IntegerToEnglishWords iew = new IntegerToEnglishWords();
		System.out.println(iew.numberToWords(num));
	}

	int num;
	Map<Integer, String> onesMap = new HashMap<>();
	Map<Integer, String> tensMap = new HashMap<>();
	Map<Integer, String> tysMap = new HashMap<>();

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        this.num = num;
        buildMap();
        int ones = getLastThreeDigits();
        int thousands = getLastThreeDigits();
        int millions = getLastThreeDigits();
        int billions = getLastThreeDigits();

        String onesString = getWords(ones);
        onesString = onesString.isEmpty() ? onesString : onesString.substring(0, onesString.length() - 1);
        String thousandsString = thousands > 0 ? getWords(thousands) + "Thousand" : "";
        String millionsString = millions > 0 ? getWords(millions) + "Million" : "";
        String billionsString = billions > 0 ? getWords(billions) + "Billion" : "";

        if (!billionsString.isEmpty()) {
        	if (!millionsString.isEmpty() || !thousandsString.isEmpty() || !onesString.isEmpty()) {
        		billionsString = billionsString + " ";
        	}
        }

        if (!millionsString.isEmpty()) {
        	if (!thousandsString.isEmpty() || !onesString.isEmpty()) {
        		millionsString = millionsString + " ";
        	}
        }

        if (!thousandsString.isEmpty()) {
        	if (!onesString.isEmpty()) {
        		thousandsString = thousandsString + " ";
        	}
        }

        return billionsString + millionsString + thousandsString + onesString;

    }

    public String getWords(int number) {
		if (tensMap.containsKey(getLastNDigits(number, 2))) {
			String tensString = tensMap.get(getLastNDigits(number, 2)) + " ";
			number = number / 100;
			String hundredsString = onesMap.containsKey(number) ? onesMap.get(number) + " Hundred": "";
			return hundredsString + tensString;
		} else {			
			int ones = getLastNDigits(number, 1);
			number = number - (number % 10);
			int tens = getLastNDigits(number, 2);
			number = number / 100;
			int hundreds = getLastNDigits(number, 1);
			
			String onesString = onesMap.containsKey(ones) ? onesMap.get(ones) + " " : "";
			String tensString = tysMap.containsKey(tens) ? tysMap.get(tens) + " " : "";
			String hundredsString = onesMap.containsKey(hundreds) ? onesMap.get(hundreds) + " Hundred" : "";
			return hundredsString + tensString + onesString;
		}
    }

    public int getLastNDigits(int number, int n) {
    	int digits = 0;
    	for (int i = 0; i < n; i++) {
    		digits += (number % 10) * Math.pow(10, i);
    		number /= 10;
    	}
    	return digits;
    }

    public int getLastThreeDigits() {
    	int threeDigits = 0;
    	for (int i = 0; i < 3; i++) {
    		threeDigits += (num % 10) * Math.pow(10, i);
    		num /= 10;
    	}
    	return threeDigits;
    }

    public void buildMap() {
    	onesMap.put(1, "One");
    	onesMap.put(2, "Two");
    	onesMap.put(3, "Three");
    	onesMap.put(4, "Four");
    	onesMap.put(5, "Five");
    	onesMap.put(6, "Six");
    	onesMap.put(7, "Seven");
    	onesMap.put(8, "Eight");
    	onesMap.put(9, "Nine");

    	tensMap.put(10, "Ten");
    	tensMap.put(11, "Eleven");
    	tensMap.put(12, "Twelve");
    	tensMap.put(13, "Thirteen");
    	tensMap.put(14, "Fourteen");
    	tensMap.put(15, "Fifteen");
    	tensMap.put(16, "Sixteen");
    	tensMap.put(17, "Seventeen");
    	tensMap.put(18, "Eighteen");
    	tensMap.put(19, "Nineteen");

		tysMap.put(20, "Twenty");
		tysMap.put(30, "Thirty");
		tysMap.put(40, "Forty");
		tysMap.put(50, "Fifty");
		tysMap.put(60, "Sixty");
		tysMap.put(70, "Seventy");
		tysMap.put(80, "Eighty");
		tysMap.put(90, "Ninety");
    }
}