package p03_polymorphism;

public interface WatcherBot {
    void notifyBotInDanger();
    void notifyHumanInDanger();
    int countHealthyBots();
    int countBrokenBots();
}
