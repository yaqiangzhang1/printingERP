package cn.stylefeng.guns.modular.business.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 费用信息
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-01
 */
@TableName("cost")
public class Cost implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id")
    private Long id;

    /**
     * 订单编号
     */
    @TableField("o_number")
    private String o_number;

    /**
     * 费用编号
     */
    @TableField("costnumber")
    private Long costnumber;

    /**
     * 费用
     */
    @TableField("cost")
    private Double cost;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getO_number() {
        return o_number;
    }

    public void setO_number(String o_number) {
        this.o_number = o_number;
    }

    public Long getCostnumber() {
        return costnumber;
    }

    public void setCostnumber(Long costnumber) {
        this.costnumber = costnumber;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "id=" + id +
                ", o_number='" + o_number + '\'' +
                ", costnumber=" + costnumber +
                ", cost=" + cost +
                '}';
    }
}
