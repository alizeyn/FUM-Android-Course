package p03_polymorphism;

import java.util.ArrayList;
import java.util.List;

public class BotManager {
    private List<Bot> bots;

    public BotManager() {
        bots = new ArrayList<>();
    }

    public FirefighterBot getFirefighterBot() {
        FirefighterBot bot = new FirefighterBot("ladflkj8r4");
        bots.add(bot);
        return bot;
    }

    public void destroyAllBots() {
        for (int i = 0; i < bots.size(); i++) {
            bots.get(i).selfDestruction();
            bots.remove(i);
        }
    }

    public String identifyBot(Bot bot) {
        String code = bot.getCode();
        return "bot code is : " + code;
    }
}
