import java.util.*;

interface MealPlan {
    String getMealCategory(); 
}

class VegetarianMeal implements MealPlan {
    public String getMealCategory() {
        return "Vegetarian";
    }
}

class VeganMeal implements MealPlan {
    public String getMealCategory() { 
        return "Vegan";
    }
}

class Meal<T extends MealPlan> {
    private String mealName;
    private double price;
    private T mealType;

    public Meal(String mealName, double price, T mealType) {
        this.mealName = mealName;
        this.price = price;
        this.mealType = mealType;
    }

    public void displayInfo() {
        System.out.println("Meal name: " + mealName + " , Price: " + price + " , Meal type: " + mealType.getMealCategory());
    }

    public T getMealType() {
        return mealType;
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMeal(String mealName, T mealPlan) {
        if (mealPlan != null) {
            return new Meal<>(mealName, 10.0, mealPlan);  
        }
        System.out.println("Invalid meal plan: Meal plan cannot be null.");
        return null;
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        List<Meal<? extends MealPlan>> mealList = new ArrayList<>();

        Meal<VegetarianMeal> vegMeal = MealPlanGenerator.generateMeal("Veggie Delight", new VegetarianMeal());
        Meal<VeganMeal> veganMeal = MealPlanGenerator.generateMeal("Vegan Power", new VeganMeal());
       

        mealList.add(vegMeal);
        mealList.add(veganMeal);
       

        System.out.println("Personalized Meal Plans:");
        for (Meal<? extends MealPlan> meal : mealList) {
            meal.displayInfo();
        }
    }
}
