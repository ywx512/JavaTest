/**
 * 
 */
package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * 
 * @author ywx
 * @Date 2020年6月10日 下午11:13:15
 * @Description:时间实体
 */
public class Time {
	private Date date;

	private LocalDate localDate;

	private LocalTime localTime;

	private LocalDateTime localDateTime;

	private Time(Builder builder) {
		this.date = builder.date;
		this.localDate = builder.localDate;
		this.localTime = builder.localTime;
		this.localDateTime = builder.localDateTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public LocalTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}

	/** 
	 * 
	 */
	public Time() {
		super();
	}

	/**
	 * Creates builder to build {@link Time}.
	 * 
	 * @return created builder
	 */
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link Time}.
	 */
	public static final class Builder {
		private Date date;
		private LocalDate localDate;
		private LocalTime localTime;
		private LocalDateTime localDateTime;

		private Builder() {
		}

		public Builder withDate(Date date) {
			this.date = date;
			return this;
		}

		public Builder withLocalDate(LocalDate localDate) {
			this.localDate = localDate;
			return this;
		}

		public Builder withLocalTime(LocalTime localTime) {
			this.localTime = localTime;
			return this;
		}

		public Builder withLocalDateTime(LocalDateTime localDateTime) {
			this.localDateTime = localDateTime;
			return this;
		}

		public Time build() {
			return new Time(this);
		}
	}

}
