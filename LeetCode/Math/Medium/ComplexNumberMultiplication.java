public class Solution {
    public String complexNumberMultiply(String x, String y) {
        String[] n1 = x.split("\\+");
        String[] n2 = y.split("\\+");
        Integer a = Integer.parseInt(n1[0]);
        Integer c = Integer.parseInt(n2[0]);
        String bTemp = "";
        String dTemp = "";

        for (int i = 0; i < n1[1].length(); i++) {
        	if (n1[1].charAt(i) == 'i') {
        		break;
        	}
        	bTemp = bTemp + n1[1].charAt(i);
        }

        for (int i = 0; i < n2[1].length(); i++) {
        	if (n2[1].charAt(i) == 'i') {
        		break;
        	}
        	dTemp = dTemp + n2[1].charAt(i);
        }

        // System.out.println("a = " + a + " b = " + n1[1] + " c = " + c + " d = " + n2[1]);
        // System.out.println("a = " + a + " b = " + bTemp + " c = " + c + " d = " + dTemp);

        Integer b = Integer.parseInt(bTemp);
        Integer d = Integer.parseInt(dTemp);

        Integer o1 = (a * c) - (b * d);
        Integer o2 = (b * c) + (a * d);
        String o = o1 + "+" + o2 + "i";
        return o;
    }
}