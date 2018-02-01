package cn.lu.mybatis.web;

import cn.lu.mybatis.dto.CreateUserBatchDTO;
import cn.lu.mybatis.dto.CreateUserDTO;
import cn.lu.mybatis.dto.UpdateUserDTO;
import cn.lu.mybatis.entity.User;
import cn.lu.mybatis.exception.SQLException;
import cn.lu.mybatis.mapper.UserMapper;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 更新
     *
     * @param userId
     * @param userDTO
     * @return
     * @throws Exception
     */
    @PutMapping("/{userId}")
    public User update(@PathVariable Long userId, @RequestBody UpdateUserDTO userDTO) throws Exception {
        User user = new User();
        user.setUserId(userId);
        // 值不为空的字段将被更新
        if (!Strings.isNullOrEmpty(userDTO.getUserName())) {
            user.setUserName(userDTO.getUserName());
        }
        if (!Strings.isNullOrEmpty(userDTO.getUserMobile())) {
            user.setUserMobile(userDTO.getUserMobile());
        }
        int row = userMapper.updateByPrimaryKeySelective(user);
        if (row > 0) {
            return user;
        } else {
            throw new SQLException();
        }
    }

    @DeleteMapping("/{userId}")
    public int delete(@PathVariable Long userId) throws Exception {
        User user = new User();
        user.setUserId(userId);
        user.setDeleteFlag(1);
        return userMapper.updateByPrimaryKeySelective(user);
        //return userMapper.deleteByPrimaryKey(userId);
    }
}