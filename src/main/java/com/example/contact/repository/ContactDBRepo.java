package com.example.contact.repository;

import com.example.contact.entity.ContactEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
@RequiredArgsConstructor
public class ContactDBRepo implements Repo {

    private final JdbcTemplate template;

    public List<ContactEntity> getAll() {

        final String sqlQuery = "SELECT * FROM contacts";

        log.info("list contacts send from db");
        return template.query(sqlQuery, RowMapper);

        return null;
    }


    public ContactEntity save(ContactEntity contact) {
        return null;
    }


    public ContactEntity get(Integer id) {
        return null;
    }


    public void deleteById(Integer id) {

    }
}
