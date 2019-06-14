package estructura;

import Logic.ComponentInterface;
import Logic.Hexagon;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cocau
 */
public class ObserverWinner {

    private static ObserverWinner instanceobserver = new ObserverWinner();
    private int tamanio = 0;

    private ObserverWinner() {
    }

    public static ObserverWinner getInstance() {
        return instanceobserver;
    }

    public void setTamanio(int t) {

        this.tamanio = t - 1;
    }

    public void verifyWinPlayer(int indicadorJugador) {

        updateTree(indicadorJugador);
        ArrayList<ComponentInterface> listCabezasVerification = new ArrayList<ComponentInterface>();

        if (indicadorJugador == 1) {

            listCabezasVerification = Logic.Logic.getListHexagonsCabezasJ1();
        } else {

            listCabezasVerification = Logic.Logic.getListHexagonsCabezasJ2();
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

                        if (indice == tamanio) {

                            verificationWin = true;
                            cumple = false;
                        }
                    }

                }
                indice++;
            }

            if (verificationWin) {

                if (indicadorJugador == 1) {
                    JOptionPane.showMessageDialog(null, "Gano el Jugador 1");
                } else {
                    JOptionPane.showMessageDialog(null, "Gano el Jugador 2");
                }

                k = listCabezasVerification.size();
            }

        }
    }

    private void updateTree(int indicadorJugador) {
        ArrayList<ComponentInterface> listHexagonsVerification = new ArrayList<ComponentInterface>();

        if (indicadorJugador == 1) {

            listHexagonsVerification = Logic.Logic.getListHexagonsJ1();
        } else {

            listHexagonsVerification = Logic.Logic.getListHexagonsJ2();
        }

        if (!listHexagonsVerification.isEmpty()) {

            boolean continuarBusqueda = true;
            Hexagon hexagon = null;

            while (continuarBusqueda) {

                continuarBusqueda = false;
                for (int i = 0; i < listHexagonsVerification.size(); i++) {

                    hexagon = (Hexagon) listHexagonsVerification.get(i);
                    Logic.Logic.verificationPredecessor(hexagon, indicadorJugador);

                    if (hexagon.isHasPredecessor()) {
                        listHexagonsVerification.remove(hexagon);
                        continuarBusqueda = true;
                    }
                }
            }

        }
    }

}
