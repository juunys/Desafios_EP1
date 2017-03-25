import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine();
		
		while(n > 0) {
			
			n--;
			String line = sc.nextLine();
			String[] input = line.split(" ");
			
			int k = Integer.parseInt(input[1]);
			
			//método que faz alguma coisa
		}
	}
}
