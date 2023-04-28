package com.autoaid.aid.client;

import com.autoaid.aid.model.Breakdown;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "BreakdownService")
public interface BreakdownFeignClient {
    @GetMapping("/breakdownapi/all")
    List<Breakdown> getAllBreakdowns();
}
