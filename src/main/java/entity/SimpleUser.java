/**
 *
 */
package entity;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author ywx
 * @Date 2020年3月11日 下午10:53:21
 */

public class SimpleUser {

    private String name;

    private Integer id;

    private SimpleUser(Builder builder) {
        this.name = builder.name;
        this.id = builder.id;
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

    /**
     * @param name
     * @param id
     */
    public SimpleUser(String name, Integer id) {
        super();
        this.name = name;
        this.id = id;
    }

    /**
     *
     */
    public SimpleUser() {
        super();
    }

    @Override
    public String toString() {
        return "SimpleUser [name=" + name + ", id=" + id + "]";
    }

    /**
     * Creates builder to build {@link SimpleUser}.
     *
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder to build {@link SimpleUser}.
     */
    public static final class Builder {
        private String name;
        private Integer id;

        private Builder() {
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public SimpleUser build() {
            return new SimpleUser(this);
        }
    }
}
