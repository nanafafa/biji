package com.riji.Asyc;

/**
 * @author 杨鹏发
 * @date 2020/5/8 0008
 */
public class EmailRunnable implements Runnable {
    private String name;
    public EmailRunnable(String name) {

        this.name=name;
    }

    @Override
    public void run() {
        System.out.println("正在给"+name+"发送邮件");
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("邮件发送完毕");
    }


}
