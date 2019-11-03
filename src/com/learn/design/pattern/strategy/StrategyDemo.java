package com.learn.design.pattern.strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        Duck duck = new MardyDuck();
        duck.setFlyBehavior(new FlyWithWings());
        duck.display();
        duck.performFly();
    }
}
