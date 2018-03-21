package com.test.zx.transent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Taylor
 * @version 1.0
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserInfo implements Serializable{

    private String name;
    private transient String psw;

}
