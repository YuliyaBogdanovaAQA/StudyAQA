package shcool.lesson7.taskTwo;

public class AppData {
    private String[] header;
    private int[][] data;

    public AppData(String[] header) {
        this.header = header;
    }

    public AppData(int[][] data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

}