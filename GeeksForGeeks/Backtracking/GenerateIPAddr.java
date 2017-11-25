/*
	https://practice.geeksforgeeks.org/problems/generate-ip-addresses/1
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GenerateIPAddr{

	ArrayList<String> ipAddresses;

	public static void main(String args[]) {		
		GenerateIPAddr generateIpAddr = new GenerateIPAddr();
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		while (--testCases >= 0) {
			String str = in.next();		
			
			System.out.println(genIp(str));			
		}
	}

	public static ArrayList<String> genIp(String s) {
		GenerateIPAddr generateIpAddr = new GenerateIPAddr();
		generateIpAddr.ipAddresses = new ArrayList<String>();		
		generateIpAddr.generate(s, 0, s.length() - 1, 1, new ArrayList<>());
		return generateIpAddr.ipAddresses;
	}

	public boolean generate(String str, int s, int e, int part, ArrayList<Integer> ip) {
		
		if (part == 4) {
			if (e - s > 3) {
				return false;
			} else if (s > e) {
				return false;
			}
			ip.add(Integer.parseInt(str.substring(s, e + 1)));
			if(validateIP(ip, str.length())) {
				ipAddresses.add(getIpAddr(ip));
				ip.remove(ip.size() - 1);
				return true;
			} else {
				ip.remove(ip.size() - 1);
				return false;
			}
		}

		for (int i = s; i < s + 3 && i <= e; i++) {
			ip.add(Integer.parseInt(str.substring(s, i + 1)));
			boolean generated = generate(str, i + 1, e, part + 1, ip);
			ip.remove(ip.size() - 1);			
		}
		return false;	
	}

	public boolean validateIP(ArrayList<Integer> ip, int n) {
		
		//Print IP ADDRESSES

		// for (Integer ipAddr : ip) {
		// 	System.out.print(ipAddr + ".");
		// }
		// System.out.println();

		if (ip.size() != 4) {
			return false;
		}

		if (!checkDigits(ip, n)) {
			return false;
		}

		for (Integer part : ip) {
			if (part < 0 || part > 255) {
				return false;
			}
		}
		return true;
	}

	public String getIpAddr(ArrayList<Integer> ip) {
		StringBuilder sBuilder = new StringBuilder();
		for (Integer part : ip) {
			sBuilder.append(part + ".");
		}
		sBuilder.setLength(sBuilder.length() - 1);
		return sBuilder.toString();
	}

	public boolean checkDigits(ArrayList<Integer> ip, int n) {
		int totalDigits = 0;
		for (Integer ipAddr : ip) {
			if (ipAddr == 0) {
				totalDigits++;
			} else {
				totalDigits += (int) (Math.log10(ipAddr) + 1);	
			}
			
		}
		return totalDigits == n;
	}
}
