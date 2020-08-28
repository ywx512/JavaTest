/**
 *
 */
package entity;

import java.util.Collections;
import java.util.List;

/**
 * @author ywx
 * @Date 2020年1月11日 下午4:23:47
 */

public class User {

    private String name;
    private Integer age;

    private Recipe recipe;

    private List<Car> carList;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.recipe = builder.recipe;
        this.carList = builder.carList;
    }

    /**
     * @param name
     * @param age
     * @param recipe
     * @param carList
     */
    public User(String name, Integer age, Recipe recipe, List<Car> carList) {
        super();
        this.name = name;
        this.age = age;
        this.recipe = recipe;
        this.carList = carList;
    }

    /**
     *
     */
    public User() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", recipe=" + recipe + ", carList=" + carList + "]";
    }

    /**
     * Creates builder to build {@link User}.
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder to build {@link User}.
     */
    public static final class Builder {
        private String name;
        private Integer age;
        private Recipe recipe;
        private List<Car> carList = Collections.emptyList();

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAge(Integer age) {
            this.age = age;
            return this;
        }

        public Builder withRecipe(Recipe recipe) {
            this.recipe = recipe;
            return this;
        }

        public Builder withCarList(List<Car> carList) {
            this.carList = carList;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
