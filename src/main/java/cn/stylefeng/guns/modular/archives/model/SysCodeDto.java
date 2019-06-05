package cn.stylefeng.guns.modular.archives.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 字典信息
 *
 * @author fengshuonan
 * @Date 2018/12/8 18:16
 */
@Data
public class SysCodeDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long codeId;
    /**
     * 父部门id
     */
    private Long pid;
    /**
     * 父部门名称
     */
    private String pName;
    /**
     * 名称
     */
    private String simpleName;

}
