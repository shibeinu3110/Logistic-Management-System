package com.octl2.api.service.impl;

import com.octl2.api.repository.PartnerRepository;
import com.octl2.api.service.PartnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PartnerServiceImpl implements PartnerService {
    private final PartnerRepository partnerRepository;




}
