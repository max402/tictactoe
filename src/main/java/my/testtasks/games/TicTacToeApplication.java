package my.testtasks.games;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan("my.testtasks.games")
public class TicTacToeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicTacToeApplication.class, args);
	}
}
