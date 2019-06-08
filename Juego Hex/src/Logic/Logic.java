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
    private ArrayList<ComponentInterface> listHexagonsCabezasJ1;
    private ArrayList<ComponentInterface> listHexagonsCabezasJ2;

    public Logic() {
        listHexagonsJ1 = new ArrayList<>();
        listHexagonsJ2 = new ArrayList<>();
        listHexagonsCabezasJ1 = new ArrayList<>();
        listHexagonsCabezasJ2 = new ArrayList<>();
    }

    public void addHexagonTreeJ1(ComponentInterface hexagon) {

        Hexagon hex = (Hexagon) hexagon;

        if (!hex.isHasPredecessor() && hex.getLocation().getX() != 0) {
            listHexagonsJ1.add(hexagon);
        }

    }

    public void verificationPredecessorJ1(ComponentInterface hegagonV) {

        Hexagon hexagonVerification = (Hexagon) hegagonV;
        boolean isCabeza = false;
        boolean isLegitimateSon = false;

        if (hexagonVerification.getLocation().getX() == 0) {
            listHexagonsCabezasJ1.add(hexagonVerification);
            isCabeza = true;
        }

        if (!listHexagonsCabezasJ1.isEmpty() && isCabeza == false) {

            Hexagon hexagonCabeza = null;

            for (int i = 0; i < listHexagonsCabezasJ1.size(); i++) {

                hexagonCabeza = (Hexagon) listHexagonsCabezasJ1.get(i);

                if ((hexagonCabeza.getLocation().getX() + 1) == (hexagonVerification.getLocation().getX())) {

                    if ((hexagonCabeza.getLocation().getY() - 1) == (hexagonVerification.getLocation().getY())) {

                        hexagonCabeza.addHexagonDescendant(hegagonV);
                        isLegitimateSon = true;
                    } else if ((hexagonCabeza.getLocation().getY()) == (hexagonVerification.getLocation().getY())) {

                        hexagonCabeza.addHexagonDescendant(hegagonV);
                        isLegitimateSon = true;
                    }

                }

            }

            if (!isLegitimateSon) {

                Hexagon hexagonSon = null;

                for (int j = 0; j < listHexagonsCabezasJ1.size(); j++) {

                    hexagonCabeza = (Hexagon) listHexagonsCabezasJ1.get(j);

                    for (int k = 0; k < hexagonCabeza.getListHexagons().size(); k++) {

                        hexagonSon = (Hexagon) hexagonCabeza.getListHexagons().get(k);

                        if ((hexagonSon.getLocation().getX() + 1) == (hexagonVerification.getLocation().getX())) {

                            if ((hexagonSon.getLocation().getY() - 1) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);
                            } else if ((hexagonSon.getLocation().getY()) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);
                            }

                        } else if (hexagonSon.getLocation().getX() == hexagonVerification.getLocation().getX()) {

                            if ((hexagonSon.getLocation().getY() - 1) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);

                            } else if ((hexagonSon.getLocation().getY() + 1) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);
                            }

                        } else if ((hexagonSon.getLocation().getX() - 1) == (hexagonVerification.getLocation().getX())) {

                            if ((hexagonSon.getLocation().getY() + 1) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);
                            } else if ((hexagonSon.getLocation().getY()) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);
                            }

                        }
                    }

                }

            }

        }

    }

    public void updateTree1() {

        if (!listHexagonsJ1.isEmpty()) {

            Hexagon hexagon = null;

            for (int i = 0; i < listHexagonsJ1.size(); i++) {

                hexagon = (Hexagon) listHexagonsJ1.get(i);
                verificationPredecessorJ1(hexagon);

                if (hexagon.isHasPredecessor()) {
                    listHexagonsJ1.remove(hexagon);
                }
            }

        }

    }

    public void verifyWinPlayer1() {

        updateTree1();

        String infoPredecessor = "";
        String indiceString = "";
        Hexagon hexagonActual = null;
        String vec[] = null;
        int indice = 0;
        boolean cumple = true;
        boolean verificationWin = false;

        for (int k = 0; k < listHexagonsCabezasJ1.size(); k++) {

            cumple = true;
            indice = 0;
            hexagonActual = (Hexagon) listHexagonsCabezasJ1.get(k);
            infoPredecessor = hexagonActual.listLocationX();
            vec = infoPredecessor.split(",");
            while (cumple) {

                cumple = false;
                indiceString = indice + "";
                for (int i = 0; i < vec.length; i++) {

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
                k = listHexagonsCabezasJ1.size();
            }

        }

    }

    public void addHexagonTreeJ2(ComponentInterface hexagon) {

        Hexagon hex = (Hexagon) hexagon;

        if (!hex.isHasPredecessor() && hex.getLocation().getY() != 0) {
            listHexagonsJ2.add(hexagon);
        }

    }

    public void verificationPredecessorJ2(ComponentInterface hegagonV) {

        Hexagon hexagonVerification = (Hexagon) hegagonV;
        boolean isCabeza = false;
        boolean isLegitimateSon = false;

        if (hexagonVerification.getLocation().getY() == 0) {
            listHexagonsCabezasJ2.add(hexagonVerification);
            isCabeza = true;
        }

        if (!listHexagonsCabezasJ2.isEmpty() && isCabeza == false) {

            Hexagon hexagonCabeza = null;

            for (int i = 0; i < listHexagonsCabezasJ2.size(); i++) {

                hexagonCabeza = (Hexagon) listHexagonsCabezasJ2.get(i);

                if ((hexagonCabeza.getLocation().getX() + 1) == (hexagonVerification.getLocation().getX())) {

                    if ((hexagonCabeza.getLocation().getY()) == (hexagonVerification.getLocation().getY())) {

                        hexagonCabeza.addHexagonDescendant(hegagonV);
                        isLegitimateSon = true;
                    }

                } else if (hexagonCabeza.getLocation().getX() == hexagonVerification.getLocation().getX()) {

                    if ((hexagonCabeza.getLocation().getY() + 1) == (hexagonVerification.getLocation().getY())) {

                        hexagonCabeza.addHexagonDescendant(hegagonV);
                        isLegitimateSon = true;
                    }

                } else if ((hexagonCabeza.getLocation().getX() - 1) == (hexagonVerification.getLocation().getX())) {

                    if ((hexagonCabeza.getLocation().getY() + 1) == (hexagonVerification.getLocation().getY())) {

                        hexagonCabeza.addHexagonDescendant(hegagonV);
                        isLegitimateSon = true;
                    }

                }

            }

            if (!isLegitimateSon) {

                Hexagon hexagonSon = null;

                for (int j = 0; j < listHexagonsCabezasJ2.size(); j++) {

                    hexagonCabeza = (Hexagon) listHexagonsCabezasJ2.get(j);

                    for (int k = 0; k < hexagonCabeza.getListHexagons().size(); k++) {

                        hexagonSon = (Hexagon) hexagonCabeza.getListHexagons().get(k);

                        if ((hexagonSon.getLocation().getX() + 1) == (hexagonVerification.getLocation().getX())) {

                            if ((hexagonSon.getLocation().getY() - 1) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);
                            } else if ((hexagonSon.getLocation().getY()) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);
                            }

                        } else if (hexagonSon.getLocation().getX() == hexagonVerification.getLocation().getX()) {

                            if ((hexagonSon.getLocation().getY() - 1) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);

                            } else if ((hexagonSon.getLocation().getY() + 1) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);
                            }

                        } else if ((hexagonSon.getLocation().getX() - 1) == (hexagonVerification.getLocation().getX())) {

                            if ((hexagonSon.getLocation().getY() + 1) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);
                            } else if ((hexagonSon.getLocation().getY()) == (hexagonVerification.getLocation().getY())) {

                                hexagonCabeza.addHexagonDescendant(hegagonV);
                            }

                        }
                    }

                }

            }

        }

    }

    public void updateTree2() {

        if (!listHexagonsJ2.isEmpty()) {

            Hexagon hexagon = null;

            for (int i = 0; i < listHexagonsJ2.size(); i++) {

                hexagon = (Hexagon) listHexagonsJ2.get(i);
                verificationPredecessorJ2(hexagon);

                if (hexagon.isHasPredecessor()) {
                    listHexagonsJ2.remove(hexagon);
                }
            }

        }

    }

    public void verifyWinPlayer2() {

        updateTree2();

        String infoPredecessor = "";
        String indiceString = "";
        Hexagon hexagonActual = null;
        String vec[] = null;
        int indice = 0;
        boolean cumple = true;
        boolean verificationWin = false;

        for (int k = 0; k < listHexagonsCabezasJ2.size(); k++) {

            cumple = true;
            indice = 0;
            hexagonActual = (Hexagon) listHexagonsCabezasJ2.get(k);
            infoPredecessor = hexagonActual.listLocationY();
            vec = infoPredecessor.split(",");
            while (cumple) {

                cumple = false;
                indiceString = indice + "";
                for (int i = 0; i < vec.length; i++) {

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

                JOptionPane.showMessageDialog(null, "Gano el azul");
                k = listHexagonsCabezasJ2.size();
            }

        }

    }

}
