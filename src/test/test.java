package test;

import java.util.Scanner;

public class test {
	public static Integer elevar(Integer num, Integer vezes) {
	    Integer novoNum = 1;
		for (int i = 0; i < vezes; i++) {
	    	novoNum = novoNum * num;
	    }
		return novoNum;
    }
	
	public static void print(String msg) {
		System.out.println(msg);
	}
	
	public static void operacoes() {
		Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a number");

        int n1 = myObj.nextInt();
        myObj.nextLine(); // Consume the newline character left by nextInt()
        System.out.println("Enter the operation");
        String op = myObj.nextLine();
        System.out.println("Enter another number");
        int n2 = myObj.nextInt();
        String n3 = "";

        if (op.equals("+")) {
            n3 = Integer.toString(n1 + n2);
        } else if (op.equals("-")) {
            n3 = Integer.toString(n1 - n2);
        } else if (op.equals("*")) {
            n3 = Integer.toString(n1 * n2);
        } else if (op.equals("//")) {
            n3 = Integer.toString(n1 / n2);
        } else if (op.equals("^")) {
        	n3 = Integer.toString(elevar(n1, n2));
        } else if (op.equals("/")) {
        	n3 = Float.toString((float) n1 / n2);
        } else if (op.equals("%")) {
        	n3 = Integer.toString(n1 % n2);
        }

        System.out.println(n3);
	}
	
    public static void main(String[] args) {
    	Scanner myObj = new Scanner(System.in);
        Boolean flag = true;
    	while(flag == true) {
        	System.out.println("----------------");
        	System.out.println("1 - Operações (Calculadora Básica)");
        	System.out.println("0 - Sair do Programa");
        	System.out.println("----------------");
        	System.out.println("Item: ");
            Integer op = myObj.nextInt();
            if (op == 1) {
            	operacoes();
            } else {
            	flag = false;
            }
        }
    	print("Programa terminado!");
    }
    
}
