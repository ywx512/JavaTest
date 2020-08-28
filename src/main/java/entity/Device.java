/**
 *
 */
package entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ywx
 * @Date 2020年1月11日 下午4:28:19
 */

public class Device {

    private String name;
    private ArrayList<String> parts;
    private HashMap<String, String> products;

    private Recipe recipe;


    /**
     * @param name
     * @param parts
     * @param products
     * @param recipe
     */
    public Device(String name, ArrayList<String> parts, HashMap<String, String> products, Recipe recipe) {
        super();
        this.name = name;
        this.parts = parts;
        this.products = products;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getParts() {
        return parts;
    }

    public void setParts(ArrayList<String> parts) {
        this.parts = parts;
    }

    public HashMap<String, String> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, String> products) {
        this.products = products;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Device [name=" + name + ", parts=" + parts + ", products=" + products + ", recipe=" + recipe + "]";
    }

}
