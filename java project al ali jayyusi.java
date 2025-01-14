import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class FoodItem
{
    protected String name;
    protected double price;

    public FoodItem(String n, double p) {
        
        name = n;
        price = p;
    }

    public void display()
    {
        
        System.out.println("Food Item: " + name + ", Price: " + price + " JD");
    }

    public double getPrice()
    {
        
        return price;
    }

    public String getName()
    {
        
        return name; 
    }
}

class Appetizer extends FoodItem
{
    public Appetizer(String n, double p)
    {
        
        super(n, p);
    }


    public void display() {
        
        System.out.println("Appetizer: " + name + ", Price: " + price + " JD");
    }
}

class MainCourse extends FoodItem {
    public MainCourse(String n, double p) {
        
        super(n, p);
    }

    public void display() {
        
        System.out.println("Main Course: " + name + ", Price: " + price + " JD");
    }
}

class Dessert extends FoodItem {
    public Dessert(String n, double p) {
        
        super(n, p);
    }

    public void display() {
        
        System.out.println("Dessert: " + name + ", Price: " + price + " JD");
    }
}

class Restaurant {
    private List<FoodItem> appetizers = new ArrayList<>();
    private List<FoodItem> mainCourses = new ArrayList<>();
    private List<FoodItem> desserts = new ArrayList<>();

    public Restaurant() {
        
    }

    public void addOrder(FoodItem item, int quantity, String course) {
        
        for (int i = 0; i < quantity; i++) {
            
            if (course.equalsIgnoreCase("appetizer")) {
                
                appetizers.add(item);
            } else if (course.equalsIgnoreCase("maincourse")) {
                
                mainCourses.add(item);
            } else if (course.equalsIgnoreCase("dessert")) {
                
                desserts.add(item);
            }
        }
    }

    public void displayMenu() {
        
        System.out.println("\nYour Order Summary:");
        System.out.println("Appetizers:");
        for (FoodItem appetizer : appetizers) {
            
            appetizer.display();
        }
        System.out.println("Main Courses:");
        for (FoodItem mainCourse : mainCourses) {
            
            mainCourse.display();
        }
        System.out.println("Desserts:");
        for (FoodItem dessert : desserts) {
            
            dessert.display();
        }
    }

    public double calculateTotal() {
        
        double total = 0;
        for (FoodItem appetizer : appetizers) {
            
            total += appetizer.getPrice();
        }
        for (FoodItem mainCourse : mainCourses) {
            
            total += mainCourse.getPrice();
        }
        for (FoodItem dessert : desserts) {
            
            total += dessert.getPrice();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        FoodItem appetizer1 = new Appetizer("Hummus", 2.00);  
        FoodItem appetizer2 = new Appetizer("Tabbouleh", 3.50);
        FoodItem appetizer3 = new Appetizer("Fattoush", 3.00);
        FoodItem appetizer4 = new Appetizer("Sambousa", 1.00);
        FoodItem appetizer5 = new Appetizer("Mutabbal", 2.50);
        FoodItem appetizer6 = new Appetizer("Baba Ganoush", 2.50);

        FoodItem mainCourse1 = new MainCourse("Mansaf", 10.00);
        FoodItem mainCourse2 = new MainCourse("Maqlouba", 8.00);
        FoodItem mainCourse3 = new MainCourse("Shawarma", 5.00);
        FoodItem mainCourse4 = new MainCourse("Kebab", 10.00);
        FoodItem mainCourse5 = new MainCourse("Fatteh", 7.00);
        FoodItem mainCourse6 = new MainCourse("Grilled Fish", 10.00);
        FoodItem mainCourse7 = new MainCourse("Biryani", 8.00);

        FoodItem dessert1 = new Dessert("Kunafa", 5.00);
        FoodItem dessert2 = new Dessert("Baklava", 6.50);
        FoodItem dessert3 = new Dessert("Basbousa", 4.00);
        FoodItem dessert4 = new Dessert("Rice Pudding", 3.00);
        FoodItem dessert5 = new Dessert("Halva", 4.00);
        FoodItem dessert6 = new Dessert("Ma'amoul", 2.00);

        System.out.println("Please select how many items you would like to order from each category:");

        Restaurant myRestaurant = new Restaurant();
        boolean continueOrderingAppetizers = true;
        while (continueOrderingAppetizers) {
            
            System.out.println("\nAppetizers:");
            System.out.println("1. Hummus (2.00 JD)");
            System.out.println("2. Tabbouleh (3.50 JD)");
            System.out.println("3. Fattoush (3.00 JD)");
            System.out.println("4. Sambousa (1.00 JD)");
            System.out.println("5. Mutabbal (2.50 JD)");
            System.out.println("6. Baba Ganoush (2.50 JD)");

            System.out.print("\nChoose an appetizer (1-6) or 0 to finish ordering appetizers: ");
            int appetizerChoice = scanner.nextInt();
            if (appetizerChoice == 0) {
                
                continueOrderingAppetizers = false;
                break;
            }

            if (appetizerChoice < 1 || appetizerChoice > 6) {
                
                System.out.println("Invalid choice! Please select a valid appetizer from the list.");
                continue;  
            }

            System.out.print("How many would you like to order? ");
            int appetizerQuantity = scanner.nextInt();
            if (appetizerChoice == 1) {
                
                myRestaurant.addOrder(appetizer1, appetizerQuantity, "appetizer");
            } else if (appetizerChoice == 2) {
                
                myRestaurant.addOrder(appetizer2, appetizerQuantity, "appetizer");
            } else if (appetizerChoice == 3) {
                
                myRestaurant.addOrder(appetizer3, appetizerQuantity, "appetizer");
            } else if (appetizerChoice == 4) {
                
                myRestaurant.addOrder(appetizer4, appetizerQuantity, "appetizer");
            } else if (appetizerChoice == 5) {
                
                myRestaurant.addOrder(appetizer5, appetizerQuantity, "appetizer");
            } else if (appetizerChoice == 6) {
                
                myRestaurant.addOrder(appetizer6, appetizerQuantity, "appetizer");
            }
        }

        boolean continueOrderingMainCourses = true;
        while (continueOrderingMainCourses) {
            
            System.out.println("\nMain Courses:");
            System.out.println("1. Mansaf (10.00 JD)");
            System.out.println("2. Maqlouba (8.00 JD)");
            System.out.println("3. Shawarma (5.00 JD)");
            System.out.println("4. Kebab (10.00 JD)");
            System.out.println("5. Fatteh (7.00 JD)");
            System.out.println("6. Grilled Fish (10.00 JD)");
            System.out.println("7. Biryani (8.00 JD)");

            System.out.print("\nChoose a main course (1-7) or 0 to finish ordering main courses: ");
            int mainCourseChoice = scanner.nextInt();
            if (mainCourseChoice == 0) {
                
                continueOrderingMainCourses = false;
                break;
            }

            if (mainCourseChoice < 1 || mainCourseChoice > 7) {
                
                System.out.println("Invalid choice! Please select a valid main course from the list.");
                continue;  
            }

            System.out.print("How many would you like to order? ");
            int mainCourseQuantity = scanner.nextInt();
            if (mainCourseChoice == 1) {
                
                myRestaurant.addOrder(mainCourse1, mainCourseQuantity, "maincourse");
            } else if (mainCourseChoice == 2) {
                
                myRestaurant.addOrder(mainCourse2, mainCourseQuantity, "maincourse");
            } else if (mainCourseChoice == 3) {
                
                myRestaurant.addOrder(mainCourse3, mainCourseQuantity, "maincourse");
            } else if (mainCourseChoice == 4) {
                
                myRestaurant.addOrder(mainCourse4, mainCourseQuantity, "maincourse");
            } else if (mainCourseChoice == 5) {
                
                myRestaurant.addOrder(mainCourse5, mainCourseQuantity, "maincourse");
            } else if (mainCourseChoice == 6) {
                
                myRestaurant.addOrder(mainCourse6, mainCourseQuantity, "maincourse");
            } else if (mainCourseChoice == 7) {
                
                myRestaurant.addOrder(mainCourse7, mainCourseQuantity, "maincourse");
            }
        }

        boolean continueOrderingDesserts = true;
        while (continueOrderingDesserts) {
            
            System.out.println("\nDesserts:");
            System.out.println("1. Kunafa (5.00 JD)");
            System.out.println("2. Baklava (6.50 JD)");
            System.out.println("3. Basbousa (4.00 JD)");
            System.out.println("4. Rice Pudding (3.00 JD)");
            System.out.println("5. Halva (4.00 JD)");
            System.out.println("6. Ma'amoul (2.00 JD)");

            System.out.print("\nChoose a dessert (1-6) or 0 to finish ordering desserts: ");
            int dessertChoice = scanner.nextInt();
            if (dessertChoice == 0) {
                
                continueOrderingDesserts = false;
                break;
            }

            if (dessertChoice < 1 || dessertChoice > 6) {
                
                System.out.println("Invalid choice! Please select a valid dessert from the list.");
                continue;  
            }

            System.out.print("How many would you like to order? ");
            int dessertQuantity = scanner.nextInt();
            if (dessertChoice == 1) {
                
                myRestaurant.addOrder(dessert1, dessertQuantity, "dessert");
            } else if (dessertChoice == 2) {
                
                myRestaurant.addOrder(dessert2, dessertQuantity, "dessert");
            } else if (dessertChoice == 3) {
                
                myRestaurant.addOrder(dessert3, dessertQuantity, "dessert");
            } else if (dessertChoice == 4) {
                
                myRestaurant.addOrder(dessert4, dessertQuantity, "dessert");
            } else if (dessertChoice == 5) {
                
                myRestaurant.addOrder(dessert5, dessertQuantity, "dessert");
            } else if (dessertChoice == 6) {
                
                myRestaurant.addOrder(dessert6, dessertQuantity, "dessert");
            }
        }

        myRestaurant.displayMenu();

        double total = myRestaurant.calculateTotal();
        System.out.println("\nTotal Bill: " + total + " JD");

        scanner.close();
    }
}
