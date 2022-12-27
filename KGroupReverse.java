import java.util.Scanner;
public class KGroupReverse
{
    public class Node
    {
        public int data;
        public Node next;
        public Node(int value)
        {
            this.data = value;
            this.next = null;
        }
    }
    Node head;
    public void InsertNode(int val)
    {
        Node n = new Node(val);
        if(head == null)
        {
            head = n;
            return;
        }
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = n;
        n.next = null;
    }
    public void PrintList()
    {
        Node temp = head;
        while(temp.next != null)
        {
            System.out.print(temp.data+"-> ");
            temp = temp.next;
        }
        System.out.println(temp.data);
        return;
    }
    public void DeleteNodeHead()
    {
        head = head.next;
        return;
    }
    public void ReverseKGroup(int k1, int l, KGroupReverse list1)
    {
        Node temp = head;
        while(l - k1 > k1)
        {
            for(int i = 0; i < k1; i++)
            {
                list1.InsertNode(temp.data);
                DeleteNodeHead();
                temp = temp.next;
            }
            list1.PrintList();
            list1.ReverseList();
            k1 = k1 + k1;
            list1.PrintList();
            Node temp1 = head;
            for(int i = 0; i < k1; i++)
            {
                InsertNode(temp1.data);
                list1.DeleteNodeHead();
                temp1 = temp1.next;
            }
            PrintList();
        }
    }
    public void ReverseList()
    {
        Node prev = null;
        Node current = head;
        Node After = head;
        while(current != null)
        {
            After = current.next;      // Storing the after pointer...
            current.next = prev;       // The current pointer is reversed...
            prev = current;            // previous pointer updated...
            current = After;           // Current pointer is updated...
        }
        head = prev;   // Head is updated to previous...
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        KGroupReverse reverse = new KGroupReverse();
        KGroupReverse list = new KGroupReverse();
        int x, a, k;
        System.out.print("Enter the number of elements in the List : ");
        x = sc.nextInt();
        System.out.print("Enter the value of k : ");
        k = sc.nextInt();
        for(int i = 0; i < x; i++)
        {
            System.out.print("Enter "+(i+1)+"th Node data : ");
            a = sc.nextInt();
            reverse.InsertNode(a);
        }
        reverse.PrintList();
        reverse.ReverseKGroup(k, x, list);
        sc.close();
    }
}