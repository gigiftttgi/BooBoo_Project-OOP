package com.booboo.CAREN.Parser;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, SyntaxError {
        FileReader f = new FileReader("C:/Users/myonl/BooBoo-1/src/grammar/test.txt");
        Scanner reader = new Scanner(f);
        do {
            // String l = reader.nextLine();
            // System.out.println(l);
            // Expressionparse e = new Expressionparse(l);
            // e.statementParse().evaluate(); 
            // System.out.println("\n--------------------");
        } while (reader.hasNextLine());
    }
}
