package cn.stylefeng.guns.modular.archives.service;

import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.modular.archives.entity.Machine;
import cn.stylefeng.guns.modular.archives.entity.Materiel;
import cn.stylefeng.guns.modular.archives.mapper.MachineMapper;
import cn.stylefeng.guns.modular.archives.mapper.MaterielMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 设备档案 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Service
public class MachineService extends ServiceImpl<MachineMapper, Machine> {



    /**
     * 添加设备
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:51
     */
    public void addCustomer(Machine machine) {
        this.save(machine);
    }
//
//    /**
//     * 修改用户
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:53
//     */
//    public void editUser(UserDto user) {
//        User oldUser = this.getById(user.getUserId());
//
//        if (ShiroKit.hasRole(Const.ADMIN_NAME)) {
//            this.updateById(UserFactory.editUser(user, oldUser));
//        } else {
//            this.assertAuth(user.getUserId());
//            ShiroUser shiroUser = ShiroKit.getUserNotNull();
//            if (shiroUser.getId().equals(user.getUserId())) {
//                this.updateById(UserFactory.editUser(user, oldUser));
//            } else {
//                throw new ServiceException(BizExceptionEnum.NO_PERMITION);
//            }
//        }
//    }
//
//    /**
//     * 删除用户
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:54
//     */
//    public void deleteUser(Long userId) {
//
//        //不能删除超级管理员
//        if (userId.equals(Const.ADMIN_ID)) {
//            throw new ServiceException(BizExceptionEnum.CANT_DELETE_ADMIN);
//        }
//        this.assertAuth(userId);
//        this.setStatus(userId, ManagerStatus.DELETED.getCode());
//    }
//
    /**
     * 根据条件查询设备档案列表
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:45
     */
    public Page<Map<String, Object>> selectMachine(String searchType, String search) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.selectMachine(page,searchType,search);
    }


    /**
     * 根据物料编码获取物料
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:45
     */
    public Machine getBymcNumber(String mcNumber){
        return this.baseMapper.getBymcNumber(mcNumber);
    }

}
