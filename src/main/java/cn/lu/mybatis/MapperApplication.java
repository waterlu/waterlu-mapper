package cn.lu.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author lutiehua
 * @date 2018/1/31
 */
@SpringBootApplication
@MapperScan(basePackages = "cn.lu.mybatis.mapper")
public class MapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapperApplication.class, args);
	}
}