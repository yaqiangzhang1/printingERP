package cn.stylefeng.guns.modular.archives.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 客户档案
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-01
 */
@TableName("customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "c_number")
    private String cNumber;

    /**
     * 客户名称
     */
    @TableField("c_name")
    private String cName;

    /**
     * 所属行业
     */
    @TableField("c_trade")
    private String cTrade;

    /**
     * 客户性质
     */
    @TableField("c_nature")
    private String cNature;

    /**
     * 客户来源
     */
    @TableField("c_source")
    private String cSource;

    /**
     * 客户类型
     */
    @TableField("c_type")
    private String cType;

    /**
     * 所在地区
     */
    @TableField("c_region")
    private String cRegion;

    /**
     * 业务员
     */
    @TableField("salesman")
    private String salesman;

    /**
     * 地址
     */
    @TableField("address")
    private String address;

    /**
     * 报价折扣
     */
    @TableField("discount")
    private String discount;


    /**
     *
     * 状态
     *
     * */
    @TableField("status")
    private String status;

    @Override
    public String toString() {
        return "Customer{" +
                "cNumber='" + cNumber + '\'' +
                ", cName='" + cName + '\'' +
                ", cTrade='" + cTrade + '\'' +
                ", cNature='" + cNature + '\'' +
                ", cSource='" + cSource + '\'' +
                ", cType='" + cType + '\'' +
                ", cRegion='" + cRegion + '\'' +
                ", salesman='" + salesman + '\'' +
                ", address='" + address + '\'' +
                ", discount='" + discount + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", createUser=" + createUser +
                ", updateTime=" + updateTime +
                ", updateUser=" + updateUser +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 联系人
     */
    @TableField("contacts")
    private String contacts;

    /**
     * 手机号码
     */
    @TableField("phone")
    private String phone;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcTrade() {
        return cTrade;
    }

    public void setcTrade(String cTrade) {
        this.cTrade = cTrade;
    }

    public String getcNature() {
        return cNature;
    }

    public void setcNature(String cNature) {
        this.cNature = cNature;
    }

    public String getcSource() {
        return cSource;
    }

    public void setcSource(String cSource) {
        this.cSource = cSource;
    }

    public String getcType() {
        return cType;
    }

    public void setcType(String cType) {
        this.cType = cType;
    }

    public String getcRegion() {
        return cRegion;
    }

    public void setcRegion(String cRegion) {
        this.cRegion = cRegion;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
