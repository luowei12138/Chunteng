package cn.bdqn.controller;

import cn.bdqn.common.Config;
import cn.bdqn.model.*;
import cn.bdqn.req.RegistryReq;
import cn.bdqn.result.Result;
import cn.bdqn.service.*;
import cn.bdqn.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * @Package: cn.bdqn.controller
 * @Description: 登入及页面跳转，控制类
 * @Author hah
 * @Create 2021年03月30日 09时53分28秒
 */
@Controller
@RequestMapping("/api")
public class AutoController {

    @Autowired
    SysUsersService sysUsersService;

    @Autowired
    SysMenusService sysMenusService;

    @Autowired
    SysRolesService sysRolesService;

    @Autowired
    DepartmentService departmentService;
    @Autowired
    ScheduleService scheduleService;

    @Autowired
    RegistryService registryService;
    @Autowired
    MedicalAdviceService medicalAdviceService;


    /**
     * @Author: hah
     * @Date: 2021-03-30 09:03:55
     * @Description: 进入登入页面
     * @return java.lang.String
     **/
    @RequestMapping("/Login")
    public String Login() {
        return "login";
    }

    /**
     * @Author: hah
     * @Date: 2021-03-30 14:03:40
     * @Description: 登入方法
     * @param sysUsers
     * @param request
     * @param response
     * @param model
     * @return java.lang.String
     **/
    @RequestMapping("doLogin")
    public String doLogin(SysUsers sysUsers, HttpServletRequest request, HttpServletResponse response, Model model){

        //根据用户名判断，用户是否，存在
        Result<SysUsers> result = sysUsersService.dologin(sysUsers);

        if("200".equals(result.getCode())){
            HttpSession session = request.getSession();
            session.setAttribute(Config.USER_SESSION,result.getData());
            try {
                response.sendRedirect(request.getContextPath() + "/api/users/index");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("error",result.getMsg());
        model.addAttribute("sysUser", sysUsers);
        return "login";
    }

    /**
     * @Author: hah
     * @Date: 2021-03-30 14:03:15
     * @Description: 进入主页面
     * @param model
     * @param request
     * @return java.lang.String
     **/
    @RequestMapping("/users/index")
    public String main(Model model,HttpServletRequest request) {
        System.out.println("进入主页面");
        return "main";
    }

    /**
     * @Author: hah
     * @Date: 2021-03-30 15:03:47
     * @Description: 加载菜单
     * @param userId
     * @return java.util.List<cn.bdqn.model.SysMenus>
     **/
    @ResponseBody
    @GetMapping("/getMenuList.json")
    public Result<List<SysMenus>> getMenuList(@RequestParam("userId")Integer userId){
        return sysMenusService.getMenuList(userId);
    }

    /**
     * @Author: hah
     * @Date: 2021-03-30 15:03:07
     * @Description: 退出
     * @param session
     * @return java.lang.String
     **/
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(Constants.USER_SESSION);
        return "login";
    }

    /**
     * @Author: hah
     * @Date: 2021-04-08 09:04:59
     * @Description: 加载 用户类型
     * @return cn.bdqn.result.Result<java.util.List<cn.bdqn.model.SysRoles>>
     **/
    @ResponseBody
    @GetMapping("/auth/getRoleList.json")
    public Result<List<SysRoles>> getRoleList(){
        return sysRolesService.getRoleList();
    }

    @ResponseBody
    @GetMapping("/department/getDepartmentList.json")
    public Result<List<Department>> getDepartmentList(){
        return departmentService.getAlldepartment();
    }

    @ResponseBody
    @RequestMapping("/schedule/getDoctorList.json")
    public Result<List<Schedule>> getDoctorList(Schedule schedule){
        return scheduleService.getDoctorList(schedule);
    }

    //开始就诊
    @RequestMapping("/consultation/consultationAdd")
    public String consultationAdd(@RequestParam Integer id,
                                  HttpServletRequest request,
                                  Model model) throws Exception {

        Result<RegistryReq> result = registryService.consultationAdd(((SysUsers) request.getSession().getAttribute("userSession")).getId().intValue(), id);
        model.addAttribute("register", result.getData());
        model.addAttribute("medicalAdvice", medicalAdviceService.queryByRegistryId(id));

        return "consultationAdd";
    }

    @ResponseBody
    @RequestMapping("/consultation/medicalAdviceAdd.json")
    public Result<MedicalAdvice> medicalAdviceAdd(MedicalAdvice medicalAdvice) {
        return medicalAdviceService.medicalAdviceAdd(medicalAdvice);
    }

    @RequestMapping("consultation/consultationEnd")
    public String consultationEnd(@RequestParam Integer registryId) throws Exception {
        boolean b = registryService.consultationEnd(registryId);
        if (b) {
            return "redirect:/api/register/registerInfoList";
        } else {
            throw new Exception("结束失败！");
        }
    }


}
