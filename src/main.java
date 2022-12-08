
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Decode.BWT;
import Decode.MoveToFront;
import Encode.ArithmeticCoding;

public class main {
    public static void main (String[] args) throws FileNotFoundException {
    	
        Scanner sc = new Scanner(System.in);
        System.out.println("Пожалуйста выберите функцию (1/2)");
        System.out.println("1 - Арифметическое кодирование");
        System.out.println("2 - Декодирование");
        int firstCh = sc.nextInt();
        while(firstCh != 1 & firstCh != 2) {
            System.out.println("Пожалуйста, введите '1' или '2'");
            firstCh = sc.nextInt();
        }
        if(firstCh == 1) {
        	encode();
        }   else {
	        	System.out.println("Пожалуйста выберите функцию (1/2/3)");
	            System.out.println("1 - Декодирование с помощью алгоритма 'Стопка книг'");
	            System.out.println("2 - Декодирование с помощью преобразование Барроуза-Уилера");
	            System.out.println("3 - Декодирование с помощью преобразование Барроуза-Уилера + 'Стопка книг'");
	            int secondCh = sc.nextInt();
	            while(secondCh != 1 & secondCh != 2 & secondCh != 3) {
	                System.out.println("Пожалуйста, введите '1' или '2' или '3'");
	                secondCh = sc.nextInt();
	            }
	            if(secondCh == 1) {
	            	decodeMTF();
	            } else if(secondCh == 2) {
	            	decodeBWT();
	            }else {
	            	decodeBWTMTF();
	            }
        	}
    }
    
    public static  void encode() throws FileNotFoundException {
    	
        ArithmeticCoding arithmeticCoding = new ArithmeticCoding();
    	 Scanner scanner = new Scanner(new File("src/encodeFile.txt"));
         String s = scanner.nextLine();
         char[] letters = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
         double[] probability = new double[letters.length];        
         for (int i = 0; i < letters.length; i++) {
         	probability[i] = scanner.nextDouble();
         }
         System.out.println("Результат кодирования: " + arithmeticCoding.arithmeticCoding(letters,probability,s));
         System.out.println("Длина исходной строки: " + s.length());
    }
    
    public static void decodeMTF() throws FileNotFoundException {
    	MoveToFront moveToFront = new MoveToFront();
    	Scanner scanner = new Scanner(new File("src/decodeMTFFile.txt"));
    	List<Integer> list = new LinkedList<>();
        while(scanner.hasNextInt()) {
        	list.add(scanner.nextInt());
        }
        scanner.nextLine();
    	String symTable = scanner.nextLine().replaceAll("\\s+", "");
        System.out.println("Результат декодирования: " + moveToFront.decode(list, symTable));
    }
    
    public static void decodeBWT() throws FileNotFoundException {
    	BWT bwt = new BWT();
    	Scanner scanner = new Scanner(new File("src/decodeBWTFile.txt"));
		String s = scanner.nextLine();
		int encNum =scanner.nextInt();
		System.out.println("Результат декодирования: " + bwt.decode(s, encNum - 1));
    }
    public static void decodeBWTMTF() throws FileNotFoundException {
    	BWT bwt = new BWT();
    	MoveToFront moveToFront = new MoveToFront();
    	Scanner scanner = new Scanner(new File("src/decodeBWTMTFFile.txt"));
    	List<Integer> list = new LinkedList<>();
        while(scanner.hasNextInt()) {
        	list.add(scanner.nextInt());
        }
        scanner.nextLine();
        String symTable = scanner.nextLine().replaceAll("\\s+", "");
        int encNum =scanner.nextInt();
        String stringForBWT =  moveToFront.decode(list, symTable);
		System.out.println("Результат декодирования: " + bwt.decode(stringForBWT, encNum - 1));
    }
}
