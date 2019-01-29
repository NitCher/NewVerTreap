public class ImplicitTreap {
    // Корень дерева
    Node root = null;

    // Обьект узла дерева
    class Node {
        Integer size; //размер дерева
        Integer value;//ключ, информация, которую мы храним в дереве
        Double priority;//приоритет
        Node left, right;//левое поддерево и правое поддеров

        //Конструкто узла дерева
        Node (int value) {
            this.value = value;
            this.size = 1;
            priority = Math.random();
        }
    }

    // Объект пары узлов
    class NodePair {
        Node left, right;

        //Конструкто пары узлов
        NodePair (Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

    //Метод удаления по ключу
    public void remove (Integer k) {
        NodePair res = split(root, k);
        root = merge(res.left.left, merge(res.left.right, res.right));
    }

    //Метод добавления по ключу и значении
    public void add (Integer key, Integer val) {
        NodePair n = split(root, key);
        root = merge(n.left, merge(new Node(val), n.right));
    }

    //Метод слияния
    private Node merge (Node t1, Node t2) {
        if (t1 == null)
            return t2;
        else if (t2 == null)
            return t1;

        Node newRoot = null;
        if (t1.priority > t2.priority) {
            t1.right = merge(t1.right, t2);
            newRoot = t1;
        } else {
            t2.left = merge(t1, t2.left);
            newRoot = t2;
        }
        resetSize(newRoot);
        return newRoot;
    }

    // Метод разрезание
    private NodePair split (Node n, Integer key) {
        NodePair res = new NodePair(null, null);
        if (n == null)
            return res;
        Integer nKey = getSize(n.left) + 1;
        if (nKey > key) {
            res = split(n.left, key);
            n.left = res.right;
            res.right = n;
            resetSize(res.left);
            resetSize(res.right);
            return res;
        } else {
            res = split(n.right, key - getSize(n.left) - 1);
            n.right = res.left;
            res.left = n;
            resetSize(res.left);
            resetSize(res.right);
            return res;
        }
    }

    //Метод очистки
    public void clear () {
        this.root = null;
    }

    //Метод изменения размера
    private void resetSize (Node n) {
        if (n != null)
            n.size = getSize(n.left) + getSize(n.right) + 1;
    }

    //Метод получения размера
    private int getSize (Node n) {
        return n == null ? 0 : n.size;
    }

    //Метод вывода дерева
    public void printTree()
    {
        print(root, 0);
    }

    //Метод вывода отдельного узла
    private void print(Node t, int level)
    {
        if(t!=null)
        {
            print(t.left, level+1);
            for(int i=0; i<level; i++)
                System.out.print("...");
            System.out.println("("+t.value+", "+t.priority+")");
            print(t.right,level+1);
        }
    }
}



