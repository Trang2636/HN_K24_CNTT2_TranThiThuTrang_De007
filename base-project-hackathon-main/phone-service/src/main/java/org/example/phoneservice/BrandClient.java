package org.example.phoneservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "brand-service")
public interface BrandClient {
    @GetMapping("/api/brands/{id}")
    BrandResponse getBrandById(@PathVariable("id") Long id);
}
