package site.sunlong.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Sunlong
 * @date: 2022/1/20 17:06
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 3706543196297926824L;

    private Long id;

    private String username;

}
