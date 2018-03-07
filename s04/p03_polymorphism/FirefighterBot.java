package p03_polymorphism;

public class FirefighterBot extends Bot implements RescuerBot {

    public FirefighterBot(String code) {
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
