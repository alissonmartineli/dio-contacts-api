package com.github.alissonmartineli.contactmanager.service;

import java.util.List;

import com.github.alissonmartineli.contactmanager.dto.mapper.ContactMapper;
import com.github.alissonmartineli.contactmanager.dto.request.ContactDTO;
import com.github.alissonmartineli.contactmanager.dto.response.MessageResponseDTO;
import com.github.alissonmartineli.contactmanager.entity.Contact;
import com.github.alissonmartineli.contactmanager.exception.ContactNotFoundException;
import com.github.alissonmartineli.contactmanager.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ContactService {

    private final ContactRepository contactRepository;

    private final ContactMapper contactMapper;

    public List<ContactDTO> findAll() {
        List<Contact> contacts = contactRepository.findAll();

        return contacts.stream()
                .map(contactMapper::toDTO)
                .collect(java.util.stream.Collectors.toList());
    }

    public ContactDTO findById(Long id) throws ContactNotFoundException {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));

        return contactMapper.toDTO(contact);
    }

    public MessageResponseDTO create(ContactDTO contactDTO) {
        Contact contact = contactMapper.toModel(contactDTO);
        Contact savedContact = contactRepository.save(contact);

        return createMessageResponse("Contact successfully created with ID ", savedContact.getId());
    }

    public MessageResponseDTO update(Long id, ContactDTO contactDTO) throws ContactNotFoundException {
        contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));

        Contact updatedContact = contactMapper.toModel(contactDTO);
        updatedContact.setId(id);

        Contact savedContact = contactRepository.save(updatedContact);

        return createMessageResponse("Contact successfully updated with ID ", savedContact.getId());
    }

    public void delete(Long id) throws ContactNotFoundException {
        contactRepository.findById(id).orElseThrow(() -> new ContactNotFoundException(id));

        contactRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
