package chess;

/**
 * Created with IntelliJ IDEA.
 * User: jderinger
 * Date: 11/6/13
 * Time: 7:09 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Piece {

    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
