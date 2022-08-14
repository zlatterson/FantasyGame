package nonplayercharacters;

import playercharacters.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Boss extends Monster{
    public Boss(String name, int money, int health, int power) {
        super(name, money, health, power);
    }
    public void useAoeAttack(ArrayList<Player> players){
        for(Player player : players){
            player.takeDamage(player.getMaxHealth() / 3);
        }
    }
    public Player getStrongestPlayer(ArrayList<Player> players){
        return players.stream().max(Comparator.comparing(Player::getHealth)).get();
    }
    public void useSmash(ArrayList<Player> players){
        Player strongestPlayer = getStrongestPlayer(players);
        strongestPlayer.takeDamage(strongestPlayer.getMaxHealth() / 2);
    }

}
