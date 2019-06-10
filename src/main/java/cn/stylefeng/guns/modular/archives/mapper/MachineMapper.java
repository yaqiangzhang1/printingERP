package cn.stylefeng.guns.modular.archives.mapper;

import cn.stylefeng.guns.modular.archives.entity.Machine;
import cn.stylefeng.guns.modular.archives.entity.Materiel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 设备档案表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
public interface MachineMapper extends BaseMapper<Machine> {

//    /**
//     * 修改用户状态
//     */
//    int setStatus(@Param("userId") Long userId, @Param("status") String status);
//
//    /**
//     * 修改密码
//     */
//    int changePwd(@Param("userId") Long userId, @Param("pwd") String pwd);
//
    /**
     * 根据条件查询物料档案列表
     */
    Page<Map<String, Object>> selectMachine(@Param("page") Page page, @Param("searchType") String searchType, @Param("search") String search);

//    /**
//     * 设置用户的角色
//     */
//    int setRoles(@Param("userId") Long userId, @Param("roleIds") String roleIds);
//
    /**
     * 通过设备编码获取设备
     */
    Machine getBymcNumber(@Param("mcNumber") String mcNumber);

}
