/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsa;

/**
 *
 * @author Hp
 */
 //219017700

import java.util.Scanner;
public class LinearProbingHashTable {
    
    private int currentSize,maxSize;
    private String[] keys;
    private String[] values;
    
    public LinearProbingHashTable(int capacity){
        currentSize = 0;
        maxSize = capacity;
        keys = new String[maxSize];
        values = new String[maxSize];
        
        
    }
    public void makeEmpty(){
        currentSize = 0;
        keys = new String[maxSize];
        values = new String[maxSize];
    }
    
    public int getSize(){
        return currentSize;
    
    }
    public boolean isFull(){
        return currentSize== maxSize;
    }
    public boolean isEmpty(){
        return getSize()==0;
    }
    
    public boolean contains(String key){
        return get(key)!= null;
    }
    private int hash(String key){
        return key.hashCode()% maxSize;
    }
    public void insert(String key, String value){
        int tmp = hash(key);
        int i = tmp;
        do{
            if(keys[i] == null)
            {
                keys[i] = key;
                values[i] = value;
                currentSize++;
                return;
            }
            if (keys[i].equals(key)){
                values[i] = value;
                return;
            }
            i =(i+1)% maxSize;
        
        } while(i!=tmp);
    }
    
    public String get(String key){
        int i = hash(key);
        while (keys[i] != null)
        {
            if (keys[i].equals(key))
                return values[i];
            i = (i+1)% maxSize;
        }
        return null;
    }
    
    public void remove(String key){
        if(!contains(key));
        while (!key.equals(keys[i]))
            i = (i+1)% maxSize;
        keys[i] = values[i] = null;
        
        for(i=(i+1)% maxSize; keys[i] != null; i= (i+1)% maxSize)
        {
            String tmp1 = keys[i], tmp2 = values[i];
            keys[i] = values[i] = null;
            currentSize--;
            insert(tmp1, tmp2);
        }
        currentSize--;
    }
    public void printHashTable(){
        System.out.println("\n Hash Table:");
        for (int i = 0; i < maxSize; i++)
            if(keys[i] !=null)
                System.out.println(keys[i] + "" + values[i]);
        System.out.println(this);
    }
    
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Hash Table Testing\n\n");
        System.out.println("Enter size ");
        LinearProbingHashTable table = new LinearProbingHashTable(keyboard.nextInt());
        
        char ch;
        do{
            System.out.println("\nHash Table Operations\n");
             System.out.println("1. insert");
              System.out.println("2. remove");
               System.out.println("3. get");
                System.out.println("4. clear");
                 System.out.println("5. size");
                 
                 int choice = keyboard.nextInt();
                 
                 switch(choice){
                     case 1:
                         System.out.println("Enter key and value");
                         table.insert(keyboard.next(), keyboard.next());
                         break;
                     case 2:
                            System.out.println("Enter key");
                         table.remove(keyboard.next());
                         break;
                     case 3:
                         System.out.println("Enter key");
                         System.out.println("Value = " + table.get(keyboard.next()));
                         break;
                     case 4:
                         table.makeEmpty();
                         System.out.println("Hash Table cleared\n");
                         break;
                     case 5:
                         System.out.println("Size = "+ table.getSize());
                         break;
                     default:
                         System.out.println("Wrong Entry\n");
                         break;
                         
                 }
                 table.printHashTable();
                 
                 System.out.println("\n Do you want to continue(Type Y or N)\n ");
                 ch = keyboard.next().charAt(0);
            
        }while(ch == 'y' || ch =='Y');
    }
}
