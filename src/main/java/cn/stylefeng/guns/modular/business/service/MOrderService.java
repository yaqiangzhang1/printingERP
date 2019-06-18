package cn.stylefeng.guns.modular.business.service;


import cn.stylefeng.guns.core.common.page.LayuiPageFactory;
import cn.stylefeng.guns.modular.business.entity.MOrder;
import cn.stylefeng.guns.modular.business.mapper.MOrderMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Service
public class MOrderService extends ServiceImpl<MOrderMapper, MOrder> {

//    /**
//     * 添加客户档案
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:51
//     */
//    public void addCustomer(Customer customer) {
//        // 判断客户名称是否存在
//        Customer theCustomer = this.getBycName(customer.getcName());
//        if (theCustomer != null) {
//            throw new ServiceException(BizExceptionEnum.Customer_ALREADY_REG);
//        }
//        this.save(customer);
//    }
    /**
     * 根据条件查询订单信息列表
     *
     * @author fengshuonan
     * @Date 2018/12/24 22:45
     */
    public Page<Map<String, Object>> selectMOrder(String searchType, String search) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.selectMOrder(page,searchType,search);
    }

//    /**
//     * 通过客户名称获取客户
//     *
//     * @author fengshuonan
//     * @Date 2018/12/24 22:46
//     */
//    public Customer getBycName(String cName) {
//        return this.baseMapper.getBycName(cName);
//    }

}
