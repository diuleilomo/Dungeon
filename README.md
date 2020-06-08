### Dungeon layout

To be specific, the layout of each dungeon is defined by a grid of squares, each of which may contain one or more entities. The different types of entities are as follows:

| Entity               | Example | Description                             |
| ------               | ------- | --------------------------------------- |
| Player               | ![Player][player] | The player can be moved either up, down, left, or right into adjacent squares, as long as another entity does not stop them (e.g. a wall). |
| Wall                 | ![Wall][wall] | Blocks the movement of the player, enemies, boulders and arrows. |
| Exit                 | ![Exit][exit] | If the player goes through an exit the puzzle is complete.  |
| Treasure             | ![Treasure][treasure] | Can be collected by the player. |
| Door                 | ![Door][door_open] ![Door][door_closed] | Exists in conjunction with a single key that can open it. If the player holds the key, they can open the door by moving through it. After opening it remains open. The client will be satisfied if dungeons can be made with up to 3 doors. |
| Key                  | ![Key][key] | Can be picked up by the player when they move into the containing square. The player can carry only one key at a time, and only one door has a lock that fits the key. The key disappears once it is used to open its corresponding door. |
| Boulder              | ![Boulder][boulder] | Acts like a wall in most cases. The only differences are that it can be pushed by the player into adjacent squares and can be destroyed by a bomb. The player is only strong enough to push **one** boulder at a time. |
| Floor switch         | ![Floor switch][switch] | Switches behave like empty squares so other entities can appear on top of them. When a boulder is pushed onto a floor switch, it is triggered. Pushing a boulder off the floor switch untriggers it. |
| Unlit bomb           | ![Unlit bomb][bomb_unlit] | The bomb is picked up by the player when they move into the square containing it. |
| Lit bomb             | ![Lit bomb][bomb_lit_1] ![Lit bomb][bomb_lit_2] ![Lit bomb][bomb_lit_3] ![Lit bomb][bomb_lit_4] | The player can light the bombs they have collected and drop them. The fuse burns down for a short fixed period of time before the bomb explodes. Upon explosion, any boulders or enemies in the squares immediately to the left, right, above or below are destroyed. If the player is in one of these squares they die. |
| Enemy                | ![Enemy][enemy] | Constantly moves toward the player, stopping if it cannot move any closer. The player dies upon collision with an enemy. |
| Sword                | ![Sword][sword] | This can be picked up the player and used to kill enemies. Only one sword can be carried at once. Each sword is only capable of 5 hits and disappears after that. One hit of the sword is sufficient to destroy any enemy. |
| Invincibility potion | ![Invincibility][invincibility] | If the player picks this up they become invincible to all bombs and enemies. Colliding with an enemy should result in their immediate destruction. Because of this, all enemies will run away from the player when they are invincible. The effect of the potion only lasts a limited time. |

### Goals

In addition to its layout, each dungeon also has a goal that defines what must be achieved by the player for the dungeon to be considered complete. Basic goals are:

* Getting to an exit.
* Destroying all enemies.
* Having a boulder on all floor switches.
* Collecting all treasure.

More complex goals can be built by logically composing basic goals. For example,

* Destroying all enemies AND getting to an exit
* Collecting all treasure OR having a boulder on all floor switches
* Getting to an exit AND (destroying all enemies OR collecting all treasure)

If getting to an exit is one of a conjunction of conditions, it must be done last. For example, if the condition is to destroy all enemies AND get to an exit, the player must destroy the enemies *then* get to the exit.


[player]:        images/human_new.png
[wall]:          images/brick_brown_0.png
[exit]:          images/exit.png
[door_open]:     images/open_door.png
[door_closed]:   images/closed_door.png
[key]:           images/key.png
[boulder]:       images/boulder.png
[switch]:        images/pressure_plate.png
[bomb_unlit]:    images/bomb_unlit.png
[bomb_lit_1]:    images/bomb_lit_1.png
[bomb_lit_2]:    images/bomb_lit_2.png
[bomb_lit_3]:    images/bomb_lit_3.png
[bomb_lit_4]:    images/bomb_lit_4.png
[enemy]:        images/deep_elf_master_archer.png
[sword]:         images/greatsword_1_new.png
[invincibility]: images/brilliant_blue_new.png
[treasure]:      images/gold_pile.png

[maze]:          examples/maze.png
[boulders]:      examples/boulders.png
[advanced]:      examples/advanced.png
