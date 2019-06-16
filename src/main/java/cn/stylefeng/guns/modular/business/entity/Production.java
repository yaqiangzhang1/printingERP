package cn.stylefeng.guns.modular.business.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 生产信息
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-01
 */
@TableName("production")
public class Production implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id")
    private long id;

    /**
     * 订单编号
     */
    @TableField("o_number")
    private String oNumber;

    /**
     * 项目
     */
    @TableField("project")
    private String project;

    /**
     * p数
     */
    @TableField("p_number")
    private Integer pNumber;

    /**
     * 库房
     */
    @TableField("room")
    private String room;

    /**
     * 物料名称
     */
    @TableField("m_name")
    private String mName;

    /**
     * 规格
     */
    @TableField("specifications")
    private String specifications;

    /**
     * 品牌
     */
    @TableField("m_brand")
    private String mBrand;

    /**
     * 单位
     */
    @TableField("unit")
    private String unit;

    /**
     * 拼数
     */
    @TableField("pinnumber")
    private Integer pinnumber;


    /**
     * 裁纸开数
     */
    @TableField("tailorknumber")
    private String tailorknumber;



    /**
     * 裁纸尺寸
     */
    @TableField("tailorszie")
    private String tailorszie;


    /**
     * 正色
     */
    @TableField("zcolour")
    private String zcolour;


    /**
     * 反色
     */
    @TableField("fcolour")
    private String fcolour;


    /**
     * 套数
     */
    @TableField("taonumber")
    private Integer taonumber;




    /**
     * 印刷方式
     */
    @TableField("printtype")
    private String printtype;


    /**
     * 版数
     */
    @TableField("bannumber")
    private Integer bannumber;


    /**
     * 小张数
     */
    @TableField("zhangnumber")
    private Integer zhangnumber;


    /**
     * 印刷加放
     */
    @TableField("printjf")
    private Integer printjf;



    /**
     * 装订加放
     */
    @TableField("bindingjf")
    private Integer bindingjf;




    /**
     * 合计小张
     */
    @TableField("totalxz")
    private Integer totalxz;


    /**
     * 大张数
     */
    @TableField("dznumber")
    private Integer dznumber;

    /**
     * 印刷机台
     */
    @TableField("machine")
    private String machine;



    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getoNumber() {
        return oNumber;
    }

    public void setoNumber(String oNumber) {
        this.oNumber = oNumber;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Integer getpNumber() {
        return pNumber;
    }

    public void setpNumber(Integer pNumber) {
        this.pNumber = pNumber;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getmBrand() {
        return mBrand;
    }

    public void setmBrand(String mBrand) {
        this.mBrand = mBrand;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getPinnumber() {
        return pinnumber;
    }

    public void setPinnumber(Integer pinnumber) {
        this.pinnumber = pinnumber;
    }

    public String getTailorknumber() {
        return tailorknumber;
    }

    public void setTailorknumber(String tailorknumber) {
        this.tailorknumber = tailorknumber;
    }

    public String getTailorszie() {
        return tailorszie;
    }

    public void setTailorszie(String tailorszie) {
        this.tailorszie = tailorszie;
    }

    public String getZcolour() {
        return zcolour;
    }

    public void setZcolour(String zcolour) {
        this.zcolour = zcolour;
    }

    public String getFcolour() {
        return fcolour;
    }

    public void setFcolour(String fcolour) {
        this.fcolour = fcolour;
    }

    public Integer getTaonumber() {
        return taonumber;
    }

    public void setTaonumber(Integer taonumber) {
        this.taonumber = taonumber;
    }

    public String getPrinttype() {
        return printtype;
    }

    public void setPrinttype(String printtype) {
        this.printtype = printtype;
    }

    public Integer getBannumber() {
        return bannumber;
    }

    public void setBannumber(Integer bannumber) {
        this.bannumber = bannumber;
    }

    public Integer getZhangnumber() {
        return zhangnumber;
    }

    public void setZhangnumber(Integer zhangnumber) {
        this.zhangnumber = zhangnumber;
    }

    public Integer getPrintjf() {
        return printjf;
    }

    public void setPrintjf(Integer printjf) {
        this.printjf = printjf;
    }

    public Integer getBindingjf() {
        return bindingjf;
    }

    public void setBindingjf(Integer bindingjf) {
        this.bindingjf = bindingjf;
    }

    public Integer getTotalxz() {
        return totalxz;
    }

    public void setTotalxz(Integer totalxz) {
        this.totalxz = totalxz;
    }

    public Integer getDznumber() {
        return dznumber;
    }

    public void setDznumber(Integer dznumber) {
        this.dznumber = dznumber;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", oNumber='" + oNumber + '\'' +
                ", project='" + project + '\'' +
                ", pNumber=" + pNumber +
                ", room='" + room + '\'' +
                ", mName='" + mName + '\'' +
                ", specifications='" + specifications + '\'' +
                ", mBrand='" + mBrand + '\'' +
                ", unit='" + unit + '\'' +
                ", pinnumber=" + pinnumber +
                ", tailorknumber='" + tailorknumber + '\'' +
                ", tailorszie='" + tailorszie + '\'' +
                ", zcolour='" + zcolour + '\'' +
                ", fcolour='" + fcolour + '\'' +
                ", taonumber=" + taonumber +
                ", printtype='" + printtype + '\'' +
                ", bannumber=" + bannumber +
                ", zhangnumber=" + zhangnumber +
                ", printjf=" + printjf +
                ", bindingjf=" + bindingjf +
                ", totalxz=" + totalxz +
                ", dznumber=" + dznumber +
                ", machine='" + machine + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
