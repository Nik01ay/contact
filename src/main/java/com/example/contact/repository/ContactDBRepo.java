package com.example.contact.repository;

import com.example.contact.entity.ContactEntity;
import com.example.contact.repository.mapper.ContactRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.ArgumentPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Primary
@Repository
@RequiredArgsConstructor
public class ContactDBRepo implements Repo {

    private final JdbcTemplate jdbcTemplate;

    public List<ContactEntity> getAll() {
        String sqlQuery = "SELECT * FROM contacts";
        log.info("list contacts send from db");
        return jdbcTemplate.query(sqlQuery, new ContactRowMapper());
    }

    public ContactEntity save(ContactEntity contact) {
        if (get(contact.getId()).isEmpty()) {
            log.warn("not found contact with id {}. Create new contact", contact.getId());
            create(contact);
        }
        String sqlQuery =
                "UPDATE contacts SET first_name = ?, last_name = ?, email = ?, phone_number = ? WHERE id = ?";
        jdbcTemplate.update(sqlQuery,
                contact.getFirstName(),
                contact.getLastName(),
                contact.getEmail(),
                contact.getPhoneNumber(),
                contact.getId());
        log.info("Contact with id {} refresh", contact.getId());
        return contact;
    }

    public Optional<ContactEntity> get(Integer id) {
        final String sqlQuery = "SELECT * FROM contacts WHERE id = ?";
        log.debug("Calling DatabaseContactRepository->findById with ID: {}", id);
        ContactEntity contact = DataAccessUtils.singleResult(
                jdbcTemplate.query(
                        sqlQuery,
                        new ArgumentPreparedStatementSetter(new Object[]{id}),
                        new RowMapperResultSetExtractor<>(new ContactRowMapper(), 1)
                )
        );
        return Optional.ofNullable(contact);
    }

    public ContactEntity create(ContactEntity contact){
        String sqlQuery =
                "INSERT INTO contacts(first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getPhoneNumber());
        log.info("Contact id {} created", contact.getId());
        return contact;
    }

    public void deleteById(Integer id) {
        final String sqlQuery = "DELETE from  contacts WHERE id= ?";
        log.info("Contact id {} deleted", id);
        jdbcTemplate.update(sqlQuery, id);
    }
}
