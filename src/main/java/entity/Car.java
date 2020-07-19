/**
 * 
 */
package entity;

import java.util.Map;
import java.util.Collections;

/**  
* @author ywx
* @Date 2020年3月11日 下午9:39:12
*/

/**
 * @Description:测试实体
 */
public class Car {

	private String name;

	private Integer id;

	private Map<String, String> partMap;

	private Car(Builder builder) {
		this.name = builder.name;
		this.id = builder.id;
		this.partMap = builder.partMap;
	}

	/**
	 * @param name
	 * @param id
	 * @param partMap
	 */
	public Car(String name, Integer id, Map<String, String> partMap) {
		super();
		this.name = name;
		this.id = id;
		this.partMap = partMap;
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

	public Map<String, String> getPartMap() {
		return partMap;
	}

	public void setPartMap(Map<String, String> partMap) {
		this.partMap = partMap;
	}

	/** 
	 * 
	 */
	public Car() {
		super();
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", id=" + id + ", partMap=" + partMap + "]";
	}

	/**
	 * Creates builder to build {@link Car}.
	 * 
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Car}.
	 */
	public static final class Builder {
		private String name;
		private Integer id;
		private Map<String, String> partMap = Collections.emptyMap();

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

		public Builder withPartMap(Map<String, String> partMap) {
			this.partMap = partMap;
			return this;
		}

		public Car build() {
			return new Car(this);
		}
	}
}
