import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Knapsack {

        public double knapsackBruteForce(Item[] items, double capacity, int itemNumber, ArrayList<Item> storedItems) {
        
            if(itemNumber == 0 || capacity == 0) {
                return 0;   // base case for recursion in case the knapsack is full or there are no items in the array
             }
        
            Item currentItem = items[itemNumber-1]; // fetching the last item in the array of items
            double currentValue = currentItem.getValue();  // recording the item's details
            double currentWeight = currentItem.getWeight();
    
            if(currentWeight > capacity) {
                return knapsackBruteForce(items, capacity, itemNumber-1, storedItems); // if the weight of the current item is too large for the knapsack, item is excluded and the next item is processed
            }
            else {
                ArrayList<Item> includeList = new ArrayList<Item>(storedItems); // creating array lists as copies of the input array list so that it can be modified depending on the specific use case
                ArrayList<Item> excludeList = new ArrayList<Item>(storedItems);

                double includeItemValue = currentValue + knapsackBruteForce(items, capacity-currentWeight, itemNumber-1, includeList); // if item is considered for knapsack, the value is added to the variable and next item in array is recursively called
                double excludeItemValue = knapsackBruteForce(items, capacity, itemNumber-1, excludeList);  // if item isn't considered, item is excluded and the next item is processed
    
                if (includeItemValue > excludeItemValue) {    // checking to see if the value of the knapsack is greater with or without the item
                    includeList.add(currentItem);
                    storedItems.clear();    // clearing the input array list so that new items can be added to the knapsack
                    storedItems.addAll(includeList);
                    return includeItemValue;
                }
                else {
                    storedItems.clear();
                    storedItems.addAll(excludeList);
                    return excludeItemValue;
                }
            }
        
        }

        public Item[] readItems(String filename) throws FileNotFoundException { // method that will read the test file to obtain information about the list of items
            
            File  readItemData= new File(filename);
            Scanner fileScan = new Scanner(readItemData);
            int lineCount = -1; // counting the number of items in the file - starting at -1 so that the line containing the knapsack capacity is not included

            while(fileScan.hasNextLine()){
                fileScan.nextLine();
                lineCount++;
            }

            fileScan.close();
            fileScan = new Scanner(readItemData);   // closing and reopening the file scanner so that the scanner points to the start of the file again

            Item[] items = new Item[lineCount]; // initialising the item array with the correct number of items
            String itemData = "";
            int i=0;
            
            while(fileScan.hasNextLine()){
                itemData = fileScan.nextLine();
                if(itemData.contains(",") == false) {  // if the line read by the file scanner does not contain a comma, it must be the line that has information of the knapsack capacity, so it is skipped
                    continue;
                }
                String[] itemArr = itemData.split(","); // splitting the line containing item information by its components that are separated by commas (item name, value and weight) and storing them in a string array
                Item item = new Item(itemArr[0], Double.parseDouble(itemArr[1]), Double.parseDouble(itemArr[2])); // storing the components by calling the item class
                items[i] = item; // storing the new item into the item array
                i++;
            } 

            fileScan.close();
            return items;
        }

        public double readCapacity(String filename) throws FileNotFoundException {  // method that will read the test file to obtain the capacity of the knapsack

            File  readItemData= new File(filename);
            Scanner fileScan = new Scanner(readItemData);
            String itemData = "";
            double capacity = 0;

            while(fileScan.hasNextLine()) {
                itemData = fileScan.nextLine();
                if(itemData.contains(",") == false) {
                    capacity = Double.parseDouble(itemData);    // if the line read by the file scanner does not contain a comma, it must be the line that has information of the knapsack capacity, so the value is stored in the capacity variable
                    break;
                }
                continue;
            }

            fileScan.close();
            return capacity;
        }
        
        public static void main(String[] args) throws Exception {
            
        Knapsack ks = new Knapsack();   // creating new knapsack object
        Scanner sc = new Scanner(System.in);    // scanner to read user input for which test they would like to see
        System.out.println("Enter test file number (1-5):");
        String output = sc.next();
        sc.close();
        
        int testNumber = Integer.parseInt(output);
        Item[] items = null;
        double capacity = 0;

        switch(testNumber) {    // switch statement where cases are executed based on the test number the user inputted
            case 1:
                items = ks.readItems("test1.txt");   
                capacity = ks.readCapacity("test1.txt");
                System.out.println("Test 1:\nKnapsack capacity: " + capacity + "\nItems in the knapsack:");
                break;
            case 2:
                items = ks.readItems("test2.txt");    
                capacity = ks.readCapacity("test2.txt");
                System.out.println("Test 2:\nKnapsack capacity: " + capacity + "\nItems in the knapsack:");
                break;
            case 3:
                items = ks.readItems("test3.txt");
                capacity = ks.readCapacity("test3.txt");
                System.out.println("Test 3:\nKnapsack capacity: " + capacity + "\nItems in the knapsack:");
                break;
            case 4:
                items = ks.readItems("test4.txt");
                capacity = ks.readCapacity("test4.txt");
                System.out.println("Test 4:\nKnapsack capacity: " + capacity + "\nItems in the knapsack:");
                break;
            case 5:
                items = ks.readItems("test5.txt");
                capacity = ks.readCapacity("test5.txt");
                System.out.println("Test 5:\nKnapsack capacity: " + capacity + "\nItems in the knapsack:");
                break;
        }

        ArrayList<Item> storedItems = new ArrayList<Item>();

        double maxValue = ks.knapsackBruteForce(items, capacity,items.length, storedItems);  //  calling the method to process items to be stored in the knapsack and the maximum value of those items 
        double totalWeight = 0;

        for (int i=0;i < storedItems.size();i++) {
            System.out.println(storedItems.get(i).getName() + " (Value: " + storedItems.get(i).getValue() + ", Weight: " + storedItems.get(i).getWeight() + ")");   // loop that goes through the array to print the information about the items
            totalWeight += storedItems.get(i).getWeight();  // tallying up the weight of each item in the knapsack
        }   
        System.out.println("Number of items in the knapsack: " + storedItems.size());   // displaying knapsack information
        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Maximum Value: " + maxValue + '\n');

    }
}