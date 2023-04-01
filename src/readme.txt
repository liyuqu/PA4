# CS611-<Assignment 3>
## <Legend_Hero_Monster>
---------------------------------------------------------------------------
<Liyu Qu>
<liyuqu@bu.edu>
<U47658884>

## Files
---------------------------------------------------------------------------
<A brief description of each file and what it does>
I designed a read text class called ReadTxt to read those txt file, and according to the txt file I create HeroList, MonsterList, PotionList, WeaponList, ArmoryList, and SpellList to read through all the txt file and gather the data together so I can get all heroes, monsters, potions, weapons, armories, and spells. A main class is designed to create the initial project. Game class provides the selection for games, although for now there is only one game, there should be more in the future, so I use the option part as well as GameOperation--operation for all the games, and use inherience class to make specific move/game info (Like LMHGameOperation I specify the movement, map building details like the size and how much area for each type, and the speical movement on the map). I also create a Rule class for the rule like checking status of monsters/heroes or update hero's attribute each round. There is also Market, submarket, and deal for market and dealing part. Map, Content, ContentType works for the map built and enum ContentType decides whether the cell(content) is a Hero, market, random, or inaccessible. For the Battle Part, I create three class: Battle, MonsterAttack, and HeroAttack. Battle can check if we encounter monsters and start the play, and MonsterAttack HeroAttack means performing attack for them. Also, Monster and Hero class are also created to get their attribute and update status. They are inherited from Status, which is specified for creatures, and Status inherited from Entity, which is parent class of Equipment--parent of Weapon, Armory, Potion, and Spell(these four are created to maintain their data and get data). Inventory also exists for the Hero's bag. Enum (GameType, HeroType, PotionType, SpellType, MonsterType) is created for easily building the other classes.
Also, a Sound class is built for the sound.
## Notes
---------------------------------------------------------------------------
1. <Files to be parsed should be stored in ConfigFiles, for parser class to
read class>
2. <Bonus Done>
1.Can see Player info during battle
2.Add Color to Hero, Market, and Inaccessible area.
3.Can quit game while playing
4.Enable sounds while encounter a battle, hero cast spell/attack/potion, monster attack, and win a battle. (Save in ./src/resources)
5.Enable dual weapon, if you are dual, you can choose which weapon to use while attacking.
6.Can equip items while at the moving part(open info and then press e)
7.Can replay after be defeated, I give two ways--first is to get the status at the beginning of the battle and have battle with same monsters,
and second is to cheat(get full status back and fight with them). 
8.Add quit method on th map by press q.
9.Can go back to select action part after wrongly choosing attack, use spell, or potion. 
10. Add kindly arranged UI for hero, monster, and items.
3. <Notes to grader>
It needs to add dependency for the sound since I use mp3 file.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "RpgGame" after unzipping the files
2. Run the following instructions:
<Example below>
javac -source 1.8 -d bin -target 1.8 src\*.java
java -cp bin Main

## Input/Output Example
---------------------------------------------------------------------------
<Place here an example of how the program runs. Include both its
outputs and correctly formatted inputs. Please clearly mark the inputs.>

Example:







Welcome to Game World!
Here is the list of games you can play, press thenumber to play it!
1. Legends_Monsters_Heroes
0. Quit the Game
input: 1
Welcome to Legends_Monster_Heroes!
------------------------------------------------------------------------  HEROES  ------------------------------------------------------------------------
Number              Name                     mana            strength           agility             dexterity                gold              level
0		            Parzival                 300                 750                 650                 700                2500                   7
1		    Sehanine_Moonbow                 300                 750                 700                 700                2500                   7
2		 Skoraeus_Stonebones                 250                 650                 600                 350                2500                   4
3		    Garl_Glittergold                 100                 600                 500                 400                2500                   5
4		     Amaryllis_Astra                 500                 500                 500                 500                2500                   5
5		       Caliber_Heist                 400                 400                 400                 400                2500                   8
6		    Gaerdal_Ironhand                 100                 700                 500                 600                1354                   7
7		    Sehanine_Monnbow                 600                 700                 800                 500                2500                   8
8		    Muamman_Duathall                 300                 900                 500                 750                2546                   6
9		   Flandal_Steelskin                 200                 750                 650                 700                2500                   7
10		      Undefeated_Yoj                 400                 800                 400                 700                2500                   7
11		          Eunoia_Cyn                 400                 700                 800                 600                2500                   6
12		 Rillifane_Rallathil                1300                 750                 450                 500                2500                   9
13		 Segojan_Earthcaller                 900                 800                 500                 650                2500                   5
14		         Reign_Havoc                 800                 800                 800                 800                2500                   8
15		      Reverie_Ashels                 900                 800                 700                 400                2500                   7
16		             Kalabar                 800                 850                 400                 600                2500                   6
17		           Skye_Soar                1000                 700                 400                 500                2500                   5
You can select 1-3 heroes to join your party! How many do you like?(enter 1/2/3)
input: 1
Ok, you select 1 heroes, please select them separately
Please select the hero to join your party!
Enter a number: 4
Congrats! you have selected 1 heroes:
Amaryllis_Astra

+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| H | $ | $ |   |   |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | X |   |   | $ |   | $ | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   |   | X | X |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | $ |   | X |   |   | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | $ |   | X | $ | $ |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   | X | $ | $ | $ | X | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| $ |   |   | X | X | $ |   | X |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | X | $ | $ |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

Legend: 
empty slot means you may randomly encounter a battle
$ means a market, it is safe and you can enter m/M to view market's items
X means the inaccessible area, you cannot walk through it

You can use the following operation guidelines to play the game.
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• Q/q: quit game
• I/i: show information
• M/m: enter market
input:d
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | H | $ |   |   |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | X |   |   | $ |   | $ | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   |   | X | X |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | $ |   | X |   |   | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | $ |   | X | $ | $ |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   | X | $ | $ | $ | X | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| $ |   |   | X | X | $ |   | X |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | X | $ | $ |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

Legend: 
empty slot means you may randomly encounter a battle
$ means a market, it is safe and you can enter m/M to view market's items
X means the inaccessible area, you cannot walk through it

You can use the following operation guidelines to play the game.
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• Q/q: quit game
• I/i: show information
• M/m: enter market
input:m
---------------------------------------------------------------  Market  ----------------------------------------------------------------
---------------------------------------------------------------  Weapons  ----------------------------------------------------------------
Number              Name                     Cost                 Require_Level                  Damage               Require Hand 
-----------------------------------------------------------------  SPELLS  ------------------------------------------------------------------------
Number              Name                   Cost                 required level             Damage             ManaCost               Type           Used Time
---------------------------------------------------------------  Armory  ----------------------------------------------------------------
Number              Name                     Cost                 Require_Level                  Damage Reduction 
0		      Guardian_Angel                1000                  10                                    1000
1		       Wizard_Shield                1200                  10                                    1500
2		     Platinum_Shield                 150                   1                                     200
---------------------------------------------------------------  Potions  ----------------------------------------------------------------
Number              Name                     Cost               Require_Level              Increase               Affected Attribute
0		      Healing_Potion                 250                   1                           100                        Health
1		       Mermaid_Tears                 850                   5                           100  Health/Mana/Strength/Agility
Do you want to buy/sell something?(y/n) Amaryllis_Astra
input:n
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | H | $ |   |   |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | X |   |   | $ |   | $ | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   |   | X | X |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | $ |   | X |   |   | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | $ |   | X | $ | $ |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   | X | $ | $ | $ | X | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| $ |   |   | X | X | $ |   | X |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | X | $ | $ |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

Legend: 
empty slot means you may randomly encounter a battle
$ means a market, it is safe and you can enter m/M to view market's items
X means the inaccessible area, you cannot walk through it

You can use the following operation guidelines to play the game.
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• Q/q: quit game
• I/i: show information
• M/m: enter market
input:d
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | H |   |   |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | X |   |   | $ |   | $ | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   |   | X | X |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | $ |   | X |   |   | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | $ |   | X | $ | $ |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   | X | $ | $ | $ | X | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| $ |   |   | X | X | $ |   | X |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | X | $ | $ |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

Legend: 
empty slot means you may randomly encounter a battle
$ means a market, it is safe and you can enter m/M to view market's items
X means the inaccessible area, you cannot walk through it

You can use the following operation guidelines to play the game.
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• Q/q: quit game
• I/i: show information
• M/m: enter market
input:m
---------------------------------------------------------------  Market  ----------------------------------------------------------------
---------------------------------------------------------------  Weapons  ----------------------------------------------------------------
Number              Name                     Cost                 Require_Level                  Damage               Require Hand 
0		                 Bow                 300                   2                                500                   2
-----------------------------------------------------------------  SPELLS  ------------------------------------------------------------------------
Number              Name                   Cost                 required level             Damage             ManaCost               Type           Used Time
0		         Snow_Cannon                 500                   2                      650                 250                 Ice                0/10
1		       Flame_Tornado                 700                   4                      850                 300                Fire                0/10
2		     Electric_Arrows                 550                   5                      650                 200           Lightning                0/10
3		        Arctic_Storm                 700                   6                      800                 300                 Ice                0/10
4		       Spark_Needles                 500                   2                      600                 200           Lightning                0/10
---------------------------------------------------------------  Armory  ----------------------------------------------------------------
Number              Name                     Cost                 Require_Level                  Damage Reduction 
0		      Guardian_Angel                1000                  10                                    1000
1		       Wizard_Shield                1200                  10                                    1500
---------------------------------------------------------------  Potions  ----------------------------------------------------------------
Number              Name                     Cost               Require_Level              Increase               Affected Attribute
Do you want to buy/sell something?(y/n) Amaryllis_Astra
input:y
Do you want to buy or sell?(b or s) Amaryllis_Astra
input:b
Please select which type of item you want to buy?(enter w for weapon, a for armory, p for potion, s for spell) Amaryllis_Astra
input:s
OK, which item would you like? (enter 0-4) for items
input:0
You buy it successfully!!!
Do you want to continue to buy or sell?(y/n) Amaryllis_Astra
input:n
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | H |   |   |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | X |   |   | $ |   | $ | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   |   | X | X |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | $ |   | X |   |   | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | $ |   | X | $ | $ |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   | X | $ | $ | $ | X | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| $ |   |   | X | X | $ |   | X |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | X | $ | $ |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

Legend: 
empty slot means you may randomly encounter a battle
$ means a market, it is safe and you can enter m/M to view market's items
X means the inaccessible area, you cannot walk through it

You can use the following operation guidelines to play the game.
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• Q/q: quit game
• I/i: show information
• M/m: enter market
input:d
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | $ | H |   |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | X |   |   | $ |   | $ | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   |   | X | X |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | $ |   | X |   |   | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | $ |   | X | $ | $ |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   | X | $ | $ | $ | X | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| $ |   |   | X | X | $ |   | X |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | X | $ | $ |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

Legend: 
empty slot means you may randomly encounter a battle
$ means a market, it is safe and you can enter m/M to view market's items
X means the inaccessible area, you cannot walk through it

#####################################
####### Wild Monsters Appear! #######
#####################################
------------------------------------------------------------------------  Monster  ------------------------------------------------------------------------
Number              Name                  Damage               Defense             DodgeChance             Type                Level              HP
0		              Casper                 255                 225                  11             Spirits                   5                 500
Do you wanna equip anything?(Armory or Weapon) Y for yes and other for no, after this we will start our battle
input:
Choose which action do you want to!
a. Attack (use your weapon)
b. Cast a Spell
c. use potions in your inventory
i. see your hero info
input: b
which monster you would like to attack
------------------------------------------------------------------------  Monster  ------------------------------------------------------------------------
Number              Name                  Damage               Defense             DodgeChance             Type                Level              HP
a              Casper                 255                 225                  11                       Spirits                   5                 500
input: a
Do you choose it wrongly? If so, you can press q to quit this func and re-choose your action, and other input means continue this action.
input: a
-----------------------------------------------------------------  SPELLS  ------------------------------------------------------------------------
Number              Name                   Cost                 required level             Damage             ManaCost               Type           Used Time
0		         Snow_Cannon                 500                   2                      650                 250                 Ice                0/10
Which spell do you wanna use? enter 0-0 to cast it
input: 0
Amaryllis_Astra use Snow_Cannon to attack Casper for 613 damage!
And Casper get fainted!
Congrats! You won the battle!
Amaryllis_Astra get 20 exp and 500 gold!

+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | $ | H |   |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | X |   |   | $ |   | $ | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   |   | X | X |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   | $ | $ |   | X |   |   | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | $ |   | X | $ | $ |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| X |   | X | $ | $ | $ | X | $ |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
| $ |   |   | X | X | $ |   | X |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
|   |   | X | $ | $ |   |   |   |
+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+

Legend: 
empty slot means you may randomly encounter a battle
$ means a market, it is safe and you can enter m/M to view market's items
X means the inaccessible area, you cannot walk through it

You can use the following operation guidelines to play the game.
• W/w: move up
• A/a: move left
• S/s: move down
• D/d: move right
• Q/q: quit game
• I/i: show information
• M/m: enter market