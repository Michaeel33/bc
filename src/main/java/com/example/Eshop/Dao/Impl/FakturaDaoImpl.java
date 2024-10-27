package com.example.Eshop.Dao.Impl;

import com.example.Eshop.Dao.FakturaDao;
import com.example.Eshop.Dto.FakturaDto;
import com.example.Eshop.Dto.Items;
import com.example.Eshop.Dto.PersonalData;
import com.example.Eshop.Dto.PersonalDocuments;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
@Repository
public class FakturaDaoImpl extends NamedParameterJdbcDaoSupport implements FakturaDao {

    private final JdbcTemplate jdbcTemplate;

    @PostConstruct
    private void initialize() {
        setJdbcTemplate(jdbcTemplate);
    }
    @Autowired
    public FakturaDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public PersonalData getPersonalData(long perId) {

        String sql = "SELECT * FROM personaldata WHERE perId = ?";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> mapPersonalData(rs), perId);
    }

    @Override
    public FakturaDto getFaktura(long perId) {

        FakturaDto fakturaDto = new FakturaDto();
        PersonalData personalDataDto = getPersonalData(perId);

        fakturaDto.setPersId(perId);
        fakturaDto.setPersonalData(personalDataDto);

        return fakturaDto;

    }


    private PersonalData mapPersonalData(ResultSet rs) throws SQLException {

        PersonalData personalData = new PersonalData();

        personalData.setPerId(rs.getInt("perId"));
        personalData.setFirstName(rs.getString("firstName"));
        personalData.setLastName(rs.getString("lastName"));
        personalData.setUlica(rs.getString("ulica"));
        personalData.setMesto(rs.getString("mesto"));
        personalData.setPsc(rs.getString("psc"));

        return personalData;
    }
}
