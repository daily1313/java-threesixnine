package model;

import com.example.model.vo.Name;
import com.example.model.Player;
import fixture.NameFixture;
import fixture.PlayerFixture;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class PlayerTest {

    final List<Name> names = List.of(
            NameFixture.from("Jay"),
            NameFixture.from("Tong"),
            NameFixture.from("Kim"),
            NameFixture.from("Park")
    );

    @Test
    public void 플레이어를_생성한다() {
        // given
        List<Player> players = PlayerFixture.from(names);

        // when & then
        assertSoftly(softly -> {
            softly.assertThat(players.size()).isEqualTo(4);
            softly.assertThat(players.get(0).getName()).isEqualTo(names.get(0).getName());
            softly.assertThat(players.get(1).getName()).isEqualTo(names.get(1).getName());
            softly.assertThat(players.get(2).getName()).isEqualTo(names.get(2).getName());
            softly.assertThat(players.get(3).getName()).isEqualTo(names.get(3).getName());
            softly.assertThat(players.get(0).getCount()).isEqualTo(0);
        });
    }
}
