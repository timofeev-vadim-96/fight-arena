package org.example.factory;

import org.example.model.Monster;

import java.util.Random;

public class MonsterFactory {
    /**
     * @return одного из 4х видов монстров, выбранного рандомно
     */
    public Monster getMonsterFighter(){
        Random random = new Random();
        int numb = random.nextInt(1,5); //1-4
        switch (numb){
            case 1:
                return new Monster
                        ("Dragon", 1000, 3000, 250, 3.0, 30);
            case 2:
                return new Monster
                        ("Hydra", 550, 1500, 150, 2.0, 20);
            case 3:
                return new Monster
                        ("Gryphon", 300, 1000, 100, 3.5, 40);
            default:
                return new Monster
                        ("Demon", 850, 2000, 250, 3.0, 15);
        }
    }
}
