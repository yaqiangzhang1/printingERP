package cn.stylefeng.guns.modular.archives.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 设备档案
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-01
 */
@TableName("machine")
public class Machine implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id 设备编码
     */
    @TableId(value = "mc_number")
    private String mcNumber;
    /**
     * 设备名称
     */
    @TableField("mc_name")
    private String mcName;

    /**
     * 规格型号
     */
    @TableField("mc_model")
    private String mcModel;

    /**
     * 生产地址
     */
    @TableField("mc_address")
    private String mcAddress;

    /**
     * 出厂日期
     */
    @TableField("factorydate")
    private Date factorydate;

    /**
     * 出厂编号
     */
    @TableField("factorynumber")
    private String factorynumber;

    /**
     * 使用年限
     */
    @TableField("useyear")
    private Integer useyear;

    /**
     * 保养周期
     */
    @TableField("cycle")
    private Integer cycle;

    /**
     * 售后电话
     */
    @TableField("telephone")
    private String telephone;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建人
     */
    @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField(value = "update_user", fill = FieldFill.UPDATE)
    private Long updateUser;

    @Override
    public String toString() {
        return "Machine{" +
                "mcNumber='" + mcNumber + '\'' +
                ", mcName='" + mcName + '\'' +
                ", mcModel='" + mcModel + '\'' +
                ", mcAddress='" + mcAddress + '\'' +
                ", factorydate=" + factorydate +
                ", factorynumber='" + factorynumber + '\'' +
                ", useyear=" + useyear +
                ", cycle=" + cycle +
                ", telephone='" + telephone + '\'' +
                ", remarks='" + remarks + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", createUser=" + createUser +
                ", updateTime=" + updateTime +
                ", updateUser=" + updateUser +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMcNumber() {
        return mcNumber;
    }

    public void setMcNumber(String mcNumber) {
        this.mcNumber = mcNumber;
    }

    public String getMcName() {
        return mcName;
    }

    public void setMcName(String mcName) {
        this.mcName = mcName;
    }

    public String getMcModel() {
        return mcModel;
    }

    public void setMcModel(String mcModel) {
        this.mcModel = mcModel;
    }

    public String getMcAddress() {
        return mcAddress;
    }

    public void setMcAddress(String mcAddress) {
        this.mcAddress = mcAddress;
    }

    public Date getFactorydate() {
        return factorydate;
    }

    public void setFactorydate(Date factorydate) {
        this.factorydate = factorydate;
    }

    public String getFactorynumber() {
        return factorynumber;
    }

    public void setFactorynumber(String factorynumber) {
        this.factorynumber = factorynumber;
    }

    public Integer getUseyear() {
        return useyear;
    }

    public void setUseyear(Integer useyear) {
        this.useyear = useyear;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }
}
