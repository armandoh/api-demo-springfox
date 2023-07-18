package com.epam.demo.service;



import com.epam.demo.dto.PhoneRequest;
import com.epam.demo.dto.PhoneResponse;
import com.epam.demo.jpa.model.Phone;
import com.epam.demo.jpa.repository.PhoneRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<PhoneResponse> getAllPhones() {
        List<Phone> phones = phoneRepository.findAll();
        return phones.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    public PhoneResponse getPhoneById(Long id) {
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        if (optionalPhone.isPresent()) {
            return convertToDTO(optionalPhone.get());
        }
        throw new IllegalArgumentException("Phone not found");
    }


    public PhoneResponse createPhone(PhoneRequest phoneDTO) {
        Phone phone = new Phone();
        BeanUtils.copyProperties(phoneDTO, phone);
        Phone savedPhone = phoneRepository.save(phone);
        return convertToDTO(savedPhone);
    }


    public PhoneResponse updatePhone(Long id, PhoneRequest phoneDTO) {
        Optional<Phone> optionalPhone = phoneRepository.findById(id);
        if (optionalPhone.isPresent()) {
            Phone phone = optionalPhone.get();
            BeanUtils.copyProperties(phoneDTO, phone);
            Phone updatedPhone = phoneRepository.save(phone);
            return convertToDTO(updatedPhone);
        }
        throw new IllegalArgumentException("Phone not found");
    }

    public void deletePhone(Long id) {
        phoneRepository.deleteById(id);
    }

    private PhoneResponse convertToDTO(Phone phone) {
        PhoneResponse phoneDTO = new PhoneResponse();
        BeanUtils.copyProperties(phone, phoneDTO);
        return phoneDTO;
    }

}
