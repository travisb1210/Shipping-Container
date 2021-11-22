// Travis Broussard
// C00150007
// CMPS 260
// Programming Assignment : #4
// Due Date : 10/28/2019
// Program Description: This program simulates boxes being sorted and loaded into a shipping container
// Certificate of Authenticity:

// I certify that the code in this project is, other than code provided by the instructor or that was
// created by Intellij, entirely my own work.

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner input = new Scanner(System.in);

        int selection;
        int container_selection;

        Container c1;
        Container c2;
        Container c3;

        System.out.println("Add the boxes to the correct container, discarding any boxes that \n" +
                "belong to a container that is full or a box that does not belong to \n" +
                "any container.  Apples go in one container, oranges go in another \n" +
                "container and lemons go in yet another container.  It does not matter \n" +
                "which container contains a particular type of fruit, but a container \n" +
                "must contain only one type of fruit.  It is up to you to remember \n" +
                "which container is correct.  Discard boxes that contain any other \n" +
                "items. \n");

        System.out.print("Enter the capacity for the first container (>2): ");
        int size1 = input.nextInt();
        System.out.print("Enter the capacity of the second container (>2): ");
        int size2 = input.nextInt();
        System.out.print("Enter the capacity of the third container (>2): ");
        int size3 = input.nextInt();
        System.out.println();

        c1 = new Container(size1);
        c2 = new Container(size2);
        c3 = new Container(size3);

        do {
            System.out.print("1-Get a box, 2-halt): ");
            selection = input.nextInt();
            if (selection == 2){
                break;
            }
            while (selection < 0 || selection > 2) {
                System.out.println("Invalid Selection");
                System.out.println();
                System.out.print("1-Get a box, 2-halt): ");
                selection = input.nextInt();
            }
            System.out.println("Container 1: Boxes-" + c1.getNumber_of_boxes() + " Max Boxes-" + c1.getMaximum());
            System.out.println("Container 2: Boxes-" + c2.getNumber_of_boxes() + " Max Boxes-" + c2.getMaximum());
            System.out.println("Container 3: Boxes-" + c3.getNumber_of_boxes() + " Max Boxes-" + c3.getMaximum());
            if (selection == 1) {
                Box box = Box.randomBox();
                System.out.println("New box: " + box.getContents());
                System.out.print("Place in container number? (-1 discards the box): ");
                container_selection = input.nextInt();
                while (container_selection < -1 || container_selection > 3){
                    System.out.println("Invalid selection");
                    System.out.print("Place in container number? (-1 discards the box): ");
                    container_selection = input.nextInt();
                }
                if (container_selection != -1) {
                    if (container_selection == 1) {
                        c1.InsertBox(box);
                        System.out.println();
                    }
                    if (container_selection == 2) {
                        c2.InsertBox(box);
                        System.out.println();
                    }
                    if (container_selection == 3) {
                        c3.InsertBox(box);
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
        while (selection == 1 && selection != 2);

        System.out.println();

        System.out.println("Container 1 Manifest:");
        System.out.println("Contents" + "   " + "Weight" + "     " + "Value");
        System.out.print(c1.getManifest());
        System.out.println();

        System.out.println("Container 2 Manifest:");
        System.out.println("Contents" + "    " + "Weight" + "     " + "Value");
        System.out.print(c2.getManifest());
        System.out.println();

        System.out.println("Container 3 Manifest:");
        System.out.println("Contents" + "   " + "Weight" + "     " + "Value");
        System.out.print(c3.getManifest());
        System.out.println();

        System.out.println("Container 1 Total Weight and Value: $" + c1.getTotalValue() + ", " + c1.getTotalWeight() + " pounds");
        System.out.println("Container 2 Total Weight and Value: $" + c2.getTotalValue() + ", " + c2.getTotalWeight() + " pounds");
        System.out.println("Container 3 Total Weight and Value: $" + c3.getTotalValue() + ", " + c3.getTotalWeight() + " pounds");

    }
}


