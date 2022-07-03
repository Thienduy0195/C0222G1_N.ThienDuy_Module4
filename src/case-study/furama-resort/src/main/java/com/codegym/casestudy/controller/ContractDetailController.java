package com.codegym.casestudy.controller;

import com.codegym.casestudy.dto.contract_dto.ContractDetailDto;
import com.codegym.casestudy.dto.contract_dto.ContractDto;
import com.codegym.casestudy.dto.customer_dto.CustomerDtoJoin;
import com.codegym.casestudy.model.contract.Contract;
import com.codegym.casestudy.model.contract.ContractDetail;
import com.codegym.casestudy.service.interface_contract.IAttachService;
import com.codegym.casestudy.service.interface_contract.IContractDetailService;
import com.codegym.casestudy.service.interface_contract.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {

    @Autowired
    IContractDetailService iContractDetailService;
    @Autowired
    IContractService contractService;
    @Autowired
    IAttachService attachService;

    @GetMapping()
    public String goContractDetail(Model model,
                                   @RequestParam(defaultValue = "0") Integer page,
                                   @RequestParam(defaultValue = "4") Integer pageSize,
                                   @RequestParam Optional<String> sort,
                                   @RequestParam Optional<String> dir){
        Pageable pageable;
        String dirVal = dir.orElse("");
        String sortVal = sort.orElse("");
        if ("".equals(sortVal)) {
            pageable = PageRequest.of(page, pageSize);
        } else {
            if ("asc".equals(dirVal)) {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).ascending());
            } else {
                pageable = PageRequest.of(page, pageSize, Sort.by(sortVal).descending());
            }
        }
        model.addAttribute("sortVal", sortVal);
        model.addAttribute("dirVal", dirVal);
        model.addAttribute("contractDetail", iContractDetailService.findAll(pageable));
        return "contract/contract_detail_list";
    }

    @GetMapping("/goCreate")
    public String goCreateContract(Model model) {
        model.addAttribute("contractDetailDto", new ContractDetailDto());
        model.addAttribute("contract",contractService.findAll());
        model.addAttribute("attachService",attachService.findAll());
        return "contract/create_contract_detail";
    }

    @PostMapping("/save")
    public String createFacility(@ModelAttribute @Validated ContractDetailDto contractDetailDto,
                                 BindingResult bindingResult,
                                 Model model){
        new ContractDetailDto().validate(contractDetailDto,bindingResult);
        if(bindingResult.hasFieldErrors()){
            model.addAttribute("contract",contractService.findAll());
            model.addAttribute("attachService",attachService.findAll());
            return "contract/create_contract_detail";
        }else{
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contractDetail);
            this.iContractDetailService.save(contractDetail);
            return "redirect:/contractDetail";
        }
    }

}
