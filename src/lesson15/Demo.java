package lesson15;

public class Demo {

    public static void main(String[] args) {
        MadScientist madScientistOne = new MadScientist();
        MadScientist.Minion minionOne = new MadScientist.Minion();
        MadScientist madScientistTwo = new MadScientist();
        MadScientist.Minion minionTwo = new MadScientist.Minion();
        int days = 100;
        Thread threadScienistOne = new Thread(() -> {
            for (int i = 0; i < days; i++) {
                synchronized (Dump.dump) {
                    System.out.println("Прислужник #1 взял несколько деталей");
                    minionOne.takeFromDump(Dump.dump, madScientistOne.warehouse);
                    try {
                        if (i != days - 1) {
                            Dump.dump.notify();
                            Dump.dump.wait();
                        } else {
                            Dump.dump.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadScienistTwo = new Thread(() -> {
            for (int i = 0; i < days; i++) {
                synchronized (Dump.dump) {
                    System.out.println("прислужник №2 взял несколько деталей");
                    minionTwo.takeFromDump(Dump.dump, madScientistTwo.warehouse);
                    try {
                        if (i != days - 1) {
                            Dump.dump.wait();
                        } else {
                            Dump.dump.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread threadFactory = new Thread(() -> {
            for (int i = 0; i < days; i++) {
                synchronized (Dump.dump) {
                    System.out.println("фабрика произвела несколько деталей");
                    Factory.getRandomfactoryDetail();
                    try {
                        if (i != days - 1) {
                            Dump.dump.notifyAll();
                            Dump.dump.wait();
                            Thread.sleep(100);
                        } else {
                            Dump.dump.notifyAll();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        threadFactory.start();
        threadScienistOne.start();
        threadScienistTwo.start();
        try {
            threadFactory.join();
            threadScienistOne.join();
            threadScienistTwo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int robotsScietistOne = madScientistOne.getRobots(madScientistOne.warehouse);
        int robotsScietistTwo = madScientistOne.getRobots(madScientistTwo.warehouse);
        if (robotsScietistOne == robotsScietistTwo) {
            System.out.println("Ничья!");
        } else if (robotsScietistOne > robotsScietistTwo) {
            System.out.println("Победил ученый №1");
        } else {
            System.out.println("Победил ученый №2");
        }
    }
}