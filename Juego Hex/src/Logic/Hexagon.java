package Logic;

import estructura.Punto;
import java.util.ArrayList;

/**
 *
 * @author cocau
 */
public class Hexagon implements ComponentInterface {

    private int player;
    private Punto location;
    private boolean hasPredecessor;
    private boolean hexEspeciales;
    private boolean utilizado;
    ArrayList<ComponentInterface> listHexagons;

    public Hexagon(int player, int locationX, int locationY) {

        this.player = player;
        location = new Punto(locationX, locationY);
        hasPredecessor = false;
        utilizado = false;
        hexEspeciales = false;
        listHexagons = new ArrayList<>();
    }

    public boolean isHexEspeciales() {
        return hexEspeciales;
    }

    public void setHexEspeciales(boolean hexEspeciales) {
        this.hexEspeciales = hexEspeciales;
    }

    public boolean isUtilizado() {
        return utilizado;
    }

    public void setUtilizado(boolean utilizado) {
        this.utilizado = utilizado;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public Punto getLocation() {
        return location;
    }

    public void setLocation(Punto location) {
        this.location = location;
    }

    public boolean isHasPredecessor() {
        return hasPredecessor;
    }

    public void setHasPredecessor(boolean hasPredecessor) {
        this.hasPredecessor = hasPredecessor;
    }

    public void addHexagonDescendant(ComponentInterface hexagon) {

        Hexagon hexagonVerification = (Hexagon) hexagon;

        if (!hexagonVerification.isHasPredecessor()) {
            hexagonVerification.setHasPredecessor(true);
            hexagon = hexagonVerification;
            listHexagons.add(hexagon);
        }

    }

    @Override
    public String listLocationX() {

        String locations = "";
        Hexagon hexagon = null;

        if (!isHasPredecessor()) {

            locations += getLocation().getX() + ",";
           // setUtilizado(true);
        }
        if (!listHexagons.isEmpty()) {

            for (int i = 0; i < listHexagons.size(); i++) {

              //  if (!isUtilizado()) {
                    hexagon = (Hexagon) listHexagons.get(i);
                    locations += hexagon.getLocation().getX() + ",";
                 //   hexagon.setUtilizado(true);
                    locations += listHexagons.get(i).listLocationX();
               // }

            }

        }
        return locations;
    }
    
    

    @Override
    public String listLocationY() {

        String locations = "";
        Hexagon hexagon = null;

        if (!isHasPredecessor()) {

            locations += getLocation().getY() + ",";
        }
        if (!listHexagons.isEmpty()) {

            for (int i = 0; i < listHexagons.size(); i++) {

                hexagon = (Hexagon) listHexagons.get(i);
                locations += hexagon.getLocation().getY() + ",";
                locations += listHexagons.get(i).listLocationY();
            }
        }

        return locations;
    }

    @Override
    public String toString() {
        return "Hexagon{" + "player=" + player + ", location=" + location.toString() + ", hasPredecessor=" + hasPredecessor + ", listHexagons=" + listHexagons + '}';
    }

    public String infoDescendant() {

        return "D: " + location.toString() + " , hasPredecessor=" + hasPredecessor + "\n";
    }

    public String toStringDescedant() {

        Hexagon hexagon = null;
        String info = "";

        for (int i = 0; i < listHexagons.size(); i++) {

            hexagon = (Hexagon) listHexagons.get(i);
            info += hexagon.infoDescendant();
        }

        return "P: " + location.toString() + " , hasPredecessor=" + hasPredecessor + ", List Hex:\n" + info;
    }

}
