package cn.stylefeng.guns.modular.archives.mapper;

import cn.stylefeng.guns.modular.archives.entity.Customer;
import cn.stylefeng.guns.modular.system.entity.User;
import cn.stylefeng.roses.core.datascope.DataScope;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 客户档案 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    /**
     * 根据条件查询客户档案列表
     */
    Page<Map<String, Object>> selectCustomer(@Param("page") Page page,  @Param("searchType") String searchType, @Param("search") String search);

    /**
     * 通过客户名称获取客户
     */
    Customer getBycName(@Param("cName") String cName);


}