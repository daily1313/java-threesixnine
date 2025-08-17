package model;

import com.example.model.vo.Name;
import com.example.model.Player;
import fixture.NameFixture;
import fixture.PlayerFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
public class CountTest {

    private Name name;
    private Player player;

    @BeforeEach
    void setUp() {
        name = NameFixture.from("Jay");
        player = PlayerFixture.from(name);
    }

    @Test
    void 플레이어는_실행_횟수_0을_할당받는다() {
        // when & then
        assertThat(player.getCount()).isEqualTo(0);
    }

    @Test
    void 카운트를_1_증가_한다() {
        // when
        player.incrementPlayCount();

        // then
        assertThat(player.getCount()).isEqualTo(1);
    }
}
