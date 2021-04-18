package hu.nive.ujratervezes.kepesitovizsga.frogprince;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FrogPrince {

    public Set<PlayerOfTale> getPlayersOfTale(DataSource dataSource, Tale tale) {
        Set<PlayerOfTale> result = new HashSet();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("select player_name, age from tales where tale = ?")

        ) {
            ps.setString(1, tale.toString().toUpperCase());
            return getPlayerOfTales(tale, result, ps);
        } catch (SQLException sql) {
            throw new IllegalArgumentException("Something went wrong", sql);
        }

    }

    private Set<PlayerOfTale> getPlayerOfTales(Tale tale, Set<PlayerOfTale> result, PreparedStatement ps) {
        try (
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                String name = rs.getString("player_name");
                int age = Integer.parseInt(rs.getString("age"));
                PlayerOfTale playerOfTale = new PlayerOfTale(name, age, tale);
                result.add(playerOfTale);

            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

}

