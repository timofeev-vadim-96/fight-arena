package org.example.model;

public class FightClub {
    private final Monster monster1;
    private final Monster monster2;

    public FightClub(Monster monster1, Monster monster2) {
        this.monster1 = monster1;
        this.monster2 = monster2;
    }

    /**
     * Старт сражения
     */
    public void fight() {
        Thread th1 = new Thread(new Runnable() {
            public void run() {
                toAttackMonster1();
            }
        });

        Thread th2 = new Thread(new Runnable() {
            public void run() {
                toAttackMonster2();
            }
        });

        greeting();

        th1.start();
        th2.start();
    }

    /**
     * Первый монстр атакует второго до тех пор, пока не убьет или пока не умрет сам
     */
    private void toAttackMonster1() {
        while (this.monster1.getHealth() > 0) {
            int dealDamage = monster1.dealDamage();
            this.monster1.attack(this.monster2, dealDamage);
            System.out.printf("%s deals %d damage %s\n", monster1.getName(), dealDamage, monster2.getName());
            if (this.monster2.getHealth() <= 0) {
                System.out.printf(
                        "%s is dead, %s won!\n", this.monster2.getName(), this.monster1.getName());
                break;
            }
            try {
                Thread.sleep(this.monster1.getAttackSpeed());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Второй монстр атакует первого до тех по, пока не убьет или пока не умрет сам
     */
    private void toAttackMonster2() {
        while (this.monster2.getHealth() > 0) {
            int dealDamage = monster2.dealDamage();
            this.monster2.attack(this.monster1, dealDamage);
            System.out.printf("%s deals %d damage %s\n", monster2.getName(), dealDamage, monster1.getName());
            if (this.monster1.getHealth() <= 0) {
                System.out.printf(
                        "%s is dead, %s won!\n", this.monster1.getName(), this.monster2.getName());
                break;
            }
            try {
                Thread.sleep(this.monster2.getAttackSpeed());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void greeting() {
        System.out.printf("Welcome to the fight club! Today they are fighting in the arena: \n" +
                        "%s (HP: %d) and %s (HP: %d)! \n" +
                "The battle will begin in 5 seconds...\n",
                monster1.getName(), monster1.getHealth(), monster2.getName(), monster2.getHealth());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
