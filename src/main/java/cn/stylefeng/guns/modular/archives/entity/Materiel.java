package cn.stylefeng.guns.modular.archives.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 物料档案
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-01
 */
@TableName("materiel")
public class Materiel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id 物料编码
     */
    @TableId(value = "m_number")
    private String mNumber;
    /**
     * 物料编码
     */
    @TableField("m_name")
    private String mName;

    /**
     * 品牌
     */
    @TableField("m_brand")
    private String mBrand;

    /**
     * 物料种类
     */
    @TableField("m_type")
    private String mType;

    /**
     * 单位
     */
    @TableField("unit")
    private String unit;

    /**
     * 规格
     */
    @TableField("specifications")
    private String specifications;

    /**
     * 报价金额
     */
    @TableField("amount")
    private Double amount;

    /**
     * 最高库存
     */
    @TableField("maxstock")
    private Double maxstock;

    /**
     * 最低库存
     */
    @TableField("minstock")
    private Double minstock;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    @Override
    public String toString() {
        return "Materiel{" +
                "mNumber='" + mNumber + '\'' +
                ", mName='" + mName + '\'' +
                ", mBrand='" + mBrand + '\'' +
                ", mType='" + mType + '\'' +
                ", unit='" + unit + '\'' +
                ", specifications='" + specifications + '\'' +
                ", amount=" + amount +
                ", maxstock=" + maxstock +
                ", minstock=" + minstock +
                ", remarks='" + remarks + '\'' +
                ", status='" + status + '\'' +
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getMaxstock() {
        return maxstock;
    }

    public void setMaxstock(Double maxstock) {
        this.maxstock = maxstock;
    }

    public Double getMinstock() {
        return minstock;
    }

    public void setMinstock(Double minstock) {
        this.minstock = minstock;
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
