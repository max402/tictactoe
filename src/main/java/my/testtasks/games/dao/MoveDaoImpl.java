package my.testtasks.games.dao;

import my.testtasks.games.model.Cell;
import my.testtasks.games.model.Move;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

/** Created by Grischenko Maxim on 23.04.17. */
@Repository
public class MoveDaoImpl implements MoveDao{
    private static final RowMapper<Move> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Move.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SimpleJdbcInsert insertMove;

    @Autowired
    private void setDataSource(@Qualifier("dataSource") DataSource dataSource) {
        this.insertMove = new SimpleJdbcInsert(dataSource)
                .withTableName("moves")
                .usingGeneratedKeyColumns("id");
    }

    public Move save(Move move, int gameId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("game_id", gameId)
                .addValue("cell_id",move.getCell().getId())
                .addValue("number", move.getNumber());

        Number newId = insertMove.executeAndReturnKey(map);
        move.setId(newId.intValue());
        return move;
    }

    public List<Move> getAll(int gameId) {
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet("SELECT number, cells.name FROM moves LEFT JOIN cells on cell_id=cells.id WHERE game_id=?", gameId);
        List<Move> moves = new ArrayList<>();
        while (rowSet.next()) {
            moves.add(new Move(rowSet.getInt("number"), Cell.valueOf(rowSet.getString("name"))));
        }
        return moves;
    }
}
