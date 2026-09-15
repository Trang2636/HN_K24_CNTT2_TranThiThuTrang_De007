package org.example.phoneservice;

import feign.FeignException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {

    private final PhoneRepository phoneRepository;
    private final BrandClient brandClient;

    public PhoneService(PhoneRepository phoneRepository, BrandClient brandClient) {
        this.phoneRepository = phoneRepository;
        this.brandClient = brandClient;
    }

    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    public Phone create(Phone phone) {
        if (phone.getBrandId() == null) {
            throw new IllegalArgumentException("brandId không được để trống");
        }

        try {
            brandClient.getBrandById(phone.getBrandId());
        } catch (FeignException.NotFound e) {
            throw new BrandNotFoundException("Không tìm thấy thương hiệu với brandId = " + phone.getBrandId());
        }

        return phoneRepository.save(phone);
    }
}
