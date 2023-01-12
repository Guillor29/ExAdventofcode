package Day;

//import Case;
//import Monkey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day12 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("src/Source/input121.txt"));
        Map<String, Case> mapCase = new HashMap<String, Case>();


        int i = 0;
        String arrive = "";
        int min = Integer.MAX_VALUE;
        LinkedList<Case> testCaseInit = null;
        List<LinkedList<Case>> departCase = new ArrayList<>();
        LinkedList<Case> cheminCourt;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            for (int j = 0; j < line.length(); j++) {
                String charr = String.valueOf(line.charAt(j));
                if (charr.equals("S") || charr.equals("a")) {
                    Case maCase = new Case();
                    maCase.Valeur = "a";
                    maCase.Poids = 0;
                    maCase.Coordonnee = i + "," + j;
                    testCaseInit = new LinkedList<>();
                    testCaseInit.add(maCase);
                    departCase.add(testCaseInit);
                    mapCase.put(i + "," + j,maCase);
                } else if (charr.equals("E")) {
                    arrive = i + "," + j;
                    Case maCase = new Case();
                    maCase.Valeur = "z";
                    maCase.Poids = Integer.MAX_VALUE;
                    maCase.Coordonnee = arrive;
                    mapCase.put(i + "," + j,maCase);
                } else {
                    Case maCase = new Case();
                    maCase.Valeur = charr;
                    maCase.Poids = Integer.MAX_VALUE;
                    maCase.Coordonnee = i + "," + j;
                    mapCase.put(i + "," + j,maCase);
                }
            }
            i++;
        }

        for(LinkedList<Case> testCase : departCase) {
            while (testCase.size() > 0) {
                cheminCourt = testCase;
                testCase = new LinkedList<>();
                for (Case caseEnCours : cheminCourt) {
                    int x = Integer.valueOf(caseEnCours.Coordonnee.split(",")[0]);
                    int y = Integer.valueOf(caseEnCours.Coordonnee.split(",")[1]);

                    //haut
                    String direction = (x - 1) + "," + y;
                    testCase(mapCase,caseEnCours,direction,testCase,arrive);

                    //bas
                    direction = (x + 1) + "," + y;
                    testCase(mapCase,caseEnCours,direction,testCase,arrive);

                    //gauche
                    direction = x + "," + (y - 1);
                    testCase(mapCase,caseEnCours,direction,testCase,arrive);

                    //droite
                    direction = x + "," + (y + 1);
                    testCase(mapCase,caseEnCours,direction,testCase,arrive);

                }
            }
            if(mapCase.get(arrive).Poids < min){
                min = mapCase.get(arrive).Poids;
            }
        }
        System.out.println(min);
    }

    private static void testCase(Map<String, Case> mapCase, Case caseEnCours, String direction, LinkedList<Case> testCase,String arrive) {
        if (mapCase.get(direction) != null && mapCase.get(direction).Valeur.charAt(0) - caseEnCours.Valeur.charAt(0) < 2) {
            if (mapCase.get(direction).Poids > caseEnCours.Poids + 1) {
                mapCase.get(direction).Poids = caseEnCours.Poids + 1;
                if (!direction.equals(arrive)) {
                    testCase.add(mapCase.get(direction));
                }
            }
        }
    }
}