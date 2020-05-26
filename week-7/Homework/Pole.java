public class Pole {
    public Pole (int ID){
        this.ID= ID;
    }
    private int ID;

    public char getSymbol(){
        switch (this.ID){
            case 1:
                return 'S';
            case 2:
                return 'F';
            case 3:
                return '*';
            case 4:
                return 'V';
            case 5:
                return 'Y';
            case 6:
                return 'N';
            case 50:
            case 60:
                return 'X';
            default: return ' ';
        }
    }
    public void changeID(int newID){
        this.ID = newID;
    }

    public int getID() {
        return ID;
    }
}
