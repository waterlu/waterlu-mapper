package cn.lu.mybatis.web;

import cn.lu.mybatis.dto.CreateUserBatchDTO;
import cn.lu.mybatis.dto.CreateUserDTO;
import cn.lu.mybatis.entity.User;
import cn.lu.mybatis.exception.SQLException;
import cn.lu.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lutiehua
 * @date 2018/1/31
 */
@RestController
@RequestMapping("mapper/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    /**
     * 写入（返回自增ID）
     *
     * @return
     */
    @PostMapping("")
    public User create(@RequestBody CreateUserDTO userDTO) throws Exception {
        User user = new User();
        user.setUserMobile(userDTO.getUserMobile());
        user.setUserName(userDTO.getUserName());
        // 自动user.setUserId() 实体类 @GeneratedValue(generator = "JDBC")
        int row = userMapper.insertSelective(user);
        if (row == 1) {
            return user;
        } else {
            throw new SQLException();
        }
    }

    /**
     * 批量写入
     *
     * @return
     * @throws Exception
     */
    @PostMapping("/batch")
    public List<User> createBatch(@RequestBody CreateUserBatchDTO userBatchDTO) throws Exception {
        List<User> userList = new ArrayList<>();
        for (int i=0; i<userBatchDTO.getCount().intValue(); i++) {
            User user = new User();
            long mobile = userBatchDTO.getUserMobile().longValue() + i;
            String userMobile = Long.toString(mobile);
            user.setUserMobile(userMobile);
            user.setUserName(userMobile.substring(userMobile.length() - 4));
            userList.add(user);
        }

        int row = userMapper.insertList(userList);
        if (row > 0) {
            return userList;
        } else {
            throw new SQLException();
        }
    }
}
