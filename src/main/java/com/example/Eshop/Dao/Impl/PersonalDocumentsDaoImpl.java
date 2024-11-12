package com.example.Eshop.Dao.Impl;

import com.example.Eshop.Dao.PersonalDocumentsDao;
import com.example.Eshop.Dto.PersonalDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PersonalDocumentsDaoImpl implements PersonalDocumentsDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonalDocumentsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PersonalDocuments getPersonalDoc(long perId) {
        String sql = "SELECT pd.obcianskypreukaz, pd.isVerified, c.countryName " +
                "FROM personaldocuments pd " +
                "JOIN country c ON pd.stat = c.countryId " +
                "WHERE pd.perId = ?";
        return jdbcTemplate.queryForObject(sql, this::mapPersDocument, perId);
    }

    private PersonalDocuments mapPersDocument(ResultSet rs, int rowNum) throws SQLException {
        PersonalDocuments document = new PersonalDocuments();
        document.setCustomerId(rs.getString("obcianskypreukaz"));
        document.setVerified(rs.getInt("isVerified") == 1);
        document.setCountryName(rs.getString("countryName"));
        return document;
    }
}