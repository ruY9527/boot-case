package iyang.mybatis.users.service.impl;

import iyang.mybatis.users.entity.Users;
import iyang.mybatis.users.mapper.UsersMapper;
import iyang.mybatis.users.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luohong
 * @since 2021-05-05
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
