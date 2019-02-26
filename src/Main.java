import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Treap Test");
		char ch;
		int key;
		int val;
		Scanner scan = new Scanner(System.in);
		ImplicitTreap treap = new ImplicitTreap();

        // Выводим меню
        do {
            System.out.println("\nНажмите чтобы:\n");
            System.out.println("1. вставить элемент по ключу и по значению");
            System.out.println("2. удалить элемент по ключу");
 
            int choice = scan.nextInt();            
            switch (choice) {
            case 1 : 
                System.out.println("Введите целое число - ключ");
                key = scan.nextInt();
                System.out.println("Введите целое число - значение");
                val = scan.nextInt();
                treap.add(key, val);                   
                break;                          
            case 2 : 
                System.out.println("Введите ключ для удаления");
                key = scan.nextInt();
                treap.remove(key);
                break;                                               
            default : 
                System.out.println("Ошибка нажатия \n ");
                break;   
            }
            //  Вывод дерева

            System.out.println("Обновленное дерево");
            treap.printTree();
            System.out.println("\nПродолжить? (Введите y или n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');
	}

}
