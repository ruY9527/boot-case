package com.iyang.bootbasicio.pojo;

/***********************************************************************
 *<PRE>
 *
 *  File Name       : 
 *
 *  Creation Date   : 20-6-28
 *
 *  Author          : Gavin
 *
 *  Purpose         : 
 *
 *  History         : 
 *
 *</PRE>
 ***************************************************************************/

@GavinYang(lwf = "baoyang")
@PeterWong(name = "gavinyang")
public class User {

    private Integer id;
    @GavinYangFiledAnno(desc = "秒啊")
    private String name;

    public String age;
    public User(){

    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void say(){
        System.out.println("User说");
    }
}
