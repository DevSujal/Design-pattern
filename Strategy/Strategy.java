import java.util.*;

interface SortingTechniques{
  void sort();
}

class BubbleSort implements SortingTechniques{
  public void sort(){
    System.out.println("You are in Bubble sort");
  }
}

class SelectionSort implements SortingTechniques{
  public void sort(){
    System.out.println("You are in Selection sort");
  }
}

class InsertionSort implements SortingTechniques{
  public void sort(){
    System.out.println("You are in Insertion sort");
  }
}

class QuickSort implements SortingTechniques{
  public void sort(){
    System.out.println("You are in Quick sort");
  }
}

class MergeSort implements SortingTechniques{
  public void sort(){
    System.out.println("You are in Merge sort");
  }
}

public class Strategy{
  public static void main(String[] args){
    SortingTechniques b = new BubbleSort();
    b.sort();
  }
}