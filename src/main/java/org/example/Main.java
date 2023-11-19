package org.example;

import org.example.factory.MonsterFactory;
import org.example.model.FightClub;
import org.example.model.Monster;

public class Main {
    public static void main(String[] args) {
        MonsterFactory monsterFactory = new MonsterFactory();
        Monster monster1 = monsterFactory.getMonsterFighter();
        Monster monster2 = monsterFactory.getMonsterFighter();
        while (monster1.equals(monster2)){ //чтобы не было одинаковых бойцов
            monster2 = monsterFactory.getMonsterFighter();
        }
        FightClub fightClub = new FightClub(monster1, monster2);
        fightClub.fight();
    }
}