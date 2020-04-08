package csci467.calfco.productsystem.repository;

import csci467.calfco.productsystem.models.Part;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("partRepository")
public class PartRepositoryImpl implements PartRepository {

    @Qualifier("legacyProductDAO")
    private JdbcTemplate jdbcTemplate;

    public PartRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Collection<Part> getAllParts() {

        final String sql = "SELECT * FROM parts";
        List<Part> parts = jdbcTemplate.query(sql, new RowMapper<Part>() {
            @Override
            public Part mapRow(ResultSet rs, int rowNum) throws SQLException {
                Part part = new Part();
                part.setId(rs.getInt("number"));
                part.setDescription(rs.getString("description"));
                part.setPrice(rs.getFloat("price"));
                part.setWeight(rs.getFloat("weight"));
                part.setPictureURL(rs.getString("pictureURL"));
                return part;
            }
        });

        return parts;
    }
}
