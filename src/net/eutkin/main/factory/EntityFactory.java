package net.eutkin.main.factory;


import net.eutkin.main.entity.AbstractDataTS;
import net.eutkin.main.entity.DataTS1;
import net.eutkin.main.entity.DataTS2;

public class EntityFactory {
    private int numTS;
    public EntityFactory(int numTS){
        this.numTS = numTS;
    }
    public AbstractDataTS getEntity(){
        switch (this.numTS){
            case 1: return new DataTS1();
            case 2: return new DataTS2();
        }
        return new DataTS1();
    }
}
