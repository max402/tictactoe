package my.testtasks.games.controller;

import my.testtasks.games.model.Cell;
import my.testtasks.games.model.Game;
import my.testtasks.games.model.Move;
import my.testtasks.games.model.Status;
import my.testtasks.games.service.GameService;
import my.testtasks.games.service.MoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private MoveService moveService;

    @GetMapping("/")
    public String list(Model m) {
        m.addAttribute("games", gameService.getAll());
        return "gameList";
    }

    @PostMapping("/")
    public String addGame(HttpServletRequest request) {
        String gameName = request.getParameter("gameName");
        gameService.save(new Game(gameName, Status.IN_PROGRESS));
        return "redirect:/";
    }

    @GetMapping("/game/{game_id}")
    public String game(Model m, @PathVariable("game_id") int game_id) {
        Map<Cell, Integer> moves = moveService.getAll(game_id);
        Map<String,String> map = new HashMap<>();
        for(int i=1;i<=9;i++) {
            Cell c = Cell.values()[i-1];
            map.put(c.toString(), moves.containsKey(c) ? (moves.get(c)%2==1 ? "x" : "o") : "");
        }

        Status result = gameService.checkWin(moves);
        Game game = gameService.get(game_id);
        if(result != game.getStatus()) {
            game.setStatus(result);
            game = gameService.update(game);
        }
        m.addAttribute("map", map);
        m.addAttribute("status", game.getStatus());
        m.addAttribute("playable", result.getId()==1);
        return "game";
    }

    @PostMapping("/game/{game_id}")
    public String makeMove(HttpServletRequest request, @PathVariable("game_id") int game_id) {
        String strCell = request.getParameter("selected");
        if("".equals(strCell)) return "redirect:/";
        int newNumber = moveService.getAll(game_id).size()+1;
        moveService.save(new Move(newNumber, Cell.valueOf(strCell)), game_id);
        return "redirect:/game/"+game_id;
    }

}
