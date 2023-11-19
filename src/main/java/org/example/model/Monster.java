package org.example.model;

import java.util.Random;

public class Monster {
    private String name;
    private int health;
    private long attackSpeed; // in milliseconds
    private int damage;
    private double criticalDamageRatio; //1.1 and more
    private double criticalDamageChance; //0-100

    public Monster(String name, int health, long attackSpeed, int damage, double criticalDamageRatio, double criticalDamageChance) {
        this.name = name;
        this.health = health;
        this.attackSpeed = attackSpeed;
        this.damage = damage;
        this.criticalDamageRatio = criticalDamageRatio;
        this.criticalDamageChance = criticalDamageChance;
    }

    public void attack(Monster target, int damage) {
        target.getDamage(damage);
    }

    public int dealDamage(){
        if (isCriticalDamage()) return (int) (damage * criticalDamageRatio);
        else return damage;
    }

    public void getDamage(int damage) {
        this.health -= damage;
    }

    public boolean isCriticalDamage() {
        Random random = new Random();
        int rn = random.nextInt(1, 101);
        return this.criticalDamageChance >= rn;
    }

    public long getAttackSpeed() {
        return attackSpeed;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        Monster monster = (Monster) obj;
        return this.name.equals(monster.name);
    }
}
