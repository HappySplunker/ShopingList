package com.rsamarskyi.shopinglist;

import com.rsamarskyi.shopinglist.db.Database;
import com.rsamarskyi.shopinglist.db.ListDatabase;
import com.rsamarskyi.shopinglist.services.AddNewProductService;
import com.rsamarskyi.shopinglist.services.RemoveProductService;
import com.rsamarskyi.shopinglist.services.ShowAllProductsService;
import com.rsamarskyi.shopinglist.views.AddNewProductView;
import com.rsamarskyi.shopinglist.views.RemoveProductView;
import com.rsamarskyi.shopinglist.views.ShowAllProductsView;



import java.util.Scanner;

public class ApplicationStart {
    public static void main(String[] args) {

        Database database = new ListDatabase();

        AddNewProductService addNewProductService = new AddNewProductService(database);
        RemoveProductService removeProductService = new RemoveProductService(database);
        ShowAllProductsService showAllProductsService = new ShowAllProductsService(database);


        AddNewProductView addNewProductView = new AddNewProductView(addNewProductService);
        RemoveProductView removeProductView = new RemoveProductView(removeProductService);
        ShowAllProductsView showAllProductsView = new ShowAllProductsView(showAllProductsService);


        while(true){
            getUserMenuInput();
            int userChoice = getUserChoice();
            if (userChoice == 4){
                break;
            }
            switch(userChoice){
                case 1:{
                   addNewProductView.action();
                   break;
                }
                case 2:{
                    removeProductView.action();
                    break;
                }
                case 3:{
                    showAllProductsView.action();
                    break;
                }
                default:
                    System.out.println("Wrong option. Try again");
            }
        }
    }



    private static void getUserMenuInput (){
        System.out.println("Press 1 to add product to the list");
        System.out.println("Press 2 to remove product from the list");
        System.out.println("Press 3 to show the list");
        System.out.println("Press 4 to exit");
    }
    private static int getUserChoice(){
        System.out.println("Enter your choice");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        boolean isInteger;
            try {
                Integer.parseInt(userInput);
                isInteger= true;
            } catch (NumberFormatException e) {
                isInteger= false;
            }

        if (isInteger) {

            return Integer.parseInt(userInput);
        }else
        {
            System.out.println("Wrong input");

        }return 0;
    }
}
