package net.eutkin.main.factory;


import net.eutkin.main.entity.*;

public class EntityFactory {
    private int numTS;
    public EntityFactory(int numTS){
        this.numTS = numTS;
    }
    public AbstractDataTS getEntity(){
        switch (this.numTS){
            case 1: return new DataTS1();
            case 2: return new DataTS2();
            case 3: return new DataTS3();
            case 4: return new DataTS4();
            case 5: return new DataTS5();
            case 6: return new DataTS6();
        }
        return new DataTS1();
    }
}
