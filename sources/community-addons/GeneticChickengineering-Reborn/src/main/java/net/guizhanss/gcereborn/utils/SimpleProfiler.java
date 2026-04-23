package net.guizhanss.gcereborn.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Small optional profiler for timing hot methods during runtime investigations.
 */
public final class SimpleProfiler {

    private static final ConcurrentHashMap<String, AtomicLong> totals = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, AtomicLong> counts = new ConcurrentHashMap<>();

    private SimpleProfiler() {}

    public static void record(String key, long nanos) {
        totals.computeIfAbsent(key, ignored -> new AtomicLong()).addAndGet(nanos);
        counts.computeIfAbsent(key, ignored -> new AtomicLong()).incrementAndGet();
    }

    public static void startReporter(Plugin plugin) {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    reportAndReset(plugin);
                } catch (Throwable t) {
                    plugin.getLogger().severe("Profiler reporter failed: " + t.getMessage());
                }
            }
        }.runTaskTimerAsynchronously(plugin, 20L * 60L, 20L * 60L);
    }

    private static void reportAndReset(Plugin plugin) {
        if (totals.isEmpty()) {
            return;
        }

        List<Map.Entry<String, AtomicLong>> entries = new ArrayList<>(totals.entrySet());
        entries.sort(Comparator.comparingLong(entry -> -entry.getValue().get()));

        StringBuilder report = new StringBuilder("[SimpleProfiler] Report:\n");
        for (Map.Entry<String, AtomicLong> entry : entries) {
            String key = entry.getKey();
            long total = entry.getValue().getAndSet(0L);
            AtomicLong count = counts.get(key);
            long invocations = count == null ? 0L : count.getAndSet(0L);
            if (invocations == 0L) {
                continue;
            }

            double avgMicros = (total / (double) invocations) / 1000.0D;
            report.append(String.format(" - %s: count=%d avg=%.3fµs total=%,dns%n", key, invocations, avgMicros, total));
        }

        plugin.getLogger().info(report.toString());
    }
}
