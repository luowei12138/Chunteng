package cn.bdqn.controller;

import cn.bdqn.common.PageUtils;
import cn.bdqn.dto.RegistryDto;
import cn.bdqn.model.Registry;
import cn.bdqn.req.MedicalAdviceReq;
import cn.bdqn.req.RegistryReq;
import cn.bdqn.result.Result;
import cn.bdqn.service.MedicalAdviceService;
import cn.bdqn.service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: cn.bdqn.controller
 * @Description:
 * @Author hah
 * @Create 2021年04月13日 10时44分48秒
 */
@Controller
@RequestMapping("/api/register")
public class RegistryController {

    @Autowired
    RegistryService registryService;
    @Autowired
    MedicalAdviceService medicalAdviceService;


    @RequestMapping("/registerAdd")
    public String registerAdd(){
        return "registerAdd";
    }

    @ResponseBody
    @RequestMapping("/createFee.json")
    public Result<Registry> createFee(@RequestParam(value = "sign",required = false) String sign){
        return registryService.createFee(sign);
    }

    @ResponseBody
    @RequestMapping("/register")
    public Result<Registry>  register(Registry registry,
                           @RequestParam(value = "idMedicare", required = false) String idMedicare,
                           @RequestParam(value = "sign", required = false) Integer sign) throws Exception {

        Result<Registry> result = registryService.register(registry, idMedicare, sign);
        return result;
    }


    @RequestMapping("/registerList")
    public String registerList(@ModelAttribute Registry registry,
                               @RequestParam(required = false) String idCard,
                               @RequestParam(required = false) Integer pageNo,
                               Model model) {
/*
        PageUtils<RegistryDto> pageUtils = registryService.registerList(registry, idCard, pageNo);

        model.addAttribute("registryList", pageUtils.getDatas());
        model.addAttribute("pages", pageUtils);
        // 回显
        model.addAttribute("queryStatus", registry.getStatus());
        model.addAttribute("queryIdCard", idCard);*/
        return "registerList";
    }


    @ResponseBody
    @RequestMapping("queryAllregisterList")
    public Result quserAllregisterList(RegistryReq registryReq){

        System.out.println("getPageNo为："+registryReq.getPageNo());
        System.out.println("getPageNo为："+registryReq.getIdCard());
        System.out.println("getPageNo为："+registryReq.getDepartmentId());
        System.out.println("getPageNo为："+registryReq.getStatus());

        return registryService.queryAllregisterList(registryReq);
    }

    @RequestMapping("/registerView/{id}")
    public String registerView(@PathVariable("id") Integer id, Model model) {

        RegistryReq registryReq = registryService.getById(id);
        MedicalAdviceReq medicalAdvice = medicalAdviceService.queryByRegistryId(id);
        model.addAttribute("register", registryReq);
        model.addAttribute("medicalAdvice", medicalAdvice);
        return "registerView";
    }

    @RequestMapping("/registerInfoList")
    public String registerInfoList(@ModelAttribute Registry registry,
                                   @RequestParam(required = false) String idCard,
                                   @RequestParam(required = false) Integer pageNo,
                                   Model model) {

        System.out.println("idCard："+idCard);
        System.out.println("pageNo："+pageNo);

        PageUtils<RegistryDto> pageUtils = registryService.registerList(registry, idCard, pageNo);

        model.addAttribute("registryList", pageUtils.getDatas());
        model.addAttribute("pages", pageUtils);
        // 回显
        model.addAttribute("queryStatus", registry.getStatus());
        model.addAttribute("queryIdCard", idCard);

        return "registerInfoList";
    }


}
