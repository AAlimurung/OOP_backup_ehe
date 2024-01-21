package PlantsPVZ;

interface SunProducer {
    int produce_sun();
}

interface PlantUpgrade {
    int concurrentSunCost();
}

interface Attacker {
    int attack(); //print attack action, return integer of dmg
    RangeType rangeType(); //return integer of range capability (SL / AOE)
}

interface InstantKiller{
    KillType killType();
}

interface Upgradable{
    PlantUpgrade upgrade();
}
// add more interfaces here

enum RangeType{
    SINGLE_LINE, AOE, LIMITED, FREE_RANGE;
}

enum KillType{
    INSTANT, CLOSE_ON;
}