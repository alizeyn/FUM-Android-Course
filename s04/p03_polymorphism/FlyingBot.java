package p03_polymorphism;

public class FlyingBot extends Bot implements WatcherBot {

    public FlyingBot(String code) {
        super(code);
    }

    @Override
    public void notifyBotInDanger() {

    }

    @Override
    public void notifyHumanInDanger() {

    }

    @Override
    public int countHealthyBots() {
        return 0;
    }

    @Override
    public int countBrokenBots() {
        return 0;
    }
}
