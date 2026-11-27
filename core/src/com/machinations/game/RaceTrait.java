package com.machinations.game;

import java.util.ArrayList;

public abstract class RaceTrait {

    private ArrayList<RaceTrait> raceTraits = new ArrayList<>();

    public abstract void applyEffect(PlayerCharacter playerCharacter);

    public abstract String getDescription();


    public static boolean isHumanoidTrait(Class<? extends RaceTrait> traitClass) {
        return traitClass == Adaptable.class || traitClass == Fecund.class;
    }

    public static boolean isAmmoniaBasedTrait(Class<? extends RaceTrait> traitClass) {
        return traitClass == Gasbag.class;
    }

    public static boolean isAmoeboidTrait(Class<? extends RaceTrait> traitClass) {
        return traitClass == LimitedShapeshifting.class;
    }

    public static boolean isGiantTrait(Class<? extends RaceTrait> traitClass) {
        return traitClass == Resilient.class || traitClass == Strong.class || traitClass == Enduring.class;
    }


    public static boolean isHerbivoreTrait(Class<? extends RaceTrait> traitClass) {
        return traitClass == Fearful.class || traitClass == RapidReaction.class;
    }

    public static boolean isHighGravityTrait(Class<? extends RaceTrait> traitClass) {
        return traitClass == VeryStrong.class || traitClass == VeryTough.class || traitClass == HiGAdapted.class;
    }

    public static boolean isHunterTrait(Class<? extends RaceTrait> traitClass) {
        return traitClass == Survival.class || traitClass == Stalker.class;
    }

    public static boolean isInsectTrait(Class<? extends RaceTrait> traitClass) {
        return traitClass == Flight.class;
    }


    public static class Adaptable extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setUnspentSkillPoints(playerCharacter.getUnspentSkillPoints() + 1);
        }

        @Override
        public String getDescription() {
            return "'Specialisation is for insects' Gain +1 skill Point.";
        }
    }

    //No Vitals: Half hit-points. Take only one damage from physical attacks. Take normal damage from energy attacks

    public static class NoVitals extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.addResistance(DamageType.PHYSICAL);
            //PLACEHOLDER IMPLEMENT REDUCING PHYS DAMAGE TO 1 (Maybe when combat implemented?)
        }

        @Override
        public String getDescription() {
            return "Your heart has a negative BPM, you take one damage from physial attacks, but take normal damage from energy, and have halved HP.";
        }
    }

    public static class Ascetic extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.getSkills().setSkillValue(Skills.Skill.INVESTMENT,
                    playerCharacter.getSkills().getSkillValue(Skills.Skill.INVESTMENT) + 1);
        }

        @Override
        public String getDescription() {
            return "'Mo' Money, Mo' problems' - Hallowed Monk Nwa Big, Gain +1 to your investment skill.";
        }
    }


    public static class Swimming extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setSwimspeed(playerCharacter.getSwimspeed() * 2);
        }

        @Override
        public String getDescription() {
            return "'Sleep with the fishes' to you just means a good night's rest, your swimming speed is doubled.";
        }
    }

    public static class KeenSight extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.getSkills().setSkillValue(Skills.Skill.SEARCH,
                    playerCharacter.getSkills().getSkillValue(Skills.Skill.SEARCH) + 1);
        }

        @Override
        public String getDescription() {
            return "You've got an Eye for treasures, traps, faces in a crowd, everything really, gain +1 to your search skill.";
        }
    }

    public static class LightBody extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            ///Trade Con for Dex, amybe just a big con penalty and dex bonus?
        }

        @Override
        public String getDescription() {
            return "A tree is sturdy, but a bird is swift, who do you think gets more fruit? Gain a penalty to Con in exchange for a large increase in dexterity";
        }
    }

    public static class NaturalWeapons extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            ///add a weapon to player inventory, that can't be unequppied or something?
        }

        @Override
        public String getDescription() {
            return "Your third leg is a knife. Gain a natural weapons that dealth D4 damange, every time you take this trait, increase the die by one tier (4,6,8,12,20)";
        }
    }

    public static class RadResist extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.addResistance(DamageType.ENERGY);
        }

        @Override
        public String getDescription() {
            return "Radioactive? No, Radiodocile. gain resistance to radiation (and energy damage)";
        }
    }

    public static class Rocky extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //Increase armour rolls by +1
        }

        @Override
        public String getDescription() {
            return "The idea of a 'Mountain King' is more literal for your species. Increase your armour rolls by +1";
        }
    }

    public static class Consort extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setStrScore(playerCharacter.getStrScore() + 1);
            playerCharacter.setConScore(playerCharacter.getConScore() + 2);
            playerCharacter.setIntScore(playerCharacter.getIntScore() - 1);
            playerCharacter.setWisScore(playerCharacter.getWisScore() - 1);
        }

        @Override
        public String getDescription() {
            return "In the complex caste system of your homeworld, you are a himbo. Gain +1 Strength and +2 Constitution, at the cost of -1 Inteliigence and Wisdom.";
        }
    }

    public static class Monarch extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setStrScore(playerCharacter.getStrScore() + 2);
            playerCharacter.setConScore(playerCharacter.getConScore() + 2);
            playerCharacter.setDexScore(playerCharacter.getDexScore() - 3);
        }

        @Override
        public String getDescription() {
            return "In the complex caste system of your homeworld, you may be a living god, undisputed sovereign, or duly elected president imbued with the will of the people. you gain +2 Strength and Constitution, at the cost of -3 Dexterity";
        }
    }

    public static class Soldier extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setStrScore(playerCharacter.getStrScore() + 1);
            playerCharacter.setConScore(playerCharacter.getConScore() + 1);
            playerCharacter.setWisScore(playerCharacter.getWisScore() - 1);
            playerCharacter.setIntScore(playerCharacter.getIntScore() - 1);
            ///Maybe add some kind of "Military heritage" for bonsuses in coversations/certain checks thing to make this better than the Monarch?
        }

        @Override
        public String getDescription() {
            return "In the complex caste system of your homeworld, you are expendable laser fodder, you gain + 1 Strength and Constitution, at the cost of -1 Intelligence and Wisdom";
        }
    }

    public static class Worker extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setUnspentSkillPoints(playerCharacter.getUnspentSkillPoints() + 1);
            playerCharacter.setConScore(playerCharacter.getConScore() + 1);

            ///Maybe add some kind of "low class origin" thing to make certain factions pissed off at you in order to make this not objectively superior to adaptable?
        }

        @Override
        public String getDescription() {
            return "In the complex caste system of your homeworld, you do the vast majority of the work, and are therefore treated terrible, gain +1 Skill & Constitution point";
        }
    }

    public static class Camoflague extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            ///find a way to only apply this bonus if Naked?
            playerCharacter.getSkills().setSkillValue(Skills.Skill.STEALTH,
                    playerCharacter.getSkills().getSkillValue(Skills.Skill.STEALTH) + 1);


        }

        @Override
        public String getDescription() {
            return "Your Species has the remarkable ability to shift hue to blend in with your surroundings, your clothes have stubbornly refused to get with the program, gain +2 to stealth rolls while naked.";
        }
    }

    public static class Ambush extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.getSkills().setSkillValue(Skills.Skill.SNEAK_ATTACK,
                    playerCharacter.getSkills().getSkillValue(Skills.Skill.SNEAK_ATTACK) + 1);
        }

        @Override
        public String getDescription() {
            return "You're well acquainted with the honourable art of shooting an opponent in the head while they're distracted, gain +1 to your Sneak Attack Skill.";
        }
    }

    public static class Intrusive extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.getSkills().setSkillValue(Skills.Skill.SECURITY,
                    playerCharacter.getSkills().getSkillValue(Skills.Skill.SECURITY) + 1);
        }

        @Override
        public String getDescription() {
            return "What is a lock if not a challenge? Gain +1 to your Security Skill.";
        }
    }

    public static class Sneaky extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.getSkills().setSkillValue(Skills.Skill.STEALTH,
                    playerCharacter.getSkills().getSkillValue(Skills.Skill.STEALTH) + 1);
        }

        @Override
        public String getDescription() {
            return "'Step one of a life of crime: Don't get caught.' - Krezzik, Master Thief, you gain +1 to your stealth skill.";
        }
    }

    public static class TechSavant extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.getSkills().setSkillValue(Skills.Skill.TINKER,
                    playerCharacter.getSkills().getSkillValue(Skills.Skill.TINKER) + 1);
        }

        @Override
        public String getDescription() {
            return "Gadgets, Gizmos, Doohickeys and thingamajigs all fall before your expertise, gain +1 to your Tinker skill.";
        }
    }

    public static class Wary extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setReflexSave(playerCharacter.getToughnessSave() + 1);
            playerCharacter.setLogicSave(playerCharacter.getPowerSave() + 1);
        }

        @Override
        public String getDescription() {
            return "You've seen enough bad ideas to see them coming, and how to manage their consequences, gain +1 to your reflexes and logic saves.";
        }
    }

    public static class DeadFlesh extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            /// Double player HP
            /// Add some kind of consequnce mechanic for this, lower comeliness and cha, maybe some kind of flag to make certain factions see you as a monster
        }

        @Override
        public String getDescription() {
            return "You once heard someone saying some people 'just lay down and rot', you felt seen, your decaying flesh body doubles your HP, but at the cost of (define the penalty later)";
        }
    }

    public static class Confident extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setWillSave(playerCharacter.getWillSave() + 2);
        }

        @Override
        public String getDescription() {
            return "You're a very confident person, with much to be confident about. Gain +2 to Will saves.";
        }
    }

    public static class Excess extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setConScore(playerCharacter.getConScore() + 2);
            playerCharacter.setWisScore(playerCharacter.getWisScore() - 1);
        }

        @Override
        public String getDescription() {
            return "Moderation is for cowards, so eat, drink and make merry, for tomorrow you'll probably get someone to die for your gain + 2 Constition and -1 Wisdom.";
        }
    }

    public static class Fashionable extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setConScore(playerCharacter.getConScore() + 2);
            playerCharacter.setWisScore(playerCharacter.getWisScore() - 1);
        }

        @Override
        public String getDescription() {
            return "You dress to impress, gain +1 to your looks and charm saves";
        }
    }

    public static class Shell extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            ///Add natural armour here, same kind of logic as the natural weapons, we'll add these when we're done with inventory shit
        }

        @Override
        public String getDescription() {
            return "By definition, you're a very guarded person. You gain natural armour of 1d4, this increases each time you take this trait.";
        }
    }

    public static class Spines extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            /// Enemies must make a reflex save or take a d4 of damage, add this when Combat's in
        }

        @Override
        public String getDescription() {
            return "Anyone trying to grab you is getting a hand full of barbs, your enemies must make a reflex save when they attack you with a melee weapon, and take 1d4 damage if they fail.";
        }
    }

    public static class Tourist extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //WRITE THIS EFFECT IN LATER WE'RE LAZY AS SHIT
        }

        @Override
        public String getDescription() {
            return "You're not from' round these parts, but you've been keen to learn, gain +1 to ExoTech and Xenoarcheaology, at the cost of -2 Charisma. ";
        }
    }

    public static class Linguist extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //WRITE THIS EFFECT IN LATER WE'RE LAZY AS SHIT
        }

        @Override
        public String getDescription() {
            return "Rediscovering language from first principles is a suprisingly good way to get into peoples heads, gain +1 to languages and xenopsych, at the cost of someshit idunno this is unfniished";
        }
    }

    public static class Cunning extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setWisScore(playerCharacter.getWisScore() + 1);
        }

        @Override
        public String getDescription() {
            return "Nobody could ever call you 'Cun't' Gain +1 Wisdom ";
        }
    }

    //elemental traits, these count as 2 race traits when selected, will figure this out later
    public static class Air extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setDexScore(playerCharacter.getDexScore() + 1);
            playerCharacter.setWillSave(playerCharacter.getWillSave() + 2);
        }

        @Override
        public String getDescription() {
            return "Out of the four classical elements, you're the best, you outnumber the others by far, gain +1 dex and +2 to your will saves";
        }
    }

    public static class Fire extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            /// gain nautral weapon that deals 1d4 fire damage, use the spines mechanic but with toughness not reflexes for 1d4 fire dam
            playerCharacter.addResistance(DamageType.HEAT);
            playerCharacter.addVulnerability(DamageType.COLD);
        }

        @Override
        public String getDescription() {
            return "Out of the four classical elements, you're the best, you burn brighter and can destroy the others. Gain a 1d4 natural fire weapon, resistance to heat damage, and vulnerability to cold damage.";
        }
    }

    public static class Earth extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            /// Increase armour rolls by +1
            //+1 con (too fucking lazy to do it)
        }

        @Override
        public String getDescription() {
            return "Out of the four classical elements, you're the best, long after the others are gone, your mountainous mass will remain, you gain +1 con, and a +1 to all armour rolls.";
        }
    }

    public static class Water extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            /// increase str by 1
            //+1 con (too fucking lazy to do it)
        }

        @Override
        public String getDescription() {
            return "Out of the four classical elements, you're the best, you can erode and douse any challengers, gain +1 constitution and strength.";
        }
    }

    public static class Energistic extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.addResistance(DamageType.ENERGY);
            playerCharacter.addVulnerability(DamageType.PHYSICAL);
        }

        @Override
        public String getDescription() {
            return "Hippies tend to confuse you and vibes a lot, gain a resistance to energy damage, and a vulnerability to physical.";
        }
    }

    /// Exotic Attack (Exotic)
    /// You have access to a special, exotic attack, unique to your species which you can use once per encounter.
    /// Dart: You can shoot a dart or quill from your flesh as a ranged attack with a range equal to your Strength in metres. It does
    /// D4 damage. You can take this multiple times to step up the damage and to increase the range by 2 metres each time.
    /// Electroshock: You can discharge an electric shock through your body. This is a Hand-to-Hand attack, resisted by a
    /// Toughness Save. If they fail they are stunned for 1d6 turns.
    /// Fire Breathing: You can breathe a plume of fire up to five metres. This does D4 damage to anyone hit by it. They can make
    /// a Reflexes Save to dodge. You can take this multiple times to step up the damage.
    /// Sonic Boom: You can discharge a powerful sound at a range of up to five metres. This does D4 damage to anyone hit by it.
    /// They can make a Toughness Save to resist the effect. You can take this multiple times to step up the damage.
    /// Toxic Gas: You can expel a cloud of toxic gas two metres around yourself in every direction. Those in the cloud must make a
    /// Toughness save or take D4 damage. You can step this up by taking it multiple times. You are unaffected by the cloud and it
    /// can last several turns.
    /// Ok so these are the exotic attacks, i have no idea if i can implement these properly
    ///
    /// Descriptions:
    /// Dart: You're always a favourite on darts night at the pub, you can shoot a dart or quill from your body, starting as a D4 piercing weapon, you can take this multiple times to increase it's damage by one die.
    /// Electroshock: You're very electrocute. You can make a hand to hand attack, where the enemy must make a toughness save, if they fail, they are stunned for 1d6 turns.
    /// Firebreathing: You spit straight fire. you can emit a jet of flame that deals 1d4 fire damage to all enemies, but they have anopprtunity to dodge with a reflex save, you can take this multiple times to increase it's damage by one die.
    /// Sonic Boom: Shouting matches among your species can be fatal,you can emit a jet of flame that deals 1d4 energy damage to all enemies, but they have anopprtunity to withstand it with a toughness save, you can take this multiple times to increase it's damage by one die.

    public static class Graceful extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setDexScore(playerCharacter.getDexScore() + 1);
        }

        @Override
        public String getDescription() {
            return "When the television show named Earth was being created, they based cats partly off you, gain +1 dexterity";
        }
    }

    public static class Large extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            /// reduce ranged and close defence by 1, gain an extra +1 to melee strikes and health per level
        }

        @Override
        public String getDescription() {
            return "When you found out about Gittens, you genuinely couldn't believe a creature that small was real, your ranged and close defence is reduced by 1, but you gain +1 damage when hitting with a melee weapon, and an additional hitpoint per level";
        }
    }

    public static class Warrior extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            /// Plus one ranged and close attack (to hit chance)
        }

        @Override
        public String getDescription() {
            return "Your gait is the march, your music the bugle, and your destiny, an early grave, gain +1 to close and ranged attack.";
        }
    }

    public static class Weapon extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //Add profciency with a weapon type
        }

        @Override
        public String getDescription() {
            return "THIS IS MY HOLORIFLE, THERE ARE MANY LIKE IT BUT THIS ONE IS MINE. GAIN +1 TO A CHOSEN WEAPON SKILL,MAGGOT!";
        }
    }

    public static class Chitin extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //+1 to armour rolls
            //Might have some overlap with rocky/shell?
        }

        @Override
        public String getDescription() {
            return "Nature protects that which is precious, and it found you very precious, gain +1 to armour rolls.";
        }
    }

    public static class Flowering extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //+1 comeliness
        }

        @Override
        public String getDescription() {
            return "Aliens are suprisingly like bees in how attracted they get to pretty flowers, gain +1 Comeliness";
        }
    }

    public static class Foothands extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //+1 climb skill
        }

        @Override
        public String getDescription() {
            return "'Look ma! No feet!' You gain +1 to your climb skill.";
        }
    }

    public static class Tail extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //Gain extra attack if taken three times, and +1 reflex save generally
        }

        @Override
        public String getDescription() {
            return "'Getting Tail' is a phrase that confuses you, gives +1 reflex save, if taken three times, you can make an extra attack per round.";
        }
    }

    public static class PsiPower extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //gain an extra Psipoint to spend on abilities
        }

        @Override
        public String getDescription() {
            return "You have pierced through the veil to the psychic realm, all that's left is to reach out and take it, gain +1 Psi Point";
        }
    }

    public static class PsiTalent extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //gain an extra psi talent, even if not Psion(?)
            //this feels like it'll be a collosal pain in the ass to implement
        }

        @Override
        public String getDescription() {
            return "You give good brain. You can take a Psi power even if you're not a Psionic";
        }
    }

    public static class ColdBlooded extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //gain +1 will and toughness
        }

        @Override
        public String getDescription() {
            return "Your passions run cold, gain +1 to will and toughness saves";
        }
    }

    public static class Regeneration extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            //restore 1HP per round
        }

        @Override
        public String getDescription() {
            return "Your ancestors broke through concrete to gain nourishment from the stars, and you have similar tenacity, restore 1HP every round.";
        }
    }

    //Fuel eater's purely roleplaying based, eating the worst kind of stuff imaginable, but there's a few of these traits, maybe think about ways to implement them


    /// "Take a cup of Sarin Gas, and a pinch of plutonium" is a common sight in your species cookbooks, you can eat material others would refuse to, but at
    /// the expense of others being pretty grossed out


    //So self protecting should go here but it's redundant with mindful, so i'm not writing it again


    public static class Fecund extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setComScore(playerCharacter.getComScore() + 1);
        }

        @Override
        public String getDescription() {
            return "When people describe 'The Beast with two backs' They may well be referring to your species, you gain an extra Comeliness point";
        }
    }

    public static class Gasbag extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setCanFly(true);
            playerCharacter.setSpeed(playerCharacter.getSpeed() / 2);
        }

        @Override
        public String getDescription() {
            return "Your species developed a biological form of propulsion, you can fly naturally, but move half as fast.";
        }

    }

    public static class SlowMetabolism extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            ///Implement after saving rolls are in
        }

        @Override
        public String getDescription() {
            return "If you ever had Gonorrhea, don't worry - it's now 'Gone'orrhea, you gain a +5 to saving rolls against Poison and Disease";
        }
    }

    public static class LimitedShapeshifting extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setCanFitThroughSmallSpaces(true); // Example effect
        }

        @Override
        public String getDescription() {
            return "An intensive amount of flexibility allows you to easily contract yourself to fit in small spaces";
        }

    }

    public static class Resilient extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setToughnessSave(playerCharacter.getToughnessSave() + 1);
            playerCharacter.setPowerSave(playerCharacter.getPowerSave() + 1);
        }

        @Override
        public String getDescription() {
            return "You're built like a ToughCo certified Brick Shithouse, and gain +1 to your Toughness and Power Saves";
        }
    }

    public static class Enduring extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setConScore(playerCharacter.getConScore() + 1);
        }

        @Override
        public String getDescription() {
            return "'He Lives, and He lives, until all the lights go out' Gain +1 Constitution.";
        }

    }


    public static class Fearful extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setReflexSave(playerCharacter.getReflexSave() + 1);
            playerCharacter.setWillSave(playerCharacter.getWillSave() + 1);
        }

        @Override
        public String getDescription() {
            return "'Some may call it cowardice, but a rabbit who never burrows isn't courageous, they're stupid, and usually dead. Your fearful nature gives you +1 to your will and reflex saves.";
        }
    }

    public static class StrongWilled extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setWillSave(playerCharacter.getWillSave() + 2);
        }

        @Override
        public String getDescription() {
            return "Through continued cultivation of restraint, you are far harder to tempt, you gain +2 to your will saves.";
        }
    }

    public static class Tough extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setToughnessSave(playerCharacter.getToughnessSave() + 2);
        }

        @Override
        public String getDescription() {
            return "You are the waiting Anvil to the hammer of the world, and will not falter, gain +2 to toughnss saves. ";
        }
    }

    public static class Strong extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setStrScore(playerCharacter.getStrScore() + 1);
        }

        @Override
        public String getDescription() {
            return "'Eat any good books lately?' You gain +1 Strength";
        }
    }

    public static class RapidReaction extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setReflexSave(playerCharacter.getReflexSave() + 2);
        }

        @Override
        public String getDescription() {
            return "Docility is Death for your kind, and you have learned the lesson well. you gain +2 to reflex saves.";
        }
    }

    public static class VeryStrong extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setStrScore(playerCharacter.getStrScore() + 2);
            playerCharacter.setDexScore(playerCharacter.getDexScore() - 1);
        }

        @Override
        public String getDescription() {
            return "'Grace is for Church' You gain +2 strength, however, your dexterity is reduced by 1";
        }
    }

    public static class VeryTough extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setConScore(playerCharacter.getConScore() + 2);
            playerCharacter.setDexScore(playerCharacter.getDexScore() - 1);
        }

        public String getDescription() {
            return "Moons will be moved before you are, gain +2 Constitution at the cost of -1 Dexterity";
        }

    }

    public static class HiGAdapted extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setPowerSave(playerCharacter.getPowerSave() + 2);
            playerCharacter.setToughnessSave(playerCharacter.getToughnessSave() + 2);
            playerCharacter.setReflexSave(playerCharacter.getReflexSave() - 2);
        }

        public String getDescription() {
            return "'I've Fallen, and i can't get up!' Is considered one of the shortest, tragic stories where you grew up" +
                    "You gain +2 to your power and toughness saves, at the cost of -2 to your reflex saves. ";
        }

    }

    public static class Survival extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.getSkills().setSkillValue(Skills.Skill.SURVIVAL,
                    playerCharacter.getSkills().getSkillValue(Skills.Skill.SURVIVAL) + 1);
        }

        public String getDescription() {
            return "In Space, it's hard to find Bush, but you're excellent at bushcraft anyway, gain +1 Survival.";
        }
    }

    public static class Stalker extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.getSkills().setSkillValue(Skills.Skill.STEALTH,
                    playerCharacter.getSkills().getSkillValue(Skills.Skill.STEALTH) + 1);
        }

        public String getDescription() {
            return "'We Have more ... subtle methods' You gain +1 to your Stealth Skill.";
        }
    }

    public static class Flight extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            // This method can be used to apply the flight effect, such as modifying movement speed.
            playerCharacter.setCanFly(true);  // Example method to indicate flight capability.
            playerCharacter.setSpeed(playerCharacter.getSpeed() * 2);  // Double the ground speed.
        }

        public String getDescription() {
            return "If God intended Man to fly, he would've made them your species, you gain flight, and double your movement speed";
            //Find a way to balance this so gasbag isn't objectively shittier
        }
    }

    public static class Mindful extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setLogicSave(playerCharacter.getLogicSave() + 1);
            playerCharacter.setWillSave(playerCharacter.getWillSave() + 1);
        }

        public String getDescription() {
            return "Shields can take a hit, Guns can dish them out, only a Brain can build them, you gain +1 to your logic and will saves";
        }
    }

    public static class Thoughtful extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setIntScore(playerCharacter.getIntScore() + 1);
            ///playerCharacter.setIntMod(playerCharacter.getModifier(playerCharacter.getIntScore())); // Update modifier
        }

        public String getDescription() {
            return "You're clever enough to disregard the absurdity of reducing intelligence to a arbitrary statistic, that being said, you gain +1 to your intelligence score";
        }
    }

    public static class Beautiful extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setComScore(playerCharacter.getComScore() + 1);
        }

        public String getDescription() {
            return "You cause more thirst than a drought, gain +1 Comeliness";
        }
    }

    public static class Charming extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setChaScore(playerCharacter.getChaScore() + 1);
        }

        public String getDescription() {
            return "You are the difference between flirting and harassment, Gain +1 Charisma ";
        }
    }

    public static class Gregarious extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setCharmSave(playerCharacter.getCharmSave() + 2);
        }

        public String getDescription() {
            return "You've got the gift of the gab, and are quite generous, gain +2 to charm saves";
        }
    }

    public static class Sexy extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setLooksSave(playerCharacter.getLooksSave() + 1);
            playerCharacter.setCharmSave(playerCharacter.getCharmSave() + 1);
        }

        public String getDescription() {
            return "'WOWEEEEE HUMMMANHUMMANAN BOING AWOOGA' Gain +1 to Looks and Charm saves.";
        }
    }

    public static class Flexible extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.setReflexSave(playerCharacter.getReflexSave() + 1);
            playerCharacter.setToughnessSave(playerCharacter.getToughnessSave() + 1);
        }

        public String getDescription() {
            return "You hold the Osinium medal in Gymanastics, gain +1 to to Refelex and Toughness saves.";
        }
    }

    public static class Boiling extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            playerCharacter.addResistance(DamageType.HEAT);
            playerCharacter.addVulnerability(DamageType.COLD);
        }

        public String getDescription() {
            return "Some like it hot, you like it boiling, gain resistance to heat damage and a vulnerability to cold.";
        }
    }

    public static class Electrosense extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {
            /// Ok, so this one's weird, lets you sense electricity as a sense, i'm saying we can make checks if the player has this trait for certain perception checks
            /// and provide a big bonus to it if they do
        }

        public String getDescription() {
            return "In your culture, the seventh sense is the one that lets you see ghosts, your sixth does boring stuff, like allowing you to sense any nearby electrical current";
        }
    }

    public static class Heatfeeder extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {

        }

        public String getDescription() {
            return "Your species can feed off incredible heat sources, gain +1 HP when exposed to heator fire, at the cost of constantly being angered by misleading hot-sauce ads.";
        }
    }

    public static class Poisonous extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {

        }

        public String getDescription() {
            return "Your ancestors may have been eaten by predators, but they always got the last laugh, because of your toxic blood, any enemy or creature biting you must make a Toughness save or take D6\n" +
                    "damage. You can coat your own weapons with your toxin by cutting yourself, taking 1 hit point of damage. This lasts for a\n" +
                    "single hit";
        }
    }

    public static class WarningSign extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {

        }

        public String getDescription() {
            return "Quite fortunately, Animals are put off by your technicolour skin, you are targeted last by them in combat";
        }
    }

    public static class Woo extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {

        }

        public String getDescription() {
            return "Your mind's so open, it tends to let in a lot of guff, fortunately, a lot of that is thinly veiled psychic metaphor, gain +1 Psi Point";
        }
    }

    public static class ZeroG extends RaceTrait {
        @Override
        public void applyEffect(PlayerCharacter playerCharacter) {

        }

        public String getDescription() {
            return "Your species saw the weaker bones, muscular degeneration, and general hard times of space living, and immediately hopped to it before they even invented artificial gravity, you gain +3 to any checks made in low or zero gravity.";
        }

        public static class Tentacles extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {

            }

            public String getDescription() {
                return "Mellekian Elapids, Boa Constrictors, Your arm, all of these are known for killing with their intense grip, gain +1 to rolls attempting to constrict and enemy, but -1 to escaping constriction. ";
            }


            // Add other traits as needed
        }

        public static class Slow extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// You can take this to remove an attribute penalty for taking another trait, at the cost of halving your speed
            }

            public String getDescription() {
                return "Look at a 10,000 year old Callistian Redwood and say that the flies at its base are the real winners, your movement speed is halved, but you can take another trait for free (pay no attribute penalty), you can take this trait twice.";
            }


            // Add other traits as needed
        }

        public static class Painless extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// +1 hp per level, and +1toughness save
            }

            public String getDescription() {
                return "Whether through intense cultivation, a particularly pleasant ecosystem, or something else entirely, you have no pain response, gain +1 hp per level, and gain +1 to your toughness save.";
            }


            // Add other traits as needed
        }

        public static class SelfSustaining extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Never need food if you've got sunlight, i'm saying we can adapt this to provide a bonus outside
            }

            public String getDescription() {
                return "'Light food' is more literal for your species, you gain +2 ranged and close attack while under a star (outdoors)";
            }


            // Add other traits as needed
        }

        public static class NonCombat extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Get a free extra trait (no penalty) in exchange for reducing closed and ranged attack
            }

            public String getDescription() {
                return "War is a disease, and you aspire to cure it, gain a free extra trait, and the cost of -1 closed and ranged attack.";
            }


            // Add other traits as needed
        }

        public static class Immaterial extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Ok so the original is no interacting with the world, we'll change it to it doesn't matter how clever you get, a laser will fry you regardless, you are capped to 1HP, but gain +2 skill points to ALL skills.
            }

            public String getDescription() {
                return "Eschewing the physical world is truly transcendental, that being said, it doesn't matter how clever you get, a laser will fry you regardless, you are capped to 1HP, but gain +2 skill points to ALL skills.";
            }
        }

        public static class Fur extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// +2 to checks against weather
            }

            public String getDescription() {
                return "Your birthday suit's a bit warmer than others, gain +2 to checks against the effects of cold weather.";
            }
        }

        public static class Fanatic extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// +2 to checks against weather
            }

            public String getDescription() {
                return "Football Teams, Ideology, God, if you support anything, you don't do it by halves, gain +1 Will and Constitution.";
            }
        }

        public static class Avatar extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// give popup to allow popup for either a device (define rules for these later, makes sense the player could buy like, i don't know, a ladderbot or some shit for climbing)
                /// or ship, which would probably be a flat bonus to pilot skill and maybe some kind of ship combat bonus if we put that in the game
            }

            public String getDescription() {
                return "You've got, or possibly are, a talking car, choose a machine to 'bond' with, gain +1 to rolls involving said machine";
            }
        }

        public static class BrotherMachine extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                playerCharacter.getSkills().setSkillValue(Skills.Skill.TINKER,
                        playerCharacter.getSkills().getSkillValue(Skills.Skill.TINKER) + 1);
            }

            public String getDescription() {
                return "Y0U H4V3 4551NTY W1TH M4CH1N35. G41N +1 T0 Y0UR T1NK3R 5K1LL.";
            }
        }

        public static class CodeBody extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// So, as a way to distinguish this from immaterial, I like the idea of something similar but more "digital", so locking the player from natural weapons
                /// But improving their tech skills and maybe giving a bonus to laser weapons or something

                /// Tenative idea: capped at 1 HP (like immaterial), but instead of skill monkey, we're talking glass cannon, no melee weapons, but something like a +3 for a chosen ranged weapon skill
            }

            public String getDescription() {
                return "Sticks and stones can't break your (non-existent) bones, but Zip Bombs will definitely brick you, add explanation here when we've finalised penalty";
            }
        }

        public static class Colony extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Add physical damage resistance, add fire vulnerability
            }

            public String getDescription() {
                return "You're a eusocialist, a crowd of technically distinct lifeforms stuffed into one convenient bag-of-person. Compared to '1r’s'—those boring, single-bodied creatures—you’re much more resilient. Gain resistance to physical damage, but suffer a vulnerability to fire.";
            }
        }

        public static class ExtraAction extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Add extra action
            }

            public String getDescription() {
                return "Anything worth doing is worth doing twice, gain an extra action per turn.";
            }
        }

        public static class Engineered extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Gain +1 to all attributes, at a cost of maybe -2 to looks and charm save?
            }

            public String getDescription() {
                return "To your species, DNA is basically lego, unfortunately, playing god with your own genetic code has given you the attitude of a haughty prick, gain +1 to ALL attributes, but -2 to your looks and charm saves.";
            }
        }

        public static class FastMetabolism extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// +2 Dex,-5 to poision and disease saves
            }

            public String getDescription() {
                return "Your species lives fast, and dies often, gain +2 Dex,-5 to poision and disease saves";
            }
        }

        public static class Faz extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Conditional bonus to certain checks based on vibration,like i guess help with mining, or sensing danger
            }

            public String getDescription() {
                return "You're the guy the Energistic description was talking about, you can sense vibrations.";
            }
        }

        public static class CannotMove extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///When rollng intiative, always go last, instead of negating a penalty, maybe just allocate an extra +4 to a stat?
            }

            public String getDescription() {
                return "Woah, Slow down there buster, you were just going 3.3 Micrometers an hour. You Gain +4 to a chosen stat, but always move last in Combat, you can only take this Trait once.";
            }
        }

        public static class Educated extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Gain a point in a lore skill,
            }

            public String getDescription() {
                return "'Amber, i'm telling you, everyone's lying about doing the reading, so if you just do a little bit, you'll be fine' - Amber Fryst, Uncredentialled Communist. You gain +1 on a lore skill of your choice, even if you're not a Scholar.";
            }
        }

        public static class SealedSystem extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Probably way too contextual for it's own good, what's the fantasy here? Well it's great endurance, innoculation from the elements
                ///Idea, Pick a resistance? Neutralise a weakness? This way you can build "CUBE", the totall blank invlunerable cube who sees every damage type and blankly stares it to death
            }

            public String getDescription() {
                return "A pelt can defeat cold, light absorbing skin, the heat, and lead based skin, radiation. Your species has evolved to contain a natural resistance, pick a damage type, and gain resistance to it, or neutralise a weakness.";
            }
        }

        public static class Narrow extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// -1con
                /// +1dex
                /// set limited shapeshifting to true
            }

            public String getDescription() {
                return "Why be a ball or a cube when you could be a tube? Gain Limited Shapeshifting to represent your ability to coil and fit through small gaps, +1 Dexterity, and -1 Constititon.";
            }
        }

        public static class ToxicGas extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// give a natural weapon (we should make this a subtype of equipment that can't be removed, seems like the simpliest way)
                /// for increasing the damage when taken, we could have a pretty simple form of simply having variants on the weapon pushed onto the given PC
                ///
            }

            public String getDescription() {
                return "When people describe your species public speakers as having 'An acerbic tongue', you are genuinely confused, what other types of tongue are there?" +
                        " You gain a natural weapon that can create a cloud of Toxic gas, forcing your opponents to make a toughness save each turn, or take 1d4 Poison damage," +
                        " this damage can be improved by taking the trait numerous times";
            }
        }

        public static class InfraredVision extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// +1 Survival, kind of boring
                ///
            }

            public String getDescription() {
                return "It's remarkable how weird, you once noted, dating gets when you can literally see the other person's body heat rise and fall" +
                        "You wonder if it's less fun this way, then recall that they probably have never tracked down a thief from the slowly dissipating heat image" +
                        "of the dickhead who nicked your Gamestation, and abandoned the thought, gain +1 Survival for your tracking ability";
            }
        }

        public static class UVVision extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// +1 Search, kind of boring
                ///
            }

            public String getDescription() {
                return "IT'S NOT FUCKING BEIGE, YOU GODDAMNED PHILLISITE, IT'S ZORN, I WORK IN ZORN, IT'S NOT A STATEMENT ON YOU BUYING ANYTHING, IT'S A STATEMENT" +
                        "OF HOW FUCKING HARD IT IS TO RENDER A SUNSET USING ZORN, JUST BECAUSE YOU CAN'T SEE IT DOESN'T MEAN IT'S, STOP WRITING THAT DOWN" +
                        "IT WASN'T PROFOUND, GOOD FUCKING GOD.- Trillo Carks, unwilling avant garde artist, fellow Ultra Violet seer" +
                        "You gain +1 to your search skill, and a finer appreciation of the cosmic symphony of colour.";
            }
        }

        public static class Fast extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///We'e probably going to want to make a seperate initiatve stat, that this will increase it by 20%
            }

            public String getDescription() {
                return "Aesop can get bent, he never saw you race a tortoise. Gain a 20% Bonus to your initiative rolls.";
            }
        }

        public static class ThreeDThinking extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///We'e probably going to want to make a seperate initiatve stat, that this will increase it by 20%
            }

            public String getDescription() {
                return "Some people say 'Think outside the Box', when they barely know how to think inside of it, you're more of an expert, gain +1 to your pilot skill";
            }
        }


        public static class StoneBody extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///I think we're going to have to crank up that dex penalty because taking this six times gets you a literal d24 worth of damage negation at game start which is awesome but fucking ludicrous
            }

            public String getDescription() {
                return "You look like you were cut from a mountain, in fact, you may well have literally, been cut out of a mountain, gain 1d4 Natural Armour, at the cost of one dexterity.";
            }
        }

        public static class GooBody extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// OK this one is utterly fucking broken, we are going to need to massively bump up that con penalty
            }

            public String getDescription() {
                return "Alright, you may not be built like a statue, but, consider: ever tried stabbing Jelly to death? Gain the limited shapeshifting trait, gain resistance to physical damage, and lose one constitution ";
            }
        }

        public static class Frozen extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {

            }

            public String getDescription() {
                return "Old Man Winter's a rude way to refer to your grandad, gain a vulnerability to fire damage, and a resistance to cold damage.";
            }
        }

        public static class WaterBreathing extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                //Probably going to add a boolean for "Can breathe liquid" which will give advantages in checks related to stuff done at sea
            }

            public String getDescription() {
                return "It's a well known falsehood that 'fish have no word for water', you can prove them wrong and watch in delight as they drown trying to make a comeback. You can breathe in liquid environments.";

            }
        }

        public static class Bioluminescent extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Idea to differentiate this one, maybe add a sneaking penalty and add a natural weapon that can do minor radiation damage to make it more of an interesting "You can literally blind people with flash power
                ///style nonsense
            }

            public String getDescription() {
                return "You may not have a glowing personality, but you sure do glow, you cast a constant light, allowing you to see in the dark";

            }
        }

        public static class Nightvision extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Just flip a "Can see in dark" boolean to true
            }

            public String getDescription() {
                return "It's so cute when the Prey thinks the absence of the sun will save them. You can see in the Dark.";

            }
        }

        public static class AcuteHearing extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Add a "SensoryBonus Hearing" that we can apply to checks related to hearing
            }

            public String getDescription() {
                return "Your species music infuriates others, while most cannot properly differentiate 1/256th of an Octave,for you, it's hilariously obvious. gain bonuses on Checks related to hearing.";

            }
        }

        public static class AcuteSenseOfSmell extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///increase Search and Survival by one point
            }

            public String getDescription() {
                return "Some children learn the colours of the rainbow at nursery, your species might, but they also learn the beauty of the olfactory continuity cylinder, Gain +1 to your Search and Survival skills";

            }
        }

        public static class PackMentality extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///"Help" functions in combat aren't done yet, as combat isn't done yet, +2 sounds like a lot, but like, you are giving up your turn to do it
            }

            public String getDescription() {
                return "A 'Lone wolf' is your species' word for 'Total Moron' Gain a +2 Bonus to helping an ally aim and deal damage in combat.";

            }
        }

        public static class DefensiveCloud extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Add a natural weapon that gives a defensive bonus that lasts a few turns
            }


            public String getDescription() {
                return "Everyone loves to make fun of Octopi until they're stuck in a cloud they can't see through with 8 angry knives stabbing them. You can produce a defensive cloud, giving you bonuses to defence (define later)";

            }
        }

        public static class EchoLocation extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Add see in the dark,maybe also a natural weapon to let "Batboy shrieking his enemies to death" have this work as less "here is another see in the dark flavour lol"
            }


            public String getDescription() {
                return "Cartography for your species is as natural as shouting 'Yodelheyhehoo!'. You can see in the dark even if blinded.";

            }
        }

        public static class ChemicalFeast extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Add massive bonuses to Poison checks, probably have some kind of system of rotten food or cheap chemicals that these guys can use for HP recovery
            }


            public String getDescription() {
                return "A lot of the Galaxy is perfectly content with Sodium Chloride, but, ohhh, add a bit of Potassium Cyanide to your meal and all of a sudden everyone's judgy. You can consume normally inedible chemicals, and in fact, might even prefer them.";

            }
        }

        public static class PoisonResistant extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Add massive bonuses to Poison checks
            }


            public String getDescription() {
                return "Fugu? Fuggedabout it. You are resistant to Poisons.";

            }
        }

        public static class Cybernetics extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Add this when we add the hell that is going to be Augmentations, Glitch, etc.
            }


            public String getDescription() {
                return "You can understand the eternal recursive cycle of input, controller, output, but also understand it could be improved with a kickass Robo-arm. Gain a free, basic augmentation (below 100 GP)";

            }
        }

        public static class FearAttack extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Add a natural weapon that does what the description says, original has "Flee", but that feels kind of lame and gets to te eternal "Bosses don't interact with my chosen things" problem
            }


            public String getDescription() {
                return "A Bullet's all well and good but sapient minds are more than capable of brutally torturing themselves, if you just give them a push. Once per encounter, you can force your enemies to make a Charm save, inflicting the frightened condition on them if they fail.";

            }
        }

        public static class SelfProtecting extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///+1 to Logic and will saves
            }


            public String getDescription() {
                return "Living inside a six feet thick lead mech is one thing, but if you hate yourself for doing it, is it really worth it? Gain +1 to your Logic and Will saves, to protect your ego.";

            }
        }

        public static class PowerUp extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Add natural weapon that has a popup allowing a player to basically load themselves into the gun
                ///Rulebook has a "You can also use this for machines at the GM's digression but frankly, i don't want to get into a "well, how much HP should a point extra in a skill be worth" for every check related to a machine in the game
            }


            public String getDescription() {
                return "There's a bit of yourself in everything you do, so why would burning someones face off with a laser pistol be any different? You gain the ability to place portions of your HP as bonus damage on your next shot with an energy weapon.";

            }
        }

        public static class TechZen extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Add +1 to ExoTech, which can bring it above 6
                ///Does raise an interesting question of Checks above 6, Motsp works on a over sitation with skills being 1D6, so a few ExoTech skill checks of 7 or Higher for seriously insane shit like an early game BFG equivilant could be fun
            }


            public String getDescription() {
                return "Gittenian Trinary, Ancient Rombulian Hydraulics, COBOL, if it's utterly antiquated technology, you are Home. You gain +1 to your Exotech skill, and can bring it above 6.";

            }
        }

        public static class Fleet extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Add +1 to ExoTech, which can bring it above 6
                ///Does raise an interesting question of Checks above 6, Motsp works on a over sitation with skills being 1D6, so a few ExoTech skill checks of 7 or Higher for seriously insane shit like an early game BFG equivilant could be fun
            }


            public String getDescription() {
                return "Jack be nimble , Jack be quick, Jack rarely trips on his own dick. Gain +1 Dexterity.";

            }
        }

        public static class Emotive extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                //add one wisdom
            }

            public String getDescription() {
                return "Your body language is eerily simple and yet totally communicative. Gain +1 Wisdom";

            }
        }

        public static class Scales extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                //add one wisdom
            }

            public String getDescription() {
                return "Skin is overated, ever see it stop a knife? Course you haven't, your scaled body adds +1 to your armour rolls.";

            }
        }

        public static class CombatReflexes extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                //add two iniative
            }

            public String getDescription() {
                return "Your deep understanding of martial ways has made you well attuned to the ancient method of 'shooting your opponent in the face before he can do the same to you', Gain +2 to your Initiative rolls.";

            }
        }

        public static class Tiny extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                //Reduces HP, adds close and ranged def (?)
            }

            public String getDescription() {
                return "Float Like a Butterfly, Sting like a Bee, Live better than any dumb collosus with his head in the trees.";

            }
        }

        public static class IntimateOfNature extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Add five Planet types that we can set in map data, Urban, Temperate, Hot, Cold, and Jungilic, on taking the trait more than once, adjust the underlying effect to be stronger? Could be a pain in the ass, the thing is
                ///We're probably going to have to run a "Check relevant bonuses" function for our events regardless, which is probably going to be fine once we actually make it as simple as being able to group them and set a single variable in the constructor to say "YES ICE2674 IS COLD"
            }

            public String getDescription() {
                return "It's a bit hard not to be at least a bit Parochial when your entire physiology is literally tied to home. Gain +2 Survival on PLanets of Your Homeworld's Ecology (pick when you take this trait)," +
                        "and -1 on Planets that are not, You can take this repeatedly, if you take your claim that Ice-Rock 2674, your Home, is intrinsically superior to any shithole dessert or temperate zone in the galaxy, completely seriously.";

            }
        }

        public static class LiveOn extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Exactly what it says, upon death, a pop up arises, first, the penalty, then, who takes the penalty
            }

            public String getDescription() {
                return "You cannot die. Hey, wait, hold on, hold on, calm down, you can never Die, if you choose! If you do, you're looking at -TWO to ALL attributes," +
                        " -SIX to one, or -TWO, to a skill... Though of course, should any willing sucke- you mean, kindly hosts!, be travelling with you, well, what are blood bags- Friends! You meant friends!" +
                        "Then what are friends for? It also costs three trait points, and, you could choose to die, but come on, what kind of Parasite would do that?";
            }
        }

        public static class HostPowers extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///Exactly what it says, upon death, a pop up arises, first, the penalty, then, who takes the penalty
            }

            public String getDescription() {
                return "It's called kleptocnidy, technically, you know it as the thing that let your species historically roast Fire Breathing Tokklem's over a spit with a taste of their own medicine." +
                        "You can borrow a party member's natural weapon, and use it as your own for the rest of a fight.";
            }
        }

        public static class Seperate extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                ///
            }

            public String getDescription() {
                return "You are Seperate but equal. Not, not in the racist way, look, this started bad, let's, i'll tell you what you can do" +
                        ". You can sacrifice half your HP, rounded down, to provide yourself with an Extra Action for the rest of a given combat, represeting your personage splitting into different bodies.";
            }
        }

        public static class Serene extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                playerCharacter.setCharmSave(playerCharacter.getCharmSave() + 1);
                playerCharacter.setWillSave(playerCharacter.getWillSave() + 1);
            }

            public String getDescription() {
                return "Everyone thinks you're so fucking above it all, and frankly, you are, having abandoned the wordly wiles of harlots (anyone who may be interested in Intimacy)" +
                        "And the endless horde of cruel mindworms (Alright i concede you may have a point on this one), you gain +1 to your Charm and Will saves. Bully for You.";
            }
        }

        public static class Interface extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                playerCharacter.getSkills().setSkillValue(Skills.Skill.SECURITY,
                        playerCharacter.getSkills().getSkillValue(Skills.Skill.SECURITY) + 1);

                ///Should change this when we add in that selective improvement things for Events, so that if the thing is computer security tagged, you get the better boost, avoids redundancy as well
            }

            public String getDescription() {
                return "Who the fuck is 'Krezzik' So called 'Master Thief'? You know a guy from a hacker forum who wiped out the entire GDP of Git's worth of Palladium and didn't get out his chair, he carries a lock pick? Fucking Lmao, Who is this dipshit???." +
                        " Gain +2 to your Security skill when engaging with computer security";

            }
        }

        public static class KillerInstinct extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Add +2 to Close Attack when combat statistics are implemented
            }

            public String getDescription() {
                return "Every army since the invention of the firearm, and then lightarm, has been desperately attempting to prove that actually, " +
                        "hitting a man with something incredibly unpleasant up close can defeat thousands of cowardly bullets fired by even more cowardly men" +
                        "When doing this, they Cite your species, and then everyone gets a bit quiet and someone says 'Fuck, good point' Gain +2 to your Close Attack.";
            }
        }

        public static class Venom extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Add 1d4 additional Poison damage to natural weapons
                /// Enemy must fail a Toughness save to receive this damage
                /// Increase damage die for each subsequent selection
            }

            public String getDescription() {
                return "Did you know that Torkid Kneels had 23 Sensory Organs more than the galactic average? Did you know he died screaming in Agony, despite his millions," +
                        " having picked a fight with 'Dave Rattletooth', local shitkicker who had access to venom on his claws? Much to think on." +
                        " Your natural attacks inflict an additional 1d4 Poison damage if your opponent fails a Toughness save." +
                        " Taking this trait repeatedly increases the damage die.";
            }
        }

        public static class MindControl extends RaceTrait {
            @Override
            public void applyEffect(PlayerCharacter playerCharacter) {
                /// Add 1d4 additional Poison damage to natural weapons
                /// Enemy must fail a Toughness save to receive this damage
                /// Increase damage die for each subsequent selection
            }

            public String getDescription() {
                return "You're getting pretty sick of explaining you do not garner the ability to fully understand the inscurtable minds of anything from ants to something as insanely complex as other sapient beings" +
                        ". However! You take do take amusement that lowering aggression thresholds and temporarily dulling psychological mechanisms associated with determining friends has everyone thinking you can." +
                        "As an action you make a melee attack, with your target making a will save, if they fail, they spend their next turn attacking their friends.";

            }

            public static class Paralytic extends RaceTrait {
                @Override
                public void applyEffect(PlayerCharacter playerCharacter) {
                    /// Add 1d4 additional Poison damage to natural weapons
                    /// Enemy must fail a Toughness save to receive this damage
                    /// Increase damage die for each subsequent selection
                }

                public String getDescription() {
                    return "Your species evolved eating Fresh Meat. No, fresher than that. No, fresher than that" +
                            ". You can use an action to use your natural weapon to attempt to paralyse a prospective meal, they must make a toughness save, and upon failure" +
                            "are paralysed for 1 turn, taking this numerous times can increase this to 1d4, 6, and so on, creatures immune to Paralysis instead take double damage.";

                }

                public static class Engulf extends RaceTrait {
                    @Override
                    public void applyEffect(PlayerCharacter playerCharacter) {
                        /// Add Engulf as a special natural attack, probably natural weapon added to inventory named "Engulfer" or something
                        /// Automatically hit the engulfed target with natural attacks on subsequent turns
                        /// Attacks directed at the engulfed target also hit the engulfing character
                        /// Define escape conditions and initial resistance check later
                    }

                    public String getDescription() {
                        return "Okay, so, right, billions of years of evolution, but what, really, did the Amoeba's get wrong? Exactly?" +
                                " You gain a natural weapon to engulf an opponent, automatically hitting them with your natural attacks each subsequent turn." +
                                " Any attacks that hit the engulfed opponent also hit you." +
                                "While in this state, you may only attack your engulfed foe, or attatch to another.";
                    }
                }

                public static class Fruiting extends RaceTrait {
                    @Override
                    public void applyEffect(PlayerCharacter playerCharacter) {
                        /// Allow the player to produce consumable healing items
                        /// Determine the cost, frequency and potency of fruit production
                        /// Potentially increase production when taken multiple times
                    }

                    public String getDescription() {
                        return "Look, is it technically cannabalism, sure, but it is delicious, and besides, you're trying to be nice, god, some people, huh." +
                                "Besides, they're going to be shitting your seeds, it's literally, win-win." +
                                " You can produce fruit from your own body, which can be consumed by yourself or other party members to restore HP.";

                    }
                }

                public static class Shapeshifting extends RaceTrait {
                    @Override
                    public void applyEffect(PlayerCharacter playerCharacter) {
                        ///Gain Limited ShapeShifting
                    }

                    public String getDescription() {
                        return "The Firmness of Your Form is frequently in flux. You retain a general body shape, but can shapeshift as to fit into difficult to reach areas.";

                    }
                }


                public static class TrueShapeshifting extends RaceTrait {
                    @Override
                    public void applyEffect(PlayerCharacter playerCharacter) {
                        ///Does nothing when selected.
                    }

                    public String getDescription() {
                        return "You have no face, but the mask." +
                                "You have no form, but the mould." +
                                "You could get up tommorrow, and walk away, become someone new, and nobody would ever know." +
                                "Nobody even knows if you're real." +
                                "Players cannot take this Racial Trait." +
                                "But who knows if they are out there. and if they are, who they are pretending to be." +
                                "Maybe you were? If you have, you have forgotten, perhaps one morning, That Thing took you, and now pilots a Ship of Thesus Burned";

                    }
                }
            }


            // Add other traits as needed

        }
    }
}