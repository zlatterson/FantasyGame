import nonplayercharacters.Monster;
import org.junit.Before;
import org.junit.Test;
import playercharacters.Knight;
import playercharacters.PetType;
import playercharacters.WeaponType;
import playercharacters.Wizard;

import static org.junit.Assert.assertEquals;

public class WizardTest {
    Wizard wizard;
    Knight knight;
    @Before
    public void before(){
        wizard = new Wizard("Merlin",3000,200,150,10,20,0, WeaponType.WAND);
        knight = new Knight("Aragorn",120,100,100,10,0,0, WeaponType.SWORD);

    }
    @Test
    public void canUseFireball(){
        wizard.useFireball(knight);
        assertEquals(50,knight.getHealth());
    }
    @Test
    public void canUsePetAttack(){
        wizard.setCurrentPet(PetType.DRAGON);
        wizard.usePetAttack(knight);
        assertEquals(0,knight.getHealth());
    }
    @Test
    public void petAttackWithoutPetDoesNoDamage(){
        wizard.usePetAttack(knight);
        assertEquals(100, knight.getHealth());
    }
    @Test
    public void otherPetsWork(){
        wizard.setCurrentPet(PetType.LIZARD);
        wizard.usePetAttack(knight);
        wizard.setCurrentPet(PetType.FOX);
        wizard.usePetAttack(knight);
        assertEquals(85,knight.getHealth());
    }
}
