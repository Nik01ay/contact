package com.example.contact.repository.mapper;

import com.example.contact.entity.ContactEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<ContactEntity> {
    @Override
    public ContactEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        ContactEntity contact = new ContactEntity();
        contact.setId(rs.getInt("id"));
        contact.setEmail(rs.getString("email"));
        contact.setFirstName(rs.getString("first_name"));
        contact.setLastName(rs.getString("last_name"));
        contact.setPhoneNumber(rs.getString("phone_number"));
        return contact;
    }
}
