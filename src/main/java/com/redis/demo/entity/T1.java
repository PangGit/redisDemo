package com.redis.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * TODO
 *
 * @author Pangdb
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@TableName(value = "t1")
public class T1 {

    @TableId(value = "id", type = IdType.AUTO)
    Long id;

    String name;

    Byte s1;
    Byte s2;
    Byte s3;
    Byte s4;
}
