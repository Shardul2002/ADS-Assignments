import java.util.Scanner;

class Heap {
    
    static int[] maxHeap;
    static int[] minHeap;
    static int x, n, curr_index;
    
    public Heap(){
        maxHeap = new int[30];
        minHeap = new int[30];
        curr_index = 0;
    }
    
    public static void getdata(){
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter no of Students : ");
        n = sc.nextInt();
        System.out.print("\nEnter marks : ");
        for(int i=1; i <= n; i++)
        {   
            x = sc.nextInt();
            maxHeap[i] = x;
            minHeap[i] = x;
            curr_index++;
        }
        buildHeap(n);
    }
    
    public static void maxHeapify(int a[], int n, int i){
        int largest = i;
        int l = 2 * i;
        int r = 2 * i + 1;
        
        if(l <= n && a[l] > a[largest]){
            largest = l;
        }
        
        if(r <= n && a[r] > a[largest]){
            largest = r;
        }
        
        if(largest != i){
            swap(a, i, largest);
            maxHeapify(a, n, largest);
        }
    }
    
    public static void minHeapify(int arr[], int n, int i){
        int smallest = i; // Initialize smalles as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2
 
        // If left child is smaller than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;
 
        // If right child is smaller than smallest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;
 
        // If smallest is not root
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
 
            // Recursively heapify the affected sub-tree
            minHeapify(arr, n, smallest);
        }
    }
    
    public static void buildHeap(int n){
        for(int i = n/2; i > 0; i--){
            maxHeapify(maxHeap, n, i);
        }
        for(int i = n/2; i > 0; i--){
            minHeapify(minHeap, n, i);
        }
    }
    
    
    
    public static void swap(int[] heap, int parent, int i){
        int temp = heap[parent];
        heap[parent] = heap[i];
        heap[i] = temp;
    }
    
    
    public static void print(){
        
       System.out.println("\nmaximum marks -> " + maxHeap[1]);
       System.out.println("\nminimum marks -> " + minHeap[1]);
    }
}

public class Main{
    public static void main(String[] args){
        Heap h1 = new Heap();
        h1.getdata();
        h1.print();
    }
}

