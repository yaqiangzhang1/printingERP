package cn.stylefeng.guns.modular.archives.service;

import cn.stylefeng.guns.core.common.exception.BizExceptionEnum;
import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.shiro.service.UserAuthService;
import cn.stylefeng.guns.modular.archives.entity.Customer;
import cn.stylefeng.guns.modular.archives.entity.Materiel;
import cn.stylefeng.guns.modular.archives.mapper.CustomerMapper;
import cn.stylefeng.guns.modular.archives.mapper.MaterielMapper;
import cn.stylefeng.guns.modular.system.service.MenuService;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 物料档案 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Service
public class MaterielService extends ServiceImpl<MaterielMapper, Materiel> {



    /**
     * 添加物料档案
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:51
     */
    public void addCustomer(Materiel materiel) {
        this.save(materiel);
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
     * 根据条件查询物料档案列表
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:45
     */
    public Page<Map<String, Object>> selectMateriel(String searchType, String search) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.selectMateriel(page,searchType,search);
    }


    /**
     * 根据物料编码获取物料
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:45
     */
    public Materiel getByNumber(String mNumber){
        System.out.println(this.baseMapper.getBymNumber(mNumber));
        return this.baseMapper.getBymNumber(mNumber);
    }

}
