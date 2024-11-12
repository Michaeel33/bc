package com.example.Eshop.Dao.Impl;

import com.example.Eshop.Dao.PersonalDataDao;
import com.example.Eshop.Dto.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class PersonalDataDaoImpl implements PersonalDataDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonalDataDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PersonalData getPersonalData(long perId) {
        String sql = "SELECT * FROM personaldata WHERE perId = ?";
        return jdbcTemplate.queryForObject(sql, this::mapPersonalData, perId);
    }

    private PersonalData mapPersonalData(ResultSet rs, int rowNum) throws SQLException {
        PersonalData personalData = new PersonalData();
        personalData.setFirstName(rs.getString("firstName"));
        personalData.setLastName(rs.getString("lastName"));
        personalData.setUlica(rs.getString("ulica"));
        personalData.setMesto(rs.getString("mesto"));
        personalData.setPsc(rs.getString("psc"));
        return personalData;
    }
}