public class Bill {
    private int ID;
    private String date;
    private String time;

    public Bill(){

    }
    public Bill(int ID, String date, String time) {
        this.ID = ID;
        this.date = date;
        this.time = time;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
