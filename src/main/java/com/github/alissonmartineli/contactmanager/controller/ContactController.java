package com.github.alissonmartineli.contactmanager.controller;

import java.util.List;

import javax.validation.Valid;

import com.github.alissonmartineli.contactmanager.dto.request.ContactDTO;
import com.github.alissonmartineli.contactmanager.dto.response.MessageResponseDTO;
import com.github.alissonmartineli.contactmanager.exception.ContactNotFoundException;
import com.github.alissonmartineli.contactmanager.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/contacts")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public List<ContactDTO> findAll() {
        return contactService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactDTO findById(@PathVariable Long id) throws ContactNotFoundException {
        return contactService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid ContactDTO contactDTO) {
        return contactService.create(contactDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid ContactDTO contactDTO)
            throws ContactNotFoundException {
        return contactService.update(id, contactDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ContactNotFoundException {
        contactService.delete(id);
    }

}
