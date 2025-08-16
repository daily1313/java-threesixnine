package fixture;

import com.example.strategy.GameStrategy;
import com.example.strategy.MultipleClapStrategy;
import com.example.strategy.SingleClapStrategy;

public class StrategyFixture {

    public static GameStrategy from(int option) {
        if (option == 1) {
            return new SingleClapStrategy();
        }

        return new MultipleClapStrategy();
    }
}
