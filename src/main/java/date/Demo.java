package date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 * @author ywx
 * @Date 2020年6月10日 下午11:17:33
 * @Description:时间工具类测试
 */
public class Demo {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate: " + localDate);

		LocalTime localTime = LocalTime.now();
		System.out.println("localTime: " + localTime);

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("localDateTime: " + localDateTime);

		/**
		 * 由日期和时间生成
		 */
		LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
		System.out.println("localDateTime2: " + localDateTime2);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
		System.out.println("格式化时间: " + localDateTime.format(formatter));

		System.out.println("localDateTime转时间戳: " + localDateTime.toInstant(ZoneOffset.of("+8")).getEpochSecond());

		Instant instant = Instant.now();
		System.out.println("instant: " + instant.toString());
		System.out.println("instant 获取秒数 时间戳: " + instant.getEpochSecond());
		System.out.println("instant 获取毫秒数 时间戳: " + instant.toEpochMilli());

		Date date = localDateTimeConvertToDate(localDateTime);
		System.out.println("date转localDateTime: " + date.toString());
		LocalDateTime localDateTime3 = dateConvertToLocalDateTime(date);
		System.out.println("localDateTime转date: " + localDateTime3.toString());
	}

	public static LocalDateTime dateConvertToLocalDateTime(Date date) {
		return date.toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
	}

	public static Date localDateTimeConvertToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.toInstant(ZoneOffset.of("+8")));
	}
}
