import java.io.*;
import java.util.*;
import java.util.Scanner;;


class LinearProbingHashTable {
    String[] keys;
    String[] vals;
    int maxSize,currentSize;


    LinearProbingHashTable(int capacity){
        maxSize=capacity;
        currentSize=0;
        keys=new String[maxSize];
        vals=new String[maxSize];
    }

    boolean contains(String key){
        return search(key) !=null;
    }

    int hash(String key){
        return key.hashCode()%maxSize;
    }

    void insert(String key,String value){
        int tmp=hash(key);
        int i=tmp;

        do{
            if(keys[i]==null){
                 keys[i]=key;
                 vals[i]=value;
                 currentSize++;
                 return ;
            }

            if(keys[i].equals(key)){
                vals[i]=value;
                return;
            }
            i=(i+1)%maxSize;
        }while(i!=tmp);
    }

    String search(String key){
        int i=hash(key);
        while(keys[i]!=null){
            if(keys[i].equals(key)){
                return vals[i];
            }
            i=(i+1)%maxSize;
        }
        return null;
    }

    void remove(String key){
        if(!contains(key))
        return;

        int i=hash(key);
        while(!key.equals(keys[i])){
            i=(i+1)%maxSize;
        }
        keys[i]=vals[i]=null;
        for(i=(i+1)%maxSize;keys[i]!=null;i=(i+1)%maxSize){
            String tmp1=keys[i],tmp2=vals[i];
            keys[i]=vals[i]=null;
            currentSize--;
            insert(tmp1, tmp2);
        }
        currentSize--;
    }

    void print(){
        System.out.println("\nHashTable:");
        for(int i=0;i<maxSize;i++){
            if(keys[i]!=null){
                System.out.println(keys[i]+" "+vals[i]);
            }
        }
        System.out.println();
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size");

        LinearProbingHashTable lb= new LinearProbingHashTable(sc.nextInt());

        char ch;
        do{
            System.out.println("\nHash Table Operation\n");
            System.out.println("1.insert");
            System.out.println("2.serach");
            System.out.println("3.delete");

            int choice=sc.nextInt();

            switch(choice){
                case 1:
                System.out.println("Enter key and value");
                lb.insert(sc.next(), sc.next());
                lb.print();
                break;

                case 2:
                System.out.println("Enter key");
                System.out.println(lb.search(sc.next()));
                break;

                case 3:
                System.out.println("Enter key");
                lb.remove(sc.next());
                lb.print();
                break;

                default:
                System.out.println("Invalid Choice");
                break;
            }
            
            
            System.out.println("Do you want to continue??");
            ch=sc.next().charAt(0);
        }while(ch=='Y'||ch=='y');
        
    }

}


