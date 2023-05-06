package com.my.shardingdemo.pojo;

    import java.time.LocalDateTime;
    import java.io.Serializable;
    import lombok.Data;
    import lombok.EqualsAndHashCode;
    import lombok.experimental.Accessors;

/**
* <p>
    * 
    * </p>
*
* @author qyz
* @since 2023-05-05
*/
    @Data
        @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;

            /**
            * ??
            */
    private String name;

            /**
            * ??
            */
    private Integer age;

            /**
            * ??
            */
    private String position;

    private LocalDateTime hiteTime;

    private LocalDateTime hireTime;


}
