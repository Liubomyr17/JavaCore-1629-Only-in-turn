package com.company;

/*

1629 Only in turn

1. In the Solution class, create a public static Read3Strings thread class inheriting from Thread.
2. In the run method, read three lines from the console.
3. Three consecutively entered lines should be read in one thread and combined into one line through a space.
4. In the main method, display the result for each thread.
5. Use join.
Example:
Input data
a
b
c
d
e
f
Output:
a b c
d e f

Requirements:
1. Declare Read3Strings class in the Solution public static class.
2. The Read3Strings class must be inherited from Thread.
3. The run method of the Read3Strings class should read three lines.
4. The Read3Strings class must contain the public printResult method.
5. The printResult method should print the read lines to the console 3, separating them with spaces.
6. The main method should call the start methods on the created threads.
7. The main method should call the join methods on the created threads.
8. The output of the program should indicate that the threads read the lines sequentially, and not in parallel.


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        t1.printResult();
        System.out.println();
        t2.printResult();
    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        public String[] lst = new String[3];

        @Override
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    lst[i] = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void printResult() {
            for (int i = 0; i < lst.length; i++) {
                System.out.print(lst[i] + " ");
            }
        }
    }
}





