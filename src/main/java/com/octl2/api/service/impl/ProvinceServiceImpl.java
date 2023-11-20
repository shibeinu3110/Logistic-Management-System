package com.octl2.api.service.impl;

import com.octl2.api.dto.ProvinceDTO;
import com.octl2.api.repository.ProvinceRepository;
import com.octl2.api.service.ProvinceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepo;

    @Override
    public ProvinceDTO getBybId(long id) {
        return provinceRepo.getDtoById(id);
    }
}
