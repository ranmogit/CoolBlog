package cn.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableScheduling
@EnableAsync
@EnableTransactionManagement
@Controller
@MapperScan("cn.blog.dao")
public class WarApplication {
//to
	public static void main(String[] args) {
		SpringApplication.run(WarApplication.class, args);
	}
}
