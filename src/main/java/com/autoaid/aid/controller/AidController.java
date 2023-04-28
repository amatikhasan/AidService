package com.autoaid.aid.controller;

import com.autoaid.aid.model.AidRequest;
import com.autoaid.aid.service.AidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/aid")
public class AidController {

    private AidService aidService;

    @Autowired
    public AidController(AidService aidService) {
        this.aidService = aidService;
    }

    @GetMapping("/all")
    private String getAllAidRequest(Model model) {
        model.addAttribute("aidRequestList", aidService.getAllAidRequest());
        return "aid-details";
    }

    @PostMapping("/create")
    private String createAidRequest(AidRequest aidRequest) {
        aidService.createAidRequest(aidRequest);
        return "redirect:/aid-form";
    }

    @GetMapping("/payment")
    private String updateAidPayment(AidRequest aidRequest) {
        return "redirect:http://localhost:8083/payment/update/" + aidRequest.getId();
    }

    @GetMapping("/get/{id}")
    private AidRequest getAidRequest(@PathVariable Long id) {
        return aidService.getAidRequest(id).get();
    }

    @PutMapping("/update")
    private AidRequest updateAidRequest(AidRequest aidRequest) {
        return aidService.updateAidRequest(aidRequest);
    }

    @DeleteMapping("/delete/{id}")
    private void deleteAidRequest(@PathVariable Long id) {
        aidService.deleteAidRequest(id);
    }

}
