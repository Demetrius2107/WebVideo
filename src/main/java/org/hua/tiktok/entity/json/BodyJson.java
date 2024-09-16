package org.hua.tiktok.entity.json;

import lombok.Data;

import java.io.Serializable;

@Data
public class BodyJson implements Serializable {

    String id;
    String status;
    ResultJson result;

}
