package cn.stylefeng.guns.modular.archives.service;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.core.common.constant.Const;
import cn.stylefeng.guns.core.common.constant.state.ManagerStatus;
import cn.stylefeng.guns.core.common.exception.BizExceptionEnum;
import cn.stylefeng.guns.core.common.node.MenuNode;
import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.core.shiro.ShiroKit;
import cn.stylefeng.guns.core.shiro.ShiroUser;
import cn.stylefeng.guns.core.shiro.service.UserAuthService;
import cn.stylefeng.guns.core.util.ApiMenuFilter;
import cn.stylefeng.guns.modular.archives.entity.Customer;
import cn.stylefeng.guns.modular.archives.mapper.CustomerMapper;
import cn.stylefeng.guns.modular.system.entity.User;
import cn.stylefeng.guns.modular.system.factory.UserFactory;
import cn.stylefeng.guns.modular.system.mapper.UserMapper;
import cn.stylefeng.guns.modular.system.model.UserDto;
import cn.stylefeng.guns.modular.system.service.MenuService;
import cn.stylefeng.roses.core.datascope.DataScope;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 客户档案 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Service
public class CustomerService extends ServiceImpl<CustomerMapper, Customer> {

    /**
     * 添加客户档案
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:51
     */
    public void addCustomer(Customer customer) {
        // 判断客户名称是否存在
        Customer theCustomer = this.getBycName(customer.getcName());
        if (theCustomer != null) {
            throw new ServiceException(BizExceptionEnum.Customer_ALREADY_REG);
        }
        this.save(customer);
    }
    /**
     * 根据条件查询客户档案列表
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:45
     */
    public Page<Map<String, Object>> selectCustomer(String searchType, String search) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.selectCustomer(page,searchType,search);
    }

    /**
     * 通过客户名称获取客户
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:46
     */
    public Customer getBycName(String cName) {
        return this.baseMapper.getBycName(cName);
    }

}
