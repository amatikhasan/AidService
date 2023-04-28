package com.autoaid.aid.service;

import com.autoaid.aid.client.BreakdownFeignClient;
import com.autoaid.aid.model.AidProvider;
import com.autoaid.aid.model.AidRequest;
import com.autoaid.aid.model.Breakdown;
import com.autoaid.aid.repository.AidProviderRepository;
import com.autoaid.aid.repository.AidRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AidService {

    private AidProviderRepository aidProviderRepository;
    private  AidRequestRepository aidRequestRepository;
    private BreakdownFeignClient breakdownFeignClient;

    public AidService(AidProviderRepository aidProviderRepository, AidRequestRepository aidRequestRepository, BreakdownFeignClient breakdownFeignClient) {
        this.aidProviderRepository = aidProviderRepository;
        this.aidRequestRepository = aidRequestRepository;
        this.breakdownFeignClient = breakdownFeignClient;
    }

    public AidRequest createAidRequest(AidRequest aidRequest) {
        return aidRequestRepository.save(aidRequest);
    }

    public Optional<AidRequest> getAidRequest(Long id) {
        return aidRequestRepository.findById(id);
    }

    public List<AidRequest> getAllAidRequest() {
        return aidRequestRepository.findAll();
    }

    public AidRequest updateAidRequest(AidRequest aidRequest) {
        return aidRequestRepository.save(aidRequest);
    }

    public void deleteAidRequest(Long id) {
        aidRequestRepository.deleteById(id);
    }

    public void deleteAllAidRequest() {
        aidRequestRepository.deleteAll();
    }

    public List<AidProvider> getAllAidProvider() {
        return aidProviderRepository.findAll();
    }
    public AidProvider createAidProvider(AidProvider aidProvider) {
        return aidProviderRepository.save(aidProvider);
    }

    public void deleteAllAidProvider() {
        aidProviderRepository.deleteAll();
    }


    public List<Breakdown> getAllBreakdown() {

        return breakdownFeignClient.getAllBreakdowns();
    }
}
