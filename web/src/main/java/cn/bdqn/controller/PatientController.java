package cn.bdqn.controller;

import cn.bdqn.model.Department;
import cn.bdqn.model.Patient;
import cn.bdqn.result.Result;
import cn.bdqn.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Package: cn.bdqn.controller
 * @Description:
 * @Author hah
 * @Create 2021年04月13日 09时07分41秒
 */
@Controller
@RequestMapping("api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping("/patientAdd")
    public String patientAdd(){
        return "patientAdd";
    }

    @ResponseBody
    @RequestMapping("/getPatientByIdMedicare.json")
    public Result<Patient> getPatientByIdMedicare(@RequestParam String idMedicare){
        return patientService.isNotIdMedicare(idMedicare);
    }

    @ResponseBody
    @RequestMapping("/getPatientByIdCard.json")
    public Result<Patient> getPatientByIdCard(@RequestParam String idCard){
        return patientService.isNotIdCare(idCard);
    }


    @RequestMapping("/createVisitCard")
    public String createVisitCard(Patient patient){
        int insert = patientService.insert(patient);
        if(insert == 1){
            return "redirect:/api/users/index";
        }
        return "redirect:/api/patient/patientAdd";
    }
}
