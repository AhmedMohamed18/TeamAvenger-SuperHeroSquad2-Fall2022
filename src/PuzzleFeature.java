import java.util.List;
import java.util.Scanner;
import java.io.File;
/*
 * @author of Class: Cameron Lake
 *
 * */
public class PuzzleFeature {
    List<Puzzle> puzzles;// array to store puzzles given in the question

    public  PuzzleFeature(List<Puzzle> puzzles){
        this.puzzles=puzzles;
    }
    public void showPuzzle(String command) {
        // scanner class to read inputs that may contain spaces
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int attempts = 3;// number of attempts are assumed to be 3
        boolean hintWatched = false;// to insecure hint is viewed only once

        // adding the puzzles given in the question
//        readPuzzles(puzzles);
        // showing available command
//        System.out.println(
//                "Available Commands-\n\nSolve puzzle to kill monster\nSolve puzzle to pick up item\nSolve puzzle to kill final monster\nSolve puzzle to dodge traps\nSolve puzzle for dark room\nSolve puzzle to boost health\nSolve puzzle for extra life\nEnter your command:-");
        if (command.equals("Solve puzzle to kill monster")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println(puzzles.get(0).getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles.get(0).getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles.get(0).getAnswer().toLowerCase())) {
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
        }

        else if (command.equals("Solve puzzle to pick up item")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles.get(5).getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles.get(5).getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles.get(5).getAnswer().toLowerCase())) {
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
        }

        else if (command.equals("Solve puzzle to kill final monster")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles.get(6).getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles.get(6).getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles.get(6).getAnswer().toLowerCase())) {
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
        }

        else if (command.equals("Solve puzzle to dodge arrow trap")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles.get(1).getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles.get(1).getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles.get(1).getAnswer().toLowerCase())) {
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
                    System.out.println("You have died by the arrow trap.\n");
                }
            }
        }

        else if (command.equals("Solve puzzle to dodge fire trap")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles.get(4).getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles.get(4).getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles.get(4).getAnswer().toLowerCase())) {
                        System.out.println("You made it pass the fire trap.\n");
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
        }

        else if (command.equals("Solve puzzle for dark room")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles.get(7).getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles.get(7).getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles.get(7).getAnswer().toLowerCase())) {
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
        }

        else if (command.equals("Solve puzzle to boost health")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles.get(2).getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles.get(2).getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles.get(2).getAnswer().toLowerCase())) {
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
        }

        else if (command.equals("Solve puzzle for extra life")) {
            while (true) {
                System.out.println(
                        "Enter Command:\nInspect puzzle : To see the riddle description\nAsk for Hint : To ask for a hint (only once)\nSolve puzzle : To answer the puzzle\nNOTE: any other command will end the puzzle\n");
                String puzzleCommand = sc.nextLine().toLowerCase();
                if (puzzleCommand.equals("inspect puzzle")) {
                    System.out.println("Description: " + puzzles.get(3).getDescription() + "\n");
                } else if (puzzleCommand.equals("ask for hint")) {
                    if (hintWatched) {
                        System.out.println("You already watched hint once!\n");
                    } else {
                        System.out.println("Hint: " + puzzles.get(3).getHint() + "\n");
                        hintWatched = true;
                    }
                } else if (puzzleCommand.equals("solve puzzle")) {
                    System.out.print("Your Answer: ");
                    String userAnswer = sc.nextLine().toLowerCase();
                    if (userAnswer.equals(puzzles.get(3).getAnswer().toLowerCase())) {
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
        }

        else {
            System.out.println("Invalid Command!\n");
        }

    }

 static void readPuzzles(List<Puzzle> puzzles) {
    try {
        File myFile = new File("DataFiles/puzzle.txt");
         Scanner input = new Scanner(myFile);
            while (input.hasNext()) {
                int roomId = Integer.parseInt(input.nextLine());
                String puzzleQue = input.nextLine();
                String puzzleAns = input.nextLine();
                String puzzleHint = input.nextLine();
                int room = Integer.parseInt(input.nextLine());
               String difficulty = input.nextLine();
                Puzzle puzzle = new Puzzle(roomId, puzzleQue, puzzleAns, puzzleHint, room, difficulty);
               puzzles.add(puzzle);
           }
        } catch (Exception e) {
            System.err.println(e);
        }

   }
}
