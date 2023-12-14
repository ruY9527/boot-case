package com.iyang.bootbasicio.lists;

import lombok.*;

/****
 * boot-case / com.iyang.bootbasicio.lists
 * @author: Yang_Bao
 * @time: 2023/10/12 / 10:49
 * @desc:
 **/

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DictInfo {

    /**
     * 主键 Key
     */
    private String key;

    /**
     * key -> value
     */
    private Integer value;

}
