package my.testtasks.games.controller;

import my.testtasks.games.model.Game;
import my.testtasks.games.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GameController {

    @Autowired
    private GameService service;

//    public Game get(int id) {
//        return service.get(id);
//    }
//
//    public void delete(int id) {
//        service.delete(id);
//    }
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Game> getAll() {
//        return service.getAll();
//    }
//
//    public void update(Game game, int id) {
//        checkIdConsistent(game, id);
//        service.update(game);
//    }
//
//    public Game create(Game game) {
//        checkNew(game);
//        return service.save(game);
//    }
//
//    public static void checkNew(Game game) {
//        if (!game.isNew()) {
//            throw new IllegalArgumentException(game + " must be new (id=null)");
//        }
//    }
//
//    public static void checkIdConsistent(Game game, int id) {
//        if (game.isNew()) {
//            game.setId(id);
//        } else if (game.getId() != id) {
//            throw new IllegalArgumentException(game + " must be with id=" + id);
//        }
//    }

    @GetMapping("/")
    public String list(Model m) {
        m.addAttribute("games", service.getAll());
        return "gameList";
    }

    @GetMapping("/game/{id}")
    public String game(@PathVariable("id") int id) {
        return "game";
    }

}
