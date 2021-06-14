package io.lesible.util;

import java.util.Random;
import java.util.UUID;

public class UniqueIdUtil {

    private static final Random RANDOM = new Random(System.currentTimeMillis());
    private static final long RANDOM_NUM = Math.abs(RANDOM.nextInt(32));
    private static final UniqueIdUtil ID_WORKER = new UniqueIdUtil(RANDOM_NUM, RANDOM_NUM, RANDOM_NUM);

    private final long workerId;
    private final long datacenterId;
    private final long workerIdBits = 5L;
    private final long datacenterIdBits = 5L;
    private long sequence;
    private long lastTimestamp = -1L;

    public UniqueIdUtil(long workerId, long datacenterId, long sequence) {
        // sanity check for workerId
        long maxWorkerId;
        maxWorkerId = ~(-1L << workerIdBits);
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        long maxDatacenterId = ~(-1L << datacenterIdBits);
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
        this.sequence = sequence;
    }

    public static String nextUniqueId() {
        return ID_WORKER.nextId() + UUID.randomUUID().toString().substring(0, 4);
    }

    public long getWorkerId() {
        return workerId;
    }

    public long getDatacenterId() {
        return datacenterId;
    }

    public long getTimestamp() {
        return System.currentTimeMillis();
    }

    public synchronized long nextId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            System.err.printf("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp);
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }
        long sequenceBits = 12L;
        if (lastTimestamp == timestamp) {
            long sequenceMask = ~(-1L << sequenceBits);
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = timestamp;
        long datacenterIdShift = sequenceBits + workerIdBits;
        long tmp = 1288834974657L;
        long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
        return ((timestamp - tmp) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << sequenceBits) |
                sequence;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

}