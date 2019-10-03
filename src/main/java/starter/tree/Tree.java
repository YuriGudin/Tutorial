package starter.tree;

/*
Реализовать дерево
* */


class MyTree {
    Element root; //Корень дерева

    //Добавление эл-та в дерево (Ключ, значение)
    public void put(int key, double value) {
        root = insert(root, null, key, value);
    }

    //Вставка элемента
    private Element insert(Element t, Element p, int key, double value) {
        if (t == null) {
            t = new Element(key, value, p);
        } else {
            if (key == t.key) {
                t = new Element(key, value, p);
            } else if (key < t.key)
                t.left = insert(t.left, t, key, value);
            else
                t.right = insert(t.right, t, key, value);

        }
        return t;
    }

    private Element search(Element t, int key) {
        if (t == null || t.key == key)
            return t;
        if (key < t.key)
            return search(t.left, key);
        else
            return search(t.right, key);
    }
    //Метод получения эл-та по ключу
    public double get(int key) {
        return search(root, key).value;
    }

    void replace(Element a, Element b) {
        if (a.parent == null)
            root = b;
        else if (a == a.parent.left)
            a.parent.left = b;
        else
            a.parent.right = b;
        if (b != null)
            b.parent = a.parent;
    }

    private void remove(Element t, int key) {
        if (t == null)
            return;
        if (key < t.key)
            remove(t.left, key);
        else if (key > t.key)
            remove(t.right, key);
        else if (t.left != null && t.right != null) {
            Element m = t.right;
            while (m.left != null)
                m = m.left;
            t.key = m.key;
            t.value = m.value;
            replace(m, m.right);
        } else if (t.left != null) {
            replace(t, t.left);
        } else if (t.right != null) {
            replace(t, t.right);
        } else {
            replace(t, null);
        }
    }

    public void remove(int key) {
        remove(root, key);
    }

}

class Element {

    double value; //Значение
    int key;    //Ключ
    Element left; //Ссылка на левый эл-т
    Element right; //Ссылка на правый эл-т
    Element parent; //Ссылка на вершину (родителя)

    Element(int key, double value, Element parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }


}

public class Tree {

    public static void main(String[] args) {

        MyTree tree = new MyTree();

        tree.put(1, 10.0);
        tree.put(2, 11.1);
        tree.put(3, 10.4);
        tree.put(10, 190.756);

        tree.put(8, 745.236);
        tree.put(8, 9);

        System.out.println(tree.get(10));
        System.out.println(tree.get(3));
        System.out.println(tree.get(2));
        System.out.println(tree.get(1));
        System.out.println();
        System.out.println(tree.get(8));

        tree.remove(8);

        System.out.println(tree.get(10));
    }
}
