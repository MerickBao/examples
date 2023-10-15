package com.example.designpattern.m1;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/10/14 20:55
 */

public class Hello extends AbstractQueuedSynchronizer {


    protected Hello() {
        super();
    }

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }

    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
