import java.util.Scanner;


public class Main {
        //maior substring 
        static int sub = 0;
        
        //abca
        public static int palindromePairKum(String word, int k, int len) {
            int lendiv = len/2;
            int i = (lendiv-1);
             if (word.charAt(i) != word.charAt(lendiv)) {
                sub = 3;
                return sub;
            }
            while ((i >= 0) && (k >= 0) && (lendiv < len)) {
                    if ((word.charAt(i) != word.charAt(lendiv)) && (k > 0)) {
                        k--;
                        sub = sub+2;
                    }   
                    else if (word.charAt(i) == word.charAt(lendiv)) {
                        sub = sub+2;
                    }
                    i--;
                    lendiv++;
                }
            return sub;
        }
       
        public static int palindromeOdd(String word, int k, int len) {
            int lendiv = len/2;
            int i = (lendiv-1);
            while ((i >= 0) && (k >= 0) && (lendiv < len)) {
              //  abcdb
                    //System.out.println(i + " " + lendiv);
                    //System.out.println (word.charAt(i) + " "+ word.charAt(lendiv));
                    if ((word.charAt(i) != word.charAt(lendiv+1)) && (k > 0)) {
                        k--;
                        sub = sub+2;
                    }
                    else if (word.charAt(i) == word.charAt(lendiv+1)) {
                        sub = sub+2;
                    }    
                    i--;
                    lendiv++;
                }
            //acrescenta o caracter central
            sub++;
            return sub;
        }
	
        public static int palindrome(String word, int k, int len) {
            //abacddcaab 1
            //asddsa
            //nacabb
            int lendiv = len/2;
            int i = (lendiv-1);

                while ((i >= 0) && (k >= 0) && (lendiv < len)) {
                    //System.out.println(i + " " + lendiv);
                    //System.out.println (word.charAt(i) + " "+ word.charAt(lendiv));
                    
                    //se os chars sao diferentes mas existe k
                    if ((word.charAt(i) != word.charAt(lendiv)) && (k > 0)) {
                        k--;
                        sub = sub+2;
                    }   
                    
                    //se chars sao iguais
                    else if (word.charAt(i) == word.charAt(lendiv)) {
                        sub = sub+2;
                    }
                    i--;
                    lendiv++;
                }
            return sub;
        }
	
	public static void main(String[] args){
                //  long tempoInicio = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
                int T = Integer.parseInt(sc.nextLine());
                
                while (T > 0) {
                    T--;
                    sub = 0;
                    String s = sc.nextLine();
                    String [] line = s.split(" ");
                    int k = Integer.parseInt(line[1]);
                    String word = line[0];
                    int len = word.length();
                    //comprimento par
                    if (len%2 == 0) {
                        switch (k) {
                            case 1:
                                System.out.println(palindromePairKum(word, k, len));
                                break;
                            default:
                                System.out.println(palindrome(word, k, len));
                                break;
                        }
                    }
                    //comprimento impar
                    else {
                        palindromeOdd(word, k, len);
                    }
                    
                }
               // System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));


        }
}
