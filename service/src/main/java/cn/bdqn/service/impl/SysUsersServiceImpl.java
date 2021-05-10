package cn.bdqn.service.impl;

import cn.bdqn.common.Config;
import cn.bdqn.common.MD5Utils;
import cn.bdqn.mapper.SysUsersDao;
import cn.bdqn.model.SysUsers;
import cn.bdqn.result.Result;
import cn.bdqn.result.ResultEnum;
import cn.bdqn.result.ResultUtils;
import cn.bdqn.service.SysUsersService;
import cn.bdqn.util.PasswordUtil;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 用户表(SysUsers)表服务实现类
 *
 * @author makejava
 * @since 2021-03-19 22:55:14
 */
@Service("sysUsersService")
public class SysUsersServiceImpl implements SysUsersService {

    @Resource
    private SysUsersDao sysUsersDao;


    @Value("${windowsFilePath}")
    private String windowsFilePath;
    @Value("${linuxFilePath}")
    private String linuxFilePath;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUsers queryById(Long id) {
        return this.sysUsersDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUsers> queryAllByLimit(int offset, int limit) {
        return this.sysUsersDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUsers 实例对象
     * @return 实例对象
     */
    @Override
    public SysUsers insert(SysUsers sysUsers) {
        this.sysUsersDao.insert(sysUsers);
        return sysUsers;
    }

    /**
     * 修改数据
     *
     * @param sysUsers 实例对象
     * @return 实例对象
     */
    @Override
    public SysUsers update(SysUsers sysUsers) {
        this.sysUsersDao.update(sysUsers);
        return this.queryById(sysUsers.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUsersDao.deleteById(id) > 0;
    }

    /**
     * @Author: hah
     * @Date: 2021-03-25 13:03:52
     * @Description: 
     * @return java.util.List<cn.bdqn.model.SysUsers>
     **/
    @Override
    public List<SysUsers> getUsersList() {
        return sysUsersDao.getUsersList();
    }


    @Override
    public Result<SysUsers> dologin(SysUsers sysUsers) {
        SysUsers users = sysUsersDao.dologin(sysUsers.getAccount());
        if(ObjectUtils.isEmpty(users)){
            return ResultUtils.returnResult(ResultEnum.FAIL_USER_ACCOUNT_ISNULL);
        }
        // 2. 获取数据中的 加密字符
        // 3. 拼接 加密 比较
        //将需要验证的密码和，原对象的盐相加
        String encryptMD5 = MD5Utils.encryptMD5(sysUsers.getPassword(), users.getSalt());
        if(encryptMD5.equals(users.getPassword())){
            return ResultUtils.returnDataSuccess(users);
        }
        return ResultUtils.returnResult(ResultEnum. FAIL_USER_LOGIN_ERROR);
    }


    @Override
    public Result<SysUsers> accountExist(String account) {
        SysUsers users = sysUsersDao.dologin(account);
        //if为空，则可添加
        if (ObjectUtils.isEmpty(users)) {
            return ResultUtils.returnDataSuccess(users);
        }
        return ResultUtils.returnFail();
    }


    @Override
    public Result<SysUsers> addUser(SysUsers sysUsers, MultipartFile multipartFile) {
        String OSName = System.getProperty("os.name");
        String filePath = OSName.toLowerCase().startsWith("win") ? windowsFilePath:linuxFilePath;
        String fileName = null;
        System.out.println("====="+filePath);
        System.out.println("开始文件上传");
        {
            if(multipartFile == null || multipartFile.isEmpty()){
                return ResultUtils.returnResult(ResultEnum.FAIL_FILE_EMPTY);
            }
            if(multipartFile.getSize() > Config.FILE_SIZE){
                return ResultUtils.returnResult(ResultEnum.FAIL_FILE_SIZE_ERROR);
            }

            //获取文件名称
            fileName = multipartFile.getOriginalFilename();
            //获取当前时间，形成新名称
            fileName = System.currentTimeMillis()+fileName;
            System.out.println("文件名：" + fileName);
            //获取文件，后缀名
            String prefix = FilenameUtils.getExtension(fileName);

            if(!(Config.FILE_JEPG.equals(prefix)
                    ||Config.FILE_JPG.equals(prefix)
                    ||Config.FILE_PNEG.equals(prefix)
                    ||Config.FILE_JPEG.equals(prefix)
                    ||Config.FILE_PNG.equals(prefix))){
                //抛出FAIL_FILE_SUFFIX_ERROR("40003","文件格式不符合要求"),
                return ResultUtils.returnResult(ResultEnum.FAIL_FILE_SUFFIX_ERROR);
            }else {
                // 创建File对象,加入，文件地址和，名称
                File file = new File(filePath,fileName);
                // 判断文件是否存在
                if (!file.exists()) {
                    // 不存在 创建文件
                    file.mkdirs();
                }
                try{
                    // 保存文件
                    multipartFile.transferTo(file);
                    System.out.println("图片保存成功！");
                    // 保存图片路径
                    sysUsers.setHeadUrl(filePath + File.separator + fileName);
                    System.out.println(filePath + File.separator + fileName);
                } catch (IOException e) {
                    // 出现错误 保存失败
                    e.printStackTrace();
                    System.out.println("上传文件失败！");
                    return ResultUtils.returnResult(ResultEnum.FAIL);
                }
            }

        }

        //密码加油
        String salt = PasswordUtil.salt();
        //将盐和密码，存入对象中
        sysUsers.setSalt(salt);
        sysUsers.setPassword(PasswordUtil.encode(sysUsers.getPassword(), salt));
        // 存入创建和修改时间
        Date date = new Date();
        sysUsers.setCreatedTime(date);
        sysUsers.setUpdatedTime(date);
        Integer num = sysUsersDao.insert(sysUsers);
        if(num !=0 || num !=-1){
            return ResultUtils.returnSuccess();
        }
        return ResultUtils.returnResult(ResultEnum.FAIL_USER_ADD_ERROR);
    }

    @Override
    public Result<List<SysUsers>> getDoctorListByDepartmentId(Integer departmentId) {
        if (ObjectUtils.isEmpty(departmentId)) {
            return ResultUtils.returnFail(null);
        }
        System.out.println("SysUsersServiceImpl departmentId为："+departmentId);
        List<SysUsers> doctorList = sysUsersDao.getDoctorList(departmentId);
        System.out.println("doctorList为："+doctorList);
        return ResultUtils.returnDataSuccess(doctorList);
    }

}
