# Word Finder
## Utility Component :wrench:
* Enter in any string with alphanumeric characters
* Generate words that have a relationship to the entered string (there are three possible relationships programmed for)
* Words with a relationship are structured in an array
* Filter (manipulate) array by removing components that have or don't have a specific combination of characters (user-chosen)
* Sort resulting array by length of word or word value in popular tile-based multiplayer crossword games
* View results and / or search through results with user-defind parameters
## Game Component :game_die:
* Enter in any string with alphanumeric characters
* Generate words that have a relationship to the entered string (there are three possible relationships programmed for)
* User guesses as many possible relationships as possible
* User-generated results compared witht the actual total number of relationships. Show all relationships missed by the user
## Other Information
* 
## How to Use :computer:
#### Bash
```bash
$ git clone https://www.github.com/eankeen/word-finder
$ cd ./word-finder
$ ./run.sh
```
#### Powershell / Cmd
```bash
$ git clone https://www.github.com/eankeen/word-finder
$ cd ./word-finder/src
$ javac *.java
$ cd ..
$ java src.Control
```
### About the Shell Script
* `./run.sh -rem` removes all .class files from src directory if at least one is present
* `./run.sh -com` compiles all .class files in the src directory, if all .class files are present. If not, will alert user that not all .class files are present
*  `./run.sh -run` runs the program
* `./run.sh` performs all of the above operations, in order
