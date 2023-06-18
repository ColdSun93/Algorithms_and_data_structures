package hw_3;

public class Linked_list {

    public static void main(String[] args) {
        List list = new List();
        for (int i = 10; i >= 1; i--){
            list.pushBack(i);
        }
        
        list.print();
        list.reverse();
        list.print();
    }
}
        