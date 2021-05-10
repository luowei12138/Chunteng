package cn.bdqn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 医嘱表(MedicalAdvice)实体类
 *
 * @author makejava
 * @since 2021-03-19 22:55:05
 */
public class MedicalAdvice implements Serializable {
    private static final long serialVersionUID = 961988130670502187L;

    private Long id;
    /**
     * 挂号单表主键ID
     */
    private Long registryId;
    /**
     * 就诊医师用户ID
     */
    private Long userId;
    /**
     * 病人主诉
     */
    private String chiefComplaint;
    /**
     * 诊断情况
     */
    private String diagnosis;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 修改时间
     */
    private Date updatedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegistryId() {
        return registryId;
    }

    public void setRegistryId(Long registryId) {
        this.registryId = registryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

}
