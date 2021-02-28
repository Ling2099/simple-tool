package com.huoguo.simpletool.demo;

import com.huoguo.simpletool.pool.ThreadPools;

/**
 * @ClassName: Test
 * @Description: TODO
 * @Author: LZH
 * @Date: 2021/2/26 15:20
 * @Version: 1.0
 */
public class Test implements Runnable{



    public static void main(String[] args) {
        Test test = new Test();
        ThreadPools.execute(test, 1, 1, 5000);
        ThreadPools.cancel(test);
    }

    @Override
    public void run() {
        System.out.println(111111);
    }
}
