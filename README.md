## Super Mario Bros - University Project  

### Overview  
This project is a recreation of the classic *Super Mario Bros* game, developed as part of a university assignment by a team of five students. It encompasses the entire development process, from problem modeling using UML diagrams (reduced, extended, and sequence diagrams) to abstraction of entities and implementation of the game in Java.  

The final product is a playable game featuring two distinct modes:  
1. **Original Mode** - Faithful to the classic *Super Mario Bros* gameplay.  
2. **Alternative Mode** - Inspired by the aesthetic and gameplay elements of *DOOM*.  

### Features  
- **Persistent Ranking System**: Scores are saved and managed using Java's `Serializable` class.  
- **Menu Navigation**: Navigate through the menu with the `W` (up) and `S` (down) keys. Select an option by pressing `Enter`.  
- **Player Mechanics**:  
  - The player starts with 3 lives.  
  - Movement:  
    - `W`: Move up.  
    - `A`: Move left.  
    - `D`: Move right.  
  - *Pipes are not accessible.*  
- **Endgame Process**:  
  - At the end of the game, players are prompted to enter their name for the ranking. Names can be up to 4 characters long, and the player must press `Enter` to submit.  
  - After submitting, a game-over screen appears. Press `Enter` to return to the main menu, where you can choose to play again or exit the game.  
- **Simplified Enemy Behaviors**: Certain enemy functionalities have been modified for the sake of simplicity.  

### Controls  
- **In Menu**:  
  - `W` - Move up.  
  - `S` - Move down.  
  - `Enter` - Select option.  
- **In Game**:  
  - `W` - Jump/move up.  
  - `A` - Move left.  
  - `D` - Move right.  

### Known Issues  
- **Bugs with Lakitu**: Some bugs caused by Lakitu have been identified but have not yet been resolved due to time constraints.  
- **Background Contrast Issue**: The final background in the game has poor contrast with the *Buzzy Beetle* enemies, making them harder to see.  

### How to Play  
1. Start the game and navigate the menu using the keys specified above.  
2. Select a game mode and begin playing.  
3. Complete levels, avoid obstacles, and collect points.  
4. When all lives are lost, enter your name for the ranking (max 4 characters).  
5. Decide whether to play again or exit.  

### Team Contributions  
This project was completed collaboratively by a team of five university students. Each team member contributed to different aspects, including UML modeling, coding, and gameplay design.  

### Closing Remarks  
We hope you enjoy this reimagined version of *Super Mario Bros* with its unique blend of classic and DOOM-inspired gameplay. While there are known issues, we believe the game offers an engaging and enjoyable experience. Feedback is welcome as we continue refining our skills and projects!  
