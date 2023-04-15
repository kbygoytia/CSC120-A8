Use this file to record your reflection on this assignment.
Worked with Julie Altamirano and Taylor Knibb

- Tell me about your class! What does it represent?
Our class is an alien that a user creates which has the ability to fly, hold things, walk, examine items, undo motions, has a height, energy level, resting ability, use things is has, drop things it has, check if it has space to hold more things and moves to a direction. It is able to move around a grid that has a space of 100 to the north -100 to the south, 100 to the east and -100 to the west. The alien is very dependent on it's energy level as each action depletes it's energy by 20 so uders need to make the alien rest which will gain it +10 energy. There are certain things that the alien is not able to undo such as use and examine because there are not unuse or unexamine methods. 

- What additional methods (if any) did you implement alongside those listed in the interface?
We added the flyTo method whick actually allows the user's alien to fly to a specific coordinate pair while fly was just the checker to see if it even could go to a certain area. We also had last_action that allowed the program to have a record of what the user last did in order to be able to undo it and gain energyy back after the undo (if it is even possible).

- What worked, what didn't, what advice would you give someone taking this course in the future?
What worked was storing a strign in the last_action method at the end of each action method so that a record is kept of what the alien had done. I would advise students to think in a more abstract way because originally we were actually going to make a 2D plain and give each plain range a specific name like North, South, East, West so that the alien could touch the tile and be told where it is. But that was a bit accessive and confusing we we had to think on a less literal level.