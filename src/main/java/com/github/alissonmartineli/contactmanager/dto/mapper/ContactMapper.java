package com.github.alissonmartineli.contactmanager.dto.mapper;

import com.github.alissonmartineli.contactmanager.dto.request.ContactDTO;
import com.github.alissonmartineli.contactmanager.entity.Contact;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    Contact toModel(ContactDTO contactDTO);

    ContactDTO toDTO(Contact dto);

}
