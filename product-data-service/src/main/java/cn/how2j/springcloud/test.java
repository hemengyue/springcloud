package cn.how2j.springcloud;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NumberUtil;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 功能说明
 *
 * @author heyueyue
 * @date 2019-11-08 16:43:19
 */
public class test {
    public static void main(String[] args) {
        int num=0;
        int defaultnum=80000;
        Future<Integer> future = ThreadUtil.execAsync(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int p = 0;
                System.out.println("请于5秒钟内输入,否则将会默认赋值为  " + defaultnum);
                Scanner scanner = new Scanner(System.in);
                while(true) {
                    String strPort = scanner.nextLine();
                    if(!NumberUtil.isInteger(strPort)) {
                        System.err.println("只能是数字");
                        continue;
                    }
                    else {
                        p = Convert.toInt(strPort);
                        scanner.close();
                        break;
                    }
                }
                return p;
            }

        });//执行异步方法,excAsync(Runnable runnable, boolean isDaemon)
        try{
            num = future.get(5, TimeUnit.SECONDS);
        }catch (Exception e){
            num=defaultnum;
        }

        System.out.println(num);
    }
}
