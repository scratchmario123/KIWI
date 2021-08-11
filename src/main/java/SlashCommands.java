import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.Button;
import net.dv8tion.jda.api.interactions.components.Component;
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction;
import okhttp3.OkHttpClient;

public class SlashCommands extends ListenerAdapter {

    @Override
    public void onSlashCommand(SlashCommandEvent event) {
        if (event.getName().equals("ping")) {
            long time = System.currentTimeMillis();
            event.reply("Pong!").setEphemeral(false)
                    .flatMap(v -> event.getHook().editOriginal(new PingPong().getPing(time))
                    ).queue();
        } else if (event.getName().equals("8ball")) {

        }
    }
}
