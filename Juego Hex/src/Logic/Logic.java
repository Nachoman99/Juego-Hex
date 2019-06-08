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

    public void verificationPredecessor(ComponentInterface hegagonV, int indicadorJugador) {

        ArrayList<ComponentInterface> listCabezasVerification = new ArrayList<ComponentInterface>();
        Hexagon hexagonVerification = (Hexagon) hegagonV;
        Hexagon hexagonCabeza = null;
        boolean isCabeza = false;
        boolean isLegitimateSon = false;

        if (indicadorJugador == 1) {

            if (hexagonVerification.getLocation().getX() == 0) {
                listHexagonsCabezasJ1.add(hexagonVerification);
                isCabeza = true;
            }

            if (!listHexagonsCabezasJ1.isEmpty() && isCabeza == false) {

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
            }

            listCabezasVerification = listHexagonsCabezasJ1;
        } else {

            if (hexagonVerification.getLocation().getY() == 0) {
                listHexagonsCabezasJ2.add(hexagonVerification);
                isCabeza = true;
            }

            if (!listHexagonsCabezasJ2.isEmpty() && isCabeza == false) {

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

            }

            listCabezasVerification = listHexagonsCabezasJ2;
        }

        if (!isLegitimateSon && isCabeza == false) {

            Hexagon hexagonSon = null;

            for (int j = 0; j < listCabezasVerification.size(); j++) {

                hexagonCabeza = (Hexagon) listCabezasVerification.get(j);

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

    public void updateTree(int indicadorJugador) {

        ArrayList<ComponentInterface> listHexagonsVerification = new ArrayList<ComponentInterface>();

        if (indicadorJugador == 1) {

            listHexagonsVerification = listHexagonsJ1;
        } else {

            listHexagonsVerification = listHexagonsJ2;
        }

        if (!listHexagonsVerification.isEmpty()) {

            boolean continuarBusqueda = true;
            Hexagon hexagon = null;

            while (continuarBusqueda) {

                continuarBusqueda = false;
                for (int i = 0; i < listHexagonsVerification.size(); i++) {

                    hexagon = (Hexagon) listHexagonsVerification.get(i);
                    verificationPredecessor(hexagon, indicadorJugador);

                    if (hexagon.isHasPredecessor()) {
                        listHexagonsVerification.remove(hexagon);
                        continuarBusqueda = true;
                    }
                }
            }

        }

    }

    public void verifyWinPlayer(int indicadorJugador) {

        updateTree(indicadorJugador);

        ArrayList<ComponentInterface> listCabezasVerification = new ArrayList<ComponentInterface>();

        if (indicadorJugador == 1) {

            listCabezasVerification = listHexagonsCabezasJ1;
        } else {

            listCabezasVerification = listHexagonsCabezasJ2;
        }

        String infoPredecessor = "";
        String indiceString = "";
        Hexagon hexagonActual = null;
        String vec[] = null;
        int indice = 0;
        boolean cumple = true;
        boolean verificationWin = false;

        for (int k = 0; k < listCabezasVerification.size(); k++) {

            cumple = true;
            indice = 0;
            hexagonActual = (Hexagon) listCabezasVerification.get(k);

            if (indicadorJugador == 1) {
                infoPredecessor = hexagonActual.listLocationX();
            } else {
                infoPredecessor = hexagonActual.listLocationY();
            }

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

                if (indicadorJugador == 1) {
                    JOptionPane.showMessageDialog(null, "Gano el rojo");
                } else {
                    JOptionPane.showMessageDialog(null, "Gano el azul");
                }

                k = listCabezasVerification.size();
            }

        }

    }

    public void addHexagonTreeJ2(ComponentInterface hexagon) {

        Hexagon hex = (Hexagon) hexagon;

        if (!hex.isHasPredecessor() && hex.getLocation().getY() != 0) {
            listHexagonsJ2.add(hexagon);
        }

    }

}
