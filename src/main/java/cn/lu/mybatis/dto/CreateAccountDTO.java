package cn.lu.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author lutiehua
 * @date 2018/1/31
 */
@Getter
@Setter
@ToString
public class CreateAccountDTO {

    /**
     * 用户UUID
     *
     */
    @NotNull
    private Long userId;
}
