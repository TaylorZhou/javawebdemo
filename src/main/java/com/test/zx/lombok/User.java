package com.test.zx.test;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
@ToString
public class User {
    private String userId;
    private List<String> groups = new ArrayList<String>();


}



