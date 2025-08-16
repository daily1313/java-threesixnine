package fixture;

import com.example.model.Name;
import com.example.model.Player;

import java.util.List;

public class PlayerFixture {

    public static Player from(Name name) {
        return Player.from(name);
    }

    public static List<Player> from(List<Name> names) {
        return names.stream()
                .map(Player::from)
                .toList();
    }
}
