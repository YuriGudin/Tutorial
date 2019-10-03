package starter.list;
/*
* Реализовать List
* */

class Node {
    double value; //Значение
    Node next; //Ссылка на следующий элемент
}

class MyList {

    Node first;
    Node last;
    long count=0;

    //Добавить
    void add(double value){
        if (first == null)
        {
            this.first = new Node();
            this.first.value = value;
        }
        else
        {
            Node end = first;
            while ((end.next) !=null) {
                end = end.next;
            }

            end.next = new Node();
            end.next.value = value;

        }
        count++;
    }

    //Получить  эл-т по индексу
    double get(int index){
        Node temp = first;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return temp.value;
    }

    //Удаление по индексу
    void remove(int index){

        Node temp = first;

        for (int i = 1; i < index-1; i++) {
            temp = temp.next;
        }

        Node left = temp;
        Node right = temp.next.next;
        left.next = right;

        count--;
    }

    long size(){
        return count;
    }
}

public class List {

    public static void main(String[] args) {

        MyList list = new MyList();

        list.add(1.0);
        list.add(22.0);
        list.add(31.0);
        list.add(43.0);
        list.add(90.0);

        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(4));

        System.out.println(list.size());
        list.remove(2);
        System.out.println(list.size());
    }
}