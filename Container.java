package com.company;

public class Container {

    private Box[] boxes = new Box[3];
    private int number_of_boxes = 0;

    public Container(){}

    public Container(int new_number_of_boxes){
        if (new_number_of_boxes > 2){
            this.boxes = new Box[new_number_of_boxes];
        }
    }


    public boolean IsContainerFull(){
        if (number_of_boxes < boxes.length){
            return false;
        }
        return true;
    }

    public int getNumber_of_boxes(){
        return number_of_boxes;
    }

    public int getMaximum(){
        return boxes.length;
    }

    public void InsertBox(Box box){
        boolean check = IsContainerFull();
        if (!check){
            boxes[number_of_boxes] = box;
            number_of_boxes++;
        }else
            System.out.println("There is no more room for boxes in this container");

    }

    public double getTotalValue(){
        double total = 0;
        for (int i = 0; i < boxes.length; i++){
            total += boxes[i].getValue();
        }
        return total;
    }

    public double getTotalWeight(){
        double total = 0;
        for (int i = 0; i < boxes.length; i++){
            total += boxes[i].getWeight();
        }
        return total;
    }

    public String getManifest(){
        String s = "";
        for (int i = 0; i < number_of_boxes; i++){
           //System.out.println(boxes[i].getContents() + "   " + boxes[i].getWeight() + "   " + boxes[i].getValue());
            s += String.format(boxes[i].getContents() + "%10.2f %10.2f\n", boxes[i].getWeight(), boxes[i].getValue());
        }
        return s;
    }
}
