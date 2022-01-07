package com.github.alissonmartineli.contactmanager.repository;

import com.github.alissonmartineli.contactmanager.entity.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
