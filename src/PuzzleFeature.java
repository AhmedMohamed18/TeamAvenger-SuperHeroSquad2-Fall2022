import java.util.Scanner;

public class PuzzleFeature {
    public static void showPuzzle(String command) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int attempts = 3;// number of attempts are assumed to be 3
        boolean hintWatched = false;// to make sure hint is viewed only once
        Puzzle[] puzzles = new Puzzle[8];// array to store puzzles given in the question
        // adding the puzzles given in the question
        makePuzzles(puzzles);
        System.out.println(
                "Available Commands-\n\nSolve puzzle to kill monster\nSolve puzzle to pick up item\nSolve puzzle to kill final monster\nSolve puzzle to dodge traps\nSolve puzzle for dark room\nSolve puzzle to boost health\nSolve puzzle for extra life\nEnter your command:-");

        if (command.equals("Solve puzzle to kill monster")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println(puzzles[0].getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles[0].getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles[0].getAnswer().toLowerCase())) {
                        System.out.println("Monster is killed.\n");
                        break;
                    } else {
                        attempts--;
                        System.out.println("That is incorrect. Try again. " + attempts + " attempts are remaining\n");
                        if (attempts == 0) {
                            System.out.println("Number of attempts Exhausted!\n");
                            break;
                        }
                    }
                } else {
                    System.out.println("The monster has killed you.\n");
                }
            }
        } else if (command.equals("Solve puzzle to pick up item")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles[5].getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles[5].getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles[5].getAnswer().toLowerCase())) {
                        System.out.println("You are now able to pick up item.\n");
                        break;
                    } else {
                        attempts--;
                        System.out.println("That is incorrect. Try again. " + attempts + " attempts are remaining\n");
                        if (attempts == 0) {
                            System.out.println("Number of attempts Exhausted!\n");
                            break;
                        }
                    }
                } else {
                    System.out.println("You are not allowed to pick this item up.\n");
                }
            }
        } else if (command.equals("Solve puzzle to kill final monster")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles[6].getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles[6].getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles[5].getAnswer().toLowerCase())) {
                        System.out.println("Monster is greatly damage.\n");
                        break;
                    } else {
                        attempts--;
                        System.out.println("That is incorrect. Try again. " + attempts + " attempts are remaining\n");
                        if (attempts == 0) {
                            System.out.println("Number of attempts Exhausted!\n");
                            break;
                        }
                    }
                } else {
                    System.out.println("The monster has killed you.\n");
                }
            }
        } else if (command.equals("Solve puzzle to dodge traps")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles[1].getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles[1].getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles[1].getAnswer().toLowerCase())) {
                        System.out.println("You made it pass the trap.\n");
                        break;
                    } else {
                        attempts--;
                        System.out.println("That is incorrect. Try again. " + attempts + " attempts are remaining\n");
                        if (attempts == 0) {
                            System.out.println("Number of attempts Exhausted!\n");
                            break;
                        }
                    }
                } else {
                    System.out.println("You have died by the trap.\n");
                }
            }
        } else if (command.equals("Solve puzzle for dark room")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles[7].getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles[7].getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles[7].getAnswer().toLowerCase())) {
                        System.out.println("Light is on.\n");
                        break;
                    } else {
                        attempts--;
                        System.out.println("That is incorrect. Try again. " + attempts + " attempts are remaining\n");
                        if (attempts == 0) {
                            System.out.println("Number of attempts Exhausted!\n");
                            break;
                        }
                    }
                } else {
                    System.out.println("Can't go inside. Room is dark.\n");
                }
            }
        } else if (command.equals("Solve puzzle to boost health")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles[2].getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles[2].getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles[2].getAnswer().toLowerCase())) {
                        System.out.println("You get a boost in health points.\n");
                        break;
                    } else {
                        attempts--;
                        System.out.println("That is incorrect. Try again. " + attempts + " attempts are remaining\n");
                        if (attempts == 0) {
                            System.out.println("Number of attempts Exhausted!\n");
                            break;
                        }
                    }
                } else {
                    System.out.println("You get nothing.\n");
                }
            }
        } else if (command.equals("Solve puzzle for extra life")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles[3].getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles[3].getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles[3].getAnswer().toLowerCase())) {
                        System.out.println("You get an extra life.\n");
                        break;
                    } else {
                        attempts--;
                        System.out.println("That is incorrect. Try again. " + attempts + " attempts are remaining\n");
                        if (attempts == 0) {
                            System.out.println("Number of attempts Exhausted!\n");
                            break;
                        }
                    }
                } else {
                    System.out.println("You have lost a life.\n");
                }
            }
        } else {
            System.out.println("Invalid Command!\n");
        }

    }

    static void makePuzzles(Puzzle[] puzzles) {
        puzzles[0] = new Puzzle(1, "What has a head and a tail but no body?", "Coin", "We use it as money", 5, "Easy");
        puzzles[1] = new Puzzle(2, "What word of five letters has one left when two are removed?", "Stone",
                "Made castles strong", 18, "Medium");
        puzzles[2] = new Puzzle(3,
                "I follow you all the time and copy your every move, but you can’t touch me or catch me. What am I?",
                "Shadow", "You can see it when the sun comes out", 7, "Easy");
        puzzles[3] = new Puzzle(4,
                "I turn once, what is out will not get in. I turn again, what is in will not get out. What am I?",
                "Key", "It open things", 13, "Medium");
        puzzles[4] = new Puzzle(5,
                "I am always hungry and will die if not fed, but whatever I touch will soon turn red. What am I?",
                "Fire", "It can warm things", 9, "Medium");
        puzzles[5] = new Puzzle(6, "What is so fragile that saying its name breaks it?", "Silence",
                "Librarians love this setting", 17, "Medium");
        puzzles[6] = new Puzzle(7,
                "A girl has as many brothers as sisters, but each brother has only half as many brothers as sisters. How many brothers and sisters are there in the family?",
                "Four sisters and three brothers", "There are 7 siblings", 20, "Hard");
        puzzles[7] = new Puzzle(8, "What breaks yet never falls, and what falls yet never breaks?", "Day and Night",
                "You can see the sun and stars", 11, "Hard");
    }
}
