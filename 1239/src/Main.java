import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		while(n > 0) {
			String line = sc.nextLine();
			String[] input = line.split(" ");
			
			int k = Integer.parseInt(input[1]);
			String word = input[0];
			//char[] word = line.toCharArray();
			//do something
			int result = palindrome(word, k, 0, line.length()-1);
			n--;
			
			System.out.println(line + " " + result);
		}
	}
	
	public static int palindrome(String word, int k, int begin, int end) {
		if(word.length() == 1 || begin >= end) return 1;
		int result = -1;
		int i = 0;
		int n = word.length() -1;
		char[] subs_word = word.toCharArray(); // Usado pra não alterar o original, caso precise analisar as substrings.
		int subs_k = k; //igual ao subs_word
		boolean reduce = false; // boolean usado para verificar se será necessário analisar as substrings.
		
		while(i <= n) {
			if(subs_word[i] != subs_word[n]) {
				if(subs_k > 0) {
					subs_word[i] = subs_word[n];
					subs_k--;
				} else {
					reduce = true;
					break;
				}
			}
			
			i++;
			n--;
		}
		
		if(!reduce) {
			result = word.length();
			return result;
		} else {
			int result1 = palindrome(word.substring(begin, end-1), k, begin, end-1);
			int result2 = palindrome(word.substring(begin+1, end), k, begin+1, end);
			if(result1 >= result2) result = result1;
			else result = result2;
			
			return result;
		}
	}
}
