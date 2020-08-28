/**
 *
 */
package entity;

import java.util.List;

/**
 * @author ywx
 * @Date 2020年3月11日 下午9:36:09
 */

public class Recipe {

    private String name;

    private Integer id;

    private List<String> recipe;


    /**
     * @param name
     * @param id
     * @param recipe
     */
    public Recipe(String name, Integer id, List<String> recipe) {
        super();
        this.name = name;
        this.id = id;
        this.recipe = recipe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<String> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<String> recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Recipe [name=" + name + ", id=" + id + ", recipe=" + recipe + "]";
    }

}
