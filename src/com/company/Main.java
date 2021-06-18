package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static Float ProcessLine(String line)
    {
        Pattern pattern = Pattern.compile("[/*\\-+]");
        Matcher matcher = pattern.matcher(line);
        float a = 0;
        float b = 0;
        int x1 = 0;
        int x2 = 0;
        while (matcher.find())
        {
            x1 = matcher.start();
            x2 = matcher.end();
        }
        a = Float.parseFloat(line.substring(0, x1));
        b = Float.parseFloat(line.substring(x2, line.length()));
        switch (line.substring(x1,x2))
        {
            case "-" -> {
                return a-b;
            }
            case "+" -> {
                return a+b;
            }
            case "/" -> {
                return a/b;
            }
            case "*" -> {
                return a*b;
            }
        }

        return null;

    }
    public static void main(String[] args) {
        try
        {
            File myObj = new File("./filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.printf("%s = %f\n",data,ProcessLine(data));
            }
                myReader.close();
        }
        catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
        }
    }
}
