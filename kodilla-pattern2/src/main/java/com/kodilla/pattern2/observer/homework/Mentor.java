package com.kodilla.pattern2.observer.homework;

public class Mentor implements Observer {
    private final String userName;
    private int updateCount;

    public Mentor(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(TaskQueue taskQueue) {
        System.out.println(userName + ": New task in " + taskQueue.getName() + "\n (total: " + taskQueue.getTasks().size() + " tasks)");
        updateCount++;
    }

    public String getUserName() {
        return userName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
