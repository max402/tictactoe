package my.testtasks.games.dao;

import my.testtasks.games.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/** Created by Grischenko Maxim on 23.04.17. */
@Repository
public class GameDaoImpl implements GameDao {
    private static final RowMapper<Game> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Game.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertGame;

    @Autowired
    private void setDataSource(@Qualifier("dataSource") DataSource dataSource) {
        this.insertGame = new SimpleJdbcInsert(dataSource)
                .withTableName("games")
                .usingGeneratedKeyColumns("id");
    }
    
    public Game save(Game game) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", game.getId())
                .addValue("name", game.getName())
                .addValue("status", game.getStatus());

        if (game.isNew()) {
            Number newId = insertGame.executeAndReturnKey(map);
            game.setId(newId.intValue());
        } else {
            if (namedParameterJdbcTemplate.update("" +
                  "UPDATE games "+
                  "SET name=:name, status_id=(SELECT id FROM statuses WHERE name=:status) "+
                  "WHERE id=:id"
                    , map) == 0) {
                return null;
            }
        }
        return game;
    }

    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM games WHERE id=?", id) != 0;
    }

    public Game get(int id) {
        List<Game> games = jdbcTemplate.query("SELECT * FROM games WHERE id = ?", ROW_MAPPER, id);
        return DataAccessUtils.singleResult(games);
    }

    public List<Game> getAll() {
        return jdbcTemplate.query("SELECT * FROM games", ROW_MAPPER);
    }
}
