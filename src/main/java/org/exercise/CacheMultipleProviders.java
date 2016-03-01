package org.exercise;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by manuel.cordoba on 2/29/16.
 */
public class CacheMultipleProviders {


    private final Set<CacheProvider> providers = new HashSet<>();

    private final ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<String, Lock> locks = new ConcurrentHashMap<>();


    public void addProvider(CacheProvider provider) {
        providers.add(provider);
    }

    public String get(String key) {
        String cachedValue = cache.get(key);
        if (cachedValue == null) {

            Lock current = getLock(key);

            Iterator<CacheProvider> providerIterator = providers.iterator();
            try {
                current.lock();
                // if locked thread we need to test the cache before getting in
                cachedValue = cache.get(key);
                while (cachedValue == null && providerIterator.hasNext()) {
                    CacheProvider provider = providerIterator.next();
                    cachedValue = provider.get(key);
                    if (cachedValue != null) {
                        cache.put(key, cachedValue);
                    }
                }
            } finally {
                current.unlock();
            }

        }

        return cachedValue;
    }

    private Lock getLock(String key) {
        Lock newLock = new ReentrantLock();
        return (locks.putIfAbsent(key, newLock) == null) ? newLock : locks.get(key);
    }

}
