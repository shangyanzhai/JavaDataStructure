package test.SecretCode;

import com.sun.jmx.snmp.SnmpUnknownModelException;

import java.util.Objects;
import java.util.Scanner;

/**
 * 编写代码模拟三次密码输入的场景。最多能输入三次密码，密码正确，提示“登录成功”,密码错误，可以重新输入，最多输入三次。三次均错，则提示退出程序
 */
public class SecretCode {
    public static void main(String[] args) {
        //编写代码模拟三次密码输入的场景。最多能输入三次密码，密码正确，提示“登录成功”,密码错误，可以重新输入，最多输入三次。三次均错，则提示退出程序
        String sercetcode = "123456";//sercetcode为设定的密码
        int num = 0;//用来计数，当num == 3的时候结束程序
        System.out.println("请输入密码");
        Scanner scanner = new Scanner(System.in);
        String scanf = scanner.nextLine();//scanf为输入
        num++;
        while(!Objects.equals(scanf, sercetcode)){//scanf != sercetcode是错误的
            System.out.println("密码错误");
            num++;
            scanf = scanner.nextLine();
            if(num == 3){
                if(!Objects.equals(scanf, sercetcode)){
                    System.out.println("登陆失败，程序退出");
                    num++;
                }
                break;
            }
        }
        if(num <= 3){
            System.out.println("登录成功");
        }
    }
}
