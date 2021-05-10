package cn.bdqn.req;

import java.util.Date;


public class MedicalAdviceReq {
    /**
     * 主键ID
     */
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

    public MedicalAdviceReq() {
    }

    public MedicalAdviceReq(Long registryId, Long userId) {
        this.registryId = registryId;
        this.userId = userId;
        this.chiefComplaint = "正在诊断...";
        this.diagnosis = "正在诊断...";
        this.updatedTime = this.createdTime = new Date();
    }

    /**
     * 就诊医师姓名
     */
    private String doctorName;

    /**
     * get set 方法
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setRegistryId(Long registryId) {
        this.registryId = registryId;
    }

    public Long getRegistryId() {
        return this.registryId;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
    }

    public String getChiefComplaint() {
        return this.chiefComplaint;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return this.diagnosis;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
