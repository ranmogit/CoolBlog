package cn.lxt;

import cn.lxt.bean.configBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableConfigurationProperties(configBean.class)
//@EnableScheduling
@EnableAsync
@Controller
public class WarApplication {

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Welcome~";
    }


	public static void main(String[] args) {
		SpringApplication.run(WarApplication.class, args);
	}
}
