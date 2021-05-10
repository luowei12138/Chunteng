package cn.bdqn.controller;

import cn.bdqn.common.Config;
import cn.bdqn.model.SysUsers;
import cn.bdqn.result.Result;
import cn.bdqn.result.ResultUtils;
import cn.bdqn.service.SysUsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @Package: cn.bdqn.controller
 * @Description: 用户，控制类
 * @Author hah
 * @Create 2021年03月30日 09时52分50秒
 */

@Controller
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    SysUsersService sysUsersService;


    @RequestMapping("/showImg")
    public void showImg(@RequestParam("userId") Long userId,
                        HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        SysUsers user = sysUsersService.queryById(userId);
        String headUrl = user.getHeadUrl();
        //获取路径 if(headUrl为空) Config.SESSION_IMAGER_DEFAULT = users.getHeadUrl()
        String path = (StringUtils.isEmpty(headUrl) ? Config.SESSION_IMAGER_DEFAULT : user.getHeadUrl());

        //文件输入流
        FileInputStream fileInputStream = new FileInputStream(path);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);//写入
        response.setContentType("image/*");

        OutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();

        outputStream.close();
        fileInputStream.close();
    }

    /**
     * @Author: hah
     * @Date: 2021-04-08 09:04:52
     * @Description: 进入用户列表
     * @param pageNo
     * @param model
     * @return java.lang.String
     **/
    @RequestMapping("/list")
    public String getUserList(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                              Model model) {

        PageHelper.startPage(pageNo, 4);
        List<SysUsers> usersList = sysUsersService.getUsersList();
        PageInfo<SysUsers> info = new PageInfo<>(usersList);
        model.addAttribute("pages", info);

        return "userList";
    }

    
    /**
     * @Author: hah
     * @Date: 2021-04-08 09:04:24
     * @Description: 进入添加用户页面
     * @return java.lang.String
     **/
    @GetMapping("/addUser")
    public String toaddUser() {
        return "userAdd";
    }

    /**
     * @Author: hah
     * @Date: 2021-04-08 10:04:17
     * @Description: 判断用户名，是否存在
     * @param account
     * @return cn.bdqn.result.Result
     **/
    @ResponseBody
    @RequestMapping("/accountExist.json")
    public Result accountExist(@RequestParam("account")String account){
        return sysUsersService.accountExist(account);
    }

    /*开始添加*/
    @PostMapping("/addUser")
    public String doaddUser(SysUsers sysUsers
                            ,@RequestParam(value = "userImg",required = false) MultipartFile multipartFile
                            ,HttpServletRequest request,HttpServletResponse response
                            ,Model model) {
        //将Session中的用户id取出，set到添加用户中的，创建人中
        Long aLong = ((SysUsers) request.getSession().getAttribute(Config.USER_SESSION)).getId();
        sysUsers.setCreatedUserId(aLong);

        Result<SysUsers> result = sysUsersService.addUser(sysUsers, multipartFile);
        if("200".equals(result.getCode())){
            return "redirect:/api/users/list";
        }

        //返回错误信息
        request.setAttribute("fileUploadError",result.getMsg());
        return "userAdd";
    }

    @ResponseBody
    @PostMapping("/getDoctorList.json")
    public Result<List<SysUsers>> getDoctorList(@RequestParam(required = false) Integer departmentId) {
        System.out.println("departmentId为："+departmentId);
        return sysUsersService.getDoctorListByDepartmentId(departmentId);
    }

}
