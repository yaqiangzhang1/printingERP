package cn.stylefeng.guns.modular.business.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-01
 */
@TableName("m_order")
public class MOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 单据编号
     */
    @TableId(value = "o_number")
    private String oNumber;

    /**
     * 订单类型
     */
    @TableField("o_type")
    private String oType;

    /**
     * 订单状态
     */
    @TableField("o_ststus")
    private String oStstus;

    /**
     * 业务员
     */
    @TableField("salesman")
    private String salesman;

    /**
     * 客户名称
     */
    @TableField("c_name")
    private String cName;

    /**
     * 产品名称
     */
    @TableField("p_name")
    private String pName;

    /**
     * 产品开数
     */
    @TableField("p_number")
    private String pNumber;

    /**
     * 产品尺寸
     */
    @TableField("p_size")
    private String pSize;

    /**
     * 订货数量
     */
    @TableField("o_quantity")
    private Integer oQuantity;

    /**
     * 单位
     */
    @TableField("unit")
    private String unit;


    /**
     * 客户订单号
     */
    @TableField("c_o_number")
    private String cONumber;



    /**
     * 下单日期
     */
    @TableField("ordertime")
    private Date ordertime;


    /**
     * 联系人
     */
    @TableField("contacts")
    private String contacts;


    /**
     * 联系方式
     */
    @TableField("phone")
    private String phone;


    /**
     * 交货日期
     */
    @TableField("deliverydate")
    private Date deliverydate;


    /**
     * 结账日期
     */
    @TableField("settlementdate")
    private Date settlementdate;


    /**
     * 印品类型
     */
    @TableField("printtype")
    private String printtype;


    /**
     * 在线订单号
     */
    @TableField("onlinenumber")
    private String onlinenumber;


    /**
     * 报价金额
     */
    @TableField("onlineamount")
    private Double onlineamount;


    /**
     * 订单总金额
     */
    @TableField("orderamount")
    private Double orderamount;



    /**
     * 上传路径
     */
    @TableField("upload")
    private String upload;




    /**
     * 产品说明
     */
    @TableField("p_description")
    private String pDescription;


    /**
     * 客户提供
     */
    @TableField("c_provide")
    private String cProvide;

    /**
     * 印刷工艺要求
     */
    @TableField("printask")
    private String printask;


    /**
     * 印刷后工艺要求
     */
    @TableField("printafterask")
    private String printafterask;


    /**
     * 拼晒要求
     */
    @TableField("pinshaiask")
    private String pinshaiask;


    /**
     * 外发要求
     */
    @TableField("waifaask")
    private String waifaask;


    /**
     * 送货要求
     */
    @TableField("deliveryask")
    private String deliveryask;

    /**
     * 说明备注
     */
    @TableField("description")
    private String description;

    /**
     *
     * 状态
     *
     * */
    @TableField("status")
    private String status;

    /**
     * 订单备注
     */
    @TableField("remarks")
    private String remarks;


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
        return "MOrder{" +
                "oNumber='" + oNumber + '\'' +
                ", oType='" + oType + '\'' +
                ", oStstus='" + oStstus + '\'' +
                ", salesman='" + salesman + '\'' +
                ", cName='" + cName + '\'' +
                ", pName='" + pName + '\'' +
                ", pNumber='" + pNumber + '\'' +
                ", pSize='" + pSize + '\'' +
                ", oQuantity=" + oQuantity +
                ", unit='" + unit + '\'' +
                ", cONumber='" + cONumber + '\'' +
                ", ordertime=" + ordertime +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", deliverydate=" + deliverydate +
                ", settlementdate=" + settlementdate +
                ", printtype='" + printtype + '\'' +
                ", onlinenumber='" + onlinenumber + '\'' +
                ", onlineamount=" + onlineamount +
                ", orderamount=" + orderamount +
                ", upload='" + upload + '\'' +
                ", pDescription='" + pDescription + '\'' +
                ", cProvide='" + cProvide + '\'' +
                ", printask='" + printask + '\'' +
                ", printafterask='" + printafterask + '\'' +
                ", pinshaiask='" + pinshaiask + '\'' +
                ", waifaask='" + waifaask + '\'' +
                ", deliveryask='" + deliveryask + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", remarks='" + remarks + '\'' +
                ", createTime=" + createTime +
                ", createUser=" + createUser +
                ", updateTime=" + updateTime +
                ", updateUser=" + updateUser +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getoNumber() {
        return oNumber;
    }

    public void setoNumber(String oNumber) {
        this.oNumber = oNumber;
    }

    public String getoType() {
        return oType;
    }

    public void setoType(String oType) {
        this.oType = oType;
    }

    public String getoStstus() {
        return oStstus;
    }

    public void setoStstus(String oStstus) {
        this.oStstus = oStstus;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpNumber() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber = pNumber;
    }

    public String getpSize() {
        return pSize;
    }

    public void setpSize(String pSize) {
        this.pSize = pSize;
    }

    public Integer getoQuantity() {
        return oQuantity;
    }

    public void setoQuantity(Integer oQuantity) {
        this.oQuantity = oQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getcONumber() {
        return cONumber;
    }

    public void setcONumber(String cONumber) {
        this.cONumber = cONumber;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
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

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public Date getSettlementdate() {
        return settlementdate;
    }

    public void setSettlementdate(Date settlementdate) {
        this.settlementdate = settlementdate;
    }

    public String getPrinttype() {
        return printtype;
    }

    public void setPrinttype(String printtype) {
        this.printtype = printtype;
    }

    public String getOnlinenumber() {
        return onlinenumber;
    }

    public void setOnlinenumber(String onlinenumber) {
        this.onlinenumber = onlinenumber;
    }

    public Double getOnlineamount() {
        return onlineamount;
    }

    public void setOnlineamount(Double onlineamount) {
        this.onlineamount = onlineamount;
    }

    public Double getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(Double orderamount) {
        this.orderamount = orderamount;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getcProvide() {
        return cProvide;
    }

    public void setcProvide(String cProvide) {
        this.cProvide = cProvide;
    }

    public String getPrintask() {
        return printask;
    }

    public void setPrintask(String printask) {
        this.printask = printask;
    }

    public String getPrintafterask() {
        return printafterask;
    }

    public void setPrintafterask(String printafterask) {
        this.printafterask = printafterask;
    }

    public String getPinshaiask() {
        return pinshaiask;
    }

    public void setPinshaiask(String pinshaiask) {
        this.pinshaiask = pinshaiask;
    }

    public String getWaifaask() {
        return waifaask;
    }

    public void setWaifaask(String waifaask) {
        this.waifaask = waifaask;
    }

    public String getDeliveryask() {
        return deliveryask;
    }

    public void setDeliveryask(String deliveryask) {
        this.deliveryask = deliveryask;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
