package Logic;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cocau
 */
public class Logic {

    private ArrayList<ComponentInterface> listHexagonsJ1;
    private ArrayList<ComponentInterface> listHexagonsJ2;
    private ArrayList<ComponentInterface> listHexagonsEspecialesJ1;
    private ArrayList<ComponentInterface> listHexagonsEspecialesJ2;

    public Logic() {
        listHexagonsJ1 = new ArrayList<>();
        listHexagonsJ2 = new ArrayList<>();
        listHexagonsEspecialesJ1 = new ArrayList<>();
        listHexagonsEspecialesJ2 = new ArrayList<>();
    }

    public void addHexagonTreeJ1(ComponentInterface hexagon) {

        listHexagonsJ1.add(hexagon);
    }

    public void verificationPredecessorJ1(ComponentInterface hegagonV) {

        Hexagon hexagonActual = null;
        Hexagon hexagonVerification = (Hexagon) hegagonV;

        for (int i = 0; i < listHexagonsJ1.size(); i++) {

            hexagonActual = (Hexagon) listHexagonsJ1.get(i);

            if (hexagonActual.getPlayer() == hexagonVerification.getPlayer()) {

                if ((hexagonActual.getLocation().getX() + 1) == (hexagonVerification.getLocation().getX())) {

                    if ((hexagonActual.getLocation().getY() - 1) == (hexagonVerification.getLocation().getY())) {

                        hexagonActual.addHexagonDescendant(hegagonV);
                        if (!hexagonActual.isHexEspeciales() && !hexagonActual.isHasPredecessor()) {

                            hexagonActual.setHexEspeciales(true);
                            listHexagonsEspecialesJ1.add(hexagonActual);
                        }
                    } else if ((hexagonActual.getLocation().getY()) == (hexagonVerification.getLocation().getY())) {

                        hexagonActual.addHexagonDescendant(hegagonV);
                        if (!hexagonActual.isHexEspeciales() && !hexagonActual.isHasPredecessor()) {

                            hexagonActual.setHexEspeciales(true);
                            listHexagonsEspecialesJ1.add(hexagonActual);
                        }
                    }

                } else if (hexagonActual.getLocation().getX() == hexagonVerification.getLocation().getX()) {

                    if ((hexagonActual.getLocation().getY() - 1) == (hexagonVerification.getLocation().getY())) {

                        hexagonActual.addHexagonDescendant(hegagonV);

                        if (!hexagonActual.isHexEspeciales() && !hexagonActual.isHasPredecessor()) {

                            hexagonActual.setHexEspeciales(true);
                            listHexagonsEspecialesJ1.add(hexagonActual);
                        }

                    } else if ((hexagonActual.getLocation().getY() + 1) == (hexagonVerification.getLocation().getY())) {

                        hexagonActual.addHexagonDescendant(hegagonV);

                        if (!hexagonActual.isHexEspeciales() && !hexagonActual.isHasPredecessor()) {

                            hexagonActual.setHexEspeciales(true);
                            listHexagonsEspecialesJ1.add(hexagonActual);
                        }

                    }

                } else if ((hexagonActual.getLocation().getX() - 1) == (hexagonVerification.getLocation().getX())) {

                    if ((hexagonActual.getLocation().getY() + 1) == (hexagonVerification.getLocation().getY())) {

                        if (listHexagonsEspecialesJ1.contains(hexagonActual)) {

                            listHexagonsEspecialesJ1.remove(hexagonActual);
                        }

                        hexagonVerification.addHexagonDescendant(hexagonActual);

                        if (!hexagonVerification.isHexEspeciales() && !hexagonVerification.isHasPredecessor()) {

                            hexagonVerification.setHexEspeciales(true);
                            listHexagonsEspecialesJ1.add(hexagonVerification);
                        }

                    } else if ((hexagonActual.getLocation().getY()) == (hexagonVerification.getLocation().getY())) {

                        if (listHexagonsEspecialesJ1.contains(hexagonActual)) {

                            listHexagonsEspecialesJ1.remove(hexagonActual);
                        }

                        hexagonVerification.addHexagonDescendant(hexagonActual);
                        if (!hexagonVerification.isHexEspeciales() && !hexagonVerification.isHasPredecessor()) {

                            hexagonVerification.setHexEspeciales(true);
                            listHexagonsEspecialesJ1.add(hexagonVerification);
                        }

                    }

                }
            }

        }

        verifyWinPlayer1();
    }

    
    public void verificationPredecessorJ2(ComponentInterface hegagonV) {

        Hexagon hexagonActual = null;
        Hexagon hexagonVerification = (Hexagon) hegagonV;

        for (int i = 0; i < listHexagonsJ2.size(); i++) {

            hexagonActual = (Hexagon) listHexagonsJ2.get(i);

            if (hexagonActual.getPlayer() == hexagonVerification.getPlayer() && hexagonActual.getPlayer() == 1) {

                if ((hexagonActual.getLocation().getX() + 1) == (hexagonVerification.getLocation().getX())) {

                    if ((hexagonActual.getLocation().getY() - 1) == (hexagonVerification.getLocation().getY())) {

                        hexagonActual.addHexagonDescendant(hegagonV);
                        if (!hexagonActual.isHexEspeciales() && !hexagonActual.isHasPredecessor()) {

                            hexagonActual.setHexEspeciales(true);
                            listHexagonsEspecialesJ2.add(hexagonActual);
                        }
                    } else if ((hexagonActual.getLocation().getY()) == (hexagonVerification.getLocation().getY())) {

                        hexagonActual.addHexagonDescendant(hegagonV);
                        if (!hexagonActual.isHexEspeciales() && !hexagonActual.isHasPredecessor()) {

                            hexagonActual.setHexEspeciales(true);
                            listHexagonsEspecialesJ2.add(hexagonActual);
                        }
                    }

                } else if (hexagonActual.getLocation().getX() == hexagonVerification.getLocation().getX()) {

                    if ((hexagonActual.getLocation().getY() - 1) == (hexagonVerification.getLocation().getY())) {

                        hexagonActual.addHexagonDescendant(hegagonV);

                        if (!hexagonActual.isHexEspeciales() && !hexagonActual.isHasPredecessor()) {

                            hexagonActual.setHexEspeciales(true);
                            listHexagonsEspecialesJ2.add(hexagonActual);
                        }

                    } else if ((hexagonActual.getLocation().getY() + 1) == (hexagonVerification.getLocation().getY())) {

                        hexagonActual.addHexagonDescendant(hegagonV);

                        if (!hexagonActual.isHexEspeciales() && !hexagonActual.isHasPredecessor()) {

                            hexagonActual.setHexEspeciales(true);
                            listHexagonsEspecialesJ2.add(hexagonActual);
                        }

                    }

                } else if ((hexagonActual.getLocation().getX() - 1) == (hexagonVerification.getLocation().getX())) {

                    if ((hexagonActual.getLocation().getY() + 1) == (hexagonVerification.getLocation().getY())) {

                        if (listHexagonsEspecialesJ2.contains(hexagonActual)) {

                            listHexagonsEspecialesJ2.remove(hexagonActual);
                        }

                        hexagonVerification.addHexagonDescendant(hexagonActual);

                        if (!hexagonVerification.isHexEspeciales() && !hexagonVerification.isHasPredecessor()) {

                            hexagonVerification.setHexEspeciales(true);
                            listHexagonsEspecialesJ2.add(hexagonVerification);
                        }

                    } else if ((hexagonActual.getLocation().getY()) == (hexagonVerification.getLocation().getY())) {

                        if (listHexagonsEspecialesJ2.contains(hexagonActual)) {

                            listHexagonsEspecialesJ2.remove(hexagonActual);
                        }

                        hexagonVerification.addHexagonDescendant(hexagonActual);
                        if (!hexagonVerification.isHexEspeciales() && !hexagonVerification.isHasPredecessor()) {

                            hexagonVerification.setHexEspeciales(true);
                            listHexagonsEspecialesJ2.add(hexagonVerification);
                        }

                    }

                }
            }

        }

        //verifyWinPlayer2();
    }

    public void verifyWinPlayer1() {

        String infoPredecessor = "";
        Hexagon hexagonActual = null;

        for (int j = 0; j < listHexagonsEspecialesJ1.size(); j++) {

            hexagonActual = (Hexagon) listHexagonsEspecialesJ1.get(j);

            if (hexagonActual.isHasPredecessor()) {

                listHexagonsEspecialesJ1.remove(hexagonActual);
                System.out.println("Entro a eliminar");
            }
        }

        for (int k = 0; k < listHexagonsEspecialesJ1.size(); k++) {

            hexagonActual = (Hexagon) listHexagonsEspecialesJ1.get(k);

            infoPredecessor += hexagonActual.listLocationX();
        }

        String vec[] = infoPredecessor.split(",");
        int indice = 0;
        String indiceString = "";
        boolean cumple = true;
        boolean verificationWin = false;

        while (cumple) {

            cumple = false;
            indiceString = indice + "";
            for (int i = 0; i < vec.length; i++) {

                //JOptionPane.showMessageDialog(null, vec[i] + "==" + indiceString);
                if (vec[i].equals(indiceString)) {
                    cumple = true;
                    i = vec.length;

                    if (indice == 6) {

                        verificationWin = true;
                        cumple = false;
                    }
                }

            }
            indice++;
        }

        if (verificationWin) {

            JOptionPane.showMessageDialog(null, "Gano el rojo");
        }

    }
    
//    public void verifyWinPlayer2() {
//
//        String infoPredecessor = "";
//        Hexagon hexagonActual = null;
//
//        for (int j = 0; j < listHexagonsEspecialesJ2.size(); j++) {
//
//            hexagonActual = (Hexagon) listHexagonsEspecialesJ2.get(j);
//
//            if (hexagonActual.isHasPredecessor()) {
//
//                listHexagonsEspecialesJ2.remove(hexagonActual);
//                System.out.println("Entro a eliminar");
//            }
//        }
//
//        for (int k = 0; k < listHexagonsEspecialesJ2.size(); k++) {
//
//            hexagonActual = (Hexagon) listHexagonsEspecialesJ2.get(k);
//
//            infoPredecessor += hexagonActual.listLocationX();
//        }
//
//        String vec[] = infoPredecessor.split(",");
//        int indice = 0;
//        String indiceString = "";
//        boolean cumple = true;
//        boolean verificationWin = false;
//
//        while (cumple) {
//
//            cumple = false;
//            indiceString = indice + "";
//            for (int i = 0; i < vec.length; i++) {
//
//                JOptionPane.showMessageDialog(null, vec[i] + "==" + indiceString);
//                if (vec[i].equals(indiceString)) {
//                    cumple = true;
//                    i = vec.length;
//
//                    if (indice == 6) {
//
//                        verificationWin = true;
//                        cumple = false;
//                    }
//                }
//
//            }
//            indice++;
//        }
//
//        if (verificationWin) {
//
//            JOptionPane.showMessageDialog(null, "Gano el rojo");
//        }
//
//    }

}
