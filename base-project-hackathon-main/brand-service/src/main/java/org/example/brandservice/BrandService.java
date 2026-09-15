package org.example.brandservice;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {
    private final BrandRepository brandRepository;
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }
}
