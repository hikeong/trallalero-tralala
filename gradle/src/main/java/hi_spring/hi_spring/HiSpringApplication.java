package hi_spring.hi_spring;

import org.springframework.ui.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class HiSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HiSpringApplication.class, args);

	}
     @GetMapping("hello-mvc")
	 public String helloMvc(@RequestParam("name") String name, Model model) {
		 model.addAttribute("name",name);
         return "hello-template";

	 }
}
