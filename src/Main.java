import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Integer> expenses = new ArrayList<Integer>();

    public static void main(String[] args) {
        /*System.out.println("Hello World!");*/

        expenses.add(1000);
        expenses.add(2300);
        expenses.add(45000);
        expenses.add(32000);
        expenses.add(110);

        System.out.println("\n**************************************\n");
        System.out.println("\tWelcome to TheDesk \n");
        System.out.println("**************************************");
        optionsSelection();

    }
    private static void optionsSelection() {
        String[] theOptions = {"1. I wish to review my expenditure",
                "2. I wish to add my expenditure",
                "3. I wish to delete my expenditure",
                "4. I wish to sort the expenditures",
                "5. I wish to search for a particular expenditure",
                "6. Close the application"
        };

        for(String option : theOptions){
            System.out.println(option);
        }

        System.out.print("\nEnter your choice:\t");
        Scanner sc = new Scanner(System.in);
        int  options =  sc.nextInt();
        switch (options){
            case 1:
                System.out.println("Your saved expenses are listed below: \n");
                System.out.println(expenses+"\n");
                optionsSelection();
                break;
            case 2:
                System.out.println("Enter the value to add your Expense: \n");
                int value = sc.nextInt();
                expenses.add(value);
                System.out.println("Your value is updated\n");
                System.out.println(expenses+"\n");
                optionsSelection();

                break;
            case 3:
                System.out.println("You are about the delete all your expenses! \nConfirm again by selecting the same option...\n");
                int con_choice = sc.nextInt();
                if(con_choice==options){
                    expenses.clear();
                    System.out.println(expenses+"\n");
                    System.out.println("All your expenses are erased!\n");
                } else {
                    System.out.println("Oops... try again!");
                }
                optionsSelection();
                break;
            case 4:
                sortExpenses(expenses);
                optionsSelection();
                break;
            case 5:
                searchExpenses(expenses);
                optionsSelection();
                break;
            case 6:
                closeApp();
                break;
            default:
                System.out.println("You have made an invalid choice!");
                optionsSelection();
                break;
        }

    }
    private static void closeApp() {
        System.out.println("Closing your application... \nThank you!");
        System.exit(0);
            }
    private static void searchExpenses(ArrayList<Integer> arrayList) {
        int expenseLookFor = 0;
        boolean foundExpense = false;
        System.out.println("Enter the expense you need to search:\t");
        Scanner scanner = new Scanner(System.in);
        expenseLookFor = scanner.nextInt();
        for (int expense : arrayList) {
            if(expense == expenseLookFor) {
                foundExpense = true;
            }
        }
        if(foundExpense){
            System.out.println("Found expense " + expenseLookFor);
        } else {
            System.out.println("Expense: " + expenseLookFor + " could not be found!");
        }
    }
    private static void sortExpenses(ArrayList<Integer> arrayList) {
        int arrlength =  arrayList.size();
        for(int lastUnsortedIndex = arrlength - 1; lastUnsortedIndex > 0 ; lastUnsortedIndex--){

            int largestIndex = 0;
            for(int i = 0; i <= lastUnsortedIndex; i++){
                if(arrayList.get(i) > arrayList.get(largestIndex)){
                    largestIndex = i;
                }
            }

            if (lastUnsortedIndex != largestIndex){
                int temp = arrayList.get(lastUnsortedIndex);
                arrayList.set(lastUnsortedIndex, arrayList.get(largestIndex));
                arrayList.set(largestIndex, temp);
            }
        }
        System.out.println("Expenses in order: ");
        System.out.println(arrayList + "\n");
    }
}
