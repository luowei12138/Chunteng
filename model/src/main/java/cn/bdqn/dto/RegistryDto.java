package cn.bdqn.dto;



import java.util.Date;

public class RegistryDto {

    private Long id;
    /**
     * 病人表主键ID
     */
    private Long patientId;
    private Object patientSex;
    private String patientSexName;
    private String patientName;
    private String patientIdCard;
    private String departmentName;
    //1-->已挂号，未问诊；2-->正在问诊；3-->问诊结束'
    private String statusName;
    private String doctorName;
    /**
     * 挂号单状态 1-->已挂号，未问诊；2-->正在问诊；3-->问诊结束
     */
    private Object status;
    /**
     * 挂号时间
     */
    private Date registryTime;
    /**
     * 创建时间
     */
    private Date createdTime;

    public RegistryDto() {
    }

    public RegistryDto(Long id, Long patientId, Object patientSex, String patientSexName, String patientName, String patientIdCard, String departmentName, String statusName, String doctorName, Object status, Date registryTime, Date createdTime) {
        this.id = id;
        this.patientId = patientId;
        this.patientSex = patientSex;
        this.patientSexName = patientSexName;
        this.patientName = patientName;
        this.patientIdCard = patientIdCard;
        this.departmentName = departmentName;
        this.statusName = statusName;
        this.doctorName = doctorName;
        this.status = status;
        this.registryTime = registryTime;
        this.createdTime = createdTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Object getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(Object patientSex) {
        this.patientSex = patientSex;
        this.setPatientSexIdName((Integer) patientSex);
    }

    public String getPatientSexName() {
        return patientSexName;
    }

    public void setPatientSexName(String patientSexName) {
        this.patientSexName = patientSexName;
    }

    private void setPatientSexIdName(int patientSexIdName) {
        this.patientSexName = patientSexIdName == 1 ? "女" : "男";
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientIdCard() {
        return patientIdCard;
    }

    public void setPatientIdCard(String patientIdCard) {
        this.patientIdCard = patientIdCard;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    private void setStatusIdName(int statusId) {
        switch (statusId) {
            case 1:
                this.statusName = "已挂号，未问诊";
                break;
            case 2:
                this.statusName = "正在问诊";
                break;
            case 3:
                this.statusName = "问诊结束";
                break;
        }
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
        this.setStatusIdName((Integer) status);
    }

    public Date getRegistryTime() {
        return registryTime;
    }

    public void setRegistryTime(Date registryTime) {
        this.registryTime = registryTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


}
