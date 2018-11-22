package cxs15.pyrmont.digestertest;

import java.io.File;
import org.apache.commons.digester.Digester;

public class Test01 {

  public static void main(String[] args) {
    String path = System.getProperty("user.dir") + File.separator  + "etc";
    File file = new File(path, "employee1.xml");
    Digester digester = new Digester();
    // add rules  attributeName这个属性 是 xml文件中 <employee 节点的 实例化对象的类的类路径属性，
    // //譬如这个 attributeName为dd,那么实例化employee节点的时候会去找首先找dd属性的值作为className
    digester.addObjectCreate("employee", "cxs15.pyrmont.digestertest.Employee","dd");
    // 设置属性
    digester.addSetProperties("employee");
    // 调用方法
    digester.addCallMethod("employee", "printName");

    try {
      Employee employee = (Employee) digester.parse(file);
      System.out.println("First name : " + employee.getFirstName());
      System.out.println("Last name : " + employee.getLastName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }  
  
}
