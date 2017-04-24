package my.testtasks.games;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/** Created by Grischenko Maxim on 23.04.17. */

public class ServletInitializer  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TicTacToeApplication.class);
    }

}
