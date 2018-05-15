package com.test.zx.lombok;

import com.test.zx.util.JsonUtil;
import com.test.zx.util.ServiceException;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
/*@ToString
@Data*/
public class User {
    private String userId;
    private List<String> groups;

/*    public User(String userId){
        this.userId = userId;
    }*/

    public static void main(String[] args) throws ServiceException {
        User user = new User();
        user.setUserId("111");
/*        user.getGroups().add("111");
        user.getGroups().add("222");*/
        System.out.println(JsonUtil.objectToJson(user));

    }


}



