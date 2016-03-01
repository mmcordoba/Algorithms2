package org.exercise;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by manuel.cordoba on 2/29/16.
 */
public class CacheProviderTest {

    @Test
    public void testMultipleAccessToAKeyOnlyCallsProviderOnce() {
        final CacheMultipleProviders cacheMultipleProviders = new CacheMultipleProviders();
        SimpleProvider provider = new SimpleProvider();
        cacheMultipleProviders.addProvider(provider);

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        int countTestTh = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(countTestTh);

        for (int i = 0; i < countTestTh; i ++)
        executorService.submit(() -> {
                cacheMultipleProviders.get("key");
                countDownLatch.countDown();
            });

        try {
            countDownLatch.await();
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(1, provider.accesses.intValue());

    }

    @Test
    public void testMultipleAccessCallsProviderAllTheTimes() {
        final CacheMultipleProviders cacheMultipleProviders = new CacheMultipleProviders();
        SimpleProvider provider = new SimpleProvider();
        cacheMultipleProviders.addProvider(provider);

        ExecutorService executorService = Executors.newFixedThreadPool(20);

        final CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i ++) {
            final Integer incrementer = i;
            executorService.submit(() -> {
                Assert.assertEquals("value", cacheMultipleProviders.get("key" + incrementer));
                countDownLatch.countDown();

            });
        }
        try {
            countDownLatch.await();
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertEquals(10, provider.accesses.intValue());

    }



    public static class SimpleProvider implements CacheProvider {

        private AtomicInteger accesses = new AtomicInteger(0);

        public String get(String key) {
            try {
                Thread.currentThread().sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            accesses.getAndIncrement();
            return "value";
        }

        public Integer getAccesses() {
            return accesses.get();
        }
    }


}
