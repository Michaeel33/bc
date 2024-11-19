package com.example.Eshop.Dao.Impl;

import com.example.Eshop.Dao.PersonalDocumentsDao;
import com.example.Eshop.Dto.PersonalDocuments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonalDocumentsDaoImpl implements PersonalDocumentsDao {

    private static final String GET_PERSONAL_DOC_SQL = "SELECT pd.perId, pd.obcianskypreukaz, pd.isVerified, c.countryName " +
            "FROM personaldocuments pd " +
            "JOIN country c ON pd.stat = c.countryId " +
            "WHERE pd.perId = ?";
    private static final String GET_PER_ID_BY_CUSTOMER_ID_SQL = "SELECT perId FROM personaldocuments WHERE obcianskypreukaz = ?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonalDocumentsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PersonalDocuments getPersonalDoc(long perId) {
        List<PersonalDocuments> documents = jdbcTemplate.query(GET_PERSONAL_DOC_SQL, new PersonalDocumentsRowMapper(), perId);
        return documents.isEmpty() ? null : documents.get(0);
    }

    @Override
    public Long getPerIdByCustomerId(String customerId) {
        List<Long> perIds = jdbcTemplate.query(GET_PER_ID_BY_CUSTOMER_ID_SQL, (rs, rowNum) -> rs.getLong("perId"), customerId);
        return perIds.isEmpty() ? null : perIds.get(0);
    }

    private static class PersonalDocumentsRowMapper implements RowMapper<PersonalDocuments> {
        @Override
        public PersonalDocuments mapRow(ResultSet rs, int rowNum) throws SQLException {
            PersonalDocuments document = new PersonalDocuments();
            document.setPerId(rs.getLong("perId"));
            document.setCustomerId(rs.getString("obcianskypreukaz"));
            document.setVerified(rs.getInt("isVerified") == 1);
            document.setCountryName(rs.getString("countryName"));
            return document;
        }
    }
}