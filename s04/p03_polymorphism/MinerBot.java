package p03_polymorphism;

public class MinerBot extends Bot implements RescuerBot {

    public MinerBot(String code) {
        super(code);
    }

    @Override
    public boolean saveHuman() {
        return false;
    }

    @Override
    public DangerType notifyDanger() {
        return null;
    }

    @Override
    public void siren() {

    }
}
